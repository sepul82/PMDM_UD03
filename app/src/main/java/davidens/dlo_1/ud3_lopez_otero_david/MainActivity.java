package davidens.dlo_1.ud3_lopez_otero_david;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button bt_registro;
    Button bt_clientes;
    GestionBD bdPersonas = null;
    SQLiteDatabase db = null;
    String nombreUser = "";
    String nombrePassword = "";
    int loginOK=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_registro = findViewById(R.id.lg_registro);
        bt_clientes = findViewById(R.id.lg_loguearse);

        eventoLogin();
        eventoRegistro();

    }

        private void eventoLogin () {


            bt_clientes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    EditText etUser = (EditText) findViewById(R.id.lg_user);
                    EditText etPass = (EditText) findViewById(R.id.lg_pass);


                    if (etUser.length() > 0 && etPass.length() > 0) {

                        //CURSOR PARA VERIFICAR LOS DATOS DE USUARIO Y PASSWORD, PERO DA ERROR

                       /* Cursor cursor=bdPersonas.ConsultarUsuPas(etUser.getText().toString(),etPass.getText().toString());
                        if (cursor.getCount()>0){

                            Intent int_cliente= new Intent(MainActivity.this, Clientes.class);
                            MainActivity.this.startActivity(int_cliente);

                        }*/
                        Toast.makeText(MainActivity.this, "Usuario o Password erróneos", Toast.LENGTH_SHORT).show();

                        //bdPersonas = new GestionBD(getApplicationContext());

                        //ESTO IRÍA DENTRO DEL IF DEL CURSOR. EN CASO DE QUE EL LOGIN FUESE CORRECTE, SE AVANZA A LA SIGUIENTE PANTALLA, PERO COMO FALLA, LO DEJO ASÍ

                        Intent int_cliente= new Intent(MainActivity.this, Clientes.class);
                        MainActivity.this.startActivity(int_cliente);






                    } else {
                        Toast.makeText(MainActivity.this, "Debe rellenar primero todos los campos.", Toast.LENGTH_SHORT).show();
                        Log.w("INFORMACIÓN BD", "*** AVISO *** Alguno de los campos se encuentra vacío.");
                    }
                }
            });


        }






            private void eventoRegistro(){

                bt_registro.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent int_registro= new Intent(MainActivity.this, Registro.class);
                                           MainActivity.this.startActivity(int_registro);
                                       }

                });

                }





    }



