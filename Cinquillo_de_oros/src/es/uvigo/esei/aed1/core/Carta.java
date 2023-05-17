/*
 * Representa una carta, formada por un número y su palo correspondiente
 */


package es.uvigo.esei.aed1.core;

public class Carta {
    
    public static enum Palos{
        OROS, COPAS, ESPADAS, BASTOS
    }
    
    private final int numero;
    private final Palos palo;

    public Carta(int numero, Palos palo) {
        this.numero = numero;
        this.palo = palo;
    }

    /**
     * Función para devolver el numero de una carta
     * @return 
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Función para devolver el Palo de una carta
     * @return 
     */
    public Palos getPalo() {
        return palo;
    }
    
    /**
     * Función para mostrar los atributos de una carta
     * @return 
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append(numero).append("/").append(palo);
        
        return sb.toString();
    }
    
}
