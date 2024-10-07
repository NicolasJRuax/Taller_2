package com.myproyect.taller_2;


import android.content.Intent;
import android.content.SharedPreferences;
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
        btnGoToHome = findViewById(com.example.tareasenfondojava.R.id.btnGoToHome);

        // Configurar el Spinner con los colores
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.colors_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerColors.setAdapter(adapter);

        // Cambiar color de fondo
        btnChangeColor.setOnClickListener(view -> {
            String color = spinnerColors.getSelectedItem().toString();
            int colorValue = 0; // Valor del color en formato int

            // Determina el color seleccionado
            switch (color) {
                case "Rojo":
                    colorValue = getResources().getColor(R.color.red);
                    break;
                case "Azul":
                    colorValue = getResources().getColor(R.color.blue);
                    break;
                case "Verde":
                    colorValue = getResources().getColor(R.color.green);
                    break;
            }

            // Guardar el color en SharedPreferences
            SharedPreferences preferences = getSharedPreferences("AppSettings", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("backgroundColor", colorValue); // Guardar el color seleccionado
            editor.apply();

            // Cambiar el color de fondo inmediatamente
            getWindow().getDecorView().setBackgroundColor(colorValue);

            Toast.makeText(ConfiguracionActivity.this, "Color cambiado a " + color, Toast.LENGTH_SHORT).show();
        });

        // Botón para volver a la pantalla de inicio
        btnGoToHome.setOnClickListener(view -> {
            Intent intent = new Intent(ConfiguracionActivity.this, InicioActivity.class);
            startActivity(intent);
        });
    }
}
