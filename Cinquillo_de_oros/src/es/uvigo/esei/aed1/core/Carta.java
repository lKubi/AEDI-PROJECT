/*
 * Representa una carta, formada por un número y su palo correspondiente
 */


package es.uvigo.esei.aed1.core;

public class Carta {
    
    public static enum Palos{
        OROS, ESPADAS, BASTOS, COPAS
    }
    
    private int numero;
    private Palos palo;

    public Carta(int numero, Palos palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    public Palos getPalo() {
        return palo;
    }
    
    

}
