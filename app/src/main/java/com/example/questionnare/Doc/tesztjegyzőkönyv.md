Teszt jegyzőkönyve

Tesztelt projekt: Questionnare
Teszt kezdete: 2023.11.01.
Teszt leírása: Az applikáció különböző osztálya valamint az adatbázisának a tesztelése.


| Step Description | Test Date	| Expected Result | 	Actual Results | PASS/FAIL	| Additional Notes/Who did it |
| ---------------- | ---------  | --------------- | ---------------- | ---------- | --------------------------- |
| setUp(): Célja a tesztek előkészítése, inicializálása. Ez magában foglalja az alkalmazás kontextusának létrehozását, az adatbázis kapcsolat megnyitását is a DatabaseManager open() metódusából | 	2023.11.29. 15:30	| setUp() metódus sikeres végrehajtása és az adatbázis kapcsolat megnyitása | Megkaptam az „Expected Result”-ot	| PASS	| Papp Gréta |
| tearDown(): metódus célja a tesztek utókészítése, takarítás. Az adatbázis kapcsolat bezárása és egyéb szükséges lépések elvégzése.	| 2023.11.29. 15:30 |	tearDown() metódus sikeres végrehajtása. Az adatbázis kapcsolat lezárása.	| Megkaptam az „Expected Result”-ot	| PASS	| Papp Gréta |
| addUserTest(): Ellenőrzi, hogy a DatabaseManager megfelelően hozzá tud-e adni egy felhasználót az adatbázishoz.	| 2023.11.29.16:17	| checkUser metódus visszaadja, hogy a felhasználó hozzá lett adva | Megkaptam az „Expected Result”-ot	| PASS	| Papp Gréta |
| checkUserTest(): Ellenőrzi, hogy a DatabaseManager helyesen kezeli a felhasználói hitelesítés ellenőrzését.	 | 2023.11.29. 16:20	| checkUser metódus visszaadja, hogy a felhasználó hozzá lett adva	| Megkaptam az „Expected Result”-ot | PASS	| Papp Gréta |
| checkEmailTest(): Ellenőrzi, hogy a DatabaseManager helyesen kezeli az email cím ellenőrzését.	| 2023.11.29. 16:23	| a checkEmail metódus visszaadja, hogy az email cím még nem létezik, majd a hozzáadás után igaz értékkel tér vissza.	| Megkaptam az „Expected Result”-ot	| PASS	| Papp Gréta |
| getUserIdTest(): Ellenőrzi, hogy a DatabaseManager helyesen visszaadja a felhasználói azonosítót az email cím alapján.	| 2023.11.29. 16:30 |	a getUserId metódus a helyes felhasználói azonosítót adja vissza. | Megkaptam az „Expected Result”-ot |	PASS |	Papp Gréta |
| addQATest(): Ellenőrzi, hogy a DatabaseManager helyesen hozzáadja a kérdéseket és válaszokat az adatbázishoz.	| 2023.11.29. 16:35 |	metódus visszaadja, hogy a kérdés hozzá lett adva	| Megkaptam az „Expected Result”-ot	| PASS	| Papp Gréta |
| addResultTest(): Ellenőrzi, hogy a DatabaseManager helyesen kezeli az eredmények hozzáadását az adatbázishoz. |	2023.11.29. 16:42	| az eredmények helyesen visszakerülnek az adatbázisba.	| Megkaptam az „Expected Result”-ot	| PASS	| Papp Gréta |
| initializeQAAndisQAInDatabaseTest(): Ellenőrzi, hogy a DatabaseManager inicializálja-e a kérdéseket, majd sikeresen ellenőrzi, hogy a kérdés az adatbázisban van-e. Két function-t ellenőrzök egyszerre.	| 2023.11.29. 17:23	| a kérdés az adatbázisban található	| Megkaptam az „Expected Result”-ot	| PASS	| Papp Gréta |
| getAnswersByQuestionTest(): Ellenőrzi, hogy a DatabaseManager helyesen visszaadja-e a kérdéshez tartozó válaszokat.	| 2023.11.29. 17:30	| a visszaadott válasz megegyezik a várt válasszal.	| Megkaptam az „Expected Result”-ot	| PASS	| Papp Gréta |
| getQADataTest(): Ellenőrzi, hogy a DatabaseManager helyesen visszaadja-e az összes kérdést és választ az adatbázisból.	| 2023.11.29. 18:17	| a visszaadott adatok megegyeznek a várt adatokkal. |  Megkaptam az „Expected Result”-ot	| PASS	| Papp Gréta |

Tesztelő környezet: Robolectric tesztelő keretrendszer
Android SDK: O_MR1 verzió
Megjegyzés: A tesztek végrehajtásakor biztosítva van, hogy az adatbázis inicializálása és a szükséges adatok betöltése már megtörtént. A Robolectric tesztelő keretrendszer használata a Android Studio JUnit4 tesztek és a tesztelendő osztályok loggolása miatt lett alkalmazva

| Step Description | Test Date	| Expected Result | 	Actual Results | PASS/FAIL	| Additional Notes/Who did it |
| ---------------- | ---------  | --------------- | ---------------- | ---------- | --------------------------- |
| Arrange :egy próbapofilt hozz létre | 2023.11.21. 18.37 | egy próbapofil beillesztése  |  Megkaptam az „Expected Result”-ot  | PASS | Fekete Enikő |
| Act : a próbapofil profiljának megtekintése | 2023.11.7 19.03. | a profil adatainak ellenőőrzése | Megkaptam az „Expected Result”-ot | PASS | Fekete Enikő |
| Assert: az eredmény megtekintése | 2023. 11.7. 19.53 | a próbapofil törlése | Megkaptam az „Expected Result”-ot | PASS | Fekete Enikő|

| Step Description | Test Date	| Expected Result | 	Actual Results | PASS/FAIL	| Additional Notes/Who did it |
| ---------------- | ---------  | --------------- | ---------------- | ---------- | --------------------------- |
| testQuestionsActivity: A teszt azt ellenőrzi, hogy a QuestionsActivity helyesen jelenik meg, a felhasználók helyesen válaszolnak-e a kérdésekre (legalább egy rádiógomb van bejelölve minden kérdéshez), és a válaszok elküldése után a megfelelő átmenet történik-e a HomeActivity-re. | 2023.11.22. 13.52. |  Megkaptam az „Expected Result”-ot  |  a kérdés lebonyolításának ellenőrzése | PASS | Fekete Enikő | 
| areAllRadioButtonsChecked:  az a feladata, hogy ellenőrizze, hogy az összes rádiógomb be van-e jelölve a QuestionsActivity által megjelenített kérdéseknél. | 2023. 11.22. 14.48.  |  Megkaptam az „Expected Result”-ot  |  a gombok megjelennek | PASS | Fekete Enikő |

| Step Description | Test Date	| Expected Result | 	Actual Results | PASS/FAIL	| Additional Notes/Who did it |
| ---------------- | ---------  | --------------- | ---------------- | ---------- | --------------------------- |
| testDefaultFragment(): , ez a teszteset azt biztosítja, hogy amikor a HomeActivity elindul, az alapértelmezett fragmens a megadott konténerben (R.id.container) a Qlist típusú legyen | 2023.11.22. 22.58. |  Megkaptam az „Expected Result”-ot  |  a típus megegyezik | PASS | Fekete Enikő és Kaponyás Lüszi |


| Step Description | Test Date	| Expected Result | 	Actual Results | PASS/FAIL	| Additional Notes/Who did it |
| ---------------- | ---------  | --------------- | ---------------- | ---------- | --------------------------- |
| testSuccessfulLogin():  ellenőrzi hogy  a bejelentkezési művelet a megfelelő módon fut-e le, és hogy a HomeActivity az elvárt adatokkal kerül-e megnyitásra | 2023.11.23. 07.12. | Megkaptam az „Expected Result”-ot | az adatok rendben betöltődnek | PASS | Fekete Enikő és Kaponyás Lüszi |
| Intents.release(): Ez a sor felszabadítja az Espresso Intents keretrendszerrel kapcsolatos erőforrásokat. | 2023.11.23. 07.59. | Megkaptam az „Expected Result”-ot | az erőforrás megtisztult | PASS | Fekete Enikő és Kaponyás Luszy |
| launchActivity():  elindítja az Android alkalmazás MainActivity komponensét, és inicializálja az Espresso Intents keretrendszert | 2021.11.23. 10.51. | Megkaptam az „Expected Result”-ot | minden tesztmetódus előtt lefut | PASS | Fekete Enikő és Kaponyás Lüszi |


| Step Description | Test Date	| Expected Result | 	Actual Results | PASS/FAIL	| Additional Notes/Who did it |
| ---------------- | ---------  | --------------- | ---------------- | ---------- | --------------------------- |
| validatePackageName():Az összehasonlítás segítségével a teszt megállapítja, hogy az alkalmazás csomagnéve megegyezik-e a várt értékkel ("com.example.questionnare") | 2023.11.23. 18.24. | Megkaptam az „Expected Result”-ot | a tesztben és az appban megegyeznek a nevek | PASS | Fekete Enikő és Papp Gréta |


| Step Description | Test Date	| Expected Result | 	Actual Results | PASS/FAIL	| Additional Notes/Who did it |
| ---------------- | ---------  | --------------- | ---------------- | ---------- | --------------------------- |
| testListItemClick(): a teszt azt ellenőrzi, hogy a lista első elemére történő kattintás működik-e megfelelően a MainActivity alkalmazásban | 2023.11.23. 23.46. | Megkaptam az „Expected Result”-ot | a kattintások során minden elem megfelelően működik | PASS | Fekete Enikő |


| Step Description | Test Date	| Expected Result | 	Actual Results | PASS/FAIL	| Additional Notes/Who did it |
| ---------------- | ---------  | --------------- | ---------------- | ---------- | --------------------------- |
| initDb metódus:Az inMemoryDatabaseBuilder segítségével egy Room adatbázist hoz létre az alkalmazás kontextusával. | 2023.11.26. 7.15. |  Megkaptam az „Expected Result”-ot | adatbázsi létrehozva |  PASS | Fekete Enikő és Papp Gréta |
| closeDb :Lezárja az adatbázist a teszt után. | 2023.11.26. 9.01. |  Megkaptam az „Expected Result”-ot | addatbázis zárva |  PASS | Fekete Enikő és Papp Gréta |
| insertAndReadData: egyszerű teszt, amely adatokat szúr be az adatbázisba, majd kiolvassa azokat, és ellenőrzi, hogy a beolvasott adatok megegyeznek-e a beillesztett adatokkal. | 2023.11.26. 10.32. |  Megkaptam az „Expected Result”-ot | az adatok egyértelműen megegyeznek |  PASS | Fekete Enikő és Papp Gréta |
| MyDatabase osztály: Ez egy abstract Room adatbázis osztály, amely kiterjeszti a RoomDatabase osztályt. | 2023.11.26. 12.35. |  Megkaptam az „Expected Result”-ot | adatbázis kiterjesztve |  PASS | Fekete Enikő és Papp Gréta |
| MyDao interfész:A metódusok segítségével az adatbázishoz való hozzáférést definiálja. | 2023.11.26. 14.07. | Megkaptam az „Expected Result”-ot | külön hozzáférések definiálva |  PASS | Fekete Enikő és Papp Gréta |


| Step Description | Test Date	| Expected Result | 	Actual Results | PASS/FAIL	| Additional Notes/Who did it |
| ---------------- | ---------  | --------------- | ---------------- | ---------- | --------------------------- |
|setup():elindítja a SignUpActivity-t a ActivityScenario.launch(SignUpActivity.class) hívással. | 2023.11.25. 22.59. |   Megkaptam az „Expected Result”-ot | elindult a bejelentkezési folyamat |  PASS | Fekete Enikő és Varga Petra|
| testRegistrationSuccess(): lehetővé teszi az Android alkalmazások felhasználói felületének (UI) automatizált tesztelését. A konkrét műveletek a regisztrációs űrlap kitöltését és a regisztrációs gomb megnyomását szimulálják. Azt várják, hogy ezek a műveletek sikeresen lefutnak, és a regisztráció eredményeként a helyes nézetek jelennek meg a felhasználói felületen. | 2023.11.25. 21.41. |   Megkaptam az „Expected Result”-ot |  helyes nézet jelenik meg |  PASS | Fekete Enikő és Varga Petra |

| Step Description | Test Date	| Expected Result | 	Actual Results | PASS/FAIL	| Additional Notes/Who did it |
| ---------------- | ---------  | --------------- | ---------------- | ---------- | --------------------------- |
| Arrange: Itt inicializáljuk és előkészítjük azokat az objektumokat vagy értékeket, amelyekre a tesztünk szüksége van. Ebben az esetben két egész számot állítunk be (operand1 és operand2). | 2023.11.14. 23.11. |   Megkaptam az „Expected Result”-ot | egész számok beállítódtak | 
| Act: Ebben a szakaszban meghívjuk azt a funkciót vagy metódust, amelyet tesztelni szeretnénk. Ebben az esetben az ArithmeticUtil.add metódust hívjuk meg az operand1 és operand2 értékekkel, és a visszatérő értéket tároljuk a result változóban. | 2023.11.14. 23.33. | Megkaptam az „Expected Result”-ot | értékek a result változóban vannak |  PASS | Fekete Enikő és Varga Petra |
| Assert: Ebben a részben ellenőrizzük, hogy az aktuális eredmény megegyezik-e a várt eredménnyel. Ha az összeadás helyesen működik, akkor a result értékenek 4-nek kell lennie. Az assertEquals függvény segítségével ellenőrizzük ezt, és hiba esetén kijelzi egy megfelelő üzenettel. | 2023.11.14. 23.59.  | Megkaptam az „Expected Result”-ot | 4-es érték jön ki |  PASS | Fekete Enikő és Varga Petra |

| Step Description | Test Date	| Expected Result | 	Actual Results | PASS/FAIL	| Additional Notes/Who did it |
| ---------------- | ---------  | --------------- | ---------------- | ---------- | --------------------------- |
 | IntentsTestRule :segítségével inicializál egy HomeActivity-t, majd a setUp és tearDown metódusokban előkészíti és lezárja az alkalmazás teszteléséhez szükséges adatbázist. | 2023.11.30. 15.4. | Megkaptam az „Expected Result”-ot | adatbázis időben dolgozódik fel | PASS | Fekete Enikő és Varga Petra |
| testNavigationToProfileActivity : ellenőrzi, hogy a profil ikonra történő kattintás után megfelelően megnyílik-e a ProfileActivity | 2023.11.30. 16.00 | Megkaptam az „Expected Result”-ot | megnyílt | PASS | Fekete Enikő és Varga Petra |
| testDefaultFragmentIsDisplayed:  ellenőrzi, hogy az alkalmazás alapértelmezett állapotban a Qlist fragmentet jeleníti-e meg. | 2023.11.30. 16. 24. | Megkaptam az „Expected Result”-ot | helyes fregmentet jelenít meg | PASS | Fekete Enikő és Varga Petra |
| tearDown(): tisztít, ha kell | 2023.11.30. 18.02. | Megkaptam az „Expected Result”-ot | tisztít | PASS | Fekete Enikő és Varga Petra |
