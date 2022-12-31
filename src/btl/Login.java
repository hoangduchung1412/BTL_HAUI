package btl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTextField textFieldName;
	private static JPasswordField passwordField; 
	static Login frame = new Login();
	private List<User> list = new ArrayList<>();
	private int n;

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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\java_thuc_hanh\\logo.png"));
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UserManager usm = new UserManager();
		list = usm.create();
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkUser() != 0) {
					Menu.main(null);
					dispose();
					return;
				} else {
					JOptionPane.showMessageDialog(contentPane, "tài khoản hoặc mật khẩu không đúng!");
					return;
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(81, 227, 138, 42);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Tài khoản:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(32, 111, 100, 28);
		contentPane.add(lblNewLabel);

		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMtKhu.setBounds(32, 164, 100, 28);
		contentPane.add(lblMtKhu);

		textFieldName = new JTextField();
		textFieldName.setBounds(179, 114, 182, 28);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Đăng nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(139, 43, 207, 48);
		contentPane.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(179, 167, 182, 28);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(283, 227, 138, 42);
		contentPane.add(btnNewButton_1);
	}

//	public void showMessage(String message) {
//		JOptionPane.showMessageDialog(this, message);
//	}
	
	public static int checkUser() {
		int n = 0;
		String name = textFieldName.getText();
		String password = String.copyValueOf(passwordField.getPassword());
			if ( name != null && password  != null) {
				if (name.equals("Do Khanh Vinh")) {
					n = 1;
				} else if (name.equals("Hoang Duc Hung")) {
					n = 2;
				} else if (name.equals("Tran Tien Diep")) {
					n = 3;
				} else if (name.equals("Hoang Quang Huy")) {
					n = 4;
				}
			} 
		return n;
	}
}
