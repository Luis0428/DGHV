package com.example.menudesplegable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class distancia extends Fragment
{
    EditText etx1, etx2, ety1, ety2;
    TextView tvDistancia, tvPendiente;
    Button btnResolver, btnLimpiar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_distancia, container, false);

        etx1 = view.findViewById(R.id.dist_etx1);
        etx2 = view.findViewById(R.id.dist_etx2);
        ety1 = view.findViewById(R.id.dist_ety1);
        ety2 = view.findViewById(R.id.dist_ety2);
        tvDistancia = view.findViewById(R.id.dist_tvPuntos);
        tvPendiente = view.findViewById(R.id.dist_tvPendiente);
        btnResolver = view.findViewById(R.id.dist_btnResolver);
        btnLimpiar = view.findViewById(R.id.dist_btnLimpiar);

        btnResolver.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        float x1, x2, y1, y2, distancia, pendiente;
                        validarEntradas();

                        x1 = Float.parseFloat(etx1.getText().toString());
                        x2 = Float.parseFloat(etx2.getText().toString());
                        y1 = Float.parseFloat(ety1.getText().toString());
                        y2 = Float.parseFloat(ety2.getText().toString());

                        distancia = (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                        pendiente = (y2 - y1) / (x2 - x1);

                        tvDistancia.setText(String.valueOf(distancia));
                        tvPendiente.setText(String.valueOf(pendiente));
                    }
                }
        );

        btnLimpiar.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        etx1.setText("");
                        etx2.setText("");
                        ety1.setText("");
                        ety2.setText("");
                        tvDistancia.setText("");
                        tvPendiente.setText("");
                    }
                }
        );

        return view;
    }

    private void validarEntradas()
    {
        String x1 = etx1.getText().toString();
        String x2 = etx2.getText().toString();
        String y1 = ety1.getText().toString();
        String y2 = ety2.getText().toString();

        if (x1.equals(""))
            etx1.setText("0");

        if (x2.equals(""))
            etx2.setText("0");

        if (y1.equals(""))
            ety1.setText("0");

        if (y2.equals(""))
            ety2.setText("0");
    }
}
