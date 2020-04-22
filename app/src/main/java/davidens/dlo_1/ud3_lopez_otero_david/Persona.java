package davidens.dlo_1.ud3_lopez_otero_david;



public class Persona {

    private long id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String usuario;
    private String password;
    private String cliente;

    public Persona () {}

    public Persona (long id, String nombre, String apellido1, String apellido2, String email, String usuario, String password, String cliente ) {

        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.usuario = usuario;
        this.password = password;
        this.cliente=cliente;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }


    @Override
    public String toString () {

        return nombre;

    }
}