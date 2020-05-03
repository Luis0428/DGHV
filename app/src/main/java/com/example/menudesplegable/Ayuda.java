package com.example.menudesplegable;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessageAware;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Ayuda extends Fragment {
    protected View vista;
    protected String correoEmisor="contacto.dghv@gmail.com";
    protected String PassEmisor="dghv123gatito";
    protected Button BTN_Limpiar,BTN_ENVIAR;
    protected EditText CorreoCliente,MensajeCliente;
    protected Session sesion;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        vista= inflater.inflate(R.layout.fragment_ayuda, container, false);
        BTN_Limpiar = vista.findViewById(R.id.btn_LimpiarMensaje);
        BTN_ENVIAR = vista.findViewById(R.id.btn_EnviarCorreo);
        CorreoCliente = vista.findViewById(R.id.Correo_Cliente);
        MensajeCliente = vista.findViewById(R.id.Mensaje_Ayuda);



        BTN_Limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MensajeCliente.setText("");
            }
        });

        BTN_ENVIAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_correoCliente = CorreoCliente.getText().toString();
                String txt_mensajeCliente = MensajeCliente.getText().toString();
                StrictMode.ThreadPolicy policity = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policity);
                if(!txt_mensajeCliente.isEmpty() && !txt_correoCliente.isEmpty()){
                    Properties Propiedades = new Properties();
                    //En el caso de que nuestro emisor fuera un correo de hotmail se tiene que cambiar a smtp.live.com
                    Propiedades.put("mail.smtp.host","smtp.googlemail.com");
                    //En el caso de que nuestro emisor fuera un correo de hotmail se cambia el puerto a 587
                    Propiedades.put("mail.smtp.socketFactory.port","465");
                    Propiedades.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                    Propiedades.put("mail.smtp.auth","true");
                    //En el caso de que nuestro emisor fuera un correo de hotmail se cambia a put(mail.starttls.enable,true)
                    Propiedades.put("mail.smtp.port","465");
                    try {
                        sesion = Session.getDefaultInstance(Propiedades, new Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(correoEmisor,PassEmisor);
                            }
                        });
                        if(sesion != null){
                            Message mensaje = new MimeMessage(sesion);
                            mensaje.setFrom(new InternetAddress(correoEmisor)); //Correo de quien esta enviando el correo
                            mensaje.setSubject("Ayuda en DGHV"); //Asunto del correo
                            mensaje.setRecipients(Message.RecipientType.TO,InternetAddress.parse("reporte.dghv@gmail.com"));//Correo al que vamos a enviarle el mensaje
                            mensaje.setContent(txt_mensajeCliente+". "+"Puedes comunicarte conmigo con el siguiente correo: "+txt_correoCliente,"text/html; charset=utf-8");
                            Transport.send(mensaje);
                            Snackbar.make(getView(),"Mensaje Enviado",Snackbar.LENGTH_LONG).show();
                            MensajeCliente.setText("");
                        /*En el caso de que nuestro emisor fuera un correo de hotmail se cambia lo siguiente
                        Transport transport = sesion.getTransport("smtp");
                        transport.connect("smtp.live.com",587,correoEmisor,PassEmisor);
                        transport.sendMessage(mensaje,mensaje.getAllRecipients());
                        transport.close();
                        */
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        Snackbar.make(getView(),"Algo ha salido mal, lamentamos las molestias",Snackbar.LENGTH_LONG).show();
                    }
                }else if(txt_correoCliente.isEmpty() && !txt_mensajeCliente.isEmpty()){
                    Snackbar.make(getView(),"Falta correo al que vamos a comunicarnos",Snackbar.LENGTH_LONG).show();
                }else if(!txt_correoCliente.isEmpty() && txt_mensajeCliente.isEmpty()){
                    Snackbar.make(getView(),"Falta mensaje para enviar el correo",Snackbar.LENGTH_LONG).show();
                }else if(txt_correoCliente.isEmpty() && txt_mensajeCliente.isEmpty()){
                    Snackbar.make(getView(),"No se ha llenado ningun campo",Snackbar.LENGTH_LONG).show();
                }
            }
        });
        return vista;

    }
}
