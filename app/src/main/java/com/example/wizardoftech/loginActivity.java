package com.example.wizardoftech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wizardoftech.Controler.ConexionHelper;

public class loginActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    Button loginButton;
    Button registroButton;
    private ConexionHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new ConexionHelper(this, "bd_usuarios", null, 1);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        registroButton = findViewById(R.id.registroButton); // Inicializa el botón

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (validarCredenciales(username, password)) {
                    Intent intent = new Intent(loginActivity.this, MainActivity.class);
                    intent.putExtra("USERNAME", username);
                    startActivity(intent);
                } else {
                    Toast.makeText(loginActivity.this, "Credenciales no válidas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Agrega el OnClickListener para el botón de registro
        registroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inicia la actividad de registro
                Intent intent = new Intent(loginActivity.this, registroActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean validarCredenciales(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Lógica para verificar credenciales en tu base de datos utilizando ConexionHelper
        boolean credencialesValidas = dbHelper.verificarCredenciales(username, password);

        if (!credencialesValidas) {
            Toast.makeText(this, "Credenciales no válidas", Toast.LENGTH_SHORT).show();
        }

        return credencialesValidas;
    }
}
