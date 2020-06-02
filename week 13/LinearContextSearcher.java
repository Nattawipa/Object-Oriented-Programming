import java.util.ArrayList;

 public class LinearContextSearcher extends ContextSearcher 
 {
	 // protected ArrayList<Word> sortedWords = null;
	 public LinearContextSearcher(String filename) 
	 {
		 super(filename);
	 }

	 public String find(Word query, int window) 
	 {
		 for (Word sort : sortedWords) 
		 {
			 if (query.equals(sort)) 
			 {
				 return getSnippet(sort, window);
			 }
		 }
		 return null;
	 }
}