package Mobile;

import java.io.Serializable;
import java.util.Scanner;

public class Product implements Serializable {
	public static final int PRODUCT_ID = 0;
	public static final String Product_NAME = " ";
	public static final double PRODUCT_PRICE = 0;
	public static final int PRODUCT_TOTAL = 0;
	
	private int product_id;
	private String product_name;
	private double product_price;
	private int product_total;
	
	
	
	public Product() {
		this(PRODUCT_ID, Product_NAME, PRODUCT_PRICE, PRODUCT_TOTAL);
		
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
//		return " ---Product--- : product_id = " + product_id + ", product_name = " + product_name + ", product_price = "
//				+ product_price + ", product_total = " + product_total + "";
		return String.format("%-5d | %-15s | %-10.3f | %8d |", product_id, product_name, product_price, product_total);
	}



	public void input() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap dinh danh san pham: ");
		product_id = Integer.parseInt(sc.nextLine());
		System.out.println("Nhap ten san pham: ");
		product_name = sc.nextLine();
		System.out.println("Nhap gia san pham: ");
		product_price = Double.parseDouble(sc.nextLine());
		System.out.println("Nhap so luong san pham: ");
		product_total = Integer.parseInt(sc.nextLine());
				
	}

}
