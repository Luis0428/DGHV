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


public class combinacion extends Fragment
{
    EditText et_nC, et_rC, et_nP, et_rP;
    TextView tvResultado, tvSalida;
    RadioButton rbComb, rbPer;
    Button btnResolver, btnLimpiar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View vista = inflater.inflate(R.layout.fragment_combinacion, container, false);

        et_nC = vista.findViewById(R.id.comb_et_nC);
        et_rC = vista.findViewById(R.id.comb_et_rC);
        et_nP = vista.findViewById(R.id.comb_et_nP);
        et_rP = vista.findViewById(R.id.comb_et_rP);
        tvResultado = vista.findViewById(R.id.comb_tvRes);
        tvSalida = vista.findViewById(R.id.comb_tvSalida);
        btnResolver = vista.findViewById(R.id.comb_btnResolver);
        btnLimpiar = vista.findViewById(R.id.comb_btnLimpiar);
        rbComb = vista.findViewById(R.id.comb_rbComb);
        rbPer = vista.findViewById(R.id.comb_rbPer);

        btnResolver.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        int n, r, res;
                        validarEntradas();

                        if(rbComb.isChecked())
                        {
                            n = Integer.parseInt(et_nC.getText().toString());
                            r = Integer.parseInt(et_rC.getText().toString());
                            et_nP.setText("");
                            et_rP.setText("");
                            res = factorial(n) / (factorial(n - r) * factorial(r));
                            tvSalida.setText("El número de combinaciones es: ");
                            tvResultado.setText(String.valueOf(res));
                        }
                        else  if(rbPer.isChecked())
                        {
                            n = Integer.parseInt(et_nP.getText().toString());
                            r = Integer.parseInt(et_rP.getText().toString());
                            et_nC.setText("");
                            et_rC.setText("");
                            res = factorial(n) / factorial(n - r);
                            tvSalida.setText("El número de permutaciones es: ");
                            tvResultado.setText(String.valueOf(res));
                        }
                    }
                }
        );

        btnLimpiar.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        et_nC.setText("");
                        et_rC.setText("");
                        et_nP.setText("");
                        et_rP.setText("");
                        tvResultado.setText("");
                        tvSalida.setText("El número de combinaciones/permutaciones es:");
                    }
                }
        );

        return vista;
    }

    private void validarEntradas()
    {
        if(et_nC.getText().toString().equals(""))
            et_nC.setText("0");
        if(et_rC.getText().toString().equals(""))
            et_rC.setText("0");
        if(et_nP.getText().toString().equals(""))
            et_nP.setText("0");
        if(et_rP.getText().toString().equals(""))
            et_rP.setText("0");
    }

    private int factorial(int a)
    {
        int res = 1;

        for (int i = 1; i <= a; i++)
            res *= i;

        return res;
    }
}
