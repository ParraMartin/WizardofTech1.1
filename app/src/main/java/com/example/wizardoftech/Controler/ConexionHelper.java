package com.example.wizardoftech.Controler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionHelper extends SQLiteOpenHelper {
    public ConexionHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Modifica la sentencia SQL para hacer que el ID sea autoincremental
        String query = "CREATE TABLE " + utility.TABLA_USUARIO + " (" +
                utility.CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                utility.CAMPO_NOMBRE + " TEXT, " +
                utility.CAMPO_CORREO + " TEXT, " +
                utility.CAMPO_password + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+utility.TABLA_USUARIO);
        onCreate(db);

    }

    // En tu ConexionHelper
    public boolean verificarCredenciales(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        // Consulta para verificar las credenciales
        String query = "SELECT * FROM " + utility.TABLA_USUARIO +
                " WHERE " + utility.CAMPO_NOMBRE + " = ? AND " +
                utility.CAMPO_password + " = ?";

        // Argumentos para la consulta
        String[] selectionArgs = {username, password};

        // Ejecutar la consulta
        Cursor cursor = db.rawQuery(query, selectionArgs);

        // Verificar si se encontraron resultados
        boolean credencialesValidas = cursor.moveToFirst();

        // Cerrar el cursor y la base de datos
        cursor.close();
        db.close();

        return credencialesValidas;
    }

}