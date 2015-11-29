import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Library.
 */
public class Library {

    /**
     * departments.
     */
    private ArrayList<Department> departments;

    /**
     * Constructs a blank Library object.
     */
    public Library() {

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
