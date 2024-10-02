package subsetsAndSequences;

import java.util.*;

public class nextGreaterElement {
    public static void main(String[] args) {
        System.out.println(nextGreaterElement(1432));
    }

    public static int nextGreaterElement(int n) {

        ArrayList<String> perms = permutation("", (n+""));
        int[] arr = new int[perms.size()];
        int i=0;
        System.out.println(perms.size());
        for(String num: perms){
            System.out.println("num: " + num);
            arr[i] = Integer.parseInt(num);
            i++;
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for(int num : arr){
            if(num>n)
                return num;
        }

        return -1;

    }

    static ArrayList<String> permutation(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }

        char ch = up.charAt(0);
        int n = p.length() + 1;

        ArrayList<String> perms =new ArrayList<>();

        for(int i=0; i<n; i++){
            String first = p.substring(0,i);
            String last = p.substring(i, p.length());

            perms.addAll(permutation(first+ch+last, up.substring(1)));

        }

        return perms;
    }
//    public static int subsetsAndSequences.nextGreaterElement(int n) {
//        // int digits = (int) Math.log10(n)+1;
//        char[] digits = (n + "").toCharArray();
//
//        for(int i=1; i<digits.length; i++){
//            int j=i+1;
//            char[] temp = new char[digits.length];
//            for(int k=0; k<digits.length; k++){
//                temp[k] = digits[k];
////                System.out.println(temp[k]);
////                System.out.println(getNum(temp[k]));
//            }
//
//            int smallest = 0;
//            while(j<temp.length){
//                System.out.println(digits);
//
//                if(temp[j]>temp[i]){
//                    swap(temp, j, i);
////                    System.out.println(temp);
//                    if(number(temp)>number(digits))
//                        return number(temp);
//                }
//                j++;
//            }
//        }
//        int i=1;
//        char temp = digits[digits.length-1];
//        System.out.println(digits);
//        while(i<digits.length){
//            digits[i] = digits[i-1];
//            i++;
//        }
//        digits[0] = temp;
//        System.out.println(digits);
//
//        if(number(digits)>n)
//            return number(digits);
//
//        return -1;
//
//    }

//    static int number(char[] nums){
//        int n=0;
//        for(int i=0; i<nums.length; i++){
//            n = n + (getNum(nums[i])*(int)Math.pow(10, nums.length-i-1));
//        }
//        return n;
//    }
//
//    static int getNum(int n){
//        return Character.getNumericValue(n);
//    }
//
//    static void swap(char[] nums, int i, int j){
////        System.out.println(nums);
//
//        char temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
////        System.out.println(nums);
//    }
//    static int findSum(int n){
//        int sum=0;
//        while(n>0){
//            sum+=n%10;
//            n/=10;
//        }
//        return sum;
//    }
}
