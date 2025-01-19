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

        trie.erase("apple");
        trie.erase("apple");
// here, in this implementation, erase simply alters the endswith and prefixcount counters, doesn't actually delete the node.
// hence, after erase(), any count related functions would work in accordance with the number of erase(),
// but any boolean or actual search related functions would work as if erase() never happened, this is because,
// search functions work based on checking the existence of the node, not the counters.
        System.out.println("Search words equal to apple: " +
                trie.search("appl"));

        System.out.println("Search words starting with appl: " +
                trie.startsWith("appl"));
    }
}
