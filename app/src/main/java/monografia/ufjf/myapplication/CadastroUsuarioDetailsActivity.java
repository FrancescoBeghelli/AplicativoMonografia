package monografia.ufjf.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CadastroUsuarioDetailsActivity extends AppCompatActivity {

    private static final int REQUEST_UPDATE_USUARIO = 1;

    private TextView txtNome;
    private TextView txtIdade;
    private TextView txtSexo;
    private TextView txtAltura;
    private TextView txtPeso;
    private Button btnEdtUsuario;
    private int id;

    private SQLiteDatabase db;
    private static UsuarioAdapter adapterUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario_details);

        db = new CadastroPessoalDbHelper(this).getWritableDatabase();

        txtNome = (TextView)findViewById(R.id.txtNomeUsuarioDetalhes);
        txtIdade = (TextView)findViewById(R.id.txtIdadeUsuarioDetalhes);
        txtSexo = (TextView)findViewById(R.id.txtSexoUsuarioDetalhes);
        txtAltura = (TextView)findViewById(R.id.txtAlturaUsuarioDetalhes);
        txtPeso = (TextView)findViewById(R.id.txtPesoUsuarioDetalhes);
        btnEdtUsuario = (Button)findViewById(R.id.btnEditarUsuarioDetalhes);

        btnEdtUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CadastroUsuarioDetailsActivity.this, CadastroUsuarioEditActivity.class);
                i.putExtra("id", id);
                i.putExtra("nome", txtNome.getText().toString());
                i.putExtra("idade", txtIdade.getText().toString());
                i.putExtra("sexo", txtSexo.getText().toString());
                i.putExtra("altura", txtAltura.getText().toString());
                i.putExtra("peso", txtPeso.getText().toString());
                startActivityForResult(i, REQUEST_UPDATE_USUARIO);
            }
        });



    }
}