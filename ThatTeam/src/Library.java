import java.io.File;
import java.util.ArrayList;

public class Library {
	
	private ArrayList<Department> departments;
	
	//private Department activeDepartment;

	
	//Blank Library
	public Library() {
	    
	}
	
	//Library from file
	public Library(File theFile) {
	    
	}

	public Department getDepartment(int index) {
		return departments.get(index);
	}

	public void addDepartment(Department department) {
		departments.add(department);
	}
	
	public void editDepartment(int index, String newTitle) {
	    departments.get(index).setTitle(newTitle);
	}


}
