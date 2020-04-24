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

public class rectangulo extends Fragment
{
    protected TextView Area, Perimetro;
    protected EditText Lado1,Lado2;
    protected Button BtnResolver,BtnLimpiar;
    protected View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_rectangulo,container,false);
        Lado1 = view.findViewById(R.id.editText3);
        Lado2 = view.findViewById(R.id.editText21);
        Area = view.findViewById(R.id.textView32);
        Perimetro = view.findViewById(R.id.textView56);
        BtnResolver = view.findViewById(R.id.button11);
        BtnLimpiar = view.findViewById(R.id.button12);

        BtnResolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String B = Lado1.getText().toString();
                String A = Lado2.getText().toString();
                if(!B.isEmpty() && !A.isEmpty()){
                    float Base = Float.parseFloat(B);
                    float Altura = Float.parseFloat(A);
                    float AreaRec=(float) (Base*Altura);
                    float PerimetroRec= (float) ((2*Base)+(2*Altura));
                    Area.setText(String.valueOf(AreaRec));
                    Perimetro.setText(String.valueOf(PerimetroRec));
                }else if(B.isEmpty() && !A.isEmpty()){
                    //Toast.makeText(getActivity(),"Hace falta llenar el campo Lado 1 (Base)", LENGTH_SHORT).show();
                    Snackbar.make(getView(),"Hace falta llenar el campo Lado 1 (Base)",Snackbar.LENGTH_LONG).show();
                }else if(!B.isEmpty() && A.isEmpty()){
                    //Toast.makeText(getActivity(),"Hace falta llenar el campo Lado 2 (Altura)", LENGTH_SHORT).show();
                    Snackbar.make(getView(),"Hace falta llenar el campo Lado 2 (Altura)",Snackbar.LENGTH_LONG).show();
                }else if(B.isEmpty() && A.isEmpty()){
                    //Toast.makeText(getActivity(),"Hace falta llenar el campo Lado1 y Lado 2", LENGTH_SHORT).show();
                    Snackbar.make(getView(),"Hace falta llenar el campo Lado 1 y Lado 2",Snackbar.LENGTH_LONG).show();
                }
            }
        });
        BtnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Area.setText("");
                Perimetro.setText("");
                Lado1.setText("");
                Lado2.setText("");
            }
        });
        return view;
    }
}
