package com.example.wizardoftech;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wizardoftech.Controler.ConexionHelper;
import com.example.wizardoftech.Controler.utility;

public class registroActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText correoEditText;
    EditText passwordEditText;
    Button registroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usernameEditText = findViewById(R.id.usernameEditText);
        correoEditText = findViewById(R.id.correoEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registroButton = findViewById(R.id.registroButton);

        registroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validar datos antes de registrar al usuario
                validarDatos();
            }
        });
    }

    private void validarDatos() {
        String nombre = usernameEditText.getText().toString();
        String correo = correoEditText.getText().toString();
        String contraseña = passwordEditText.getText().toString();

        if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(correo) || TextUtils.isEmpty(contraseña)) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            Toast.makeText(this, "Ingrese un correo electrónico válido", Toast.LENGTH_SHORT).show();
            return;
        }

        // Si los datos son válidos, registrar al usuario en la base de datos
        registrarUsuarioEnBD(nombre, correo, contraseña);

        // Después de registrar, puedes redirigir a la pantalla de login si es necesario
        Intent intent = new Intent(registroActivity.this, loginActivity.class);
        startActivity(intent);
    }

    private void registrarUsuarioEnBD(String nombre, String correo, String contraseña) {
        ConexionHelper conn = new ConexionHelper(this, "bd_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(utility.CAMPO_NOMBRE, nombre);
        contentValues.put(utility.CAMPO_CORREO, correo);
        contentValues.put(utility.CAMPO_password, contraseña);

        long idResultante = db.insert(utility.TABLA_USUARIO, null, contentValues);
        Toast.makeText(getApplicationContext(), "ATENCION, id Registrado..." + idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}
