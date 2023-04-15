/*
* Representa la Mesa de juego. 
* Estructura: se utilizar� un TAD adecuado. Piensa que hay 4 palos y de cada palo se pueden colocar cartas 
* por cualquiera de los dos extremos (un array con 4 doblescolas parece lo más adecuado). La DobleCola se comento en clase de teoria
* Funcionalidad: saber si es posible colocar una carta en la mesa, colocar una carta en la mesa, mostrar la mesa
 */
package es.uvigo.esei.aed1.core;
import java.util.*;


public class Mesa {

    // Array de deques que representa la mesa para cada palo
    private Deque<Integer>[] mesa;
    
    //constructor
    public Mesa(){
        mesa = new Deque[4];
    }

    //Añadir más funcionalidades
    
    //Estas 2 cabeceras de funciones las añadí yo (Luis) para que se implementen, 
    //saco la idea de las funciones, de la cabecera de la clase
    
    //Saber si es posible colocar una carta en la mesa
//    public boolean comprobarSiSePuedenPonerCartas(Jugador j){
//        
//    }
    
    //colocar una carta en la mesa
//    public void colocarCartaMesa(Carta c){
//        
//    }

    
    // mostrar el estado de la mesa
//    @Override
//    public String toString(){
//        
//    }
	
    
}
