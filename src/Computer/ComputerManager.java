package Computer;

import java.util.List;

public interface ComputerManager {
	public boolean addComputer(Computer c);
	public boolean editComputer(Computer c);
	public boolean delComputer(Computer c);
	public List<Computer> searchComputerByName(String product_name);
	public List<Computer> searchComputerByPrice(double product_price);
	public List<Computer> searchComputerByType(String type);
	public List<Computer> sortedComputerByPrice(double product_price);
	public List<Computer> sortedComputerByRam(int ram);
}
