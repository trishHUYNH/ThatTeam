package Program;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Library class. Stores a list of departments, representing the whole library.
 * @Author Mika Kaur, James Brewer
 * @version 12_17_2015
 */
public class Library {

	/**
	 * Collection of department
	 */
	public ArrayList<Department> departments;

	/**
	 * Constructs a blank Library object.
	 */
	public Library() {
		departments = new ArrayList<Department>();
	}

	// TODO: Add a constructor for an existing list?

	/**
	 * Gets a department.
	 *
	 * @author James Brewer
	 * @param index
	 *            index
	 * @return department
	 */
	public Department getDepartment(int index) {
	    System.out.println(departments.get(index).getTitle());
		return departments.get(index);
	}

	/**
	 * Gets the list of all departments.
	 *
	 * @author Mika Kaur
	 * @return the department
	 */
	public List<Department> getDepartment() {
		List<Department> list = (ArrayList<Department>) departments.stream()
				.collect(Collectors.toList());

		return list;

	}

	/**
	 * Adds the department.
	 *
	 * @author James Brewer
	 * @param department
	 *            department
	 */
	public void addDepartment(Department department) {

		departments.add(department);
//		System.out.println(department.getTitle());

	}
	
	/**
	 * Removes the department from the list of departments.
	 *
	 * @author Mika Kaur
	 * @param department the department to remove from the list 
	 */
	public void removeDepartment(Department department) {

		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).equals(department)) {
				departments.remove(department);
				break;  //Department found and removed, no need to search further
			}
		}

	}

}
