import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Identification extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Identification frame = new Identification(null, 0, null, 0, 0, 0, 0, 0, 0, 0, null, null, null);
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
	public Identification(String Username,int num,String s,int d,int m,int y,int d1,int m1,int y1,int amt,String HotelName,FileOutputStream fos,ObjectOutputStream oos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdentification = new JLabel(" Identification:");
		lblIdentification.setForeground(new Color(255, 255, 255));
		lblIdentification.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblIdentification.setBounds(52, 64, 129, 22);
		contentPane.add(lblIdentification);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLUE);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox.addItem("");
		comboBox.addItem("Aadhar Card");
		comboBox.addItem("Pan Card");
		comboBox.addItem("Voter ID Card");
		comboBox.setBounds(199, 64, 150, 22);
		contentPane.add(comboBox);
		
		JLabel lblCardNumber = new JLabel(" Card Number:");
		lblCardNumber.setForeground(new Color(255, 255, 255));
		lblCardNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblCardNumber.setBounds(65, 129, 116, 20);
		contentPane.add(lblCardNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setForeground(Color.GRAY);
		textField.setBounds(197, 129, 152, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int BookRef=10000;
				String sc= textField.getText();
				int length= sc.length();
				if(length != 12)
				{
					JOptionPane.showMessageDialog(contentPane, "Invalid Aadhar Id");
					Identification obj=new Identification(Username,num,s,d,m,y,d1,m1,y1,amt, HotelName, fos, oos);
					obj.setVisible(true);
					Identification.super.dispose();	
				}
				else 
				{ 
				int count = 0;
				
				for(int i=0; i<12;i++)
				{
					if (sc[i])==1 || sc[i])==2 || sc[i])==3 || sc[i])==4 || sc[i])==5 || sc[i])==6 || 
				}
					
				if(textField.getText().equals("")|| ((String)comboBox.getSelectedItem()).equals(""))
				{
					JOptionPane.showMessageDialog(contentPane, "Input field(s) cannot be empty");
					Identification obj=new Identification(Username,num,s,d,m,y,d1,m1,y1,amt, HotelName, fos, oos);
					obj.setVisible(true);
					Identification.super.dispose();
					
				}
				
				else {
				try
				{
					Connection connect=null;
					connect=UserDatabase.dbConnector();
					Statement ss=connect.createStatement();
					ResultSet rs=ss.executeQuery("select BookRef from Booking");
					while(rs.next())
					{
						BookRef=rs.getInt("BookRef");
					}
					BookRef++;
					String query="insert into Booking (Username,BookRef,In_d,In_m,In_y,Out_d,Out_m,Out_y,Amount,HotelName,RoomType,NoOfRooms,CardType,CardNum) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst=connect.prepareStatement(query);
					pst.setString(1, Username);
					pst.setInt(2, BookRef);
					pst.setInt(3, d);
					pst.setInt(4, m);
					pst.setInt(5, y);
					pst.setInt(6, d1);
					pst.setInt(7, m1);
					pst.setInt(8, y1);
					pst.setInt(9, amt);
					pst.setString(10, HotelName);
					pst.setString(11, s);
					pst.setInt(12, num);
					pst.setString(13, (String)comboBox.getSelectedItem());
					pst.setString(14, textField.getText());
					pst.execute();
					System.out.println("Added");
					pst.close();
				}
				catch(Exception ee)
				{
					System.out.println(ee.toString());
				}
				JOptionPane.showMessageDialog(contentPane, "Booking Successful! Your Booking Reference is "+BookRef);
				UserOptions obj=new UserOptions(Username, fos,oos);
				obj.setVisible(true);
				Identification.super.dispose();
			}
			}
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		btnNewButton.setBounds(151, 183, 103, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hari2\\Desktop\\Swimming-Pools.jpg"));
		lblNewLabel.setBounds(-31, -26, 479, 289);
		contentPane.add(lblNewLabel);
	}
}
