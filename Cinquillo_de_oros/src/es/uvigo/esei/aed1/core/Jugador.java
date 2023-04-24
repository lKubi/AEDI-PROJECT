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

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Carta> getMano() {
        return mano;
    }
    
    /**
     * Agrega una carta a la mano del jugador
     * @param c 
     */
    public void agregarCartaAMano(Carta c){
        this.mano.add(c);
    }
    
    /**
     * Saca una carta de la mano del jugador
     * @param c
     * @return carta sacada de la mano
     */
    public boolean sacarCartaDeMano(Carta c){
        return this.mano.remove(c);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Mano: ").append(mano);
        return sb.toString();

    }
    
    
    
}
