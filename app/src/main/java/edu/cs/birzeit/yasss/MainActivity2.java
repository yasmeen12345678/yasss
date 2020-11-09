package edu.cs.birzeit.yasss;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity2 extends AppCompatActivity {
    private int seconds = 0;
    private boolean running;
    private TextView Time;
    private static final String FORMAT = "%02d:%02d:%02d";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Time=(TextView)findViewById(R.id.Time);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");

        }



        new CountDownTimer(600000, 1000) {

            public void onTick(long millisUntilFinished) {

                Time.setText(""+String.format(FORMAT,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));

            }

            public void onFinish() {
                Time.setText("done!");
            }
        }.start();
        //  runTimer();
    }

 /*   private void runTimer(){
        final TextView txtView = (TextView) findViewById(R.id.Time);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = seconds % 3600 /60;
                int snds = seconds % 60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, snds);
                txtView.setText(time);
                if(running){
                    --seconds;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }*/

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("seconds", seconds);
        bundle.putBoolean("running", running);
    }

    public void btnStartOnClick(View view) {
        running = true;
    }

    public void btnPauseOnClick(View view) {
        seconds = 0;
        running = true;
    }

    public void btnStopOnClick(View view) {
        running = true;
    }







}
