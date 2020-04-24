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
import android.widget.Toast;

public class ec_lineales extends Fragment
{
    EditText etX1, etX2, etY1, etY2, etC1, etC2;
    TextView tvX, tvY;
    Button btnResolver, btnLimpiar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View vista = inflater.inflate(R.layout.fragment_ec_lineales, container, false);

        etX1 = vista.findViewById(R.id.lin_etX1);
        etY1 = vista.findViewById(R.id.lin_etY1);
        etX2 = vista.findViewById(R.id.lin_etX2);
        etY2 = vista.findViewById(R.id.lin_etY2);
        etC1 = vista.findViewById(R.id.lin_etC1);
        etC2 = vista.findViewById(R.id.lin_etC2);
        tvX = vista.findViewById(R.id.lin_tvX);
        tvY = vista.findViewById(R.id.lin_tvY);
        btnResolver = vista.findViewById(R.id.lin_btnResolver);
        btnLimpiar = vista.findViewById(R.id.lin_btnLimpiar);

        btnResolver.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        if(validarCampos())
                        {
                            float detP=0, detX=0, detY=0, X = 0, Y = 0;
                            float mat[][] = new float[2][3];

                            mat[0][0] = Float.parseFloat(etX1.getText().toString());
                            mat[0][1] = Float.parseFloat(etY1.getText().toString());
                            mat[0][2] = Float.parseFloat(etC1.getText().toString());
                            mat[1][0] = Float.parseFloat(etX2.getText().toString());
                            mat[1][1] = Float.parseFloat(etY2.getText().toString());
                            mat[1][2] = Float.parseFloat(etC2.getText().toString());

                            detP = (mat[0][0]*mat[1][1])-(mat[1][0]*mat[0][1]);
                            detX = (mat[0][2]*mat[1][1])-(mat[1][2]*mat[0][1]);
                            detY = (mat[0][0]*mat[1][2])-(mat[1][0]*mat[0][2]);
                            X = detX/detP;
                            Y = detY/detP;

                            tvX.setText(String.valueOf(X));
                            tvY.setText(String.valueOf(Y));
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
                        etX1.setText("");
                        etY1.setText("");
                        etC1.setText("");
                        etX2.setText("");
                        etY2.setText("");
                        etC2.setText("");
                        tvX.setText("");
                        tvY.setText("");
                    }
                }
        );

        return vista;
    }

    private boolean validarCampos()
    {
        if(etX1.getText().toString().equals("") ||etY1.getText().toString().equals("") || etC1.getText().toString().equals("") ||
                etX2.getText().toString().equals("") || etY2.getText().toString().equals("") || etC2.getText().toString().equals(""))
        {
            Snackbar.make(getView(),"No se han llenado algunos campos.", Snackbar.LENGTH_LONG).show();
            return false;
        }

        else
            return true;
    }
}
