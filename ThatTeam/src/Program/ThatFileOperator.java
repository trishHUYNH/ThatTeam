/**
 * @author Brandon Thomas
 * 
 * Methods modified by James Brewer
 * 
 * This object handles writing to files and loading data from files. 
 * 
 */

package Program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ThatFileOperator {
    private static final String ARTICLE_HEADER = "ARTICLE___BEGIN";
    private static final String ARTICLE_END = "ARTICLE___END";

    private static final String DEPARTMENT_HEADER = "DEPARTMENT___BEGIN";
    private static final String DEPARTMENT_END = "DEPARTMENT___END";
    
    private static final String SOURCE_IDENTIFIER = "SOURCE___BEGIN";
    private static final String SOURCE_END = "SOURCE___END";
    
    private static final String TITLE_BEGIN = "ARTICLE___TITLE___BEGIN";
    private static final String TITLE_END = "ARTICLE___TITLE___END";


    /**
     * Functions I want to implement
     * (RFT) = Ready for testing
     * 1. Load every article from a text file to my file (RFT)
     * 2. Load every textblock from a text file to my file (RFT)
     * 3. Load every category from a text file to my file (RFT)
     * 4. Add an article to my file (RFT)
     * 5. Add a Department to my file (RFT)
     * 6. Add a category to my file (RFT)
     * 7. Edit an article from my file and save it back to my file (RFT)
     * 8. Edit an category from my file and save it back to my file (RFT)
     * 9. Edit an textblock from my file and save it back to my file (RFT)
     */
    File file;
    BufferedReader fileReader;
    
    BufferedWriter fileAppender;
    FileWriter fileWriter;
    
    private static boolean appendMode = true;
    /**
     * Constructors
     * The basic constructor implements a new text file for you 
     * whereas the other constructor accepts a file and handles data to and
     * from that file.
     * 
     */
    public ThatFileOperator(){
        file = new File("/library.txt");
        try {
            fileWriter = new FileWriter(file, !appendMode);
            fileAppender = new BufferedWriter(new FileWriter(file, appendMode));
        } catch (IOException e1) {
            System.err.println("Failed to create file properly, derp");
        }

    }
    public ThatFileOperator(File x){
        file = x;
        try {
            fileAppender = new BufferedWriter(new FileWriter(file, true));
            fileReader = new BufferedReader(new FileReader(file));
        } catch (IOException e1) {
            System.err.println("Failed to create file properly, derp");
        }
    }
    
    /**
     * add an article to the text file.
     * 
     * @author Brandon Thomas
     * Modified by James for multi-line text
     * @param article
     * @throws IOException
     */
    public void addArticle(String article, String sourceDepartment, String articleTitle) throws IOException{        
        fileAppender.newLine();
        fileAppender.write(ARTICLE_HEADER);
        fileAppender.newLine();
        fileAppender.write(TITLE_BEGIN);
        fileAppender.newLine();
        fileAppender.write(articleTitle);
        fileAppender.newLine();
        fileAppender.write(TITLE_END);
        fileAppender.newLine();
        fileAppender.write(SOURCE_IDENTIFIER);
        fileAppender.newLine();
        fileAppender.write(sourceDepartment);
        fileAppender.newLine();
        fileAppender.write(SOURCE_END);
        fileAppender.newLine();
        fileAppender.write(article);
        fileAppender.newLine();
        fileAppender.write(ARTICLE_END);
        fileAppender.flush();
    }

    /**
     * add a department to the text file.
     * @param article
     * @throws IOException
     */
    public void addDepartment(String article) throws IOException{       
        fileAppender.newLine();
        fileAppender.write(DEPARTMENT_HEADER);
        fileAppender.newLine();
        fileAppender.write(article);
        fileAppender.newLine();
        fileAppender.write(DEPARTMENT_END);
        fileAppender.flush();
    }
    /**
     * Returns a list of type string of every article within the text file.
     * @return
     * @throws IOException
     */
    public List<String> getArticles() throws IOException{
        List<String> list = new ArrayList<String>();
        StringBuilder line = new StringBuilder();
        String test = "";
        while((test = fileReader.readLine()) != null){
            if(test.contains(ARTICLE_HEADER)){
                while(!(test = fileReader.readLine()).contains(ARTICLE_END)){
                    if(test.contains(SOURCE_IDENTIFIER)){
                        test = fileReader.readLine();
                        line.append("Source Department: ");
                    }
                    if(test.contains(ARTICLE_END)) break;
                    line.append(test);
                }
            }
            if(!line.toString().equals("")){
                list.add(line.toString());
            }
            line = new StringBuilder();
        }
        return list;
    }
    /**
     * Returns a list of department objects, filled with the articles they contain.
     * 
     * @author Brandon Thomas, James Brewer
     * @return list of department objects
     * @throws IOException
     */
    public List<Department> getDepartments() throws IOException{
        List<Department> deptList = new ArrayList<Department>();
        StringBuilder line = new StringBuilder();
        String test = "";
        
        
        while((test = fileReader.readLine()) != null){
            if(test.contains(DEPARTMENT_HEADER)){
                while(!(test = fileReader.readLine()).contains(DEPARTMENT_END)){
                    if(test.contains(DEPARTMENT_END)) break;
                    line.append(test);
                }
            }
            if(!line.toString().equals("")){
                deptList.add(new Department(line.toString()));
            }
            line = new StringBuilder();
        }
        
        /*
         * 
         */
        
        fileAppender = new BufferedWriter(new FileWriter(file, true));
        fileReader = new BufferedReader(new FileReader(file));
        
        Article tempArt = new Article("");
        String deptName = "";
        
        while((test = fileReader.readLine()) != null){
            if(test.contains(ARTICLE_HEADER)){
                while(!(test = fileReader.readLine()).contains(ARTICLE_END)){
                    if(test.contains(TITLE_BEGIN)) {
                        while(!(test = fileReader.readLine()).contains(TITLE_END)){
                            tempArt = new Article(test);
                        }
                    } else if(test.contains(SOURCE_IDENTIFIER)) {
                        while(!(test = fileReader.readLine()).contains(SOURCE_END)){
                            deptName = test;
                        }
                    } else {
                        if(test.equals("")) {
                            line.append("\n");
                        }else if(!test.equals("")){
                            line.append(test + "\n");
                        }
                    }
                }
                
                line.deleteCharAt(line.length() - 1); //Remove the last new line character
                
                tempArt.editText(line.toString());
                for(Department dept:deptList) {
                    if(dept.getTitle().equals(deptName)) {
                        dept.addArticle(tempArt);
                        break;
                    }
                }
            }
            line = new StringBuilder();
        }
        
        
        return deptList;
    }

    /**
     * To use this method properly I'd recommend something like:
     * for(String art: ThatFileOperator.getArticles()){
     *      if(art.equals("the article I want to change in string form")){
     *              editArticles(art, "the new article");
     *      }
     * }
     * 
     * This implementation is recommended for each "edit" method.
     * @param articleToChange
     * @param updatedArticle
     * @throws IOException
     */
    public void editArticle(String articleToChange, String updatedArticle) throws IOException{
        File updatedFile = new File("TheActualLibrary.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(updatedFile));
        String test = "";

        int i = 0;
        System.out.println(fileReader.toString() + "DNE?");
        try{
            while(!(test = fileReader.readLine()).equals(articleToChange) ){
                System.out.println(i++);
                bw.newLine();
                bw.write(test);
            }
        }catch (Exception e){
            System.err.println("This doesn't exist.");
        }
        while((test = fileReader.readLine()) != null){
            bw.newLine();
            bw.write(test);
        }
        test = "";
        bw.newLine();
        bw.write(DEPARTMENT_HEADER);
        bw.newLine();
        bw.write(updatedArticle);
        bw.newLine();
        bw.write(DEPARTMENT_END);
        bw.close();
        fileReader.close();
        try {
            fileAppender = new BufferedWriter(new FileWriter(file, true));
            fileReader = new BufferedReader(new FileReader(file));
        } catch (IOException e1) {
            System.err.println("Failed to create file properly, derp");
        }
    }
    /**
     * To use this method properly I'd recommend something like:
     * for(String art: ThatFileOperator.getArticles()){
     *      if(art.equals("the article I want to change in string form")){
     *              editArticles(art, "the new article");
     *      }
     * }
     * @param departmentToChange
     * @param updatedDepartment
     * @throws IOException
     */
    public void editDepartment(String departmentToChange, String updatedDepartment) throws IOException{
        File updatedFile = new File("TheActualLibrary.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(updatedFile));
        String test = "";

        int i = 0;
        System.out.println(fileReader.toString() + "DNE?");
        try{
            while(!(test = fileReader.readLine()).equals(departmentToChange) ){
                System.out.println(i++);
                bw.newLine();
                bw.write(test);
            }
        }catch (Exception e){
            System.err.println("This doesn't exist.");
        }
        while((test = fileReader.readLine()) != null){
            bw.newLine();
            bw.write(test);
        }
        test = "";
        bw.newLine();
        bw.write(DEPARTMENT_HEADER);
        bw.newLine();
        bw.write(updatedDepartment);
        bw.newLine();
        bw.write(DEPARTMENT_END);
        bw.close();
        fileReader.close();
        try {
            fileAppender = new BufferedWriter(new FileWriter(file, true));
            fileReader = new BufferedReader(new FileReader(file));
        } catch (IOException e1) {
            System.err.println("Failed to create file properly, derp");
        }
    }

    /**
     * Use this at the end of main to close all file readers, if you want to so; most 
     * methods implement this already.
     */
    public void closeFileReader(){
        try {
            fileAppender.close();
        } catch (IOException e) {
            System.err.println("Failed to close, maybe file doesn't exist");
            e.printStackTrace();
        }
    }
    /**
     * Feed in a text file and if its properly formatted 
     * @param xFiles
     */
    public void updateLibraryFromFile(File xFiles){
        try{
            loadArticles(xFiles);
            loadDepartments(xFiles);
        }catch (Exception e){
            System.err.println("Can't find that file broh");
        }
        
    }
    /**
     * Loading files that are properly formatted to our current file.
     * @param xFiles
     * @throws IOException
     */
    public void loadArticles(File xFiles) throws IOException{
        String read = "";
        StringBuilder line = new StringBuilder("");
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(xFiles));
        } catch (FileNotFoundException e) {
            System.err.println("Can't find that file, son");
            return;
        }
        
        while((read = reader.readLine()) != null){
            if(read.contains(ARTICLE_HEADER)){
                while(!read.contains(ARTICLE_END)){
                    line.append(read);
                    read = reader.readLine();
                }
            }
        }
        reader.close();
        fileWriter.write(line.toString());
        fileWriter.close();

    }

    /**
     * Loading files that are properly formatted to our current file.
     * @param xFiles
     * @throws IOException
     */
    public void loadDepartments(File xFiles) throws IOException{
        String read = "";
        StringBuilder line = new StringBuilder("");
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(xFiles));
        } catch (FileNotFoundException e) {
            System.err.println("Can't find that file, son");
            return;
        }
        
        while((read = reader.readLine()) != null){
            if(read.contains(DEPARTMENT_HEADER)){
                while(!read.contains(DEPARTMENT_END)){
                    line.append(read);
                    read = reader.readLine();
                }
            }
        }
        reader.close();
        fileWriter.write(line.toString());
        fileWriter.close();

    }
    
    /**
     * Resets the file given a library object
     * 
     * @author James Brewer
     * @param current library
     */
    public void rewriteFile(Library lib) throws IOException{
        PrintWriter pw = new PrintWriter(file);
        pw.close();         //Effectively clears the file
        
        List<Department> deptList = lib.getDepartment();
        String deptTitle = "";
        for(Department dept:deptList) {
            deptTitle = dept.getTitle();
            addDepartment(deptTitle);
            
            for(Article art:dept.getArticle()) {
                addArticle(art.getText(), deptTitle, art.getTitle());
            }
            
        }
        
    }
}
