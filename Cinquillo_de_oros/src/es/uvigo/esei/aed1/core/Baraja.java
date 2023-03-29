/*
* Representa la baraja española pero con 8 y 9, en total 48 cartas, 4 palos, valores de las cartas de 1 a 12. 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: barajar las cartas, devolver la carta situada encima del montón de cartas
 */

package es.uvigo.esei.aed1.core;
import java.util.*;


public class Baraja {
    
    Carta.Palos palos [] = Carta.Palos.values();
    Stack<Carta> baraja = new Stack<>();
    
    
    public Baraja(){
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 12; j++) {
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
