package editManage;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import dbManage.JDBCFile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.TextArea;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class adddata extends JDialog {
	private JTextField txtGeneid;
	private JTextField txtGoid;
	private JTextField txtGeneid_1;
	private JTextField txtSymbol;
	JTextArea resulttextArea;
	private JLabel lblResult;
	private JTextField txtClickToEnter;
	private JTextField txtClickToEnter_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adddata dialog = new adddata();
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
	public adddata() {
		setTitle("ADD DATA");
		setBounds(100, 100, 609, 292);
		
		txtGeneid = new JTextField();
		txtGeneid.setForeground(SystemColor.activeCaption);
		txtGeneid.setBounds(53, 46, 173, 21);
		txtGeneid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtGeneid.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String str1=txtGeneid.getText();
				if(str1.equals("")){
				txtGeneid.setText("click to enter geneID");}
			}
		});
		getContentPane().setLayout(null);
		txtGeneid.setText("click to enter geneID");
		getContentPane().add(txtGeneid);
		txtGeneid.setColumns(10);
				
		txtGoid = new JTextField();
		txtGoid.setForeground(SystemColor.activeCaption);
		txtGoid.setBounds(53, 77, 173, 21);
		txtGoid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtGoid.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String str1=txtGoid.getText();
				if(str1.equals("")){
					txtGoid.setText("click to enter GOID");}
			}
		});
		txtGoid.setText("click to enter GOID");
		getContentPane().add(txtGoid);
		txtGoid.setColumns(10);
		
		txtGeneid_1 = new JTextField();
		txtGeneid_1.setForeground(SystemColor.activeCaption);
		txtGeneid_1.setBounds(375, 46, 181, 21);
		txtGeneid_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtGeneid_1.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String str1=txtGeneid_1.getText();
				if(str1.equals("")){
				txtGeneid_1.setText("click to enter geneID");}
			}
		});
		txtGeneid_1.setText("click to enter geneID");
		getContentPane().add(txtGeneid_1);
		txtGeneid_1.setColumns(10);
		
		txtSymbol = new JTextField();
		txtSymbol.setForeground(SystemColor.activeCaption);
		txtSymbol.setBounds(375, 77, 181, 21);
		txtSymbol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtSymbol.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String str1=txtSymbol.getText();
				if(str1.equals("")){
				txtSymbol.setText("click to enter symbol");}
			}
		});
		txtSymbol.setText("click to enter symbol");
		getContentPane().add(txtSymbol);
		txtSymbol.setColumns(10);
		
		JButton btnNewButton = new JButton("add to godata");
		btnNewButton.setBounds(85, 124, 111, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addgo();
			}
		});
		getContentPane().add(btnNewButton);
		
		JButton btnAddToInfodata = new JButton("add to infodata");
		btnAddToInfodata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addinfo();
			}
		});
		btnAddToInfodata.setBounds(399, 124, 123, 23);
		getContentPane().add(btnAddToInfodata);
		
		resulttextArea = new JTextArea();
		resulttextArea.setBounds(216, 151, 150, 67);
		getContentPane().add(resulttextArea);
		
		lblResult = new JLabel("result");
		lblResult.setBounds(263, 228, 54, 15);
		getContentPane().add(lblResult);
		
		txtClickToEnter = new JTextField();
		txtClickToEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtClickToEnter.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String str1=txtClickToEnter.getText();
				if(str1.equals("")){
					txtClickToEnter.setText("click to enter taxid");}
			}
		});
		txtClickToEnter.setText("click to enter taxid");
		txtClickToEnter.setForeground(SystemColor.activeCaption);
		txtClickToEnter.setColumns(10);
		txtClickToEnter.setBounds(53, 15, 173, 21);
		getContentPane().add(txtClickToEnter);
		
		txtClickToEnter_1 = new JTextField();
		txtClickToEnter_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtClickToEnter_1.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String str1=txtClickToEnter_1.getText();
				if(str1.equals("")){
					txtClickToEnter_1.setText("click to enter taxid");}
			}
		});
		txtClickToEnter_1.setText("click to enter taxid");
		txtClickToEnter_1.setForeground(SystemColor.activeCaption);
		txtClickToEnter_1.setColumns(10);
		txtClickToEnter_1.setBounds(375, 15, 181, 21);
		getContentPane().add(txtClickToEnter_1);

	}
	private void addgo(){
		String GOID=txtGoid.getText().trim();
		String geneID=txtGeneid.getText().trim();
		String taxid=txtClickToEnter.getText().trim();
		String insertsql="insert into gomissystem.godata(GOID,geneID,taxid) values('"+GOID+"','"+geneID+"','"+taxid+"');";
		
		JDBCFile jdbccon=new JDBCFile();
		int result=jdbccon.insert(insertsql);
		if(result>0){
			resulttextArea.setText("add to godata ok!");
		}
		else {
			resulttextArea.setText("add to godata fail!");
		}
		
	}
	private void addinfo(){
		String symbol=txtSymbol.getText().trim();
		String geneID=txtGeneid_1.getText().trim();
		String taxid=txtClickToEnter_1.getText().trim();
		String insertsql="insert into gomissystem.infodata(symbol,geneID,taxid) values('"+symbol+"','"+geneID+"','"+taxid+"');";
		
		JDBCFile jdbccon=new JDBCFile();
		int result=jdbccon.insert(insertsql);
		if(result>0){
			resulttextArea.setText("add to infodata ok!");
		}
		else {
			resulttextArea.setText("add to infodata fail!");
		}
		
	}
}
