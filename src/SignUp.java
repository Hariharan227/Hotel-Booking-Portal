import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileOutputStream fos = null;
					ObjectOutputStream oos = null;
					SignUp frame = new SignUp(fos,oos);
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
	public SignUp(FileOutputStream fos,ObjectOutputStream oos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSig = new JLabel("Sign Up");
		lblSig.setForeground(new Color(255, 255, 255));
		lblSig.setBounds(62, 11, 73, 23);
		lblSig.setFont(new Font("Calibri", Font.BOLD, 18));
		contentPane.add(lblSig);
		
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(124, 47, 73, 19);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		contentPane.add(lblNewLabel);
		
		JLabel lblMiddleNaee = new JLabel("Middle Name:");
		lblMiddleNaee.setForeground(new Color(255, 255, 255));
		lblMiddleNaee.setBounds(122, 77, 94, 21);
		lblMiddleNaee.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		contentPane.add(lblMiddleNaee);
		
		JLabel lblLastName = new JLabel("  Last Name:");
		lblLastName.setForeground(new Color(255, 255, 255));
		lblLastName.setBounds(123, 106, 74, 17);
		lblLastName.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		contentPane.add(lblLastName);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBounds(124, 134, 73, 14);
		lblUsername.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(124, 159, 75, 19);
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setForeground(new Color(255, 255, 255));
		lblConfirmPassword.setBounds(103, 189, 96, 18);
		lblConfirmPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		contentPane.add(lblConfirmPassword);
		
		textField = new JTextField();
		textField.setBounds(207, 47, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(207, 75, 96, 20);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(207, 103, 96, 20);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(207, 131, 96, 20);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(207, 158, 96, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(207, 187, 96, 20);
		contentPane.add(passwordField_1);

		JButton btnNext = new JButton("Next");
		btnNext.setBounds(304, 229, 74, 23);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||textField_3.getText().equals("")||passwordField.getText().equals("")||passwordField_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(contentPane, "Input Field(s) cannot be empty");
					SignUp obj=new SignUp(fos, oos);
					obj.setVisible(true);
					SignUp.super.dispose();
				}
				else if(!(passwordField.getText().equals(passwordField_1.getText())))
				{
					JOptionPane.showMessageDialog(contentPane, "Password Mismatch");
					SignUp obj=new SignUp(fos, oos);
					obj.setVisible(true);
					SignUp.super.dispose();
				}
				else
				{
					int u=0;
					try
					{
						Connection connect=null;
						connect=UserDatabase.dbConnector();
						Statement ss=connect.createStatement();
						ResultSet rs=ss.executeQuery("select Username from User");
						while(rs.next())
						{
							if(textField_3.getText().equals(rs.getString("Username")))
							{
								u=1;
							}
						}
					}
					catch(Exception ae) {}
					if(u==1)
					{
						JOptionPane.showMessageDialog(contentPane, "Username already exists.");
						SignUp obj=new SignUp(fos, oos);
						obj.setVisible(true);
						SignUp.super.dispose();
					}
					else
					{		
						try
						{
							Connection connect=null;
							connect=UserDatabase.dbConnector();
							String query="insert into User (FirstName,MiddleName,LastName,Username,Password) values (?,?,?,?,?)";
							PreparedStatement pst=connect.prepareStatement(query);
							pst.setString(1, textField.getText());
							pst.setString(2, textField_1.getText());
							pst.setString(3, textField_2.getText());
							pst.setString(4, textField_3.getText());
							pst.setString(5, passwordField.getText());
							pst.execute();
							System.out.println("Added");
							pst.close();
						}
						catch(Exception ee)
						{
							System.out.println(ee.toString());
						}
						SignUp2 obj=new SignUp2(textField_3.getText(),fos,oos);
						obj.setVisible(true);
						SignUp.super.dispose();
					}
				}
			}
		});
		btnNext.setForeground(Color.BLUE);
		btnNext.setBackground(Color.GRAY);
		btnNext.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		contentPane.add(btnNext);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hari2\\Desktop\\arbb_04.jpg"));
		lblNewLabel_1.setBounds(-101, -10, 562, 304);
		contentPane.add(lblNewLabel_1);
	}
}
