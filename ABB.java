package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2

public class ABB<T extends Comparable<T>> implements Conjunto<T> {

    // Agregar atributos privados del Conjunto

    private Nodo raiz;
    private int cardinal;
    private int altura;

    private class Nodo {

        // Agregar atributos privados del Nodo
        // Crear Constructor del nodo
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;

        Nodo (T v) {
            valor = v;
            izq = null;
            der = null;
            padre = null;
        }
    }

    public ABB() {
        raiz = null;
        cardinal = 0;
        altura = 0;
    }

    public int cardinal() {
        return cardinal;
    }

    public T minimo(){
        Nodo actual = raiz;
        while (actual.izq != null){
            actual = actual.izq;
        }
        return actual.valor;
    }

    public T maximo(){
        Nodo actual = raiz;
        while (actual.der != null){
            actual = actual.der;
        }
        return actual.valor;
    }

    public void insertar(T elem){

    if (raiz != null){
        Nodo actual = raiz;
        
        while(actual != null){   
            
            if ((actual.valor).compareTo(elem) > 0){
            actual = actual.der;
            }else{
                actual = actual.izq;
            }
        }

        if ((elem).compareTo(actual.padre.valor) > 0){
            actual.padre.der = new Nodo(elem);
        }
        else{
            actual.padre.izq = new Nodo(elem);
        }
    }
    else{
        Nodo nuevo = new Nodo(elem);
        raiz = nuevo;
    }
    }

    public boolean pertenece(T elem){
        Nodo actual = raiz;
        while(actual != null){
            if ((actual.valor).compareTo(elem) > 0){
                actual = actual.izq;
            }
            else{
                actual = actual.der;
            }
            if (actual.valor == elem){
                return true;
            }
        }
        return false;
    }

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
