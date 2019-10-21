package sada.com.br.gasolinaetanol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //fonte http://www.calculoexato.net/calculadora-flex-gasolina-x-alcool/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              EditText etanol = findViewById(R.id.edtPrEtanol);
              //etanol.setText("2.85");
                if (TextUtils.isEmpty(etanol.getText().toString())) {
                    Toast.makeText(getBaseContext(),"PREÇO DO ETANOL EM BRANCO",Toast.LENGTH_SHORT).show();
                    return;
                }

                EditText gasolina = findViewById(R.id.edtPrGasolina);
                //gasolina.setText("3.55");
                if (TextUtils.isEmpty(gasolina.getText().toString())) {
                    Toast.makeText(getBaseContext(),"PREÇO DA GASOLINA EM BRANCO",Toast.LENGTH_SHORT).show();
                    return;
                }

                double precoEtanolInformado = Double.parseDouble(etanol.getText().toString()) ;
                double precoGasolinaInformado = Double.parseDouble(gasolina.getText().toString());
                double calculo = precoEtanolInformado / precoGasolinaInformado;

                TextView resultado = findViewById(R.id.txtResultado);
                if (calculo < 0.70) {
                    resultado.setText("SUGESTAO : ALCOOL");
                }else {
                    resultado.setText("SUGESTAO : GASOLINA");

                }

            }
        });



        //Novo Botao aqui

    }
}
