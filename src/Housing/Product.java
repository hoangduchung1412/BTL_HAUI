package Housing;

import java.io.Serializable;
import java.util.Scanner;

public class Product implements Serializable{
	
	static Scanner sc = new Scanner(System.in);

	public static final int PRODUCT_ID = 0;
	public static final String PRODUCT_NAME = "No product name";
	public static final double PRODUCT_PRICE = 0;
	public static final int PRODUCT_TOTAL = 0;

	private int product_id;
	private String product_name;
	private double product_price;
	private int product_total;

	public Product() {
		this(Product.PRODUCT_ID, Product.PRODUCT_NAME, Product.PRODUCT_PRICE, Product.PRODUCT_TOTAL);
	}

	public Product(int product_id, String product_name, double product_price, int product_total) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_total = product_total;
	}
	
	public int getProduct_id() {
		return product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public double getProduct_price() {
		return product_price;
	}

	public int getProduct_total() {
		return product_total;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public void setProduct_total(int product_total) {
		this.product_total = product_total;
	}
	
	@Override
	public String toString() {
//		return "product_id = " + product_id + ", product_name = " + product_name + ", product_price = " 
//				+ product_price + "$, product_total = " + product_total + ", ";
		return String.format("%-5d | %-25s | %15.3f | %8d |", product_id, product_name, product_price, product_total);
	}
	
	public void input() {
	    System.out.print("\tNhập tên: ");
	    setProduct_name(sc.nextLine());
	    System.out.print("\tNhập giá($): ");
	    setProduct_price(Double.parseDouble(sc.nextLine()));
	    System.out.print("\tNhập số lượng: ");
	    setProduct_total(Integer.parseInt(sc.nextLine()));
	  }
}
