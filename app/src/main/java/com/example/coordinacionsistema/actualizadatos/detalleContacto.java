package com.example.coordinacionsistema.actualizadatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class detalleContacto extends AppCompatActivity {
    String txtNombre ;
    String txtEmail ;
    String txtTelefono ;
    String txtDescripcion ;
    String txtcalendar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);



        Bundle recibeparmetros = getIntent().getExtras();
          txtNombre= recibeparmetros.getString("txtNombre");
          txtEmail= recibeparmetros.getString("txtEmail");
          txtTelefono= recibeparmetros.getString("txtTelefono");
          txtDescripcion= recibeparmetros.getString("txtDescripcion");
          txtcalendar= recibeparmetros.getString("txtcalendar");

        TextView txtNombrePut = findViewById(R.id.txtNombrePut) ;
        TextView txtcalendarPut = findViewById(R.id.txtCalendarPut) ;
        TextView txtEmailPut = findViewById(R.id.txtEmailPut) ;
        TextView txtTelefonoPut = findViewById(R.id.txtTelefonoPut) ;
        TextView txtDescripcionPut = findViewById(R.id.txtDescripcionPut) ;

        txtNombrePut.setText(txtNombre);
        txtcalendarPut.setText("Fecha nacimiento: "+txtcalendar);
        txtTelefonoPut.setText("Telefono: "+txtTelefono);
        txtEmailPut.setText("Email: "+txtEmail);
        txtDescripcionPut.setText("Descripcion: "+txtDescripcion);




    }

    @Override

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            Intent actividad = new Intent(detalleContacto.this,MainActivity.class);
            startActivity(actividad);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }



    public void Editar(View v){

                Intent actividad = new Intent(detalleContacto.this,MainActivity.class);
                actividad.putExtra("txtNombre", txtNombre);
                actividad.putExtra("txtEmail", txtEmail  );
                actividad.putExtra("txtTelefono", txtTelefono );
                actividad.putExtra("txtDescripcion", txtDescripcion  );
                actividad.putExtra("txtcalendar", txtcalendar );
                startActivity(actividad);
                finish();



    }
}
