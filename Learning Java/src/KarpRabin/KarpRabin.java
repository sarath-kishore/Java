package KarpRabin;
import java.util.*;
public class KarpRabin {
    final private int PRIME = 101;

    private double getHash(String str){
        double hash = 0;
        for(int i=0; i<str.length(); i++){
            hash += str.charAt(i) * Math.pow(PRIME,i);
        }
        return hash;
    }

    private double rollHash(double oldHash, char firstChar, char newLastChar, int patternLength){
        double newHash = (oldHash - firstChar) / PRIME;
        newHash += newLastChar * Math.pow(PRIME, patternLength-1);

        return newHash;
    }

    public void search(String text, String pattern){
        double patternHash = getHash(pattern);
        int patternLength = pattern.length();
        double textHash = getHash(text.substring(0,patternLength));

        for(int i=0; i<= text.length() - patternLength; i++){
            if(textHash == patternHash){
                if(pattern.equals(text.substring(i, patternLength+i))){
                    System.out.println("Pattern found at index: "+i);
                    return;
                }
            }
            if(i<text.length()-patternLength)
                textHash = rollHash(textHash, text.charAt(i), text.charAt(patternLength+i), patternLength);
        }
        System.out.println("Pattern not found");
    }
}
