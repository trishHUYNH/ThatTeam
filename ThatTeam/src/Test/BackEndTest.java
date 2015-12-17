package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Program.Article;
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
     * 
     * @author Trish Huynh
     */
    @Test
    public void testDepartment() {
        Library testLibrary = new Library();
        Department deptOne = new Department("Test Department 1");
        Department deptTwo = new Department("Test Department 2");
        Article articleOne = new Article("Article #1", "This is the first article");
        Article articleTwo = new Article("Article #2", "This is the second article");
        Article articleThree = new Article("Article #3", "This is the third article");
        
        testLibrary.addDepartment(deptOne);
        testLibrary.addDepartment(deptTwo);
        testLibrary.departments.get(0).articles.add(articleOne);
        testLibrary.departments.get(0).articles.add(articleTwo);
        testLibrary.departments.get(1).articles.add(articleThree);
        
        //assertTrue(testLibrary.departments.size() == 2);
        //assertTrue(testLibrary.departments.get(0).equals(deptOne));
        //assertTrue(testLibrary.departments.get(1).equals(deptTwo));
        
        assertTrue(deptOne.articles.size() == 2);
        
        
    }
    
    /**
     * Test article.
     */
    @Test
    public void testArticle() {
        
    }

}
