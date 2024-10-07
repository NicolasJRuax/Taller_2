package com.myproyect.taller_2;



import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
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
        goToMainButton = findViewById(R.id.btnGoToMain);

        // Mostrar saludo personalizado
        String greeting = getGreetingMessage();
        greetingText.setText(greeting);

        // Botón para ir a la actividad principal
        goToMainButton.setOnClickListener(view -> {
            Intent intent = new Intent(InicioActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private String getGreetingMessage() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 0 && hour < 12) {
            return "Buenos días";
        } else if (hour >= 12 && hour < 18) {
            return "Buenas tardes";
        } else {
            return "Buenas noches";
        }
    }
}
