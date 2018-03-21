package com.nelsonbenitez.laboratorioii;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class LogginActivity extends AppCompatActivity {

    EditText eUSUARIO,eCONTRASENA;
    String USER,PASSWORD,MAIL;
    String usuario_ingresado,password_ingresado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //establece el modo de la pantalla
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE); // no app bar
        setContentView(R.layout.activity_loggin);

        eUSUARIO= (EditText) findViewById(R.id.usuario_login);
        eCONTRASENA=(EditText) findViewById(R.id.contrasena_login);

        Bundle datos = getIntent().getExtras();
        USER= datos.getString("usuario");
        PASSWORD=datos.getString("contrasena");
        MAIL=datos.getString("email");


    }

    public void Registro(View view) {
        Intent registro = new Intent(LogginActivity.this,RegistroActivity.class);
        registro.putExtra("usuario","");
        registro.putExtra("contrasena","");
        registro.putExtra("email","");
        startActivityForResult(registro,1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode==RESULT_OK)
        {
            USER=data.getExtras().getString("usuario");
            PASSWORD=data.getExtras().getString("contrasena");
            MAIL=data.getExtras().getString("email");
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void Ingresar(View view) {
        usuario_ingresado=eUSUARIO.getText().toString();
        password_ingresado=eCONTRASENA.getText().toString();

        if (usuario_ingresado.length()!=0 && password_ingresado.length()!=0)
        {
            if (password_ingresado.equals(PASSWORD)
                    && usuario_ingresado.equals(USER))
            {
                Intent IR_A_MAIN =new Intent().setClass(LogginActivity.this,MainActivity.class);
                IR_A_MAIN.putExtra("usuario",USER);
                IR_A_MAIN.putExtra("contrasena",PASSWORD);
                IR_A_MAIN.putExtra("email",MAIL);

                Toast datos_validos= Toast.makeText(this,"Ingreso éxitoso"
                        ,Toast.LENGTH_SHORT);
                datos_validos.show();

                startActivity(IR_A_MAIN);

            }

            else if (! usuario_ingresado.equals(USER))
            {
                Toast datos_invalidos= Toast.makeText(this,"Usuario Errado"
                        ,Toast.LENGTH_SHORT);
                datos_invalidos.show();
            }

            else
            {
                Toast datos_invalidos= Toast.makeText(this,"Contraseña Errada"
                        ,Toast.LENGTH_SHORT);
                datos_invalidos.show();
            }
        }

        else if (usuario_ingresado.length()==0)
        {
            Toast datos_invalidos= Toast.makeText(this,"Usuario está vacío"
                    ,Toast.LENGTH_SHORT);
            datos_invalidos.show();
        }

        else
        {
            Toast datos_invalidos= Toast.makeText(this,"Contraseña está vacía"
                    ,Toast.LENGTH_SHORT);
            datos_invalidos.show();
        }
    }
}
