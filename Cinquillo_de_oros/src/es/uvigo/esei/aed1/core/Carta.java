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

    public int getNumero() {
        return numero;
    }

    public Palos getPalo() {
        return palo;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append(numero).append("/").append(palo);
        
        return sb.toString();
    }
    
}
