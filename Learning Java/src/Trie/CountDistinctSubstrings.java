package Trie;

public class CountDistinctSubstrings {
    static void countDistinctSubstrings(){
//        String word = "abab";  // out: 7
        String word = "striver";  // out: 27
        Trie trie = new Trie();

        System.out.println(trie.countDistinctSubstrings(word));
    }
}