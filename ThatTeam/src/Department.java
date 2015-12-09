import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// TODO: Auto-generated Javadoc
// TODO:  
/**
 * The Class Department.
 */
public class Department {

	/**
	 * title.
	 */
	private String title;

	/**
	 * articles.
	 */
	public ArrayList<Article> articles;

	/**
	 * Constructs a new Department object.
	 *
	 * @param theTitle
	 *            the title
	 */
	public Department(String theTitle) {
		this.title = theTitle;
		articles = new ArrayList<Article>();
	}

	/**
	 * Sets title.
	 *
	 * @param newTitle
	 *            becomes the new title.
	 */
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}

	/**
	 * Gets title.
	 *
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets article.
	 *
	 * @param index
	 *            index
	 * @return article
	 */
	public Article getArticle(int index) {
		return articles.get(index);
	}

	/**
	 * Gets the list of all article related to particular departments.
	 *
	 * @return the article
	 */
	public List<Article> getArticle() {
		List<Article> list = (ArrayList<Article>) articles.stream().collect(
				Collectors.toList());

		// list.forEach(System.out::println);

		return list;

	}

	/**
	 * Adds the article.
	 *
	 * @param article
	 *            the article
	 */
	public void addArticle(Article article) {

		articles.add(article);
		System.out.println("List of articles " + articles.toString());

	}
	
	/**
	 * Removes the article from selected department.
	 *
	 * @param article the article to remove
	 */
	public void removeArticle(Article article) {

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).equals(article)) {
				articles.remove(article);
			}
		}

		System.out.println("deleted articles size: " + articles.size());
		System.out.println("List of articles After deleting: "
				+ articles.toString());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getTitle();
	}

	// /**
	// * Edits the article title.
	// *
	// * @param newTitle new title
	// */
	// public void editArticleTitle(String newTitle) {
	//
	// }

}
