package Housing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import btl.Login;
import btl.Statistic;
import btl.WriteToFile;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import javax.swing.JSeparator;
import javax.swing.JComboBox;

public class HousingGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HousingManagerImpl manager = new HousingManagerImpl();
	private List<Housing> list = new ArrayList<>();
	private List<Statistic> listSt = new ArrayList<>();
	private JPanel contentPane;
	private JTable table = new JTable();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private DefaultTableModel model = new DefaultTableModel();
	private DefaultTableModel model_1 = new DefaultTableModel();
	private static int idSelect;
	private JTextField textField_5;
	private JTextField textField_6;
	static HousingGUI frame;
	private JTable tableStatistic = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new HousingGUI();
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
	@SuppressWarnings("unchecked")
	public HousingGUI() throws Exception, ClassNotFoundException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\java_thuc_hanh\\logo.png"));
		setTitle("Qu???n l?? b??s");
		manager.init();
		list = WriteFile.listFile(manager.getList());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1129, 742);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 26, 831, 252);
		contentPane.add(scrollPane);

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Price", "Total", "Area", "Location" }));
		scrollPane.setViewportView(table);
		model = (DefaultTableModel) table.getModel();

		JLabel lblName = new JLabel("T??n B??S:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(41, 323, 92, 25);
		contentPane.add(lblName);

		JLabel lblPrice = new JLabel("Gi?? ($):");
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setBounds(51, 358, 82, 25);
		contentPane.add(lblPrice);

		JLabel lblSLng = new JLabel("S??? l?????ng:");
		lblSLng.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSLng.setBounds(41, 393, 92, 25);
		contentPane.add(lblSLng);

		JLabel lblArea = new JLabel("Di???n t??ch(m??):");
		lblArea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArea.setBounds(29, 428, 104, 25);
		contentPane.add(lblArea);

		JLabel lblVTr = new JLabel("V??? tr??:");
		lblVTr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVTr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVTr.setBounds(29, 464, 104, 25);
		contentPane.add(lblVTr);

		JButton btnThem = new JButton("Th??m");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkValue()) {
					return;
				}
				Housing hs = new Housing(manager.autoNumber++, textField.getText(),
						Double.parseDouble(textField_1.getText()), Integer.parseInt(textField_2.getText()),
						Double.parseDouble(textField_3.getText()), textField_4.getText());
				if (!checkExist(hs, list))
					return;
				list.add(hs);
				fillTable();
				resetTextField();
				JOptionPane.showMessageDialog(contentPane, "Th??m B??S th??nh c??ng", "Successful",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(22, 512, 114, 38);
		contentPane.add(btnThem);

		JButton btnSua = new JButton("S???a");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkValue()) {
					return;
				}
				int choice = JOptionPane.showConfirmDialog(contentPane, "B???n c?? ch???c ch???n c???p nh???t th??ng tin kh??ng?",
						"H???i", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION) {
					resetTextField();
					return;
				}
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i).getProduct_id() == idSelect) {
						editHousing(list.get(i));
					}
				}
				fillTable();
				JOptionPane.showMessageDialog(contentPane, "S???a B??S th??nh c??ng", "Successful",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(169, 512, 114, 38);
		contentPane.add(btnSua);

		JButton btnXoa = new JButton("X??a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getProduct_id() == idSelect) {
						list.remove(i);
						JOptionPane.showMessageDialog(contentPane, "X??a B??S th??nh c??ng", "Successful",
								JOptionPane.PLAIN_MESSAGE);
					}
				}
				fillTable();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(324, 512, 114, 38);
		contentPane.add(btnXoa);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(143, 328, 170, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(143, 363, 170, 19);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(143, 398, 170, 19);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(143, 433, 170, 19);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(143, 469, 170, 19);
		contentPane.add(textField_4);

		JButton btnShow = new JButton("Xem danh s??ch");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewTable(list);
			}
		});
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnShow.setBounds(143, 565, 170, 38);
		contentPane.add(btnShow);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(472, 293, 1, 385);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(472, 485, 370, 2);
		contentPane.add(separator_1);

		JLabel lblNewLabel = new JLabel("T??m ki???m theo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(564, 308, 104, 25);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nh???p th??ng tin mu???n t??m:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(491, 360, 177, 21);
		contentPane.add(lblNewLabel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "T??n B??S", "Gi?? B??S", "S??? l?????ng", "Di???n t??ch", "V??? tr??" }));
		comboBox.setBounds(678, 312, 159, 21);
		contentPane.add(comboBox);

		textField_5 = new JTextField();
		textField_5.setBounds(678, 360, 159, 25);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton = new JButton("T??m ki???m");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Housing> listSearch = new ArrayList<>();
				String valueSearch = comboBox.getSelectedItem().toString();
				String typeSearch = textField_5.getText().toLowerCase();
				checkStringInput(typeSearch);
				if (valueSearch.toLowerCase().equals(comboBox.getItemAt(0).toString().toLowerCase())) {
					listSearch = manager.searchHousing(typeSearch);
					viewTable(listSearch);
				} else if (valueSearch.toLowerCase().equals(comboBox.getItemAt(1).toString().toLowerCase())) {
					listSearch = manager.searchHousing(Double.parseDouble(typeSearch));
					viewTable(listSearch);
				} else if (valueSearch.trim().toLowerCase().equals(comboBox.getItemAt(2).toString().toLowerCase())) {
					listSearch = manager.searchHousing(Integer.parseInt(typeSearch));
					viewTable(listSearch);
				} else if (valueSearch.trim().toLowerCase().equals(comboBox.getItemAt(3).toString().toLowerCase())) {
					listSearch = manager.searchHousingByArea(Double.parseDouble(typeSearch));
					viewTable(listSearch);
				} else if (valueSearch.trim().toLowerCase().equals(comboBox.getItemAt(4).toString().toLowerCase())) {
					listSearch = manager.searchHousingByLocation(typeSearch);
					viewTable(listSearch);
				}
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(610, 417, 151, 36);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Lo???i s???p x???p:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(564, 527, 104, 23);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nh???p gi?? min:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(564, 560, 104, 25);
		contentPane.add(lblNewLabel_3);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_6.setBounds(678, 565, 159, 25);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "T??ng d???n", "Gi???m d???n" }));
		comboBox_1.setBounds(678, 530, 159, 21);
		contentPane.add(comboBox_1);

		JButton btnNewButton_1 = new JButton("S???p X???p");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Housing> listSort = new ArrayList<>();
				String typeSort = comboBox_1.getSelectedItem().toString();
				boolean check;
				String valueSort = textField_6.getText();
				checkStringInput(valueSort);
				if (typeSort == "T??ng d???n") {
					check = true;
				} else {
					check = false;
				}
				if (check) {
					listSort = manager.sortedHousing(Double.parseDouble(valueSort), check);
					viewTable(listSort);
				} else {
					listSort = manager.sortedHousing(Double.parseDouble(valueSort), check);
					viewTable(listSort);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(610, 613, 151, 38);
		contentPane.add(btnNewButton_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(852, 293, 1, 385);
		contentPane.add(separator_2);

		JButton btnNewButton_2 = new JButton("????ng Xu???t");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				log.setVisible(true);
				log.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(143, 625, 170, 36);
		contentPane.add(btnNewButton_2);

		JScrollPane scrollPane_1 = new JScrollPane(tableStatistic);
		scrollPane_1.setBounds(877, 26, 228, 252);
		contentPane.add(scrollPane_1);

		tableStatistic.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Type", "Total" }));
		scrollPane_1.setViewportView(tableStatistic);
		model_1 = (DefaultTableModel) tableStatistic.getModel();

		JButton btnNewButton_3 = new JButton("Th???ng k??");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTableS();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(936, 302, 123, 38);
		contentPane.add(btnNewButton_3);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				idSelect = (int) table.getValueAt(row, 0);
				textField.setText(String.valueOf(table.getValueAt(row, 1)));
				textField_1.setText(String.valueOf(table.getValueAt(row, 2)));
				textField_2.setText(String.valueOf(table.getValueAt(row, 3)));
				textField_3.setText(String.valueOf(table.getValueAt(row, 4)));
				textField_4.setText(String.valueOf(table.getValueAt(row, 5)));
			}
		});

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		setLocation(screenWidth / 9, screenHeight / 32);
	}

	public int counT(String name) {
		int count = 0;
		for (Housing housing : list) {
			if (housing.getLocation().equals(name)) {
				count++;
			}
		}
		return count;
	}

	public void fillTableS() {
		List<Statistic> tmp = addStatic();
		try {
			WriteToFile.fileWrite(tmp, "Report.bin");
			listSt = WriteToFile.fileRead("Report.bin");
			viewTableS(listSt);
		} catch (IOException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		tableStatistic.setRowHeight(40);

		DefaultTableCellRenderer rightRendererS = new DefaultTableCellRenderer();
		rightRendererS.setHorizontalAlignment(SwingConstants.CENTER);

		for (int columnIndex = 0; columnIndex < model_1.getColumnCount(); columnIndex++) {
			tableStatistic.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRendererS);
		}
	}

	public void viewTableS(List<Statistic> list) {
		model_1.setRowCount(0);
		for (Statistic sts : listSt) {
			model_1.addRow(new Object[] { sts.getType(), sts.getSumTotal() });
			;
		}
	}

	public List<Statistic> addStatic() {
		List<Statistic> lst = new ArrayList<>();

		lst.add(new Statistic("H?? N???i", counT("H?? N???i")));
		lst.add(new Statistic("B??nh D????ng", counT("B??nh D????ng")));
		lst.add(new Statistic("Nam ?????nh", counT("Nam ?????nh")));
		lst.add(new Statistic("H??? Long", counT("H??? Long")));
		lst.add(new Statistic("H?? ????ng", counT("H?? ????ng")));
		lst.add(new Statistic("Gia L??m", counT("Gia L??m")));
		lst.add(new Statistic("H???i Ph??ng", counT("H???i Ph??ng")));

		return lst;
	}

	public void checkStringInput(String str) {
		if (str.equals("")) {
			JOptionPane.showMessageDialog(contentPane, "Kh??ng ???????c ????? tr???ng gi?? tr??? nh???p v??o!");
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
	}

	public boolean checkExist(Housing c, List<Housing> list) {
		for (Housing housing : list) {
			if (housing.equals(c)) {
				JOptionPane.showMessageDialog(contentPane, "B??S ???? t???n t???i!", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}

	public void viewTable(List<Housing> list) {
		model.setRowCount(0);
		for (Housing housing : list) {
			model.addRow(new Object[] { housing.getProduct_id(), housing.getProduct_name(), housing.getProduct_price(),
					housing.getProduct_total(), housing.getArea(), housing.getLocation() });
		}

		table.setRowHeight(20);

		DefaultTableCellRenderer rightRendererS = new DefaultTableCellRenderer();
		rightRendererS.setHorizontalAlignment(SwingConstants.CENTER);

		for (int columnIndex = 0; columnIndex < model.getColumnCount(); columnIndex++) {
			table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRendererS);
		}
	}

	public boolean checkValue() {
		if (!checkEmpty())
			return false;
		StringBuilder strb = new StringBuilder();
		if (Double.parseDouble(textField_1.getText()) < 0)
			strb.append("S??? ti???n kh??ng h???p l???!\n");
		if (Integer.parseInt(textField_2.getText()) < 0)
			strb.append("S??? l?????ng kh??ng h???p l???!\n");
		if (Double.parseDouble(textField_3.getText()) < 0)
			strb.append("Di???n t??ch kh??ng h???p l???!\n");
		if (strb.length() > 0) {
			JOptionPane.showMessageDialog(contentPane, strb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public boolean checkEmpty() {
		StringBuilder strb = new StringBuilder();
		if (textField.getText().equals(""))
			strb.append("T??n B??S kh??ng ???????c ????? tr???ng!\n");
		if (textField_1.getText().equals(""))
			strb.append("Gi?? B??S kh??ng ???????c b??? tr???ng!\n");
		if (textField_2.getText().equals(""))
			strb.append("S??? l?????ng kh??ng ???????c b??? tr???ng!\n");
		if (textField_3.getText().equals(""))
			strb.append("Di???n t??ch kh??ng ???????c ????? tr???ng!\n");
		if (textField_4.getText().equals(""))
			strb.append("Khu v???c kh??ng ???????c ????? tr???ng!\n");
		if (strb.length() > 0) {
			JOptionPane.showMessageDialog(contentPane, strb.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;

	}

	public Housing editHousing(Housing hs) {
		if (!textField.getText().equals(""))
			hs.setProduct_name(textField.getText());
		if (!textField_1.getText().equals(""))
			hs.setProduct_price(Double.valueOf(textField_1.getText()));
		if (!textField_2.getText().equals(""))
			hs.setProduct_total(Integer.valueOf(textField_2.getText()));
		if (!textField_3.getText().equals(""))
			hs.setArea(Double.valueOf(textField_3.getText()));
		if (!textField_4.getText().equals(""))
			hs.setLocation(textField_4.getText());

		return hs;
	}
}
