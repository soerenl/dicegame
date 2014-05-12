package com.example.dicegame;


import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {

	private Random rnd = new Random();
	// value+1 is real dice result
	private int value;
	private DiceRollHandler handler;
	private Player player;
	private TextView TvScore;
	private TextView TvCasts;
	private ImageButton IbDice;
	private boolean handlerBusy = true;
	
	public void setTvCasts() {
		TvCasts.setText("Casts: "+player.getCasts());
	}
	public void setTvScore() {
		TvScore.setText("Score: "+player.getPoints());
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TvScore = (TextView) findViewById(R.id.Tv_score);
		TvCasts = (TextView) findViewById(R.id.Tv_casts);
		player = new Player();
		addListenerOnIbDice();
		handler = new DiceRollHandler();
	}
	
	public void addListenerOnIbDice() {
		IbDice = (ImageButton) findViewById(R.id.dice);
		IbDice.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				handlerBusy=true;
				handler.sendMessageDelayed(Message.obtain(handler, 0, 7), 200);
				while (handlerBusy){
					System.out.println("busy");
				}
				
				  player.setCasts(1);
				  player.setPoints(value+1);
				  setTvCasts();
				  setTvScore();
				
			}
		});
	}
	
	

//	public void rollDie(View view) {
//		  // Setup the animation.
//		  Animation shake = AnimationUtils.loadAnimation(view.getContext(),
//		    R.anim.shake);
//		  View dice = findViewById(R.id.dice);
//		  dice.setAnimation(shake);
//		 
//		  shake.start();
//		  handler.sendMessageDelayed(Message.obtain(handler, 0, 7), 200);
//	}
	
	class DiceRollHandler extends Handler {
		 /**
		  * @see android.os.Handler#handleMessage(android.os.Message)
		  */
		 public void handleMessage(Message msg) {
		  value = rnd.nextInt(6);
		  ImageView dice = (ImageView) MainActivity.this
		    .findViewById(R.id.dice);
		  dice.setImageLevel(value);
		 
		  // If there are still rolls available, roll another time.
		  Integer rollsLeft = (Integer) msg.obj;
		  if (rollsLeft > 0)
		   MainActivity.this.handler.sendMessageDelayed(Message.obtain(
		     MainActivity.this.handler, 0, --rollsLeft), 200);
		  
		  handlerBusy=false;
		 }
		}



}
