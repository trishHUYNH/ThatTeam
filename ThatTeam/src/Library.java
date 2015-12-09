import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.ObservableList;

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
	 */
	public Library() {
		departments = new ArrayList<Department>();
	}

	// TODO: Add a constructor for an existing list?

	/**
	 * Gets department.
	 *
	 * @param index
	 *            index
	 * @return department
	 */
	public Department getDepartment(int index) {
		return departments.get(index);
	}

	/**
	 * Gets the list of all department.
	 *
	 * @return the department
	 */
	public List<Department> getDepartment() {
		List<Department> list = (ArrayList<Department>) departments.stream()
				.collect(Collectors.toList());

		// list.forEach(System.out::println);

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
	

	/**
	 * Edits the department.
	 *
	 * @param index
	 *            index
	 * @param newTitle
	 *            new title
	 */
	public void editDepartment(int index, String newTitle) {
		departments.get(index).setTitle(newTitle);
	}

}
