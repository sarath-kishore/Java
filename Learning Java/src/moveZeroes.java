public class moveZeroes {
    public static void main(String[] args) {
        int[] arr = new int[]{1,0,1};
        // int[] arr = new int[]{1,0,1,0,2,3,4,0,4,6,7};
        // int[] arr = new int[]{1};
        // int[] arr = new int[]{0,0};
        // int[] arr = new int[]{0,1,0,3,12};
        for(int m =0; m<arr.length; m++){
            System.out.print(arr[m] + " ");
        }
        System.out.println();
        // moveZeroes(arr);
        moveZeroes2(arr);
        for(int m =0; m<arr.length; m++){
            System.out.print(arr[m] + " ");
        }
    }

    static void moveZeroes2(int[] nums){
        // most efficient solution. simplest.
        int shifted = 0;
        int i=0;
        while(i<nums.length){
            if(nums[i]!=0){
                nums[shifted] = nums[i];
                shifted++;
            }
            i++;
        }

        while(shifted<nums.length){
            nums[shifted] = 0;
            shifted++;
        }
        return;
    }


    static void moveZeroes(int[] nums){

        int j =0, shifted =0;
        while(j<nums.length){
            while(j<nums.length && nums[j]!=0){
                // find the index of 0.
                j++;
            }

            if(shifted==0 && j!=0)
                shifted = j;

            while(j<nums.length && nums[j]==0){
                // find the first non-zero element in order to start shifting from there.
                j++;
            }

            while(j<nums.length && nums[j]!=0){
                // shift elements until next 0.
                nums[shifted] = nums[j];
                j++;
                shifted++;
            }
        }

        while(shifted<nums.length && shifted!=0){
            nums[shifted] = 0;
            shifted++;
        }

        return;
    }
}
