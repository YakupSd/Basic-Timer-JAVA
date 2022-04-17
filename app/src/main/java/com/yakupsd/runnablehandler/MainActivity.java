package com.yakupsd.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int number;
    Runnable runnable;
    Handler handler;
    Button button;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.timerTxt);
        button = findViewById(R.id.startBtn);
        number = 0;
        button2 = findViewById(R.id.stopBtn);

    }

    public void start(View view){


        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: " + number);
                number++;
                textView.setText("Time:" + number);
                handler.postDelayed(runnable,500);
            }
        };

        handler.post(runnable);
        button.setEnabled(false);
        button2.setEnabled(true);


            /*
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"Hata Mesajı : "+e,Toast.LENGTH_LONG).show();
            } */



    }
    public void stop(View view){
        button.setEnabled(true);
        button2.setEnabled(false);
        handler.removeCallbacks(runnable);
        number=number;
        textView.setText("Last Number : "+ number);


    }
    public void reset(View view){
        button.setEnabled(true);
        button2.setEnabled(true);
        number=0;
        textView.setText("Time: "+number);
    }
}