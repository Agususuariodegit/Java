package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    
    private Nodo primero;
    private Nodo ultimo;
    private int size;
    private T[] elementos;

    private class Nodo {
        int valor;
        Nodo sig;
        Nodo ant;
    } 
    
    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        size = 0; 
    }

    public int longitud() {
        return size;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        nuevo.sig = primero;
        nuevo.ant = null;
        primero = nuevo;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primero == null){
            primero = nuevo;
        } else {
            ultimo.sig = nuevo;
            nuevo.ant = ultimo;
            ultimo = nuevo;
        }
    }

    public T obtener(int i) {
        Nodo actual = primero;
        j = 0; 
        while (j < i) {
            actual = primero.sig;
            j = j + 1;
        }
        return actual.valor;
    }

    public void eliminar(int i) {
        Nodo actual = primero;
        j = 0;
        while (j < i) {
            actual = primero.sig;
            j = j + 1;
        }
        actual = null;

    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        j = 0;
        while (j < indice) {
            actual = primero.sig;
            j = j + 1;
        }
        actual.ant.sig = actual.sig;
        actual.sig.ant = actual.ant;
        actual = null;  
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        Nodo actual = lista.primero;
        while (actual != null) {
            agregarAtras(actual.valor);
            actual = actual.sig;
        }
    }           
    
    @Override
    public String toString() {
        String res = "[";
        Nodo actual = primero;
        if (size == 1) {
            return "[" + actual.valor + "]";
        }
        else {
            while (actual != null && actual != ultimo) {
                res = res + actual.valor + ",";
                actual = actual.sig; 
            }
            res = res + ultimo.valor + "]";
            }
        return res;
        }

    private class ListaIterador implements Iterador<T> {

        int indice;
        
        Iterador(){
            indice = 0;
        }
        
        public boolean haySiguiente() {
            return indice > -1 && indice < size;
        }
    
        public boolean hayAnterior() {
            return indice < size && indice > 0;
        }

        public T siguiente() {
	        int i = indice;
            indice = indice + 1;
            return elementos[i];
        }
        

        public T anterior() {
	        int i = indice;
            indice = indice - 1;
            return elementos[i];
        }
    }

    public Iterador<T> iterador() {
	   return new Iterador();
    }

}
