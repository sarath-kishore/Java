package Trie;

class XORTrie{
    class Node{
        Node[] links;
        boolean isEnd; // technically not needed in this case. because there will always be 32 nodes in each trie.

        Node(){
            this.links = new Node[2]; // only storing binary values 0/1
            this.isEnd = false;
        }

        boolean getEnd(){
            return this.isEnd;
        }

        void setEnd(){
            this.isEnd = true;
        }

        void put(int bit){
            links[bit] = new Node();
        }

        Node get(int bit){
            Node child = links[bit];
            return child;
        }

        boolean containsKey(int bit){
            return links[bit] != null;
        }

    }
    private Node root;
    XORTrie(){
        this.root = new Node();
    }

    void insert(int n){
        Node curr = root;

        for(int i = 31; i>=0; i--){ // adding bits from left to right
            int bit = (n >> i) & 1; // idx = binary bit, which is also the index of the node array

            if(!curr.containsKey(bit))
                curr.put(bit);

            curr = curr.get(bit);
        }

        curr.setEnd();
    }

    int getMax(int n){
        // all elements are already added in the trie in binary 32 bit form.
        // now checking against n for the maximum XOR.
        // returns the maximum xor value of n ^ across all elements in the 1st array that was inserted.
        Node curr = root;
        int maxXOR = 0;

        for(int i = 31; i>=0; i--){
            int bit = (n >> i) & 1;
//                int max = ~bit;
            int max = 1 - bit;
            if(curr.containsKey(max)){
                maxXOR = maxXOR | (1 << i);
                curr = curr.get(max);
            }else{
                // else, maxXOR = maxXOR | (0<<i); which is already 0 by default. hence nothing to be done.
                curr = curr.get(bit);
            }
        }

        return maxXOR;
    }
}