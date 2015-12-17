package Program;

import java.io.File;

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
        
        ThatFileOperator TFO = new ThatFileOperator(new File("library.txt"));
        
        Interface.runWindow(new Library());

    }

}
