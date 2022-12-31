package Computer;

import java.util.*;

public class Computer extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static Scanner sc = new Scanner(System.in);

	public static final String TYPE = "No type";
	public static final int RAM = 0;
	public static final int SSD = 0;
	
	private String type;
	private int ram;
	private int ssd;

	public Computer() {
		this(Computer.PRODUCT_ID, Computer.PRODUCT_NAME, Computer.PRODUCT_PRICE, Computer.PRODUCT_TOTAL, Computer.TYPE,
				Computer.RAM, Computer.SSD);
	}

	public Computer(int product_id, String product_name, double product_price, int product_total, String type, int ram,
			int ssd) {
		super(product_id, product_name, product_price, product_total);
		this.type = type;
		this.ram = ram;
		this.ssd = ssd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getSsd() {
		return ssd;
	}

	public void setSsd(int ssd) {
		this.ssd = ssd;
	}

	@Override
	public String toString() {
//		return "Computer [" + super.toString() + " - type=" + type + ", ram=" + ram + ", ssd=" + ssd + "]\n";
		return super.toString() + String.format(" %-10s | %-5d | %-10d", type, ram, ssd);
	}

	public void input(){
		super.input();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập loại sản phẩm: ");
		setType(sc.nextLine());
		System.out.print("Nhập ram: ");
		setRam(Integer.parseInt(sc.nextLine()));
		System.out.print("Nhập ssd: ");
		setSsd(Integer.parseInt(sc.nextLine()));
	}
}
