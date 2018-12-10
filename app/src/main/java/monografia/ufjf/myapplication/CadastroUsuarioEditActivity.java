package monografia.ufjf.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroUsuarioEditActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtIdade;
    private EditText edtSexo;
    private EditText edtAltura;
    private EditText edtPeso;
    private Button btnEditarUsuario;

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario_edit);

        edtNome = (EditText)findViewById(R.id.edtNomeUsuarioEditar);
        edtIdade = (EditText)findViewById(R.id.edtIdadeUsuarioEditar);
        edtSexo = (EditText)findViewById(R.id.edtSexoUsuarioEditar);
        edtAltura = (EditText)findViewById(R.id.edtAlturaUsuarioEditar);
        edtPeso = (EditText)findViewById(R.id.edtPesoUsuarioEditar);

        btnEditarUsuario = (Button)findViewById(R.id.btnUsuarioEditar);

        Bundle bundle = null;
        try
        {
            bundle = this.getIntent().getExtras();
            id = bundle.getInt("id", -1);
        }
        catch (Exception err)
        {
            id = -1;
        }
        if(id != -1) //é pra atualizar, preenche com os dados do participante
        {
            edtNome.setText(bundle.getString("nome"));
            edtIdade.setText(bundle.getString("idade"));
            edtSexo.setText(bundle.getString("sexo"));
            edtAltura.setText(bundle.getString("altura"));
            edtPeso.setText(bundle.getString("peso"));
            btnEditarUsuario.setText("Atualizar Usuário");
        }
        btnEditarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    if(validateEntry())
                    {
                        if(id != -1)
                        {
                            CadastroPessoalContract.updateUsuario(new CadastroPessoalDbHelper(CadastroUsuarioEditActivity.this).getWritableDatabase(), id,
                                    edtNome.getText().toString(), edtIdade.getText().toString(), edtSexo.getText().toString(), edtAltura.getText().toString(), edtPeso.getText().toString());
                            Intent i = new Intent();
                            i.putExtra("nome", edtNome.getText().toString());
                            i.putExtra("idade", edtIdade.getText().toString());
                            i.putExtra("sexo", edtSexo.getText().toString());
                            i.putExtra("altura", edtAltura.getText().toString());
                            i.putExtra("peso", edtPeso.getText().toString());
                            setResult(Activity.RESULT_OK, i);
                        }
                        else
                        {
                            CadastroPessoalContract.saveUsuario(new CadastroPessoalDbHelper(CadastroUsuarioEditActivity.this).getWritableDatabase(),
                                    edtNome.getText().toString(), edtIdade.getText().toString(), edtSexo.getText().toString(), edtAltura.getText().toString(), edtPeso.getText().toString());
                            setResult(Activity.RESULT_OK);
                        }

                        Toast.makeText(CadastroUsuarioEditActivity.this,"Participante salvo com sucesso", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                        Toast.makeText(CadastroUsuarioEditActivity.this,"Por favor preencha todos os campos", Toast.LENGTH_LONG).show();
                }
                catch(Exception er)
                {
                    Toast.makeText(CadastroUsuarioEditActivity.this,"Ocorreu um erro ao salvar", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    private boolean validateEntry()
    {
        return !(edtNome.getText().toString().isEmpty() || edtIdade.getText().toString().isEmpty() || edtSexo.getText().toString().isEmpty() ||
                edtAltura.getText().toString().isEmpty() || edtPeso.getText().toString().isEmpty());
    }
}
