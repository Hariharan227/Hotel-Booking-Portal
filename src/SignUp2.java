import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class SignUp2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp2 frame = new SignUp2( null, null, null);
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
	public SignUp2(String username,FileOutputStream fos,ObjectOutputStream oos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Personal Information");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(23, 39, 145, 23);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(23, 11, 89, 23);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp obj=new SignUp(fos, oos);
				obj.setVisible(true);
				SignUp2.super.dispose();
			}
		});
		btnPrevious.setForeground(Color.BLUE);
		btnPrevious.setBackground(Color.GRAY);
		btnPrevious.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		contentPane.add(btnPrevious);
		
		textField = new JTextField();
		textField.setBounds(152, 73, 202, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(152, 104, 57, 23);
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
		comboBox_1.setBounds(213, 104, 57, 23);
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
		comboBox_2.setBounds(275, 104, 79, 23);
		comboBox_2.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_2.addItem("YYYY");
		comboBox_2.addItem("1970");
		comboBox_2.addItem("1971");
		comboBox_2.addItem("1972");
		comboBox_2.addItem("1973");
		comboBox_2.addItem("1974");
		comboBox_2.addItem("1975");
		comboBox_2.addItem("1976");
		comboBox_2.addItem("1977");
		comboBox_2.addItem("1978");
		comboBox_2.addItem("1979");
		comboBox_2.addItem("1980");
		comboBox_2.addItem("1981");
		comboBox_2.addItem("1982");
		comboBox_2.addItem("1983");
		comboBox_2.addItem("1984");
		comboBox_2.addItem("1985");
		comboBox_2.addItem("1986");
		comboBox_2.addItem("1987");
		comboBox_2.addItem("1988");
		comboBox_2.addItem("1989");
		comboBox_2.addItem("1990");
		comboBox_2.addItem("1991");
		comboBox_2.addItem("1992");
		comboBox_2.addItem("1993");
		comboBox_2.addItem("1994");
		comboBox_2.addItem("1995");
		comboBox_2.addItem("1996");
		comboBox_2.addItem("1997");
		comboBox_2.addItem("1998");
		comboBox_2.addItem("1999");
		comboBox_2.addItem("2000");
		comboBox_2.addItem("2001");
		comboBox_2.addItem("2002");
		comboBox_2.addItem("2003");
		contentPane.add(comboBox_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 138, 202, 58);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JCheckBox chckbxIAgreeTo = new JCheckBox("I agree to the terms & conditions");
		chckbxIAgreeTo.setForeground(new Color(255, 255, 255));
		chckbxIAgreeTo.setOpaque(false);
		chckbxIAgreeTo.setBounds(6, 218, 264, 23);
		chckbxIAgreeTo.setBackground(new Color(255, 0, 0));
		chckbxIAgreeTo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		contentPane.add(chckbxIAgreeTo);
		
		
		
	    
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(319, 218, 89, 23);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				 if (emailIdValidation(textField.getText())==0)
					{
						JOptionPane.showMessageDialog(contentPane, "Enter Valid email address");
						SignUp2 temp=new SignUp2(username,fos,oos);
						temp.setVisible(true);
						SignUp2.super.dispose();
					}
				 else 
				 {
					 if(textField.getText().equals("")||textField_1.getText().equals(""))
						{
							JOptionPane.showMessageDialog(contentPane, "Input Field(s) cannot be empty");
							SignUp2 temp=new SignUp2(username,fos,oos);
							temp.setVisible(true);
							SignUp2.super.dispose();
						}
									
					else if((((String)comboBox.getSelectedItem()).equals("DD"))||(((String)comboBox_1.getSelectedItem()).equals("MM"))||(((String)comboBox_2.getSelectedItem()).equals("YYYY")))
					{
						JOptionPane.showMessageDialog(contentPane, "Invalid Date of Birth");
						SignUp2 temp=new SignUp2(username,fos,oos);
						temp.setVisible(true);
						SignUp2.super.dispose();
					}
					else
					{
						int d=Integer.parseInt((String)comboBox.getSelectedItem()),m=Integer.parseInt((String)comboBox_1.getSelectedItem()),y=Integer.parseInt((String)comboBox_2.getSelectedItem());
						if(((m==4||m==6||m==9||m==11)&&(d==31))||((m==2)&&((y%4==0&&y%100!=0)||y%400==0)&&(d==30||d==31))||((m==2)&&(y%4!=0)&&(d==29||d==30||d==31)))
						{
							JOptionPane.showMessageDialog(contentPane, "Invalid Date of Birth");
							SignUp2 temp=new SignUp2(username, fos, oos);
							temp.setVisible(true);
							SignUp2.super.dispose();
						}
						else
						{
							if(!(chckbxIAgreeTo.getModel().isSelected()))
							{
								JOptionPane.showMessageDialog(contentPane, "Terms & conditions not agreed.");
								SignUp2 temp=new SignUp2(username, fos, oos);
								temp.setVisible(true);
								SignUp2.super.dispose();
							}
							else
							{
								User u=new User(null,textField_1.getText(),username,null,textField.getText(),d,m,y);
								try
								{
									Connection connect=null;
									connect=UserDatabase.dbConnector();
									String query="Update User set Mail=?,Address=?,DOB_d=?,DOB_m=?,DOB_y=? where Username=?";
									PreparedStatement pst=connect.prepareStatement(query);
									pst.setString(1, u.get_mail());
									pst.setString(2, u.get_address());
									pst.setInt(3, u.DOB.day);
									pst.setInt(4, u.DOB.month);
									pst.setInt(5, u.DOB.year);
									pst.setString(6, u.get_username());
									pst.execute();
									System.out.println("Added");
									pst.close();
								}
								catch(Exception ae) 
								{
									JOptionPane.showMessageDialog(contentPane, ae.toString());
								}
								JOptionPane.showMessageDialog(contentPane, "Successfully Registered!");
								Login obj=new Login(fos,oos);
								obj.setVisible(true);
								SignUp2.super.dispose();
							}
				 }
				    
				    
				 
					}
				}
			}
		});
		btnSignUp.setBackground(Color.GRAY);
		btnSignUp.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		contentPane.add(btnSignUp);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setBounds(85, 75, 65, 14);
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		contentPane.add(lblEmail);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setBounds(62, 107, 95, 14);
		lblDateOfBirth.setForeground(new Color(255, 255, 255));
		lblDateOfBirth.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		contentPane.add(lblDateOfBirth);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(85, 138, 68, 14);
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		contentPane.add(lblAddress);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hari2\\Desktop\\four-points-by-sheraton.jpg"));
		lblNewLabel_1.setBounds(-107, -72, 597, 335);
		contentPane.add(lblNewLabel_1);
		
	}
	  public static int emailIdValidation(String ip) {
		  int i = 0;
		    int b = 0;
		  try
		   {
			
		    StringTokenizer t = new StringTokenizer(ip, "@");
		    String s1 = t.nextToken();
		    String s2 = t.nextToken();
		    StringTokenizer t1 = new StringTokenizer(s2, ".");
		    String s3 = t1.nextToken();
		    String s4 = t1.nextToken();
	  
		   
		    if (ip.contains("@") && ip.contains("."))
		      i++;
		    if (i == 1)
		      if (s3.length() == 5)
		        if (s1.length() >= 3)
		          if (s4.equals("com"))
		            b = 1;
		    System.out.print(b);
		   }
	    catch (Exception ae) {}
		   
		   return b;
	  }
	  
}
