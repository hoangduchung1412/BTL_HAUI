package Housing;

import java.io.*;
import java.util.*;

public class WriteFile {
	public static void outputList(List<Housing> list) throws IOException {
			FileOutputStream outFile = new FileOutputStream("Housing.bin");
			ObjectOutputStream out = new ObjectOutputStream(outFile);
			out.writeInt(list.size());
			for (Housing housing : list) {
				out.writeObject(housing);
			}

			out.close();
	}
	
	public static List<Housing> inputList( int n) throws IOException, ClassNotFoundException {
		FileInputStream inputFile = new FileInputStream("Housing.bin");
		ObjectInputStream in = new ObjectInputStream(inputFile);

		in.readInt();
		List<Housing> list = new ArrayList<>();
		for(int i = 0 ; i < n; i++) {
			list.add((Housing)in.readObject());
		}
		in.close();
		return list;
	}
	
	public static int sizeOfList() throws IOException, ClassNotFoundException{
		FileInputStream inputFile = new FileInputStream("Housing.bin");
		ObjectInputStream in = new ObjectInputStream(inputFile);
		
		int size = in.readInt();
		inputFile.close();
		in.close();
		return size;
	}
	
	public static List<Housing> listFile(List<Housing> list) throws IOException, ClassNotFoundException {
		outputList(list);
		list = inputList(sizeOfList());
		return list;
	}
}
