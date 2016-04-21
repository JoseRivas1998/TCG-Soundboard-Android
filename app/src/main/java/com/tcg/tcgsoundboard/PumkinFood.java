package com.tcg.tcgsoundboard;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PumkinFood extends AppCompatActivity {

    private SoundButton[] soundButtons;
    private Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pumkin_food);

        View backGround = findViewById(R.id.pumkinFoodMainLayout);
        View root = backGround.getRootView();

        root.setBackgroundColor(ContextCompat.getColor(this, R.color.pumkinBg));

        GradientDrawable gradient = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[] {
                        ContextCompat.getColor(this, R.color.pumkinBtnTop),
                        ContextCompat.getColor(this, R.color.pumkinBtnBottom)
                });
        gradient.setCornerRadius(20);

        soundButtons = new SoundButton[] {
                new SoundButton(this, R.raw.bread, R.id.bread),
                new SoundButton(this, R.raw.butter, R.id.butter),
                new SoundButton(this, R.raw.cheese, R.id.cheese),
                new SoundButton(this, R.raw.chicken, R.id.chicken),
                new SoundButton(this, R.raw.coffee, R.id.coffee),
                new SoundButton(this, R.raw.eggs, R.id.eggs),
                new SoundButton(this, R.raw.fish, R.id.fish),
                new SoundButton(this, R.raw.french_fries, R.id.french_fries),
                new SoundButton(this, R.raw.hamburger, R.id.hamburger),
                new SoundButton(this, R.raw.hot_dog, R.id.hot_dog),
                new SoundButton(this, R.raw.jam, R.id.jam),
                new SoundButton(this, R.raw.juice, R.id.juice),
                new SoundButton(this, R.raw.noodles, R.id.noodles),
                new SoundButton(this, R.raw.pepper, R.id.pepper),
                new SoundButton(this, R.raw.pizza, R.id.pizza),
                new SoundButton(this, R.raw.rice, R.id.rice),
                new SoundButton(this, R.raw.salt, R.id.salt),
                new SoundButton(this, R.raw.sandwich, R.id.sandwich),
                new SoundButton(this, R.raw.soda, R.id.soda),
                new SoundButton(this, R.raw.water, R.id.water)
        };

        buttons = new Button[soundButtons.length];
        for(int i = 0; i < soundButtons.length; i++) {
            buttons[i] = soundButtons[i].generateButton(this);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                buttons[i].setBackground(gradient);
            }
        }

        Button home = (Button) findViewById(R.id.pumkinHomeFromFood);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Pumkin.class);
                startActivity(i);
            }
        });
        Button playAll = (Button) this.findViewById(R.id.pumkinFoodPlayAll);
        playAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(SoundButton soundButton : soundButtons) {
                    soundButton.play();
                }
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            home.setBackground(gradient);
            playAll.setBackground(gradient);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for(SoundButton soundButton : soundButtons) {
            soundButton.dispose();
        }
    }

}
