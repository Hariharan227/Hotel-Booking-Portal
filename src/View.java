import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
public class View extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View(null, 0, null, null, null, 0,0,0,0,0,0,null, null);
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
	public View(String Username,int num, Vector<String> opt, String HotelName,String s,int d,int m,int y,int d1,int m1,int y1,FileOutputStream fos,ObjectOutputStream oos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HotelOptions obj=new HotelOptions(Username, num,opt,s,d,m,y,d1,m1,y1, fos, oos);
				obj.setVisible(true);
				View.super.dispose();
			}
		});
		button.setForeground(Color.GREEN);
		button.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		button.setBackground(Color.GRAY);
		button.setBounds(54, 213, 71, 20);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("Amenities");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(54, 25, 109, 30);
		contentPane.add(lblNewLabel);
		
		Connection connect=null;
		connect=UserDatabase.dbConnector();
		int days=0;
		try
		{
			Statement ss=connect.createStatement();
			ResultSet rs=ss.executeQuery("select * from Hotel");
			
			while(rs.next())
			{
				if(HotelName.equals(rs.getString("HotelName")))
					
				{
					
					if(!(y==y1) ||(m==1&&y==y1)||(m==3&&y==y1)||(m==5&&y==y1)||(m==7&&y==y1)||(m==8&&y==y1)||(m==10&&y==y1)) {
					Calendar cal = Calendar.getInstance();

			        cal.set(Calendar.DAY_OF_MONTH, d);
			        cal.set(Calendar.MONTH, m);
			        cal.set(Calendar.YEAR, y);
			        Date firstDate = cal.getTime();
			
			        cal.set(Calendar.DAY_OF_MONTH, d1);
			        cal.set(Calendar.MONTH, m1);
			        cal.set(Calendar.YEAR, y1);
			        Date secondDate = cal.getTime();
			
			
			        long diff = secondDate.getTime() - firstDate.getTime();
			        days= Integer.parseInt(""+(diff/86400000));
					}
					
					if((m==4&&y==y1)||(m==6&&y==y1)||(m==9&&y==y1)||(m==11&&y==y1))
							{
								days= (d1-d) + (m1-m)*30;
							}
					else if(m==2&&y!=2020)
					{
						days = (d1-d)+ (m1-m)*28;
					}
					else if(m==2&&y==2020)
					{
						days = (d1-d)+ (m1-m)*29;
					}
					
					
					
			        
					JLabel lblAmenity = new JLabel(rs.getString("Amenity1"));
					lblAmenity.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
					lblAmenity.setBounds(64, 58, 138, 20);
					contentPane.add(lblAmenity);
					
					JLabel label = new JLabel(rs.getString("Amenity2"));
					label.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
					label.setBounds(64, 78, 138, 20);
					contentPane.add(label);
					
					JLabel label_1 = new JLabel(rs.getString("Amenity3"));
					label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
					label_1.setBounds(64, 97, 138, 20);
					contentPane.add(label_1);
					
					JLabel label_2 = new JLabel(rs.getString("Amenity4"));
					label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
					label_2.setBounds(64, 118, 138, 20);
					contentPane.add(label_2);
					
					JLabel label_3 = new JLabel(rs.getString("Amenity5"));
					label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
					label_3.setBounds(64, 137, 138, 20);
					contentPane.add(label_3);
					
					JLabel label_4 = new JLabel(rs.getString("Amenity6"));
					label_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
					label_4.setBounds(64, 159, 138, 20);
					contentPane.add(label_4);
					
					JLabel label_5 = new JLabel(""+rs.getDouble("Rating"));
					label_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
					label_5.setBounds(310, 57, 54, 20);
					contentPane.add(label_5);
					
					JLabel lblNumberOfRaters = new JLabel("Number of Raters: "+rs.getInt("RaterCount"));
					lblNumberOfRaters.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
					lblNumberOfRaters.setBounds(212, 78, 183, 20);
					contentPane.add(lblNumberOfRaters);
					
					JLabel lblTotalAmountPayable = new JLabel("Total Amount Payable: "+(rs.getInt(s+"Cost")*num*days));
					lblTotalAmountPayable.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
					lblTotalAmountPayable.setBounds(200, 176, 210, 20);
					contentPane.add(lblTotalAmountPayable);
				}
			}
		}
		catch(Exception e) {}

		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int amt=0;
				try
				{
					Connection connect=null;
					connect=UserDatabase.dbConnector();Statement ss=connect.createStatement();
					ResultSet rs=ss.executeQuery("select HotelName,"+s+"Cost from Hotel");
					while(rs.next())
						
					{
						int days=0;
						if(HotelName.equals(rs.getString("HotelName")))
						{
							if(!(y==y1) ||(m==1&&y==y1)||(m==3&&y==y1)||(m==5&&y==y1)||(m==7&&y==y1)||(m==8&&y==y1)||(m==10&&y==y1)) {
							Calendar cal = Calendar.getInstance();

					        cal.set(Calendar.DAY_OF_MONTH, d);
					        cal.set(Calendar.MONTH, m);
					        cal.set(Calendar.YEAR, y);
					        Date firstDate = cal.getTime();
					
					        cal.set(Calendar.DAY_OF_MONTH, d1);
					        cal.set(Calendar.MONTH, m1);
					        cal.set(Calendar.YEAR, y1);
					        Date secondDate = cal.getTime();
					
					
					        long diff = secondDate.getTime() - firstDate.getTime();
					         days= Integer.parseInt(""+(diff/86400000));
							}
							
							if((m==4&&y==y1)||(m==6&&y==y1)||(m==9&&y==y1)||(m==11&&y==y1))
									{
										days= (d1-d) + (m1-m)*30;
									}
							else if(m==2&&y!=2020)
							{
								days = (d1-d)+ (m1-m)*28;
							}
							else if(m==2&&y==2020)
							{
								days = (d1-d)+ (m1-m)*29;
							}
							
							amt=rs.getInt(s+"Cost")*num*days;
						}
					}
				}
				catch(Exception ee) {}
				Identification obj=new Identification(Username,num,s,d,m,y,d1,m1,y1,amt, HotelName, fos, oos);
				obj.setVisible(true);
				View.super.dispose();
			}
		});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnNewButton.setBounds(310, 212, 71, 20);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hari2\\Desktop\\infinity-pool-south-tyrol.jpg"));
		lblNewLabel_1.setBounds(-192, 0, 659, 285);
		contentPane.add(lblNewLabel_1);
		
	}
}
