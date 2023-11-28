package com.mycompany.juego.taken;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class Taken {
    List<String> tablero;
    int movimientos;
    List<String> Horizontal = new LinkedList<String>();
    List<String> Espiral = new LinkedList<String>();
    List<String> Imposible = new LinkedList<String>();
    List<String> Periferico = new LinkedList<String>();
    List<String> Vertical = new LinkedList<String>();
    
    
    Taken(){
        tablero = new LinkedList<String>();
        reiniciar();
        resultados();
    }
    
    void resultados(){
        String resHor[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",""};
        String resEsp[] = {"7","8","9","10","6","1","2","11","5","4","3","12","","15","14","13"};
        String resImp[] = {"15","14","13","12","11","10","9","8","7","6","5","4","3","2","1",""};
        String resPeri[] = {"1","2","3","4","12","13","14","5","11","","15","6","10","9","8","7"};
        String resVer[] = {"1","5","9","13","2","6","10","14","3","7","11","15","4","8","12",""};
        Horizontal = Arrays.asList(resHor);
        Espiral = Arrays.asList(resEsp);
        Imposible = Arrays.asList(resImp);
        Periferico = Arrays.asList(resPeri);
        Vertical = Arrays.asList(resVer);
        
    }
    
    boolean verificarTablero(){
        boolean resp = true;
        
        for(int i=0; i<16; i++){
            if(!tablero.equals(Horizontal)){
                resp = false;
            }
        }
        if(resp == false){
            resp = true;
            for(int i=0; i<16; i++){
                if(!tablero.equals(Espiral)){
                    resp = false;
                }
            }
        }
        if(resp == false){
            resp = true;
                for(int i=0; i<16; i++){
                if(!tablero.equals(Imposible)){
                    resp = false;
                }
            }
        }
        if(resp == false){
            resp = true;
            for(int i=0; i<16; i++){
                if(!tablero.equals(Periferico)){
                    resp = false;
                }
            }
        }
        if(resp == false){
            resp = true;
            for(int i=0; i<16; i++){
                if(!tablero.equals(Vertical)){
                    resp = false;
                }
            }
        }
        
        return resp;
    }
    

String moverTecla(int num) {
    String resp = "Moviendo tecla.";
    String aux;
    int pos = -1;
    
    pos = tablero.indexOf(String.valueOf(num));
    
        // Arriba
        if (pos >= 4 && tablero.get(pos-4).equals("")) {
            aux = tablero.get(pos);
            tablero.set(pos, tablero.get(pos-4));
            tablero.set(pos-4,aux);
            movimientos++;
            resp = "Tecla cambiada hacia arriba.";
        } else {
            //Abajo
            if (pos <= 11 && tablero.get(pos+4).equals("")) {
                aux = tablero.get(pos);
                tablero.set(pos, tablero.get(pos+4));
                tablero.set(pos+4,aux);
                movimientos++;
                resp = "Tecla cambiada hacia abajo.";
            } else {
                // Derecha
                if (pos % 4 != 3 && tablero.get(pos+1).equals("")) {
                    aux = tablero.get(pos);
                    tablero.set(pos, tablero.get(pos+1));
                    tablero.set(pos+1,aux);
                    movimientos++;
                    resp = "Tecla cambiada hacia la derecha.";
                } else {
                    // Izquierda
                    if (pos % 4 != 0 && tablero.get(pos-1).equals("")) {
                        aux = tablero.get(pos);
                        tablero.set(pos, tablero.get(pos-1));
                        tablero.set(pos-1,aux);
                        movimientos++;
                        resp = "Tecla cambiada hacia la izquierda.";
                    } else {
                        resp = "No es posible mover la tecla.";
                    }
                }
            }
        }
        
    return resp;
}
    
    int obtenerMovimientos(){
        return movimientos;
    }
    
    void reiniciar(){
        tablero.clear();
        for (int i=0; i<13; i++){
            tablero.add(String.valueOf(i+1));
        }
        tablero.add("15");
        tablero.add("14");
        tablero.add("");
        movimientos=0;
    }
}
