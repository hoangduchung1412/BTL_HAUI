package Mobile;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Mobile.Mobile;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.Color;

public class MobileGUI extends JFrame {

	private MobileManagerImpl manager = new MobileManagerImpl();
	private List<Mobile> list = new ArrayList<>();
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	DefaultTableModel model;
	private static int idSelect;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MobileGUI frame = new MobileGUI();
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
	public MobileGUI() throws Exception, ClassNotFoundException {
		setTitle("Quản lý Mobile");
		manager.Danhsach();
		list = WriteFile.listFile(manager.getList());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 742);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(439, 11, 575, 306);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Tên Hãng", "Price", "Total", "Tên Mobile", "PhoneNumber", "Company" }));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				idSelect = (int) table.getValueAt(row, 0);
			}
		});

		JLabel lblName = new JLabel("Tên hãng");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(9, 73, 111, 25);
		contentPane.add(lblName);

		JLabel lblPrice = new JLabel("Giá ($):");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(28, 121, 92, 25);
		contentPane.add(lblPrice);

		JLabel lblSLng = new JLabel("Số lượng:");
		lblSLng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSLng.setBounds(10, 157, 111, 25);
		contentPane.add(lblSLng);

		JLabel lblType = new JLabel("Tên điện thoại:");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblType.setBounds(10, 199, 104, 25);
		contentPane.add(lblType);

		JLabel lblRam = new JLabel("PhoneNumber:");
		lblRam.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRam.setBounds(10, 246, 104, 25);
		contentPane.add(lblRam);
		
		JLabel lblSsd = new JLabel("Company:");
		lblSsd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSsd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSsd.setBounds(9, 295, 106, 22);
		contentPane.add(lblSsd);

		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(255, 255, 204));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkValue()) {
					return;
				}
				Mobile m = new Mobile(manager.id++, textField.getText(),
						Double.parseDouble(textField_1.getText()), Integer.parseInt(textField_2.getText()),
						textField_3.getText(), Integer.parseInt(textField_4.getText()), textField_7.getText());
				if (!checkExist(m, list))
					return;
				list.add(m);
				fillTable();
				resetTextField();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(10, 365, 114, 38);
		contentPane.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(204, 255, 204));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkValue()) {
					return;
				}
				int choice = JOptionPane.showConfirmDialog(contentPane, "Bạn có chắc chắn cập nhật thông tin không?",
						"Edit", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION) {
					resetTextField();
					return;
				}
				for (Mobile Mobile : list) {
					if (Mobile.getProduct_id() == idSelect) {
						editMobile(Mobile);
						break;
					}
				}
				fillTable();
				JOptionPane.showMessageDialog(contentPane, "Sửa thành công", "Successful",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(144, 365, 114, 38);
		contentPane.add(btnSua);

		JButton btnXoa = new JButton("Xoá");
		btnXoa.setBackground(new Color(102, 255, 204));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getProduct_id() == idSelect) {
						list.remove(i);
					}
				}
				fillTable();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(291, 365, 114, 38);
		contentPane.add(btnXoa);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(130, 73, 184, 25);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(130, 123, 184, 25);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(131, 159, 184, 25);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(131, 201, 184, 25);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(131, 248, 184, 25);
		contentPane.add(textField_4);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_7.setBounds(131, 292, 184, 25);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		contentPane.add(textField_7);
		
		JButton btnShow = new JButton("Xem danh sách");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTable(list);
			}
		});
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShow.setBounds(119, 503, 170, 38);
		contentPane.add(btnShow);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(439, 383, 6, 314);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(439, 502, 575, 2);
		contentPane.add(separator_1);

		JLabel lblNewLabel = new JLabel("Tìm kiếm theo: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(528, 400, 104, 25);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nhập thông tin muốn tìm: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(455, 449, 177, 21);
		contentPane.add(lblNewLabel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Tên Hãng", "Price", "Tên Mobile", "PhoneNumber", "Company" }));
		comboBox.setBounds(648, 399, 191, 26);
		contentPane.add(comboBox);

		textField_5 = new JTextField();
		textField_5.setBounds(648, 445, 191, 25);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setBackground(new Color(255, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Mobile> listSearch = new ArrayList<>();
				String valueSearch = comboBox.getSelectedItem().toString();
				String typeSearch = textField_5.getText().toLowerCase();
				checkStringInput(typeSearch);
				if (valueSearch.toLowerCase().equals(comboBox.getItemAt(0).toString().toLowerCase())) {
					listSearch = manager.searchMobile(typeSearch);
					viewTable(listSearch);
				} else if (valueSearch.toLowerCase().equals(comboBox.getItemAt(1).toString().toLowerCase())) {
					listSearch = manager.searchMobile(Double.parseDouble(typeSearch));
					viewTable(listSearch);
				} else if (valueSearch.trim().toLowerCase().equals(comboBox.getItemAt(2).toString().toLowerCase())) {
					listSearch = manager.searchMobileName(typeSearch);
					viewTable(listSearch);
				} else if (valueSearch.trim().toLowerCase().equals(comboBox.getItemAt(3).toString().toLowerCase())) {
					listSearch = manager.searchMobileNumberphone(Double.parseDouble(typeSearch));
					viewTable(listSearch);
				} else if (valueSearch.trim().toLowerCase().equals(comboBox.getItemAt(4).toString().toLowerCase())) {
					listSearch = manager.searchMobileCompany(typeSearch);
					viewTable(listSearch);
				}
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(849, 434, 151, 36);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Loại sắp xếp: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(508, 586, 104, 23);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nhập min: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(508, 630, 104, 25);
		contentPane.add(lblNewLabel_3);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setBounds(648, 630, 191, 25);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Tăng dần", "Giảm dần"}));
		comboBox_1.setBounds(648, 585, 190, 25);
		contentPane.add(comboBox_1);

		JButton btnNewButton_1 = new JButton("Sắp xếp");
		btnNewButton_1.setBackground(new Color(255, 128, 192));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Mobile> listSort = new ArrayList<>();
				String typeSort = comboBox_1.getSelectedItem().toString();
				boolean check;
				String valueSort = textField_6.getText();
				checkStringInput(valueSort);
				if(typeSort == "Tăng dần") {
					check = true;
				} else {
					check = false;
				}
				if (check) {
					listSort = manager.sortedMobileByPrice(Double.parseDouble(valueSort), check);
					viewTable(listSort);
				} else {
					listSort = manager.sortedMobileByPrice(Double.parseDouble(valueSort), check);
					viewTable(listSort);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(849, 617, 151, 38);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Sắp xếp theo: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(518, 550, 114, 25);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2.setModel(
				new DefaultComboBoxModel(new String[] { "Giá điện thoại"}));
		comboBox_2.setBounds(648, 550, 191, 24);
		contentPane.add(comboBox_2);
		
		
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		setLocation(screenWidth/9, screenHeight/32);
	}

	public void checkStringInput(String str) {
		if (str.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Thông tin không được để trống!");
			return;
		}
	}

	public void fillTable() {
		try {
			list = WriteFile.listFile(list);
			viewTable(list);
			resetTextField();
		} catch (IOException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void resetTextField() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_7.setText("");
	}

	public boolean checkExist(Mobile m, List<Mobile> list) {
		for (Mobile Mobile : list) {
			if (Mobile.equals(m)) {
				JOptionPane.showMessageDialog(contentPane, "!", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}

	public void viewTable(List<Mobile> list) {
		model.setRowCount(0);
		for(Mobile mobile : list) {
			model.addRow(new Object[] { mobile.getProduct_id(), mobile.getProduct_name(), mobile.getProduct_price(),
					mobile.getProduct_total(), mobile.getMobile_name(), mobile.getMobile_numberphone(), mobile.getMobile_company() });
		}
	}

	public boolean checkValue() {
		if (!checkEmpty())
			return false;
		StringBuilder strb = new StringBuilder();
		if (Double.parseDouble(textField_1.getText()) < 0)
			strb.append("!\n");
		if (Integer.parseInt(textField_2.getText()) < 0)
			strb.append("!\n");
		if (Integer.parseInt(textField_4.getText()) < 0)
			strb.append("!\n");
		if (strb.length() > 0) {
			JOptionPane.showMessageDialog(contentPane, strb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public boolean checkEmpty() {
		StringBuilder strb = new StringBuilder();
		if (textField.getText().equals(""))
			strb.append("Hãng điện thoại không được để trống!\n");
		if (textField_1.getText().equals(""))
			strb.append("Giá điện thoại không được để trống!\n");
		if (textField_2.getText().equals(""))
			strb.append("Số lượng điện thoại không được để trống!\n");
		if (textField_3.getText().equals(""))
			strb.append("Tên điện thoại không được để trống!\n");
		if (textField_4.getText().equals(""))
			strb.append("Số điện thoại không được để trống!\n");
		if (textField_7.getText().equals(""))
			strb.append("Công ty điện thoại không được để trống!\n");
		if (strb.length() > 0) {
			JOptionPane.showMessageDialog(contentPane, strb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;

	}

	public Mobile editMobile(Mobile m) {
		if (!textField.getText().equals(""))
			m.setProduct_name(textField.getText());
		if (!textField_1.getText().equals(""))
			m.setProduct_price(Double.valueOf(textField_1.getText()));
		if (!textField_2.getText().equals(""))
			m.setProduct_total(Integer.valueOf(textField_2.getText()));
		if (!textField_3.getText().equals(""))
			m.setMobile_name(textField_3.getText());
		if (!textField_4.getText().equals(""))
			m.setMobile_numberphone(Double.valueOf(textField_4.getText()));
		if (!textField_7.getText().equals(""))
			m.setMobile_company(textField_7.getText());
		return m;
	}
}
