import java.util.ArrayList;
import java.util.Scanner;

class Sparepart {
    protected String nama;
    protected int harga;
    protected int stok;

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

// Subclass pertama: SparepartMobil
class SparepartMobil extends Sparepart {
    private String modelMobil;

    public SparepartMobil(String nama, int harga, int stok, String modelMobil) {
        super(nama, harga, stok);
        this.modelMobil = modelMobil;
    }

    public String getModelMobil() {
        return modelMobil;
    }

    public void setModelMobil(String modelMobil) {
        this.modelMobil = modelMobil;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Model Mobil: " + modelMobil + "\n";
    }
}

// Subclass kedua: SparepartMotor
class SparepartMotor extends Sparepart {
    private String jenisMotor;

    public SparepartMotor(String nama, int harga, int stok, String jenisMotor) {
        super(nama, harga, stok);
        this.jenisMotor = jenisMotor;
    }

    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setJenisMotor(String jenisMotor) {
        this.jenisMotor = jenisMotor;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Jenis Motor: " + jenisMotor + "\n";
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Sparepart> spareparts = new ArrayList<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Sparepart");
            System.out.println("2. Lihat Sparepart");
            System.out.println("3. Perbarui Sparepart");
            System.out.println("4. Hapus Sparepart");
            System.out.println("5. Keluar");

            System.out.print("Pilih menu: ");
            int menu = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (menu) {
                case 1:
                    System.out.print("Nama Sparepart: ");
                    String nama = scanner.nextLine();
                    System.out.print("Harga: ");
                    int harga = scanner.nextInt();
                    System.out.print("Stok: ");
                    int stok = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan newline
                    spareparts.add(new Sparepart(nama, harga, stok));
                    System.out.println("Sparepart ditambahkan.");
                    break;
                case 2:
                    if (spareparts.isEmpty()) {
                        System.out.println("Tidak ada sparepart.");
                    } else {
                        System.out.println("Daftar Sparepart:");
                        for (Sparepart sparepart : spareparts) {
                            System.out.println(sparepart);
                        }
                    }
                    break;
                case 3:
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
                case 4:
                    System.out.print("Masukkan nama sparepart yang akan dihapus: ");
                    String namaToDelete = scanner.nextLine().trim(); // Membersihkan newline dan memangkas spasi ekstra
                    for (int i = 0; i < spareparts.size(); i++) {
                        Sparepart sparepart = spareparts.get(i);
                        if (sparepart.getNama().equals(namaToDelete)) {
                            spareparts.remove(i);
                            System.out.println("Sparepart dihapus.");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Menu tidak valid.");
            }
        }
    }
}
