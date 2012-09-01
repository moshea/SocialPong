package com.example.socialpong;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

public class GamePlayActivity extends Activity {
	
	private static final String TAG = GamePlayActivity.class.getSimpleName();
	Paddle paddle;
	Ball ball;
	LinearLayout parent;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "Creating activity");
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play_activity);
        
        parent = (LinearLayout) findViewById(R.id.parent);
        paddle = new Paddle(this);
        ball = new Ball(this);
        
        ViewTreeObserver vto = parent.getViewTreeObserver();
        /* set up a listener to wait for the layout to be created
         * this way we can get its height
         */
        vto.addOnGlobalLayoutListener(onGlobalLayoutListener);
        /* set the touch listener for the paddle, in order to 
         * move it
         */
        parent.setOnTouchListener(touchListener);
	}
	
	private OnTouchListener touchListener = new OnTouchListener(){
		public boolean onTouch(View v, MotionEvent ev){
			Log.d(TAG, "Action Down: " + ev.getAction());
			if( (ev.getAction() == MotionEvent.ACTION_MOVE) || (ev.getAction() == MotionEvent.ACTION_DOWN) ){
				paddle.move((int)ev.getX());
			}
			return true;
		}
	};
	
	public OnGlobalLayoutListener onGlobalLayoutListener = new OnGlobalLayoutListener(){
		public void onGlobalLayout(){
			Log.d(TAG, "getMeasuredHeight: " + parent.getMeasuredHeight());
			paddle.setY(parent.getMeasuredHeight());
			ball.setFieldHeight(parent.getMeasuredHeight());
		}
	};

}
