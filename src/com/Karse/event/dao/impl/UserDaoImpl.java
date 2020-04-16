package com.Karse.event.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.Karse.event.dao.UserDao;
import com.Karse.event.entity.User;
import com.Karse.event.util.isEmpty;
import com.jgoodies.forms.factories.Borders.EmptyBorder;
/**
 * ��װjdbc�û��˺���Ϣ��ɾ�Ĳ����ݿ�ķ���
 * @author Karse
 *
 */


public class UserDaoImpl implements UserDao{
	//ע���������ڹ��췽�����Ϊֻ��ִ��һ��
	public UserDaoImpl(){
		//ע������

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	
	public Connection getConnection() throws SQLException{
		/**
		 * �õ����ӽӿڵķ���
		 */
		//��Դ������
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String password = bundle.getString("password");
		
		Connection conn = DriverManager.getConnection(url,user,password);
		return conn;
	}
	
	
	/**
	 * ��½����
	 * @param Username �û���
	 * @param password ����
	 */

	
	@Override
	public User selectUserByPassword(String name, String password) {
		User resultUser = null; //���ڷ���
		String sql = "select * from t_user where name=? and password=?";
		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			//�ж��Ƿ���������
			if(rs.next()){
				resultUser = new User();
				resultUser.setId(rs.getInt("id"));
				resultUser.setName(rs.getString("name"));;
				resultUser.setPassword(rs.getString("password"));;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultUser;
	}
	
	
	public boolean adminNameEmpty(String name){
		boolean flag = true;  //��չ������
		String sql = "select * from t_admin where name=? ";
		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			//�ж����ݿ��Ƿ��и��˺�
			if(rs.next()){
				flag = true; 				
			}
			else{
				//����false
				flag = false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
	
	/**
	 * ע���˺Ų�ѯ�Ƿ���ڸ��û�
	 * @param name
	 * @return
	 */
	public boolean isNameEmpty(String name) {
		/**
		 * ��ѯt_user�����Ƿ���ڸ��û���
		 */
		boolean flag = true; 
		String sql = "select * from t_user where name=? ";
		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			//�ж����ݿ��Ƿ��и��˺�
			if(rs.next()){
				flag = true;
			}else{
				flag = false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
		
	}
	
	
	public boolean isPasswordEmpty(String password) {
		/**
		 * ��ѯt_user�����Ƿ���ڸ�����
		 */
		boolean flag = true;  //��չ������
		String sql = "select * from t_user where password=? ";
		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, password);
			ResultSet rs = ps.executeQuery();
			//�ж����ݿ��Ƿ��и��˺�
			if(rs.next()){
				flag = true; 				
			}
			else{
				//����false
				flag = false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
		
	}
	
	public boolean addUser(String name,String password){
		/**
		 * ��������Ϣ�������ݿ�
		 */
		boolean flag = true;
		String sql = "insert into t_user values(null,?,?)";	
		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {

			//��������
			ps.setString(1, name);
			ps.setString(2,password);
			int count = ps.executeUpdate();
			if(count == 1){
				flag = true;
			}else{
				flag = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;			
	}
	
	
//	public int getTotal(){
//		/**
//		 * �õ���������
//		 */
//		int total = 0;
//		String sql = "select * from t_user";
//		try(Connection conn = getConnection();PreparedStatement ps = conn.prepareStatement(sql)) {
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()){
//				total = rs.getInt("id");
//			}
//		} catch (SQLException e) {
//			// TODO: handle exception
//		}
//		return total;
//	}
//	
//	
//	public User get(int id){
//		/**
//		 * ����id�����ض���
//		 */
//		User u = null;
//		String sql = "select * from t_user where id ="+id;	
//		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
//			//�������ݿ����
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()){
//				//ʵ��������
//				u = new User();	 
//				String name = rs.getString("name");
//				int age = rs.getInt("age");
//				String sex = rs.getString("sex");
//				//�����ݿ��ֵ�������������
//				u.name = name;
//				u.age = age;
//				u.sex = sex;
//				
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return u;					
//	}
//	

//	
//	public void delete(User u){
//		/**
//		 * �����User�����Ӧ������ɾ����
//		 */
//		String sql = "delete from t_user where id = "+u.id;
//		try (Connection conn = getConnection() ;Statement stat = conn.createStatement()){
//			
//			//ִ��sql���
//			stat.execute(sql);			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//	}
//	
//	public  void update(User u){
//		/**
//		 * ��������User����
//		 */
//		//��Դ������
//		String sql = "update t_user set name=?,age=?,sex=? where id=?";	
//		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
//			//��������
//			ps.setString(1, u.name);
//			ps.setInt(2, u.age);
//			ps.setString(3, u.sex);
//			ps.setInt(4, u.id);
//			//ִ��sql���
//			ps.execute();
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	
//	public List<User> list(){
//		/**
//		 * �����е�user���ݲ�ѯ������ת��ΪUser����󣬷���һ�������з���
//		 */
//		
//		//��չ������
//		List<User> users = null;
//		String sql = "select * from t_user";
//		
//		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
//			
//			User u = new User();
//			users = new ArrayList<User>();
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()){
//				//ת��Ϊ����
////				int id = rs.getInt("id");
////				String name = rs.getString("name");
////				int age = rs.getInt("age");
////				String sex =  rs.getString("sex");
////				u. id = id;				
////				u.name = name;
////				u.age = age;
////				u.sex = sex;
////				//������Ž�����
//				System.out.println(1);
//				users.add(u);
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return users;
//	}

}
