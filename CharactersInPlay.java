import java.util.*;
import edu.duke.*;

/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharactersInPlay {
    private ArrayList<String> charNames;
    private ArrayList<Integer> charCounts;
    
    public CharactersInPlay() {
        charNames = new ArrayList<String>();
        charCounts = new ArrayList<Integer>();
    }
    
    private void update(String person) {
        int index = charNames.indexOf(person);
            if(index == -1) {
                charNames.add(person);
                charCounts.add(1);
            }
            else {
                int value = charCounts.get(index);
                charCounts.set(index, value+1);
            }
    }
    
    private void findAllCharacters() {
        charNames.clear();
        charCounts.clear();
        FileResource res = new FileResource();
        for (String s : res.lines()) {
            int endIndex = s.indexOf(".");
            if (endIndex != -1) {
                String person = s.substring(0, endIndex);
                update(person);
            }
        }
    }
    
    public void testFindAllCharacters() {
        findAllCharacters();
        for(int k=0; k < charNames.size(); k++){
            if(charCounts.get(k) > 1) {
                System.out.println(charCounts.get(k) + "\t" + charNames.get(k).trim());
            }
        }
    }
    
    private void charactersWithNumParts(int num1, int num2) {
        findAllCharacters();
        for(int k=0; k < charNames.size(); k++){
            if(charCounts.get(k) >= num1 && charCounts.get(k) <= num2) {
                System.out.println(charCounts.get(k) + "\t" + charNames.get(k).trim());
            }
        }
    }
    
    public void testCharactersWithNumParts() {
        charactersWithNumParts(2, 10);
    }
    
    public static void main(String[] args) {
        CharactersInPlay cip = new CharactersInPlay();
        cip.testCharactersWithNumParts();
    }

}
