									
Hazırlayan: Fatih Safa Özgür

# Tank Oyunu Uygulaması

## Giriş
Proje kapsamında; basit bir atari oyunu olan Tank Oyunu uygulaması, Java programlama dili ile gerçekleştirilmiştir. (Bir internet sitesinde yayınlanan kodlar, pratik yapmak maksadıyla tekrar yorumlanarak oluşturulmuştur) 

## Hedef
Oyunların çalışma mantığı anlaşılmaya çalışılarak, pratik yapmak maksadıyla Tank Oyunu tasarımı yapılmıştır.

## Çalışma Prensibi
Söz konusu oyunda öncelikle bir arayüz oluşturulmakta, daha sonra bu arayüz yardımıyla Oyun nesnesi oluşturulmakta, bu nesne ise Timer aracılığıyla belli aralıklarla ekranı yenilemektedir.
Belirlenen hıza göre (vurulan tank sayısı arttıkça hızlanan şekilde) Düşman Tankları ekranın X ekseninde rastgele(random) bir noktada doğmakta ve kullanıcı tarafından kullanılan Tank'a doğru gitmektedir. Düşman Tankları, Tank'ın bulunduğu Y ekseni koordinatını geçtikleri zaman ise oyun bitmektedir.
Tank tarafından atılan her mermi, ya da zamana bağlı olarak üretilen her bir Düşman Tankı ilgili obje listelerine eklenmekte, bu objelerin ekrandaki konumları (X ve Y koordinatları) belirli pixel miktarları ile sürekli değiştirilmekte, o anda devreye giren Paint methodu ile ise güncel koordinatlara göre tüm mermiler ve Düşman Tankları ile kullanıcı tarafından kullanılan Tank ekrana basılmaktadır. 
Koordinatlar arttırıldıkça veya azaltıldıkça (yukarı veya aşağı hareket sağlamak için) ve güncel koordinatlara göre Paint methodu ile ekrana çizim işlemi yapıldıkça, insan gözü bunları (mermileri ve Düşman tanklarını) yukarı veya aşağa doğru kayan nesneler olarak görmektedir.
Tank (CTRL tuşu ile) ateş ettiği zaman, yeni bir mermi nesnesi oluşturularak, belirli pixel miktarı ile ilerletilmekte ve bu mermi, Düşman Tankının merkez koordinatlarına yakın bir mesafeye ulaştığında Düşman Tankı yokedilmiş sayılmakta ve ilgili Düşman Tankı obje listesinden silinmektedir. Aynı şekilde Düşman Tankını vuran Mermi de Mermi nesnelerini tutan obje listesinden silinir. Böylece bir sonraki Paint methodu devreye girdiğinde, vurulan Düşman Tankı ve onu vuran Mermi ekrana basılmamış olur. 
