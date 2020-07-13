public class SwitchDemo {
    public static void main(String[] args) {

        char txt = 'B';
        String charString;
        switch (txt) {
            case 'A':  charString = "Sangat Pintar";
                break;
            case 'B':  charString = "Pintar";
                break;
            case 'C' :  charString = "Cukup";
                break;
            case 'D':  charString = "Lumayan";
                break;
            default: charString = "Invalid";
                break;
        }
        System.out.println(charString);
    }
}
