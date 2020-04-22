package davidens.dlo_1.ud3_lopez_otero_david;



import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import davidens.dlo_1.ud3_lopez_otero_david.Persona;

import java.util.ArrayList;

public class GestionBD extends SQLiteOpenHelper {

    //Tabla de Personas

    public final static String NOMBRE_BD = "DatosPersonales";
    public final static int VERSION_BD = 1;
    private String borrarTablaPersonas = "DROP TABLE IF EXISTS personas";
    private String crearTablaPersonas = "CREATE TABLE personas (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "nombre VARCHAR(50) NOT NULL, "+
            "apellido1 VARCHAR(150) NOT NULL, "+
            "apellido2 VARCHAR(150) NOT NULL, "+
            "email VARCHAR(50) NOT NULL, "+
            "usuario VARCHAR(50) NOT NULL, "+
            "password VARCHAR(25) NOT NULL, "+
            "cliente VARCHAR (15) NOT NULL)";

    private String insertarTablaPersona = "INSERT INTO personas (nombre, apellido1, apellido2, email, usuario, password, cliente) VALUES (";
    public String consultarPersonas = "SELECT _ID, NOMBRE, APELLIDO1, APELLIDO2, EMAIL, USUARIO, PASSWORD, CLIENTE FROM personas";

    public String borrarDatos = "DELETE FROM personas";

    //Tabla de pedidos


    private String borrarTablaPedidos = "DROP TABLE IF EXISTS pedidos";
    private String crearTablaPedidos = "CREATE TABLE pedidos (" +
            "_id_pedido INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "categoria VARCHAR(150) NOT NULL, "+
            "producto VARCHAR(150) NOT NULL, "+
            "cantidad INTEGER NOT NULL, "+
            "FOREIGN KEY (id_cliente) REFERENCES personas(_id))";

    private String insertarTablaPedidos = "INSERT INTO pedidos (categoria, producto, cantidad, id_cliente) VALUES (";
    public String consultarPedidos = "SELECT _ID_PEDIDO, CATEGORIA, PRODUCTO, CANTIDAD, ID_CLIENTE FROM pedidos";

    public String borrarDatosPedidos = "DELETE FROM pedidos";

    public GestionBD (Context contexto) {

        super(contexto, NOMBRE_BD, null, VERSION_BD);
        Log.i("INFORMACIÓN BD", "Se accede a la base de datos DatosPersonales.");

    }

    @Override
    public void onCreate (SQLiteDatabase db) {

        db.execSQL(crearTablaPersonas);
        Log.i("INFORMACIÓN BD", "Se ha creado la tabla personas.");
        //db.execSQL(crearTablaPedidos);
        //Log.i("INFORMACIÓN BD", "Se ha creado la tabla pedidos.");

    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(borrarTablaPersonas);
        Log.i("INFORMACIÓN BD", "Se ha borrado la tabla personas.");
        db.execSQL(crearTablaPersonas);
        Log.i("INFORMACIÓN BD", "Se ha creado la tabla personas.");

        /*db.execSQL(borrarTablaPedidos);
        Log.i("INFORMACIÓN BD", "Se ha borrado la tabla pedidos.");
        db.execSQL(crearTablaPedidos);
        Log.i("INFORMACIÓN BD", "Se ha creado la tabla pedidos.");*/

    }

    public void insertarDatos (SQLiteDatabase db, Persona persona) {

        db.execSQL(insertarTablaPersona+"'"+persona.getNombre()+"','"+persona.getApellido1()+"','"+persona.getApellido2()+"','"+persona.getEmail()+"','"+persona.getUsuario()+"','"+persona.getPassword()+"','"+persona.getCliente()+"')");
        Log.i("INFORMACIÓN BD", "Se ha añadido a una persona a la base de datos");



    }

    public void insertarDatosPedido (SQLiteDatabase db, Pedido pedido, Persona persona) {

        db.execSQL(insertarTablaPedidos+"'"+pedido.getCategoria()+"','"+pedido.getProducto()+"','"+pedido.getCantidad()+"','"+persona.getId()+"')");
        Log.i("INFORMACIÓN BD", "Se ha añadido un pedido a la base de datos");



    }

    public void borrarBD (SQLiteDatabase db) {

        db.execSQL(borrarDatos);
        Log.i("INFORMACIÓN BD", "Se han borrado los datos de la tabla personas.");

        /*db.execSQL(borrarDatosPedidos);
        Log.i("INFORMACIÓN BD", "Se han borrado los datos de la tabla pedidos.");*/

    }

    public ArrayList<Persona> verDatos (SQLiteDatabase db) {

        ArrayList<Persona> listadoPersonas = new ArrayList<Persona>();

        Cursor datosConsulta = db.rawQuery(consultarPersonas, null);
        if (datosConsulta.moveToFirst())
        {
            Persona persona;
            while (!datosConsulta.isAfterLast())
            {
                persona = new Persona (datosConsulta.getLong(0), datosConsulta.getString(1), datosConsulta.getString(2), datosConsulta.getString(3), datosConsulta.getString(4), datosConsulta.getString(5), datosConsulta.getString(6), datosConsulta.getString(7));
                listadoPersonas.add(persona);
                datosConsulta.moveToNext();
            }
            Log.i("INFORMACIÓN BD", "Se ha creado un listado(ArrayList) con las personas de la tabla personas.");
        }
        return listadoPersonas;
    }

    public ArrayList<Pedido> verDatosPedido (SQLiteDatabase db) {

        ArrayList<Pedido> listadoPedidos = new ArrayList<Pedido>();

        Cursor datosConsultaPedido = db.rawQuery(consultarPedidos, null);
        if (datosConsultaPedido.moveToFirst())
        {
            Pedido pedido;
            while (!datosConsultaPedido.isAfterLast())
            {
                pedido = new Pedido (datosConsultaPedido.getLong(0), datosConsultaPedido.getString(1), datosConsultaPedido.getString(2), datosConsultaPedido.getInt(3));
                listadoPedidos.add(pedido);
                datosConsultaPedido.moveToNext();
            }
            Log.i("INFORMACIÓN BD", "Se ha creado un listado(ArrayList) con los pedidos de la tabla pedidos.");
        }
        return listadoPedidos;
    }

    public Cursor ConsultarUsuPas (String usu, String pass) {
        Cursor mcursor=null;
        mcursor=this.getReadableDatabase().query("personas", new String[]{"_id", "nombre", "apellido1", "apellido2", "email", "usuario", "password", "cliente"},"usuario like '"+usu+"' and password like '"+pass+"'", null, null, null, null);
        return mcursor;
    }

}

