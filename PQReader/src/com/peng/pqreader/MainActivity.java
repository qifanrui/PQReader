package com.peng.pqreader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final View view=View.inflate(this, R.layout.activity_main, null);
		setContentView(view);
	
		
		AlphaAnimation animation=new AlphaAnimation(0.3f, 1.0f);
		animation.setDuration(5000);
		view.startAnimation(animation);
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				redirectTo();
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				
			}
		});
		
	}

	
	private void redirectTo() {
		super.onResume();
		Intent intent=new Intent(this, Bookrack.class);
		startActivity(intent);
		MainActivity.this.finish();
	}
}
