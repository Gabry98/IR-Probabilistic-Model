import java.util.List;

public class DocumentSet {
	private List<Document> documents;
	
	public DocumentSet(List<Document> documents) {
		this.documents = documents;
	}
	
	public void addDocumentList(List<Document> documents) { //Adds a list of documents
		documents.addAll(documents);
	}
	
	public List<Document> getDocumentList() { //Returns the list of documents
		return documents;
	}
	
	public void addDocument(Document d) { //Adds a document
		documents.add(d);
	}
	
	public void removeDocument(Document d) { //Removes a document
		documents.remove(d);
	}
	
	public Document getDocument(int index) { //Returns a document
		return documents.get(index);
	}
	
	public long contains(String Ki) { //Checks which document contains the term Ki
		return documents.stream().filter(d -> d.contains(Ki)).count();
	}
}
