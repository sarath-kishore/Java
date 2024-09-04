package BinarySearch;

public class splitArray {
    public static void main(String[] args) {
        int[] arr = new int[]{7,2,5,8,10};
        System.out.println(splitArray(arr, 2));
    }

    public static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for(int num : nums){
            start = Math.max(start, num);
            end+= num;
        }

        // 'start' will have the answer for the most minimum sum possible, if required piece count is equal to arr.length,
        // which means the given array will be split into sub arrays of each individual element and the maximum of it would be the max element.

        // 'end' will have the answer for the most maximum sum possible, if required piece count is equal to 1,
        // which means sum = sum of all array elements.


        while(start<end){
            int mid = (start+end) / 2;
            int sum=0;
            int pieces = 1;

            for(int num: nums){
                if(sum + num > mid){
                    sum = num;
                    pieces++;
                }else{
                    sum+=num;
                }
            }

            if(pieces>k){
                // here you know for sure mid is not the answer, because pieces don't match the required count.
                // hence you move the start after mid.
                start = mid+1;
            }else{
                // this is the else case, here you don't know for sure that mid is not the answer.
                // pieces could be equal to required count here.
                // yet you're gonna continue checking for a minimal sum. so you leave the current mid in the range.
                // so, end = mid and not end = mid-1;
                end = mid;
            }

        }

        return start;

    }
}
