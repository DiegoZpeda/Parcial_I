package com.ugb.parcial_1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DatabaseErrorHandler;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Button btn;

    TabHost tab;
    TextView temp;
    Spinner spn;
    conversores miConversor = new conversores();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab = findViewById(R.id.tabConvertir);
        tab.setup();
        tab.addTab(tab.newTabSpec("conversor").setContent(R.id.tabConvertir).setIndicator("Conversor"));

        btn = findViewById(R.id.btnConvertir);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = (TextView) findViewById(R.id.txtcantidad);
                double cantidad = Double.parseDouble(temp.getText().toString());

                spn = findViewById(R.id.spnde);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spna);
                int a = spn.getSelectedItemPosition();

                temp = findViewById(R.id.lblrespuesta);
                temp.setText("Respuesta: "+ miConversor.convertir(0, de, a, cantidad));
            }
        });
    }
}
class conversores{
    double[][] valores = {
            {0.698896, 1e-6, 628.86, 0.70, 10000, 0.000247105,},

    };
    public double convertir(int opcion, int de, int a, double cantidad){
        return valores[opcion][a] / valores[opcion][de] * cantidad;
    }
}