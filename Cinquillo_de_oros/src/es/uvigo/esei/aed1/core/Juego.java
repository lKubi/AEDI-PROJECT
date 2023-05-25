/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega). 
 * Se recomienda una implementación modular.
 */

package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.IU;
import java.util.*;


public class Juego{
    
    private final IU iu;
    private final List <Jugador> jugadores;
    private final int PUNTOS_POR_PARTIDA;
    private int puntosAsOros;    
    private Baraja laBaraja;
    private Mesa mesaJuego;
    
    public Juego(IU iu){
        this.iu = iu;
        this.laBaraja = new Baraja();
        this.jugadores = new LinkedList<>();
        this.mesaJuego = new Mesa();
        this.puntosAsOros = 0;
        this.PUNTOS_POR_PARTIDA = 4;
    }
    
    /**
     * Metodo al que se le pasa el numero de jugadores y les reparte las cartas 
     * correspondientes a su mano
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
     * Metodo usado para procesar el turno de un jugador que TIENE cartas para colocar
     * en la mesa
     * @param j Jugador que juega
     */
    private void procesarTurno(Jugador j){
        //Cuando tengo la carta elegida, la coloco en la mesa y la saco de la mano
        //del jugador
        Carta cartaElegida = iu.elegirCartaColocar(j, mesaJuego);
        //Compruebo si la carta es el As de Oros para sumarle los puntos al jugador
        if(cartaElegida.getPalo() == Carta.Palos.OROS && cartaElegida.getNumero() == 1){
            j.sumarPuntos(puntosAsOros);
        }
        mesaJuego.colocarCartaMesa(cartaElegida);
        j.sacarCartaDeMano(cartaElegida);
        
    }
    
    /**
     * Metodo usado para cambiar al jugador actual cuando un jugador acaba su 
     * turno de juego (Ya sea por colocar carta o porque no tiene cartas para colocar) 
     * @param j Jugador Actual
     * @param jugadores Lista de jugadores
     * @return Nuevo jugador Actual
     */
    private Jugador cambiarTurno(Jugador j, List <Jugador> jugadores){
        //Tomo el indice del jugador actual y del jugador siguiente
        int indiceActual = jugadores.indexOf(j);
        int indiceSiguiente = indiceActual + 1;
        
        //Si el indice del jugador siguiente esta fuera del rango del tamaño
        //de la lista de jugadores, asigno el valor 0, porque se entiende, que se vuelve
        //al jugador 0
        if (indiceSiguiente >= jugadores.size()){
            indiceActual = 0;
        }else{
            indiceActual++;
        }
        
        //Devuelvo el jugador que está en la posición del indice nuevo
        Jugador devolver = jugadores.get(indiceActual);
        return devolver;
    }
        
    /**
     * Metodo que maneja todo el flujo de una partida
     * @param jugadorInicial jugador que empieza la partida
     * @return jugador ganador de la partida
     */
    private Jugador jugarTurnos(Jugador jugadorInicial){
        
        Jugador jugadorActual = jugadorInicial;
        
        Jugador toret = null;
        
        //Creo una variable booleana para el control del fin de la partida y creo la mesa       
        
        boolean terminoPartida = false;
               
        while(!terminoPartida){
            
            //En cada turno muestro los datos de la partida
            iu.mostrarDatos(jugadorActual, mesaJuego);
            
            //Si el jugador actual tiene cartas para jugar, se procesa su turno
            //Si no tiene cartas para jugar, le da el mensaje y cambia el turno
            if(!jugadorActual.getCartasCandidatas(mesaJuego).isEmpty()){
                procesarTurno(jugadorActual);
            }else{
                iu.mostrarMensaje("No tienes cartas para colocar!");
            }
            
            //Entendemos que solo hay un ganador por partida, que es el jugador
            //al que primero se le acaban las cartas
            if(jugadorActual.getNumCartasMano() == 0){
                jugadorActual.sumarPuntos(PUNTOS_POR_PARTIDA);
                terminoPartida = true;
                toret = jugadorActual;
            }
            
            jugadorActual = cambiarTurno(jugadorActual, jugadores);
        }
        
        return toret;
        
    }
    
    /**
     * Función de los pasos comunes de una partida
     * @return verdadero si se puso el As de Oros o falso en caso contrario
     */
    private boolean jugarPartida(){
        int numJugadores = jugadores.size();
        //Barajar y asignar la mano a cada jugador
        barajarYRepartir(numJugadores);

        //Muestra en pantalla los jugadores y sus manos
        iu.mostrarJugadores(jugadores);

        //Se crea un numero random para seleccionar el jugador que empieza la partida
        Random random = new Random();

        int numeroAleatorio = random.nextInt(numJugadores) + 1;

        Jugador jugadorInicial = jugadores.get(numeroAleatorio - 1);

        System.out.println("\nEmpieza la partida el jugador " + (jugadores.indexOf(jugadorInicial) + 1) 
                + ". Que es: " + jugadorInicial.getNombre());

        System.out.println("=".repeat(50));

        //En el método jugarTurnos se juega todo el juego hasta que un jugador se
        //queda sin cartas y ese es guardado como jugadorGanador
        Jugador jugadorGanador = jugarTurnos(jugadorInicial);

        //Mostramos el fin de la partida y al jugador ganador
        iu.mostrarGanador(jugadorGanador, mesaJuego);
        
        return mesaJuego.estaAsDeOros();
  
    }  
    
    /**
     * Función utilizada para controlar el flujo del Juego
     */
    private void jugarJuego(){
        do{
            iu.siguienteJuego();
            puntosAsOros += 2;
            mesaJuego = new Mesa();
            laBaraja = new Baraja();
            for(Jugador j : jugadores){
                j.limpiarMano();
            }
        //Se juegan partidas hasta que esté el As de Oros, que es lo que devuelve
        //el método jugarPartida()
        }while(!jugarPartida());
        
    }
     
    /**
     * Función principal del juego, donde se llaman a las funciones modulares
     * del juego y de la(s) partidas
     */
    public void jugar(){
        //Creación de baraja y colección de nombres de los jugadores
        Collection<String> nombresJugadores = iu.pedirDatosJugadores();     
        
        //Creación de la lista de objetos Jugadores
        for(String nombre : nombresJugadores){
            jugadores.add(new Jugador(nombre));
        }
     
        jugarJuego();
        
        iu.mostrarGanadorPorPuntos(jugadores);
    }
}
