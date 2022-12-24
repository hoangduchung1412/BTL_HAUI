package Mobile;

import java.util.List;

public interface MobileManager {
	public boolean addMobile(Mobile m);
	public boolean editMobile(Mobile m);
	public boolean delMobile(Mobile m);
	
	public List<Mobile> searchMobile(String name);
	public List<Mobile> searchMobile(double price);
	public List<Mobile> searchMobileName(String name);
	public List<Mobile> searchMobileNumberphone(double numberphone);
	public List<Mobile> searchMobileCompany(String company);
		
	public List<Mobile> sortedMobile(double price);

}
