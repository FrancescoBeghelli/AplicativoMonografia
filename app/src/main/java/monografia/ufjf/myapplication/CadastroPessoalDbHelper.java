package monografia.ufjf.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CadastroPessoalDbHelper extends SQLiteOpenHelper {

    public final static int DATABASE_VERSION = 3;
    public final static String DATABASE_NAME = "CadastroPessoal.db";

    public CadastroPessoalDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CadastroPessoalContract.CadastroPessoal.CREATE_CADASTROPESSOAL);
        db.execSQL(AtividadeFisicaContract.Atividade.CREATE_ATIVIDADE);

        inicializeUsuario(db);
        inicializeAtividade(db);
    }

    private void inicializeUsuario(SQLiteDatabase db){
        CadastroPessoalContract.saveUsuario(db,"João das Couves","10","Masculino", "140","30");
    }

    private void inicializeAtividade(SQLiteDatabase db){
        AtividadeFisicaContract.saveAtividade(db,"Corrida","10","2", "30");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CadastroPessoalContract.CadastroPessoal.DROP_CADASTROPESSOAL);
        db.execSQL(AtividadeFisicaContract.Atividade.DROP_CREATE_ATIVIDADE);

        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db,oldVersion,newVersion);
    }

}
