package basics;

public class basicStrings {
    public static void main(String[] args) {
//        String stringToSkip = "p";
//        String stringToNotSkip = "apple";
//        System.out.println(stringToNotSkip.indexOf(stringToSkip));

        StringBuilder temp = new StringBuilder("" + 'c');
        System.out.println(temp.insert(temp.length(), 'y'));

        temp.append('e');
        System.out.println(temp);
        temp.insert(0, 'a');
        System.out.println(temp);
        System.out.println(temp.substring(1));
        System.out.println(temp.replace(0, temp.length(), "hijkl"));
        System.out.println(temp.insert(2, "abcd"));
        System.out.println(temp);

        // in StringBuilder, during initialisation, character cannot be used alone, it has to be
        // concat with a string but, char can be appended.
        // String.valueOf(temp) -> used to convert stringbuilder object to string object.


        System.out.println(skipChar1(new StringBuilder(""),"abbaccbaad"));
        System.out.println(skipChar2("abbaccbaad"));
        System.out.println(skipChar3("abbaccbaad"));

        System.out.println(skipString1("abbacappcbappleappdap"));
        System.out.println(skipString1NotString2("abbacappcbappleappdap"));

        System.out.println("isPangram: "+checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));

    }

    public static boolean checkIfPangram(String sentence) {
        for(char ch = 'a'; ch<='z' ; ch++){
            if(sentence.indexOf(ch)<0)
                return false;
        }

        return true;
    }

    static String skipString1NotString2(String str){
        String stringToSkip = "app";
        String stringToNotSkip = "apple";

        if(str.isEmpty())
            return "";

        if(str.startsWith(stringToSkip) && !str.startsWith(stringToNotSkip))
            return skipString1NotString2(str.substring(stringToSkip.length()));

        return str.charAt(0) + skipString1NotString2(str.substring(1));

    }

    static String skipString1(String str){
        String stringToSkip = "apple";

        if(str.isEmpty())
            return "";

//        if(str.charAt(0) == stringToSkip.charAt(0) && str.length()>=stringToSkip.length()){
//            String temp = str.substring(0, stringToSkip.length());
//            if(temp.equals(stringToSkip))
//                return skipString1(str.substring(stringToSkip.length()));
//        }

        if(str.startsWith(stringToSkip))
            return skipString1(str.substring(stringToSkip.length()));

        return str.charAt(0) + skipString1(str.substring(1));

    }

    static String skipChar3(String str){
        // recursive method. this uses 1 parameter, just the unprocessed.
        // uses String type - bad space complexity

        char charToRemove = 'a';
        if(str.isEmpty())
            return "";

        if(str.charAt(0)!= charToRemove)
            return str.charAt(0) + skipChar3(str.substring(1));

        return skipChar3(str.substring(1));

//        String ans = "";
//        if(str.charAt(0)!= charToRemove)
//            ans = ans+str.charAt(0);
//        return ans+skipChar3(str.substring(1));

    }
    static StringBuilder skipChar2(String str){
        // recursive method. this uses 1 parameter, just the unprocessed.
        // uses StringBuilder type - good space complexity

        char charToRemove = 'a';
        if(str.isEmpty())
            return new StringBuilder();

        if(str.charAt(0)!=charToRemove)
            return new StringBuilder().append(str.charAt(0)).append(skipChar2(str.substring(1)));
        return new StringBuilder(skipChar2(str.substring(1)));

//        StringBuilder ans = new StringBuilder();
//        if(str.charAt(0)!=charToRemove)
//            ans.append(str.charAt(0));
//        return ans.append(skipChar2(str.substring(1)));

    }
    static StringBuilder skipChar1(StringBuilder ans, String str){
        // recursive method. this uses 2 parameters, 1 for answer and 1 for unprocessed.
        // uses StringBuilder type

        char charToRemove = 'a';
        if(str.isEmpty())
            return ans;
        if(str.charAt(0)!=charToRemove)
            return skipChar1(ans.append(str.charAt(0)), str.substring(1));

        return skipChar1(ans, str.substring(1));
    }
}
