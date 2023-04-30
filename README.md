# GRAF ALGORİTMALARI ve UYGULAMALARI
HAZIRLAYAN ; 1210505067 RIDVAN BEKLEVİÇ , 1210505070 YUSUF DUMAN , 1210505010 İBRAHİM YİTİZ



Graf teorisi, matematik ve bilgisayar bilimi alanlarında kullanılan bir konsepttir. Graf teorisi, nesneler arasındaki ilişkileri modellemek için kullanılır ve çeşitli uygulamalarda önemli bir rol oynar. Graf, düğümler (vertex) ve kenarlar (edge) olarak adlandırılan iki temel bileşenden oluşur. Düğümler nesneleri (örneğin, şehirler, insanlar, web sayfaları) temsil ederken, kenarlar bu nesneler arasındaki ilişkileri (örneğin, yollar, arkadaşlıklar, bağlantılar) temsil eder.

Graf teorisi ile ilgili bazı temel kavramlar ve tanımlar şunlardır:

1. Yönlü Graf (Directed Graph): Kenarların yönü olduğu graf tipidir. Başlangıç düğümünden bitiş düğümüne doğru yönlendirilir.
2. Yönsüz Graf (Undirected Graph): Kenarların yönü olmayan graf tipidir. İki düğüm arasındaki ilişki karşılıklıdır.
3. Ağırlıklı Graf (Weighted Graph): Kenarların bir ağırlık değeri olduğu graf tipidir. Ağırlık, mesafe, maliyet, kapasite vb. özellikleri temsil edebilir.
4. Döngü (Cycle): Bir düğümden başlayarak ve aynı düğümde biterek, her düğümün sadece bir kez ziyaret edildiği kenar dizisidir.
5. Bağlantılı Graf (Connected Graph): Yönsüz bir grafın herhangi iki düğümü arasında en az bir yol olduğu durumdur.
6. Güçlü Bağlantılı Graf (Strongly Connected Graph): Yönlü bir grafın herhangi iki düğümü arasında en az bir yol olduğu durumdur.
7. Ağaç (Tree): Döngü içermeyen bağlantılı graf.

Graf algoritmaları, graf teorisindeki problemlere çözüm sağlamak için kullanılır. Çeşitli graf algoritmaları vardır, ancak bazı yaygın olanları şunlardır:

1. En Kısa Yol Algoritmaları: İki düğüm arasındaki en kısa yolu veya en düşük maliyetli yolu bulmak için kullanılır. Örnekler: Dijkstra, Bellman-Ford, Floyd-Warshall.
2. Asgari Kapsayan Ağaç Algoritmaları: Bir grafın tüm düğümlerini kapsayan ve kenar ağırlıklarının toplamının minimum olduğu alt grafları bulmak için kullanılır. Örnekler: Kruskal, Prim.
3. Maksimum Akış Algoritmaları: Başlangıç ve bitiş düğümü arasında maksimum akış değerini bulmak için kullanılır. Örnekler: Ford-Fulkerson, Edmonds-Karp, Dinic.
4. Graf Gezme Algoritmaları: Bir grafa düğüm ve kenarları üzerinden sistematik olarak geçmek için kullanılır. Örnekler: Derinlik İlk Arama (Depth-First Search, DFS) ve Genişlik İlk Arama (Breadth-First Search, BFS).
5. Topolojik Sıralama: Yönlü Asiklik Grafı'ndaki (DAG) düğümleri, tüm yönlü kenarların başlangıç düğümünden bitiş düğümüne doğru yönlendirildiği bir sırayla düzenler. Örnekler: Kahn'ın algoritması, DFS ile topolojik sıralama.
6. En Uzun Artan Alt Dizi (LIS) ve En Uzun Ortak Alt Dizi (LCS) Algoritmaları: Diziler üzerinde çalışan ve graf teorisi ile ilişkili dinamik programlama algoritmalarıdır. Örnekler: İkili arama ile LIS, LCS için tablo yöntemi.

Bu algoritmalar, optimizasyon problemlerinden veri madenciliğine, ulaşım planlamasından sosyal ağ analizine kadar çeşitli uygulamalar için kullanılır. Graf teorisi ve algoritmaları, gerçek dünya problemlerine etkili çözümler sağlamada önemli bir rol oynar. Bu nedenle, bilgisayar bilimi ve mühendislik alanında çalışan profesyoneller için temel bilgi olarak kabul edilir.

Graf teorisi ve algoritmalarının daha derinlemesine incelemesinde, aşağıdaki gibi ileri düzey kavramlar ve yöntemler de bulunmaktadır:

1. Minimum Çap Ağaç (MST) Algoritmaları: Başka bir popüler MST algoritması olan Boruvka'nın algoritması (Sollin algoritması olarak da bilinir) özellikle büyük ve yoğun grafikler için uygundur.

2. En Kısa Yol Algoritmaları: Örnek olarak, Bellman-Ford algoritması, negatif ağırlıklı kenarların bulunduğu grafiklerde kullanılır ve negatif ağırlık döngülerini tespit edebilir. Floyd-Warshall algoritması ise, tüm çiftlerin en kısa yollarını hesaplamak için kullanılır ve yönlü ve yönsüz grafiklerde çalışır.

3. En Uzun Yol ve Kritik Yol Problemleri: Proje planlamasında ve etkinlik sürelerinin analizinde kullanılan yöntemlerdir. Kritik Yol Yöntemi (CPM) ve Program Değerlendirme ve İnceleme Tekniği (PERT) gibi algoritmalar, graf teorisi ve ağ analizi temelinde çalışır.

4. Maksimum Akış Problemleri: Min-cut Max-flow teoremi ve bununla ilgili algoritmalar, ağ akışlarını ve kesme optimizasyonunu analiz etmek için kullanılır.

5. Gruplar ve Topluluklar: Sosyal ağ analizinde kullanılan kavramlar, düğümlerin yoğun bağlantılarla gruplandığı bölgeleri tespit etmeye yöneliktir. Örnek olarak, Girvan-Newman ve Louvain yöntemleri gibi topluluk algılama algoritmaları bulunmaktadır.

6. Graf Kümeleme ve Sınıflandırma: Düğümleri veya kenarları benzerlik ölçütlerine göre gruplandıran ve sınıflandıran algoritmalar, örneğin Spektral Kümeleme veya Vertex Nomination.

Graf teorisi ve algoritmalarının uygulama alanları sürekli olarak genişlemekte olup, yapay zeka, makine öğrenimi ve doğal dil işleme gibi alanlarda da kullanılmaktadır. Örneğin, graf sinir ağları (GNN'ler), düğüm ve kenarların temsilini öğrenmek ve graf yapılarını analiz etmek için kullanılır.

Graf teorisi ve algoritmaları hakkında bilgi edinmek, bilgisayar bilimi ve mühendislik alanındaki profesyonellerin problemlere daha geniş bir perspektiften yaklaşmalarına ve daha etkili çözümler bulmalarına olanak tanır. Bu nedenle, bu alanı öğrenmek ve anlamak önemlidir.




DİJKSTRA ALGORİTMASI

Edsger W. Dijkstra tarafından 1956 yılında geliştirilen ve özellikle ağırlıklı çizgelerde (graph) kullanılan bir en kısa yol algoritmasıdır. Algoritma, çizgedeki bir başlangıç düğümünden diğer tüm düğümlere olan en kısa yolları bulur. Dijkstra algoritması, pozitif ağırlıklı kenarlarla çalışan yönlü ve yönsüz çizgelerde etkilidir.

Dijkstra algoritması şu adımlarla çalışır:

1. Başlangıç düğümü belirlenir ve mesafeleri hesaplamak için bir mesafe dizisi oluşturulur. Başlangıç düğümünün mesafesi 0, diğer düğümlerin mesafeleri ise sonsuz olarak atanır.
2. Ziyaret edilmemiş düğümler arasından şu anki en kısa mesafeye sahip düğümü seçin. İlk adımda bu başlangıç düğümü olacaktır.
3. Seçilen düğümden komşu düğümlere olan mesafeyi hesaplayın. Hesaplanan yeni mesafe, mevcut mesafeden daha kısa ise, mevcut mesafeyi yeni mesafe ile güncelleyin.
4. Seçilen düğümü ziyaret edilmiş olarak işaretleyin.
5. Tüm düğümler ziyaret edilene kadar 2. ve 4. adımları tekrarlayın.

Bu süreç tamamlandığında, başlangıç düğümünden diğer tüm düğümlere olan en kısa mesafeleri içeren bir mesafe dizisi elde edilir. Ayrıca, en kısa yolları yeniden oluşturmak için bir önceki düğüm dizisi de kullanılabilir.

Dijkstra algoritması, çeşitli gerçek dünya uygulamalarında kullanılır, örneğin coğrafi bilgi sistemlerinde (GIS) en kısa yol hesaplamalarında, ağ yönlendirme protokollerinde ve hatta sosyal ağ analizinde.
