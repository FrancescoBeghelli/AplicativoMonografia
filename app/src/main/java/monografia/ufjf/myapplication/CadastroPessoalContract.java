package monografia.ufjf.myapplication;

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
                + CadastroPessoal.COLUMN_NAME_IDADE + " INTEGER, "
                + CadastroPessoal.COLUMN_NAME_SEXO + " TEXT, "
                + CadastroPessoal.COLUMN_NAME_ALTURA + " INTEGER "
                + CadastroPessoal.COLUMN_NAME_PESO + " INTEGER "
                +")";
        public static final String DROP_CADASTROPESSOAL = "DROP TABLE IF EXISTS " + CadastroPessoal.TABLE_NAME;
    }

}
