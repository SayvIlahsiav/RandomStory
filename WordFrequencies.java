import java.util.*;
import edu.duke.*;

/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    private void findUnique() {
        myWords.clear();
        myFreqs.clear();
        
        FileResource res = new FileResource();
        for (String s : res.words()) {
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1) {
                myWords.add(s);
                myFreqs.add(1);
            } else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value + 1);
            }
        }
    }
    
    public void testFindUnique() {
        findUnique();
        System.out.println("Number of unique words: " + myWords.size());
        for(int k=0; k < myWords.size(); k++){
            System.out.println(myFreqs.get(k) + "\t" + myWords.get(k));
        }
    }
    
    private int findIndexOfMax() {
        int maxIndex = 0; // Start with the first index
        int max = myFreqs.get(0); // Assume the first frequency is the max to start
        for(int k = 0; k < myFreqs.size(); k++) {
            if (myFreqs.get(k) > max) {
                max = myFreqs.get(k);
                maxIndex = k; // Update maxIndex when a new max is found
            }
        }
        return maxIndex; // Return the index of the max frequency
    }
    
    public void testFindIndexOfMax() {
        int maxIndex = findIndexOfMax();
        if(maxIndex != -1) { // Check if the list is not empty
            System.out.println("The word that occurs most often and its count are: " + myWords.get(maxIndex) + "\t" + myFreqs.get(maxIndex));
        } else {
            System.out.println("No words found.");
        }
    }
    
    public static void main(String[] args) {
        WordFrequencies wf = new WordFrequencies();
        wf.testFindUnique();
        wf.testFindIndexOfMax();
    }

}
