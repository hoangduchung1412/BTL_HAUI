package Computer;

import java.io.*;
import java.util.*;

public class WriteFile {
	public static void outputList(List<Computer> list) throws IOException {
			FileOutputStream outFile = new FileOutputStream("Computer.bin");
			ObjectOutputStream out = new ObjectOutputStream(outFile);
			out.writeInt(list.size());
			for (Computer computer : list) {
				out.writeObject(computer);
			}

			out.close();
	}
	
	public static List<Computer> inputList( int n) throws IOException, ClassNotFoundException {
		FileInputStream inputFile = new FileInputStream("Computer.bin");
		ObjectInputStream in = new ObjectInputStream(inputFile);

		in.readInt();
		List<Computer> list = new ArrayList<>();
		for(int i = 0 ; i < n; i++) {
			list.add((Computer)in.readObject());
		}
		in.close();
		return list;
	}
	
	public static int sizeOfList() throws IOException, ClassNotFoundException{
		FileInputStream inputFile = new FileInputStream("Computer.bin");
		ObjectInputStream in = new ObjectInputStream(inputFile);
		
		int size = in.readInt();
		inputFile.close();
		in.close();
		return size;
	}
	
	public static List<Computer> listFile(List<Computer> list) throws IOException, ClassNotFoundException {
		outputList(list);
		list = inputList(sizeOfList());
		return list;
	}
}
