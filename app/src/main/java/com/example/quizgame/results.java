package com.example.quizgame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class results extends AppCompatActivity {
    MyReceiver brodcastreceiver = new MyReceiver();
    private static final String TAG = "game";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        final Button startnewBtn = findViewById(R.id.startnewquizbtn);
        final Button quit = findViewById(R.id.quit);
        final Button sharebtn = findViewById(R.id.startnewquizbtn);
        final TextView correctanswer=findViewById(R.id.correctanswers);
        final TextView incorrectanswer=findViewById(R.id.incorrectanswers);

        final int getcorrectanswers =getIntent().getIntExtra("correct",0);
        final int getincorrectanswers =getIntent().getIntExtra("incorrect",0);

        correctanswer.setText("Amazing you had "+getcorrectanswers +" correct");
        //incorrectanswer.setText(String.valueOf(getincorrectanswers));
        incorrectanswer.setText("You also got "+getincorrectanswers +" wrong");

        startnewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(results.this,game.class));
                finish();
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                System.exit(0);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter =new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        this.registerReceiver(brodcastreceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(brodcastreceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finishAffinity();
        System.exit(0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity( new Intent(results.this,game.class));
        finish();
    }
}