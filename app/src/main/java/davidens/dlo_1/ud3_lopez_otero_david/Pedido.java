package davidens.dlo_1.ud3_lopez_otero_david;



public class Pedido {

    private long id_pedido;
    private String categoria;
    private String producto;
    private int cantidad;


    public Pedido () {}

    public Pedido (long id_pedido, String categoria, String producto, int cantidad) {

        this.id_pedido = id_pedido;
        this.categoria = categoria;
        this.producto = producto;
        this.cantidad = cantidad;


    }

    public long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }




    @Override
    public String toString () {

        return categoria;

    }
}
