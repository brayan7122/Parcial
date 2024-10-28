import java.util.ArrayList;
import java.util.List;

public abstract class Producto {
    private String nombre;
    private String marca;
    private double precio;
    private double cant_stock;

    public Producto() {
    }

    public Producto(String nombre, String marca, double precio, double cant_stock) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.cant_stock = cant_stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", Cant_stock=" + cant_stock +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCant_stock() {
        return cant_stock;
    }

    public void setCant_stock(double cant_stock) {
        this.cant_stock = cant_stock;
    }

    public void mostrar_det() {
        System.out.println("Marca: " + getMarca() + ", Nombre: " + getNombre() +
                ", Precio: " + getPrecio() + ", Stock: " + getCant_stock());
    }

    public void mostrarDetalles() {

    }
}

class Laptop extends Producto implements Vendible {
    private String procesador;
    private double RAM;

    public Laptop(String nombre, String marca, double precio, double cant_stock, String procesador, double RAM) {
        super(nombre, marca, precio, cant_stock);
        this.procesador = procesador;
        this.RAM = RAM;
    }

    @Override
    public void mostrarDetalles() {
        mostrar_det();
        System.out.println("Procesador: " + procesador + ", RAM: " + RAM);
    }

    @Override
    public double calcularpre_venta(int cantidad) {
        double total = getPrecio() * cantidad;
        if (cantidad = 5) {
            total *= 0.9;
        }
        return total;
    }
}

class Celular extends Producto implements Vendible {
    private double capacidadBateria;
    private double resolucionCamara;

    public Celular(String nombre, String marca, double precio, double cant_stock, double capacidadBateria, double resolucionCamara) {
        super(nombre, marca, precio, cant_stock);
        this.capacidadBateria = capacidadBateria;
        this.resolucionCamara = resolucionCamara;
    }

    @Override
    public void mostrarDetalles() {
        mostrar_det();
        System.out.println("Capacidad Batería: " + capacidadBateria + "de capacidad, Resolución Cámara: " + resolucionCamara + "pixeles");
    }

    @Override
    public double calcularpre_venta(int cantidad) {
        double total = getPrecio() * cantidad;
        if (cantidad > 5) {
            total *= 0.9;
        }
        return total;
    }
}

interface Vendible {
    double calcularpre_venta(int cantidad);
}

class Cliente {
    private String nombre;
    private String correo;
    private List<Producto> compras;

    public Cliente(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
        this.compras = new ArrayList<>();
    }

    public void comprarpro(Producto producto, int cantidad) {
        if (producto.getCant_stock() >= cantidad) {
            producto.setCant_stock(producto.getCant_stock() - cantidad);
            compras.add(producto);
            System.out.println(nombre + " ha comprado " + cantidad + " unidades de " + producto.getNombre());
        } else {
            System.out.println("Stock insuficiente para " + producto.getNombre());
        }
    }

    public void mostrarCompra() {
        double totalCompra = 0;
        System.out.println("Compra realizada por:  " + nombre);
        for (Producto producto : compras) {
            int cantidadComprada = 1;
            double precioven = ((Vendible) producto).calcularpre_venta(cantidadComprada);
            totalCompra += precioven;
            producto.mostrarDetalles();
            System.out.println("Precio: " + precioven);
        }
        System.out.println("Total de la compra: " + totalCompra);
    }
}

