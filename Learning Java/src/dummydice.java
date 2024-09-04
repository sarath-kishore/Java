import java.util.ArrayList;

public class dummydice {
    public static void main(String[] args) {
        int target = 6;
        int face = 6;
        ArrayList<String> ans = helper(face, target, "");
        System.out.println(ans);
    }

    static ArrayList<String> helper(int face, int target, String p){
        if(target==0){
            ArrayList<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }

        ArrayList<String> ans = new ArrayList<>();
        for(int i=1; i<=face && target - i >=0; i++){
            ans.addAll(helper(face, target-i, p+i));
        }
        return ans;
    }

}
