package com.example.rolldice;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imgdice1 = findViewById(R.id.dice1);
        ImageView imgdice2 = findViewById(R.id.dice2);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);
        int imageView[]={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
        Button button= findViewById(R.id.rollButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random randomnumber = new Random();
                int generatedNumber1 = randomnumber.nextInt(6);
                int generatedNumber2 = randomnumber.nextInt(6);
                YoYo.with(Techniques.Wobble)
                        .duration(400)
                        .repeat(0)
                        .playOn(findViewById(R.id.dice1));
                YoYo.with(Techniques.Wobble)
                        .duration(400)
                        .repeat(0)
                        .playOn(findViewById(R.id.dice2));
                mp.start();
                imgdice1.setImageResource(imageView[generatedNumber1]);
                imgdice2.setImageResource(imageView[generatedNumber2]);

            }
        });

    }
}