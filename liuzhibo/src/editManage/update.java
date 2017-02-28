package editManage;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import dbManage.JDBCFile;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class update extends JDialog {
	private JTextField txtEnterGeneid;
	private JTextField txtEnterGeneid_1;
	private JTextField txtEnterGoid;
	private JTextField txtEnterSymbol;
	JTextArea resulttextArea;
	private JTextField txtClickToEnter;
	private JTextField txtClickToEnter_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update dialog = new update();
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
	public update() {
		setTitle("UPDATE DATA");
		setBounds(100, 100, 450, 269);
		getContentPane().setLayout(null);
		
		txtEnterGeneid = new JTextField();
		txtEnterGeneid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEnterGeneid.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String str1=txtEnterGeneid.getText();
				if(str1.equals("")){
				txtEnterGeneid.setText("click to enter geneID");}
			}
		});
		txtEnterGeneid.setText("click to enter geneID");
		txtEnterGeneid.setBounds(28, 58, 119, 21);
		getContentPane().add(txtEnterGeneid);
		txtEnterGeneid.setColumns(10);
		
		txtEnterGeneid_1 = new JTextField();
		txtEnterGeneid_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEnterGeneid_1.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String str1=txtEnterGeneid_1.getText();
				if(str1.equals("")){
				txtEnterGeneid_1.setText("click to enter geneID");}
			}
			
		});
		txtEnterGeneid_1.setText("click to enter geneID");
		txtEnterGeneid_1.setBounds(258, 58, 135, 21);
		getContentPane().add(txtEnterGeneid_1);
		txtEnterGeneid_1.setColumns(10);
		
		txtEnterGoid = new JTextField();
		txtEnterGoid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEnterGoid.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String str1=txtEnterGoid.getText();
				if(str1.equals("")){
				txtEnterGoid.setText("click to enter GO_ID");}
			}
			
		});
		txtEnterGoid.setText("click to enter GO_ID");
		txtEnterGoid.setBounds(28, 89, 119, 21);
		getContentPane().add(txtEnterGoid);
		txtEnterGoid.setColumns(10);
		
		txtEnterSymbol = new JTextField();
		txtEnterSymbol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtEnterSymbol.setText("");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				String str1=txtEnterSymbol.getText();
				if(str1.equals("")){
				txtEnterSymbol.setText("click to enter symbol");}
			}
			
		});
		txtEnterSymbol.setText("click to enter symbol");
		txtEnterSymbol.setBounds(258, 89, 135, 21);
		getContentPane().add(txtEnterSymbol);
		txtEnterSymbol.setColumns(10);
		
		JButton btnUpdate = new JButton("update godata");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatago();
			}
		});
		btnUpdate.setBounds(28, 120, 119, 23);
		getContentPane().add(btnUpdate);
		
		JButton btnNewButton = new JButton("update infodata");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatainfo();
			}
		});
		btnNewButton.setBounds(258, 120, 135, 23);
		getContentPane().add(btnNewButton);

		resulttextArea = new JTextArea();
		resulttextArea.setBounds(137, 153, 150, 67);
		getContentPane().add(resulttextArea);
		
		JLabel lblResult = new JLabel("result:");
		lblResult.setBounds(64, 182, 54, 15);
		getContentPane().add(lblResult);
		
		txtClickToEnter = new JTextField();
		txtClickToEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		txtClickToEnter.setColumns(10);
		txtClickToEnter.setBounds(28, 27, 119, 21);
		getContentPane().add(txtClickToEnter);
		
		txtClickToEnter_1 = new JTextField();
		txtClickToEnter_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		txtClickToEnter_1.setColumns(10);
		txtClickToEnter_1.setBounds(258, 27, 135, 21);
		getContentPane().add(txtClickToEnter_1);

	}
	private void updatago(){                           //update GOID by geneID
		String GOID=txtEnterGoid.getText().trim();
		String geneID=txtEnterGeneid.getText().trim();
		String taxid=txtClickToEnter.getText().trim();
		String updatesql="update gomissystem.godata set GOID='"+GOID+"' where geneID='"+geneID+"' and tax='"+taxid+"';";
		
		JDBCFile jdbccon=new JDBCFile();
		int result=jdbccon.update(updatesql);
		if(result>0){
			resulttextArea.setText("updata to godata ok!");
		}
		else {
			resulttextArea.setText("updata to godata fail!");
		}
		
	}
	private void updatainfo(){                       //update symbol by geneID
		String symbol=txtEnterSymbol.getText().trim();
		String geneID=txtEnterGeneid_1.getText().trim();
		String taxid=txtClickToEnter_1.getText().trim();
		String updatesql="update gomissystem.infodata set symbol='"+symbol+"' where geneID='"+geneID+"' and tax='"+taxid+"';";
		
		JDBCFile jdbccon=new JDBCFile();
		int result=jdbccon.update(updatesql);
		if(result>0){
			resulttextArea.setText("updata to infodata ok!");
		}
		else {
			resulttextArea.setText("updata to infodata fail!");
		}
		
	}
}
