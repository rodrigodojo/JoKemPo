package com.dojo.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity{

    ImageView jogador;
    ImageButton buttonRock, buttonScissors, buttonPaper, buttonJogador1, buttonJogador2, buttonVS;
    Animation aparecer1, aparecervs, aparecer2;
    int num=0, jogador1=0, jogador2=0;
    /*
     0 - estado inicial
     1 - pedra
     2 - papel
     3 - tesoura
     */

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
        aparecervs.setDuration(2000);
        aparecer2.setDuration(3000);

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
                quemGanhou();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void jogadaBotao(View view){

        buttonJogador1.setScaleX(-1);

        switch (view.getId()){
            case(R.id.buttonPedra):
                jogador1 = 1;
                buttonJogador1.setImageResource(R.drawable.pedra);
                buttonVS.setImageResource(R.drawable.vs);
                buttonJogador1.startAnimation(aparecer1);
                buttonVS.startAnimation(aparecervs);
                jogadaRival();
                break;
            case(R.id.buttonPapel):
                jogador1 = 2;
                buttonJogador1.setImageResource(R.drawable.papel);
                buttonVS.setImageResource(R.drawable.vs);
                buttonJogador1.startAnimation(aparecer1);
                buttonVS.startAnimation(aparecervs);
                jogadaRival();
                break;
            case(R.id.buttonTesoura):
                jogador1 = 3;
                buttonJogador1.setImageResource(R.drawable.tesoura);
                buttonVS.setImageResource(R.drawable.vs);
                buttonJogador1.startAnimation(aparecer1);
                buttonVS.startAnimation(aparecervs);
                jogadaRival();
                break;


        }
    }

    public void jogadaRival(){
        num = new Random().nextInt(3);
        switch(num){
            case 0:
                jogador2 = 1;
                buttonJogador2.setImageResource(R.drawable.pedra);
                buttonJogador2.startAnimation(aparecer2);
                break;
            case 1:
                jogador2 = 2;
                buttonJogador2.setImageResource(R.drawable.papel);
                buttonJogador2.startAnimation(aparecer2);
                break;
            case 2:
                jogador2 = 3;
                buttonJogador2.setImageResource(R.drawable.tesoura);
                buttonJogador2.startAnimation(aparecer2);
                break;

        }
    }

    public void quemGanhou(){
        if(jogador1 == jogador2){
            Toast.makeText(this,"Empate!",Toast.LENGTH_SHORT).show();
        }
        if(jogador1 == 1 && jogador2 ==3 || jogador1 == 2 && jogador2 == 1 || jogador1 == 3 && jogador2 == 2){
            Toast.makeText(this,"Jogador Ganhou",Toast.LENGTH_SHORT).show();
        }
        if(jogador1 == 3 && jogador2 ==1 || jogador1 == 1 && jogador2 == 2 || jogador1 == 2 && jogador2 == 3){
            Toast.makeText(this,"Android Ganhou",Toast.LENGTH_SHORT).show();
        }
    }
}