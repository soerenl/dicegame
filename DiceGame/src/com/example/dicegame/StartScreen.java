package com.example.dicegame;

import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartScreen extends Activity {
	
	private Button btnStart;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_screen);
		addListenerOnbtnStart();
		
		MediaPlayer mp = MediaPlayer.create(this, R.raw.pig);
		try {
			mp.prepare();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mp.start();
		
	}
	
	private void addListenerOnbtnStart() {
		
		final Context context = this;
		btnStart = (Button) findViewById(R.id.btnStart);
		btnStart.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, MainActivity.class);
				startActivity(intent);
			}
		});

	}

}
