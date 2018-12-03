package monografia.ufjf.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class CadastroPessoalContract {

    public final class CadastroPessoal implements BaseColumns
    {
        public static final String TABLE_NAME = "CadastroPessoal";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_IDADE = "idade";
        public static final String COLUMN_NAME_SEXO = "sexo";
        public static final String COLUMN_NAME_ALTURA = "altura";
        public static final String COLUMN_NAME_PESO = "peso";
        public static final String CREATE_CADASTROPESSOAL = "CREATE TABLE " + CadastroPessoal.TABLE_NAME + " ("
                + CadastroPessoal._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CadastroPessoal.COLUMN_NAME_NOME + " TEXT, "
                + CadastroPessoal.COLUMN_NAME_IDADE + " TEXT, "
                + CadastroPessoal.COLUMN_NAME_SEXO + " TEXT, "
                + CadastroPessoal.COLUMN_NAME_ALTURA + " TEXT, "
                + CadastroPessoal.COLUMN_NAME_PESO + " TEXT "
                +")";
        public static final String DROP_CADASTROPESSOAL = "DROP TABLE IF EXISTS " + CadastroPessoal.TABLE_NAME;
    }

    public static void saveUsuario(SQLiteDatabase db, String nome, String idade,
                                  String sexo, String altura, String peso) {
        db.insert(CadastroPessoalContract.CadastroPessoal.TABLE_NAME,null,
                createContentValue(nome, idade, sexo, altura, peso));
    }

    public static void updateUsuario(SQLiteDatabase db, int id, String nome, String idade,
                                    String sexo, String altura, String peso) {
        db.update(CadastroPessoalContract.CadastroPessoal.TABLE_NAME,createContentValue(nome, idade, sexo, altura, peso),
                CadastroPessoal._ID + " = ?", new String[] {Integer.toString(id)});
    }

    private static ContentValues createContentValue(String nome, String idade, String sexo, String altura, String peso)
    {
        ContentValues cv = new ContentValues();
        cv.put(CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_NOME, nome);
        cv.put(CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_IDADE, idade);
        cv.put(CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_SEXO, sexo);
        cv.put(CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_ALTURA, altura);
        cv.put(CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_PESO, peso);
        return cv;
    }
    public static Cursor getCadastroPessoalCursor(SQLiteDatabase db, String selection, String[] selectionArgs)
    {
        return db.query(CadastroPessoalContract.CadastroPessoal.TABLE_NAME, new String[] {CadastroPessoalContract.CadastroPessoal._ID, CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_NOME, CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_IDADE,
                CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_SEXO, CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_ALTURA, CadastroPessoalContract.CadastroPessoal.COLUMN_NAME_PESO }, selection, selectionArgs,null,null,null,null);
    }

}
