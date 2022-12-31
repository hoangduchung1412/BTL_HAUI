package Computer;

import java.util.*;


public class ComputerManagerImpl implements ComputerManager {
	private List<Computer> list = new ArrayList<>();

	public static int autoNumber = 1001;

	static Scanner sc = new Scanner(System.in);

	public List<Computer> init() {
		list.add(new Computer(autoNumber++, "Dell", 4000, 2, "Vostro", 6, 128));
		list.add(new Computer(autoNumber++, "Lenovo", 3000, 6, "Thinkpad", 4, 512));
		list.add(new Computer(autoNumber++, "Asus", 2000, 4, "Zenbook", 12, 128));
		list.add(new Computer(autoNumber++, "MSI", 1000, 6, "Gaming", 8, 256));
		list.add(new Computer(autoNumber++, "AOG", 5000, 5, "Strix", 10, 128));
		list.add(new Computer(autoNumber++, "Dell", 6000, 1, "Vostro", 16, 128));
		list.add(new Computer(autoNumber++, "Lenovo", 4000, 4, "Thinkpad", 8, 512));
		list.add(new Computer(autoNumber++, "Asus", 8000, 5, "Zenbook", 4, 128));
		list.add(new Computer(autoNumber++, "Lenovo", 3000, 7, "Thinkpad", 12, 256));
		list.add(new Computer(autoNumber++, "Dell", 10000, 8, "Vostro", 8, 512));
		return list;
	}

	@Override
	public boolean addComputer(Computer c) {
		c.input();
		if (list.contains(c)) {
			return false;
		}
		c.setProduct_id(autoNumber++);
		list.add(c);
		System.out.println("\tThêm thành công");
		return true;
	}

	@Override
	public boolean editComputer(Computer c) {
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
	public boolean delComputer(Computer c) {
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
	public List<Computer> searchComputerByName(String product_name) {
		List<Computer> search = new ArrayList<>();
		for (Computer computer : list) {
			if (computer.getProduct_name().toLowerCase().contains(product_name.toLowerCase())) {
				search.add(computer);
			}
		}
		return search;
	}

	@Override
	public List<Computer> searchComputerByPrice(double product_price) {
		List<Computer> search = new ArrayList<>();
		for (Computer computer : list) {
			if (computer.getProduct_price() == product_price) {
				search.add(computer);
			}
		}
		return search;
	}

	@Override
	public List<Computer> searchComputerByType(String type) {
		List<Computer> search = new ArrayList<>();
		for (Computer computer : list) {
			if (computer.getType() == type) {
				search.add(computer);
			}
		}
		return search;
	}


	@Override
	public List<Computer> sortedComputerByPrice(double price) {
		List<Computer> tmp = new ArrayList<>();
		for (Computer computer : list) {
			if (computer.getProduct_price() > price) {
				tmp.add(computer);
			}
		}
		int i;
		do {
			System.out.print("Nhập vào kiểu sắp xếp(1: tăng, 0: giảm): ");
			i = Integer.parseInt(sc.nextLine());
			if (i == 1) {
				Collections.sort(tmp, new sortedComputerByPrice());
			} else {
				Collections.sort(tmp, new sortedComputerByPrice().reversed());
			}
		} while (i != 1 && i != 0);

		return tmp;
	}

	public List<Computer> sortedComputerByPrice(double price, boolean i) {
		List<Computer> tmp = new ArrayList<>();
		for (Computer computer : list) {
			if (computer.getProduct_price() > price) {
				tmp.add(computer);
			}
		}
		if (i) {
			Collections.sort(tmp, new sortedComputerByPrice());
		} else {
			Collections.sort(tmp, new sortedComputerByPrice().reversed());
		}

		return tmp;
	}

	
	@Override
	public List<Computer> sortedComputerByRam(int ram) {
		List<Computer> tmp = new ArrayList<>();
		for (Computer computer : list) {
			if (computer.getRam() > ram) {
				tmp.add(computer);
			}
		}
		int i;
		do {
			System.out.print("Nhập vào kiểu sắp xếp(1: tăng, 0: giảm): ");
			i = Integer.parseInt(sc.nextLine());
			if (i == 1) {
				Collections.sort(tmp, new sortedComputerByRam());
			} else {
				Collections.sort(tmp, new sortedComputerByRam().reversed());
			}
		} while (i != 1 && i != 0);

		return tmp;
	}

	public List<Computer> sortedComputerByRam(int ram, boolean i) {
		List<Computer> tmp = new ArrayList<>();
		for (Computer computer : list) {
			if (computer.getRam() > ram) {
				tmp.add(computer);
			}
		}
		if (i) {
			Collections.sort(tmp, new sortedComputerByPrice());
		} else {
			Collections.sort(tmp, new sortedComputerByPrice().reversed());
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

	public List<Computer> getList() {
		// TODO Auto-generated method stub
		return list;
	}

}

class sortedComputerByPrice implements Comparator<Computer> {

	@Override
	public int compare(Computer o1, Computer o2) {
		// TODO Auto-generated method stub
		Double price1 = o1.getProduct_price();
		Double price2 = o2.getProduct_price();
		return (int) (price1 - price2);
	}

}

class sortedComputerByRam implements Comparator<Computer> {

	@Override
	public int compare(Computer o1, Computer o2) {
		// TODO Auto-generated method stub
		double ram1 = o1.getRam();
		double ram2 = o2.getRam();
		return (int) (ram1 - ram2);
	}

}
