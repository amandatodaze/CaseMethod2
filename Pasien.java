public class Pasien {
    String nama;
    String nik;
    String keluhan;

    public Pasien(String nama, String nik, String keluhan) {
        this.nama = nama;
        this.nik = nik;
        this.keluhan = keluhan;
    }

    public void tampilkanInformasi() {
        System.out.println("Nama Pasien: " + this.nama);
        System.out.println("NIK: " + this.nik);
        System.out.println("Keluhan: " + this.keluhan);
    }
}