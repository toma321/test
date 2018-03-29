package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends AppCompatActivity {


    public static final String VALUE1 = "value";
    public static final String VALUE2 = "VALUE2";
    public static final int REQUEST_CODE = 123;

    Button button2;
    Button button3;
    Button button1;

    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);

        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button1 = findViewById(R.id.button);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button2:
                        editText.setText((Integer.parseInt(editText.getText().toString())+ 1)+ "");
                        break;


                    case R.id.button3:
                        editText2.setText((Integer.parseInt(editText2.getText().toString())+ 1)+ "");
                        break;



                }
            }
        };


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("practicaltest01.eim.systems.cs.pub.ro.practicaltest01.intent.action.SecondActivity");
                intent.putExtra("value1", editText.getText().toString());
                intent.putExtra("value2", editText2.getText().toString());
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(VALUE1)) {
                editText.setText(savedInstanceState.getString(VALUE1));
            }

            if (savedInstanceState.containsKey(VALUE2)) {
                editText2.setText(savedInstanceState.getString(VALUE2));
            }


        }

        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);




        Intent intentService = new Intent(this, PracticalTest01Service.class);
        intentService.putExtra("value1", editText.getText().toString());
        intentService.putExtra("value2", editText2.getText().toString());

        startService(intentService);


        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.e("cacao", intent.getStringExtra("mesaj"));

            }
        };


        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PracticalTest01Service.PRACTICALTEST01_EIM_SYSTEMS_CS_PUB_RO_PRACTICALTEST0_INTENT_ACTION_BROAD_CAST);
//        intentFilter.addAction();
//        intentFilter.addAction();


        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {

        Intent intentService = new Intent(this, PracticalTest01Service.class);
        intentService.putExtra("value1", editText.getText().toString());
        intentService.putExtra("value2", editText2.getText().toString());

        stopService(intentService);

        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CODE:
                Toast.makeText(this, resultCode+ "", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString(VALUE1, editText.getText().toString());
        outState.putString(VALUE2, editText2.getText().toString());

        super.onSaveInstanceState(outState);
    }
}
