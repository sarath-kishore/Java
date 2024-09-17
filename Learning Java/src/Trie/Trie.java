package Trie;

public class Trie {

    private class Node{
        private Node[] links;
        private boolean isEnd;
        private int cp; // prefix count
        private int ew; // ends with

        Node(){
            links = new Node[26];
            isEnd = false;
        }

        void setEnd(){
            this.isEnd = true;
        }

        boolean getEnd(){
            return this.isEnd;
        }

        boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }

        void put(char ch){
            links[ch - 'a'] = new Node();
        }

        Node get(char ch){
            Node child = links[ch - 'a'];
            return child;
        }

        void setCp(int i){
            this.cp += i;
        }

        int getCp(){
            return this.cp;
        }

        void setEw(int i){
            this.ew += i;
        }

        int getEw(){
            return this.ew;
        }
    }

    private Node root;

    Trie(){
        this.root = new Node();
    }
    void insert(String word){
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(!curr.containsKey(ch))
                curr.put(ch);
            curr = curr.get(ch);
            curr.setCp(1); // increment prefix count on the child

        }
        curr.setEnd(); // set the last pointer as end of a word
        curr.setEw(1); // increment ends with counter on the child
        System.out.println("Inserted: " + word);
    }

    boolean search(String word){
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(!curr.containsKey(ch))
                return false;
            curr = curr.get(ch);
        }
        return curr.getEnd() == true;
    }

    boolean startsWith(String prefix){
        Node curr = root;
        for(char ch : prefix.toCharArray()){
            if(!curr.containsKey(ch))
                return false;
            curr = curr.get(ch);
        }
        return true;
    }

    int countWordsStartingWith(String word){
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(!curr.containsKey(ch))
                return 0;
            curr = curr.get(ch);
        }

        return curr.getCp();
    }

    int countWordsEqualTo(String word){
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(!curr.containsKey(ch))
                return 0;
            curr = curr.get(ch);
        }

        return curr.getEw();
    }

    void erase(String word){
        // assumes that the word does exist.
        Node curr = root;
        for(char ch : word.toCharArray()){
            curr = curr.get(ch);
            curr.setCp(-1); // decrement prefix count on the child
        }
        curr.setEw(-1); // decrement ends with counter on the child
    }

    public boolean checkIfComplete(String word) {
//        boolean flag = true;
        Node curr = root;
        for(char ch : word.toCharArray()){
            curr = curr.get(ch);
//            flag &= curr.getEnd();
            if(curr.getEnd() == false)
                return false;
            // checks if all substrings of the given word are part of the trie.
            // if not, it will return false.
        }

        return true;
//        return flag;
    }

}
