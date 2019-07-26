import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HotelInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//super(cost,total,amenity1,amenity2,amenity3,amenity4,amenity5,amenity6,rating,raters);
						FileOutputStream fo=new FileOutputStream("Hotel Data",true);
						ObjectOutputStream oo=new ObjectOutputStream(fo);
					HotelInfo frame = new HotelInfo(fo,oo);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param oo 
	 * @param fo 
	 */
	public HotelInfo(FileOutputStream fo, ObjectOutputStream oo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(31, 24, 153, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(31, 55, 153, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(31, 86, 153, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(31, 113, 153, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(31, 144, 153, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(31, 172, 153, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(31, 199, 153, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(31, 230, 153, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(240, 24, 153, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(240, 55, 153, 20);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(240, 86, 153, 20);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(240, 113, 153, 20);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(240, 144, 153, 20);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(240, 172, 153, 20);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(240, 199, 153, 20);
		contentPane.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(240, 230, 153, 20);
		contentPane.add(textField_15);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingleRoom s=new SingleRoom(Integer.parseInt(textField_2.getText()),Integer.parseInt(textField_3.getText()),textField_8.getText(),textField_9.getText(),textField_10.getText(),textField_11.getText(),textField_12.getText(),textField_13.getText(),Double.parseDouble(textField_14.getText()),Integer.parseInt(textField_15.getText()));
				DoubleRoom m=new DoubleRoom(Integer.parseInt(textField_4.getText()),Integer.parseInt(textField_5.getText()),textField_8.getText(),textField_9.getText(),textField_10.getText(),textField_11.getText(),textField_12.getText(),textField_13.getText(),Double.parseDouble(textField_14.getText()),Integer.parseInt(textField_15.getText()));
				FamilyRoom l=new FamilyRoom(Integer.parseInt(textField_6.getText()),Integer.parseInt(textField_7.getText()),textField_8.getText(),textField_9.getText(),textField_10.getText(),textField_11.getText(),textField_12.getText(),textField_13.getText(),Double.parseDouble(textField_14.getText()),Integer.parseInt(textField_15.getText()));
				Hotel h=new Hotel(textField.getText(),textField_1.getText(),s,m,l);
				try {
					oo.writeObject(h);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.toString());
				}
				HotelInfo obj=new HotelInfo(fo, oo);
				obj.setVisible(true);
				HotelInfo.super.dispose();
			}
		});
		btnNewButton.setBounds(194, 240, 32, 23);
		contentPane.add(btnNewButton);
	}
}
