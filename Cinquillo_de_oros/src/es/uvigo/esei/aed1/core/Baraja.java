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
        for (int i = 1; i <= 12; i++) {
            for (int j = 0; j < 4; j++) {
                    this.baraja.push(new Carta(i, palos[j]));
            }
        }
            
    }
    
    public void barajarBaraja(){
        Collections.shuffle(this.baraja);
    }
    
    public Carta sacarCartaDeArriba(){
        return baraja.pop();
    }
    
   
}
