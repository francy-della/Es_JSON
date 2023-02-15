package com.mycompany.analisidelsangue;

import java.util.ArrayList;

/**
 *
 * @author JENNIFERPAGANIN
 */
public class Analisi {
    private ArrayList<Strumenti> strumenti;
    private String nome;
    private int TdopoPrelievo;

    public Analisi(String nome, int TdopoPrelievo, ArrayList<Strumenti> strumenti) {
        this.nome = nome;
        this.TdopoPrelievo = TdopoPrelievo;
        this.strumenti = strumenti;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTDopoPrelievo() {
        return TdopoPrelievo;
    }
    public void setTDopoPrelievo(int tempoDopoPrelievo) {
        this.TdopoPrelievo = tempoDopoPrelievo;
    }

    public ArrayList<Strumenti> getStrumenti() {
        return strumenti;
    }
    public void setStrumenti(ArrayList<Strumenti> strumenti) {
        this.strumenti = strumenti;
    }
}
