package monografia.ufjf.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AtividadeActivity extends AppCompatActivity {

    private Button btnAtividadeFisicaCad;
    private Button btnAlimentacaoCad;
    private Button btnEstudosCad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade);

        btnAtividadeFisicaCad = (Button) findViewById(R.id.btnAtividadeFisicaCad);
        btnAlimentacaoCad = (Button) findViewById(R.id.btnAlimentacaoCad);
        btnEstudosCad = (Button) findViewById(R.id.btnEstudosCad);

        btnAtividadeFisicaCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AtividadeActivity.this,CadastroAtividadeFisicaActivity.class);
                startActivity(i);
            }
        });

        btnAlimentacaoCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AtividadeActivity.this,CadastroAlimentacaoActivity.class);
                startActivity(i);
            }
        });

        btnEstudosCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AtividadeActivity.this,CadastroEstudoActivity.class);
                startActivity(i);
            }
        });
    }
}
