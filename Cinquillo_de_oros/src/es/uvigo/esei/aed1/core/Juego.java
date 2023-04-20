/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega). 
 * Se recomienda una implementación modular.
 */

package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.IU;
import java.util.*;


public class Juego{
    
    private final IU iu;
    Baraja laBaraja;
    private List <Jugador> jugadores;
    
    public Juego(IU iu){
        this.iu = iu;
        laBaraja = new Baraja();
        jugadores = new LinkedList<>();
        

    }
    
    private void barajarYRepartir(int numJugadores){
        laBaraja.barajarBaraja();
        for(Jugador jugador : jugadores){
            for (int i = 0; i < 48/numJugadores; i++) {
                jugador.agregarCartaAMano(laBaraja.sacarCartaDeArriba());
            }
        }        
    }
    
    public boolean comprobarSiTieneCartas(Jugador j, Mesa m){
        boolean toret = false;
        List<Carta> cartas = m.getCartasCandidatas(j);
        
        if(cartas.isEmpty()){
            System.out.println("No tienes cartas para poner. Saltando el turno");
        }else{
            System.out.println("Estas son tus cartas disponibles para colocar");
            int indice = 1;
            for(Carta c : cartas){
                System.out.print("Carta #" + indice + ": ");
                System.out.println(c);
            }
            toret = true;
            
            int indiceCarta; 
            
            do{
                indiceCarta = iu.leeNum("Que carta quieres poner (#): ");
            }while(indiceCarta < 1 || indiceCarta > cartas.size());
            
            Carta cartaElegida = cartas.get(indiceCarta - 1);
        }
        return toret;
    }
    
    private void mostrarDatos(Mesa mesaJuego, Jugador jugadorActual){
        System.out.println(mesaJuego);
        System.out.println(jugadorActual);        
    }
     
    public void jugar(){
        //Creación de baraja y colección de nombres de los jugadores
        Collection<String> nombresJugadores = iu.pedirDatosJugadores();     
        int numJugadores = nombresJugadores.size();
        
        //Creación de la lista de objetos Jugadores
        for(String nombre : nombresJugadores){
            jugadores.add(new Jugador(nombre));
        }
     
        //Barajar y asignar la mano a cada jugador
        barajarYRepartir(numJugadores);
        
        //Muestra en pantalla los jugadores y sus manos
        
        iu.mostrarJugadores(jugadores);
        
        //Se crea un numero random para seleccionar el jugador que empieza la partida
        Random random = new Random();
        
        int numeroAleatorio = random.nextInt(numJugadores) + 1;
        
        Jugador jugadorActual = jugadores.get(numeroAleatorio - 1);
        
        System.out.println("\nEmpieza la partida el jugador " + (numeroAleatorio) 
                + ". Que es: " + jugadorActual.getNombre());
        
        boolean terminoPartida = false;
        
        Mesa mesaJuego = new Mesa();
                
        while(!terminoPartida){
            mostrarDatos(mesaJuego, jugadorActual);
            
            if(comprobarSiTieneCartas(jugadorActual, mesaJuego)){
                
            }
        }
        
    }
}
