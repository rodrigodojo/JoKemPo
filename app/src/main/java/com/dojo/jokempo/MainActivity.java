package com.dojo.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{

    ImageView jogador;
    ImageButton buttonRock, buttonScissors, buttonPaper, buttonJogador1, buttonJogador2, buttonVS;
    Animation aparecer1, aparecervs, aparecer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jogador = findViewById(R.id.jokempostiker);
        buttonRock = findViewById(R.id.buttonPedra);
        buttonScissors = findViewById(R.id.buttonTesoura);
        buttonPaper = findViewById(R.id.buttonPapel);
        buttonJogador1 = findViewById(R.id.buttonJogador1);
        buttonJogador2 = findViewById(R.id.buttonJogador2);
        buttonVS = findViewById(R.id.buttonVS);
        aparecer1 = new AlphaAnimation(0,1);
        aparecervs = new AlphaAnimation(0,1);
        aparecer2 = new AlphaAnimation(0,1);

        aparecer1.setDuration(500);
        aparecervs.setDuration(5000);

        aparecer1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                buttonJogador1.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                buttonJogador1.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        aparecervs.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                buttonVS.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                buttonVS.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        aparecer2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                buttonJogador2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                buttonJogador2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void jogadaBotao(View view){

        switch (view.getId()){
            case(R.id.buttonPedra):
                buttonJogador1.setImageResource(R.drawable.pedra);
                buttonVS.setImageResource(R.drawable.vs);
                buttonJogador1.startAnimation(aparecer1);
                buttonVS.startAnimation(aparecervs);
                break;
            case(R.id.buttonPapel):
                buttonJogador1.setImageResource(R.drawable.papel);
                buttonVS.setImageResource(R.drawable.vs);
                buttonJogador1.startAnimation(aparecer1);
                buttonVS.startAnimation(aparecervs);
                break;
            case(R.id.buttonTesoura):
                buttonJogador1.setImageResource(R.drawable.tesoura);
                buttonVS.setImageResource(R.drawable.vs);
                buttonJogador1.startAnimation(aparecer1);
                buttonVS.startAnimation(aparecervs);
                break;

        }
    }
}