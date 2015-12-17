package Program;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThatFileOperator {
	private static final String ARTICLE_HEADER = "ARTICLE___BEGIN";
	private static final String ARTICLE_END = "ARTICLE___END";

	private static final String CATEGORY_HEADER = "CATEGORY___BEGIN";
	private static final String CATEGORY_END = "CATEGORY___END";

	private static final String DEPARTMENT_HEADER = "DEPARTMENT___BEGIN";
	private static final String DEPARTMENT_END = "DEPARTMENT___END";

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
		//updateLibraryFromFile(file);
	}
	public void addArticle(String article) throws IOException{		
		fileAppender.newLine();
		fileAppender.write(ARTICLE_HEADER);
		fileAppender.newLine();
		fileAppender.write(article);
		fileAppender.newLine();
		fileAppender.write(ARTICLE_END);
		fileAppender.flush();
	}
	public void addCategory(String article) throws IOException{	
		fileAppender.newLine();
		fileAppender.write(CATEGORY_HEADER);
		fileAppender.newLine();
		fileAppender.write(article);
		fileAppender.newLine();
		fileAppender.write(CATEGORY_END);
		fileAppender.flush();
	}
	public void addDepartment(String article) throws IOException{		
		fileAppender.newLine();
		fileAppender.write(DEPARTMENT_HEADER);
		fileAppender.newLine();
		fileAppender.write(article);
		fileAppender.newLine();
		fileAppender.write(DEPARTMENT_END);
		fileAppender.flush();
	}
	public List<String> getArticles() throws IOException{
		List<String> list = new ArrayList<String>();
		StringBuilder line = new StringBuilder();
		String test = "";
		while((test = fileReader.readLine()) != null){
			if(test.contains(ARTICLE_HEADER)){
				while(!(test = fileReader.readLine()).contains(ARTICLE_END)){
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
	public List<String> getDepartments() throws IOException{
		List<String> list = new ArrayList<String>();
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
				list.add(line.toString());
			}
			line = new StringBuilder();
		}
		return list;
	}
	public List<String> getCategories() throws IOException{
		List<String> list = new ArrayList<String>();
		StringBuilder line = new StringBuilder();
		String test = "";
		while((test = fileReader.readLine()) != null){
			if(test.contains(CATEGORY_HEADER)){
				while(!(test = fileReader.readLine()).contains(CATEGORY_END)){
					if(test.contains(CATEGORY_END)) break;
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
	 * To use this method properly I'd recommend something like:
	 * for(String art: ThatFileOperator.getArticles()){
	 * 		if(art.equals("the article I want to change in string form")){
	 * 				editArticles(art, "the new article");
	 * 		}
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
	 * 		if(art.equals("the article I want to change in string form")){
	 * 				editArticles(art, "the new article");
	 * 		}
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
	 * To use this method properly I'd recommend something like:
	 * for(String art: ThatFileOperator.getArticles()){
	 * 		if(art.equals("the article I want to change in string form")){
	 * 				editArticles(art, "the new article");
	 * 		}
	 * }
	 * @param departmentToChange
	 * @param updatedDepartment
	 * @throws IOException
	 */
	public void editCategory(String categoryToChange, String updatedCategory) throws IOException{
		File updatedFile = new File("TheActualLibrary.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(updatedFile));
		String test = "";

		int i = 0;
		System.out.println(fileReader.toString() + "DNE?");
		try{
			while(!(test = fileReader.readLine()).equals(categoryToChange) ){
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
		bw.write(updatedCategory);
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
	public void closeFileReader(){
		try {
			fileAppender.close();
		} catch (IOException e) {
			System.err.println("Failed to close, maybe file doesn't exist");
			e.printStackTrace();
		}
	}
	
	public void updateLibraryFromFile(File xFiles){
		try{
			loadArticles(xFiles);
			loadCategories(xFiles);
			loadDepartments(xFiles);
		}catch (Exception e){
			System.err.println("Can't find that file broh");
		}
		
	}
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
	public void loadCategories(File xFiles) throws IOException{
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
			if(read.contains(CATEGORY_HEADER)){
				while(!read.contains(CATEGORY_END)){
					line.append(read);
					read = reader.readLine();
				}
			}
		}
		reader.close();
		fileWriter.write(line.toString());
		fileWriter.close();
	}
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
}
