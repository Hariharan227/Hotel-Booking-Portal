import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ModifyBooking extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyBooking frame = new ModifyBooking(null);
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
	public ModifyBooking(String Username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterBookingReference = new JLabel(" Enter Booking Reference:");
		lblEnterBookingReference.setForeground(new Color(255, 255, 255));
		lblEnterBookingReference.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblEnterBookingReference.setBounds(10, 88, 216, 27);
		contentPane.add(lblEnterBookingReference);
		
		textField = new JTextField();
		textField.setForeground(Color.GRAY);
		textField.setBounds(236, 88, 162, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connect=null;
				connect=UserDatabase.dbConnector();
				try
				{
				Statement ss=connect.createStatement();
				ResultSet rs=ss.executeQuery("select Username,BookRef from Booking");
				int u=0,bookref=0;
				while(rs.next())
				{
					if(Username.equals(rs.getString("Username"))&&Integer.parseInt(textField.getText())==rs.getInt("BookRef"))
					{
						u=1;
						bookref=rs.getInt("BookRef");
					}
				}
				if(u==0)
				{
					JOptionPane.showMessageDialog(contentPane, "Invalid Booking Reference");
					ModifyBooking obj=new ModifyBooking(Username);
					obj.setVisible(true);
					ModifyBooking.super.dispose();
				}
				else {
				ModifyBooking2 obj= new ModifyBooking2(Username,bookref);
				obj.setVisible(true);
				ModifyBooking.super.dispose();
				}
				}
				catch(Exception ae) {System.out.println(ae);}
			}
		});
		btnProceed.setBackground(Color.GRAY);
		btnProceed.setForeground(new Color(0, 0, 0));
		btnProceed.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnProceed.setBounds(248, 184, 110, 26);
		contentPane.add(btnProceed);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserOptions obj=new UserOptions(Username,null, null);
				obj.setVisible(true);
				ModifyBooking.super.dispose();
			}
		});
		btnBack.setBackground(Color.GRAY);
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnBack.setBounds(92, 184, 85, 26);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hari2\\Desktop\\four-points-by-sheraton.jpg"));
		lblNewLabel.setBounds(0, -3, 436, 281);
		contentPane.add(lblNewLabel);
	}
}

