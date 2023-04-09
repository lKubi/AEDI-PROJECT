/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega). 
 * Se recomienda una implementación modular.
 */

package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.IU;
import java.util.*;


public class Juego{
    private final IU iu;
    
    List<Jugador> jugadores;
    
    public Juego(IU iu){
        this.iu = iu;

    }

    public void jugar(){
        //Creación de baraja y colección de nombres de los jugadores
        Baraja laBaraja = new Baraja();
        Collection<String> nombresJugadores = iu.pedirDatosJugadores();     
        int numJugadores = nombresJugadores.size();
        
        //Creación de la lista de objetos Jugadores
        jugadores = new LinkedList<>();
        for(String nombre : nombresJugadores){
            jugadores.add(new Jugador(nombre));
        }
     
        //Barajar y asignar la mano a cada jugador
        laBaraja.barajarBaraja();
        for(Jugador jugador : jugadores){
            for (int i = 0; i < 48/numJugadores; i++) {
                jugador.agregarCartaAMano(laBaraja.sacarCartaDeArriba());
            }
        }
        
        //Muestra en pantalla los jugadores y sus manos
        
        iu.mostrarJugadores(jugadores);
        
        //Se crea un numero random para seleccionar el jugador que empieza la partida
        Random random = new Random();
        
        int numeroAleatorio = random.nextInt(numJugadores) + 1;
        
        System.out.println("\nEmpieza la partida el jugador " + (numeroAleatorio) 
                + ". Que es: " + jugadores.get(numeroAleatorio-1).getNombre());
        
    }
}
