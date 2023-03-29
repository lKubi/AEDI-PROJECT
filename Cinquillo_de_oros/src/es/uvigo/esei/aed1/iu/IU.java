/**
 * Representa la interfaz del juego del Cinquillo-Oro, en este proyecto va a ser una entrada/salida en modo texto 
 * Se recomienda una implementación modular.
 */

package es.uvigo.esei.aed1.iu;

import es.uvigo.esei.aed1.core.Jugador;
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
        boolean esValido;
        
        
        //Compruebo que el dato introducido es valido
        do{
            esValido = true;
            System.out.println("Cuantos jugadores van a jugar? (3 o 4): ");
            try{
                cantJugadores = Integer.parseInt(teclado.nextLine());
            }catch(NumberFormatException e){
                System.out.println("El valor introducido debe ser 3 o 4");
                esValido = false;
                continue;
            }
            
            if(cantJugadores != 3 && cantJugadores != 4){
                System.out.println("El valor introducido debe ser 3 o 4.");
            }
        }while((cantJugadores != 3 && cantJugadores != 4) || !esValido);
        
        //Creo la colección de los nombres de los jugadores y creo los objetos
        Collection<String> nombresJugadores = new ArrayList<>();
        
        for (int i = 1; i <= cantJugadores; i++) {
            System.out.println("Introduce el nombre del jugador " + i + ": ");
            nombresJugadores.add(teclado.nextLine());
        }
        
        return nombresJugadores;

    }

    public void mostrarJugador(Jugador jugador){

    }

    public void mostrarJugadores(Collection<Jugador> jugadores){

    }
   
    
}
