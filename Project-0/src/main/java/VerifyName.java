public class VerifyName {
    public static boolean verify(String s){
        char[] charArr = s.toCharArray();
        for(char c: charArr){
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }
}
