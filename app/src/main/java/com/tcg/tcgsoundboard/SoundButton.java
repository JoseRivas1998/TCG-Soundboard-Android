package com.tcg.tcgsoundboard;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.net.URI;

/**
 * Created by JoseR on 4/15/2016.
 */
public class SoundButton {

    private Context context;
    private int resId;
    private int bId;
    private MediaPlayer mp;

    public SoundButton(Context context, int resId, int bId) {
        this.context = context;
        this.resId = resId;
        this.bId = bId;
        mp = MediaPlayer.create(context, resId);
    }

    public Button generateButton(AppCompatActivity activity) {
        Button b = (Button) activity.findViewById(bId);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });
        return b;
    }

    public void play() {
        mp.seekTo(0);
        mp.start();
    }

    public void dispose() {
        mp.release();
    }

}
