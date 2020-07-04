public class Menu {
    static InputScan my_method = new InputScan();

    public void menu_mahasiswa() {
        String[] menu_list = {
                "Create & Input Data Mahasiswa",
                "Edit or Delete Data Mahasiswa",
                "Tampilkan laporan Nilai Data Mahasiswa"
        };

        generate_menu(menu_list);

    }

    void generate_menu(String[] menu) {
        String paramsMenu = "";
        while (!paramsMenu.equals("99")) {
            int nomor = 1;
            System.out.println("Menu");
            for (String item : menu) {
                System.out.println(nomor + ". " + item);
                nomor++;
            }
            System.out.println("99. Exit");
            paramsMenu = my_method.input("menu");
            System.out.println();
            switch_menu(paramsMenu);
        }
    }

    void switch_menu(String params) {
        String pesan = "";
        if (params.equals("1")) {
            MahasiswaCreate mahasiswa = new MahasiswaCreate();
            mahasiswa.create_once();
        } else if (params.equals("2")) {
            MahasiswaEditDelete mahasiswa = new MahasiswaEditDelete();
            mahasiswa.edit_or_delete();
        } else if (params.equals("3")) {
            MahasiswaShow mahasiswa = new MahasiswaShow();
            mahasiswa.show_all();
        } else if (params.equals("99")) {
            pesan = "### Exit ###\nTerimakasih ^^";
        } else {
            pesan = "Inputan anda salah, coba lagi ! ";
        }
        System.out.print(pesan + "\n\n");
    }

}
