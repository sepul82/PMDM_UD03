package davidens.dlo_1.ud3_lopez_otero_david;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

import davidens.dlo_1.ud3_lopez_otero_david.R;
import davidens.dlo_1.ud3_lopez_otero_david.GestionBD;
import davidens.dlo_1.ud3_lopez_otero_david.Persona;

public class Registro extends AppCompatActivity {

    GestionBD bdPersonas = null;
    SQLiteDatabase db = null;
    String nombreFichero = "";
    String descripcionFichero = "";
    boolean algoSeleccionado = false;

    private void eventosBotonesBD () {

        Button registrar = (Button)findViewById(R.id.rg_bt_registro);


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText etNombre = (EditText)findViewById(R.id.rg_nombre);
                EditText etApellido1 = (EditText)findViewById(R.id.rg_apellido1);
                EditText etApellido2 = (EditText)findViewById(R.id.rg_apellido2);
                EditText etEmail = (EditText)findViewById(R.id.rg_email);
                EditText etUsuario = (EditText)findViewById(R.id.rg_usuario);
                EditText etPassword = (EditText)findViewById(R.id.rg_pass);
                Spinner spCliente = (Spinner) findViewById(R.id.rg_sp_cliente_admin);
                String etCliente = spCliente.getSelectedItem().toString();

                if (etNombre.length() > 0 && etApellido1.length() > 0 && etApellido2.length() > 0 && etEmail.length() > 0 && etUsuario.length() > 0 && etPassword.length() >0 && etCliente.length() > 0 )
                {
                    Persona persona = new Persona(0, etNombre.getText().toString(), etApellido1.getText().toString(), etApellido2.getText().toString(), etEmail.getText().toString(), etUsuario.getText().toString(), etPassword.getText().toString(), etCliente);
                    bdPersonas = new GestionBD(getApplicationContext());
                    db = bdPersonas.getWritableDatabase();
                    bdPersonas.insertarDatos(db, persona);
                    db.close();
                    etNombre.setText("");
                    etApellido1.setText("");
                    etApellido2.setText("");
                    etEmail.setText("");
                    etUsuario.setText("");
                    etPassword.setText("");

                    Toast.makeText(Registro.this, "Datos añadidos correctamente.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Registro.this, "Debe rellenar primero todos los campos.", Toast.LENGTH_SHORT).show();
                    Log.w("INFORMACIÓN BD", "*** AVISO *** Alguno de los campos se encuentra vacío.");
                }
            }
        });





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eventosBotonesBD ();


    }
}
