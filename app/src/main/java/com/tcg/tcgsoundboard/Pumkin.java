package com.tcg.tcgsoundboard;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Pumkin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pumkin);

        View backGround = findViewById(R.id.mainLayout);
        View root = backGround.getRootView();

        root.setBackgroundColor(Color.parseColor("#ff811e"));

    }
}
