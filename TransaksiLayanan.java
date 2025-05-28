public class TransaksiLayanan {
    Pasien pasien;
    Dokter dokter;
    int durasiLayanan;
    int biaya;

    public TransaksiLayanan(Pasien pasien, Dokter dokter, int durasi) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.durasiLayanan = durasi;
        this.biaya = durasi * 50000;
    }

    public String getRingkasan() {
        return pasien.nama + " (" + durasiLayanan + " jam): Rp " + biaya;
    }
}
