import java.util.Scanner;

public class InputScan {
    Scanner scnr = new Scanner(System.in);

    /**
     * Sebagai scan dari string input user
     *
     * @param str merupakan inputan user
     * @return
     */
    public String input(String str) {
        System.out.print("input " + str + ": ");
        return scnr.next();
    }


//    public boolean input_validation(String str,String validation){
//        String just_number = "^[0-9]*$";
//
//        if(validation.equals("number")){
//            Pattern regex = Pattern.compile(just_number);
//            Matcher matcher = regex.matcher(str);
//            return matcher.find();
//        }
//
//        return false;
//    }


}