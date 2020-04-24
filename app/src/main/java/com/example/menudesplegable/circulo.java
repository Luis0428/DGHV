package com.example.menudesplegable;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class circulo extends Fragment
{
    protected EditText Radio ;
    protected TextView Area,Perimetro;
    protected Button BtnResolver,BtnLimpiar;
    protected View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_circulo,container,false);
        Radio = view.findViewById(R.id.editText21);
        Area = view.findViewById(R.id.textView32);
        Perimetro = view.findViewById(R.id.textView56);
        BtnResolver = view.findViewById(R.id.button11);
        BtnLimpiar = view.findViewById(R.id.button12);

        BtnResolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String R = Radio.getText().toString();
                if(!R.isEmpty()){
                    float RadioCirculo = Float.parseFloat(R);
                    float AreaCirculo = (float)(3.1415*Math.pow(RadioCirculo,2));
                    float PerimetroCirculo = (float) (2*3.1415*RadioCirculo);
                    Area.setText(String.valueOf(AreaCirculo));
                    Perimetro.setText(String.valueOf(PerimetroCirculo));
                }else if(R.isEmpty()){
                    Snackbar.make(getView(),"Falta colocar el radio del circulo",Snackbar.LENGTH_LONG).show();
                }
            }
        });

        BtnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Radio.setText("");
                Area.setText("");
                Perimetro.setText("");
            }
        });
        return view;
    }
}
