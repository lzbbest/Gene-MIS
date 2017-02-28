package importdata;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import dbManage.JDBCFile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.Toolkit;

public class importgeneinfo extends JDialog {
	private JTextField textField;
	JTextArea resulttextArea=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					importgeneinfo dialog = new importgeneinfo();
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
	public importgeneinfo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(importgeneinfo.class.getResource("/javax/swing/plaf/metal/icons/ocean/minimize-pressed.gif")));
		setTitle("import gene_info into mysql");
		setBounds(100, 100, 431, 187);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 10, 204, 21);
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
		btnBrowse.setBounds(265, 9, 93, 23);
		getContentPane().add(btnBrowse);
		
		JButton btnStart = new JButton("start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					importinfo();
					resulttextArea.setText("input geneinfo succeed!");
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnStart.setBounds(153, 52, 93, 23);
		getContentPane().add(btnStart);

		JLabel lblResult = new JLabel("result:");
		lblResult.setBounds(80, 108, 42, 22);
		getContentPane().add(lblResult);
		
		resulttextArea  = new JTextArea();
		resulttextArea .setBounds(153, 108, 205, 26);
		getContentPane().add(resulttextArea );
	}
	 public void importinfo() throws IOException{
	    	JDBCFile jdbccon=new JDBCFile();
			String path=null;
			FileReader fr=null;
			BufferedReader br=null;
			String line=null;
			String deletesql=null,selectsql=null,insertsql=null;
			String geneID=null,symbol=null,taxid=null;
			String[] lineInfo=null;
			int recordnum=0;
			
			path=textField.getText().trim();
			//deletesql="delete from infodata";
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
					symbol=lineInfo[2];
					selectsql="Select count(*) from infodata where geneID='"+geneID+"' and symbol='"+symbol+"' and taxid='"+taxid+"';";
					recordnum=isExist(selectsql,jdbccon);
					if(recordnum==0){
						insertsql="insert into infodata(geneID,symbol,taxid) values('"+geneID+"','"+symbol+"','"+taxid+"');";
						insert(insertsql,jdbccon);
					}
					else if(recordnum==1){
						resulttextArea.setText("The data has repeated.");
						deletesql="delete from infodata where geneID='"+geneID+"' and symbol='"+symbol+"' and taxid='"+taxid+"'";
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

