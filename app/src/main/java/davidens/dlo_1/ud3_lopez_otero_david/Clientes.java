package davidens.dlo_1.ud3_lopez_otero_david;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Clientes extends AppCompatActivity {
    Button cl_bt_hacerpedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        cl_bt_hacerpedido=findViewById(R.id.cl_hacerpedido);
        cl_bt_hacerpedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_hacerpedido= new Intent(Clientes.this, Hacer_Pedido.class);
                Clientes.this.startActivity(int_hacerpedido);
            }
        });
    }
}
