/*
 * Representa a un jugador, identificado por el nombre y sus cartas de la mano
 * Estructura mano: se utilizará un TAD adecuado
 * Funcionalidad: Añadir carta a la mano, convertir a String el objeto Jugador (toString)
 */

package es.uvigo.esei.aed1.core;
import java.util.*;



public class Jugador{
    
    private String nombre;
    private List<Carta> mano;
    private int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new LinkedList<>();
        this.puntos = 0;
    }

    /**
     * Función para obtener el nombre de un jugador
     * @return nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Función para obtener el numero de cartas en la mano del jugador
     * @return tamaño de la mano
     */
    public int getNumCartasMano() {
        return mano.size();
    }
    
    /**
     * Función para obtener los puntos de un jugador
     * @return puntos
     */
    public int getPuntos(){
        return this.puntos;
    }
    
    /**
     * Funcion que suma los puntos que se le pasan como parametro al atributo del jugador
     * @param puntosSumar 
     */
    public void sumarPuntos(int puntosSumar){
        this.puntos += puntosSumar;
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
    
    /**
     * Función que elimina la mano del jugador y le da una mano vacia
     */
    public void limpiarMano(){
        this.mano = new LinkedList<>();
    }
    
    /**
     * Metodo que devuelve las cartas que un jugador puede poner en la mesa actual
     * @param m Mesa de juego
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

    /**
     * Metodo toString() para mostrar al jugador
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append("\n");
        sb.append("Mano: ").append(mano);
        return sb.toString();

    }
    
}
