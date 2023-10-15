# Rendszerterv


## A rendszer célja
### (Definiálja a rendszer célját. Gyakran leírjuk azt is, ami nem cél, hogy ezzel is tisztázzuk a feladat kört (scope), amit meg akarunk oldani.)
A rendszer célja egy olyan Android alkalmazás létrehozása, amelyet csak az egyetem hallgatói használhatnak csak. Az alkalmazás egy Questionnare, vagyis
egy olyan applikáció, amelyben a diákok (ez esetben a felhasználók) az egyetemmel kapcsolatos kvízeket tölthetnek ki. Ezek a kvízek az egyetemmel kapcsolatosak, 
annak javulására szolgálnak. A kvízekben a kérdések fajtái lehetnek többfélék, feleletválasztósak, vagy akár kifejtendőek is. A cél egy stabil adatbázisrendszer 
létrehozása, amely tárolja a felhasználók bejelentkezési adatait, valamint a kérdésekre adott válaszaikat is. Kiemelendő az a kitűzésünk is, hogy ezt
teljesen törvényesen, valamint úgy akarjuk megalkotni, hogy az adatok biztonságban legyenek. Lehetőleg olyan rendszert állítanánk fel, ahol a kvízeket
lehet módosítani, törölni valamint teljesen újakat létrehozni. A tervezés közbeni hibákat minél jobban szeretnénk elkerülni vagy esetleg teljesen 
kijavítani. Fontos azonban, hogy olyan rendszert hozzunk létre, amelyet olyan diákok is könnyedén tudjanak használni, akik nem rendelkeznek kiemelkedő 
informatikai tudással, vagyis az applikáció felhasználóbarát legyen. 

## Projektterv
A projekt végrehajtásához négy csapattag fog részt venni, akik különböző szerepköröket töltenek be.
A projekt során az alábbi szerepkörök és felelősségeik kerülnek kijelölésre:

### Projektszerepkörök, felelőségek
* Scrum Master: Papp Gréta.
  * A Scrum Master felelős a projekt folyamatának és munkafolyamatainak hatékony menedzseléséért. Ő
  segíti a csapatot a Scrum keretrendszer alkalmazásában és gondoskodik arról, hogy a csapat zökkenőmentesen
  haladjon előre a projekt során.
* Product Owner: Varga Petra.
  * Ő felelős a projekt céljainak és prioritásainak meghatározásáért. A Product Owner az ügyfél igényeit
    képviseli és biztosítja, hogy a csapat a legfontosabb feladatokon dolgozzon.
* Team: Fekete Enikő, Papp Gréta, Kaponyás Lüszien, Varga Petra. 
  * Minden csapattagnak saját felelősségi területe van a projektben:

### Projektmunkások és felelőségek(TODO: szerepek kiosztása):
* Papp Gréta az adatbázis kezelési munkálatokkal foglalkozik, gondoskodva az adatok tárolásáról és hozzáférhetőségéről.
* XY a backend munkálatokért felelős, ami magában foglalja a szoftver háttérlogikájának fejlesztését.
* XY a frontend fejlesztésért felelős, azaz az alkalmazás felhasználói felületének tervezésével és kialakításával foglalkozik.
* XY a tesztelési és jegyzőkönyvezési feladatokat látja el, hogy semmilyen hiba ne lépjen fel a szoftver bemutatásakor.

A projektszerepkörök mellett fontos hangsúlyozni, hogy bár minden csapattagnak megvan a saját
szerepköre, mindannyian készen állnak arra, hogy egymást támogassák és segítsék, amikor szükség van
rá, hogy biztosítsák a projekt sikeres előrehaladását és zökkenőmentes működését.

### Ütemterv
1.hét: Projekt kitűzése. Github és Trello tábla megalkotása. A trello táblára feltölteni az elvégezendő feladatokat.\
2.hét: Követelmény specifikáció és funkcionális specifikáció elkészítese. Fejenként 20-40 sor.\
3.hét: Rendszerterv elkészítése, 1-2 ábrával együtt. Fejenként 40-80 sor. Felosztani a kötelességeket a sprintre.\
4-5.hét Fejlesztési sprint. Fejenként 300-600 sor kódolás.\
6.hét: Demó bemutatása, problémák felírása és kijavítása.\
7-8.hét: Fejlesztési sprint folytatása és tesztelés jegyzőkönyveléssel.\
9.hét: A projekt bemutatása, átadás-átvétel.

### Mérföldkövek
Projekt kezdése: 2023.10.02.\
Követelmény specifikáció és funkcionális specifikáció befejezése: XXXX\
Rendszerterv befejezése: XXXX\
Fejlesztés és tesztelés kezdete: 2023.10.23.\
A demo bemutatása: 2023.11.06.\
Utolsó simítások: 2023.11.26.\
A projekt bemutatása: 2023.11.27.


## Üzleti folyamatok modellje

<img src="Diagrams/ÜzletiFolyMod.png" width=600>

## Követelmények(Leírja, hogy mit kell teljesíteni a programnak. Még javítandó,a követelmény listából kell kiszedni a dolgokat)
A rendszer fő célja, hogy Android platformon működjön, és lehetővé tegye az egyetem hallgatóinak, hogy
saját fiókkal ki tudják tölteni a kérdőívet. Ennek érdekében a következő funkcionális követelményeket határoztuk meg:

### Funckionális követelmények(Mit tesz a rendszer?):
* Androidon való működés
* A hallgatóknak lehetővé kell tenni, hogy egy egyedi fiókot alkothassanak, amelyhez e-mail cím és
jelszó szükséges, ami adatbázisban lesz tárolva
* Az egyedi fiókkal rendelkező felhasználóknak lehetőséget kell nyújtani a bejelentkezéshez
* A diákoknak lehetőséget kell adni a kérdőívek kitöltésére az online felületen, majd válaszaik eltárolására
* Az adminisztrátoroknak admin fiókkal kell rendelkezniük, hogy képesek legyenek az összegyűjtött
adatok elemzésére és statisztikai riportok készítésére

### Nem funkcionális követelménye(Hogyan működik a rendszer?):
* A kérdőív kitöltése során a diákoknak egyszerű és felhasználóbarát felületen kell tudniuk navigálni
* A szoftvernek stabilan kell működnie, azaz nem szabad rendszerösszeomlásokat vagy hibás adatok megjelenítését okoznia
* Az adatoknak szigorúan titkosnak kell lenniük, és csak a megfelelő jogosultságokkal rendelkező
személyek férhetnek hozzá, azaz egy felhasználó nem juthat hozzá egy másik felhasználó személyes adataihoz

### Törvényi előírások, szabványok:
* A szoftvernek meg kell felelnie az adatvédelmi és felhasználói adatok kezelésére vonatkozó helyi
törvényi előírásoknak és szabványoknak, GDPR-nek való megfelelés.

## Funkcionális terv(Leírja a felhasználói szerepköröket, és hogy milyen feladatokat tudnak csinálni.)
### Rendszer szereplők:
### Rendszer használati esetek és lefutásaik
### Határ osztályok(A határ osztályok azok az osztályok, amelyek közvetlenül kezelik a felhasználói felületet és az interakciókat. Ezek az osztályok kapcsolódnak a képernyők megjelenítéséhez és a felhasználói inputok kezeléséhez.)
### Menü hierarchiák(A menü hierarchiák leírják az alkalmazás menürendszerét és az elérhető opciókat. Navigálásra jó)
### Képernyő tervek


## Fizikai környezet(Itt kell leírni milyen platformra készül a szoftver ,mik vannak engedélyezve és milyen fejlesztői eszközöket / programokat használunk fejlesztés közben)
* Programozási Nyelv: A szoftvert Java programozási nyelven fogjuk fejleszteni.
* Fejlesztői Környezet: Az Android Studio-t fogjuk használni a fejlesztéshez és teszteléshez.
* Operációs Rendszer: A szoftvert Android operációs rendszeren fogjuk futtatni a mobil alkalmazás verzió esetében.
* Nincsenek megvásárolt komponenseink.

## Absztrakt domain modell


## Architekturális terv(A nemfunkcionális követelményekből lesz az architekturális terv.)
### Felhasználó felület:
### Játék logikai:
### Adatkezelés:
### Kapcsolatok
### Technológiai megvalósítás
### Működési folyamat
### Tesztelés


## Adatbázis terv


## Implementációs terv
Az alkalmazás Android platformon fog futni, így a két választható nyelv közül a Java programozási
nyelvet fogjuk használni a mobilalkalmazás fejlesztéséhez, a Kotlinnal szemben, ugyanis több
tapasztalatunk van Java-val Az adatbázis kezeléshez SQLite adatbázist használunk amely könnyen
integrálható az Android alkalmazásokba. A felhasználó felület tervezéséhez az Android Studio saját
XML alapú layout rendszerét alkalmazzuk, amivel kialakíthatjuk a kérdőív könnyen navigálható és
felhasználóbarát felületét.

## Tesztterv (utólag még szerkesztendő)

A tesztelés célja, hogy a kódolás és a szerkesztés közben, a backend és a frontend folyamatok is rendben zajlódjnak le,
hogy a felhasználót semmi se zavarja az applikáció használata közben, valamint az, hogy az adatok ne vesszenek el.
Egy ilyen applikációnál kiemelten fontos, hogy az adatszivárgás véletlenül se következzen be. 

### Tesztelési eljárások

A különböző tesztelési eljárásokról jegyzőkönyvet készítünk. Ebben a jegyzőkönyben lesznek feltüntetve a felmerülő
hibák és azok javítása is.

#### UNIT teszt: 
A kódolás közben a metódusokat, valamint az implementációkat folyamatosan tesztelni kell. Minden egyes
metódust csak akkor tekinthetünk megfelelőnek, hogyha az Unit teszt hiba nélkül fut le rajta, ezzel kerülhetjük el 
a nagyobb, végzetes hibákat, amelyek az egész rendszer összeomlásával fenyegetnének. Tesztelés közben figyelemmel kell
kísérnünk azt is, hogy a tesztelés minél nagyobb kódlefedetséget érintsen. A teszt időtartama a kódolás kezdetétől, 
a kódolás végéig tart.

#### Alfa teszt: 
A teszt célja a mi esetünkben az, hogy az eddig meglévő funkciókat, kvízeket Andriod felülettel való
kompabitibilitását ellenőrizzük. Ezt mi, a fejlesztők végezzük el. A tesztet csak akkor tekinthetjük sikeresnek, ha 
különböző készülékeken, különböző Android rendszereken működnek hibamentesen a meglévő funkciók. A teszt időtartama
kb. 1 hét.

#### Béta teszt: 
Az alfa tesztel ellentétben a tesztelést már nem a fejlesztők végzik, hanem a célközönség, vagy a rendelő.  Ebben
az esetben a diákok.
Tesztelendő rendszerek: Android 8.0.0 (minimum)
A teszt időtartama öt nap. Ez idő alatt a béta tesztelők visszajelzéseket, esetleges hibaüzeneteket küldhetnek a 
fejlesztőknek, az alkalmazás fejlesztése érdekében. Túl sok esetlegesen túl kevés hiba esetén a tesztelés időtartama
változhat.

### Tesztelési funkciók:

#### Backend:
Az applikációnak képesnek kell lennie, hogy az adatokat gond nélkül tárolja. Képesnek kell lennie az Androidos
felületeken lévő hibamentes futásra. Az adatbázisban lévő adatokat az illetékes személyeknek gond nélkül el kell
tudni érniük. Az adatbázis adatait lehessen frissíteni vagy törölni. A kódolásban nem léphet fel kritikus hiba
sehol sem, ezáltal az összes funkciónak hibamentesen kell működnie. Az applikációnak képesnek kell lennie egyszerre
több felhasználó kiszolgálására is.

#### Android felület:
##### Login felület:
A képernyőtervben megszabottnak kell kinéznie. A felhasználó az adatainak a megfelelő megadásával, melyek az adatbázisban
szerepelnek, problémamentesen be kell tudnia lépni az applikációba.

##### Regisztrációs felület:
A regisztrációt a program telepítése után, ( amely a telepítési tervben van megírva) a felhasználó gond nelkül el tudhassa
érni. A regisztrációs ablaknak űgy kell kinéznie mint ahogy a képernyő tervek között szerepel. A regisztráció során a programnak
azonosítania kell, hogy megfelelő jogosultsággal rendelkezik e a felhasználó, hogy ezt az applikációt használhassa. A regisztráció
után fontos, hogy a megadott adatok belekerüljenek az applikációhoz tartozó adatbázis rendszerbe.

## Telepítési terv


## Karbantartási terv (Tesztelés közben frissíteni)
### Karbantartás:
