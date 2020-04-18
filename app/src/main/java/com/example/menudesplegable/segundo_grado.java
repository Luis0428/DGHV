package com.example.menudesplegable;

import android.os.Bundle;
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
                float a = Float.parseFloat(ed_a.getText().toString());
                float b = Float.parseFloat(ed_b.getText().toString());
                float c = Float.parseFloat(ed_c.getText().toString());

                float sqrt, x1, x2, tmp;
                tmp = (b * b) - (4 * a * c);
                if(tmp > 0)
                {
                    sqrt = (float) Math.sqrt(tmp);
                    x1 = (float) ((-b + sqrt) / (2 * a));
                    x2 = (float) ((-b - sqrt) / (2 * a));

                    tv_x1.setText(String.valueOf(x1));
                    tv_x2.setText(String.valueOf(x2));
                }
                else
                {
                    sqrt = (float) Math.sqrt(-tmp);
                    sqrt = sqrt / (2 * a);
                    x1 = (-b) / 2 * a;
                    String real = (x1 == 0) ? "" : String.valueOf(x1);
                    String img1 = (sqrt == 1) ? "i" : " + " + String.valueOf(sqrt) + "i";
                    String img2 = (sqrt == 1) ? "-i" : " - " + String.valueOf(sqrt) + "i";

                    String m1 = real + img1;
                    String m2 = real + img2;
                    tv_x1.setText(m1);
                    tv_x2.setText(m2);
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_a.setText("");
                ed_b.setText("");
                ed_c.setText("");
            }
        });

        return vista;
    }

    public void mResolver(View view)
    {
        float a = Float.parseFloat(ed_a.getText().toString());
        float b = Float.parseFloat(ed_b.getText().toString());
        float c = Float.parseFloat(ed_c.getText().toString());

        float sqrt, x1, x2, tmp;
        tmp = (b * b) - (4 * a * c);
        if(tmp < 0)
        {
            sqrt = (float) Math.sqrt(tmp);
            x1 = (float) ((-b + sqrt) / (2 * a));
            x2 = (float) ((-b - sqrt) / (2 * a));

            tv_x1.setText(String.valueOf(x1));
            tv_x2.setText(String.valueOf(x2));
        }
        else
        {
            sqrt = (float) Math.sqrt(-tmp);
            sqrt = sqrt / (2 * a);
            x1 = (-b) / 2 * a;
            String m1 = String.valueOf(x1) + " + " + String.valueOf(sqrt) + "i";
            String m2 = String.valueOf(x1) + " - " + String.valueOf(sqrt) + "i";
            tv_x1.setText(m1);
            tv_x2.setText(m2);
        }

    }

    public void mLimpiar(View view)
    {
        ed_a.setText("");
        ed_b.setText("");
        ed_c.setText("");
    }
}
