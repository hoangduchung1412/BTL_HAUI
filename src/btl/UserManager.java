package btl;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

	private List<User> list = new ArrayList<>();
	 
	
	public List<User> create(){
		list.add(new User("Do Khanh Vinh", "123456"));
		list.add(new User("Hoang Duc Hung", "123456"));
		list.add(new User("Tran Tien Diep", "123456"));
		list.add(new User("Hoang Quang Huy", "123456"));
		return list;
	}
	
	public List<User> getList() {
		// TODO Auto-generated method stub
		return list;
	}
}
