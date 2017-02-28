package mainFrameManage;

import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import dbManage.JDBCFile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sign_up extends JDialog {
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	JTextArea resulttextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sign_up dialog = new sign_up();
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
	public sign_up() {
		setTitle("SIGN UP");
		setIconImage(Toolkit.getDefaultToolkit().getImage(sign_up.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setBounds(100, 100, 400, 216);
		getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("USER:");
		lblUser.setBounds(22, 24, 79, 23);
		getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setBounds(22, 68, 79, 23);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(111, 69, 138, 21);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(111, 110, 138, 23);
		getContentPane().add(passwordField_1);
		
		textField = new JTextField();
		textField.setBounds(111, 24, 138, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblReinput = new JLabel("REINPUT:");
		lblReinput.setBounds(22, 107, 54, 28);
		getContentPane().add(lblReinput);
		
		resulttextArea = new JTextArea();
		resulttextArea.setBounds(286, 68, 88, 24);
		getContentPane().add(resulttextArea);
		
		JLabel lblResult = new JLabel("result");
		lblResult.setBounds(308, 41, 47, 15);
		getContentPane().add(lblResult);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						signup();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}}
		});
		btnSignUp.setBounds(121, 143, 93, 23);
		getContentPane().add(btnSignUp);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(281, 143, 93, 23);
		getContentPane().add(btnExit);

	}
	public void signup() throws SQLException{
		String user=textField.getText().trim();
		String password=passwordField.getText().trim();
		String repassword=passwordField_1.getText().trim();
		if(password.equals(repassword)){
			String insertsql="insert into gomissystem.userinfo(user,password) values('"+user+"','"+password+"');";
			JDBCFile jdbccon=new JDBCFile();
	    	if(password.equals(repassword)){
	    		int result=jdbccon.insert(insertsql);
				if(result>0){
					resulttextArea.setText("sign up succeed!");
					}
				else {
					resulttextArea.setText("sign up fail!");}
				}
	    	}
		else{
			resulttextArea.setText("Input the same password,please.");}
		
		}
		
	}

