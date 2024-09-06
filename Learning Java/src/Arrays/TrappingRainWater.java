package Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1}; //out: 6
//        int[] height = {4,2,0,3,2,5};  //out: 9
        System.out.println(trap(height));

    }
        public static int trap(int[] height) {
            // return brute(height);
            return optimal(height);
        }

        static int optimal(int[] height){
            // time: O(n)
            // space: O(1)

            int count = 0;
            int n = height.length;
            int l = 0;
            int r = n-1;
            // int lMax = height[l];
            int lMax = Integer.MIN_VALUE;
            // int rMax = height[r];
            int rMax = Integer.MIN_VALUE;
            while(l<r){
                if(height[l]<=height[r]){
                    // move from left
                    if(height[l]<lMax){
                        count += lMax - height[l];
                    }else{
                        lMax = height[l];
                    }
                    l++;
                }else{
                    // height[r]<height[l]
                    // move from right
                    if(height[r]<rMax){
                        count += rMax - height[r];
                    }else{
                        rMax = height[r];
                    }
                    r--;
                }
            }

            return count;
        }

        static int brute(int[] height){
            // time: O(n)
            // space: O(n)
            int count = 0;
            int n = height.length;
            int[] lMax = new int[n];
            int[] rMax = new int[n];
            int max = -1;

            for(int i=1; i<n; i++){
                lMax[i]  = Math.max(max, height[i-1]);
                max = Math.max(max, lMax[i]);
            }

            max = -1;
            for(int i=n-2; i>=0; i--){
                rMax[i]  = Math.max(max, height[i+1]);
                max = Math.max(max, rMax[i]);

            }

            for(int i=0; i<n; i++){
                int capacity = Math.min(lMax[i], rMax[i]) - height[i];
                if(capacity>0)
                    count+=capacity;
            }
            return count;
        }
}
