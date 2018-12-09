package monografia.ufjf.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    private TextView txtPonto;

    private Button btnEdtUsuario;
    private int id;

    private SQLiteDatabase db;
    private AtividadeAdapter adapter;
    private RecyclerView lstAtividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario_details);

        db = new CadastroPessoalDbHelper(this).getWritableDatabase();

        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");

        txtNome = (TextView)findViewById(R.id.txtNomeUsuarioDetalhes);
        txtIdade = (TextView)findViewById(R.id.txtIdadeUsuarioDetalhes);
        txtSexo = (TextView)findViewById(R.id.txtSexoUsuarioDetalhes);
        txtAltura = (TextView)findViewById(R.id.txtAlturaUsuarioDetalhes);
        txtPeso = (TextView)findViewById(R.id.txtPesoUsuarioDetalhes);
        txtPonto = (TextView) findViewById(R.id.txtPontoUsuarioDetalhes);
        btnEdtUsuario = (Button)findViewById(R.id.btnEditarUsuarioDetalhes);

        Cursor cursor = CadastroPessoalContract.getCadastroPessoalCursor(db,CadastroPessoalContract.CadastroPessoal._ID+" = ?",new String[] {Integer.toString(id)});
        int idxNome = cursor.getColumnIndexOrThrow(CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_NOME);
        int idxIdade = cursor.getColumnIndexOrThrow(CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_IDADE);
        int idxSexo = cursor.getColumnIndexOrThrow(CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_SEXO);
        int idxAltura = cursor.getColumnIndexOrThrow(CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_ALTURA);
        int idxPeso = cursor.getColumnIndexOrThrow(CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_PESO);
        cursor.moveToNext();
        txtNome.setText(cursor.getString(idxNome));
        txtIdade.setText(cursor.getString(idxIdade));
        txtSexo.setText(cursor.getString(idxSexo));
        txtAltura.setText(cursor.getString(idxAltura));
        txtPeso.setText(cursor.getString(idxPeso));

        txtPonto.setText(String.format("%.2f", AtividadeFisicaContract.getSumAtividade(db)));

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

        lstAtividade = (RecyclerView)findViewById(R.id.lstAtividadeUsuario);
        handleAtividade();
    }

    private void handleAtividade() {
        adapter = new AtividadeAdapter(AtividadeFisicaContract.getAtividadeCursor(db, null, null));
        lstAtividade.setLayoutManager(new LinearLayoutManager(this));
        lstAtividade.swapAdapter(adapter, false);
    }
}
