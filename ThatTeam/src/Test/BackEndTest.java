package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Program.Department;
import Program.Library;

// TODO: Auto-generated Javadoc
/**
 * The Class BackEndTest.
 *
 * @author James Brewer
 * @version 12_16_2015
 */
public class BackEndTest {

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test the library class.
     * 
     * Adding, retrieving, and removing articles should act as expected.
     * 
     * @author James Brewer
     */
    @Test
    public void testLibrary() {
        Library lb = new Library();
        Department dpt = new Department("Test dept1");
        Department dpt2 = new Department("Test dept2");
        
        lb.addDepartment(dpt);
        lb.addDepartment(dpt2);
        
        assertTrue(dpt.equals(lb.getDepartment(0)));
        assertTrue(dpt2.equals(lb.getDepartment(1)));
        
        assertTrue(lb.getDepartment().size() == 2);
        
        lb.removeDepartment(dpt);
        assertTrue(dpt2.equals(lb.getDepartment(0)));
        assertTrue(lb.getDepartment().size() == 1);
        
    }
    
    /**
     * Test department.
     */
    @Test
    public void testDepartment() {
        
    }
    
    /**
     * Test article.
     */
    @Test
    public void testArticle() {
        
    }

}
