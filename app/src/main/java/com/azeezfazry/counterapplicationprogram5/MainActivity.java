package com.azeezfazry.counterapplicationprogram5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView, textViewTitle;
    Button startButton, stopButton;
    Handler handler = new Handler();
    int i=0;
    boolean isStop = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tvDisplay);
        textViewTitle = findViewById(R.id.tvTitle);
        startButton = findViewById(R.id.buStart);
        stopButton = findViewById(R.id.buStop);
    }

    public void buStartAction(View view) {
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        handler.postDelayed(updateTimerThread,0);
    }

    public void buStopAction(View view) {
        isStop = true;
        stopButton.setEnabled(false);
        startButton.setEnabled(true);
        handler.removeCallbacks(updateTimerThread);
    }

    public Runnable updateTimerThread = new Runnable() {
        @Override
        public void run() {
            if(isStop){ i=0; isStop=false; }
            textView.setText("" + i);
            handler.postDelayed(this, 1000);
            i++;
        }
    };
}