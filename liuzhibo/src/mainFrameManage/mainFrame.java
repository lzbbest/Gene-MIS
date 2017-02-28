package mainFrameManage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.Vector;

import dbManage.JDBCFile;
import editManage.adddata;
import editManage.delete;
import editManage.update;
import importdata.importgene2go;
import importdata.importgeneinfo;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import queryManage.queryGeneIDfromSymbol;
import queryManage.queryGOIDfromSymbol;
import queryManage.querySymbolfromGOID;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class mainFrame extends JFrame {

	private JPanel contentPane;
	JMenuBar menuBar;
	JMenu mnFile;
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
	 * Create the frame.
	 */
	public mainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(mainFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")));
		setTitle("GO DATA MIS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 268);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setVisible(true);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
				
		JMenuItem mntmImport = new JMenuItem("import gene2go into mysql");
		mntmImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				importgene2go dialog = new importgene2go();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnFile.add(mntmImport);
				
		JMenuItem mntmImportGeneinfoInto = new JMenuItem("import gene_info into mysql");
		mntmImportGeneinfoInto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importgeneinfo dialog = new importgeneinfo();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnFile.add(mntmImportGeneinfoInto);
		
		JMenuItem mntmExit = new JMenuItem("EXIT");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnAdd = new JMenu("Edit");
		mnAdd.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnAdd);
		
		JMenuItem mntmAdd = new JMenuItem("add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					adddata dialog = new adddata();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
			}
		});
		mnAdd.add(mntmAdd);
		
		JMenuItem mntmUpdate = new JMenuItem("update");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update dialog = new update();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnAdd.add(mntmUpdate);
		
		JMenuItem mntmDelete = new JMenuItem("delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete dialog = new delete();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnAdd.add(mntmDelete);
		
		JMenu mnNewMenu = new JMenu("Serve");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("query goID from Symbol");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				queryGOIDfromSymbol dialog = new queryGOIDfromSymbol();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmQueryGeneidFrom = new JMenuItem("query geneID from Symbol");
		mntmQueryGeneidFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryGeneIDfromSymbol dialog = new queryGeneIDfromSymbol();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnNewMenu.add(mntmQueryGeneidFrom);
		
		JMenuItem mntmQuerySymbolFrom = new JMenuItem("query Symbol from goID");
		mntmQuerySymbolFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				querySymbolfromGOID dialog = new querySymbolfromGOID();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		mnNewMenu.add(mntmQuerySymbolFrom);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelpTxt = new JMenuItem("Please read document named 'readme'.");
		mnHelp.add(mntmHelpTxt);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("welcome to use free gene MIS!");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(51, 10, 333, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(374, 175, 66, 23);
		contentPane.add(btnQuit);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\\u5B66\u901AJava\u768424\u5802\u8BFE\\ym\\liuzhibo\\GENE.jpg"));
		label_1.setBounds(64, 39, 304, 159);
		contentPane.add(label_1);
	}
 }
	
