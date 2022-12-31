package Mobile;

import java.util.*;


public class MobileManagerImpl implements MobileManager {
	private List<Mobile> list = new ArrayList<>();

	public static int id = 100;

	static Scanner sc = new Scanner(System.in);

	public List<Mobile> Danhsach() {
		list.add(new Mobile(id++, "Iphone", 10, 3, "11 Pro Max", "Apple"));
		list.add(new Mobile(id++, "Iphone", 15, 6, "12 Pro Max", "Apple"));
		list.add(new Mobile(id++, "Oppo", 6, 2, "Neo 3", "BBK electroics"));
		list.add(new Mobile(id++, "Samsung", 7, 4, "Note 8", "Samsung"));
		return list;
	}

	@Override
	public boolean addMobile(Mobile c) {
		c.input();
		if (list.contains(c)) {
			return false;
		}
		c.setProduct_id(id++);
		list.add(c);
		System.out.println("\tThêm thành công");
		return true;
	}

	@Override
	public boolean editMobile(Mobile c) {
		System.out.print("\tNhập id máy tính muốn sửa: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOf(id);
		System.out.println(index);
		if (index == -1) {
			System.out.println("\tMáy tính không có trong danh sách!");
			return false;
		}
		c.input();
		c.setProduct_id(list.get(index).getProduct_id());
		list.set(index, c);
		System.out.println("Sửa thành công");
		return true;
	}

	@Override
	public boolean delMobile(Mobile c) {
		System.out.print("\tNhập vào id máy tính cần xoá: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = indexOf(id);
		if (index == -1) {
			System.out.println("\tMáy tính không có trong danh sách!");
			return false;
		}
		list.remove(index);
		System.out.println("Xoá thành công!");
		return true;
	}

	@Override
	public List<Mobile> searchMobile(String product_name) {
		List<Mobile> search = new ArrayList<>();
		for (Mobile Mobile : list) {
			if (Mobile.getProduct_name().toLowerCase().contains(product_name.toLowerCase())) {
				search.add(Mobile);
			}
		}
		return search;
	}

	@Override
	public List<Mobile> searchMobile(double product_price) {
		List<Mobile> search = new ArrayList<>();
		for (Mobile Mobile : list) {
			if (Mobile.getProduct_price() == product_price) {
				search.add(Mobile);
			}
		}
		return search;
	}

	@Override
	public List<Mobile> searchMobileName(String type) {
		List<Mobile> search = new ArrayList<>();
		for (Mobile Mobile : list) {
			if (Mobile.getMobile_name().toLowerCase().contains(type)) {
				search.add(Mobile);
			}
		}
		return search;
	}

	@Override
	public List<Mobile> searchMobileCompany(String company) {
		List<Mobile> search = new ArrayList<>();
		for (Mobile i : list) {
			if (i.getMobile_company().toLowerCase().contains(company.toLowerCase())) {
				search.add(i);
			}
		}
		// TODO Auto-generated method stub
		return search;
	}


	@Override
	public List<Mobile> sortedMobile(double price) {
		List<Mobile> tmp = new ArrayList<>();
		for (Mobile Mobile : list) {
			if (Mobile.getProduct_price() > price) {
				tmp.add(Mobile);
			}
		}
		int i;
		do {
			System.out.print("Nhập vào kiểu sắp xếp(1: tăng, 0: giảm): ");
			i = Integer.parseInt(sc.nextLine());
			if (i == 1) {
				Collections.sort(tmp, new sortedMobileByPrice());
			} else {
				Collections.sort(tmp, new sortedMobileByPrice().reversed());
			}
		} while (i != 1 && i != 0);

		return tmp;
	}

	public List<Mobile> sortedMobileByPrice(double price, boolean i) {
		List<Mobile> tmp = new ArrayList<>();
		for (Mobile Mobile : list) {
			if (Mobile.getProduct_price() > price) {
				tmp.add(Mobile);
			}
		}
		if (i) {
			Collections.sort(tmp, new sortedMobileByPrice());
		} else {
			Collections.sort(tmp, new sortedMobileByPrice().reversed());
		}

		return tmp;
	}

	
	

	
	public int indexOf(int id) {
		for (int index = 0; index < list.size(); index++)
			if (list.get(index).getProduct_id() == id)
				return index;

		return -1;
	}

	public void show() {
		System.out.println(list);
	}

	public List<Mobile> getList() {
		// TODO Auto-generated method stub
		return list;
	}

}

class sortedMobileByPrice implements Comparator<Mobile> {

	@Override
	public int compare(Mobile o1, Mobile o2) {
		// TODO Auto-generated method stub
		Double price1 = o1.getProduct_price();
		Double price2 = o2.getProduct_price();
		return (int) (price1 - price2);
	}

}
