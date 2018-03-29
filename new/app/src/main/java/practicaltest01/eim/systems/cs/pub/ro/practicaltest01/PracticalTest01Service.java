package practicaltest01.eim.systems.cs.pub.ro.practicaltest01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.Calendar;

public class PracticalTest01Service extends Service {

    public static final String PRACTICALTEST01_EIM_SYSTEMS_CS_PUB_RO_PRACTICALTEST0_INTENT_ACTION_BROAD_CAST = "practicaltest01.eim.systems.cs.pub.ro.practicaltest0.intent.action.BroadCast";
    public static final int TIME_SLEEP = 1000;

    public PracticalTest01Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");



    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String value1 = intent.getStringExtra("value1");
        String value2 = intent.getStringExtra("value2");


        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {

                    createMesaj();
                    mySleep();



                }
            }
        };


        thread.start();

        return super.onStartCommand(intent, flags, startId);
    }


    private void createMesaj() {

        Intent broadcastIntent = new Intent(PRACTICALTEST01_EIM_SYSTEMS_CS_PUB_RO_PRACTICALTEST0_INTENT_ACTION_BROAD_CAST);
        broadcastIntent.putExtra("mesaj", "mesajul este " + Calendar.getInstance() + "");

        sendBroadcast(broadcastIntent);


    }

    private void mySleep() {

        try {
            Thread.sleep(TIME_SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
