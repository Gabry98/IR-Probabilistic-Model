/*Inside this Class we make a test of the Probabilistic Model, which is used for
 * Information Retrieval operations. This kind of model represents the ranking of
 * a document set, compared to a specified query, using the probabilities to determine 
 * which one is more relevant than the others for the query. The final ranking sorts 
 * the documents in descending order (the document with the high probability will be 
 * in first position, and so on).
 */

import java.util.LinkedList;

public class Client {
	public static void main(String[] args) {
		String[] terms = {"t1","t2","t3"}; //Initialize terms
		
		
		//We make the list of documents (including the query):
		LinkedList<String> cq = new LinkedList<String>();
		cq.add("t2");
		cq.add("t3");
		Document query = new Document(cq,terms);
		
		LinkedList<String> cd1 = new LinkedList<String>();
		cd1.add("t3");
		Document d1 = new Document(cd1,terms);
		
		LinkedList<String> cd2 = new LinkedList<String>();
		cd2.add("t2");
		Document d2 = new Document(cd2,terms);
		
		LinkedList<String> cd3 = new LinkedList<String>();
		cd3.add("t1");
		cd3.add("t2");
		Document d3 = new Document(cd3,terms);
		
		//We make the document set, which contains all the documents (except the query):
		LinkedList<Document> documents = new LinkedList<Document>();
		documents.add(d1);
		documents.add(d2);
		documents.add(d3);
		DocumentSet ds = new DocumentSet(documents);
		
		//We make the Probabilistic Model and then we calculate the similarity for documents
		ProbabilisticModel p = new ProbabilisticModel(ds);
		double[] similarity = p.execution(query);
		
		for(int i=0; i<similarity.length; i++) {
			System.out.print(similarity[i]+" ");
		}
	}
}
