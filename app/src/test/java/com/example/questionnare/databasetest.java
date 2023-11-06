@RunWith(AndroidJUnit4.class)
public class MyDatabaseTest {
    private MyDatabase myDatabase;

    @Before
    public void initDb() {
        myDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                MyDatabase.class)
                .build();
    }

    @After
    public void closeDb() {
        myDatabase.close();
    }

    @Test
    public void insertAndReadData() {
        // Adatok beszúrása az adatbázisba
        myDatabase.myDao().insertData(new Data("example data"));

        // Adat
