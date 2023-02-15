package com.mycompany.analisidelsangue;

import java.util.ArrayList;

/**
 *
 * @author JENNIFERPAGANIN
 */
public class Esito {
    private String nome;
    private String cognome;
    private String codice_fiscale;
    private String sesso;
    private int eta;
    private String dataPrelievo;
    private String oraPrelievo;
    private String luogoPrelievo;
    private ArrayList<Esame> esami;

    public Esito(String nome, String cognome, String codice_fiscale, String sesso, int eta, String dataPrelievo, String oraPrelievo, String luogoPrelievo, ArrayList<Esame> esami) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice_fiscale = codice_fiscale;
        this.sesso = sesso;
        this.eta = eta;
        this.dataPrelievo = dataPrelievo;
        this.oraPrelievo = oraPrelievo;
        this.luogoPrelievo = luogoPrelievo;
        this.esami = esami;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodice_fiscale() {
        return codice_fiscale;
    }
    public void setCodice_fiscale(String codice_fiscale) {
        this.codice_fiscale = codice_fiscale;
    }

    public String getSesso() {
        return sesso;
    }
    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public int getEta() {
        return eta;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getDataPrelievo() {
        return dataPrelievo;
    }
    public void setDataPrelievo(String dataPrelievo) {
        this.dataPrelievo = dataPrelievo;
    }

    public String getOraPrelievo() {
        return oraPrelievo;
    }
    public void setOra_prelievo(String oraPrelievo) {
        this.oraPrelievo = oraPrelievo;
    }

    public String getLuogoPrelievo() {
        return luogoPrelievo;
    }
    public void setLuogo_prelievo(String luogoPrelievo) {
        this.luogoPrelievo = luogoPrelievo;
    }

    public ArrayList<Esame> getEsami() {
        return esami;
    }
    public void setEsami(ArrayList<Esame> esami) {
        this.esami = esami;
    }
}
