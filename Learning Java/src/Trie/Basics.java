package Trie;

public class Basics {
    static void basics(){
        Trie trie = new Trie();
//        System.out.println("Inserting words: Striver, Striving, String, Strike");
        trie.insert("striver");
        trie.insert("striving");
        trie.insert("string");
        trie.insert("apple");
        trie.insert("strike");
        trie.insert("appl");
        trie.insert("apple");
        trie.insert("appl");
        trie.insert("apps");
        trie.insert("apple");


        System.out.println("Search if Strawberry exists in trie: " +
                (trie.search("strawberry") ? "True" : "False"));

        System.out.println("Search if Strike exists in trie: " +
                (trie.search("strike") ? "True" : "False"));

        System.out.println("If words in Trie start with Stri: " +
                (trie.startsWith("stri") ? "True" : "False"));

        System.out.println("If words in Trie start with Appl: " +
                (trie.startsWith("appl") ? "True" : "False"));

        System.out.println("Count words starting with stri: " +
                trie.countWordsStartingWith("stri"));

        System.out.println("Count words equal to apple: " +
                trie.countWordsEqualTo("apple"));

        System.out.println("Count words starting with appl: " +
                trie.countWordsStartingWith("appl"));

        System.out.println("Count words equal to appl: " +
                trie.countWordsEqualTo("appl"));

        trie.erase("apple");

        System.out.println("Count words equal to apple: " +
                trie.countWordsEqualTo("apple"));

        System.out.println("Count words starting with appl: " +
                trie.countWordsStartingWith("appl"));
    }
}
