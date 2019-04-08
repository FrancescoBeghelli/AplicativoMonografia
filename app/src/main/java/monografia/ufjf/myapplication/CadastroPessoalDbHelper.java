package monografia.ufjf.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CadastroPessoalDbHelper extends SQLiteOpenHelper {

    public final static int DATABASE_VERSION = 7;
    public final static String DATABASE_NAME = "CadastroPessoal.db";

    public CadastroPessoalDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CadastroPessoalContract.CadastroPessoal.CREATE_CADASTROPESSOAL);
        db.execSQL(AtividadeFisicaContract.Atividade.CREATE_ATIVIDADE);
        db.execSQL(EstudoContract.Estudo.CREATE_ESTUDO);
        db.execSQL(AlimentacaoContract.Alimentacao.CREATE_ALIMENTACAO);

        inicializeUsuario(db);
        inicializeAtividade(db);
    }

    private void inicializeUsuario(SQLiteDatabase db){
        CadastroPessoalContract.saveUsuario(db,"João das Couves","10","Masculino", "140","30");
    }

    private void inicializeAtividade(SQLiteDatabase db){
        AtividadeFisicaContract.saveAtividade(db,"Corrida",10.00,2.00, 30.00);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CadastroPessoalContract.CadastroPessoal.DROP_CADASTROPESSOAL);
        db.execSQL(AtividadeFisicaContract.Atividade.DROP_CREATE_ATIVIDADE);
        db.execSQL(EstudoContract.Estudo.DROP_CREATE_ESTUDO);
        db.execSQL(AlimentacaoContract.Alimentacao.DROP_CREATE_ALIMENTACAO);

        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db,oldVersion,newVersion);
    }

}
