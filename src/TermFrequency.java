import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class TermFrequency {
    public void printList(List<String> doc) {
        for (String word : doc) {
            System.out.print(word + " ");
        }
        System.out.print("\n");
    }

    public void printlistofLists(List<List<String>> docs) {
        for (List<String> doc : docs) {
            for (String word : doc) {
                System.out.print(word + " ");
            }
            System.out.print("\n");
        }
    }

    public double tf(List<String> doc, String term) {
        double n = doc.size();
        double count = 0;
        for (String w : doc) {
            if (w.equals(term)) {
                count++;
                break;
            }
        }
        return Math.log(count / n);
    }

    public double idf(List<List<String>> docs, String term) {
        int N = docs.size();
        int count = 0;
        for (List<String> doc : docs) {
            if (doc.contains(term)) {
                count++;
            }
        }
        return Math.log( (double) N /count);
    }

    public Map<String, Double> tfIdf(List<String> doc, List<List<String>> docs) {
        Map<String, Double> tfIdfValues = new HashMap<>();
        Set<String> terms = new HashSet<>(doc);
        for (String term : terms) {
            double tf = tf(doc, term);
            double idf = idf(docs, term);
            tfIdfValues.put(term, tf * idf);
        }
        return tfIdfValues;
    }

    public double cosineSimilarity(Map<String, Double> vec1, Map<String, Double> vec2, Map<String, Double> vec3) {
        Set<String> allTerms = new HashSet<>(vec1.keySet());
        allTerms.addAll(vec2.keySet());
        allTerms.addAll(vec3.keySet());

        double dotProduct12 = 0.0;
        double dotProduct13 = 0.0;
        double dotProduct23 = 0.0;

        double normVec1 = 0.0;
        double normVec2 = 0.0;
        double normVec3 = 0.0;

        for (String term : allTerms) {
            double v1 = vec1.getOrDefault(term, 0.0);
            double v2 = vec2.getOrDefault(term, 0.0);
            double v3 = vec3.getOrDefault(term, 0.0);

            dotProduct12 += v1 * v2;
            dotProduct13 += v1 * v3;
            dotProduct23 += v2 * v3;

            normVec1 += v1 * v1;
            normVec2 += v2 * v2;
            normVec3 += v3 * v3;
        }
        double magnitudeVec1 = Math.sqrt(normVec1);
        double magnitudeVec2 = Math.sqrt(normVec2);
        double magnitudeVec3 = Math.sqrt(normVec3);

        double cosineSim12 = dotProduct12 / (magnitudeVec1 * magnitudeVec2);
        double cosineSim13 = dotProduct13 / (magnitudeVec1 * magnitudeVec3);
        double cosineSim23 = dotProduct23 / (magnitudeVec2 * magnitudeVec3);
        return (cosineSim12 + cosineSim13 + cosineSim23) / 3.0;
    }
    public static void main(String[] args) {
        TermFrequency freq = new TermFrequency();
        List<String> doc1 = Arrays.asList("the", "sky", "is", "blue");
        List<String> doc2 = Arrays.asList("the", "sun", "is", "bright");
        List<String> doc3 = Arrays.asList("the", "sun", "in", "the", "sky", "is", "bright");
        List<List<String>> corpus = Arrays.asList(doc1, doc2, doc3);

        freq.printList(doc1);
        freq.printList(doc2);
        freq.printList(doc3);

        System.out.println("\nDocument Collection:");
        freq.printlistofLists(corpus);

        double fre = freq.tf(doc1, "the");
        System.out.println("\nTF of 'the' in doc1: " + fre);

        double fre1 = freq.tf(doc3, "bright");
        System.out.println("TF of 'bright' in doc3: " + fre1);

        double idfThe = freq.idf(corpus, "the");
        System.out.println("IDF of 'the': " + idfThe);

        double idfBright = freq.idf(corpus, "bright");
        System.out.println("IDF of 'bright': " + idfBright);

        Map<String, Double> tfIdfDoc1 = freq.tfIdf(doc1, corpus);
        Map<String, Double> tfIdfDoc2 = freq.tfIdf(doc2, corpus);
        Map<String, Double> tfIdfDoc3 = freq.tfIdf(doc3, corpus);

        System.out.println("TF-IDF for doc1: " + tfIdfDoc1);
        System.out.println("TF-IDF for doc2: " + tfIdfDoc2);
        System.out.println("TF-IDF for doc3: " + tfIdfDoc3);

        double cosineSim = freq.cosineSimilarity(tfIdfDoc1, tfIdfDoc2, tfIdfDoc3);
        System.out.println("Cosine Similarity among doc1, doc2, and doc3: " + cosineSim);
    }
}
