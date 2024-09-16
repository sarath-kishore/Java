package basics;

import java.util.Arrays;
import java.util.*;

public class basicMath {
    public static void main(String[] args) {
//
//        int num = 3;
//        double fl = 1D;
//        String st = "safd";
//        Integer ina = num+1;
//        System.out.println(num);
//        System.out.println(fl);
//        System.out.println(st);
//        System.out.println(ina);
//        num = ina+1;
//        System.out.println(num);

        System.out.println("Gcd: " + GCD(15,20));
        System.out.println("Gcd: " + GCD(3,10));
        System.out.println("Gcd: " + GCD(100,10));
        System.out.println("LCM: " + LCM(10,100));


//        System.out.println("LCM: " + LCM(3,10));

//int n = 2147483647;
//int a = n+1;

//        System.out.println(n+1>Integer.MAX_VALUE);
//        System.out.println(n);
//        System.out.println(a);
//        System.out.println(n+a);
//        System.out.println((a*-1)+n+a);

        System.out.println(reverseNum1(1234));
        System.out.println(rev(1234));
//        System.out.println(palin1(121));
//        System.out.println(countZero1(102010));
//        System.out.println(countZero2(102010, 0));
//
//        System.out.println(Arrays.toString(createTargetArray(new int[]{0,1,2,3,4}, new int[]{0,1,2,2,1})));
        System.out.println((Math.log10(1234)+1));
        System.out.println((Math.log10(1234)));
        System.out.println((Math.log(1234) / Math.log(10)));
//        System.out.println((Math.log10(1234)+1)%2==0);
        System.out.println("isPrime: " + isPrime(1));
        factors(28, false);
        factors(28, true);

//        checkSieve(100);
    }

    public static void checkSieve(int n){
        seiveOfE(n);

        // below code is to verify the above sieve
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(isPrime(i)){
                list.add(i);
            }
        }
        System.out.println("Primes: " + list);
    }

    public static void seiveOfE(int n){
        // Sieve of Eratosthenes.
        // print all prime numbers from 2 to n.
        int[] sieve = new int[n+1];
        for(int i=2; i*i<=n; i++){
            // it's enough if we go till sqrt(n).
            // because square of any number bigger than sqrt(n) will be greater than n, which is the stopping condition for marking.
            // hence it is unnecessary time expense.

//          don't need to check for primes. all unmarked values will be primes only.

            // sieve[i] = 0, prime.
            // sieve[i] = 1, composite.
            if(sieve[i]==0){
                // i is a prime number
//                System.out.println(i);
                // here j is the multiple. mark all multiples of i as composite.
                for(int multiplier=i, j = i*multiplier; j<=n; ){
                    sieve[j] = 1;
                    j = ++multiplier * i;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
//      once everything is marked, whatever is unmarked is a prime.
        for(int i = 2; i<=n; i++){
            if(sieve[i]==0)
                list.add(i);
        }
        System.out.println("Sieve: " + list);
    }


    public static void factors(int n, boolean isPrimeFactorise){
        // time: O(basics.sqrt(n))
        System.out.println();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i*i<=n; i++){
            if(isPrimeFactorise){
                if(n%i==0){
                    if(n/i == i && isPrime(i))
                        System.out.print(i + " ");
                    else {
                        if(isPrime(i))
                            System.out.print(i + " ");
                        if(isPrime(n/i))
                            list.add(n/i);
                    }
                }
            }else{
                if(n%i==0){
                    if(n/i == i)
                        System.out.print(i + " ");
                    else {
                        System.out.print(i + " ");
                        list.add(n/i);
                    }
                }
            }
        }
        for(int i = list.size()-1; i>=0; i--){
            System.out.print(list.get(i) + " ");
        }
    }

    public static boolean isPrime(int n){
        // time: O(basics.sqrt(n))
        if(n<2)
            return false;
        
        if(n==2 || n==3)
            return true;

        for(int i = 2; i*i<=n; i++){
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            arr.add(index[i], nums[i]);
        }
//        When you insert an element at an index in an ArrayList that is already filled,
//        the existing elements at and after that index are shifted to make room for the new element.
//        The elements are shifted to the right to accommodate the new element at the specified index.

        for(int i=0; i<nums.length; i++){
            target[i] = arr.get(i);
        }

        return target;
    }

    static int countZero1(int n){
        if(n==0)
            return 0;
        if(n%10 == 0)
            return 1 + countZero1(n/10);
        return countZero1(n/10);
    }

    // special pattern, pass/return a value to above calls
    static int countZero2(int n, int count){
        if(n==0)
            return count;
        if(n%10 == 0)
            return countZero2(n/10, ++count);
        return countZero2(n/10, count);
    }
    static int rev = 0;
    static int reverseNum1(int n){
        if(n==0)
            return rev;
        rev = rev*10 + n%10;
        return reverseNum1(n/10);
    }


    static int rev(int n) {
        if (n%10 == n) {
            return n;
        }
        int digits = (int)(Math.log10(n)) + 1;
        return (n % 10 * (int)(Math.pow(10, digits-1))) + rev(n/10);
    }

    static boolean palin1(int n) {
        return n == rev(n);
    }


    static int GCD(int i, int j){
        // Euclidean method using recursion
//        if(j==0)
//            return i;
        return (j==0) ? i : GCD(j, i%j);
    }

    static int LCM(int i, int j){
        // a x b = LCM(a, b) * GCD (a, b)
        // LCM(a, b) = (a x b) / GCD(a, b)
        return (i*j) / GCD(i,j);
    }
}
