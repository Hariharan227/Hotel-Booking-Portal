import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class UserOptions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserOptions frame = new UserOptions(null, null, null);
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
	public UserOptions(String Username, FileOutputStream fos,ObjectOutputStream oos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewBooking = new JButton("New Booking");
		btnNewBooking.setBounds(120, 57, 170, 28);
		btnNewBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewBooking obj=new NewBooking(Username,fos, oos);
				obj.setVisible(true);
				UserOptions.super.dispose();
			}
		});
		contentPane.setLayout(null);
		btnNewBooking.setForeground(new Color(0, 0, 0));
		btnNewBooking.setBackground(Color.WHITE);
		btnNewBooking.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		contentPane.add(btnNewBooking);
		
		JButton btnCancelBooking = new JButton("Cancel Booking");
		btnCancelBooking.setBounds(120, 111, 170, 28);
		btnCancelBooking.setForeground(new Color(0, 0, 0));
		btnCancelBooking.setBackground(Color.WHITE);
		btnCancelBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelBooking obj=new CancelBooking(Username);
				obj.setVisible(true);
				UserOptions.super.dispose();
			}
		});
		btnCancelBooking.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		contentPane.add(btnCancelBooking);
		
		JButton btnModifyBooking = new JButton("Modify Booking");
		btnModifyBooking.setBounds(120, 165, 170, 28);
		btnModifyBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyBooking obj=new ModifyBooking(Username);
				obj.setVisible(true);
				UserOptions.super.dispose();
			}
		});
		btnModifyBooking.setForeground(new Color(0, 0, 0));
		btnModifyBooking.setBackground(Color.WHITE);
		btnModifyBooking.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
		contentPane.add(btnModifyBooking);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(323, 224, 91, 28);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login obj=new Login(null, null);
				obj.setVisible(true);
				UserOptions.super.dispose();
			}
		});
		btnLogout.setForeground(new Color(0, 0, 0));
		btnLogout.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btnLogout.setBackground(Color.GRAY);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hari2\\Desktop\\grand-hotel-may4360.jpg"));
		lblNewLabel.setBounds(-42, -81, 478, 344);
		contentPane.add(lblNewLabel);
	}
}
