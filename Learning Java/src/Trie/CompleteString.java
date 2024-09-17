package Trie;

public class CompleteString {

    static void completeString(){
        String[] words = {"nin", "ni", "ninja", "n", "ninj", "ninga"}; // out: ninja
//        String[] words = {"nin", "nfi", "nifnja", "dn", "nginj", "nwinga"}; // out: none


        Trie trie = new Trie();

        for(String str : words){
            trie.insert(str);
        }

        String longest = "";
        for(String str : words){
            if(trie.checkIfComplete(str)){
                if(str.equals(longest) && str.compareTo(longest) < 0)
                    longest = str;
                else if(str.length() > longest.length())
                    longest = str;
            }
        }

        System.out.println("longest complete string is: " + (longest.length() == 0 ? "none" : longest));
    }

}
