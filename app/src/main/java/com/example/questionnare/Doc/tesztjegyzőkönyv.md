#Teszt jegyzőkönyv

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
| testQuestionsActivity: A teszt azt ellenőrzi, hogy a QuestionsActivity helyesen jelenik meg, a felhasználók helyesen válaszolnak-e a kérdésekre (legalább egy rádiógomb van bejelölve minden kérdéshez), és a válaszok elküldése után a megfelelő átmenet történik-e a HomeActivity-re. | 2023.11.22. 13.52. | a kérdés lebonyolításának ellenőrzése | PASS | Fekete Enikő | 
| areAllRadioButtonsChecked:  az a feladata, hogy ellenőrizze, hogy az összes rádiógomb be van-e jelölve a QuestionsActivity által megjelenített kérdéseknél. | 2023. 11. 14.48. | a gombok megjelennek | PASS | Fekete Enikő |

| Step Description | Test Date	| Expected Result | 	Actual Results | PASS/FAIL	| Additional Notes/Who did it |
| ---------------- | ---------  | --------------- | ---------------- | ---------- | --------------------------- |
| validatePackageName():Az összehasonlítás segítségével a teszt megállapítja, hogy az alkalmazás csomagnéve megegyezik-e a várt értékkel ("com.example.questionnare") | 2023.11.23. 18.24. | a tesztben és az appban megegyeznek a nevek | PASS | Fekete Enikő és Papp Gréta |

| Step Description | Test Date	| Expected Result | 	Actual Results | PASS/FAIL	| Additional Notes/Who did it |
| ---------------- | ---------  | --------------- | ---------------- | ---------- | --------------------------- |
