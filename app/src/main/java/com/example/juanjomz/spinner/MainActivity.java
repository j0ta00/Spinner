package com.example.juanjomz.spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);
        List<Equipo> listaEquipos=new ArrayList<Equipo>();
        llenarListaEquipos(listaEquipos);
        Button btn=findViewById(R.id.btnNombres);
        spinner.setAdapter(new spinnerAdapter(this,listaEquipos));
        TextView txtNombreEquipos=findViewById(R.id.txtNombreEquipo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNombreEquipos.setText(spinner.getSelectedItem().toString());
            }
        });
    }
    private void llenarListaEquipos(List<Equipo> listaEquipos){
        listaEquipos.add(new Equipo("Clippers",R.drawable.clippers));
        listaEquipos.add(new Equipo("Bulls",R.drawable.bulls));
        listaEquipos.add(new Equipo("Celtics",R.drawable.celtics));
        listaEquipos.add(new Equipo("GoldenState", R.drawable.goldenstate));
        listaEquipos.add(new Equipo("Knicks",R.drawable.knicks));
        listaEquipos.add(new Equipo("Lakers",R.drawable.lakers));
        listaEquipos.add(new Equipo("Nets",R.drawable.nets));
    }

    public class spinnerAdapter extends BaseAdapter {
    private List<Equipo> listaEquiposAdapter;
    Context context;

        public spinnerAdapter(@NonNull Context context, @NonNull List<Equipo> listaEquiposAdapter) {
            this.listaEquiposAdapter=listaEquiposAdapter;

        }

        @Override
        public int getCount() {
            return listaEquiposAdapter.size();
        }

        @Override
        public Object getItem(int i) {
            return listaEquiposAdapter.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View Convertview, ViewGroup parent) {
            ImageView img=null;
            TextView txt=null;
            Holder holder=null;
            View vista=Convertview;
            LayoutInflater inflater =null;
            if(vista==null){
                inflater = getLayoutInflater();
                vista=inflater.inflate(R.layout.spinner_row,parent,false);
                img=vista.findViewById(R.id.fotoEquipo);
                txt=vista.findViewById(R.id.nombreEquipo);
                holder=new Holder(img,txt);
                vista.setTag(holder);
            }else{
                holder=(Holder) vista.getTag();
            }
            holder.getImgFotoEquipo().setImageResource(listaEquiposAdapter.get(i).getIdFoto());
            holder.getTxtNombreEquipo().setText(listaEquiposAdapter.get(i).getNombre());
            return vista;
        }


    }
    public class Holder{
        ImageView imgFotoEquipo;
        TextView txtNombreEquipo;

        public Holder(ImageView imgFotoEquipo, TextView txtNombreEquipo) {
            this.imgFotoEquipo = imgFotoEquipo;
            this.txtNombreEquipo = txtNombreEquipo;
        }

        public ImageView getImgFotoEquipo() {
            return imgFotoEquipo;
        }

        public void setImgFotoEquipo(ImageView imgFotoEquipo) {
            this.imgFotoEquipo = imgFotoEquipo;
        }

        public TextView getTxtNombreEquipo() {
            return txtNombreEquipo;
        }

        public void setTxtNombreEquipo(TextView txtNombreEquipo) {
            this.txtNombreEquipo = txtNombreEquipo;
        }
    }
}