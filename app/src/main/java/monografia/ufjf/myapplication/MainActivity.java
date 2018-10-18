package monografia.ufjf.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCadPessoal;
    private Button btnAtivFis;
    private Button btnAliment;
    private Button btnMetaObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadPessoal = (Button) findViewById(R.id.btnCadPessoal);
        btnAtivFis = (Button) findViewById(R.id.btnAtivFis);
        btnAliment = (Button) findViewById(R.id.btnAlimentacao);
        btnMetaObj = (Button) findViewById(R.id.btnMetaObj);

        btnCadPessoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,CadastroPessoalActivity.class);
                startActivity(i);
            }
        });

        btnAtivFis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AtividadeFisicaActivity.class);
                startActivity(i);
            }
        });
        btnAliment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AlimentacaoActivity.class);
                startActivity(i);
            }
        });
        btnMetaObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MetaObjetivoActivity.class);
                startActivity(i);
            }
        });


    }
}
