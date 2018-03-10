package com.nelsonbenitez.laboratorioii;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    String USUARIO, CONTRASENA,CORREO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle datos = getIntent().getExtras();
        USUARIO= datos.getString("usuario");
        CONTRASENA=datos.getString("contrasena");
        CORREO=datos.getString("email");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id==R.id.Mi_Perfil)
        {
            Intent MI_PERFIL =new Intent().setClass(MainActivity.this,PerfilActivity.class);
            MI_PERFIL.putExtra("usuario",USUARIO);
            MI_PERFIL.putExtra("contrasena",CONTRASENA);
            MI_PERFIL.putExtra("email",CORREO);
            startActivity(MI_PERFIL);
            finish();
        }

        else if (id==R.id.Cerrar_Sesion)
        {
            Intent MI_PERFIL =new Intent().setClass(MainActivity.this,LogginActivity.class);
            MI_PERFIL.putExtra("usuario",USUARIO);
            MI_PERFIL.putExtra("contrasena",CONTRASENA);
            MI_PERFIL.putExtra("email",CORREO);
            startActivity(MI_PERFIL);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
