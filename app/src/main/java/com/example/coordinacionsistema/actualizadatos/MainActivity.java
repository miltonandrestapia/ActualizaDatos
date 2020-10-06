package com.example.coordinacionsistema.actualizadatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    String txtNombre ;
    String txtEmail ;
    String txtTelefono ;
    String txtDescripcion ;
    String txtcalendarstr ;
    CalendarView txtcalendar ;
    String fecha="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtcalendar =  (CalendarView)  findViewById(R.id.txtCalendar) ;
        txtcalendar.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                month=month+1;
                String mes=month+"";
                if (month<10){
                    mes="0"+month;
                }
                String dia=dayOfMonth+"";
                if (dayOfMonth<10){
                    dia="0"+dayOfMonth;
                }
                fecha=""+dia+"/"+ mes+"/"+  year;
            }
        });



        if(getIntent().hasExtra("txtNombre")){


           Bundle recibeparmetros = getIntent().getExtras();
            txtNombre= recibeparmetros.getString("txtNombre");
            txtEmail= recibeparmetros.getString("txtEmail");
            txtTelefono= recibeparmetros.getString("txtTelefono");
            txtDescripcion= recibeparmetros.getString("txtDescripcion");
            txtcalendarstr= recibeparmetros.getString("txtcalendar");

            TextView txtNombrePut = findViewById(R.id.txtNombre) ;
            TextView txtEmailPut = findViewById(R.id.txtEmail) ;
            TextView txtTelefonoPut = findViewById(R.id.txtTelefono) ;
            TextView txtDescripcionPut = findViewById(R.id.txtDescripcion) ;

            txtNombrePut.setText(txtNombre);
            txtTelefonoPut.setText( txtTelefono);
            txtEmailPut.setText( txtEmail);
            txtDescripcionPut.setText( txtDescripcion);

            fecha=txtcalendarstr;
            String parts[] = txtcalendarstr.split("/");

            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, (month-1));
            calendar.set(Calendar.DAY_OF_MONTH, day);

            long milliTime = calendar.getTimeInMillis();
            txtcalendar.setDate(milliTime);

        }else{

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fecha = sdf.format(new Date(txtcalendar.getDate()));
        }





    }
    public void Siguiente(View v){


        TextView txtNombre = findViewById(R.id.txtNombre) ;
        CalendarView txtcalendar =  (CalendarView)  findViewById(R.id.txtCalendar) ;
        TextView txtEmail = findViewById(R.id.txtEmail) ;
        TextView txtTelefono = findViewById(R.id.txtTelefono) ;
        TextView txtDescripcion = findViewById(R.id.txtDescripcion) ;


        if (!txtNombre.getText().toString().equals("")){
        if (!txtTelefono.getText().toString().equals("")){
            Intent actividad = new Intent(MainActivity.this,detalleContacto.class);
            actividad.putExtra("txtNombre", txtNombre.getText().toString() );
            actividad.putExtra("txtEmail", txtEmail.getText().toString() );
            actividad.putExtra("txtTelefono", txtTelefono.getText().toString() );
            actividad.putExtra("txtDescripcion", txtDescripcion.getText().toString() );
            actividad.putExtra("txtcalendar", fecha );
            startActivity(actividad);
            finish();
        }else{
            Toast.makeText(MainActivity.this,"Escriba Telefono",Toast.LENGTH_SHORT).show();
        }
    }else{
        Toast.makeText(MainActivity.this,"Escriba Nombre",Toast.LENGTH_SHORT).show();
    }



    }
}
