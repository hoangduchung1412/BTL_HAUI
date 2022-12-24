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


public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JPasswordField passwordField; 
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
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UserManager usm = new UserManager();
		list = usm.create();
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkUser(list) != 0) {
					try {
						frame.inputFile();
						frame.outputFile();
//						n = 0;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Menu.main(null);
					frame.setVisible(false);
				} else {
					showMessage("username hoặc password không đúng!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(173, 245, 155, 57);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Tài khoản:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(60, 99, 100, 28);
		contentPane.add(lblNewLabel);

		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMtKhu.setBounds(60, 141, 100, 28);
		contentPane.add(lblMtKhu);

		textFieldName = new JTextField();
		textFieldName.setBounds(189, 102, 182, 28);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Quản Lý");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(155, 20, 207, 48);
		contentPane.add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(189, 144, 182, 28);
		contentPane.add(passwordField);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

//	public boolean checkUser(List<User> list) {
//		String name = textFieldName.getText();
//		String password = String.copyValueOf(passwordField.getPassword());
//		if ( name != null && password  != null) {
//			for (User user : list) {
//				if (user.getName().equals(name)
//						&& user.getPassword().equals(password)) {
//					return true;
//				}
//			}
//
//		}
//		return false;
//	}
	
	public int checkUser(List<User> list) {
		String name = textFieldName.getText();
		String password = String.copyValueOf(passwordField.getPassword());
		for (User user : list) {
			if ( name != null && password  != null) {
				if (name.equals("Do Khanh Vinh")
						&& password.equals(user.getPassword())) {
					return 1;
				} else if (name.equals("Hoang Duc Hung")
						&& password.equals(user.getPassword())) {
					return 2;
				} else if (name.equals("Tran Tien Diep")
						&& password.equals(user.getPassword())) {
					return 3;
				} else if (name.equals("Hoang Quang Huy")
						&& password.equals(user.getPassword())) {
					return 4;
				}
			}
		}
		System.out.println(n);
		return 0;
	}
	
	public void outputFile() throws IOException {

		// Tạo đối tượng file để lưu dữ liệu
		FileWriter outFileWriter = new FileWriter("login.txt");

		// Tạo đối tượng thực hiện xuất nội dung
		PrintWriter out = new PrintWriter(outFileWriter);

		// Xuất nội dung
		out.print(n);
		// Đóng file
		out.close();
	}

	public void inputFile() throws IOException {
		// Tạo đối tượng file để lưu dữ liệu
		FileReader outFileWriter = new FileReader("login.txt");

		// Tạo đối tượng thực hiện xuất nội dung
		BufferedReader in = new BufferedReader(outFileWriter);

		// Xuất nội dung
		n = checkUser(list);
	}

	public static Login getFrame() {
		return frame;
	}

	public static void setFrame(Login frame) {
		Login.frame = frame;
	}
	
	
	
}
