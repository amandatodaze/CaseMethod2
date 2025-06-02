import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListAntrian antrian = new LinkedListAntrian();
        QueueTransaksi transaksi = new QueueTransaksi(100);

        int pilih;
        do {
            System.out.println("\n=== SISTEM ANTRIAN KLINIK ===");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Layani Pasien");
            System.out.println("4. Cek Sisa Antrian Pasien");
            System.out.println("5. Lihat Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Nama Pasien: ");
                    String nama = sc.nextLine();
                    System.out.print("NIK: ");
                    String nik = sc.nextLine();
                    System.out.print("Keluhan: ");
                    String keluhan = sc.nextLine();
                    Pasien p = new Pasien(nama, nik, keluhan);
                    antrian.tambahPasien(p);
                    System.out.println(">> Pasien masuk ke dalam antrian.");
                    break;

                case 2:
                    antrian.tampilkanAntrian();
                    break;

                case 3:
                    Pasien pasienDilayani = antrian.layaniPasien();
                    if (pasienDilayani == null) {
                        System.out.println("Tidak ada pasien dalam antrian.");
                        break;
                    }
                    System.out.println("Pasien " + pasienDilayani.nama + " dipanggil");
                    System.out.print("Masukkan ID Dokter: ");
                    String id = sc.nextLine();
                    System.out.print("Masukkan Nama Dokter: ");
                    String namaDokter = sc.nextLine();
                    System.out.print("Masukkan Durasi Layanan (jam): ");
                    int durasi = sc.nextInt();
                    sc.nextLine();
                    while (durasi <= 0) {
                        System.out.println("Durasi layanan harus lebih besar dari 0.");
                        System.out.print("Masukkan Durasi Layanan (jam): ");
                        durasi = sc.nextInt();
                        sc.nextLine();
                    }

                    Dokter dokter = new Dokter(id, namaDokter);
                    TransaksiLayanan t = new TransaksiLayanan(pasienDilayani, dokter, durasi);
                    transaksi.tambahTransaksi(t);
                    System.out.println(">> Pasien telah dilayani, transaksi berhasil dicatat.");
                    break;

                case 4:
                    System.out.println(">> Sisa pasien dalam antrian: " + antrian.getSisa());
                    break;

                case 5:
                    transaksi.tampilkanRiwayat();
                    break;

                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 0);

        sc.close();
    }
}
