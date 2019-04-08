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
    private Spinner listaDiaDaSemana;
    private Spinner listaSobremesa;

    private Double pontuacao;

    private String alimentacaoSelecionada;
    private Double alimentacao;
    private String bebidaSelecionada;
    private Double bebida;
    private String quantidadeSelecionada;
    private Double quantidade;
    private String diaSelecionado;
    private Double dia;
    private String sobremesaSelecionada;
    private Double sobremesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_alimentacao);

        btnCadastrarAlimentacao = (Button)findViewById(R.id.btnCadastrarAlimentacao);

        listaAlimentacao = (Spinner)findViewById(R.id.spinListaAlimentacao);
        listaBebida = (Spinner)findViewById(R.id.spinListaBebida);
        listaQuantidade = (Spinner)findViewById(R.id.spinListaQuant);
        listaDiaDaSemana = (Spinner)findViewById(R.id.spinListaDiaSemana);
        listaSobremesa = (Spinner)findViewById(R.id.spinListaSobremesa);

        ArrayAdapter adapterSpinnerAlim = ArrayAdapter.createFromResource(CadastroAlimentacaoActivity.this, R.array.lista_alimentacao,android.R.layout.simple_spinner_item);
        listaAlimentacao.setAdapter(adapterSpinnerAlim);
        ArrayAdapter adapterSpinnerBeb = ArrayAdapter.createFromResource(CadastroAlimentacaoActivity.this, R.array.lista_bebida,android.R.layout.simple_spinner_item);
        listaBebida.setAdapter(adapterSpinnerBeb);
        ArrayAdapter adapterSpinnerQtd = ArrayAdapter.createFromResource(CadastroAlimentacaoActivity.this, R.array.lista_quantidade,android.R.layout.simple_spinner_item);
        listaQuantidade.setAdapter(adapterSpinnerQtd);
        ArrayAdapter adapterSpinnerDiaSem = ArrayAdapter.createFromResource(CadastroAlimentacaoActivity.this, R.array.lista_diasdasemana,android.R.layout.simple_spinner_item);
        listaDiaDaSemana.setAdapter(adapterSpinnerDiaSem);
        ArrayAdapter adapterSpinnerSobremesa = ArrayAdapter.createFromResource(CadastroAlimentacaoActivity.this, R.array.lista_sobremesa,android.R.layout.simple_spinner_item);
        listaSobremesa.setAdapter(adapterSpinnerSobremesa);

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

        AdapterView.OnItemSelectedListener diaEscolhido = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                diaSelecionado = listaDiaDaSemana.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        listaDiaDaSemana.setOnItemSelectedListener(diaEscolhido);

        AdapterView.OnItemSelectedListener sobremesaEscolhida = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sobremesaSelecionada = listaSobremesa.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        listaSobremesa.setOnItemSelectedListener(sobremesaEscolhida);

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
                        bebida = -25.0;
                        break;
                    case "Leite":
                        bebida = 50.0;
                        break;
                    default:
                        Toast.makeText(CadastroAlimentacaoActivity.this, "Bebida não cadastrada", Toast.LENGTH_SHORT).show();
                }

                switch (quantidadeSelecionada) {
                    case "Pouco":
                        quantidade = 1.0;
                        break;
                    case "Certa":
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

                if(diaSelecionado=="Domingo" || diaSelecionado=="Sábado"){
                    switch (sobremesaSelecionada) {
                        case "Nenhuma":
                            sobremesa = 25.0;
                            break;
                        case "Fruta":
                            sobremesa = 40.0;
                            break;
                        case "Doce":
                            sobremesa = 10.0;
                            break;
                        case "Gelatina":
                            sobremesa = 25.0;
                            break;
                        case "Sorvete":
                            sobremesa = 10.0;
                            break;
                        case "Outra sobremesa":
                            sobremesa = 5.0;
                            break;
                        default:
                            Toast.makeText(CadastroAlimentacaoActivity.this, "Bebida não cadastrada", Toast.LENGTH_SHORT).show();
                    }

                }else{

                    switch (sobremesaSelecionada) {
                        case "Nenhuma":
                            sobremesa = 5.0;
                            break;
                        case "Fruta":
                            sobremesa = 8.0;
                            break;
                        case "Doce":
                            sobremesa = -20.0;
                            break;
                        case "Gelatina":
                            sobremesa = 5.0;
                            break;
                        case "Sorvete":
                            sobremesa = -20.0;
                            break;
                        case "Outra sobremesa":
                            sobremesa = -20.0;
                            break;
                        default:
                            Toast.makeText(CadastroAlimentacaoActivity.this, "Bebida não cadastrada", Toast.LENGTH_SHORT).show();
                    }

                }

                pontuacao = (bebida+alimentacao+sobremesa)*quantidade;
                //AtividadeFisicaContract.saveAtividade(new CadastroPessoalDbHelper(CadastroAlimentacaoActivity.this).getWritableDatabase(),
                //            alimentacaoSelecionada,bebidaSelecionada,quantidadeSelecionada, pontuacao);
                    setResult(Activity.RESULT_OK);
                    Toast.makeText(CadastroAlimentacaoActivity.this, "Alimentação cadastrada. Você ganhou "+ pontuacao +" pontos.", Toast.LENGTH_SHORT).show();
                    finish();
                }
        });

    }
}
