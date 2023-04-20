/*
* Representa la Mesa de juego. 
* Estructura: se utilizar� un TAD adecuado. Piensa que hay 4 palos y de cada palo se pueden colocar cartas 
* por cualquiera de los dos extremos (un array con 4 doblescolas parece lo más adecuado). La DobleCola se comento en clase de teoria
* Funcionalidad: saber si es posible colocar una carta en la mesa, colocar una carta en la mesa, mostrar la mesa
 */
package es.uvigo.esei.aed1.core;
import java.util.*;
import es.uvigo.esei.aed1.core.*;


public class Mesa {

    // Array de deques que representa la mesa para cada palo
    private Deque<Carta>[] mesa;
    private final int numPalos = 4;
    
    //constructor
    public Mesa(){
        mesa = new Deque[numPalos];
    }

    public int getNumPalos() {
        return numPalos;
    }
    
    //Devuelve una lista con las posibles cartas a colocar
    public List<Carta> getCartasCandidatas(Jugador j){
        List <Carta> listaCartas = new LinkedList<>();
        
        for(Carta c : j.getMano()){
            if(sePuedePonerCarta(c)){
                listaCartas.add(c);
            }
        }
        
        return listaCartas;
    }
    //Comprueba si una carta se puede colocar en la mesa
    public boolean sePuedePonerCarta(Carta c){
        boolean toret = false;
        int paloCarta = c.getPalo().ordinal();
        int numeroArribaPalo = mesa[paloCarta].getFirst().getNumero();
        int numeroAbajoPalo = mesa[paloCarta].getLast().getNumero();
        
        if(numeroArribaPalo == (c.getNumero() - 1)){
            toret = true;
        }else if(numeroAbajoPalo == (c.getNumero() + 1)){
            toret = true;
        }
        return toret;
    }
    
    //colocar una carta en la mesa
    public void colocarCartaMesa(Carta c){

        int paloCarta = c.getPalo().ordinal();
        int numeroArribaPalo = mesa[paloCarta].getFirst().getNumero();
        int numeroAbajoPalo = mesa[paloCarta].getLast().getNumero();
        
        if(numeroArribaPalo == (c.getNumero() - 1)){
            mesa[paloCarta].addFirst(c);
        }else if(numeroAbajoPalo == (c.getNumero() + 1)){
            mesa[paloCarta].addLast(c);
        }
    }

    
    // mostrar el estado de la mesa
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numPalos; i++) {
            
        }
        
        return sb.toString();
    }
	
    
}
