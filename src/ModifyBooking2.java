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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ModifyBooking2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyBooking2 frame = new ModifyBooking2(null,0);
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
	public ModifyBooking2(String Username, int BookRef) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewCheckIn = new JLabel("  New Check In:");
		lblNewCheckIn.setOpaque(true);
		lblNewCheckIn.setBounds(48, 68, 108, 22);
		lblNewCheckIn.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		contentPane.add(lblNewCheckIn);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(180, 66, 43, 22);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox.addItem("DD");
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		comboBox.addItem("10");
		comboBox.addItem("11");
		comboBox.addItem("12");
		comboBox.addItem("13");
		comboBox.addItem("14");
		comboBox.addItem("15");
		comboBox.addItem("16");
		comboBox.addItem("17");
		comboBox.addItem("18");
		comboBox.addItem("19");
		comboBox.addItem("20");
		comboBox.addItem("21");
		comboBox.addItem("22");
		comboBox.addItem("23");
		comboBox.addItem("24");
		comboBox.addItem("25");
		comboBox.addItem("26");
		comboBox.addItem("27");
		comboBox.addItem("28");
		comboBox.addItem("29");
		comboBox.addItem("30");
		comboBox.addItem("31");
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(228, 66, 54, 22);
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_1.addItem("MM");
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
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(285, 66, 61, 22);
		comboBox_2.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_2.addItem("YYYY");
		comboBox_2.addItem("2018");
		comboBox_2.addItem("2019");
		comboBox_2.addItem("2020");
		comboBox_2.addItem("2021");
		contentPane.add(comboBox_2);
		
		JLabel lblNewCheckOut = new JLabel("  New Check Out:");
		lblNewCheckOut.setOpaque(true);
		lblNewCheckOut.setBounds(48, 112, 108, 20);
		lblNewCheckOut.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		contentPane.add(lblNewCheckOut);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(180, 113, 43, 22);
		comboBox_3.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_3.addItem("DD");
		comboBox_3.addItem("1");
		comboBox_3.addItem("2");
		comboBox_3.addItem("3");
		comboBox_3.addItem("4");
		comboBox_3.addItem("5");
		comboBox_3.addItem("6");
		comboBox_3.addItem("7");
		comboBox_3.addItem("8");
		comboBox_3.addItem("9");
		comboBox_3.addItem("10");
		comboBox_3.addItem("11");
		comboBox_3.addItem("12");
		comboBox_3.addItem("13");
		comboBox_3.addItem("14");
		comboBox_3.addItem("15");
		comboBox_3.addItem("16");
		comboBox_3.addItem("17");
		comboBox_3.addItem("18");
		comboBox_3.addItem("19");
		comboBox_3.addItem("20");
		comboBox_3.addItem("21");
		comboBox_3.addItem("22");
		comboBox_3.addItem("23");
		comboBox_3.addItem("24");
		comboBox_3.addItem("25");
		comboBox_3.addItem("26");
		comboBox_3.addItem("27");
		comboBox_3.addItem("28");
		comboBox_3.addItem("29");
		comboBox_3.addItem("30");
		comboBox_3.addItem("31");
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(228, 113, 54, 22);
		comboBox_4.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_4.addItem("MM");
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
		contentPane.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(285, 113, 61, 22);
		comboBox_5.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_5.addItem("YYYY");
		comboBox_5.addItem("2018");
		comboBox_5.addItem("2019");
		comboBox_5.addItem("2020");
		comboBox_5.addItem("2021");
		contentPane.add(comboBox_5);
		
		JButton btnCheckAvailability = new JButton("Check Availability");
		btnCheckAvailability.setBounds(127, 176, 169, 22);
		btnCheckAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection connect=null;
					int rowid=100;
					int num=0;
					if((((String)comboBox.getSelectedItem()).equals("DD"))||(((String)comboBox_1.getSelectedItem()).equals("MM"))||(((String)comboBox_2.getSelectedItem()).equals("YYYY"))||(((String)comboBox_3.getSelectedItem()).equals("DD"))||(((String)comboBox_4.getSelectedItem()).equals("MM"))||(((String)comboBox_5.getSelectedItem()).equals("YYYY")))
					{
						JOptionPane.showMessageDialog(contentPane, "Invalid Date");
						ModifyBooking2 obj=new ModifyBooking2(Username,BookRef);
						obj.setVisible(true);
						ModifyBooking2.super.dispose();
					}
					else
					{
						int d=Integer.parseInt((String)comboBox.getSelectedItem());
						int m=Integer.parseInt((String)comboBox_1.getSelectedItem());
						int y=Integer.parseInt((String)comboBox_2.getSelectedItem());
						int d_1=Integer.parseInt((String)comboBox_3.getSelectedItem());
						int m_1=Integer.parseInt((String)comboBox_4.getSelectedItem());
						int y_1=Integer.parseInt((String)comboBox_5.getSelectedItem());
						if(((m==4||m==6||m==9||m==11)&&(d==31))||((m==2)&&((y%4==0&&y%100!=0)||y%400==0)&&(d==30||d==31))||((m==2)&&(y%4!=0)&&(d==29||d==30||d==31))||((m_1==4||m_1==6||m_1==9||m_1==11)&&(d_1==31))||((m_1==2)&&((y_1%4==0&&y_1%100!=0)||y_1%400==0)&&(d_1==30||d_1==31))||((m_1==2)&&(y_1%4!=0)&&(d_1==29||d_1==30||d_1==31)))
						{
							JOptionPane.showMessageDialog(contentPane, "Invalid Date");
							ModifyBooking2 obj=new ModifyBooking2(Username,BookRef);
							obj.setVisible(true);
							ModifyBooking2.super.dispose();
						}
					}
					if(!(((String)comboBox.getSelectedItem()).equals("DD"))||(((String)comboBox_1.getSelectedItem()).equals("MM"))||(((String)comboBox_2.getSelectedItem()).equals("YYYY"))||(((String)comboBox_3.getSelectedItem()).equals("DD"))||(((String)comboBox_4.getSelectedItem()).equals("MM"))||(((String)comboBox_5.getSelectedItem()).equals("YYYY")))
					{
					int d=Integer.parseInt((String)comboBox.getSelectedItem());
					int m=Integer.parseInt((String)comboBox_1.getSelectedItem());
					int y=Integer.parseInt((String)comboBox_2.getSelectedItem());
					int d1=Integer.parseInt((String)comboBox_3.getSelectedItem());
					int m1=Integer.parseInt((String)comboBox_4.getSelectedItem());
					int y1=Integer.parseInt((String)comboBox_5.getSelectedItem());
					if((y>y1)||((y==y1)&&(m>m1))||((y==y1)&&(m==m1)&&(d>=d1)))
					{
						JOptionPane.showMessageDialog(contentPane, "Invalid Dates");
						ModifyBooking2 obj=new ModifyBooking2(Username,BookRef);
						obj.setVisible(true);
						ModifyBooking2.super.dispose();
					}
					
					else
					{
					DateTimeFormatter dff= DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDateTime now = LocalDateTime.now();
					String date=dff.format(now);
					int curr_d=(10*Integer.parseInt(""+date.charAt(0))+Integer.parseInt(""+date.charAt(1)));
					int curr_m=(10*Integer.parseInt(""+date.charAt(3))+Integer.parseInt(""+date.charAt(4)));
					int curr_y=(1000*Integer.parseInt(""+date.charAt(6))+100*Integer.parseInt(""+date.charAt(7))+10*Integer.parseInt(""+date.charAt(8))+Integer.parseInt(""+date.charAt(9)));	
					
					String Username="",Location = "",s = "",temp="";
					int ind=0,inm=0,iny=0;
					connect=UserDatabase.dbConnector();
					Statement ss=connect.createStatement();
					ResultSet rs=ss.executeQuery("select * from Booking where BookRef="+BookRef);
		
					ind=rs.getInt("In_d");
					inm=rs.getInt("In_m");
					iny=rs.getInt("In_y");
					temp=rs.getString("HotelName");
					s=rs.getString("RoomType");
					num=rs.getInt("NoOfRooms");
					Vector<String> opt = new Vector<String>();
					int ct=0;
					
					if(!((inm==curr_m && iny==curr_y && (ind-curr_d)>=3)|| (inm>curr_m && iny==curr_y)||(iny>curr_y))) {
						JOptionPane.showMessageDialog(contentPane, "Modification within 3 days before Check-in not possible");
						UserOptions obj= new UserOptions(Username,null,null);
						obj.setVisible(true);
						ModifyBooking2.super.dispose();
					}
					else
					{
					if(s.equals("SingleRoom"))
					{
						ct=10;
					}
					else if(s.equals("DoubleRoom"))
					{
						ct=7;
					}
					else if(s.equals("FamilyRoom"))
					{
						ct=5;
					}
					rs=ss.executeQuery("select * from Booking");
					int d2,m2,y2,vis=0;
					while(rs.next())
					{
						if(rs.getInt("BookRef")!=BookRef)
						{
							d2=rs.getInt("In_d");
							m2=rs.getInt("In_m");
							y2=rs.getInt("In_y");
							if(((y2>y)||((y2==y)&&(m2>m))||((y2==y)&&(m2==m)&&(d2>=d)))&&((y1>y2)||((y1==y2)&&(m1>m2))||((y1==y2)&&(m1==m2)&&(d1>=d2))))
							{
								if((temp.equals(rs.getString("HotelName"))&&(s.equals(rs.getString("RoomType")))))
								{
									vis+=rs.getInt("NoOfRooms");
								}
								continue;
							}
							d2=rs.getInt("Out_d");
							m2=rs.getInt("Out_m");
							y2=rs.getInt("Out_y");
							if(((y2>y)||((y2==y)&&(m2>m))||((y2==y)&&(m2==m)&&(d2>=d)))&&((y1>y2)||((y1==y2)&&(m1>m2))||((y1==y2)&&(m1==m2)&&(d1>=d2))))
							{
								if((temp.equals(rs.getString("HotelName"))&&(s.equals(rs.getString("RoomType")))))
								{
									vis+=rs.getInt("NoOfRooms");
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
								if((temp.equals(rs.getString("HotelName"))&&(s.equals(rs.getString("RoomType")))))
								{
									vis+=rs.getInt("NoOfRooms");
								}
							}
						}
					}
					if(vis+num<=ct)
					{
						System.out.println(""+(vis+num)+" "+ct);
						opt.add(temp);
					}
					if(opt.size()==0)
					{
						JOptionPane.showMessageDialog(contentPane, "Rooms not available for new dates");
						ModifyBooking2 obj=new ModifyBooking2(Username,BookRef);
						obj.setVisible(true);
						ModifyBooking2.super.dispose();
					}
					else
					{
						try
						{
							String query="Update Booking set In_d=?,In_m=?,In_y=?,Out_d=?,Out_m=?,Out_y=? where BookRef=?";
							PreparedStatement pst=connect.prepareStatement(query);
							pst.setInt(1, d);
							pst.setInt(2, m);
							pst.setInt(3, y);
							pst.setInt(4, d1);
							pst.setInt(5, m1);
							pst.setInt(6, y1);
							pst.setInt(7, BookRef);
							pst.execute();
							pst.close();
						}
						catch(Exception eee) {}
						JOptionPane.showMessageDialog(contentPane, "Modified Successfully");
						Login obj=new Login(null, null);
						obj.setVisible(true);
						ModifyBooking2.super.dispose();
					}
				}
				}
				}
				}
				catch(Exception ee) {}
			}
		});
		btnCheckAvailability.setForeground(new Color(0, 0, 0));
		btnCheckAvailability.setBackground(Color.GRAY);
		btnCheckAvailability.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(btnCheckAvailability);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hari2\\Desktop\\hqdefault.jpg"));
		lblNewLabel.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel);
	}
}
