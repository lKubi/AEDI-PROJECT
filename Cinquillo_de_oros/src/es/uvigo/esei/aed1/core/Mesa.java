/*
* Representa la Mesa de juego. 
* Estructura: se utilizar� un TAD adecuado. Piensa que hay 4 palos y de cada palo se pueden colocar cartas 
* por cualquiera de los dos extremos (un array con 4 doblescolas parece lo más adecuado). La DobleCola se comento en clase de teoria
* Funcionalidad: saber si es posible colocar una carta en la mesa, colocar una carta en la mesa, mostrar la mesa
 */
package es.uvigo.esei.aed1.core;
import java.util.*;


public class Mesa {

    private final Deque<Carta>[] mesa;
    private final int numPalos = 4;
    private final int numCartasPorPalo = 12;
    
    public Mesa(){
        mesa = new Deque[numPalos];
        for (int i = 0; i < numPalos; i++) {
            mesa[i] = new ArrayDeque<>();
        }
    }

    public int getNumPalos() {
        return numPalos;
    }

//    /**
//     * Metodo que devuelve las cartas que un jugador puede poner en la mesa actual
//     * @param j Jugador Actual
//     * @return Una lista con las cartas posibles a colocar
//     */
//    public List<Carta> getCartasCandidatas(Jugador j){
//        //Creo una lista vacia
//        List <Carta> listaCartas = new LinkedList<>();
//        
//        //Por cada carta en la mano, voy comprobandosi se puede añadir o no
//        //Si se puede añadir, la agrego a la lista nueva
//        for (Carta c : j.getMano()){
//            if (sePuedePonerCarta(c)){
//                listaCartas.add(c);
//            }
//        }
//        
//        return listaCartas;
//    }
    
    /**
     * Metodo que comprueba si UNA carta se puede colocar en la mesa
     * @param c carta que se evalua
     * @return 
     */
    public boolean sePuedePonerCarta(Carta c){
        boolean toret = false;
        int paloCarta = c.getPalo().ordinal();
        
        if (mesa[paloCarta].isEmpty()){
            if (c.getNumero() == 5){
                toret = true;
            }
        }else{
            int numeroArribaPalo = mesa[paloCarta].getFirst().getNumero();
            int numeroAbajoPalo = mesa[paloCarta].getLast().getNumero();
            if (numeroArribaPalo == (c.getNumero() - 1)){
                toret = true;
            }else if (numeroAbajoPalo == (c.getNumero() + 1)){
                toret = true;
            }
        }
        return toret;
    }
    
    /**
     * Coloca la carta que se pasa como parametro a su respectiva deque
     * @param c 
     */
    public void colocarCartaMesa(Carta c){
        
        int paloCarta = c.getPalo().ordinal();
        
        if (c.getNumero() == 5){
            mesa[paloCarta].addFirst(c);
        }else{
            int numeroArribaPalo = mesa[paloCarta].getFirst().getNumero();
            int numeroAbajoPalo = mesa[paloCarta].getLast().getNumero();
            
            if (numeroArribaPalo == (c.getNumero() - 1)){
                mesa[paloCarta].addFirst(c);
            }else if (numeroAbajoPalo == (c.getNumero() + 1)){
                mesa[paloCarta].addLast(c);
            }
        }
        
    }

    
    /**
     * Metodo mostrar bonita la mesa de juego en cada turno
     * @return 
     */
    @Override
    public String toString(){

        int [][] mesaMatriz = new int[numCartasPorPalo][numPalos];
        for (int i = 0; i < numPalos; i++) {
            for (Carta c : mesa[i]) {
                mesaMatriz[12 - c.getNumero()][c.getPalo().ordinal()] = c.getNumero();
            }
        }

        StringBuilder sb = new StringBuilder();

        Carta.Palos [] palos = Carta.Palos.values();        

        sb.append("\n\n");

        for (Carta.Palos p : palos){
            sb.append(p.name()).append("\t");
        }

        sb.append("\n");

        for (int i = 0; i < numCartasPorPalo; i++) {
            for (int j = 0; j < numPalos; j++) {
                if (mesaMatriz[i][j] != 0) {
                    sb.append(mesaMatriz[i][j]);
                } else {
                    sb.append("###");
                }
                sb.append("\t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    
}
