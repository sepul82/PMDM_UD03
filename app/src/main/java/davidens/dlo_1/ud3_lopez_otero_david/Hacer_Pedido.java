package davidens.dlo_1.ud3_lopez_otero_david;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static davidens.dlo_1.ud3_lopez_otero_david.R.array.informatica;

public class Hacer_Pedido extends AppCompatActivity {
    Button bt_siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hacer__pedido);
        bt_siguiente=findViewById(R.id.hp_bt_siguiente);
        eventoSpinner();
        bt_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_direccion= new Intent(Hacer_Pedido.this, direccion.class);
                Hacer_Pedido.this.startActivity(int_direccion);
            }
        });

    }

    private void eventoSpinner() {

        final Spinner sp_categoria = (Spinner) findViewById(R.id.hp_sp_categoria);
        final Spinner sp_producto = (Spinner) findViewById(R.id.hp_sp_producto);


        sp_categoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String categoria = sp_categoria.getItemAtPosition(position).toString();
                ArrayAdapter<String> adapter_producto = new ArrayAdapter<String>(Hacer_Pedido.this,android.R.layout.simple_list_item_1);
                if (categoria.equals("Informática")) {


                    adapter_producto.addAll(getResources().getStringArray(R.array.informatica));
                    sp_producto.setAdapter(adapter_producto);

                }
                if (categoria.equals("Electrónica")) {


                    adapter_producto.addAll(getResources().getStringArray(R.array.electronica));
                    sp_producto.setAdapter(adapter_producto);

                }
                if (categoria.equals("Móviles")) {


                    adapter_producto.addAll(getResources().getStringArray(R.array.moviles));
                    sp_producto.setAdapter(adapter_producto);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


}

