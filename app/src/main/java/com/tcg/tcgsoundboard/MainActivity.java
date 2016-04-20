package com.tcg.tcgsoundboard;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private SoundButton[] soundButtons;
    private Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundButtons = new SoundButton[] {
            new SoundButton(this, R.raw.tru, R.id.tru),
            new SoundButton(this, R.raw.gimme_dat_pussy, R.id.gimme_dat_pussy),
            new SoundButton(this, R.raw.lemon, R.id.im_a_lemon),
            new SoundButton(this, R.raw.normies, R.id.fucking_normies),
            new SoundButton(this, R.raw.allahu_akbar, R.id.allahu_akbar),
            new SoundButton(this, R.raw.nobody_gives_a_shit, R.id.nobody_gives_a_shit),
            new SoundButton(this, R.raw.now_thats_edgy_as_fuck, R.id.edgy_as_fuck),
            new SoundButton(this, R.raw.fuck_you, R.id.fuck_you),
            new SoundButton(this, R.raw.khaled_woo, R.id.khaled_woo),
            new SoundButton(this, R.raw.bradberry, R.id.bradberry),
            new SoundButton(this, R.raw.you_mad_bro, R.id.you_mad_bro),
            new SoundButton(this, R.raw.prettygood, R.id.pretty_good),
            new SoundButton(this, R.raw.aint_having_that_shit, R.id.aint_having_that_shit),
            new SoundButton(this, R.raw.am_i_dead_yet, R.id.am_i_dead_yet),
            new SoundButton(this, R.raw.spirits_be_gone, R.id.spirits_be_gone),
            new SoundButton(this, R.raw.schindlers_list_hd, R.id.schindlers_list),
            new SoundButton(this, R.raw.nineteenten_scary, R.id.nineteenten_times),
            new SoundButton(this, R.raw.not_even_once, R.id.not_even_once),
            new SoundButton(this, R.raw.here_comes_the_clarke, R.id.here_comes_the_clarke),
            new SoundButton(this, R.raw.wednesday_1, R.id.wednesday_1),
            new SoundButton(this, R.raw.wednesday_2, R.id.wednesday_2)
        };
        buttons = new Button[soundButtons.length];
        for(int i = 0; i < soundButtons.length; i++) {
            buttons[i] = soundButtons[i].generateButton(this);
        }

        Button playAll = (Button) this.findViewById(R.id.play_all);
        playAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(SoundButton soundButton : soundButtons) {
                    soundButton.play();
                }
            }
        });

        Button pumkin = (Button) this.findViewById(R.id.pumkinFromMain);
        pumkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Pumkin.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for(SoundButton soundButton : soundButtons) {
            soundButton.dispose();
        }
    }
}
