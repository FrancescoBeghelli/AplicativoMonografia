package monografia.ufjf.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CadastroEstudoActivity extends AppCompatActivity {

    private EditText edtTempoGasto;
    private Double pontuacao;
    private Double tempo;
    private Button btnCadastrarEstudo;

    private Spinner listaEstudos;

    private String estudoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_estudo);

        edtTempoGasto = (EditText)findViewById(R.id.edtTempoEstudo);
        btnCadastrarEstudo = (Button)findViewById(R.id.btnCadastrarEstudo);

        listaEstudos = (Spinner)findViewById(R.id.spinListaEstudos);

        ArrayAdapter adapterSpinner = ArrayAdapter.createFromResource(CadastroEstudoActivity.this, R.array.lista_estudo,android.R.layout.simple_spinner_item);
        listaEstudos.setAdapter(adapterSpinner);

        AdapterView.OnItemSelectedListener estudoEscolhida = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                estudoSelecionado = listaEstudos.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        listaEstudos.setOnItemSelectedListener(estudoEscolhida);

        btnCadastrarEstudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edtTempoGasto.getText().toString().isEmpty()) {
                    tempo = Double.parseDouble(edtTempoGasto.getText().toString());

                    switch (estudoSelecionado) {
                        case "":
                            Toast.makeText(CadastroEstudoActivity.this, "Precisa Preencher a Atividade Feita", Toast.LENGTH_SHORT).show();
                        case "Ler Livro":
                            pontuacao = tempo * 10;
                            break;
                        case "Assistir Aula":
                            pontuacao = (tempo * 10);
                            break;
                        case "Jogar":
                            pontuacao = (tempo * 7);
                            break;
                        case "Fazer Tarefa da Escola":
                            pontuacao = (tempo * 15);
                            break;
                        default:
                            Toast.makeText(CadastroEstudoActivity.this, "Estudo não cadastrada", Toast.LENGTH_SHORT).show();
                    }

                    //AtividadeFisicaContract.saveAtividade(new CadastroPessoalDbHelper(CadastroEstudoActivity.this).getWritableDatabase(),
                    //        estudoSelecionado, tempo, pontuacao);
                    setResult(Activity.RESULT_OK);
                    Toast.makeText(CadastroEstudoActivity.this, "Estudo. Você ganhou "+ pontuacao +" pontos.", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                    Toast.makeText(CadastroEstudoActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
