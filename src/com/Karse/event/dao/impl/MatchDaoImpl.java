package com.Karse.event.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.Karse.event.dao.MatchDao;
import com.Karse.event.entity.Match;
import com.mysql.jdbc.StringUtils;

/**
 * ��װ�����½�����ɾ�Ĳ�ķ���
 * @author Karse
 *
 */

public class MatchDaoImpl implements MatchDao{
	//ע���������ڹ��췽�����Ϊֻ��ִ��һ��
	public MatchDaoImpl(){
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
	
	public boolean addMatch(String team1,String team2,String time,String price){
		/**
		 * ��������Ϣ�������ݿ�
		 */
		boolean flag = true;
		String sql = "insert into t_match values(null,?,?,?,?)";	
		try(Connection conn = getConnection() ;PreparedStatement ps = conn.prepareStatement(sql)) {
			//��������
			ps.setString(1, team1);
			ps.setString(2, team2);
			ps.setString(3, time);
			ps.setString(4, price);
			//ִ��sql���
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
	
	
//	public ResultSet list(Connection conn,Match match)throws Exception{
//		/**
//		 * ģ����ѯ����ѯ���ֲ�ѯʱ�䶼�ܵõ�
//		 */
//		StringBuffer sb = new StringBuffer("salect * from t_match");
//		if(com.Karse.event.util.isEmpty(match.getName()))){
//			sb.append(" and ")
//		}
//		
//	}
}
