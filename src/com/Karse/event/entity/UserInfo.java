package com.Karse.event.entity;
/**
 * �û���Ϣ
 * @author Karse
 *
 */
public class UserInfo {
	private int id;  //���
	private String name;   //�û�����
	private int age;   //����
	private int sex;
	private double account;  //�˻����
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getAccount() {
		return account;
	}
	public void setAccount(double account) {
		this.account = account;
	}
}
