package com.kulesh.sqlone;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kulesh.sqlone.database.SQLiteHelper;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void createdb(View view) {
        SQLiteHelper helper=new SQLiteHelper(this);
        SQLiteDatabase database=helper.getWritableDatabase();
        Toast.makeText(getApplicationContext(), "db created", Toast.LENGTH_SHORT).show();
    }

    public void insertdb(View view) {
        SQLiteHelper helper=new SQLiteHelper(this);
        SQLiteDatabase database=helper.getWritableDatabase();
        database.execSQL("INSERT INTO user(name,password) VALUES('Kulesh','143')");
        Toast.makeText(getApplicationContext(), "value inserted", Toast.LENGTH_SHORT).show();
    }

    public void updatedb(View view) {
        SQLiteHelper helper=new SQLiteHelper(this);
        SQLiteDatabase database=helper.getWritableDatabase();
        database.execSQL("UPDATE user SET password='456'WHERE name='Kulesh'");
        Toast.makeText(getApplicationContext(), "Updated!!!", Toast.LENGTH_SHORT).show();
    }

    public void deletedb(View view) {
        SQLiteHelper helper=new SQLiteHelper(this);
        SQLiteDatabase database=helper.getWritableDatabase();
        database.execSQL("DELETE FROM user where id='1'");
        Toast.makeText(getApplicationContext(), "deleted!!!", Toast.LENGTH_SHORT).show();
    }

    public void searchdb(View view) {
        SQLiteHelper helper=new SQLiteHelper(this);
        SQLiteDatabase database=helper.getWritableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM user",null);
        while (cursor.moveToNext()){
//            System.out.println(cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2));
            Toast.makeText(getApplicationContext(), cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2), Toast.LENGTH_SHORT).show();
        }
    }
}