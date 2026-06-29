package modelo;

public class Material extends Producto {

    public Material(int id, String nombre, int stock, double precio) {
        super(id, nombre, stock, precio);
    }

    @Override
    public void mostrarInfo() {
        System.out.println(
                "ID: " + getId()
                + " | Material: " + getNombre()
                + " | Stock: " + getStock()
                + " | Precio: $" + getPrecio());
    }
}