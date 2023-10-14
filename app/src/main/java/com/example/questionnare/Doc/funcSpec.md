# Funkcionális Specifikációk(160 sor)


## Áttekintés
Az egyetem olyan szoftvert igényel, amely lehetővé teszi kérdőívek (questionnaires) használatát az
ott tanuló diákok adatainak gyűjtésére és értékelésére. Az alapvető cél az, hogy megértsék a diákok
véleményét és tapasztalatait az egyetemi élettel kapcsolatban, valamint az egyetemi szolgáltatásokkal
és oktatási programokkal kapcsolatban.

Az alkalmazásban minden diáknak saját felhasználói fiókja kell legyen, amelyet regisztrációval hoznak
létre. A regisztrációhoz egyetemi e-mail cím és jelszó szükséges, és ezek az adatok kerülnek tárolásra
egy adatbázisban. A felhasználóknak lehetőséget kell adni a be- és kijelentkezésre is.

Az alkalmazásnak lehetővé kell tennie az egyetem által létrehozott kérdőív könnyű kezelését.
A kérdőívnek felhasználóbarát felülettel kell rendelkeznie, amely lehetővé teszi a diákok számára a
könnyű navigációt és a kérdések egyszerű megértését. Nem adtak megszorítást a kérdőívek megjelenítésére,
az alkalmazásnak lehetőséget nyújthat különböző típusú kérdések (pl. válaszok, skála, szöveges válaszok) hozzáadására.

A felmérés során összegyűjtött adatokat biztonságosan és titkosan kell tárolni az adatbázisban, hogy
elkerüljük az illetéktelen hozzáférést. Csak a megfelelő jogosultságokkal rendelkező személyeknek
szabad hozzáférni az adatokhoz. Az egyes felhasználók által megadott válaszokat is biztonságosan kell
tárolni.

Az alkalmazásnak lehetővé kell tennie az összegyűjtött adatok statisztikai elemzését és riportok
készítését. Ez segíti az egyetemi vezetőket abban, hogy jobban megértsék a hallgatók véleményét és
az esetleges problémákat az egyetemen.

Összességében az alkalmazás célja a diákok véleményének és tapasztalatainak összegyűjtése és
értékelése az egyetemi élettel kapcsolatban, valamint az egyetemi szolgáltatások és oktatási programok
javítása. A projektnek kiemelten kell kezelnie az adatvédelmet, hogy biztosítsa az adatok biztonságos
kezelését és a felhasználók személyes adatainak védelmét.

## Jelenlegi helyzet
A hagyományos, papíralapú kérdőívek használata hosszú ideje szolgálta az adatgyűjtés és felmérések
célt, de ma már számos problémát hordoz magában, különösen az egyetemi környezetben:

* A papíralapú kérdőívek előkészítése és terjesztése jelentős költségekkel jár. Az egyetemnek pénzt
kell fordítania a nyomtatásra, papírra, nyomtató tintára és egyéb nyomtatási költségekre. Ezen felül
a papíralapú kérdőívek kézi feldolgozása és adatrögzítése további időt és pénzt emészt fel.
* A kérdőívek elkészítése és kiosztása hosszadalmas folyamat. Nehéz olyan időpontokat találni, amikor
a hallgatók könnyen hozzáférhetnek a kérdőívekhez, és nehéz ellenőrizni, hogy mindenkit elért-e a kérdőív.
Ezáltal a válaszadási arány csökkenhet.
* Az adatok kézzel történő rögzítése a számítógépen rendkívül időigényes és hibalehetőségekkel terhelt
folyamat. Az emberi hiba lehetősége fennáll, és az adatok elveszhetnek vagy megsérülhetnek.
* Gyakran előfordul, hogy a kitöltők hibás vagy hiányos adatokat adnak meg, vagy félreértelmezett kérdésekre
adnak válaszokat. Ez torzíthatja az eredményeket és nehezítheti az adatok értelmezését.

Ezzel szemben az online kérdőívek használata modern és hatékony alternatívát kínál az egyetemnek a papíralapú kérdőívekhez képest:
* Nincs szükség nyomtatásra, postázásra vagy kézi adatrögzítésre, így a költségek minimalizálódnak.
* Az online kérdőívek azonnal hozzáférhetők a diákok számára, és a válaszok automatikusan rögzülnek.
Ez lehetővé teszi, hogy az egyetem gyorsabban és hatékonyabban gyűjthesse az adatokat.
* Az online kérdőívek csak azokat a válaszokat fogadják el, amelyek megfelelő azonosítással és
válaszokkal rendelkeznek. Ez minimalizálja az emberi hibák és adatok helytelen rögzítésének lehetőségét.
* Az emberek bármikor és bárhol kitölthetik az online kérdőíveket az interneten keresztül.
Ez növeli a válaszadási arányt, mivel a diákoknak nincs szükségük fizikai jelenlétre.
* Az online platformok lehetővé teszik az adatok gyors és egyszerű elemzését. Az egyetem könnyen és
* gyorsan létrehozhat riportokat és statisztikákat az összegyűjtött adatok alapján.

## Követelménylista

## Jelenlegi üzleti folyamatok modellje

<img src="Diagrams/JelenlegiÜzFoly.png" width="600">

Napjainkban továbbra is elterjedt a papír alapú kérdőívek használata, amelyek nyomtatása érdekében 
évente több ezer fa kerül kivágásra. Ez a gyakorlat sajnos súlyos környezeti hatásokkal jár, mivel 
a fafeldolgozás és a papírgyártás szén-dioxid-kibocsátással jár, és az erdőirtás veszélyezteti a 
biodiverzitást és a természetes élőhelyeket. A nagy mennyiségű papírhasználatunk tehát károsítja 
bolygónk egészségét és hozzájárul a klímaváltozás problémájához.

Ezenkívül ne feledkezzünk meg az ipari mennyiségű tintáról is, amely a kérdőívek nyomtatásakor kerül 
felhasználásra. A tinta előállítása is környezeti terhelést jelent, és a felesleges tintától való 
megszabadulás sem egyszerű feladat.

Világszerte évente több tonna használt papír halmozódik fel a kitöltött kérdőívek eredményeként, 
és sajnálatosan kevés ezek közül kerül újrahasznosításra. Ez azzal is jár, hogy a már egyszer használt 
papíranyagot további faanyagokra van szükség annak pótlásához, ami további erdőirtást eredményez.

Minden ez csak azért történik, hogy a kérdőívek tartalmazó lapokat egy rövid ideig használják fel. 
Azok, akik kitöltik ezeket a kérdőíveket, átadják azokat, és a megadott adatokat egy szakembernek kell 
beírnia a számítógépbe a szakszerű feldolgozás és statisztikai elemzés érdekében. Ebben a folyamatban 
gyakran előfordulhatnak problémák, például hiányos vagy olvashatatlan kérdőívek, amelyek tovább 
nehezítik a munkát és hozzájárulnak az erőforrások pazarlásához.

Ezek az aggályok és problémák rámutatnak arra, hogy sürgősen szükség van a digitális technológiák 
és az online adatgyűjtés előnyeinek kihasználására, hogy csökkentsük a papírfelhasználást, 
minimalizáljuk a környezeti hatásokat, és hatékonyabban dolgozzunk az adatokkal.

## Igényelt üzleti folyamatok modellje

Létrehozunk egy olyan felületet, amely képes az ún. szűrésre a felhasználók között. Ez kiemelten fontos, 
mivel szeretnénk a hallgatók tapasztalatai alapján szűrni a válaszadók között. Ezért a kérdőív 
kitöltése előtt egy rövid "tesztet" kérünk tőlük, amely segít megállapítani, mennyi tapasztalatuk van 
az adott témával kapcsolatosan. A felhasználók a kérdőív kitöltése során számos választási lehetőséggel találkozhatnak, például 
*  igaz-hamis
*  feleletválasztós, egy választási lehetőséggel
*  feleletválasztós, több választási lehetőséggel
*  saját válasz megadós
  
Ezen adatok természetesen titkosítva vannak, és tilos bárminemű visszaélés velük.

A hallgatók saját fiókkal kell, hogy rendelkezzenek, hogy ki tudják tölteni a kérdőívet, illetve az 
adminoknak is saját fiókjuk lesz, hogy hozzáférjenek a statisztikákhoz.


## Használati esetek

__Felhasználó__: A felhasználó regisztráció után bejelentkezhet az alkalmazásba. Az alkalmazás 
főoldalán a kitöltésre váró Kérdőívekre rákattintva azt a felhasználó kitöltheti. A Kérdőív több
típusú kérdést is tartalmazhat amelyek a továbbiak:
 * Nyitott kérdések: a válaszadó a saját véleményét fogalmazhatja meg az adott témában
 * Zárt kérdések: 
   * Alternatív: 2 közül lehet választani (I-H)
   * Szelektív: több válasz lehetőség, 1 vagy több válasz lehetőség is megjelőlhető
   * Skála: minősítési sorrend (pl. 1-5)

__Admin__: Kérdőíveket publikálhat az alkalmazásban a felhasználók számára. A kitöltött kérdőívek 
eredményeit megszemlélheti, statisztikát készíthet belőle

## Megfeleltetés, hogyan fedik le a használati esetek a követelményeket

A kérdőív kizárólag a hallgatók számára lesz elérhető, és kitölthető,

1. egyszerű adatgyűjtésre:

* igaz-hamis kérdés
* feleletválasztós kérdés
* kitöltendő kérdés

2. tematizált adatgyűjtésre:

* igaz-hamis kérdés
* feleletválasztós kérdés
* kitöltendő kérdés

## Képernyő tervek

<img src="Diagrams/bejelentkezesScreen.png" width="250"> <img src="Diagrams/regisztracioScreen.png" width="250">
<img src="Diagrams/homeScreen.png" width="250"> <img src="Diagrams/profilScreen.png" width="250"> 
<img src="Diagrams/fillingScreen.png" width="250">

Az első képen a bejelentkezési képernyőt látható, ahol egy email cím és jelszó megadását követően be is jelentkezhetünk az alkamazásba.

A második képen a regisztrációs képernyőn a regisztráció egy email cím, egy jelszó és a karunk megadása után
meg is történik, amennyiben elfogadjuk az Adatvédelmi tájékoztatót.

A harmadik képernyőn az alkamazás fő képernyője szerepel ahol elsőként láthatjuk a kitöltésre váró
kérdőíveket. A képernyő alján lévő menüben láthatunk 2 gombot. A középen elhelyezkedő a fő képernyőhöz 
vezet minket, míg a jobb oldalon lévő a felhasználó profilját nyitja meg.

A profil képernyőn a felhasználó láthatja a regisztrációnál megadott adatait. Az adatok módositását 
elvégezheti a képernyő alján elhelyezkedő módositás gombbal. A mellette elhelyezkedő törlés gombbal pedig törölheti 
a felhasználói fiókját

Az utolsó képen pedig a kitöltés alatt álló kérdőívet láthatjuk különféle kérdés tipusokkal. 

## Forgatókönyv

## Funkció - követelmény megfeleltetés 

A hallgató a felületen keresztül bejelentkezhet az egyetemi e-mail címe segítségével.
Ezután jöhetnek a kérdőív kérdései, mely legelején egy rövid teszt segítségével felmérjük, illetve 
megállapítjuk a kitöltő tapasztalatát az adott témában. A felmérés után jöhetnek a számunkra, illetve 
a statisztika számára is fontos kérdések. Ezen kérdések megjelenhetnek a következő formákban:
* két válaszlehetőség közül egy válasz kiválasztása
* több válaszlehetőség közül egy válasz kiválasztása
* több válaszlehetőség közül több válasz kiválasztása
* a kitöltő a saját szavaival válaszolhat a kérdésre

Az adatokat az arra szolgáló adatbázisban tároljuk el. 

## Fogalomszótár
