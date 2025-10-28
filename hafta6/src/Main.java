import java.util.Scanner;

public class Main {
    private static final Scanner tarayici = new Scanner(System.in);

    public static void main(String[] args) {
        BagliListe liste = new BagliListe();
        while (true) {
            System.out.println("\n--- BAGLI LISTE MENUSU ---");
            System.out.println("1) Basa ekle");
            System.out.println("2) Belirli konuma ekle");
            System.out.println("3) Sondan sil");
            System.out.println("4) Belirli konumdan sil");
            System.out.println("5) Indeksten deger getir");
            System.out.println("6) Degerin ilk indeksini bul");
            System.out.println("7) Listeyi yazdir");
            System.out.println("8) Boyutu goster");
            System.out.println("9) Cikis");

            int secim = okuInt("Seciminiz: ");
            try {
                switch (secim) {
                    case 1 -> {
                        int deger = okuInt("Eklenecek deger: ");
                        liste.basaEkle(deger);
                        System.out.println("Eklendi.");
                    }
                    case 2 -> {
                        int indeks = okuInt("Eklenecek indeks: ");
                        int deger = okuInt("Eklenecek deger: ");
                        liste.konumaEkle(indeks, deger);
                        System.out.println("Eklendi.");
                    }
                    case 3 -> {
                        int silinen = liste.sondanSil();
                        System.out.println("Sondan silinen: " + silinen);
                    }
                    case 4 -> {
                        int indeks = okuInt("Silinecek indeks: ");
                        int silinen = liste.konumdanSil(indeks);
                        System.out.println("Silinen: " + silinen);
                    }
                    case 5 -> {
                        int indeks = okuInt("Getirilecek indeks: ");
                        int deger = liste.getir(indeks);
                        System.out.println(indeks + ". indeksteki deger: " + deger);
                    }
                    case 6 -> {
                        int deger = okuInt("Aranan deger: ");
                        int indeks = liste.indeksiBul(deger);
                        if (indeks == -1) System.out.println("Deger bulunamadi.");
                        else System.out.println("Ilk goruldugu indeks: " + indeks);
                    }
                    case 7 -> liste.yazdir();
                    case 8 -> System.out.println("Boyut: " + liste.boyut());
                    case 9 -> {
                        System.out.println("Cikis yapiliyor...");
                        return;
                    }
                    default -> System.out.println("Gecersiz secim.");
                }
            } catch (Exception e) {
                System.out.println("Hata: " + e.getMessage());
            }
        }
    }

    private static int okuInt(String mesaj) {
        while (true) {
            System.out.print(mesaj);
            String s = tarayici.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Lutfen tam sayi girin.");
            }
        }
    }
}
