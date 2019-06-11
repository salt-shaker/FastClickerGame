package com.fastclickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_click1, btn_click2, btn_start;
    TextView tv_counter, tv_points;
    int points = 0;
    int counter;
    int countDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_click1 = (Button) findViewById(R.id.btn_click1);
        btn_click2 = (Button) findViewById(R.id.btn_click2);
        btn_start = (Button) findViewById(R.id.btn_start);

        tv_counter = (TextView) findViewById(R.id.tv_counter);
        tv_points = (TextView) findViewById(R.id.tv_points);

        btn_click1.setEnabled(false);
        btn_click2.setEnabled(false);

        btn_click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points++;
                tv_points.setText("Points: " + points);
                btn_click1.setEnabled(false);
                btn_click2.setEnabled(true);
                counter++;
            }
        });

        btn_click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points++;
                tv_points.setText("Points: " + points);
                btn_click1.setEnabled(true);
                btn_click2.setEnabled(false);
                counter++;
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDown = 10;
                counter = 0;
                points = 0;

                tv_points.setText("Points: " + points);

                btn_start.setEnabled(false);
                btn_click1.setEnabled(true);
                btn_click2.setEnabled(false);
                timer.start();

            }
        });



    }

    CountDownTimer timer = new CountDownTimer(10000, 1000) {
        @Override
        public void onTick(long l) {
            tv_counter.setText("Counter: " + countDown);
            countDown--;
        }

        @Override
        public void onFinish() {
            btn_start.setEnabled(true);
            btn_click1.setEnabled(false);
            btn_click2.setEnabled(false);
        }
    };

}
