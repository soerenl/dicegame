package com.example.dicegame;


public class Player {
	

	
	int casts=0;
	int points=0;
	String name;
	boolean firstRun;

	public Player() {
		// TODO Auto-generated constructor stub
		firstRun = true;
	}
	
	public int getCasts() {
		return casts;
	}
	public void setCasts(int casts) {
		this.casts+= casts;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		if(firstRun){
			this.points+= points-1;
		} else  {
			if(points==7){
				this.points+= 1;
			} else {
				this.points+= points;
			}	
		}
		firstRun=false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
