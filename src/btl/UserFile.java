package btl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserFile {

	public static void outputList(List<String> list) throws IOException {
		FileOutputStream outFile = new FileOutputStream("Account.bin");
		ObjectOutputStream out = new ObjectOutputStream(outFile);
		out.writeInt(list.size());
		for (String name : list) {
			out.writeObject(name);
		}

		out.close();
	}

	public static List<String> inputList(int n) throws IOException, ClassNotFoundException {
		FileInputStream inputFile = new FileInputStream("Account.bin");
		ObjectInputStream in = new ObjectInputStream(inputFile);

		in.readInt();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add((String) in.readObject());
		}
		in.close();
		return list;
	}

	public static int sizeOfList() throws IOException, ClassNotFoundException {
		FileInputStream inputFile = new FileInputStream("Housing.bin");
		ObjectInputStream in = new ObjectInputStream(inputFile);

		int size = in.readInt();
		inputFile.close();
		in.close();
		return size;
	}

	public static List<String> listFile(List<String> list) throws IOException, ClassNotFoundException {
		outputList(list);
		list = inputList(sizeOfList());
		return list;
	}
}
