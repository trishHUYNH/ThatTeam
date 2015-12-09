import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author James Brewer
 * @version A
 * 
 */
public class Main {

    /**
     * Main method for starting the GUI.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Library mainLibrary = new Library();
        mainLibrary.addDepartment(new Department("ThisDepartment"));
        mainLibrary.addDepartment(new Department("ThisOtherDepartment"));
        
        mainLibrary.departments.get(0).addArticle(new Article("Article #1", "This is the first article"));
        mainLibrary.departments.get(0).addArticle(new Article("Article #2", "This is the second article"));
        mainLibrary.departments.get(1).addArticle(new Article("Article #3", "This is the third article"));
        
        
        /*
        System.out.println(mainLibrary.departments.size());
        for(int i = 0; i < mainLibrary.departments.size(); i++) {
        	System.out.println(mainLibrary.getDepartment(i).getTitle());
        }*/
        
        Window Interface = new Window(); 

        Interface.runWindow(mainLibrary);

    }

}
