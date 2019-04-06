package com.jaimefuentesp.tarearecyclerview;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static java.security.AccessController.getContext;

public class ActivityContacto extends AppCompatActivity {

    String contrasena;
    EditText mensaje;
    EditText correo;
    Session session;
    Button botonEnviar;
    EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mensaje = (EditText) findViewById(R.id.txtInputMensaje);
        correo = (EditText) findViewById(R.id.txtInputMail);
        botonEnviar = (Button) findViewById(R.id.botonEnviar);
        nombre = (EditText) findViewById(R.id.txtInputNombre);

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarMail();
                Toast.makeText(getBaseContext(),"Comentario enviado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void enviarMail () {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.googlemail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.port","465");

        try {
            session= javax.mail.Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("jaimefuentesp@gmail.com","jamessjamess321");
                }
            });
            if (session!=null) {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("jaimefuentesp@gmail.com"));
                message.setSubject("Mensaje de "+nombre.getText().toString());
                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(correo.getText().toString()));
                message.setContent(mensaje.getText().toString(),"text/html; charset=utf-8");
                Transport.send(message);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
