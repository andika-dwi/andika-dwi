import java.util.Scanner;

public class penghitungZakat {

    private static final double PERSENTASE_ZAKAT = 0.025;
    private static final double BERAS_PER_KG = 10000;
    private static final double SAPI = 15000000;
    private static final double KAMBING = 3000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Pilih jenis zakat yang ingin dihitung:");
            System.out.println("1. Zakat Uang");
            System.out.println("2. Zakat Beras");
            System.out.println("3. Zakat Hewan (Sapi/Kambing)");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan Anda (1-4): ");

            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    hitungZakatUang(scanner);
                    break;
                case "2":
                    hitungZakatBeras(scanner);
                    break;
                case "3":
                    hitungZakatHewan(scanner);
                    break;
                case "4":
                    System.out.println("Terima kasih telah menggunakan program penghitung zakat.");
                    scanner.close();
                    return; // keluar dari program
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void hitungZakatUang(Scanner scanner) {
        double harta = 0;

        while (true) {
            System.out.print("Masukkan jumlah harta (dalam angka desimal): ");
            try {
                harta = Double.parseDouble(scanner.nextLine());
                if (harta < 0) {
                    System.out.println("Jumlah harta tidak boleh negatif. Silakan masukkan angka yang valid.");
                } else {
                    break; 
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka yang benar.");
            }
        }

        double zakatAmal = harta * PERSENTASE_ZAKAT;

        System.out.printf("Jumlah zakat yang harus dibayarkan: Rp %.2f\n", zakatAmal);

        if (zakatAmal < 100000) {
            System.out.println("Zakat ini termasuk kecil, tapi sangat berarti.");
        } else if (zakatAmal >= 100000 && zakatAmal <= 1000000) {
            System.out.println("Zakat ini memiliki dampak yang cukup besar.");
        } else {
            System.out.println("Zakat Anda sangat besar, semoga bermanfaat bagi banyak orang.");
        }
    }

    private static void hitungZakatBeras(Scanner scanner) {
        double jumlahBeras = 0;

        while (true) {
            System.out.print("Masukkan jumlah zakat beras (dalam kg): ");
            try {
                jumlahBeras = Double.parseDouble(scanner.nextLine());
                if (jumlahBeras < 0) {
                    System.out.println("Jumlah beras tidak boleh negatif. Silakan masukkan angka yang valid.");
                } else {
                    break; 
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka yang benar.");
            }
        }

        double nilaiZakatBeras = jumlahBeras * BERAS_PER_KG;

        System.out.printf("Nilai zakat beras yang harus dibayarkan: Rp %.2f\n", nilaiZakatBeras);
    }

    private static void hitungZakatHewan(Scanner scanner) {
        System.out.println("Pilih hewan untuk zakat:");
        System.out.println("1. Sapi");
        System.out.println("2. Kambing");
        System.out.print("Masukkan pilihan Anda (1-2): ");

        String pilihanHewan = scanner.nextLine();
        double nilaiZakatHewan = 0;

        switch (pilihanHewan) {
            case "1":
                nilaiZakatHewan = SAPI;
                System.out.printf("Nilai zakat untuk seekor sapi: Rp %.2f\n", nilaiZakatHewan);
                break;
            case "2":
                nilaiZakatHewan = KAMBING;
                System.out.printf("Nilai zakat untuk seekor kambing: Rp %.2f\n", nilaiZakatHewan);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        System.out.println("Semoga zakat Anda dapat bermanfaat bagi yang membutuhkan.");
    }
}
