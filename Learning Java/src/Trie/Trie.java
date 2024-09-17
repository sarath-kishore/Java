package Trie;

public class Trie {
    private class Node{
        Node[] links;
        boolean isEnd;

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
            return links[ch - 'a'];
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
        }
        curr.setEnd(); // set the last pointer as end of a word
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

    boolean startsWith(String word){
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(!curr.containsKey(ch))
                return false;
            curr = curr.get(ch);
        }
        return true;
    }

}
