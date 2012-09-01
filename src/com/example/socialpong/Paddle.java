package com.example.socialpong;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;

public class Paddle {
	
	View paddle;
	float x = 0;
	float y = 0;
	
	private static final String TAG = Paddle.class.getSimpleName();
	
	public Paddle(Activity activity){
		this.paddle = activity.findViewById(R.id.imageView1);
	}
	
	
	public void move(int newX){
		Log.d(TAG, "getX: " + getX());
		Log.d(TAG, "newX: " + newX);
		Log.d(TAG, "getY: " + getY());
		
		/* need to take 1/2 the width of the paddle from newX, so that
		 * the paddle is centred on newX, not to the right side of it 
		 */
		newX = newX - (this.getWidth()/2);
		
		TranslateAnimation moveTranslation = new TranslateAnimation(getX(), newX, getY(), getY());
		moveTranslation.setDuration(200);
		moveTranslation.setFillAfter(true); 
		this.paddle.startAnimation(moveTranslation);
		/* set a new X after the transition has being completed so we can start from that
		 * point next time
		 */
		setX(newX);
	}
	
	public void setX(float x){
		this.x = x;
	}

	public float getX(){
		return this.x;
	}
	
	/* setting Y to the total height of the parent will place it just below
	 * the bottom line of the parent. need to bring it back up the height of the 
	 * paddle
	 */
	public void setY(float y){
		this.y = y - paddle.getMeasuredHeight();
		TranslateAnimation moveTranslation = new TranslateAnimation(getX(), getX(), getY(), getY());
		moveTranslation.setDuration(0);
		moveTranslation.setFillAfter(true); 
		this.paddle.startAnimation(moveTranslation);	
	}
	
	public float getY(){
		return this.y;
	}
	
	private int getWidth(){
		return this.paddle.getWidth();
	}
}
