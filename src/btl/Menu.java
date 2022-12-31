package btl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Computer.ComputerGUI;
import Housing.HousingGUI;
import Mobile.MobileGUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static Menu frame = new Menu();
	private List<User> list = new ArrayList<User>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Lựa chọn chức năng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Chương Trình Quản Lý");
		lblNewLabel_1.setForeground(new Color(255, 153, 51));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(155, 39, 303, 57);
		contentPane.add(lblNewLabel_1);
		JButton btnHousingButton = new JButton("Housing");
		btnHousingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Login.checkUser() == 1 || Login.checkUser() == 4) {
					HousingGUI.main(null);
					dispose();
				} 
				else {
					showMessage("Bạn không có quyền truy cập vào chức năng này");
				}
			}
		});
		btnHousingButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHousingButton.setBounds(217, 126, 187, 43);
		contentPane.add(btnHousingButton);

		JButton btnComputerButton = new JButton("Computer");
		btnComputerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Login.checkUser() == 2 || Login.checkUser() == 4) {
					ComputerGUI.main(null);
					dispose();
				} 
				else {
					showMessage("Bạn không có quyền truy cập vào chức năng này");
				}
			}
		});
		btnComputerButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnComputerButton.setBounds(217, 205, 187, 43);
		contentPane.add(btnComputerButton);

		JButton btnMobileButton = new JButton("Mobile");
		btnMobileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Login.checkUser() == 3 || Login.checkUser() == 4) {
					MobileGUI.main(null);
					dispose();
				} 
				else {
					showMessage("Bạn không có quyền truy cập vào chức năng này");
				}
			}
		});
		btnMobileButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMobileButton.setBounds(217, 291, 187, 43);
		contentPane.add(btnMobileButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(52, 81, 45, 13);
		contentPane.add(lblNewLabel);
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
