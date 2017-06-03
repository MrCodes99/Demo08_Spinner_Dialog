package com.example.suite508.demo08;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final View.OnClickListener btMainOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Cibertec");
            builder.setMessage("Hola dialog");
            //builder.setPositiveButton("Positivo",null); //SIN EVENTO
            //builder.setNegativeButton("Negativo",null); //SIN EVENTO
            //builder.setNeutralButton("Neutro",null); //SIN EVENTO

            builder.setPositiveButton("Positivo", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int witch) {
                    Toast.makeText(MainActivity.this, "Tocó positivo", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Negativo", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int witch) {
                    Toast.makeText(MainActivity.this, "Tocó negativo", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int witch) {
                    Toast.makeText(MainActivity.this, "Tocó neutro", Toast.LENGTH_SHORT).show();
                }
            });

            builder.show();
        }
    };

    private final AdapterView.OnItemSelectedListener spMainOnItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
            Toast.makeText(MainActivity.this, "Elemento seleccionado en la posicion " + position, Toast.LENGTH_SHORT).show();

            Persona persona = (Persona) parent.getSelectedItem();
            tvMain.setText(persona.getNombre() + " " + persona.getApellido());

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private SPMainAdapter mSPMainAdapter;
    private Spinner spMain;
    private TextView tvMain;
    private Button btMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spMain = (Spinner) findViewById(R.id.spMain);
        tvMain = (TextView) findViewById(R.id.tvMain);
        btMain = (Button) findViewById(R.id.btMain);

        spMain.setOnItemSelectedListener(spMainOnItemSelectedListener);
        btMain.setOnClickListener(btMainOnClickListener);

        mSPMainAdapter = new SPMainAdapter(MainActivity.this);
        spMain.setAdapter(mSPMainAdapter);



        Persona persona;
        List<Persona> lstPersona = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            persona = new Persona();
            persona.setId(java.util.UUID.randomUUID().toString());
            persona.setNombre(java.util.UUID.randomUUID().toString().replace("-","").substring(0,6));
            persona.setApellido(java.util.UUID.randomUUID().toString().replace("-","").substring(7,13));

            lstPersona.add(persona);
        }

        mSPMainAdapter.addAll(lstPersona);
    }
}
