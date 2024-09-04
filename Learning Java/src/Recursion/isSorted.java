package Recursion;

public class isSorted {
    public static void main(String[] args) {
        int[] arr = { 1, 9, 1, 2, 3, 4, 8, 23 };
//        int[] arr = { 1, 2, 3, 4, 8, 23 };
        System.out.println(isSorted(arr, 0));
    }
    static boolean isSorted(int[] arr, int idx){
        if(idx==arr.length-1)
            return true;

        return (arr[idx] <= arr[idx+1]) && isSorted(arr, ++idx);
    }

}
