package com.Karse.event.entity;

import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.xml.crypto.Data;

public class Match {
	//���
	private int id;  
	//ս��1
	private String team1;  
	//ս��2
	private String team2; 
	//����ʱ��
	private String time; 
	//�����۸�
	private int price;  
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
