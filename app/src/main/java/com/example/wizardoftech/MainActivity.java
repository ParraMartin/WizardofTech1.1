package com.example.wizardoftech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_viw);
        toolbar = findViewById(R.id.toolbar);

        imageView1 = findViewById(R.id.bus);
        imageView2 = findViewById(R.id.imageView3);
        imageView3 = findViewById(R.id.bus1);
        imageView4 = findViewById(R.id.train);
        imageView5 = findViewById(R.id.cycle);
        imageView6 = findViewById(R.id.airplane);

        textView2 = findViewById(R.id.textView2);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navegation_drawer_open, R.string.navegation_drawer_Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        imageView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ArmadopcActivity.class);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, glosarioActivity.class);
                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, guiasActivity.class);
                startActivity(intent);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReciclajeActivity.class);
                startActivity(intent);
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, compativilidadActivity.class);
                startActivity(intent);
            }
        });


        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, mapa.class);
                startActivity(intent);
            }
        });


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("USERNAME")) {
            String username = intent.getStringExtra("USERNAME");
            textView2.setText(username);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId(); // Obtiene el ID del elemento de menú

        // Utiliza if-else para comparar el ID con las variables R.id
        if (itemId == R.id.Gabinete) {
            Intent intent1 = new Intent(MainActivity.this, GabineteActivity.class);
            startActivity(intent1);
            return true;
        } else if (itemId == R.id.Refrigeración) {
            Intent intent2 = new Intent(MainActivity.this, RefrigeracionActivity.class);
            startActivity(intent2);
            return true;
        } else if (itemId == R.id.Procesador) {
            Intent intent3 = new Intent(MainActivity.this, ProcesadorActivity.class);
            startActivity(intent3);
            return true;
        } else if (itemId == R.id.Memoria_RAM) {
            Intent intent4 = new Intent(MainActivity.this, MemoriaActivity.class);
            startActivity(intent4);
            return true;
        } else if (itemId == R.id.GPU) {
            Intent intent5 = new Intent(MainActivity.this, TarjetaActivity.class);
            startActivity(intent5);
            return true;
        } else if (itemId == R.id.Almacenamiento) {
            Intent intent6 = new Intent(MainActivity.this, AlmacenamientoActivity.class);
            startActivity(intent6);
            return true;
        } else if (itemId == R.id.Placa) {
            Intent intent7 = new Intent(MainActivity.this, PlacaActivity.class);
            startActivity(intent7);
            return true;
        } else if (itemId == R.id.Fuente) {
            Intent intent8 = new Intent(MainActivity.this, FuenteActivity.class);
            startActivity(intent8);
            return true;
        } else if (itemId == R.id.Monitor) {
            Intent intent9 = new Intent(MainActivity.this, MonitorActivity.class);
            startActivity(intent9);
            return true;
        } else if (itemId == R.id.in_secion) {
            Intent intent6 = new Intent(MainActivity.this, loginActivity.class);
            startActivity(intent6);
            return true;
        } else if (itemId == R.id.reg_usuario) {
            Intent intent11 = new Intent(MainActivity.this, registroActivity.class);
            startActivity(intent11);
            return true;
        } else if (itemId == R.id.Gabinete) {
                Intent intent1 = new Intent(MainActivity.this, GabineteActivity.class);
                startActivity(intent1);
                return true;


        } else {
            return false;
        }
    }
}