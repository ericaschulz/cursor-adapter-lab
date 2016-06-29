package ly.generalassemb.drewmahrt.shoppinglistver2.setup;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ericaschulz on 6/28/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 7;
    public static final String DB_NAME = "SHOPPING_DB";
    public static final String CREATE_TABLE = "CREATE TABLE SHOPPING_LIST(id INT PRIMARY KEY, brand TEXT, item TEXT);";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS SHOPPING_LIST;";


    //public int id = id;
    public String brand = "brand";
    public String item = "item";

    public static final String shoppingList[] = {"id", "brand", "item"};


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);


    }

    public void createShoppingList(int id, String brand, String item) {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues list = new ContentValues();
        list.put("id", id);
        list.put("brand", brand);
        list.put("item", item);
        db.insert("SHOPPING_DB", null, list);
    }

    public void seedList() {
        createShoppingList(1, "Green Giant", "corn");
        createShoppingList(2, "Wonder", "bread");
        createShoppingList(3, "MinuteMaid", "orange juice");
        createShoppingList(4, "Bisquick", "pancakes");


    }
}



























