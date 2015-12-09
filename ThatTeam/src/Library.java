import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// TODO: Auto-generated Javadoc
/**
 * The Class Library.
 */
public class Library {

    /**
     * departments.
     */
    public ArrayList<Department> departments;

    /**
     * Constructs a blank Library object.
     * 
     */
    public Library() {
    	departments = new ArrayList<Department>();
    }
    
    /*
     * Copy constructor
     * 
     */
    public Library(Library copyLibrary) {
    	departments = new ArrayList<Department>(copyLibrary.departments);
    	for (int i = 0; i < copyLibrary.departments.size(); i++) {
    		departments.set(i, copyLibrary.departments.get(i));
    	}
    }
    
    //TODO: Add a constructor for an existing list?

    /**
     * Gets department.
     *
     * @param index index
     * @return department
     */
    public Department getDepartment(int index) {
        return departments.get(index);
    }
    
    /*
     * Mika's getDepartment
     */
	public List<Department> getAllDepartments() {
		List<Department> list = (ArrayList<Department>) departments.stream().collect(Collectors.toList());

		return list;

	}

    /**
     * Adds the department.
     *
     * @param department department
     */
    public void addDepartment(Department department) {
        departments.add(department);
    }

    /**
     * Edits the department.
     *
     * @param index index
     * @param newTitle new title
     */
    public void editDepartment(int index, String newTitle) {
        departments.get(index).setTitle(newTitle);
    }

}
