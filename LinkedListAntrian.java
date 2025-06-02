
class LinkedListAntrian {

    NodePasien head;
    NodePasien tail;
    int size;

    public LinkedListAntrian() {
        head = null;
        tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    public void tambahPasien(Pasien pasien) {
        NodePasien newNode = new NodePasien(pasien, null);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public Pasien layaniPasien() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada pasien yang bisa dilayani.");
            return null;
        }
        Pasien pasienDilayani = head.data;
        head = head.next;
        if (isEmpty()) {
            tail = null;
        }
        size--;
        return pasienDilayani;
    }

    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("-- Antrian kosong --");
            return;
        }
        System.out.println("-- Antrian Pasien --");
        NodePasien current = head;
        while (current != null) {
            current.data.tampilkanInformasi();
            current = current.next;
        }
    }

    public int getSisa() {
        return size;
    }
}
