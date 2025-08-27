package com.example.mi_contador;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnHilo;
    TextView tvTextoEjemplo, tvHiloAuxiliar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHilo = findViewById(R.id.btnHilo);
        tvTextoEjemplo = findViewById(R.id.tvTextoEjemplo);
        tvHiloAuxiliar = findViewById(R.id.tvHiloAuxiliar);

        btnHilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 10; i >= 0; i--){
                            int dec = i;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvTextoEjemplo.setText("Contador: " + dec);
                                }
                            });

                            try {
                                Thread.sleep(1000); //se espera 1 segundo
                            }
                            catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvTextoEjemplo.setText("Proceso de hilo finalizado");
                            }
                        });
                    }
                });
                thread.start();
            }
        });
    }
}