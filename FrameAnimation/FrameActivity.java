package com.bmpl.frameanimation;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class FrameActivity extends AppCompatActivity {

    ImageView imageView;
    AnimationDrawable animationDrawable;

    //Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        imageView = (ImageView)findViewById(R.id.imageView);

        imageView.setBackgroundResource(R.drawable.frame_animation);
        animationDrawable = (AnimationDrawable)imageView.getBackground();

        animationDrawable.start();
    }
}