package Mobile;

import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MobileManagerImpl manager = new MobileManagerImpl();
		manager.Danhsach();
		Mobile Mobile = new Mobile();
		do {
			System.out.println("\n\t----------------------------Menu---------------------------");
			System.out.println("\t1. Add Mobile");
			System.out.println("\t2. Edit Mobile");
			System.out.println("\t3. Del Mobile");
			System.out.println("\t4. Search Mobile by name");
			System.out.println("\t5. Search Mobile by price");
			System.out.println("\t6. Search Mobile by type");
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
				manager.addMobile(Mobile);
				break;
			case 2:
				manager.editMobile(Mobile);
				break;
			case 3:
				manager.delMobile(Mobile);
				break;
			case 4:
				System.out.print("Nhập name: ");
				System.out.print(manager.searchMobile(new Scanner(System.in).nextLine()));
				break;
			case 5:
				System.out.print("Nhập giá: ");
				System.out.print(manager.searchMobile(Double.parseDouble(new Scanner(System.in).nextLine())));
				break;
			case 6:
				System.out.print("Nhập loại: ");
				System.out.print(manager.searchMobileName(new Scanner(System.in).nextLine()));
				break;
			case 7:
				System.out.print("Nhập giá min($): ");
				System.out.print(manager.sortedMobile(Double.parseDouble(new Scanner(System.in).nextLine())));
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
