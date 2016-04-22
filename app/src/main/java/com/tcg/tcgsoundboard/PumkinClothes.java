package com.tcg.tcgsoundboard;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PumkinClothes extends AppCompatActivity {

    private SoundButton[] soundButtons;
    private Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pumkin_clothes);

        View backGround = findViewById(R.id.pumkinClothesMainLayout);
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
                new SoundButton(this, R.raw.dress, R.id.dress),
                new SoundButton(this, R.raw.gloves, R.id.gloves),
                new SoundButton(this, R.raw.jacket, R.id.jacket),
                new SoundButton(this, R.raw.pants, R.id.pants),
                new SoundButton(this, R.raw.perfect_for_drying_these_clothes, R.id.perfect_for_drying_these_clothes),
                new SoundButton(this, R.raw.sandles, R.id.sandles),
                new SoundButton(this, R.raw.scarf, R.id.scarf),
                new SoundButton(this, R.raw.shoes, R.id.shoes),
                new SoundButton(this, R.raw.shorts, R.id.shorts),
                new SoundButton(this, R.raw.skirt, R.id.skirt),
                new SoundButton(this, R.raw.sneakers, R.id.sneakers),
                new SoundButton(this, R.raw.socks, R.id.socks),
                new SoundButton(this, R.raw.sweater, R.id.sweater),
                new SoundButton(this, R.raw.t_shirt, R.id.t_shirt),
                new SoundButton(this, R.raw.what_a_windy_day, R.id.what_a_windy_day)
        };

        buttons = new Button[soundButtons.length];
        for(int i = 0; i < soundButtons.length; i++) {
            buttons[i] = soundButtons[i].generateButton(this);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                buttons[i].setBackground(gradient);
            }
        }

        Button home = (Button) findViewById(R.id.pumkinHomeFromClothes);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(SoundButton soundButton : soundButtons) {
                    soundButton.dispose();
                }
                Intent i = new Intent(getApplicationContext(), Pumkin.class);
                startActivity(i);
            }
        });
        Button playAll = (Button) findViewById(R.id.playAllPumkinClothes);
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
}
