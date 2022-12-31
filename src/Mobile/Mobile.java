package Mobile;

import java.util.Scanner;

public class Mobile extends Product{
	
	public static final String MOBILE_NAME = " ";
	public static final String MOBILE_COMPANY = " ";
	
	private String mobile_name;
	private String mobile_company;
	
	
	
	
	public Mobile() {
		this(Mobile.PRODUCT_ID, Mobile.Product_NAME, Mobile.PRODUCT_PRICE, Mobile.PRODUCT_TOTAL,
				Mobile.MOBILE_NAME, Mobile.MOBILE_COMPANY);
	}


	public Mobile(int product_id, String product_name, double product_price, int product_total, String mobile_name, String mobile_company) {
		super(product_id, product_name, product_price, product_total);
		this.mobile_name = mobile_name;
		this.mobile_company = mobile_company;
	}
	
	
	public String getMobile_name() {
		return mobile_name;
	}


	public String getMobile_company() {
		return mobile_company;
	}


	public void setMobile_name(String mobile_name) {
		this.mobile_name = mobile_name;
	}


	public void setMobile_company(String mobile_company) {
		this.mobile_company = mobile_company;
	}


	@Override
	public String toString() {
//		return super.toString() + " ---Mobile--- : mobile_name = " + mobile_name + ", mobile_numberphone = " + mobile_numberphone + ", mobile_company = "
//				+ mobile_company + "]\n";
		return super.toString() + String.format(" %-15s | %-5s ", mobile_name, mobile_company);
	}


	public void input() {
		super.input();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ten di dong: ");
		mobile_name = sc.nextLine();
		System.out.println("Nhap cong ty: ");
		mobile_company = sc.nextLine();
		
	}
}
