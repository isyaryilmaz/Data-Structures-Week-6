import java.util.NoSuchElementException;

public class BagliListe {
    private Dugum bas;
    private int boyut;

    public void basaEkle(int deger) {
        Dugum yeni = new Dugum(deger);
        yeni.sonraki = bas;
        bas = yeni;
        boyut++;
    }

    public int sondanSil() {
        if (bas == null) throw new NoSuchElementException("Liste boş: sondan silinecek eleman yok.");
        if (bas.sonraki == null) {
            int silinen = bas.deger;
            bas = null;
            boyut--;
            return silinen;
        }
        Dugum onceki = bas, suan = bas.sonraki;
        while (suan.sonraki != null) { onceki = suan; suan = suan.sonraki; }
        onceki.sonraki = null;
        boyut--;
        return suan.deger;
    }

    public void konumaEkle(int indeks, int deger) {
        if (indeks < 0 || indeks > boyut)
            throw new IndexOutOfBoundsException("Eklemek için geçersiz indeks: " + indeks + " (geçerli: 0.." + boyut + ")");
        if (indeks == 0) { basaEkle(deger); return; }
        Dugum onceki = dugumGetir(indeks - 1);
        Dugum yeni = new Dugum(deger);
        yeni.sonraki = onceki.sonraki;
        onceki.sonraki = yeni;
        boyut++;
    }

    public int konumdanSil(int indeks) {
        if (indeks < 0 || indeks >= boyut)
            throw new IndexOutOfBoundsException("Geçersiz indeks: " + indeks + " (boyut: " + boyut + ")");
        if (indeks == 0) {
            int silinen = bas.deger;
            bas = bas.sonraki;
            boyut--;
            return silinen;
        }
        Dugum onceki = dugumGetir(indeks - 1);
        Dugum silinecek = onceki.sonraki;
        onceki.sonraki = silinecek.sonraki;
        boyut--;
        return silinecek.deger;
    }

    public int getir(int indeks) {
        if (indeks < 0 || indeks >= boyut)
            throw new IndexOutOfBoundsException("Geçersiz indeks: " + indeks + " (boyut: " + boyut + ")");
        return dugumGetir(indeks).deger;
    }

    public int indeksiBul(int deger) {
        Dugum suan = bas; int i = 0;
        while (suan != null) { if (suan.deger == deger) return i; suan = suan.sonraki; i++; }
        return -1;
    }

    public int boyut() { return boyut; }
    public boolean bosMu() { return boyut == 0; }

    public void yazdir() {
        StringBuilder sb = new StringBuilder("[");
        Dugum suan = bas;
        while (suan != null) {
            sb.append(suan.deger);
            if (suan.sonraki != null) sb.append(" -> ");
            suan = suan.sonraki;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    private Dugum dugumGetir(int indeks) {
        Dugum suan = bas;
        for (int i = 0; i < indeks; i++) suan = suan.sonraki;
        return suan;
    }
}