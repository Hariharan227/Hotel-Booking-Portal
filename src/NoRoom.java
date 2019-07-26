import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class NoRoom extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoRoom frame = new NoRoom(null, null, 0, null, 0, 0, 0, 0, 0, 0, null, null);
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
	public NoRoom(String Username,String location,int num,String s,int d,int m,int y,int d1,int m1,int y1,FileOutputStream fos,ObjectOutputStream oos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRoomsAreNot = new JLabel("Rooms are not available during the given period.");
		lblRoomsAreNot.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblRoomsAreNot.setBounds(54, 41, 320, 44);
		contentPane.add(lblRoomsAreNot);
		
		JLabel lblDoYouWish = new JLabel("Do you wish to replan or enter the waiting list?");
		lblDoYouWish.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblDoYouWish.setBounds(54, 64, 320, 44);
		contentPane.add(lblDoYouWish);
		
		JButton btnNewButton = new JButton("Replan Booking");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewBooking obj=new NewBooking(Username,null,null);
				obj.setVisible(true);
				NoRoom.super.dispose();
			}
		});
		btnNewButton.setBounds(64, 119, 156, 34);
		contentPane.add(btnNewButton);
		
		JButton btnWaitingList = new JButton("Waiting List");
		btnWaitingList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection connect=null;
					connect=UserDatabase.dbConnector();
					String query="insert into WaitingList (Username,In_d,In_m,In_y,Out_d,Out_m,Out_y,Location,RoomType,NoOfRooms) values (?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst=connect.prepareStatement(query);
					pst.setString(1, Username);
					pst.setInt(2, d);
					pst.setInt(3, m);
					pst.setInt(4, y);
					pst.setInt(5, d1);
					pst.setInt(6, m1);
					pst.setInt(7, y1);
					pst.setString(8, location);
					pst.setString(9, s);
					pst.setInt(10, num);
					pst.execute();
					System.out.println("Added");
					pst.close();
				}
				catch(Exception ee)
				{
					System.out.println(ee.toString());
				}
				JOptionPane.showMessageDialog(contentPane, "Successfully added to the Waiting List! You will be notified if rooms are available.");
				UserOptions obj=new UserOptions(Username, fos,oos);
				obj.setVisible(true);
				NoRoom.super.dispose();
			}
		});
		btnWaitingList.setBackground(Color.GRAY);
		btnWaitingList.setForeground(Color.BLUE);
		btnWaitingList.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnWaitingList.setBounds(64, 181, 156, 34);
		contentPane.add(btnWaitingList);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserOptions obj=new UserOptions(Username,null,null);
				obj.setVisible(true);
				NoRoom.super.dispose();
			}
		});
		btnCancel.setBackground(Color.GRAY);
		btnCancel.setForeground(Color.BLUE);
		btnCancel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnCancel.setBounds(252, 149, 103, 34);
		contentPane.add(btnCancel);
	}

}
