import java.util.List;
import java.util.Arrays;

public class ProbabilisticModel {
	private DocumentSet d;
	private double[] similarity,ni;
	
	public ProbabilisticModel(DocumentSet d) {
		this.d = d;
		similarity = new double[d.getDocumentList().size()];
		ni = new double[d.getDocumentList().size()];
	}
	
	public double[] execution(Document query) { //The main method for the similarity
		int[] cq = query.getContainer();
		
		for(int i=0; i<cq.length; i++) {
			if(cq[i]==1) verifySimilarity(cq,i);
		}

		Arrays.sort(similarity);
		makeRanking();
		
		return similarity;
	}
	
	private void verifySimilarity(int[] cq, int i) { //Calculates the similarity
		List<Document> documents = d.getDocumentList();
		double probKiNotRelevant = 0.0;
		
		for(int j=0; j<documents.size(); j++) {
			if(documents.get(j).getContainer()[i]==cq[i]) ni[i]++;
		}
		probKiNotRelevant = ni[i]/documents.size();
		
		
		for(int k = 0; k<similarity.length; k++) {
			if(documents.get(k).getContainer()[i]==cq[i]) {
				similarity[k] = Math.log10((1-probKiNotRelevant)/probKiNotRelevant);
			}
		}
		
	}
	
	private void makeRanking() { //Makes the final ranking after calculate the similarity
		if (similarity == null || similarity.length < 2) { return; } 
		for (int i = 0; i < similarity.length / 2; i++) { 
			double temp = similarity[i]; 
			similarity[i] = similarity[similarity.length - 1 - i]; 
			similarity[similarity.length - 1 - i] = temp; 
		}
	}
}
