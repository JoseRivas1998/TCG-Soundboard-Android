package com.tcg.tcgsoundboard;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pumkin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pumkin);

        View backGround = findViewById(R.id.pumkinHomeMainLayout);
        View root = backGround.getRootView();

        root.setBackgroundColor(ContextCompat.getColor(this, R.color.pumkinBg));

        Button home = (Button) findViewById(R.id.pumkinSoundHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        Button food = (Button) findViewById(R.id.foodFromPumkinHome);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PumkinFood.class);
                startActivity(i);
            }
        });

        GradientDrawable gradient = new GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            new int[] {
                ContextCompat.getColor(this, R.color.pumkinBtnTop),
                ContextCompat.getColor(this, R.color.pumkinBtnBottom)
            });
        gradient.setCornerRadius(20);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            home.setBackground(gradient);
            food.setBackground(gradient);
        }
    }
}
