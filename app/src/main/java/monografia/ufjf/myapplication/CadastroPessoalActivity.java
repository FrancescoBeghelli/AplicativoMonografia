package monografia.ufjf.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroPessoalActivity extends AppCompatActivity {

    private Button btnCadastroPessoal;
    private EditText edtTxtNomeCad;
    private EditText edtTxtIdadeCad;
    private EditText edtTxtSexoCad;
    private EditText edtTxtAltCad;
    private EditText edtTxtPesoCad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoal);

        btnCadastroPessoal = (Button) findViewById(R.id.btnCadastroPessoal);
        edtTxtNomeCad = (EditText) findViewById(R.id.edtTxtNomeCad);
        edtTxtIdadeCad = (EditText) findViewById(R.id.edtTxtIdadeCad);
        edtTxtSexoCad = (EditText) findViewById(R.id.edtTxtSexoCad);
        edtTxtAltCad = (EditText) findViewById(R.id.edtTxtAltCad);
        edtTxtPesoCad = (EditText) findViewById(R.id.edtTxtPesoCad);

        btnCadastroPessoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                finish();
            }
        });
    }
}
