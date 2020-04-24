package com.example.menudesplegable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class pitagoras extends Fragment
{
    EditText etA, etB, etC;
    RadioButton rbA, rbB, rbC;
    TextView tvSalida, tvRes;
    Button btnResolver, btnLimpiar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_pitagoras, container, false);

        etA = vista.findViewById(R.id.pit_etA);
        etB = vista.findViewById(R.id.pit_etB);
        etC = vista.findViewById(R.id.pit_etC);
        rbA = vista.findViewById(R.id.pit_rbA);
        rbB = vista.findViewById(R.id.pit_rbB);
        rbC = vista.findViewById(R.id.pit_rbC);
        tvSalida = vista.findViewById(R.id.pit_tvSalida);
        tvRes = vista.findViewById(R.id.pit_tvRes);
        btnResolver = vista.findViewById(R.id.pit_btnResolver);
        btnLimpiar = vista.findViewById(R.id.pit_btnLimpiar);

        btnResolver.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        validarEntradas();
                        float valor1, valor2, res, tmp;

                        if(rbA.isChecked())
                        {
                            valor1 = Float.parseFloat(etB.getText().toString());
                            valor2 = Float.parseFloat(etC.getText().toString());

                            tmp = (float) (Math.pow(valor2, 2) - Math.pow(valor1, 2));
                            res = (float) Math.sqrt(tmp);

                            tvSalida.setText("a:");
                            tvRes.setText(String.valueOf(res));
                        }
                        else if(rbB.isChecked())
                        {
                            valor1 = Float.parseFloat(etA.getText().toString());
                            valor2 = Float.parseFloat(etC.getText().toString());

                            tmp = (float) (Math.pow(valor2, 2) - Math.pow(valor1, 2));
                            res = (float) Math.sqrt(tmp);

                            tvSalida.setText("b:");
                            tvRes.setText(String.valueOf(res));
                        }
                        else if(rbC.isChecked())
                        {
                            valor1 = Float.parseFloat(etA.getText().toString());
                            valor2 = Float.parseFloat(etB.getText().toString());

                            tmp = (float) (Math.pow(valor2, 2) + Math.pow(valor1, 2));
                            res = (float) Math.sqrt(tmp);

                            tvSalida.setText("c:");
                            tvRes.setText(String.valueOf(res));
                        }
                    }
                }
        );

        btnLimpiar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        etA.setText("");
                        etB.setText("");
                        etC.setText("");

                        tvRes.setText("");
                        tvSalida.setText("a/b/c:");
                    }
                }
        );

        return vista;
    }

    private void validarEntradas()
    {
        String a = etA.getText().toString();
        String b = etB.getText().toString();
        String c = etC.getText().toString();

        if(a.equals(""))
            etA.setText("0");

        if(b.equals(""))
            etB.setText("0");

        if(c.equals(""))
            etC.setText("0");
    }
}
