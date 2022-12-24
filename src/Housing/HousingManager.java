package Housing;

import java.util.List;

public interface HousingManager {
	public boolean addHousing(Housing h);
	public boolean editHousing(Housing h);
	public boolean delHousing(Housing h);
	public List< Housing> searchHousing(String name);
	public List< Housing> searchHousing(double product_price);
	public List< Housing> searchHousing(int product_total);
	public List< Housing> searchHousingByArea(double area);
	public List< Housing> searchHousingByLocation(String location);
	public List<Housing> sortedHousing(double price);
}
