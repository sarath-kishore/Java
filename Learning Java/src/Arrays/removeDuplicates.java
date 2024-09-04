package Arrays;

import java.util.Arrays;

public class removeDuplicates {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
//        int[] arr = {1,1};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] arr){
        int selection_idx = 0;
        // selection_idx will always be at the position of the last unique element

        for(int i=0; i< arr.length-1; i++){
            while(arr[i]==arr[i+1] && i<arr.length-2){
                i++;
            };

            if(arr[selection_idx] != arr[i+1]){
                // without this check, the last element will not be checked for duplication.
                selection_idx += 1;
                arr[selection_idx] = arr[i+1];
            }

        }

        // to return the count, add 1 to the index of last unique element.
        return selection_idx+1;
    }
}
