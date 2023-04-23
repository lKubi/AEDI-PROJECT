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
    private Mesa mesaJuego;
    
    public Juego(IU iu){
        this.iu = iu;
        laBaraja = new Baraja();
        jugadores = new LinkedList<>();
        mesaJuego = new Mesa();
    }
    
    /**
     * Metodo al que se le pasa el numero de jugadores y les reparte las cartas 
     * correspondientes a su mano
     * 
     * @param numJugadores 
     */
    private void barajarYRepartir(int numJugadores){
        laBaraja.barajarBaraja();
        for(Jugador jugador : jugadores){
            for (int i = 0; i < 48/numJugadores; i++) {
                jugador.agregarCartaAMano(laBaraja.sacarCartaDeArriba());
            }
        }        
    }
    
    /**
     * Metodo que mira si un jugador tiene cartas en su mano para colocar en 
     * la mesa
     * 
     * @param j Jugador al que se le revisa la mano
     * @return Devuelve True si el juegador tiene cartas para colocar y False si no
     */
    public boolean tieneCartasParaJugar(Jugador j){
        return !mesaJuego.getCartasCandidatas(j).isEmpty();
    }
    
    /**
     * Metodo usado para procesar el turno de un jugador que TIENE cartas para colocar
     * en la mesa
     * 
     * @param j Jugador que juega
     */
    public void procesarTurno(Jugador j){
        //Tomo las cartas que puede colocar y se las muestro
        List<Carta> cartas = mesaJuego.getCartasCandidatas(j);

        System.out.println("\nEstas son tus cartas disponibles para colocar");
        int indice = 1;
        for(Carta c : cartas){
            System.out.print("Carta #" + indice + ": ");
            System.out.println(c);
            indice++;
        }

        int indiceCarta; 
        //Pido que elija un indice valido de una carta candidata
        do{
            indiceCarta = iu.leeNum("Que carta quieres poner (#): ");
            if (indiceCarta < 1 || indiceCarta > cartas.size()) {
                System.out.println("Indice no valido!");
            }
        }while(indiceCarta < 1 || indiceCarta > cartas.size());

        //Cuando tengo la carta elegida, la coloco en la mesa y la saco de la
        //del jugador
        Carta cartaElegida = cartas.get(indiceCarta - 1);
        mesaJuego.colocarCartaMesa(cartaElegida);
        j.sacarCartaDeMano(cartaElegida);
    }
    
    /**
     * Metodo usado para mostrar el estado actual de la partida en cada turno
     * de juego
     * 
     * @param jugadorActual Jugador que tiene el turno de juego
     */
    private void mostrarDatos(Jugador jugadorActual){
        System.out.println(mesaJuego);
        System.out.println("Es el turno de: " + jugadorActual.getNombre());
        System.out.println("Esta es tu mano: ");
        System.out.println(jugadorActual.getMano());
    }
    
    /**
     * Metodo usado para cambiar al jugador actual cuando un jugador acaba su 
     * turno de juego (Ya sea por colocar carta o porque no tiene cartas para colocar) 
     * 
     * @param j Jugador Actual
     * @param jugadores Lista de jugadores
     * @return Nuevo jugador Actual
     */
    public Jugador cambiarTurno(Jugador j, List <Jugador> jugadores){
        //Tomo el indice del jugador actual y del jugador siguiente
        int indiceActual = jugadores.indexOf(j);
        int indiceSigiuente = indiceActual + 1;
        
        //Si el indice del jugador siguiente esta fuera del rango del tamaño
        //de la lista de jugadores, asigno el valor 0, porque se entiende, que se vuelve
        //al jugador 0
        if (indiceSigiuente >= jugadores.size()){
            indiceActual = 0;
        }else{
            indiceActual++;
        }
        
        //Devuelvo el jugador que está en la posición del indice nuevo
        Jugador devolver = jugadores.get(indiceActual);
        return devolver;
    }
    
    /**
     * Metodo usado al final de la partida para mostrar que ha terminado y
     * que jugador ha ganado
     * @param j 
     */
    public void mostrarGanador(Jugador j){
        
        System.out.println("\n\nLa partida ha finalizado.\n");
        String texto = j.getNombre() + " ha ganado!";
        int longitud = texto.length();

        StringBuilder sb = new StringBuilder();
        
        String colorFuera = "\u001B[32m";
        String colorNombre = "\u001B[33m";
        
        sb.append(colorFuera).append("#".repeat(longitud + 10 )).append("\n");
        sb.append(colorFuera).append("#").append(" ".repeat(longitud + 8)).append("#\n");
        sb.append("#").append(" ".repeat(4)).append(colorNombre).append(texto).append(colorFuera)
                .append(" ".repeat(4)).append("#\n");
        sb.append(colorFuera).append("#").append(" ".repeat(longitud + 8)).append("#\n");
        sb.append(colorFuera).append("#".repeat(longitud + 10 )).append("\n");
         
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

        //Creo una variable booleana para el control del fin de la partida y creo la mesa
        boolean terminoPartida = false;
        
        System.out.println("==================================================");
        
        //El jugadorGanador esta guardado como null para que no de error el 
        //return y poder asignarlo dentro del while()
        Jugador jugadorGanador = null;
               
        while(!terminoPartida){
            //En cada turno muestro los datos de la partida
            mostrarDatos(jugadorActual);
            
            //Si el jugador actual tiene cartas para jugar, se procesa su turno
            //Si no tiene cartas para jugar, le da el mensaje y cambia el turno
            if(tieneCartasParaJugar(jugadorActual)){
                procesarTurno(jugadorActual);
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
        
        //Mostramos el fin de la partida y al jugador ganador
        mostrarGanador(jugadorGanador);
    }
}
