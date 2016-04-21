package com.tcg.tcgsoundboard;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PumkinFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pumkin_food);

        View backGround = findViewById(R.id.pumkinFoodMainLayout);
        View root = backGround.getRootView();

        root.setBackgroundColor(ContextCompat.getColor(this, R.color.pumkinBg));

    }
}
