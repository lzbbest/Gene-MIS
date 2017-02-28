package importdata;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JLabel;

import dbManage.JDBCFile;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Toolkit;

public class importgene2go extends JDialog {
	private JTextField textField;
	JTextArea resulttextArea=null;
    private JProgressBar progressBar;
    private int progress;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					importgene2go dialog = new importgene2go();
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
	public importgene2go() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(importgene2go.class.getResource("/javax/swing/plaf/metal/icons/ocean/minimize-pressed.gif")));
		setTitle("import gene2go into mysql");
		setBounds(100, 100, 434, 196);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 10, 201, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBrowse = new JButton("browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f  = new JFrame();
				JFileChooser jfc = new JFileChooser();
			     if(jfc.showOpenDialog(f)==JFileChooser.APPROVE_OPTION ){
			      textField.setText(jfc.getSelectedFile().getAbsolutePath());
			     }
			}
		});
		btnBrowse.setBounds(269, 9, 93, 23);
		getContentPane().add(btnBrowse);
		
		JButton btnStart = new JButton("start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					importgo();
					resulttextArea.setText("input genego succeed!");
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnStart.setBounds(149, 71, 93, 23);
		getContentPane().add(btnStart);
		
		JLabel lblResult = new JLabel("result:");
		lblResult.setBounds(80, 108, 42, 22);
		getContentPane().add(lblResult);
		
		resulttextArea  = new JTextArea();
		resulttextArea .setBounds(132, 104, 230, 26);
		getContentPane().add(resulttextArea );

	}
	
    public void importgo() throws IOException{
    	JDBCFile jdbccon=new JDBCFile();
		String path=null;
		FileReader fr=null;
		BufferedReader br=null;
		String line=null;
		String deletesql=null,selectsql=null,insertsql=null;
		String geneID=null,GOID=null,taxid=null;
		String[] lineInfo=null;
		int recordnum=0;
		
		path=textField.getText().trim();
		//deletesql="delete from godata;";
		//jdbccon.delete(deletesql);

		try {
			fr=new FileReader(path);
			br=new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			line=br.readLine();
			int linenum=0;
			while(line!=null){
				System.out.println("linenum:"+linenum);
				linenum++;
				lineInfo=line.split("\t");
				taxid=lineInfo[0];
				geneID=lineInfo[1];	
				GOID=lineInfo[2];
				selectsql="Select count(*) from godata where geneID='"+geneID+"' and GOID='"+GOID+"' and taxid='"+taxid+"';";
				recordnum=isExist(selectsql,jdbccon);
				//insert
				if(recordnum==0){
					insertsql="insert into godata(geneID,GOID,taxid) values('"+geneID+"','"+GOID+"','"+taxid+"');";
					insert(insertsql,jdbccon);
				}
				else if(recordnum==1){
					resulttextArea.setText("The data has repeated.");
					deletesql="delete from godata where geneID='"+geneID+"' and GOID='"+GOID+"' and taxid='"+taxid+"';";
					jdbccon.delete(deletesql);
				}
					else{
					resulttextArea.setText("import fail");
					}
				
				line=br.readLine();
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	private int insert(String insertsql,JDBCFile jdbccon){
		int recordnum=0;
		recordnum=jdbccon.insert(insertsql); 
		
		return recordnum;
	}
	private int isExist(String selectsql,JDBCFile jdbccon){
		int recordnum=0;
		ResultSet rs=jdbccon.query(selectsql); 
		try {
			if(rs.next()){
				recordnum=rs.getInt(1);
			}
			else{			
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return recordnum;
	}
}
