package com.Karse.event.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Karse.event.util.isEmpty;
import com.Karse.event.controller.UserController;
import com.Karse.event.dao.impl.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class RegisterFrm extends JFrame {

	private RegisterFrm frame;
	private JPanel contentPane;
	private JTextField textField; //�û�������
	private JPasswordField passwordField;  //��������
	private JPasswordField passwordField_1;  //ȷ������
	private JButton button;
	private JButton button_1;
	private JLabel label_4;
	
	private static UserController userController = new UserController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrm frame = new RegisterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void IntoRegisterFrm(){
		/**
		 * ��¼������ô˷�������ע�����
		 * ʵ��ע����������ʹ������ӻ�
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrm frame = new RegisterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public RegisterFrm() {
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 871, 509);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u7528\u6237\u6CE8\u518C");
		label.setIcon(new ImageIcon("C:\\Users\\Karse\\Pictures\\Camera Roll\\\u6CE8\u518C2.png"));
		label.setFont(new Font("΢���ź�", Font.BOLD, 30));
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setIcon(new ImageIcon("C:\\Users\\Karse\\Pictures\\Camera Roll\\\u7528\u6237\u540D.png"));
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u5BC6 \u7801\uFF1A");
		label_2.setIcon(new ImageIcon("C:\\Users\\Karse\\Pictures\\Camera Roll\\\u5BC6\u7801.png"));
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_3.setIcon(new ImageIcon("C:\\Users\\Karse\\Pictures\\Camera Roll\\\u5BC6\u7801.png"));
		label_3.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		passwordField_1 = new JPasswordField();
		
		//���ذ�ť
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//���ؼ���
				backActionPerformed(e);
			}
		});
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ע�����
				registerActionPerformed(e);
			}
		});
		
		
		//����
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(310)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(201)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1)
										.addComponent(label_3))
									.addGap(37)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordField_1, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
										.addComponent(passwordField, 191, 191, 191)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))))))
					.addGap(304))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(315)
					.addComponent(btnNewButton)
					.addGap(66)
					.addComponent(button_1)
					.addContainerGap(286, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addComponent(label)
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}



	protected void backActionPerformed(ActionEvent e) {
		// ���ش����¼�
		//����ע�����ʾ��¼��
//		this.frame.dispose();
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setVisible(true);
		
		
	}

	protected void registerActionPerformed(ActionEvent e) {
		// ע�ᴦ���¼�
		String userName = this.textField.getText();
		String password = this.passwordField.getText();
		String isRight = this.passwordField_1.getText();
		 if(isEmpty.isEmpty(userName)){
			//�û�������Ϊ��
			JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
			return;  //����
		}else if(isEmpty.isEmpty(password)){
			//��������Ϊ��
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
			return;	
		}else if(isEmpty.isEmpty(isRight)){
			//ȷ����������Ϊ��
			JOptionPane.showMessageDialog(null, "ȷ�����벻��Ϊ��");
			return;	
		}else if(!password.equals(isRight)){
			//���벻��ȷ
			JOptionPane.showMessageDialog(null, "������������벻һ�£�");
			return;  
		}else if(userController.register(userName)){
			//�û�������
			JOptionPane.showMessageDialog(null, "���û����Ѵ��ڣ�");
			return;  
		}else if(userController.successRegister(userName, password)){	
			JOptionPane.showMessageDialog(null, "ע��ɹ���");

		}
	}

}
