import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class HotelOptions extends JFrame {

	private JPanel contentPane;
	private JButton button;
	private JButton button_2;
	private JButton btnReplan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelOptions frame = new HotelOptions(null, 0, null, null,0,0,0,0,0,0, null, null);
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
	public HotelOptions(String Username,int num,Vector<String> opt,String s,int d,int m,int y,int d1,int m1,int y1,FileOutputStream fos,ObjectOutputStream oos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int len=opt.size(),t=0;
		if(t<len)
		{
			JLabel lblHotelName = new JLabel(opt.get(t));
			lblHotelName.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblHotelName.setBounds(56, 42, 230, 33);
			contentPane.add(lblHotelName);
			Connection connect=null;
			connect=UserDatabase.dbConnector();
			try
			{
				Statement ss=connect.createStatement();
				ResultSet rs=ss.executeQuery("select HotelName,Rating,"+s+"Cost from Hotel");
				while(rs.next())
				{
					if(opt.get(t).equals(rs.getString("HotelName")))
					{
						JLabel lblRating = new JLabel("Rating: "+rs.getDouble("Rating"));
						lblRating.setForeground(Color.BLACK);
						lblRating.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
						lblRating.setBounds(143, 74, 71, 20);
						contentPane.add(lblRating);
						JLabel lblPricePerNight = new JLabel("Price per night: "+rs.getInt(s+"Cost"));
						lblPricePerNight.setForeground(Color.BLACK);
						lblPricePerNight.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
						lblPricePerNight.setBounds(224, 74, 156, 20);
						contentPane.add(lblPricePerNight);
					}
				}
				JButton btnNewButton = new JButton("View");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						View obj=new View(Username,num, opt, opt.get(0), s,d,m,y,d1,m1,y1,fos, oos);
						obj.setVisible(true);
						HotelOptions.super.dispose();
					}
				});
				btnNewButton.setForeground(Color.GREEN);
				btnNewButton.setBackground(Color.GRAY);
				btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
				btnNewButton.setBounds(309, 49, 71, 20);
				contentPane.add(btnNewButton);
			}
			catch(Exception e) {}
			t++;
		}
		if(t<len)
		{
			JLabel label = new JLabel(opt.get(t));
			label.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			label.setBounds(56, 98, 230, 33);
			contentPane.add(label);
			Connection connect=null;
			connect=UserDatabase.dbConnector();
			try
			{
				Statement ss=connect.createStatement();
				ResultSet rs=ss.executeQuery("select HotelName,Rating,"+s+"Cost from Hotel");
				while(rs.next())
				{
					if(opt.get(t).equals(rs.getString("HotelName")))
					{
						JLabel label_2 = new JLabel("Rating: "+rs.getDouble("Rating"));
						label_2.setForeground(Color.BLACK);
						label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
						label_2.setBounds(143, 131, 71, 20);
						contentPane.add(label_2);
						JLabel label_4 = new JLabel("Price per night: "+rs.getInt(s+"Cost"));
						label_4.setForeground(Color.BLACK);
						label_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
						label_4.setBounds(224, 131, 156, 20);
						contentPane.add(label_4);
					}
				}
				button = new JButton("View");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						View obj=new View(Username,num, opt, opt.get(1), s,d,m,y,d1,m1,y1, fos, oos);
						obj.setVisible(true);
						HotelOptions.super.dispose();
					}
				});
				button.setForeground(Color.GREEN);
				button.setBackground(Color.GRAY);
				button.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
				button.setBounds(309, 105, 71, 20);
				contentPane.add(button);
			}
			catch(Exception e) {}
			t++;
		}
		if(t<len)
		{

			JLabel label_1 = new JLabel(opt.get(t));
			label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			label_1.setBounds(56, 154, 230, 33);
			contentPane.add(label_1);
			Connection connect=null;
			connect=UserDatabase.dbConnector();
			try
			{
				Statement ss=connect.createStatement();
				ResultSet rs=ss.executeQuery("select HotelName,Rating,"+s+"Cost from Hotel");
				while(rs.next())
				{
					if(opt.get(t).equals(rs.getString("HotelName")))
					{
						JLabel label_3 = new JLabel("Rating: "+rs.getDouble("Rating"));
						label_3.setForeground(Color.BLACK);
						label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
						label_3.setBounds(143, 187, 71, 20);
						contentPane.add(label_3);
						JLabel label_5 = new JLabel("Price per night: "+rs.getInt(s+"Cost"));
						label_5.setForeground(Color.BLACK);
						label_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
						label_5.setBounds(224, 187, 156, 20);
						contentPane.add(label_5);
					}
				}
				button_2 = new JButton("View");
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						View obj=new View(Username,num, opt, opt.get(2), s,d,m,y,d1,m1,y1,fos, oos);
						obj.setVisible(true);
						HotelOptions.super.dispose();
					}
				});
				button_2.setForeground(Color.GREEN);
				button_2.setBackground(Color.GRAY);
				button_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
				button_2.setBounds(309, 161, 71, 20);
				contentPane.add(button_2);
			}
			catch(Exception e) {}
		}
		btnReplan = new JButton("Replan");
		btnReplan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewBooking obj=new NewBooking(Username,fos, oos);
				obj.setVisible(true);
				HotelOptions.super.dispose();
			}
		});
		btnReplan.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnReplan.setBackground(Color.CYAN);
		btnReplan.setBounds(155, 224, 114, 28);
		contentPane.add(btnReplan);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hari2\\Desktop\\infinity-pool-south-tyrol.jpg"));
		lblNewLabel.setBounds(-239, -35, 807, 315);
		contentPane.add(lblNewLabel);
		
	}
}
