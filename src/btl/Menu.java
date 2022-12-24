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
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int n;
	static Menu frame = new Menu();

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
		setBounds(100, 100, 622, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Chương Trình Quản Lý");
		lblNewLabel_1.setForeground(new Color(255, 153, 51));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(141, 53, 303, 57);
		
		try {
			n = readFile();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String name = " ";
		if(n == 1) {
			name = "Đỗ Khánh Vinh";
		} else if(n == 2) {
			name = "Hoàng Đức Hùng";
		} else if(n == 3) {
			name = "Trần Tiến Điệp";
		} else if(n == 4) {
			name = "Hoàng Quang Huy";
		} 
		contentPane.add(lblNewLabel_1);
		JButton btnHousingButton = new JButton("Housing");
		btnHousingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (n == 1 || n == 4) {
					HousingGUI.main(null);
					frame.setVisible(false);
				} 
				else {
					showMessage("Bạn không có quyền truy cập vào chức năng này");
				}
			}
		});
		btnHousingButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHousingButton.setBounds(195, 143, 187, 43);
		contentPane.add(btnHousingButton);

		JButton btnComputerButton = new JButton("Computer");
		btnComputerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (n == 2 || n == 4) {
					ComputerGUI.main(null);
					frame.setVisible(false);
				} 
				else {
					showMessage("Bạn không có quyền truy cập vào chức năng này");
				}
			}
		});
		btnComputerButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnComputerButton.setBounds(195, 210, 187, 43);
		contentPane.add(btnComputerButton);

		JButton btnMobileButton = new JButton("Mobile");
		btnMobileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (n == 3 || n == 4) {
					MobileGUI.main(null);
					frame.setVisible(false);
				} 
				else {
					showMessage("Bạn không có quyền truy cập vào chức năng này");
				}
			}
		});
		btnMobileButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMobileButton.setBounds(195, 276, 187, 43);
		contentPane.add(btnMobileButton);
		
		JLabel lblHelloLabel = new JLabel("Xin chào " + name + " !");
		lblHelloLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHelloLabel.setBounds(10, 10, 187, 22);
		contentPane.add(lblHelloLabel);
	}

	public int readFile() throws IOException {
		FileReader fileReader = null;
        BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(new File("D://java_thuc_hanh//BTL_HAUI//login.txt"));
            bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				n = Integer.valueOf(line);
			}
		} finally {
			if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
		}
		return n;
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
