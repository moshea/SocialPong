package com.example.socialpong;

import android.app.Activity;
import android.view.View;
import android.view.animation.TranslateAnimation;

public class Ball {
	
	View ball;
	int initialX;
	int initialY;
	int currentX;
	int currentY;
	int xDirection;
	int yDirection;
	int fieldHeight;
	int test;
	
	public Ball(Activity activity){
		ball = activity.findViewById(R.id.imageView2);
	}
	
	public void reset(){
		setX(getInitialX());
		setY(getInitialY());
		move();
	}
	
	public void setInitialPosition(int x, int y){
		initialX = x;
		initialY = y;
	}
	
	public void move(){
		int newX;
		int newY;
		
		newX = getX() + (getXDirection() * speed());
		newY = getY() + (getYDirection() * speed());
		
		if(newX <= 0 || newX >= getFieldHeight()){
			reverseXDirection();
		}
		
		TranslateAnimation moveTranslation = new TranslateAnimation(getX(), newX, getY(), newY);
		moveTranslation.setDuration(200);
		moveTranslation.setFillAfter(true); 
		ball.startAnimation(moveTranslation);
		
		setX(newX);
		setY(newY);
	}
	
	
	protected void reverseXDirection(){
		setXDirection(getXDirection() * -1);
	}
	
	public int speed(){
		return 1;
	}
	
	public int getInitialX(){
		return initialX;
	}
	
	public int getInitialY(){
		return initialY;
	}
	
	public void setX(int x){
		this.currentX = x;
	}
	
	public int getX(){
		return currentX;
	}
	
	public void setY(int y){
		this.currentY = y;
	}
	
	public int getY(){
		return currentY;
	}

	public int getXDirection() {
		return xDirection;
	}

	public void setXDirection(int xDirection) {
		this.xDirection = xDirection;
	}

	public int getYDirection() {
		return yDirection;
	}

	public void setYDirection(int yDirection) {
		this.yDirection = yDirection;
	}

	public int getFieldHeight() {
		return fieldHeight;
	}

	public void setFieldHeight(int fieldHeight) {
		this.fieldHeight = fieldHeight;
	}

}
