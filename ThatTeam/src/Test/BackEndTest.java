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
        
        assertTrue(lb.departments.size() == 2);
        
        lb.removeDepartment(dpt);
        assertTrue(dpt2.equals(lb.getDepartment(0)));
        assertTrue(lb.departments.size() == 1);
        
    }
    
    /**
     * Test Department class.
     * 
     * Tests for getTitle, addArticle, getArticle, and removeArticle
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
        //Add two articles to deptOne
        testLibrary.departments.get(0).addArticle(articleOne);
        testLibrary.departments.get(0).addArticle(articleTwo);
        //Add one article to deptTwo
        testLibrary.departments.get(1).addArticle(articleThree);
        
        //Test getTitle for each department name
        assertEquals(testLibrary.departments.get(0).getTitle(), "Test Department 1");
        assertEquals(testLibrary.departments.get(1).getTitle(), "Test Department 2");
        
        //Test getArticle from Department
        assertEquals(testLibrary.departments.get(0).articles.size(), 2);
        assertEquals(testLibrary.departments.get(0).getArticle(0), articleOne);
        assertEquals(testLibrary.departments.get(0).getArticle(1), articleTwo);
        
        //Test removeArticle from Department
        //Remove articleOne from deptOne
        testLibrary.departments.get(0).removeArticle(articleOne);
        assertEquals(testLibrary.departments.get(0).articles.size(), 1);
        assertEquals(testLibrary.departments.get(0).getArticle(0), articleTwo);
        
        //Test Department Two
        assertEquals(testLibrary.departments.get(1).articles.size(), 1);
        assertEquals(testLibrary.departments.get(1).articles.get(0), articleThree);
        
        //Test removeArticle from Department
        //Remove articleThree from deptTwo
        testLibrary.departments.get(1).removeArticle(articleThree);
        assertTrue(testLibrary.departments.get(1).articles.isEmpty());
        
        
    }
    
    /**
     * Test Article class
     * Tests for getText, getTitle, editText, and setTitle from Article
     * 
     * @author Trish Huynh
     */
    @Test
    public void testArticle() {
        Library testLibrary = new Library();
        Department deptOne = new Department("Test Department 1");
        Department deptTwo = new Department("Test Department 2");
        Article articleOne = new Article("Article #1", "This is the first article");
        Article articleTwo = new Article("Article #2", "This is the second article");
        Article articleThree = new Article("Article #3", "This is the third article");
        
        testLibrary.addDepartment(deptOne);
        testLibrary.addDepartment(deptTwo);
        //Add two articles to deptOne
        testLibrary.departments.get(0).addArticle(articleOne);
        testLibrary.departments.get(0).addArticle(articleTwo);
        //Add one article to deptTwo
        testLibrary.departments.get(1).addArticle(articleThree);
        
        //Test getText from Article
        assertEquals(testLibrary.departments.get(0).getArticle(0).getText(), "This is the first article");
        assertEquals(testLibrary.departments.get(0).getArticle(1).getText(), "This is the second article");
        assertEquals(testLibrary.departments.get(1).getArticle(0).getText(), "This is the third article");
        
        //Test getTitle from Article
        assertEquals(testLibrary.departments.get(0).getArticle(0).getTitle(), "Article #1");
        assertEquals(testLibrary.departments.get(0).getArticle(1).getTitle(), "Article #2");
        assertEquals(testLibrary.departments.get(1).getArticle(0).getTitle(), "Article #3");
        
        //Test editText from Article
        testLibrary.departments.get(0).getArticle(0).editText("Changing Article #1 for testing");
        assertEquals(testLibrary.departments.get(0).getArticle(0).getText(), "Changing Article #1 for testing");
        
        //Test setTitle from Article
        System.out.println("Changing Article #2 to Test Article");
        testLibrary.departments.get(0).getArticle(1).setTitle("Test Article");
        assertEquals(testLibrary.departments.get(0).getArticle(1).getTitle(), "Test Article");
    }

}
