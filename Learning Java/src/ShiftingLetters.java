public class ShiftingLetters {
    public static void main(String[] args) {
//        String s ="aaa";
//        int[] shifts = new int[]{1,2,3}; // out: gfd
        String s ="yza";
        int[] shifts = new int[]{2,2,3}; // out: fed
//        String s ="abc";
//        int[] shifts = new int[]{3,5,9}; // out: rpl
        String a = shiftingLetters(s,shifts);
        System.out.println(a);
    }

    private static String shiftingLetters(String s, int[] shifts) {
        StringBuilder sb = new StringBuilder();

        int sum = 0;

        for(int i = shifts.length-1; i>=0; i--){
            sum = (sum+shifts[i]); // to wrap around

            char ch = s.charAt(i);
            int ascii = ch + sum;

            if(ascii > 122) // if > 'z'
                ascii = (ascii % 123) + 97; // to wrap around

            sb.insert(0, (char)ascii);
        }

        return sb.toString();
    }
}


//Constraints:
//
//    1 <= s.length <= 105
//    s consists of lowercase English letters.
//    shifts.length == s.length
//    0 <= shifts[i] <= 109