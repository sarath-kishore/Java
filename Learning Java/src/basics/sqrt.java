package basics;

public class sqrt {
    public static void main(String[] args) {

        int n = 40;
        int p = 3; // precision
        BS(n, p);
        NR(n);
    }

    static void NR(int n){
//        newton raphson method
        // time: O((logn)F(n))
        double root = 0.0;
        double x = n;

        while(true){
            root = 0.5 * (x + (n / x));
//            System.out.println("rootx: " + root);
            if (Math.abs(root - x) <= 0.5) {
                System.out.println("NR root of " + n + " is: " + root);
                break;
            }
            x = root;
        }
        return;
    }

    static void BS(int n, int p){
        // using binary search.
        double root = 0.0;
        int l = 1;
        int r = n;
        while(l<=r){
            int mid = (l+r) /2;
            if(mid*mid == n){
                System.out.println("Sqrt of " + n + " is: " + mid);
                return;
            }else if(mid*mid > n){
                r = mid-1;
            }else{
                root = mid;
                l = mid+1;
            }
        }
        System.out.println("root: " + root +" - low: " + l + " - High: " + r);

        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while (root * root <= n) {
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }
        System.out.println("Sqrt of " + n + " is: " + root);
        return;
    }


}
