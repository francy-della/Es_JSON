package com.mycompany.analisidelsangue;

import java.util.ArrayList;

/**
 *
 * @author JENNIFERPAGANIN
 */
public class Strumenti {
    private int matricola;
    private ArrayList<String> operatoriAbilitati;

    public Strumenti(int matricola, ArrayList<String> operatoriAbilitati) {
        this.matricola = matricola;
        this.operatoriAbilitati = operatoriAbilitati;
    }

    public int getMatricola() {
        return matricola;
    }
    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public ArrayList<String> getOperatoriAbilitati() {
        return operatoriAbilitati;
    }
    public void setOperatoriAbilitati(ArrayList<String> operatoriAbilitati) {
        this.operatoriAbilitati = operatoriAbilitati;
    }
}
