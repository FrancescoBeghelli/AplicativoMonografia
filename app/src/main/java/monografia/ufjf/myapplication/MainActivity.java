package monografia.ufjf.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCadPessoal;
    private Button btnAtivFis;
    private Button btnAliment;
    private Button btnMetaObj;

    private SQLiteDatabase db;

    private RecyclerView lstUsuario;

    private static UsuarioAdapter usuarioAdapter;

    public static final int REQUEST_DETAILS_EVENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new CadastroPessoalDbHelper(MainActivity.this).getWritableDatabase();

        btnCadPessoal = (Button) findViewById(R.id.btnCadPessoal);
        btnAtivFis = (Button) findViewById(R.id.btnAtivFis);
        btnAliment = (Button) findViewById(R.id.btnAlimentacao);
        btnMetaObj = (Button) findViewById(R.id.btnMetaObj);

        lstUsuario = (RecyclerView)findViewById(R.id.rclViewUsuarioMain);
        handleUsuario();


        btnCadPessoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,CadastroPessoalActivity.class);
                startActivity(i);
            }
        });

        btnAtivFis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AtividadeActivity.class);
                startActivity(i);
            }
        });
        btnAliment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AlimentacaoActivity.class);
                startActivity(i);
            }
        });
        btnMetaObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MetaObjetivoActivity.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        /*if(requestCode == REQUEST_CREATE_PERSON && resultCode == Activity.RESULT_OK)
            handleParticipanteCad();
        else if(requestCode == REQUEST_CREATE_EVENT && resultCode == Activity.RESULT_OK )
            handleEventoCad();
        else if(requestCode == REQUEST_DETAILS_PERSON)
            handleParticipanteCad();
        else*/ if(requestCode == REQUEST_DETAILS_EVENT)
            handleUsuario();
    }

    private void handleUsuario() {
        usuarioAdapter = new UsuarioAdapter(CadastroPessoalContract.getCadastroPessoalCursor(db,null,null));
        usuarioAdapter.setOnUsuarioClickListener(new UsuarioAdapter.OnUsuarioClickListener() {
            @Override
            public void onUsuarioClick(View usuarioView, int itemId) {
                Intent i = new Intent(MainActivity.this, CadastroUsuarioDetailsActivity.class);
                i.putExtra("id", itemId);
                startActivityForResult(i, REQUEST_DETAILS_EVENT);
            }

        });
        usuarioAdapter.setOnUsuarioLongClickListener(new UsuarioAdapter.onUsuarioLongClickListener() {
            @Override
            public void onUsuarioLongClick(View usuarioView, int itemId) {
                //db.delete(InscricaoContract.Inscricao.TABLE_NAME, InscricaoContract.Inscricao.COLUMN_NAME_ID_EVENTO + " = ? ", new String[]{Integer.toString(itemId)});
                //db.delete(EventoContract.Evento.TABLE_NAME, EventoContract.Evento._ID + " = ? ", new String[]{Integer.toString(itemId)});
                Toast.makeText(MainActivity.this, "Evento removido com sucesso.", Toast.LENGTH_SHORT).show();

                usuarioAdapter.notifyItemRemoved(lstUsuario.getChildLayoutPosition(usuarioView));
                usuarioAdapter.setCursor(CadastroPessoalContract.getCadastroPessoalCursor(db, null, null));
            }
        });
        lstUsuario.setLayoutManager(new LinearLayoutManager(this));
        lstUsuario.swapAdapter(usuarioAdapter, false);
    }


}
