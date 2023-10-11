# Követelmény Specifikáció(80 sor)


## Áttekintés
Az egyetem olyan szoftvert kér tőlünk, amely lehetővé teszi, hogy questionnare-k, azaz kérdőívek
formájában adatokat gyűjtsön az ott tanuló diákokról. Azért, hogy minden diákot egyedileg azonosítani
lehessen, szükség van arra, hogy mindegyikük rendelkezzen saját fiókkal. Ennek érdekében szükség van
regisztrációra és bejelentkezésre is. A felhasználóknak létre kell hozniuk egy fiókot, amelyhez email-cím
és jelszó szükséges, ezek az adatok pedig az adatbázisban kerülnek tárolásra. Emellett a felhasználónak
lehetőséget kell nyújtani a ki- és bejelentkezéshez is.

Miután a felhasználó bejelentkezett, megkezdődhet a felmérés. Fontos, hogy maga a kérdőív könnyen
kezelhető legyen, és felhasználóbarát módon legyen felépítve. A diákoknak nem szabad nehézségeiknek lenniük
a kitöltés során, és a kérdéseknek világosnak és érthetőnek kell lenniük, hogy ne okozzanak félreértéseket a megfogalmazás miatt.

A felmérés során gyűjtött adatokat el kell tárolni, hogy későbbi felhasználásra is rendelkezésre álljanak,
például statisztikák készítéséhez. Az adatok védelme a legfontosabb szempont ebben a folyamatban. Azokat
szigorúan titkosan kell kezelni, és csak a megfelelő jogosultságokkal rendelkező személyek férhetnek
hozzá. Minden felhasználónak csak a saját válaszaikhoz kell hozzáférnie, és az adatokkal való visszaélésnek nem szabad megtörténnie.

Ezzel a megértéssel és megfelelő biztonsági intézkedésekkel a szoftver képes lesz hatékonyan és
biztonságosan kezelni a diákok adatait és a felméréseket.

## Jelenlegi helyzet
Mára már elavult és költséges megoldásnak számít a papíralapú kérdőívek használata, amelyeket kézzel
írnak alá és töltik ki az emberek. A papírok beszerzése és nyomtatása költséges, és hosszadalmas
folyamat. Az emberek elkapása, hogy kitöltsék a kérdőívet, különösen a hosszabb, részletesebb kérdőívek
esetén, nehézkes és időigényes feladat, amit nehéz ellenőrizni is. Ráadásul gyakran előfordul, hogy
a kitöltők hibás vagy hiányos adatokat adnak meg, vagy félreértelmezett kérdésekre adnak válaszokat.
Az adatok kézi felvitele a számítógépbe további időt és energiát igényel.

Ehelyett az online kérdőívek használata sokkal hatékonyabb és kényelmesebb megoldás. Az emberek
könnyedén és bármikor kitölthetik a kérdőívet az interneten keresztül, anélkül, hogy az egyetem
területére kellene menniük. Az online kérdőívek használata lehetővé teszi, hogy csak azok a válaszok
legyenek elfogadhatóak, amelyek megfelelő azonosítással és válaszokkal rendelkeznek, így elkerülve
a hibák és az adatok helytelen rögzítését. Ezenkívül az online platform lehetővé teszi az adatok
gyors és egyszerű rögzítését, és könnyen kezelhetővé teszi az adatok elemzését is.

## Vágyálom rendszer
A projekt célja, hogy egy olyan rendszert hozzunk létre, amely lehetővé teszi a könnyű és hatékony
felmérések készítését az egyetemen tanuló hallgatók körében. Az alkalmazás kizárólag az egyetemi
hallgatók számára lesz elérhető, és azoknak kell használniuk saját egyetemi e-mail címükkel való
regisztrációval és bejelentkezéssel.

Az alkalmazás felhasználóbarát lesz, hogy a hallgatók könnyedén és gyorsan megértsék, hogyan kell
kitölteni a kérdőíveket. Az alkalmazás felhasználói felülete egyszerűen kezelhető és átlátható legyen.
A felhasználók regisztrációs adatai biztonságosan tárolásra kerülnek egy adatbázisban, hogy elkerüljük
az illetéktelen hozzáférést. A hallgatók által megadott válaszokat is tárolni fogjuk, hogy későbbi
statisztikák és elemzések készítéséhez rendelkezésre álljanak az adatok.

Az alkalmazás célja, hogy egyszerűsítse a felmérések készítését és az adatok kezelését az egyetemi
közösség számára, és biztonságosan és hatékonyan tárolja az összegyűjtött információkat a jövőbeli felhasználás céljából.

## Funkcionális követelmények

## Törvények Jogszabályok

__Általános Adatvédelmi Rendelet (GDPR)__: Az Európai Unióban működő mobilalkalmazásoknak a GDPR 
rendelkezéseit be kell tartaniuk, ha az alkalmazás felhasználóinak személyes adatait kezelik. 
Ez magában foglalja a felhasználók hozzájárulását, adatbiztonságot és az adatokhoz való hozzáférés korlátozását is.

__Felhasználási feltételek és Adatvédelmi Nyilatkozat__: Az alkalmazásnak egyértelműen és érthetően 
kell megjelenítenie a felhasználási feltételeket és az adatvédelmi nyilatkozatot. 
Ezeknek tartalmazniuk kell, hogy milyen adatokat gyűjtenek, hogyan használják fel azokat, és kivel osztják meg.

__Cookie-k és Süti Beleegyezés__: Az Európai Unióban és sok más országban kötelezően előírják a 
felhasználói süti beleegyezést, ha az alkalmazás sütiket vagy hasonló technológiákat használ az adatgyűjtéshez.

__Adatbiztonság__: Az alkalmazásnak megfelelő intézkedéseket kell tennie az adatok biztonságos 
tárolására és védelmére, hogy megakadályozza az illetéktelen hozzáférést vagy adatvédelmi incidenseket.

__Hozzájárulás és hozzáférési jogok__: A felhasználóknak joguk van hozzájárulni adataik használatához 
a kérdőív kitöltésekor, és joguk van hozzáférni, módosítani vagy törölni ezeket az adatokat.

__Harmadik fél hozzáférés__: Ha az alkalmazás harmadik féllel osztja meg a kérdőívek adatait 
(például az eredmények elemzése céljából), akkor erre vonatkozóan is megfelelő hozzájárulást és 
adatvédelmi intézkedéseket kell alkalmazni.

__Hozzáférhetőség és diszkrimináció elkerülése__: Az alkalmazásnak biztosítania kell, hogy a kérdőívek 
ne diskrimináljanak semmilyen személy vagy csoport ellen, és azok hozzáférhetők legyenek mindenki számára.

__Szerzői jog és szellemi tulajdon__: Az alkalmazásnak biztosítania kell, hogy a kérdőívek ne sértsenek szerzői jogokat vagy szellemi tulajdont.

__Adatkezelési tájékoztatás__: Az alkalmazásnak világosan tájékoztatnia kell a felhasználókat arról, 
hogy milyen módon használják fel az adataikat, és milyen jogokkal rendelkeznek az adataik felett.

## Követelménylista

## Jelenlegi üzleti folyamatok modellje

<img src="Diagrams/JelenlegiÜzFoly.png" width="600">

Napjainkban még mindig elterjedtek a papir alapú kérdőivek, melyek kinyomtatása éredkében évente több 
ezer fát vágnak ki papir készítéséhez, ami nem előnyös környezetünk és bolygónk egészsége érdekében.
Ehez még hozzá jön az ipari menyniségű tinta, ami a nyomtatások során felhasználásra kerülnek. 
Több tonna haszált papir halmozodik fel világszerte évente kérdőivek követekeztében és ennek nem biztos, 
hogy az egésze egyáltalán újra hasznosításra tud e jutni. és mind ez csak azért, hogy a nagy történések
tekintetében egy minimális ideig legyen használva az a kérdőívet tartalmazó lap. 
Az arra vállalkozók kitöltik a kérdőívet, majd azt a szakszerű feldolgozás és sztatisztika érdekében 
egy szakembernek be kell vinnie a megadott adatokat a számítógépbe, amik lehetnek hiányosak, 
kiolvashatatlanok, ezzel megnehezítve a munkát.

## Igényelt üzleti folyamatok modellje

## Riport

## Fogalomszótár
