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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;

public class querySymbolfromGOID extends JDialog {
	private JTextField textField;
	private JTextArea resulttextArea;
	JScrollPane scrollPane_1 = new JScrollPane();
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					querySymbolfromGOID dialog = new querySymbolfromGOID();
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
	public querySymbolfromGOID() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(querySymbolfromGOID.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
		setTitle("Query Symbol from GOID");
		setBounds(100, 100, 450, 287);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INPUT GOID:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 33, 122, 24);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(158, 33, 221, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblResult = new JLabel("SYMBOL:");
		lblResult.setFont(new Font("宋体", Font.PLAIN, 20));
		lblResult.setBounds(10, 138, 102, 24);
		getContentPane().add(lblResult);
		
		JButton btnQuery = new JButton("QUERY");
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					query();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnQuery.setFont(new Font("宋体", Font.BOLD, 15));
		btnQuery.setBounds(143, 195, 93, 23);
		getContentPane().add(btnQuery);
		
		resulttextArea = new JTextArea();
		resulttextArea.setBounds(158, 80, 221, 24);
		getContentPane().add(resulttextArea);
		
		JLabel lblResult_1 = new JLabel("RESULT:");
		lblResult_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblResult_1.setBounds(10, 77, 86, 24);
		getContentPane().add(lblResult_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(143, 161, 220, -15);
		getContentPane().add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);

	}
	public void query() throws SQLException{
		String GOID=textField.getText().trim();
		if(GOID.length()==0){
			resulttextArea.setText("Please input correct data!");
		}
		else{
			String selectsql="select infodata.symbol from godata,infodata where godata.geneID=infodata.geneID and godata.GOID='"+GOID+"';";
		    JDBCFile jdbccon=new JDBCFile();
		    ResultSet rs=jdbccon.query(selectsql);
		    boolean moreRecords=false;
		    moreRecords = rs.next();
		    if(!moreRecords) {
		    	resulttextArea.setText("There is nothing you queried!");
			   }else{
				   	Vector col = new Vector();
					col.addElement("symbol");
					Vector rowData=new Vector();
					String symbol = null;
					Vector row=new Vector();
			          								
					while(rs.next()){
						symbol=rs.getString("symbol");
			           	row.add(symbol);
					}
					resulttextArea.setText("query succeed!");
					rowData.add(row);
					table = new JTable(rowData,col);
					scrollPane_1.setViewportView(table);
			}
		}
	}
}
