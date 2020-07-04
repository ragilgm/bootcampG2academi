import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    static InputScan inputScan = new InputScan();

    public boolean login() throws FileNotFoundException {
        String repeat = "y";

        while (repeat.equals("y")) {
            String input_username = inputScan.input("username");
            String input_password = inputScan.input("password");
            boolean check_regex = is_match_regex(input_username, input_password);
            boolean match_file = is_match_with_file(input_username, input_password);

            if (!check_regex) {
                System.out.println("Username/Password tidak valid !");
            } else if (!match_file) {
                System.out.println("Username/Password tidak cocok !");
            } else {
                return true;
            }

            repeat = inputScan.input("coba lagi?(Y/n)").toLowerCase();
            System.out.println("");
        }
        return false;
    }

    /**
     * Sebagai validator email dan password dgn regex
     *
     * @param email    = andi@andipyk.com
     * @param password = F{Cy3Nw(5Y+#7gdm
     * @return
     */
    public boolean is_match_regex(String email, String password) {
        String email_patern = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
        String pass_patern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        if (check_regex(email_patern, email) && check_regex(pass_patern, password))
            return true;
        return false;
    }

    public boolean check_regex(String patern, String str) {
        Pattern regex = Pattern.compile(patern);
        Matcher matcher = regex.matcher(str);
        return matcher.find();
    }


    /**
     * Sebagai matching email dan password dengan data file.txt
     *
     * @param email
     * @param password
     * @return
     * @throws FileNotFoundException
     */
    public boolean is_match_with_file(String email, String password) throws FileNotFoundException {
        String name_file_username = "username";
        String name_file_password = "password";

        if (check_file(name_file_username, email) && check_file(name_file_password, password))
            return true;
        return false;

    }

    public boolean check_file(String name_file, String input_str) throws FileNotFoundException {
        File file = new File(name_file + ".txt");
        Scanner scanFile = new Scanner(file);

        if (!scanFile.nextLine().equals(input_str)) // check !(isi == user/pass)
            return false;
        return true;
    }

}
