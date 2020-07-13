import java.util.List;

public class Document {
	private List<String> content;
	private int[] binaryContainer;
	
	public Document(List<String> content, String[] terms) {
		this.content = content;
		binaryContainer = new int[terms.length];
		initializeContainer(terms);
	}
	
	public void addTerm(String t) { //Adds a term to the document
		content.add(t);
	}
	
	public void removeTerm(String t) { //Removes a term to the document
		content.remove(t);
	}
	
	public String getTerm(int index) { //Returns a term
		return content.get(index);
	}
	
	public List<String> getContent(){ //Returns the entire list of terms
		return content;
	}
	
	public boolean contains(String Ki) { //Checks if the document contains the term Ki
		return content.contains(Ki);
	}
	
	public int[] getContainer() { //Returns the container that shows which term the document has
		return binaryContainer;
	}
	
	private void initializeContainer(String[] terms) { //initializes the container after making the document
		for(int i=0; i<terms.length; i++) {
			if(content.contains(terms[i])) binaryContainer[i] = 1;
			else binaryContainer[i] = 0;
		}
	}
}
