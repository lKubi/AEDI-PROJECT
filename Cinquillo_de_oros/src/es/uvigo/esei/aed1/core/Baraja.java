/*
* Representa la baraja española pero con 8 y 9, en total 48 cartas, 4 palos, valores de las cartas de 1 a 12. 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: barajar las cartas, devolver la carta situada encima del montón de cartas
 */

package es.uvigo.esei.aed1.core;
import java.util.*;


public class Baraja {
    
    private final Carta.Palos palos [] = Carta.Palos.values();
    private final Stack<Carta> baraja;
    
    private final int NUM_PALOS = 4;
    private final int NUM_CARTAS_POR_PALO = 12;
    
    public Baraja(){
        this.baraja = new Stack<>();
        
        for (int i = 0; i < NUM_PALOS; i++) {
            for (int j = 1; j <= NUM_CARTAS_POR_PALO; j++) {
                    this.baraja.push(new Carta(j, palos[i]));
            }
        }
    }

    /**
     * Baraja la baraja
     */
    public void barajarBaraja(){
        Collections.shuffle(this.baraja);
    }
    
    /**
     * Saca la carta de arriba de la pila de la baraja
     * @return devuelve la carta de arriba y la saca de la pila
     */
    public Carta sacarCartaDeArriba(){
        return baraja.pop();
    }
    
   
}
