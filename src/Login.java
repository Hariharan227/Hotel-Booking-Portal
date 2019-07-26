import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileOutputStream fos=new FileOutputStream("User",true);
					ObjectOutputStream oos=new ObjectOutputStream(fos);
					Login frame = new Login(fos,oos);
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
	public Login(FileOutputStream fos,ObjectOutputStream oos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblRaah = new JLabel(" Book My Trip");
		lblRaah.setForeground(Color.WHITE);
		lblRaah.setFont(new Font("Times New Roman", Font.BOLD, 31));
		lblRaah.setBounds(161, 11, 221, 48);
		contentPane.add(lblRaah);
		
		JLabel lblUsername = new JLabel(" Username:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblUsername.setBounds(117, 95, 80, 21);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel(" Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblPassword.setBounds(117, 130, 80, 21);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(237, 97, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(237, 132, 96, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=textField.getText(),b=passwordField.getText();
				int u=0;
				try
				{
					Connection connect=null;
					connect=UserDatabase.dbConnector();
					Statement ss=connect.createStatement();
					ResultSet rs=ss.executeQuery("select Username,Password from User");
					while(rs.next())
					{
						if(rs.getString("Username").equals(a)&&rs.getString("Password").equals(b))
						{
							u=1;
						}
					}
				}
				catch(Exception ae) {}
				if(u==1)
				{
					try
					{
						Connection connect=null;
						int rowid=100,d=0,m=0,y=0,d1=0,m1=0,y1=0,num=0;
						String Username="",Location = "",s = "";
						connect=UserDatabase.dbConnector();
						Statement ss=connect.createStatement();
						ResultSet rs=ss.executeQuery("select * from WaitingList ORDER BY rowid ASC");
						if(rs.next())
						{	
							Username=rs.getString("Username");
							Location=rs.getString("Location");
							s=rs.getString("RoomType");
							d=rs.getInt("In_d");
							m=rs.getInt("In_m");
							y=rs.getInt("In_y");
							d1=rs.getInt("Out_d");
							m1=rs.getInt("Out_m");
							y1=rs.getInt("Out_y");
							num=rs.getInt("NoOfRooms");	
						}
						Vector<String> opt = new Vector<String>();
						Vector<String> temp=new Vector<String>();
						int ct=0;
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
						rs=ss.executeQuery("select HotelName,Location from Hotel");
						while(rs.next())
						{
							if(Location.equals(rs.getString("Location")))
							{
								temp.add(rs.getString("HotelName"));
							}
						}
						rs=ss.executeQuery("select * from Booking");
						int d2,m2,y2;
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
						if(temp.size()!=0)
						{
							for(int i=0;i<3;i++)
							{
								if(vis[i]+num<=ct)
								{
									System.out.println(""+(vis[i]+num)+" "+ct);
									opt.add(temp.get(i));
								}
							}
						}
						if(opt.size()==0||(!a.equals(Username)))
						{
							UserOptions obj=new UserOptions(a,fos, oos);
							obj.setVisible(true);
							Login.super.dispose();
						}
						else
						{
							try
							{
								String query="delete from WaitingList where Username=? and Location=? and RoomType=? and NoOfRooms=? and In_d=? and In_m=? and In_y=? and Out_d=? and Out_m=? and Out_y=?";
								PreparedStatement pst=connect.prepareStatement(query);
								pst.setString(1, Username);
								pst.setString(2, Location);
								pst.setString(3, s);
								pst.setInt(4, num);
								pst.setInt(5, d);
								pst.setInt(6, m);
								pst.setInt(7, y);
								pst.setInt(8, d1);
								pst.setInt(9, m1);
								pst.setInt(10, y1);
								pst.execute();
								pst.close();
							}
							catch(Exception eee) {}
							JOptionPane.showMessageDialog(contentPane, "Rooms available for your waiting list entry. Click OK to redirect to the hotel options available.");
							HotelOptions obj=new HotelOptions(a,num,opt,s,d,m,y,d1,m1,y1,fos, oos);
							obj.setVisible(true);
							Login.super.dispose();
						}
					}
					catch(Exception ee) {System.out.println(e.toString());}
				}
				else
				{
					JOptionPane.showMessageDialog(contentPane, "Invalid username or password");
					Login obj=new Login(fos,oos);
					obj.setVisible(true);
					Login.super.dispose();
				}
			}
		});
		btnLogin.setBackground(Color.GRAY);
		btnLogin.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnLogin.setBounds(180, 167, 68, 21);
		contentPane.add(btnLogin);
		
		JLabel lblNewUser = new JLabel("New User?");
		lblNewUser.setForeground(new Color(255, 255, 255));
		lblNewUser.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewUser.setBounds(120, 213, 105, 21);
		contentPane.add(lblNewUser);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp obj=new SignUp(fos,oos);
				obj.setVisible(true);
				Login.super.dispose();
			}
		});
		btnSignUp.setBackground(Color.GRAY);
		btnSignUp.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		btnSignUp.setBounds(198, 212, 96, 23);
		contentPane.add(btnSignUp);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hari2\\Desktop\\arbb_04.jpg"));
		lblNewLabel.setBounds(0, 0, 446, 263);
		contentPane.add(lblNewLabel);
		
	}
}
