package queryManage;

import java.awt.EventQueue;
import dbManage.JDBCFile;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;

public class queryGeneIDfromSymbol extends JDialog {
	private JTextField textField;
	JTextArea resulttextArea;
	JScrollPane scrollPane_1 = new JScrollPane();
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					queryGeneIDfromSymbol dialog = new queryGeneIDfromSymbol();
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
	public queryGeneIDfromSymbol() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(queryGeneIDfromSymbol.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
		setTitle("Query GENEID from Symbol");
		setBounds(100, 100, 450, 287);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INPUT SYMBOL:");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 33, 122, 24);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(159, 33, 221, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblResult = new JLabel("GENEID:");
		lblResult.setFont(new Font("����", Font.PLAIN, 20));
		lblResult.setBounds(10, 125, 102, 24);
		getContentPane().add(lblResult);
		
		JButton btnQuery = new JButton("QUERY");
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resulttextArea.setText(null);
					try {
						query();
					} catch (SQLException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
			}
		});
		btnQuery.setFont(new Font("����", Font.BOLD, 15));
		btnQuery.setBounds(143, 195, 93, 23);
		getContentPane().add(btnQuery);
		
		resulttextArea = new JTextArea();
		resulttextArea.setBounds(159, 83, 221, 24);
		getContentPane().add(resulttextArea);
		
		JLabel lblResult_1 = new JLabel("RESULT:");
		lblResult_1.setFont(new Font("����", Font.PLAIN, 20));
		lblResult_1.setBounds(10, 80, 86, 24);
		getContentPane().add(lblResult_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(159, 157, 221, -22);
		getContentPane().add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);

	}
	public void query() throws SQLException {
		String symbol=textField.getText().trim();
		if(symbol.length()==0){
			resulttextArea.setText("Please input correct data!");
		}
		else{
			String selectsql="select infodata.geneID from infodata where infodata.symbol='"+symbol+"';";
		    JDBCFile jdbccon=new JDBCFile();
		    ResultSet rs=jdbccon.query(selectsql);
		    boolean moreRecords=false;
		    moreRecords = rs.next();
		    if(!moreRecords) {
				resulttextArea.setText("There is nothing you queried!");
			   }else{
				   Vector col = new Vector();
					col.addElement("geneID");
					Vector rowData=new Vector();
					int geneID = 0;
					Vector row=new Vector();
			          								
					while(rs.next()){
						geneID=rs.getInt("geneID");
			           	row.add(geneID);
					}
					resulttextArea.setText("query succeed!");
					rowData.add(row);
					table = new JTable(rowData,col);
					scrollPane_1.setViewportView(table);
		    
			
			   } 
		}
	}			
}		
		
		
		
	
