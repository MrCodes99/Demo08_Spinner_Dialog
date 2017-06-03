package com.example.suite508.demo08;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by suite508 on 03/06/2017.
 */

public class SPMainAdapter extends ArrayAdapter<Persona> {
    public SPMainAdapter(Context context) {
        super(context, 0, new ArrayList<Persona>());

    }

    // SPINNER SIN DESPLEGAR
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_item, parent, false);

            TextView tvFullName = (TextView) convertView.findViewById(R.id.tvSpinnerItemFullname);

            Persona persona = getItem(position);
            tvFullName.setText(persona.getNombre() + ' ' + persona.getApellido());
        }
        return convertView;
    }

    // SPINNER DESPLEGADO
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_item_dropdorwnview, parent, false);

            TextView tvFullName = (TextView) convertView.findViewById(R.id.tvSpinnerItemDropdownviewFullname);

            Persona persona = getItem(position);
            tvFullName.setText(persona.getNombre() + ' '+ persona.getApellido());

            // OTRA FORMA EN UNA LINEA
            /*((TextView)convertView.findViewById(R.id.tvSpinnerItemDropdownviewFullname)).setText((
                    getItem(position).getNombre() + ' '+getItem(position).getApellido()));*/
        }
        return convertView;
    }

}
