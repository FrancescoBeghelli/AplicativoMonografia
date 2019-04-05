package monografia.ufjf.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class CadastroAlimentacaoActivity extends AppCompatActivity {

    private Button btnCadastrarAlimentacao;

    private Spinner listaAlimentacao;
    private Spinner listaBebida;
    private Spinner listaQuantidade;

    private Double pontuacao;

    private String alimentacaoSelecionada;
    private Double alimentacao;
    private String bebidaSelecionada;
    private Double bebida;
    private String quantidadeSelecionada;
    private Double quantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_alimentacao);

        btnCadastrarAlimentacao = (Button)findViewById(R.id.btnCadastrarAlimentacao);

        listaAlimentacao = (Spinner)findViewById(R.id.spinListaAlimentacao);
        listaBebida = (Spinner)findViewById(R.id.spinListaBebida);
        listaQuantidade = (Spinner)findViewById(R.id.spinListaQuant);

        ArrayAdapter adapterSpinnerAlim = ArrayAdapter.createFromResource(CadastroAlimentacaoActivity.this, R.array.lista_alimentacao,android.R.layout.simple_spinner_item);
        listaAlimentacao.setAdapter(adapterSpinnerAlim);
        ArrayAdapter adapterSpinnerBeb = ArrayAdapter.createFromResource(CadastroAlimentacaoActivity.this, R.array.lista_bebida,android.R.layout.simple_spinner_item);
        listaBebida.setAdapter(adapterSpinnerBeb);
        ArrayAdapter adapterSpinnerQtd = ArrayAdapter.createFromResource(CadastroAlimentacaoActivity.this, R.array.lista_quantidade,android.R.layout.simple_spinner_item);
        listaQuantidade.setAdapter(adapterSpinnerQtd);

        AdapterView.OnItemSelectedListener alimentacaoEscolhida = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                alimentacaoSelecionada = listaAlimentacao.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        listaAlimentacao.setOnItemSelectedListener(alimentacaoEscolhida);

        AdapterView.OnItemSelectedListener bebidaEscolhida = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bebidaSelecionada = listaBebida.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        listaBebida.setOnItemSelectedListener(bebidaEscolhida);

        AdapterView.OnItemSelectedListener quantidadeEscolhida = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                quantidadeSelecionada = listaQuantidade.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        listaQuantidade.setOnItemSelectedListener(quantidadeEscolhida);

        btnCadastrarAlimentacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (alimentacaoSelecionada) {
                    case "Café da Manhã":
                        alimentacao = 100.0;
                        break;
                    case "Almoço":
                        alimentacao = 200.0;
                        break;
                    case "Café da Tarde":
                        alimentacao = 100.0;
                        break;
                    case "Jantar":
                        alimentacao = 200.0;
                        break;
                    case "Lanche":
                        alimentacao = 50.0;
                        break;
                    default:
                        Toast.makeText(CadastroAlimentacaoActivity.this, "Alimentação não cadastrada", Toast.LENGTH_SHORT).show();
                }

                switch (bebidaSelecionada) {
                    case "Nenhuma":
                        bebida = 25.0;
                        break;
                    case "Água":
                        bebida = 50.0;
                        break;
                    case "Suco":
                        bebida = 75.0;
                        break;
                    case "Refrigerante":
                        bebida = -50.0;
                        break;
                    case "Café com Leite":
                        bebida = 50.0;
                        break;
                    case "Achocolatado":
                        bebida = 25.0;
                        break;
                    case "Leite":
                        bebida = 50.0;
                        break;
                    default:
                        Toast.makeText(CadastroAlimentacaoActivity.this, "Bebida não cadastrada", Toast.LENGTH_SHORT).show();
                }

                switch (quantidadeSelecionada) {
                    case "Pouco":
                        quantidade = 0.75;
                        break;
                    case "Médio":
                        quantidade = 2.0;
                        break;
                    case "Bastante":
                        quantidade = 0.75;
                        break;
                    case "Exagerado":
                        quantidade = 0.25;
                        break;
                    default:
                        Toast.makeText(CadastroAlimentacaoActivity.this, "Bebida não cadastrada", Toast.LENGTH_SHORT).show();
                }

                pontuacao = (bebida+alimentacao)*quantidade;

                //AtividadeFisicaContract.saveAtividade(new CadastroPessoalDbHelper(CadastroAlimentacaoActivity.this).getWritableDatabase(),
                //            alimentacaoSelecionada,bebidaSelecionada,quantidadeSelecionada, pontuacao);
                    setResult(Activity.RESULT_OK);
                    Toast.makeText(CadastroAlimentacaoActivity.this, "Alimentação cadastrada. Você ganhou "+ pontuacao +" pontos.", Toast.LENGTH_SHORT).show();
                    finish();
                }
        });

    }
}
