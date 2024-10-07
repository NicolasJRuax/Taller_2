package com.myproyect.taller_2;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tareasenfondojava.R;

import java.util.Calendar;

public class InicioActivity extends AppCompatActivity {

    private TextView greetingText;
    private Button goToMainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        greetingText = findViewById(R.id.tvGreeting);
        goToMainButton = findViewById(com.example.tareasenfondojava.R.id.btnGoToMain);

        // Restaurar el color de fondo guardado
        SharedPreferences preferences = getSharedPreferences("AppSettings", MODE_PRIVATE);
        int backgroundColor = preferences.getInt("backgroundColor", getResources().getColor(R.color.default_color));
        getWindow().getDecorView().setBackgroundColor(backgroundColor);

        // Mostrar saludo personalizado con el nombre guardado
        String savedName = preferences.getString("userName", "");  // Obtén el nombre guardado
        String greeting = getGreetingMessage(savedName);  // Pasamos el nombre para el saludo
        greetingText.setText(greeting);

        // Botón para ir a la actividad principal
        goToMainButton.setOnClickListener(view -> {
            Intent intent = new Intent(InicioActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    // Método para obtener el saludo personalizado con el nombre del usuario
    private String getGreetingMessage(String name) {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        String timeOfDayGreeting;

        if (hour >= 0 && hour < 12) {
            timeOfDayGreeting = "Buenos días";
        } else if (hour >= 12 && hour < 18) {
            timeOfDayGreeting = "Buenas tardes";
        } else {
            timeOfDayGreeting = "Buenas noches";
        }

        if (!name.isEmpty()) {
            return timeOfDayGreeting + ", " + name + "!";
        } else {
            return timeOfDayGreeting;
        }
    }
}
