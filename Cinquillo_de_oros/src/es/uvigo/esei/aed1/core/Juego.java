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
    
    public boolean tieneCartasParaJugar(Jugador j, Mesa m){
        return !m.getCartasCandidatas(j).isEmpty();
    }
    
    
    public void procesarTurno(Jugador j, Mesa m){
        List<Carta> cartas = m.getCartasCandidatas(j);

        System.out.println("\nEstas son tus cartas disponibles para colocar");
        int indice = 1;
        for(Carta c : cartas){
            System.out.print("Carta #" + indice + ": ");
            System.out.println(c);
            indice++;
        }

        int indiceCarta; 

        do{
            indiceCarta = iu.leeNum("Que carta quieres poner (#): ");
            if (indiceCarta < 1 || indiceCarta > cartas.size()) {
                System.out.println("Indice no valido!");
            }
        }while(indiceCarta < 1 || indiceCarta > cartas.size());

        Carta cartaElegida = cartas.get(indiceCarta - 1);

        m.colocarCartaMesa(cartaElegida);
        j.getMano().remove(cartaElegida);

    }
    
    
    private void mostrarDatos(Mesa mesaJuego, Jugador jugadorActual){
        System.out.println(mesaJuego);
        System.out.println("Es el turno de: " + jugadorActual.getNombre());
        System.out.println("Esta es tu mano: ");
        System.out.println(jugadorActual.getMano());
    }
    
    public Jugador cambiarTurno(Jugador j, List <Jugador> jugadores){
        int indiceActual = jugadores.indexOf(j);
        int indiceSigiuente = indiceActual + 1;
        
        if (indiceSigiuente >= jugadores.size()){
            indiceActual = 0;
        }else{
            indiceActual++;
        }
        
        Jugador devolver = jugadores.get(indiceActual);
        return devolver;
    }
    
    public void mostrarGanador(Jugador j){
        
        System.out.println("\n\nLa partida ha finalizado.\n");
        String texto = j.getNombre() + " ha ganado!";
        int longitud = texto.length(); // Longitud total de la línea de caracteres

        StringBuilder sb = new StringBuilder();
        
        sb.append("#".repeat(longitud + 10 )).append("\n");
        sb.append("#").append(" ".repeat(longitud + 8)).append("#\n");
        sb.append("#").append(" ".repeat(4)).append(texto).append(" ".repeat(4)).append("#\n");
        sb.append("#").append(" ".repeat(longitud + 8)).append("#\n");
        sb.append("#".repeat(longitud + 10 )).append("\n");
        
        System.out.println(sb.toString());
                
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
        
        System.out.println("==================================================");
        
        Jugador jugadorGanador = null;
               
        while(!terminoPartida){
            mostrarDatos(mesaJuego, jugadorActual);
            
            if(tieneCartasParaJugar(jugadorActual, mesaJuego)){
                procesarTurno(jugadorActual, mesaJuego);
            }else{
                System.out.println("No tienes cartas para colocar!");
            }
            
            //Entendemos que solo hay un ganador por partida, que es el jugador
            //al que primero se le acaban las cartas
            if(jugadorActual.getMano().isEmpty()){
                jugadorGanador = jugadorActual;
                terminoPartida = true;
            }
            
            jugadorActual = cambiarTurno(jugadorActual, jugadores);
        }

        mostrarGanador(jugadorGanador);
    }
}
