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

public class delete extends JDialog {
	private JTextField txtEnterGeneid;
	private JTextField txtEnterGeneid_1;
	private JTextField txtEnterGoid;
	private JTextField txtEnterSymbol;
	JTextArea resulttextArea;
	private JLabel lblResult;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete dialog = new delete();
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
	public delete() {
		setTitle("DELETE DATA");
		setBounds(100, 100, 450, 266);
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
		txtEnterGeneid.setBounds(28, 22, 119, 21);
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
		txtEnterGeneid_1.setBounds(258, 22, 135, 21);
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
		txtEnterGoid.setBounds(28, 63, 119, 21);
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
		txtEnterSymbol.setBounds(258, 63, 135, 21);
		getContentPane().add(txtEnterSymbol);
		txtEnterSymbol.setColumns(10);
		
		JButton btnUpdate = new JButton("delete godata");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletego();
			}
		});
		btnUpdate.setBounds(28, 100, 119, 23);
		getContentPane().add(btnUpdate);
		
		JButton btnNewButton = new JButton("delete infodata");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteinfo();
			}
		});
		btnNewButton.setBounds(268, 100, 125, 23);
		getContentPane().add(btnNewButton);
		
		resulttextArea = new JTextArea();
		resulttextArea.setBounds(144, 150, 150, 67);
		getContentPane().add(resulttextArea);
		
		lblResult = new JLabel("result:");
		lblResult.setBounds(80, 175, 54, 15);
		getContentPane().add(lblResult);

	}
	private void deletego(){
		String GOID=txtEnterGoid.getText().trim();
		String geneID=txtEnterGeneid.getText().trim();						
		String deletesql="delete from gomissystem.godata where GOID='"+GOID+"' and geneID='"+geneID+"';";
		
		JDBCFile jdbccon=new JDBCFile();
		int result=jdbccon.delete(deletesql);
		if(result>0){
			resulttextArea.setText("delete to godata ok!");
		}
		else {
			resulttextArea.setText("delete to godata fail!");
		}
		
	}
	private void deleteinfo(){
		String symbol=txtEnterSymbol.getText().trim();
		String geneID=txtEnterGeneid_1.getText().trim();						
		String deletesql="delete from gomissystem.infodata where symbol='"+symbol+"' and geneID='"+geneID+"';";
		
		JDBCFile jdbccon=new JDBCFile();
		int result=jdbccon.delete(deletesql);
		if(result>0){
			resulttextArea.setText("delete to infodata ok!");
		}
		else {
			resulttextArea.setText("delete to infodata fail!");
		}
		
	}

}
