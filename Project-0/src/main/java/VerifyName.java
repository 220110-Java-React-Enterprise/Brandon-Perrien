public class VerifyName {
    public static boolean verify(String s){
        //Checks to make sure String s only contains Letters(ie no names with numbers or symbols)
        char[] charArr = s.toCharArray();
        for(char c: charArr){
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }
}
