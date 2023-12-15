package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PerfilActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editEmail;
    private Spinner spinnerCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        spinnerCursos = findViewById(R.id.spinnerCursos);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.cursos,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCursos.setAdapter(adapter);
    }

    public void verResultado(View view) {
        String nome = editNome.getText().toString();
        String cursoEscolhido = spinnerCursos.getSelectedItem().toString();

        Intent intent = new Intent(this, ResultadoActivity.class);
        intent.putExtra("nome", nome);
        intent.putExtra("cursoEscolhido", cursoEscolhido);
        startActivity(intent);
        finish();
    }
}
