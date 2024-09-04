package Recursion;

import java.util.ArrayList;

public class linearSearch {
    public static void main(String[] args) {
        int[] arr = {  1, 2, 2, 3, 4, 8, 9, 23 };
        int target = 2;
        System.out.println("Element presence: " + find(arr, target, 0));
        System.out.println("Element index from first: " + searchFirst(arr, target, 0));
        System.out.println("Element index from last: " + searchLast(arr, target, arr.length-1));
        searchAllOccurence1(arr, target, 0);
        System.out.println("Element indices from first: " + list);
        System.out.println("Element indices from first: " + searchAllOccurence2(arr, target, 0, new ArrayList<>()));
        System.out.println("Element indices from first: " + searchAllOccurence3(arr, target, 0));
        System.out.println("Element indices from last: " + searchAllOccurence4(arr, target, 0));

    }

    static ArrayList<Integer> searchAllOccurence3(int[] arr, int target, int idx){
//        no arraylist is passed as parameter
        // add to list from first
        ArrayList<Integer> current = new ArrayList<>();

        if(idx==arr.length)
            return current;

        if(arr[idx]==target)
            current.add(idx);

        ArrayList<Integer> list = searchAllOccurence3(arr, target, idx+1);

        current.addAll(list);

        return current;
    }
    static ArrayList<Integer> searchAllOccurence4(int[] arr, int target, int idx){
//        no arraylist is passed as parameter
        // add to list from last

        if(idx==arr.length)
            return new ArrayList<>();

        ArrayList<Integer> list = searchAllOccurence4(arr, target, idx+1);

        if(arr[idx]==target)
            list.add(idx);

        return list;
    }

    static ArrayList<Integer> searchAllOccurence2(int[] arr, int target, int idx, ArrayList<Integer> list){
//        passing arraylist as parameter
        if(idx==arr.length)
            return list;

        if(arr[idx]==target)
            list.add(idx);

        return searchAllOccurence2(arr, target, ++idx, list);
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static void searchAllOccurence1(int[] arr, int target, int idx){
        // uses external arraylist
        if(idx==arr.length)
            return;

        if(arr[idx]==target)
            list.add(idx);

        searchAllOccurence1(arr, target, ++idx);
    }

    static boolean find(int[] arr, int target, int idx){
        if(idx==arr.length)
            return false;

        return (arr[idx]==target) ? true : find(arr, target, ++idx);
    }

    static int searchFirst(int[] arr, int target, int idx){
        if(idx==arr.length)
            return -1;

        return (arr[idx]==target) ? idx : searchFirst(arr, target, ++idx);
    }

    static int searchLast(int[] arr, int target, int idx){
        if(idx==-1)
            return -1;

        return (arr[idx]==target) ? idx : searchLast(arr, target, --idx);
    }
}
