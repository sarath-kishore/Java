package Arrays;

public class rotateArrayByKPositions {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // int[] arr = new int[]{1,2,3,4,5,6,7};
        // int[] arr = new int[]{1,2,3,4};
        int[] arr = new int[]{1,2};
        // int[] arr = new int[]{1,2,3,4,5,6,7,8};
        int k = 3;
        rotateArray(arr, k);
        for(int m =0; m<arr.length; m++){
            System.out.print(arr[m] + " ");
        }
    }

    static void reverseArray(int[] arr, int low, int high){
        while(low<=high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    static void rotateArray(int[] nums, int k){

        if(k>nums.length){
            k%=nums.length;
        }

        reverseArray(nums, 0, nums.length-1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, nums.length-1);

        return;
    }
}
