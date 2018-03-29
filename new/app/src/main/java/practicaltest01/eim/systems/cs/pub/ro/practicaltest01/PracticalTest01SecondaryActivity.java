package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        TextView textView = findViewById(R.id.textView);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);



        Intent intent = getIntent();
        if (intent != null) {
            textView.setText((Integer.parseInt(intent.getStringExtra("value1"))+ Integer.parseInt(intent.getStringExtra("value2")))+ "");

        }

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_OK, null);
                finish();

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED, null);
                finish();

            }
        });
    }
}
