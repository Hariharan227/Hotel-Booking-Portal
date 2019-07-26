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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CancelBooking2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelBooking2 frame = new CancelBooking2(null, 0, 0);
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
	public CancelBooking2(String Username , int BookRef ,int amount ) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWillBe = new JLabel("  50% will be charged for this cancellation.");
		lblWillBe.setOpaque(true);
		lblWillBe.setBounds(55, 70, 320, 35);
		lblWillBe.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		contentPane.add(lblWillBe);
		
		JLabel lblDoYouWish = new JLabel(" Do you wish to proceed?");
		lblDoYouWish.setOpaque(true);
		lblDoYouWish.setBounds(122, 96, 191, 35);
		lblDoYouWish.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		contentPane.add(lblDoYouWish);
		
		JButton btnCancel = new JButton("Cancel Cancellation");
		btnCancel.setBounds(48, 189, 125, 43);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserOptions obj=new UserOptions(Username,null,null);
				obj.setVisible(true);
				CancelBooking2.super.dispose();
			}
		});
		contentPane.add(btnCancel);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setBounds(230, 189, 105, 43);
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connect=null;
				connect=UserDatabase.dbConnector();
				try
				{
				JOptionPane.showMessageDialog(contentPane, "Booking Cancelled Successfully! Rs "+ amount/2 +"will be refunded");
				String query="delete from Booking where Username=? and BookRef=?";
				PreparedStatement pst=connect.prepareStatement(query);
				pst.setString(1, Username);
				pst.setInt(2, BookRef);
				pst.execute();
				pst.close();
				UserOptions obj=new UserOptions(Username, null, null);
				obj.setVisible(true);
				CancelBooking2.super.dispose();
			}
				catch (Exception ee) {}
			}
			
		});
		contentPane.add(btnProceed);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hari2\\Desktop\\corinthia-hotel-tripoli-lobby.jpg"));
		lblNewLabel.setBounds(-203, 0, 657, 354);
		contentPane.add(lblNewLabel);
	}

}
