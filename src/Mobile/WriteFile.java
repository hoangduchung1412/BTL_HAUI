package Mobile;

import java.io.*;
import java.util.*;

public class WriteFile {
	public static void outputList(List<Mobile> list) throws IOException {
			FileOutputStream outFile = new FileOutputStream("Mobile.bin");
			ObjectOutputStream out = new ObjectOutputStream(outFile);
			out.writeInt(list.size());
			for (Mobile Mobile : list) {
				out.writeObject(Mobile);
			}

			out.close();
	}
	
	public static List<Mobile> inputList( int n) throws IOException, ClassNotFoundException {
		FileInputStream inputFile = new FileInputStream("Mobile.bin");
		ObjectInputStream in = new ObjectInputStream(inputFile);

		in.readInt();
		List<Mobile> list = new ArrayList<>();
		for(int i = 0 ; i < n; i++) {
			list.add((Mobile)in.readObject());
		}
		in.close();
		return list;
	}
	
	public static int sizeOfList() throws IOException, ClassNotFoundException{
		FileInputStream inputFile = new FileInputStream("Mobile.bin");
		ObjectInputStream in = new ObjectInputStream(inputFile);
		
		int size = in.readInt();
		inputFile.close();
		in.close();
		return size;
	}
	
	public static List<Mobile> listFile(List<Mobile> list) throws IOException, ClassNotFoundException {
		outputList(list);
		list = inputList(sizeOfList());
		return list;
	}
}
