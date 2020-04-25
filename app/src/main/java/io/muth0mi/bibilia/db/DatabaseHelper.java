package io.muth0mi.bibilia.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DB_PATH;
    private static String DB_NAME = "swahili.db";

    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
        DB_PATH = myContext.getFilesDir().getParent() + "/databases/" + DB_NAME;
    }


    // Creates a empty database on the system and rewrites it with bible database in assets.
    public void createDataBase() {

        boolean dbExist = checkDataBase();

        // Check if database already exists
        if (!dbExist) {
            // Create empty database in the default system path
            this.getReadableDatabase();
            this.close();

//  todo          openDataBase().close();

            // Overwrite database with our database
            try {
                copyDataBase();
            } catch (IOException e) {
                Log.e("bible DB", (e.toString()));
            }
        }
    }

    // Check if the database already exist to avoid overwriting each time app is launched
    private boolean checkDataBase() {
        SQLiteDatabase checkDB;

        try {
            checkDB = SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READONLY);

            if (checkDB != null) {
                checkDB.close();
                return true;
            }

        } catch (SQLiteException e) {
            Log.e("bible DB", "DB does not exist");
        }
        return false;
    }

    // Copy your database from assets to the empty database in the system folder
    private void copyDataBase() throws IOException {
        // Open your assets db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        // Open the system db as the output stream
        OutputStream myOutput = new FileOutputStream(DB_PATH);

        // Transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }


    public SQLiteDatabase openDataBase() throws SQLException {
        //Open the database
        myDataBase = SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READONLY);

        // Return database
        return myDataBase;
    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();

        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


}