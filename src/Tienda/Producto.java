/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tienda;

/**
 * 
 * @author Brayan Guerrero 1151983
 */
public class Producto {
    //Propiedades del producto
    private String nombre;
    private int tipo;
    private int cantidadActual;
    private int cantidadMinima = 3;
    private double precioBase;
    private int cantidadVendidos;

    public Producto(String nombre, int tipo, int cantidadActual, double precioBase) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidadActual = cantidadActual;
        this.precioBase = precioBase;
        this.cantidadVendidos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual += cantidadActual;
    }

    public  int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getCantidadVendidos() {
        return cantidadVendidos;
    }

    public void setCantidadVendidos(int cantidadVendidos) {
        this.cantidadVendidos += cantidadVendidos;
        this.cantidadActual -= cantidadVendidos;
    }
    
    @Override 
    public int hashCode(){
        return nombre.hashCode();
    }
    
    @Override
    public boolean equals(Object otro){
        if(otro.getClass()!=Producto.class)return false;
        Producto otroItem = (Producto)otro;
        if(this.nombre.equals(otroItem.nombre))return true;
        return this.nombre != null 
                && this.nombre.equals(otroItem.nombre);
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", tipo=" + tipo + ", cantidadActual=" + cantidadActual + ", precioBase=" + precioBase + ", cantidadVendidos=" + cantidadVendidos + '}';
    }
}
