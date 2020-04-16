package com.Karse.event.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Karse.event.controller.MatchController;
import com.Karse.event.dao.MatchDao;
import com.Karse.event.util.isEmpty;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class MatchAdd extends JFrame {

	private JPanel contentPane;
	private JTextField team1; //ս��1
	private JTextField team2; //ս��2
	private JTextField matchTime;  //����ʱ��
	private JTextField matchPrice;
	
	private static MatchController matchController = new MatchController();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchAdd frame = new MatchAdd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void IntoMatchAdd(){
		/**
		 * ����������Ӵ���
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchAdd frame = new MatchAdd();
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
	public MatchAdd() {
		setTitle("\u8D5B\u4E8B\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8D5B\u4E8B\u540D\u79F0\uFF1A");
		
		team1 = new JTextField();
		team1.setColumns(10);
		
		JLabel label = new JLabel("\u8D5B\u4E8B\u65F6\u95F4\uFF1A");
		
		JLabel label_1 = new JLabel("\u8D5B\u4E8B\u4EF7\u683C\uFF1A");
		
		matchTime = new JTextField();
		matchTime.setColumns(10);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//������������������ƺ�ʱ����������в������ݿ�Ĳ���
				addActionPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�������������Ϣ����
				resetValueActionPerformed(e);
			}
		});
		
		team2 = new JTextField();
		team2.setColumns(10);
		
		JLabel lblVs = new JLabel("vs");
		
		matchPrice = new JTextField();
		matchPrice.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(125)
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(team1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblVs)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(team2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(180)
							.addComponent(button)
							.addGap(55)
							.addComponent(button_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(123)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1)
									.addGap(18)
									.addComponent(matchPrice, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addGap(18)
									.addComponent(matchTime, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(team1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVs)
						.addComponent(team2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(matchTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(matchPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(69)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(button))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(button_1)))
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void resetValueActionPerformed(ActionEvent e) {
		// ���������¼�
		team1.setText("");
		team2.setText("");
		matchTime.setText("");
		matchPrice.setText("");
		
	}

	protected void addActionPerformed(ActionEvent e) {
		// ������������¼�
		String team1 = this.team1.getText();
		String team2 = this.team2.getText();
		String matchTime = this.matchTime.getText();
		String matchPrice = this.matchPrice.getText();
		 if(isEmpty.isEmpty(team1) || isEmpty.isEmpty(team2)){
			//����ս������Ϊ��
			JOptionPane.showMessageDialog(null, "�������Ʋ���Ϊ��");
			return;  //����
		}else if(isEmpty.isEmpty(matchTime)){
			//����ʱ��Ϊ��
			JOptionPane.showMessageDialog(null, "����ʱ�䲻��Ϊ��");
			return;	
		}else if(isEmpty.isEmpty(matchPrice)){
			//���¼۸�����Ϊ��
			JOptionPane.showMessageDialog(null, "���¼۸���Ϊ��");
			return;	
		}else if(matchController.addMatch(team1, team2, matchTime, matchPrice)){
			JOptionPane.showMessageDialog(null, "������ӳɹ�");
		}
			
		
			
	}
}
