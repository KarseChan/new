package com.Karse.event.entity;

import java.util.ArrayList;
import java.util.List;
/**
 * �û�ʵ��
 * @author Karse
 *
 */
public class User {
	private int id;  //���
	private String name;  //�˺���
	private String password; //����
	private int role; //Ȩ��
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	


}