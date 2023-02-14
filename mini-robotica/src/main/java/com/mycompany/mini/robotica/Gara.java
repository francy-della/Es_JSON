package com.mycompany.mini.robotica;

/**
 *
 * @author FRANCESCADELLAMANO
 */

public class Gara {
    private String campo;
    private String giudice;
    private String squadra;
    private String ora;
    private int corePercorso;
    private int coreDifficolta;
    private int tempo;

    public String getCampo() {
        return campo;
    }

    public String getSquadra() {
        return squadra;
    }

    public String getOra() {
        return ora;
    }

    public int getCorePercorso() {
        return corePercorso;
    }

    public int getCoreDifficolta() {
        return coreDifficolta;
    }

    public int getTempo() {
        return tempo;
    }
    
    @Override
    public String toString() {
        return "Gara -> " + "squadra = " + squadra + ", campo = " + campo + ", giudice = " + giudice + ", ora = " + ora + ", tempo = " + tempo + ", core percorso = " + corePercorso + ", core difficoltà = " + coreDifficolta;
    }
}