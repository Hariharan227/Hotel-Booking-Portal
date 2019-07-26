import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.time.*;
import java.time.format.DateTimeFormatter;

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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class CancelBooking extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelBooking frame = new CancelBooking(null);
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
	public CancelBooking(String Username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(400, 400));
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterBookingReference = new JLabel("Enter Booking Reference:");
		lblEnterBookingReference.setOpaque(true);
		lblEnterBookingReference.setBounds(24, 89, 202, 26);
		lblEnterBookingReference.setForeground(new Color(0, 0, 0));
		lblEnterBookingReference.setFont(new Font("Script MT Bold", Font.BOLD, 18));
		contentPane.add(lblEnterBookingReference);
		
		textField = new JTextField();
		textField.setBounds(236, 89, 162, 26);
		textField.setForeground(Color.GRAY);
		contentPane.add(textField);
		textField.setColumns(10);
		
		DateTimeFormatter dff= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String s=dff.format(now);
		int curr_d=(10*Integer.parseInt(""+s.charAt(0))+Integer.parseInt(""+s.charAt(1)));
		int curr_m=(10*Integer.parseInt(""+s.charAt(3))+Integer.parseInt(""+s.charAt(4)));
		int curr_y=(1000*Integer.parseInt(""+s.charAt(6))+100*Integer.parseInt(""+s.charAt(7))+10*Integer.parseInt(""+s.charAt(8))+Integer.parseInt(""+s.charAt(9)));
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setBounds(60, 179, 92, 26);
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection connect=null;
					connect=UserDatabase.dbConnector();
					Statement ss=connect.createStatement();
					ResultSet rs=ss.executeQuery("select In_d,In_m,In_y,Username,Amount,BookRef from Booking");
					int u=0,d=0,m=0,y=0,amount=0,bookref=0;
					while(rs.next())
					{
						if(Username.equals(rs.getString("Username"))&&Integer.parseInt(textField.getText())==rs.getInt("BookRef"))
						{
							u=1;
							d=rs.getInt("In_d");
							m=rs.getInt("In_m");
							y=rs.getInt("In_y");
							amount=rs.getInt("Amount");
							bookref=rs.getInt("BookRef");
						}
					}
					if(u==0)
					{
						JOptionPane.showMessageDialog(contentPane, "Invalid Booking Reference");
						CancelBooking obj=new CancelBooking(Username);
						obj.setVisible(true);
						CancelBooking.super.dispose();
					}
					else
					{
						if((m==curr_m && y==curr_y && (d-curr_d)>=3)|| (m>curr_m && y==curr_y)||(y>curr_y)) {
								String query="delete from Booking where Username=? and BookRef=?";
								PreparedStatement pst=connect.prepareStatement(query);
								pst.setString(1, Username);
								pst.setInt(2, Integer.parseInt(textField.getText()));
								pst.execute();
								pst.close();
								JOptionPane.showMessageDialog(contentPane, "Booking Cancelled Successfully!");
								UserOptions obj=new UserOptions(Username, null, null);
								obj.setVisible(true);
								CancelBooking.super.dispose();
							}
						else 
						{
							CancelBooking2 obj=new CancelBooking2(Username,bookref,amount);
							obj.setVisible(true);
							CancelBooking.super.dispose();
						}
					}
				}
				catch(Exception ee) {}
			}
		});
		btnProceed.setBackground(new Color(0, 0, 139));
		btnProceed.setForeground(new Color(0, 0, 0));
		btnProceed.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(btnProceed);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(236, 179, 92, 26);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserOptions obj=new UserOptions(Username, null, null);
				obj.setVisible(true);
				CancelBooking.super.dispose();
			}
		});
		btnBack.setBackground(Color.GRAY);
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 436, 263);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hari2\\Desktop\\13593635.jpg"));
		contentPane.add(lblNewLabel);
	}
}
