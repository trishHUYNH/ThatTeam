package Program;

import java.io.File;
import java.util.ArrayList;

/**
 * The starting point of the program
 * 
 * @author James Brewer
 * @version 12_17_2015
 */
public class Main {

    /**
     * Main method for starting the GUI.
     *
     * @author James Brewer
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Window Interface = new Window();
        
        Library mainLib = new Library();
        ArrayList<String> deptTitles = new ArrayList<String>();
        
        ThatFileOperator TFO = new ThatFileOperator(new File("library.txt"));
        
        
        //deptTitles.addAll(TFO.getDepartments());
        
        
        Interface.runWindow(mainLib);

    }

}
