import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class NewBooking extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBooking frame = new NewBooking(null, null, null);
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
	public NewBooking(String Username, FileOutputStream fos,ObjectOutputStream oos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox.addItem("Location");
		comboBox.addItem("Goa");
		comboBox.addItem("Mumbai");
		comboBox.addItem("Hyderabad");
		comboBox.addItem("New Delhi");
		comboBox.addItem("Chennai");
		comboBox.setBounds(142, 39, 166, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_1.addItem("DD");
		comboBox_1.addItem("1");
		comboBox_1.addItem("2");
		comboBox_1.addItem("3");
		comboBox_1.addItem("4");
		comboBox_1.addItem("5");
		comboBox_1.addItem("6");
		comboBox_1.addItem("7");
		comboBox_1.addItem("8");
		comboBox_1.addItem("9");
		comboBox_1.addItem("10");
		comboBox_1.addItem("11");
		comboBox_1.addItem("12");
		comboBox_1.addItem("13");
		comboBox_1.addItem("14");
		comboBox_1.addItem("15");
		comboBox_1.addItem("16");
		comboBox_1.addItem("17");
		comboBox_1.addItem("18");
		comboBox_1.addItem("19");
		comboBox_1.addItem("20");
		comboBox_1.addItem("21");
		comboBox_1.addItem("22");
		comboBox_1.addItem("23");
		comboBox_1.addItem("24");
		comboBox_1.addItem("25");
		comboBox_1.addItem("26");
		comboBox_1.addItem("27");
		comboBox_1.addItem("28");
		comboBox_1.addItem("29");
		comboBox_1.addItem("30");
		comboBox_1.addItem("31");
		comboBox_1.setBounds(142, 85, 43, 22);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_2.addItem("MM");
		comboBox_2.addItem("1");
		comboBox_2.addItem("2");
		comboBox_2.addItem("3");
		comboBox_2.addItem("4");
		comboBox_2.addItem("5");
		comboBox_2.addItem("6");
		comboBox_2.addItem("7");
		comboBox_2.addItem("8");
		comboBox_2.addItem("9");
		comboBox_2.addItem("10");
		comboBox_2.addItem("11");
		comboBox_2.addItem("12");
		comboBox_2.setBounds(190, 85, 54, 22);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_3.addItem("YYYY");
		comboBox_3.addItem("2018");
		comboBox_3.addItem("2019");
		comboBox_3.addItem("2020");
		comboBox_3.addItem("2021");
		comboBox_3.setBounds(247, 85, 61, 22);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_4.addItem("DD");
		comboBox_4.addItem("1");
		comboBox_4.addItem("2");
		comboBox_4.addItem("3");
		comboBox_4.addItem("4");
		comboBox_4.addItem("5");
		comboBox_4.addItem("6");
		comboBox_4.addItem("7");
		comboBox_4.addItem("8");
		comboBox_4.addItem("9");
		comboBox_4.addItem("10");
		comboBox_4.addItem("11");
		comboBox_4.addItem("12");
		comboBox_4.addItem("13");
		comboBox_4.addItem("14");
		comboBox_4.addItem("15");
		comboBox_4.addItem("16");
		comboBox_4.addItem("17");
		comboBox_4.addItem("18");
		comboBox_4.addItem("19");
		comboBox_4.addItem("20");
		comboBox_4.addItem("21");
		comboBox_4.addItem("22");
		comboBox_4.addItem("23");
		comboBox_4.addItem("24");
		comboBox_4.addItem("25");
		comboBox_4.addItem("26");
		comboBox_4.addItem("27");
		comboBox_4.addItem("28");
		comboBox_4.addItem("29");
		comboBox_4.addItem("30");
		comboBox_4.addItem("31");
		comboBox_4.setBounds(142, 132, 43, 22);
		contentPane.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_5.addItem("MM");
		comboBox_5.addItem("1");
		comboBox_5.addItem("2");
		comboBox_5.addItem("3");
		comboBox_5.addItem("4");
		comboBox_5.addItem("5");
		comboBox_5.addItem("6");
		comboBox_5.addItem("7");
		comboBox_5.addItem("8");
		comboBox_5.addItem("9");
		comboBox_5.addItem("10");
		comboBox_5.addItem("11");
		comboBox_5.addItem("12");
		comboBox_5.setBounds(190, 132, 54, 22);
		contentPane.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_6.addItem("YYYY");
		comboBox_6.addItem("2018");
		comboBox_6.addItem("2019");
		comboBox_6.addItem("2020");
		comboBox_6.addItem("2021");
		comboBox_6.setBounds(247, 132, 61, 22);
		contentPane.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_7.addItem("No. of Rooms");
		comboBox_7.addItem("1");
		comboBox_7.addItem("2");
		comboBox_7.addItem("3");
		comboBox_7.addItem("4");
		comboBox_7.addItem("5");
		comboBox_7.setBounds(43, 181, 156, 22);
		contentPane.add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_8.addItem("Type of Room");
		comboBox_8.addItem("Single Room");
		comboBox_8.addItem("Double Room");
		comboBox_8.addItem("Family Room");
		comboBox_8.setBounds(223, 181, 156, 22);
		contentPane.add(comboBox_8);
		
		JLabel lblCheckIn = new JLabel("Check In:");
		lblCheckIn.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblCheckIn.setBounds(82, 89, 61, 14);
		contentPane.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("Check Out:");
		lblCheckOut.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblCheckOut.setBounds(71, 136, 72, 14);
		contentPane.add(lblCheckOut);
		
		JButton btnShowRooms = new JButton("Show Rooms");
		btnShowRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((((String)comboBox.getSelectedItem()).equals("Location"))||(((String)comboBox_7.getSelectedItem()).equals("No. of Rooms"))||(((String)comboBox_8.getSelectedItem()).equals("Type of Room")))
				{
					JOptionPane.showMessageDialog(contentPane, "Invalid Input(s)");
					NewBooking temp=new NewBooking(Username,fos,oos);
					temp.setVisible(true);
					NewBooking.super.dispose();
				}
				else
				{
				if((((String)comboBox_1.getSelectedItem()).equals("DD"))||(((String)comboBox_2.getSelectedItem()).equals("MM"))||(((String)comboBox_3.getSelectedItem()).equals("YYYY"))||(((String)comboBox_4.getSelectedItem()).equals("DD"))||(((String)comboBox_5.getSelectedItem()).equals("MM"))||(((String)comboBox_6.getSelectedItem()).equals("YYYY")))
				{
					JOptionPane.showMessageDialog(contentPane, "Invalid Date");
					NewBooking temp=new NewBooking(Username,fos,oos);
					temp.setVisible(true);
					NewBooking.super.dispose();
				}
				else
				{
					int d=Integer.parseInt((String)comboBox_1.getSelectedItem()),m=Integer.parseInt((String)comboBox_2.getSelectedItem()),y=Integer.parseInt((String)comboBox_3.getSelectedItem());
					int d_1=Integer.parseInt((String)comboBox_4.getSelectedItem()),m_1=Integer.parseInt((String)comboBox_5.getSelectedItem()),y_1=Integer.parseInt((String)comboBox_6.getSelectedItem());
					if(((m==4||m==6||m==9||m==11)&&(d==31))||((m==2)&&((y%4==0&&y%100!=0)||y%400==0)&&(d==30||d==31))||((m==2)&&(y%4!=0)&&(d==29||d==30||d==31))||((m_1==4||m_1==6||m_1==9||m_1==11)&&(d_1==31))||((m_1==2)&&((y_1%4==0&&y_1%100!=0)||y_1%400==0)&&(d_1==30||d_1==31))||((m_1==2)&&(y_1%4!=0)&&(d_1==29||d_1==30||d_1==31)))
					{
						JOptionPane.showMessageDialog(contentPane, "Invalid Date");
						NewBooking temp=new NewBooking(Username,fos,oos);
						temp.setVisible(true);
						NewBooking.super.dispose();
					}
				}
				if(!((((String)comboBox_1.getSelectedItem()).equals("DD"))||(((String)comboBox_2.getSelectedItem()).equals("MM"))||(((String)comboBox_3.getSelectedItem()).equals("YYYY"))||(((String)comboBox_4.getSelectedItem()).equals("DD"))||(((String)comboBox_5.getSelectedItem()).equals("MM"))||(((String)comboBox_6.getSelectedItem()).equals("YYYY"))))
				{
				int d=Integer.parseInt((String)comboBox_1.getSelectedItem()),m=Integer.parseInt((String)comboBox_2.getSelectedItem()),y=Integer.parseInt((String)comboBox_3.getSelectedItem());
				int d1=Integer.parseInt((String)comboBox_4.getSelectedItem()),m1=Integer.parseInt((String)comboBox_5.getSelectedItem()),y1=Integer.parseInt((String)comboBox_6.getSelectedItem());
				if((y>y1)||((y==y1)&&(m>m1))||((y==y1)&&(m==m1)&&(d>=d1)))
				{
					JOptionPane.showMessageDialog(contentPane, "Invalid Dates");
					NewBooking temp=new NewBooking(Username,fos,oos);
					temp.setVisible(true);
					NewBooking.super.dispose();
				}
				else
				{
					Vector<String> opt = new Vector<String>();
					String s="";
					int num=Integer.parseInt((String)comboBox_7.getSelectedItem());
					try
					{
						FileInputStream f=new FileInputStream("Hotel Data");
						ObjectInputStream o=new ObjectInputStream(f);
						Connection connect=null;
						connect=UserDatabase.dbConnector();
						Statement ss=connect.createStatement();
						ResultSet rs=ss.executeQuery("select HotelName,Location from Hotel");
						int d2,m2,y2,ct=0;
						Vector<String> temp=new Vector<String>();
						if(((String)comboBox_8.getSelectedItem()).equals("Single Room"))
						{
							s="SingleRoom";
							ct=10;
						}
						else if(((String)comboBox_8.getSelectedItem()).equals("Double Room"))
						{
							s="DoubleRoom";
							ct=7;
						}
						else if(((String)comboBox_8.getSelectedItem()).equals("Family Room"))
						{
							s="FamilyRoom";
							ct=5;
						}
						else
						{
							JOptionPane.showMessageDialog(contentPane, "Invalid Room Type");
							NewBooking obj=new NewBooking(Username,fos,oos);
							obj.setVisible(true);
							NewBooking.super.dispose();
						}
						while(rs.next())
						{
							if(((String)comboBox.getSelectedItem()).equals(rs.getString("Location")))
							{
								temp.add(rs.getString("HotelName"));
							}
						}
						rs=ss.executeQuery("select * from Booking");
						int[] vis=new int[3];
						vis[0]=0;
						vis[1]=0;
						vis[2]=0;
						while(rs.next())
						{
							d2=rs.getInt("In_d");
							m2=rs.getInt("In_m");
							y2=rs.getInt("In_y");
							if(((y2>y)||((y2==y)&&(m2>m))||((y2==y)&&(m2==m)&&(d2>=d)))&&((y1>y2)||((y1==y2)&&(m1>m2))||((y1==y2)&&(m1==m2)&&(d1>=d2))))
							{
								for(int i=0;i<3;i++)
								{
									if((temp.get(i).equals(rs.getString("HotelName"))&&(s.equals(rs.getString("RoomType")))))
									{
										vis[i]+=rs.getInt("NoOfRooms");
									}
								}
								continue;
							}
							d2=rs.getInt("Out_d");
							m2=rs.getInt("Out_m");
							y2=rs.getInt("Out_y");
							if(((y2>y)||((y2==y)&&(m2>m))||((y2==y)&&(m2==m)&&(d2>=d)))&&((y1>y2)||((y1==y2)&&(m1>m2))||((y1==y2)&&(m1==m2)&&(d1>=d2))))
							{
								for(int i=0;i<3;i++)
								{
									if((temp.get(i).equals(rs.getString("HotelName"))&&(s.equals(rs.getString("RoomType")))))
									{
										vis[i]+=rs.getInt("NoOfRooms");
									}
								}
								continue;
							}
							d2=rs.getInt("In_d");
							m2=rs.getInt("In_m");
							y2=rs.getInt("In_y");
							int d3=rs.getInt("Out_d");
							int m3=rs.getInt("Out_m");
							int y3=rs.getInt("Out_y");
							if(((y>y2)||((y==y2)&&(m>m2))||((y==y2)&&(m==m2)&&(d>=d2)))&&((y3>y1)||((y3==y1)&&(m3>m1))||((y3==y1)&&(m3==m1)&&(d3>=d1))))
							{
								for(int i=0;i<3;i++)
								{
									if((temp.get(i).equals(rs.getString("HotelName"))&&(s.equals(rs.getString("RoomType")))))
									{
										vis[i]+=rs.getInt("NoOfRooms");
									}
								}
							}
						}
						for(int i=0;i<3;i++)
						{
							if(vis[i]+num<=ct)
							{
								System.out.println(""+(vis[i]+num)+" "+ct);
								opt.add(temp.get(i));
							}
						}	
						}
					
					catch(Exception ae) {}
					if(opt.size()==0)
					{
						NoRoom obj=new NoRoom(Username,(String)comboBox.getSelectedItem(),num,s,d,m,y,d1,m1,y1, fos, oos);
						obj.setVisible(true);
						NewBooking.super.dispose();
					}
					else
					{
						HotelOptions obj=new HotelOptions(Username,num,opt,s,d,m,y,d1,m1,y1, fos, oos);
						obj.setVisible(true);
						NewBooking.super.dispose();
					}
				}
			}}}
		});
		btnShowRooms.setForeground(Color.BLUE);
		btnShowRooms.setBackground(Color.GRAY);
		btnShowRooms.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnShowRooms.setBounds(259, 229, 120, 23);
		contentPane.add(btnShowRooms);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserOptions obj=new UserOptions(Username,fos, oos);
				obj.setVisible(true);
				NewBooking.super.dispose();
			}
		});
		btnCancel.setForeground(Color.BLUE);
		btnCancel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnCancel.setBackground(Color.GRAY);
		btnCancel.setBounds(43, 231, 120, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hari2\\Desktop\\destinations-dubai-attractions-hero.jpg"));
		lblNewLabel.setBounds(-466, -11, 1002, 292);
		contentPane.add(lblNewLabel);
	}
}
