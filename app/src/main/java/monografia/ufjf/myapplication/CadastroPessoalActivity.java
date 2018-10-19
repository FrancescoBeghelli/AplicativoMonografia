package monografia.ufjf.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroPessoalActivity extends AppCompatActivity {

    private Button btnCadastroPessoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoal);

        btnCadastroPessoal = (Button) findViewById(R.id.btnCadastroPessoal);

        btnCadastroPessoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                finish();
            }
        });
    }
}
