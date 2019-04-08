package monografia.ufjf.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class AlimentacaoContract {

    public final class Alimentacao implements BaseColumns
    {
        public static final String TABLE_NAME = "Atividade";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_BEBIDA = "bebida";
        public static final String COLUMN_NAME_QUANTIDADE = "quantidade";
        public static final String COLUMN_NAME_DIADASEMANA = "diadasemana";
        public static final String COLUMN_NAME_SOBREMESA = "sobremesa";
        public static final String COLUMN_NAME_PONTO = "ponto";
        public static final String CREATE_ALIMENTACAO = "CREATE TABLE " + AlimentacaoContract.Alimentacao.TABLE_NAME + " ("
                + AlimentacaoContract.Alimentacao._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AlimentacaoContract.Alimentacao.COLUMN_NAME_NOME + " TEXT, "
                + AlimentacaoContract.Alimentacao.COLUMN_NAME_BEBIDA + " TEXT, "
                + AlimentacaoContract.Alimentacao.COLUMN_NAME_QUANTIDADE + " TEXT, "
                + AlimentacaoContract.Alimentacao.COLUMN_NAME_DIADASEMANA + " TEXT, "
                + AlimentacaoContract.Alimentacao.COLUMN_NAME_SOBREMESA + " TEXT, "
                + AlimentacaoContract.Alimentacao.COLUMN_NAME_PONTO + " REAL "
                +")";
        public static final String DROP_CREATE_ALIMENTACAO = "DROP TABLE IF EXISTS " + AlimentacaoContract.Alimentacao.TABLE_NAME;
    }


    public static void saveAlimentacao(SQLiteDatabase db, String nome, String bebida, String quantidade, String diadasemana, String sobremesa, double ponto) {
        db.insert(AlimentacaoContract.Alimentacao.TABLE_NAME,null,
                createContentValue(nome, bebida, quantidade, diadasemana, sobremesa, ponto));
    }

    public static void updateAlimentacao(SQLiteDatabase db, int id, String nome, String bebida, String quantidade, String diadasemana, String sobremesa, double ponto) {
        db.update(AlimentacaoContract.Alimentacao.TABLE_NAME,createContentValue(nome, bebida, quantidade, diadasemana, sobremesa, ponto),
                AlimentacaoContract.Alimentacao._ID + " = ?", new String[] {Integer.toString(id)});
    }

    private static ContentValues createContentValue(String nome, String bebida, String quantidade, String diadasemana, String sobremesa, double ponto)
    {
        ContentValues cv = new ContentValues();
        cv.put(AlimentacaoContract.Alimentacao.COLUMN_NAME_NOME, nome);
        cv.put(AlimentacaoContract.Alimentacao.COLUMN_NAME_BEBIDA , bebida);
        cv.put(AlimentacaoContract.Alimentacao.COLUMN_NAME_QUANTIDADE , quantidade);
        cv.put(AlimentacaoContract.Alimentacao.COLUMN_NAME_DIADASEMANA , diadasemana);
        cv.put(AlimentacaoContract.Alimentacao.COLUMN_NAME_SOBREMESA , sobremesa);
        cv.put(AlimentacaoContract.Alimentacao.COLUMN_NAME_PONTO, ponto);
        return cv;
    }

    public static Cursor getAlimentacaoCursor(SQLiteDatabase db, String selection, String[] selectionArgs)
    {
        return db.query(AlimentacaoContract.Alimentacao.TABLE_NAME, new String[] {AlimentacaoContract.Alimentacao._ID, AlimentacaoContract.Alimentacao.COLUMN_NAME_NOME,
                AlimentacaoContract.Alimentacao.COLUMN_NAME_BEBIDA, AlimentacaoContract.Alimentacao.COLUMN_NAME_QUANTIDADE, AlimentacaoContract.Alimentacao.COLUMN_NAME_DIADASEMANA,
                AlimentacaoContract.Alimentacao.COLUMN_NAME_SOBREMESA, AlimentacaoContract.Alimentacao.COLUMN_NAME_PONTO}, selection, selectionArgs,null,null,null,null);
    }

    public static double getSumAlimentacao(SQLiteDatabase db)
    {
        Cursor cursor = db.rawQuery("SELECT SUM(" + AlimentacaoContract.Alimentacao.COLUMN_NAME_PONTO + ") FROM " + AlimentacaoContract.Alimentacao.TABLE_NAME, null);
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getDouble(0);
        }
        else
            return 0;
    }
}
