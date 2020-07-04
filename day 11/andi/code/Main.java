import java.io.FileNotFoundException;

public class Main {
    static Login login = new Login();
    static Menu menu = new Menu();

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("### untuk demo ###");
        System.out.println("username : andi@andipyk.com");
        System.out.println("pass : F{Cy3Nw(5Y+#7gdm");
        System.out.println("");

        boolean login_success = login.login();

        if (login_success) {
            // Masuk Sistem
            System.out.println("");
            menu.menu_mahasiswa();
        }
        System.out.println("Terimakasih");
    }
}
