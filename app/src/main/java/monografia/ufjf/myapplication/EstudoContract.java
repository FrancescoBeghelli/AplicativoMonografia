package monografia.ufjf.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class EstudoContract {

    public final class Estudo implements BaseColumns
    {
        public static final String TABLE_NAME = "Atividade";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_TEMPO = "tempo";
        public static final String COLUMN_NAME_PONTO = "ponto";
        public static final String CREATE_ESTUDO = "CREATE TABLE " + EstudoContract.Estudo.TABLE_NAME + " ("
                + EstudoContract.Estudo._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EstudoContract.Estudo.COLUMN_NAME_NOME + " TEXT, "
                + EstudoContract.Estudo.COLUMN_NAME_TEMPO + " REAL, "
                + EstudoContract.Estudo.COLUMN_NAME_PONTO + " REAL "
                +")";
        public static final String DROP_CREATE_ESTUDO = "DROP TABLE IF EXISTS " + EstudoContract.Estudo.TABLE_NAME;
    }


    public static void saveEstudo(SQLiteDatabase db, String nome, double tempo, double ponto) {
        db.insert(EstudoContract.Estudo.TABLE_NAME,null,
                createContentValue(nome, tempo, ponto));
    }

    public static void updateEstudo(SQLiteDatabase db, int id, String nome, double tempo, double ponto) {
        db.update(EstudoContract.Estudo.TABLE_NAME,createContentValue(nome, tempo, ponto),
                EstudoContract.Estudo._ID + " = ?", new String[] {Integer.toString(id)});
    }

    private static ContentValues createContentValue(String nome, double tempo, double ponto)
    {
        ContentValues cv = new ContentValues();
        cv.put(EstudoContract.Estudo.COLUMN_NAME_NOME, nome);
        cv.put(EstudoContract.Estudo.COLUMN_NAME_TEMPO, tempo);
        cv.put(EstudoContract.Estudo.COLUMN_NAME_PONTO, ponto);
        return cv;
    }

    public static Cursor getEstudoCursor(SQLiteDatabase db, String selection, String[] selectionArgs)
    {
        return db.query(EstudoContract.Estudo.TABLE_NAME, new String[] {EstudoContract.Estudo._ID, EstudoContract.Estudo.COLUMN_NAME_NOME,
                EstudoContract.Estudo.COLUMN_NAME_TEMPO, EstudoContract.Estudo.COLUMN_NAME_PONTO}, selection, selectionArgs,null,null,null,null);
    }

    public static double getSumEstudo(SQLiteDatabase db)
    {
        Cursor cursor = db.rawQuery("SELECT SUM(" + EstudoContract.Estudo.COLUMN_NAME_PONTO + ") FROM " + EstudoContract.Estudo.TABLE_NAME, null);
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            return cursor.getDouble(0);
        }
        else
            return 0;
    }
}