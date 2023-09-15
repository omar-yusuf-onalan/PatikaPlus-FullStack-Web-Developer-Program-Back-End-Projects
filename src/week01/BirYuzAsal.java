package week01;

// 1-100 Arasındaki Asal Sayıları Bulan Program

public class BirYuzAsal {
    public static void main(String[] args) {
        int bolen = 2;

        // 1'den 100'e i değişkenini döndürüyoruz.
        for (int i = 1; i <= 100; i++) {

            // i, bölenle eşit olana kadar ya da bölen i'yi bölene kadar döngü devam eder.
            while ((i >= bolen) && (i % bolen != 0)) {
                bolen++;
            }
            /*
             Eğer bölen i'yi bölebilmiş ise zaten asal sayı değildir ancak bölen i'yi bölemeden i'ye kadar gelmiş ise
             demek ki asal sayıdır ve biz bu sayıyı kullanıcıya yazdırırız.
             */
            if (i == bolen) {
                System.out.println(i);
            }

            // Bir sonraki iterasyonda kullanılmak üzere bölen değişkenine 2 değeri atanır.
            bolen = 2;
        }
    }
}
