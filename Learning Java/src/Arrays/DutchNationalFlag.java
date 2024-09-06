package Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        for(int i: arr){
            System.out.print(i + "\t");
        }
    }

    public static void brute(int[] nums){
        int zero=0;
        int one=0;
        int two=0;
        int idx = 0;
        for(int i=0;i<nums.length; i++){
            if(nums[i]==0){
                zero++;
            }
            if(nums[i]==1){
                one++;
            }
            if(nums[i]==2){
                two++;
            }

        }
        while(zero>0){
            nums[idx]=0;
            idx++;
            zero--;
        }
        while(one>0){
            nums[idx]=1;
            idx++;
            one--;
        }
        while(two>0){
            nums[idx]=2;
            idx++;
            two--;
        }
    }
    public static void sortColors(int[] arr) {
//        time: O(n) space: O(1)
//        Dutch National Flag algorithm
        int low = 0, mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}
