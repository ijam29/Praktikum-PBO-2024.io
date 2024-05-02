import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

interface Printable {
    void printDetails();
}

abstract class Sparepart {
    private String nama;
    private int harga;
    private int stok;

    public Sparepart(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + "\n" +
                "Harga: " + harga + "\n" +
                "Stok: " + stok + "\n";
    }

    public abstract void showInfo();
}

final class SparepartOli extends Sparepart implements Printable {
    private String jenisOli;

    public SparepartOli(String nama, int harga, int stok, String jenisOli) {
        super(nama, harga, stok);
        this.jenisOli = jenisOli;
    }

    public String getJenisOli() {
        return jenisOli;
    }

    public void setJenisOli(String jenisOli) {
        this.jenisOli = jenisOli;
    }

    @Override
    public String toString() {
        return "Sparepart Oli\n" +
                super.toString() +
                "Jenis Oli: " + jenisOli + "\n";
    }

    @Override
    public void showInfo() {
        System.out.println(toString());
    }

    @Override
    public void printDetails() {
        System.out.println("====================================");
        System.out.println("Detail Sparepart Oli");
        System.out.println("------------------------------------");
        showInfo();
        System.out.println("====================================");
    }
}

final class SparepartBan extends Sparepart implements Printable {
    private String merkBan;

    public SparepartBan(String nama, int harga, int stok, String merkBan) {
        super(nama, harga, stok);
        this.merkBan = merkBan;
    }

    public String getMerkBan() {
        return merkBan;
    }

    public void setMerkBan(String merkBan) {
        this.merkBan = merkBan;
    }

    @Override
    public String toString() {
        return "Sparepart Ban\n" +
                super.toString() +
                "Merk Ban: " + merkBan + "\n";
    }

    @Override
    public void showInfo() {
        System.out.println(toString());
    }

    @Override
    public void printDetails() {
        System.out.println("====================================");
        System.out.println("Detail Sparepart Ban");
        System.out.println("------------------------------------");
        showInfo();
        System.out.println("====================================");
    }
}

public final class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Sparepart> spareparts = new ArrayList<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Sparepart Oli");
            System.out.println("2. Tambah Sparepart Ban");
            System.out.println("3. Lihat Sparepart");
            System.out.println("4. Perbarui Sparepart");
            System.out.println("5. Hapus Sparepart");
            System.out.println("6. Keluar");

            System.out.print("Pilih menu: ");
            int menu;
            try {
                menu = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Silakan masukkan nomor menu.");
                scanner.nextLine();
                continue;
            }

            switch (menu) {
                case 1:
                    addSparepart(spareparts, scanner, "Oli");
                    break;
                case 2:
                    addSparepart(spareparts, scanner, "Ban");
                    break;
                case 3:
                    showSpareparts(spareparts);
                    break;
                case 4:
                    // Perbarui Sparepart
                    break;
                case 5:
                    // Hapus Sparepart
                    break;
                case 6:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Menu tidak valid.");
            }
        }
    }

    private static void addSparepart(ArrayList<Sparepart> spareparts, Scanner scanner, String jenis) {
        if (jenis.equalsIgnoreCase("Oli")) {
            System.out.println("====================================");
            System.out.println("Tambah Sparepart Oli");
            System.out.println("------------------------------------");
            System.out.print("Nama Sparepart Oli: ");
            String namaOli = scanner.nextLine();
            System.out.print("Harga: ");
            int hargaOli = scanner.nextInt();
            System.out.print("Stok: ");
            int stokOli = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Jenis Oli: ");
            String jenisOli = scanner.nextLine();
            System.out.println("------------------------------------");
            spareparts.add(new SparepartOli(namaOli, hargaOli, stokOli, jenisOli));
            System.out.println("Sparepart Oli ditambahkan.");
            System.out.println("====================================");
        } else if (jenis.equalsIgnoreCase("Ban")) {
            System.out.println("====================================");
            System.out.println("Tambah Sparepart Ban");
            System.out.println("------------------------------------");
            System.out.print("Nama Sparepart Ban: ");
            String namaBan = scanner.nextLine();
            System.out.print("Harga: ");
            int hargaBan = scanner.nextInt();
            System.out.print("Stok: ");
            int stokBan = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Merk Ban: ");
            String merkBan = scanner.nextLine();
            System.out.println("------------------------------------");
            spareparts.add(new SparepartBan(namaBan, hargaBan, stokBan, merkBan));
            System.out.println("Sparepart Ban ditambahkan.");
            System.out.println("====================================");
        } else {
            System.out.println("Jenis sparepart tidak valid.");
        }
    }

    private static void showSpareparts(ArrayList<Sparepart> spareparts) {
        if (spareparts.isEmpty()) {
            System.out.println("Tidak ada sparepart.");
        } else {
            System.out.println("====================================");
            System.out.println("Daftar Sparepart:");
            System.out.println("------------------------------------");
            for (Sparepart sparepart : spareparts) {
                if (sparepart instanceof Printable) {
                    ((Printable) sparepart).printDetails();
                }
                System.out.println("------------------------------------");
            }
        }
        System.out.println("====================================");
    }
}

