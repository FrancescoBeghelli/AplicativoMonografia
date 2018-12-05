package monografia.ufjf.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroAtividadeFisicaActivity extends AppCompatActivity {

    private EditText edtNomeAtividade;
    private EditText edtTempoGasto;
    private EditText edtDistPercorrida;
    private Double pontuacao;
    private Double tempo;
    private Double distancia;
    private Button btnCadastrarAtividadeFisica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_atividade_fisica);

        edtNomeAtividade = (EditText) findViewById(R.id.edtNomeAtividade);
        edtTempoGasto = (EditText) findViewById(R.id.edtTempoGasto);
        edtDistPercorrida = (EditText) findViewById(R.id.edtDistPercorrida);
        btnCadastrarAtividadeFisica = (Button)findViewById(R.id.btnCadastrarAtividadeFisica);

        btnCadastrarAtividadeFisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtTempoGasto.getText().toString().isEmpty() && !!edtDistPercorrida.getText().toString().isEmpty()) {
                    tempo = Double.parseDouble(edtTempoGasto.getText().toString());
                    distancia = Double.parseDouble(edtDistPercorrida.getText().toString());

                    switch (edtNomeAtividade.getText().toString()) {
                        case "":
                            Toast.makeText(CadastroAtividadeFisicaActivity.this, "Precisa Preencher a Atividade Feita", Toast.LENGTH_SHORT).show();
                        case "Corrida":
                            pontuacao = tempo * distancia;
                            break;
                        case "Caminhada":
                            pontuacao = (tempo * distancia) * 0.6;
                            break;
                        case "Natação":
                            pontuacao = (tempo * distancia) * 1.4;
                            break;
                        case "Futebol":
                            pontuacao = (tempo * distancia) * 1.3;
                            break;
                        case "Andar de Bicicleta":
                            distancia = 1.0;
                            pontuacao = (tempo * distancia) * 0.9;
                            break;
                        default:
                            Toast.makeText(CadastroAtividadeFisicaActivity.this, "Atividade Fisica não cadastrada", Toast.LENGTH_SHORT).show();
                    }

                    AtividadeFisicaContract.saveAtividade(new CadastroPessoalDbHelper(CadastroAtividadeFisicaActivity.this).getWritableDatabase(),
                            edtNomeAtividade.getText().toString(), edtTempoGasto.getText().toString(), edtDistPercorrida.getText().toString(), pontuacao.toString());
                    setResult(Activity.RESULT_OK);
                }
                else
                    Toast.makeText(CadastroAtividadeFisicaActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
