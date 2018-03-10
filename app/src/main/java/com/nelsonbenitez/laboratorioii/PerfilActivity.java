package com.nelsonbenitez.laboratorioii;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    String USER, PASSWORD,EMAIL;
    TextView user,email, user_final, email_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        user=(TextView) findViewById(R.id.usuario);
        //user.setEnabled(false);
        email=(TextView) findViewById(R.id.mail);
        //email.setEnabled(false);

        Bundle datos = getIntent().getExtras();
        USER= datos.getString("usuario");
        PASSWORD=datos.getString("contrasena");
        EMAIL=datos.getString("email");


        email.setText("EMAIL: "+EMAIL);
        user.setText("USER: "+USER);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_perfil,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id==R.id.principal)
        {
            Intent MI_PERFIL =new Intent().setClass(PerfilActivity.this,MainActivity.class);
            MI_PERFIL.putExtra("usuario",USER);
            MI_PERFIL.putExtra("contrasena",PASSWORD);
            MI_PERFIL.putExtra("email",EMAIL);
            startActivity(MI_PERFIL);
            finish();
        }

        else if (id==R.id.Cerrar_Sesion)
        {
            Intent MI_PERFIL =new Intent().setClass(PerfilActivity.this,LogginActivity.class);
            MI_PERFIL.putExtra("usuario",USER);
            MI_PERFIL.putExtra("contrasena",PASSWORD);
            MI_PERFIL.putExtra("email",EMAIL);
            startActivity(MI_PERFIL);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
