package Greedy;
import java.util.*;
public class minimumPlatform {
    public static void main(String[] args) {
        long[] arr = {900, 940, 950, 1100, 1500, 1800};
        long[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        int n = 6;
        System.out.println(greedy(arr, dep, n));
    }

    static int greedy(long[] arr, long[] dep, int n){
        int result = 1;
        int plat_needed = 1;
        Arrays.sort(arr);
        Arrays.sort(dep);

        int a = 1;
        int d = 0;

        while(a<n && d<n){
            if(arr[a]>dep[d]){
                // one platform has become available
                plat_needed--;
                d++;
            }else{
                // need another platform
                plat_needed++;
                a++;
            }

            result = Math.max(result, plat_needed);

        }

        return result;
    }
}
