import java.util.ArrayList;

public class Department {
    
        private String title;

		private ArrayList<Article> articles;
		
		public Department(String theTitle) {
			this.title = theTitle;
		}
		
		public void setTitle(String newTitle) {
		    this.title = newTitle;
		}
		
		public String getTitle() {
		    return title;
		}

		public Article getArticle(int index) {
			return articles.get(index);
		}
		
		public void editArticleTitle(String newTitle) {
			
		}
		
		public String toString() {
		    return title;
		}
		
		
}
