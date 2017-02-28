import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.*; 

public class draw_sequence250 extends JFrame {

	private JPanel contentPane;
	private JTextField txtJj;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					draw_sequence250 frame = new draw_sequence250();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public draw_sequence250() {
		setFont(new Font("华文宋体", Font.BOLD | Font.ITALIC, 15));
		setTitle("XueLie Transfer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		txtJj = new JTextField();
		txtJj.setHorizontalAlignment(SwingConstants.CENTER);
		txtJj.setBounds(175, 19, 193, 23);
		contentPane.add(txtJj);
		txtJj.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(175, 62, 193, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblInputPathway = new JLabel("Input Pathway:");
		lblInputPathway.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputPathway.setBounds(32, 19, 125, 23);
		contentPane.add(lblInputPathway);
		
		JLabel lblNewLabel = new JLabel("Output Pathway:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(32, 62, 125, 23);
		contentPane.add(lblNewLabel);
		
		final JButton btnStart = new JButton("Start");
		 btnStart.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent arg0){
			    	if(arg0.getSource()==btnStart){
						try {
							Start();
						} catch (IOException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
			    }});
		btnStart.setToolTipText("This button will transfer file type to fasta type.");
		btnStart.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		btnStart.setBounds(175, 141, 93, 23);
		contentPane.add(btnStart);  }
		public void Start() throws IOException{
			String input=txtJj.getText();
			String output=textField_1.getText();
				
		    FileReader fr=new FileReader(input); 
		    	
		    BufferedReader br=new BufferedReader(fr); 
		    	
		    FileWriter fw=new FileWriter(output); 
		    	
		    BufferedWriter bw=new BufferedWriter(fw);
		    	
		    String line=br.readLine();
		    int i=1;
		    while(line!=null&&i<250)
		      { 
		        System.out.println(line);
		       	bw.write(line);
			    bw.newLine();
		        bw.flush();
		        line=br.readLine();
		        i++;
		      }
		    	/**流的关闭.*/ 
		    br.close();
		    fr.close(); 
		    bw.flush();
		    fw.close();
	}
	    }
