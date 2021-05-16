/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tienda;

import java.util.TreeSet;

/**
 *
 * @author Brayan Guerrero 1151983
 */
public class Tienda {

    TreeSet<Producto> set;
    private double cantidadCaja;

    public Tienda() {
        set = new TreeSet<>();
        cantidadCaja = 1000;
    }

    public double getCantidadCaja() {
        return cantidadCaja;
    }

    public void setCantidadCaja(double cantidadCaja) {
        this.cantidadCaja += cantidadCaja;
    }

    public boolean venderProducto(String nombre, int cantidad) {
        boolean vendido = false;
        double dineroGanado = 0.0;
        for (Producto p : set) {
            if (p.getNombre().equals(nombre) && p.getCantidadActual() >= cantidad) {
                //Guardar la cantidad de vendidos
                p.setCantidadVendidos(cantidad);
                //Hacer un pedido si la cantidad actual es menor a la minima
                if (p.getCantidadActual() <= p.getCantidadMinima()) {
                    this.hacerPedidoProducto(nombre, 10);
                }
                //Decision del tipo de producto para su respectiva venta
                switch (p.getTipo()) {
                    case 1 -> {
                        dineroGanado = (cantidad) + (cantidad * 0.16);
                        this.setCantidadCaja(dineroGanado);
                    }
                    case 2 -> {
                        dineroGanado = (cantidad) + (cantidad * 0.04);
                        this.setCantidadCaja(dineroGanado);
                    }
                    case 3 -> {
                        dineroGanado = (cantidad) + (cantidad * 0.12);
                        this.setCantidadCaja(dineroGanado);
                    }
                    default -> {
                        break;
                    }
                }
                vendido = true;
                break;
            }
        }
        return vendido;
    }

    public boolean hacerPedidoProducto(String nombre, int cantidad) {
        boolean respuesta = false;
        if (this.existeProducto(nombre)) {
            for (Producto p : set) {
                if (p.getNombre().equals(nombre) && p.getCantidadActual() <= p.getCantidadMinima()) {
                    //Proceso para aumentar la cantidad del producto
                    for (int i = 0; i < cantidad; i++) {
                        if (this.cantidadCaja >= (p.getPrecioBase() / 2)) {
                            p.setCantidadActual(1);
                            cantidadCaja -= (p.getPrecioBase() / 2);
                            respuesta = true;
                        } 
                        else break;
                    }
                    break;
                }
            }
        }
        else{
            System.out.println("No existe este producto");
        }
        return respuesta;
    }

    public Producto productoMasVendido() {
        Producto aux = null;
        int num = 0;
        for (Producto p : set) {
            if (p.getCantidadVendidos() > num) {
                aux = p;
                num = p.getCantidadVendidos();
            }
        }
        return aux;
    }

    public double promedioVentas() {
        int suma = 0;
        for (Producto p : set) {
            suma += p.getCantidadVendidos();
        }
        return (cantidadCaja / suma);
    }

    private boolean existeProducto(String nombre) {
        boolean respuesta = false;
        for (Producto p : set) {
            if (p.getNombre().equals(nombre)) {
                respuesta = true;
                break;
            }
        }
        return respuesta;
    }
    
    public boolean agregarProducto(String nombre, int tipo, int precioBase){
        return set.add(new Producto(nombre,tipo,0,precioBase));
    }
    
    public void estadoTienda(){
        System.out.println("La cantidad de dinero en caja es: "+this.cantidadCaja);
        System.out.println("---------------------------------");
        System.out.println("Y los productos son los siguientes:");
        for(Producto p : set){
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        Tienda t = new Tienda();
        t.agregarProducto("DeTodito", 1, 10);
        t.hacerPedidoProducto("DeTodito", 10);
        t.estadoTienda();
    }
}
