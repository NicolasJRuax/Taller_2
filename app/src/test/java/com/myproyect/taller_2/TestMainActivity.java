package com.myproyect.taller_2;

import junit.framework.TestCase;


import android.content.Context;
import android.content.SharedPreferences;
import androidx.test.core.app.ApplicationProvider;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMainActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Before
    public void setUp() {
        Context context = ApplicationProvider.getApplicationContext();
        sharedPreferences = context.getSharedPreferences("AppSettings", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Test
    public void testSaveUserName() {
        String testName = "Juan";

        // Guardar el nombre en SharedPreferences
        editor.putString("userName", testName);
        editor.apply();

        // Leer el nombre guardado
        String savedName = sharedPreferences.getString("userName", "");

        // Verificar que el nombre guardado es correcto
        assertEquals(testName, savedName);
    }

    @Test
    public void testSaveBackgroundColor() {
        int testColor = 0xFFFF0000; // Rojo

        // Guardar el color en SharedPreferences
        editor.putInt("backgroundColor", testColor);
        editor.apply();

        // Leer el color guardado
        int savedColor = sharedPreferences.getInt("backgroundColor", 0);

        // Verificar que el color guardado es correcto
        assertEquals(testColor, savedColor);
    }

    @Test
    public void testDefaultValues() {
        // Verificar que el valor por defecto del nombre es vacío
        String defaultName = sharedPreferences.getString("userName", "");
        assertEquals("", defaultName);

        // Verificar que el valor por defecto del color es blanco
        int defaultColor = sharedPreferences.getInt("backgroundColor", 0xFFFFFFFF);
        assertEquals(0xFFFFFFFF, defaultColor);
    }
}
