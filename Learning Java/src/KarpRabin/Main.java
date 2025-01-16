package KarpRabin;

public class Main {
    public static void main(String[] args) {
        KarpRabin algo = new KarpRabin();
        algo.search("abcdefghijk", "jk");
        algo.search("jk", "jk");
    }

}
