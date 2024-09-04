import java.util.*;

public class missingElement {
    public static void main(String[] args) {


//        int[] arr = new int[]{3,4,1,2,5};
        int[] arr = new int[]{3,4,0,1,5};
//        int[] arrAll = new int[]{1,1};
        int[] arrAll = new int[]{4,3,2,7,8,2,3,1};

//        int[] arrAll = new int[]{3,4,0,2,5,7,9,12};

//        System.out.println(Arrays.toString(arrAll));
//        System.out.println("missing element: " + findMissing(arr));
        System.out.println("missing element: " + findMissingNumber(arr));
        System.out.println("missing elements: " + findAllMissing(arrAll).toString());
//        System.out.println("missing elements: " + findMissingHS(arrAll).toString());

    }
    static List<Integer> findAllMissing(int[] arr){
        // using cyclic sort
        // works correctly only when the minimum array length is equal to max element - 1.
        // probably because this code is meant for 0 indexed algorithm.
// range 1 to n.

        int i =0;
        int n = arr.length;
        while(i<arr.length){
            int correctIndex = arr[i]-1;
            if(correctIndex<=n && arr[i]!=arr[correctIndex]){
                swap(arr,i, correctIndex);
            }else{
                i++;
            }
        }
        List<Integer> ls = new ArrayList<>();

        for(int j=0; j<arr.length; j++){
            if(arr[j]!=j+1){
                ls.add(j+1);
            }
        }

        return ls;
    }

    static List<Integer> findMissingHS(int[] arr){
        // using hashset
        // any range

        List<Integer> ls = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(max < arr[i])
                max = arr[i];
            hs.add(arr[i]);
        }
        System.out.println("Max: " + max);
        for(int i=1; i<=max || i<=arr.length; i++){
            //i<=arr.length -> for cases like [1,1] where max is 1 but array length is bigger than 1.
            if(!hs.contains(i-1)) {
                System.out.println(i - 1);
                ls.add(i - 1);
            }
        }
        return ls;
    }
    static int findMissing(int[] arr){
        // using cyclic sort
        // to find 1 element

        int i =0;
        int n = arr.length;
        while(i<arr.length){
            int correctIndex = arr[i];
            if(correctIndex!=n && arr[i]!=arr[correctIndex]){
                swap(arr,i, correctIndex);
            }else{
                i++;
            }
        }

        for(int j=0; j<arr.length; j++){
            if(j!=arr[j])
                return j;
        }
        return n;
    }

    public static int findMissingNumber(int[] nums) {
        // using normal sum of N numbers formula
        // range 0 to n
// best time.
        int sum = (nums.length * (nums.length + 1)) /2 ;
        int given_sum = 0;

        for(int i=0; i<nums.length; i++){
            given_sum+=nums[i];
        }

        return sum-given_sum;
    }

    static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


}
