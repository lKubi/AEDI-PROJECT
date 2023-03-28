/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega). 
 * Se recomienda una implementación modular.
 */

package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.IU;
import java.util.*;


public class Juego{
    private final IU iu;
    
    
    public Juego(IU iu){
        this.iu = iu;

    }

    public void jugar(){
        Baraja laBaraja = new Baraja();
        Jugador [] jugadores;
        Collection<String> nombresJugadores = iu.pedirDatosJugadores();
        jugadores = new Jugador[nombresJugadores.size()];
        int numJugadores = 0;
        for(String nombre : nombresJugadores){
            jugadores[numJugadores] = new Jugador(nombre);
            numJugadores++;
        }
    }

        
    
}
