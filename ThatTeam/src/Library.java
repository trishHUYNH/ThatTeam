import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Library class. Stores a list of departments, representing the whole library.
 * @Author Mika Kaur, James Brewer
 * @version 12_16_2015
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
	 * @param index
	 *            index
	 * @return department
	 */
	public Department getDepartment(int index) {
		return departments.get(index);
	}

	/**
	 * Gets the list of all departments.
	 *
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
	 * @param department
	 *            department
	 */
	public void addDepartment(Department department) {

		departments.add(department);
		System.out.println("departments size: " + departments.size());
		System.out.println("List of departments: " + departments.toString());

	}
	
	/**
	 * Removes the department from the list of departments.
	 *
	 * @param department the department to remove from the list 
	 */
	public void removeDepartment(Department department) {

		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).equals(department)) {
				departments.remove(department);
			}
		}

		System.out.println("deleted departments size: " + departments.size());
		System.out.println("List of departments After deleting: "
				+ departments.toString());

	}

}
