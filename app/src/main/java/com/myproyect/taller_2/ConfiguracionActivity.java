package com.myproyect.taller_2;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tareasenfondojava.R;

public class ConfiguracionActivity extends AppCompatActivity {

    private Spinner spinnerColors;
    private Button btnChangeColor;
    private Button btnGoToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        spinnerColors = findViewById(R.id.spinnerColors);
        btnChangeColor = findViewById(R.id.btnChangeColor);
        btnGoToHome = findViewById(R.id.btnGoToHome);

        // Configurar el Spinner con los colores
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.colors_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerColors.setAdapter(adapter);

        // Cambiar color de fondo
        btnChangeColor.setOnClickListener(view -> {
            String color = spinnerColors.getSelectedItem().toString();
            switch (color) {
                case "Rojo":
                    getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.red));
                    break;
                case "Azul":
                    getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.blue));
                    break;
                case "Verde":
                    getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.green));
                    break;
            }
            Toast.makeText(ConfiguracionActivity.this, "Color cambiado a " + color, Toast.LENGTH_SHORT).show();
        });

        // Botón para volver a la pantalla de inicio
        btnGoToHome.setOnClickListener(view -> {
            Intent intent = new Intent(ConfiguracionActivity.this, InicioActivity.class);
            startActivity(intent);
        });
    }
}
