/*
 * Representa a un jugador, identificado por el nombre y sus cartas de la mano
 * Estructura mano: se utilizará un TAD adecuado
 * Funcionalidad: Añadir carta a la mano, convertir a String el objeto Jugador (toString)
 */

package es.uvigo.esei.aed1.core;
import java.util.*;



public class Jugador {
    
    private final String nombre;
    private final List<Carta> mano;
    private int numCartasMano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new LinkedList<>();
        this.numCartasMano = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumCartasMano() {
        return numCartasMano;
    }
    
    /**
     * Agrega una carta a la mano del jugador
     * @param c 
     */
    public void agregarCartaAMano(Carta c){
        this.mano.add(c);
        this.numCartasMano++;
    }
    
    /**
     * Saca una carta de la mano del jugador
     * @param c
     * @return carta sacada de la mano
     */
    public boolean sacarCartaDeMano(Carta c){
        this.numCartasMano--;
        return this.mano.remove(c);
    }
    
    /**
     * Metodo que devuelve las cartas que un jugador puede poner en la mesa actual
     * @param j Jugador Actual
     * @return Una lista con las cartas posibles a colocar
     */
    public List<Carta> getCartasCandidatas(Mesa m){
        //Creo una lista vacia
        List <Carta> listaCartas = new LinkedList<>();
        
        //Por cada carta en la mano, voy comprobandosi se puede añadir o no
        //Si se puede añadir, la agrego a la lista nueva
        for (Carta c : this.mano){
            if (m.sePuedePonerCarta(c)){
                listaCartas.add(c);
            }
        }
        
        return listaCartas;
    }    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Mano: ").append(mano);
        return sb.toString();

    }
    
    
    
}
