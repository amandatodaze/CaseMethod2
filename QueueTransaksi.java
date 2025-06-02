
class QueueTransaksi {

    TransaksiLayanan[] data;
    int front, rear, size, max;

    public QueueTransaksi(int kapasitas) {
        max = kapasitas;
        data = new TransaksiLayanan[max];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean IsEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public void tambahTransaksi(TransaksiLayanan t) {
        if (IsFull()) {
            System.out.println("Antrian transaksi penuh.");
            return;
        }

        if (IsEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % max;
        }

        data[rear] = t;
        size++;
    }

    public void tampilkanRiwayat() {
        if (IsEmpty()) {
            System.out.println("-- Belum ada transaksi --");
            return;
        }

        System.out.println("-- Riwayat Transaksi --");
        int i = front;
        for (int count = 0; count < size; count++) {
            System.out.println(data[i].getRingkasan());
            i = (i + 1) % max;
        }
    }
}
