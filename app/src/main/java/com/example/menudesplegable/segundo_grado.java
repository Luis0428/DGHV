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

public class segundo_grado extends Fragment
{
    EditText ed_a, ed_b, ed_c;
    TextView tv_x1, tv_x2;
    View vista;
    Button btnResolver, btnLimpiar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_segundo_grado, container, false);

        ed_a = vista.findViewById(R.id.et_a);
        ed_b = vista.findViewById(R.id.et_b);
        ed_c = vista.findViewById(R.id.et_c);
        tv_x1 = vista.findViewById(R.id.tv_x1);
        tv_x2 = vista.findViewById(R.id.tv_x2);
        btnResolver = vista.findViewById(R.id.btnResolver);
        btnLimpiar = vista.findViewById(R.id.btnLimpiar);

        btnResolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(validarCampos())
                {
                    float a = Float.parseFloat(ed_a.getText().toString());
                    float b = Float.parseFloat(ed_b.getText().toString());
                    float c = Float.parseFloat(ed_c.getText().toString());

                    float sqrt, x1, x2, tmp;
                    tmp = (b * b) - (4 * a * c);

                    String r1, r2, tmpImg1, tmpImg2;
                    if(tmp > 0)
                    {
                        sqrt = (float) Math.sqrt(tmp);
                        x1 = (float) ((-b + sqrt) / (2 * a));
                        x2 = (float) ((-b - sqrt) / (2 * a));

                        r1 = (x1 == 0) ? "" : String.valueOf(x1);
                        r2 = (x2 == 0) ? "" : String.valueOf(x2);

                        r1 = (r1.length() > 8) ? r1.substring(0, 8) : r1;
                        r2 = (r2.length() > 8) ? r2.substring(0, 8) : r2;

                        tv_x1.setText(r1);
                        tv_x2.setText(r2);
                    }
                    else
                    {
                        sqrt = (float) Math.sqrt(-tmp);
                        sqrt = sqrt / (2 * a);
                        x1 = (-b) / 2 * a;

                        r1 = (x1 == 0) ? "" : String.valueOf(x1);
                        tmpImg1 = (sqrt == 1) ? "+i" : " + " + String.valueOf(sqrt) + "i";
                        tmpImg2 = (sqrt == 1) ? "-i" : " - " + String.valueOf(sqrt) + "i";

                        String real = (r1.length() > 8) ? r1.substring(0, 8) : r1;
                        String img1 = (tmpImg1.length() > 8) ? tmpImg1.substring(0, 8) + "i" : tmpImg1;
                        String img2 = (tmpImg2.length() > 8) ? tmpImg2.substring(0, 8) + "i" : tmpImg2;

                        String m1 = real + img1;
                        String m2 = real + img2;
                        tv_x1.setText(m1);
                        tv_x2.setText(m2);
                    }
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_a.setText("");
                ed_b.setText("");
                ed_c.setText("");
                tv_x1.setText("");
                tv_x2.setText("");
            }
        });

        return vista;
    }

    private boolean validarCampos()
    {
        if(ed_a.getText().toString().equals("") || ed_b.getText().toString().equals("") || ed_c.getText().toString().equals(""))
        {
            Snackbar.make(getView(),"No se han llenado algunos campos.", Snackbar.LENGTH_LONG).show();
            return false;
        }
        else if(Float.parseFloat(ed_a.getText().toString()) == 0f)
        {
            Snackbar.make(getView(),"a debe de ser distinto a 0.", Snackbar.LENGTH_LONG).show();
            return false;
        }
        else return true;


    }
}
