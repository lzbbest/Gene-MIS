package mainFrameManage;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import queryManage.queryGeneIDfromSymbol;

import comPakage.getUserInfo;

import dbManage.JDBCFile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class login extends JDialog {
	private JTextField textField;
	private JPasswordField passwordField;
	JTextArea resulttextArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login dialog = new login();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setTitle("LOG IN");
		setBounds(100, 100, 450, 220);
		getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("USER:");
		lblUser.setBounds(37, 51, 81, 24);
		getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(37, 85, 81, 26);
		getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(161, 54, 181, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(161, 87, 181, 24);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(161, 134, 120, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("QUIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(331, 134, 93, 23);
		getContentPane().add(btnNewButton_1);
		
		resulttextArea = new JTextArea();
		resulttextArea.setBackground(SystemColor.control);
		resulttextArea.setBounds(161, 107, 181, 19);
		getContentPane().add(resulttextArea);
		
		JButton btnSignUp = new JButton("sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sign_up dialog = new sign_up();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnSignUp.setFont(new Font("宋体", Font.ITALIC, 17));
		btnSignUp.setBounds(10, 133, 105, 23);
		getContentPane().add(btnSignUp);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\\u5B66\u901AJava\u768424\u5802\u8BFE\\ym\\liuzhibo\\logo8527.jpg"));
		lblNewLabel.setBounds(95, 0, 247, 56);
		getContentPane().add(lblNewLabel);

	}
	public void login() throws SQLException{
		String user=textField.getText().trim();
		String password=passwordField.getText().trim();
		String selectsql="select count(*) from gomissystem.userinfo where user='"+user+"' and password='"+password+"';";
		JDBCFile jdbccon=new JDBCFile();
		getUserInfo gui=new getUserInfo(selectsql,jdbccon);
		gui.queryUserInfo();
		int recordNum=gui.getRecordNum();
		if(recordNum>0){
				resulttextArea.setText("log in succeed.");
				mainFrame frame = new mainFrame();
				frame.setVisible(true);

			}else{
				resulttextArea.setText("log in fail.");
			}		
	}
}
