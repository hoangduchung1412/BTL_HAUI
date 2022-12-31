package Housing;

import java.util.*;

public class Housing extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static Scanner sc = new Scanner(System.in);

	public static final double AREA = 0;
	public static final String LOCATION = "No location";

	private double area;
	private String location;

	public Housing() {
		this(Housing.PRODUCT_ID, Housing.PRODUCT_NAME, Housing.PRODUCT_PRICE, Housing.PRODUCT_TOTAL, Housing.AREA,
				Housing.LOCATION);
	}

	public Housing(int product_id, String product_name, double product_price, int product_total, double area,
			String location) {
		super(product_id, product_name, product_price, product_total);
		this.area = area;
		this.location = location;
	}

	public double getArea() {
		return area;
	}

	public String getLocation() {
		return location;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
//		return super.toString() + "area = " + area + "m², location = " + location +"\n";
		return super.toString() + String.format(" %9.2f | %-25s ", area, location);
	}

	@Override
	public void input(){
		super.input();
		System.out.print("\tNhập diện tích(m²): ");
		setArea(Double.parseDouble(sc.nextLine()));
		System.out.print("\tNhập vị trí: ");
		setLocation(sc.nextLine());
	}
}
