package com.example.fitstopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.os.health.SystemHealthManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {
    Button btnstart,btnstop;
    Animation roundingalone;
    ImageView icanchor;
    Chronometer timerHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart=findViewById(R.id.btnstart);
        btnstop=findViewById(R.id.btnstop);
        timerHere=findViewById(R.id.timerHere);
        icanchor=findViewById(R.id.icanchor);

        btnstop.setAlpha(0);

        roundingalone= AnimationUtils.loadAnimation(this,R.anim.roundingalone);

        btnstop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                icanchor.startAnimation(roundingalone);

            }
        });

        btnstart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                icanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();


                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();
            }
        });
    }
}
