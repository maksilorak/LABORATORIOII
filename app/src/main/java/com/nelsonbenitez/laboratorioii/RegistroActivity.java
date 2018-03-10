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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity {

    EditText eUSER,ePASSWORD,eCONFIRMA_CONTRASENA,eMAIL;
    String usuario, contrasena, mail,usuario_ingresado,password_ingresado,confirma_password_ingresado,mail_ingresado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //establece el modo de la pantalla
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE); // no app bar
        setContentView(R.layout.activity_registro);


        eUSER= (EditText) findViewById(R.id.usuario);
        ePASSWORD=(EditText) findViewById(R.id.contrasena);
        eCONFIRMA_CONTRASENA=(EditText) findViewById(R.id.confirma_contrasena);
        eMAIL=(EditText) findViewById(R.id.mail);


        Bundle datos = getIntent().getExtras();
        usuario= datos.getString("usuario");
        contrasena=datos.getString("contrasena");
        mail=datos.getString("email");
    }

    public void Registrar(View view) {
        usuario_ingresado=eUSER.getText().toString();
        password_ingresado=ePASSWORD.getText().toString();
        confirma_password_ingresado=eCONFIRMA_CONTRASENA.getText().toString();
        mail_ingresado=eMAIL.getText().toString();

        if (usuario_ingresado.length()!=0 && password_ingresado.length()!=0
                && confirma_password_ingresado.length()!=0 && mail_ingresado.length()!=0)
        {
            if (password_ingresado.equals(confirma_password_ingresado) && PasswordEsValido(password_ingresado)
                    && UusuarioEsValido(usuario_ingresado) && EmailIsValido(mail_ingresado))
            {
                usuario=eUSER.getText().toString();
                contrasena=ePASSWORD.getText().toString();
                mail=eMAIL.getText().toString();

                    Intent respuesta = new Intent();
                    respuesta.putExtra("usuario",usuario);
                    respuesta.putExtra("contrasena",contrasena);
                    respuesta.putExtra("email",mail);
                    setResult(RESULT_OK,respuesta);
                    Toast datos_invalidos= Toast.makeText(this,"Registrado con éxito"
                            ,Toast.LENGTH_SHORT);
                    datos_invalidos.show();
                    finish();
            }
        }

        else if (!PasswordEsValido(password_ingresado))
        {
            Toast datos_invalidos= Toast.makeText(this,"Contraseña no válida. Mínimo 6 caracteres"
                    ,Toast.LENGTH_SHORT);
            datos_invalidos.show();
            Log.d("Error:","Password inválido");
        }

        else if (!password_ingresado.equals(confirma_password_ingresado))
        {
            Toast datos_invalidos= Toast.makeText(this,"Contraseñas no coinciden"
                    ,Toast.LENGTH_SHORT);
            datos_invalidos.show();
            Log.d("Error:","Contraseñas no coinciden");
        }

        else if (!UusuarioEsValido(usuario_ingresado))
        {
            Toast datos_invalidos= Toast.makeText(this,"Usuario no es válido",Toast.LENGTH_SHORT);
            datos_invalidos.show();
            Log.d("Error:","Usuario Invalido");
        }

        else if (!password_ingresado.equals(confirma_password_ingresado))
        {
            Toast datos_invalidos= Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT);
            datos_invalidos.show();
            Log.d("Error:","Contraseñas no son iguales");
        }

        else if (!EmailIsValido(mail_ingresado))
        {
            Toast datos_invalidos= Toast.makeText(this,"Email Inválido",Toast.LENGTH_SHORT);
            datos_invalidos.show();
            Log.d("Error:","Email Inválido");
        }

    }

    private boolean EmailIsValido(String email) {
        boolean isValid= false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    private boolean UusuarioEsValido(String USUARIO) {
        if (USUARIO!=null && USUARIO.length()>=6){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean PasswordEsValido(String PASSWORD) {
        if (PASSWORD!=null && PASSWORD.length()>=6){
            return true;
        }
        else {
            return false;
        }
    }
}
