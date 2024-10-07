package com.myproyect.taller_2;



import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tareasenfondojava.R;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private TextView tvSavedName;
    private TextView tvProgress;
    private Button btnSaveName;
    private Button btnStartTask;
    private Button btnGoToSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.tareasenfondojava.R.layout.activity_main);

        etName = findViewById(R.id.etName);
        tvSavedName = findViewById(R.id.tvSavedName);
        tvProgress = findViewById(R.id.tvProgress);
        btnSaveName = findViewById(R.id.btnSaveName);
        btnStartTask = findViewById(R.id.btnStartTask);
        btnGoToSettings = findViewById(R.id.btnGoToSettings);

        // Restaurar el color de fondo guardado
        SharedPreferences preferences = getSharedPreferences("AppSettings", MODE_PRIVATE);
        int backgroundColor = preferences.getInt("backgroundColor", getResources().getColor(R.color.default_color)); // Valor por defecto
        getWindow().getDecorView().setBackgroundColor(backgroundColor);

        // Restaurar el nombre guardado, si existe
        String savedName = preferences.getString("userName", "");
        if (!savedName.isEmpty()) {
            tvSavedName.setText("Hola, " + savedName + "!");
        }

        // Guardar el nombre ingresado y mostrarlo
        btnSaveName.setOnClickListener(view -> {
            String name = etName.getText().toString();

            // Guardar el nombre en SharedPreferences
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("userName", name);  // Guardar el nombre
            editor.apply();

            // Mostrar el nombre
            tvSavedName.setText("Hola, " + name + "!");
        });

        // Iniciar una tarea en segundo plano
        btnStartTask.setOnClickListener(view -> {
            new BackgroundTask().execute();
        });

        // Ir a la pantalla de configuración
        btnGoToSettings.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ConfiguracionActivity.class);
            startActivity(intent);
        });
    }

    // AsyncTask para simular tarea en segundo plano
    private class BackgroundTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvProgress.setText("Iniciando tarea...");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i * 20);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tvProgress.setText("Progreso: " + values[0] + "%");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            tvProgress.setText("Tarea finalizada!");
        }
    }
}
