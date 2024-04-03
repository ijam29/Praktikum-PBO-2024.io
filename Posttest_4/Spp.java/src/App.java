import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Sparepart {
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
}

class SparepartOli extends Sparepart {
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
        return super.toString() +
                "Jenis Oli: " + jenisOli + "\n";
    }
}

class SparepartBan extends Sparepart {
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
        return super.toString() +
                "Merk Ban: " + merkBan + "\n";
    }
}

public class App {
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
                    addSparepart(spareparts, scanner, "Oli"); // Panggil method untuk menambahkan sparepart oli
                    break;
                case 2:
                    addSparepart(spareparts, scanner, "Ban"); // Panggil method untuk menambahkan sparepart ban
                    break;
                case 3:
                    if (spareparts.isEmpty()) {
                        System.out.println("Tidak ada sparepart.");
                    } else {
                        System.out.println("Daftar Sparepart:");
                        for (Sparepart sparepart : spareparts) {
                            System.out.println(sparepart);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Masukkan nama sparepart yang akan diperbarui: ");
                    String namaToUpdate = scanner.nextLine();
                    boolean found = false;
                    for (Sparepart sparepart : spareparts) {
                        if (sparepart.getNama().equals(namaToUpdate)) {
                            System.out.print("Harga baru: ");
                            int newHarga = scanner.nextInt();
                            sparepart.setHarga(newHarga);
                            System.out.print("Stok baru: ");
                            int newStok = scanner.nextInt();
                            sparepart.setStok(newStok);
                            System.out.println("Sparepart diperbarui.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Sparepart tidak ditemukan.");
                    }
                    break;
                case 5:
                    System.out.print("Masukkan nama sparepart yang akan dihapus: ");
                    String namaToDelete = scanner.nextLine();
                    for (int i = 0; i < spareparts.size(); i++) {
                        Sparepart sparepart = spareparts.get(i);
                        if (sparepart.getNama().equals(namaToDelete)) {
                            spareparts.remove(i);
                            System.out.println("Sparepart dihapus.");
                            break;
                        }
                    }
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
    
    // Method overloading untuk menambahkan sparepart
    private static void addSparepart(ArrayList<Sparepart> spareparts, Scanner scanner, String jenis) {
        if (jenis.equalsIgnoreCase("Oli")) {
            System.out.print("Nama Sparepart Oli: ");
            String namaOli = scanner.nextLine();
            System.out.print("Harga: ");
            int hargaOli = scanner.nextInt();
            System.out.print("Stok: ");
            int stokOli = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Jenis Oli: ");
            String jenisOli = scanner.nextLine();
            spareparts.add(new SparepartOli(namaOli, hargaOli, stokOli, jenisOli));
            System.out.println("Sparepart Oli ditambahkan.");
        } else if (jenis.equalsIgnoreCase("Ban")) {
            System.out.print("Nama Sparepart Ban: ");
            String namaBan = scanner.nextLine();
            System.out.print("Harga: ");
            int hargaBan = scanner.nextInt();
            System.out.print("Stok: ");
            int stokBan = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Merk Ban: ");
            String merkBan = scanner.nextLine();
            spareparts.add(new SparepartBan(namaBan, hargaBan, stokBan, merkBan));
            System.out.println("Sparepart Ban ditambahkan.");
        } else {
            System.out.println("Jenis sparepart tidak valid.");
        }
    }
}
