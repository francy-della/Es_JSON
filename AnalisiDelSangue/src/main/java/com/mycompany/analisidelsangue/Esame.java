package com.mycompany.analisidelsangue;

import java.util.ArrayList;

/**
 *
 * @author JENNIFERPAGANIN
 */
public class Esame {
    private String denominazione;
    private String data;
    private String ora;
    private String codiceOperatore;
    private ArrayList<Integer> strumenti;
    private float valore;
    private String unitaMisura;
    private int valoreMinimo;
    private int valoreMassimo;

    public Esame(String denominazione, String data, String ora, String codiceOperatore, ArrayList<Integer> strumenti, float valore, String unitaMisura, int valoreMinimo, int valoreMassimo) {
        this.denominazione = denominazione;
        this.data = data;
        this.ora = ora;
        this.codiceOperatore = codiceOperatore;
        this.strumenti = strumenti;
        this.valore = valore;
        this.unitaMisura = unitaMisura;
        this.valoreMinimo = valoreMinimo;
        this.valoreMassimo = valoreMassimo;
    }

    public String getDenominazione() {
        return denominazione;
    }
    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }
    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getCodiceOperatore() {
        return codiceOperatore;
    }
    public void setCodiceOperatore(String codiceOperatore) {
        this.codiceOperatore = codiceOperatore;
    }

    public ArrayList<Integer> getStrumenti() {
        return strumenti;
    }
    public void setStrumenti(ArrayList<Integer> strumenti) {
        this.strumenti = strumenti;
    }

    public float getValore() {
        return valore;
    }
    public void setValore(float valore) {
        this.valore = valore;
    }

    public String getUnitaMisura() {
        return unitaMisura;
    }
    public void setUnitaMisura(String unitaMisura) {
        this.unitaMisura = unitaMisura;
    }

    public int getValoreMinimo() {
        return valoreMinimo;
    }
    public void setValoreMinimo(int valoreMinimo) {
        this.valoreMinimo = valoreMinimo;
    }

    public int getValoreMassimo() {
        return valoreMassimo;
    }
    public void setValore_massimo(int valoreMassimo) {
        this.valoreMassimo = valoreMassimo;
    }
}
