package basics;

import java.util.Arrays;

public class bitwiseOps {
    public static void main(String[] args) {
//        System.out.println(isOdd(4));
//        System.out.println(Integer.toBinaryString(getIbit(3, 2)));
        removeLastSetBit(5);
        setIbit(2, 1);
        resetIbit(2, 2 );
        checkIfPowOfTwo(5);
//        System.out.println((3<<1));
//        System.out.println((4>>1));
        System.out.println(Integer.toBinaryString(3&1));
//        System.out.println(digitCount(14, 8));
        System.out.println(power(2, 5));
        System.out.println(numOfSetBits(-3));
        System.out.println(Integer.toBinaryString(-3));
//        System.out.println(Integer.toBinaryString(findRightSetBit(8)));
//        System.out.println(Integer.toBinaryString((8)));
//        System.out.println(Integer.toBinaryString((-8)));
        System.out.println(reverseBits(Integer.parseInt("00000010100101000001111010011100", 2)));
//        System.out.println(Integer.parseInt("13", 8));
        int[] arr = {1,2,3};
        swap(arr, 0,1);
        System.out.println(Arrays.toString(arr));

//
//        for(int i=1; i<=5; i++){
//            System.out.println(i>>1);
//        }


    }

    static void swap(int[]arr, int i, int j){
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
        return;
    }

    static int reverseBits(int n){
        // you need treat n as an unsigned value
        int result = 0;
        System.out.println(Integer.toBinaryString(n));

        for (int i = 0; i < 32; i++) {
            int lsb = n & 1;
            int reverselsb = lsb << (31 - i);
            result = result | reverselsb;
//            System.out.println(n);
//            System.out.println(lsb);
//            System.out.println(Integer.toBinaryString(reverselsb));
//            System.out.println(Integer.toBinaryString(result));
            n = n >> 1;
        }
        return result;
    }

    static int numOfSetBits(int n){
        int ans = 0;
//        while(n>0){
//            if((n&1) == 1)
//                ans++;
//            n = n>>1;
//        }
        while(n>0){
            ans++;
            n -= (n & (-n));
        }
//        while(n>0){
//            ans++;
//            n = n & (n-1);
//        }
        return  ans;
    }
    static int power(int base, int power){
        // time: O(log(power))
        int ans = 1;
        while(power>0){
            if((power & 1) == 1){
                ans *= base;
            }
//            System.out.println(ans);
//            System.out.println(base);
            power = power >> 1;
            base *= base;
        }
        return ans;
    }
    static int digitCount(int n, int base){
        return (int)(Math.log(n) / Math.log(base)) + 1;
        // to convert anything to base B, divide it with the same log of B.
    }

    static boolean isOdd(int n){
        return (n & 1) == 1;
    }

    static int findRightSetBit(int n){
        return (n & (-n));
    }
    static int getIbit(int n, int i){
        return n & (1<<i-1);
    }

    static void checkIfPowOfTwo(int n){
        System.out.println((n & (n-1)) == 0 ? "Power of 2" : "Not a power of 2");
    }

    static void removeLastSetBit(int n){
        System.out.println(Integer.toBinaryString(n & (n-1)));
    }

    static void setIbit(int n, int i){
        // set ith bit to 1. if its already 1 leave it be.
        System.out.println(Integer.toBinaryString(n | (1<<i-1)));
    }

    static void resetIbit(int n, int i){
        // set ith bit to 0.
//        System.out.println((n & (0<<i-1)));
//        this wont work. because no matter how many times you move 0, the whole thing is still going to be 0.
//        adding n to all 0 will be 0 only.

        System.out.println(Integer.toBinaryString(n & ~(1<<i-1))); // ~ gives the complement. the opposite.
        // something like ! operator but for mathematical purposes.
        // ! is a unary operator and can be used for comparison not evaluations.

    }
}
