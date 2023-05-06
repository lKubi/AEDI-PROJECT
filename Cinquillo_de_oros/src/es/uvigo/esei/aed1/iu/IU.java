/**
 * Representa la interfaz del juego del Cinquillo-Oro, en este proyecto va a ser una entrada/salida en modo texto 
 * Se recomienda una implementación modular.
 */

package es.uvigo.esei.aed1.iu;

import es.uvigo.esei.aed1.core.Carta;
import es.uvigo.esei.aed1.core.Jugador;
import es.uvigo.esei.aed1.core.Mesa;
import java.util.*;

public class IU {
    private final Scanner teclado;

    public IU() {
            teclado = new Scanner(System.in).useDelimiter("\r?\n");
    }

    /**
     * Lee un num. de teclado
     * 
     * @param msg El mensaje a visualizar.
     * @return El num., como entero
     */
    public int leeNum(String msg) {
        do {
                System.out.print(msg);

                try {
                        return teclado.nextInt();
                } catch (InputMismatchException exc) {
                        teclado.next();
                        System.out.println("Entrada no válida. Debe ser un entero.");
                }
        } while (true);
    }

    public String leeString(String msg) {
        System.out.print(msg);
        return teclado.next();
    }

    public String leeString(String msg, Object... args) {
        System.out.printf(msg, args);
        return teclado.next();
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarMensaje(String msg, Object... args) {
        System.out.printf(msg, args);
    }


    /**
     * Pide la cantidad de jugadores y sus nombres
     * 
     * @return Una colección con el nombre de los jugadores
     */
    public Collection<String> pedirDatosJugadores(){

        int cantJugadores = 0;
        
        //Compruebo que el dato introducido es valido
        do{
            cantJugadores = leeNum("Cuantos jugadores van a jugar? (3 o 4): ");
            if(cantJugadores != 3 && cantJugadores != 4){
                System.err.println("El valor introducido debe ser 3 o 4.");
            }
        }while(cantJugadores != 3 && cantJugadores != 4);
        
        //Creo la colección de los nombres de los jugadores
        Collection<String> nombresJugadores = new LinkedList<>();
        
        String entrada;
        
        for (int i = 1; i <= cantJugadores; i++) {
            entrada = leeString("Introduce el nombre del jugador " + i + ": ");
            
             // Compruebo que la cadena introducida no esté vacia
            
            while(entrada.isBlank()){
                entrada = leeString("\nLa cadena no puede estar vacia!\nIntroduce un nombre valido: ");
            }            
            //Añado el nombre a la colección
            nombresJugadores.add(entrada);
            
        }
        return nombresJugadores;
    }

    /**
     * Muestro el toString() del jugador pasado como parametro
     * @param jugador 
     */
    public void mostrarJugador(Jugador jugador){
        System.out.println(jugador);

    }

    /**
     * Muestro el toString() de cada jugador perteneciente a la lista jugadores
     * @param jugadores 
     */
    public void mostrarJugadores(Collection<Jugador> jugadores){
        int i = 0;
        for (Jugador jugador : jugadores) {
            System.out.println("Jugador # " + (i+1));
            System.out.println(jugador + "\n");
            i++;
        }

    }
    
    public void siguienteJuego() {
        String basura = leeString("Pulsa Enter para comenzar!\n\n");
    }       
    
    public Carta elegirCartaColocar(Jugador j, Mesa m){
        List<Carta> cartas = j.getCartasCandidatas(m);

        mostrarMensaje("\nEstas son tus cartas disponibles para colocar");
        int indice = 1;
        for(Carta c : cartas){
            System.out.print("Carta #" + indice + ": ");
            System.out.println(c);
            indice++;
        }

        int indiceCarta; 
        //Pido que elija un indice valido de una carta candidata
        do{
            indiceCarta = leeNum("Que carta quieres poner (#): ");
            if (indiceCarta < 1 || indiceCarta > cartas.size()) {
                System.out.println("Indice no valido!");
            }
        }while(indiceCarta < 1 || indiceCarta > cartas.size());
        
        return cartas.get(indiceCarta - 1);
    }
    
    /**
     * Metodo usado al final de la partida para mostrar que ha terminado y
     * que jugador ha ganado
     * @param j 
     */
    public void mostrarGanador(Jugador j, Mesa mesaJuego){
        
        System.out.println(mesaJuego);
        
        System.out.println("\n\nLa partida ha finalizado.\n");
        String texto = j.getNombre() + " ha ganado la partida!";
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

    /**
     * Metodo usado para mostrar el estado actual de la partida en cada turno
     * de juego
     * 
     * @param jugadorActual Jugador que tiene el turno de juego
     */
    public void mostrarDatos(Jugador jugadorActual, Mesa mesaJuego){
        System.out.println(mesaJuego);
        System.out.println("Es el turno de: " + jugadorActual);

    }

    public void mostrarPuntos(List<Jugador> jugadores){
        Collections.sort(jugadores);
        
        System.out.println("Posicion\tNombre\t\tPuntos");
        int posicion = 1;
        
        for(Jugador j : jugadores){
            System.out.println(posicion + "\t\t" + j.getNombre() + "\t\t" + j.getPuntos());
            posicion++;
        }
        
        System.out.println("\n\nJuego Terminado!");
    }
   
    
}
