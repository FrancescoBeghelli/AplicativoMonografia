package monografia.ufjf.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroPessoalActivity extends AppCompatActivity {

    private Button btnCadastroPessoal;
    private EditText edtTxtNomeCad;
    private EditText edtTxtIdadeCad;
    private EditText edtTxtSexoCad;
    private EditText edtTxtAltCad;
    private EditText edtTxtPesoCad;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
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

                if(validate())
                {
                    CadastroPessoalContract.saveUsuario(new CadastroPessoalDbHelper(CadastroPessoalActivity.this).getWritableDatabase(),
                            edtTxtNomeCad.getText().toString(), edtTxtIdadeCad.getText().toString(), edtTxtSexoCad.getText().toString(),
                            edtTxtAltCad.getText().toString(), edtTxtPesoCad.getText().toString());

                    Toast.makeText(CadastroPessoalActivity.this,"Pessoa cadastrada com sucesso", Toast.LENGTH_SHORT).show();
                    setResult(Activity.RESULT_OK);
                    finish();
                }
                else
                    Toast.makeText(CadastroPessoalActivity.this,"Por favor preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validate()
    {
        return !(edtTxtAltCad.getText().toString().isEmpty() || edtTxtNomeCad.getText().toString().isEmpty()
                || edtTxtIdadeCad.getText().toString().isEmpty() || edtTxtPesoCad.getText().toString().isEmpty()
                || edtTxtSexoCad.getText().toString().isEmpty());
    }
}
