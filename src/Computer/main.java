package Computer;

import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComputerManagerImpl manager = new ComputerManagerImpl();
		manager.init();
		Computer computer = new Computer();
		do {
			System.out.println("\n\t----------------------------Menu---------------------------");
			System.out.println("\t1. Add computer");
			System.out.println("\t2. Edit computer");
			System.out.println("\t3. Del computer");
			System.out.println("\t4. Search computer by name");
			System.out.println("\t5. Search computer by price");
			System.out.println("\t6. Search computer by type");
			System.out.println("\t7. Sorted housing by price");
			System.out.println("\t8. Sorted housing by ram");
			System.out.println("\t9. Show list");
			System.out.println("\t0. Exit");
			System.out.println("\t-----------------------------End-----------------------------");

			Scanner sc = new Scanner(System.in);
			System.out.print("Nhập lựa chọn của bạn: ");
			int choise = sc.nextInt();
			
			switch (choise) {
			case 1:
				manager.addComputer(computer);
				break;
			case 2:
				manager.editComputer(computer);
				break;
			case 3:
				manager.delComputer(computer);
				break;
			case 4:
				System.out.print("Nhập name: ");
				System.out.print(manager.searchComputerByName(new Scanner(System.in).nextLine()));
				break;
			case 5:
				System.out.print("Nhập giá: ");
				System.out.print(manager.searchComputerByPrice(Double.parseDouble(new Scanner(System.in).nextLine())));
				break;
			case 6:
				System.out.print("Nhập loại: ");
				System.out.print(manager.searchComputerByType(new Scanner(System.in).nextLine()));
				break;
			case 7:
				System.out.print("Nhập giá min($): ");
				System.out.print(manager.sortedComputerByPrice(Double.parseDouble(new Scanner(System.in).nextLine())));
				break;
			case 8:
				System.out.print("Nhập ram min(GB): ");
				System.out.print(manager.sortedComputerByRam(Integer.parseInt(new Scanner(System.in).nextLine())));
				break;
			case 9:
				manager.show();
				break;
			case 0:
				System.out.println("Thoát hệ thống thành công!");
				return;
			default:
				System.out.println("Lựa chọn không hợp lệ!");
			}
		} while (true);

	}

}
