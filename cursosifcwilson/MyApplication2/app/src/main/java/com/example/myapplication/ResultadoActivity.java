package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView txtResultado;
    private ImageView imgCurso;
    private Button btnVoltarInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        txtResultado = findViewById(R.id.txtResultado);
        imgCurso = findViewById(R.id.imgCurso);
        btnVoltarInicio = findViewById(R.id.btnVoltarInicio);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String[] resultadoCurso = getResumoCurso(intent.getStringExtra("cursoEscolhido"));

        String mensagem = "Bem-vindo(a), " + nome + "!\n\n" + "Resumo: " + resultadoCurso[0];
        txtResultado.setText(mensagem);

        exibirImagemCurso(resultadoCurso[1]);

        btnVoltarInicio.setOnClickListener(v -> voltarInicio());
    }


    private void exibirImagemCurso(String nomeImagem) {

        int idImagem = getResources().getIdentifier(nomeImagem, "drawable", getPackageName());


        imgCurso.setImageResource(idImagem);
    }


    private String[] getResumoCurso(String curso) {
        switch (curso) {
            case "Bacharelado em Sistemas de Informação":
                return new String[]{getString(R.string.sistemas_informacao_resumo), "sistemas_da_informacao"};
            case "Tecnologia em Sistemas para Internet (EaD)":
                return new String[]{getString(R.string.sistemas_internet_resumo), "sistemas_para_internet_ead"};
            case "Bacharelado em Agronomia":
                return new String[]{getString(R.string.agronomia_resumo), "agronomia"};
            case "Licenciatura em Pedagogia":
                return new String[]{getString(R.string.pedagogia_resumo), "pedagogia"};
            case "Tecnologia em Negócios Imobiliários":
                return new String[]{getString(R.string.negocios_imobiliarios_resumo), "negocios_imobiliarios"};
            default:
                return new String[]{"", ""};
        }
    }


    public void voltarInicio() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
