package Arrays;

public class checkIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
//        int[] arr = new int[]{2,1,3,4};
        int[] arr = new int[]{3,4,5,1,2};
//        int[] arr = new int[]{3,4,5,1,2,6};
        System.out.println(checkArray(arr));
    }

    static boolean checkArray(int[] arr){

        boolean hasPivoted = false;
        boolean isSorted = true;

        for(int i=0; i<arr.length-1; i++){
            if(arr[i]>arr[i+1]){
                if(!hasPivoted){
                    hasPivoted = true;
                    // pivot = arr[i+1];
                }else{
                    isSorted = false;
                }
            }
        }

        if(hasPivoted && arr[arr.length-1]>arr[0])
            isSorted = false;

        return isSorted;
    }
}
