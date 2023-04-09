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
                System.err.println("El valor introducido debe ser 3 o 4.");
                esValido = false;
                continue;
            }
            
            if(cantJugadores != 3 && cantJugadores != 4){
                System.err.println("El valor introducido debe ser 3 o 4.");
            }
        }while((cantJugadores != 3 && cantJugadores != 4) || !esValido);
        
        //Creo la colección de los nombres de los jugadores
        Collection<String> nombresJugadores = new LinkedList<>();
        
        String entrada;
        
        for (int i = 1; i <= cantJugadores; i++) {
            System.out.println("Introduce el nombre del jugador " + i + ": ");
            
            entrada = teclado.nextLine();
            
             // Compruebo que la cadena introducida no esté vacia
            while(entrada.trim().equals("")){
                System.out.print("\nLa cadena no puede estar vacia!\nIntroduce un nombre valido: ");
                entrada = teclado.nextLine();
            }
            
            //Añado el nombre a la colección
            nombresJugadores.add(entrada);
            
        }
        return nombresJugadores;
    }

    public void mostrarJugador(Jugador jugador){
        System.out.println(jugador);

    }

    public void mostrarJugadores(Collection<Jugador> jugadores){
        int i = 0;
        for (Jugador jugador : jugadores) {
            System.out.println("Jugador # " + (i+1));
            System.out.println(jugador + "\n");
            i++;
        }

    }
   
    
}
