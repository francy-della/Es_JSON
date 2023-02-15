package com.mycompany.analisidelsangue;

/**
 *
 * @author FRANCESCADELLAMANO
 */

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;

public class AnalisiDelSangue {
//METODO PER IL CONTROLLO DEGLI STRUMENTI
    public static void controlloStrum(ArrayList<Integer> strumenti, String nEsame, Analisi[] A) throws IOException {
        ArrayList<Integer> strumLetti = new ArrayList<Integer>();
        
        for (Analisi an : A) {
            if (an.getNome().equals(nEsame)) {
                for (int i=0; i<an.getStrumenti().size(); i++) {
                    strumLetti.add(an.getStrumenti().get(i).getMatricola());
                }
            }
        }
        Collections.sort(strumLetti);
        Collections.sort(strumenti);

        if (strumenti.equals(strumLetti)) {
            System.out.print("Tutti gli strumenti utilizzati sono consentiti!");
        } else {
            System.out.print("Strumenti non consentiti: ");
            for (Integer nStrum : strumenti) {
                if (!strumLetti.contains(nStrum)) {
                    System.out.print(nStrum + " ");
                }
            }
        }
    }
    
    //METODO PER IL CONTROLLO DEGLI OPERATORI
    public static boolean controlloOper(String operatore, String nEsame, Analisi[] A) throws IOException { 
        for (Analisi an : A) {
            if (an.getNome().equals(nEsame)) {
                for (int i=0; i<an.getStrumenti().size(); i++) {
                    if (an.getStrumenti().get(i).getOperatoriAbilitati().contains(operatore)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
   
    //METODO PER IL CONTROLLO DELLA DATA
    public static boolean controlloData(String dataAn, String dataPre, String nEsame, Analisi[] A) throws IOException, ParseException {
        LocalDate date1 = LocalDate.parse(dataAn);
        LocalDate date2 = LocalDate.parse(dataPre);
        
        for (Analisi an : A) {
            if (an.getNome().equals(nEsame)) {
                long difGiorni = ChronoUnit.DAYS.between(date2, date1);
                int intValue = (int) difGiorni;
                if (intValue<an.getTDopoPrelievo()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //MAIN
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        ArrayList<String> operatori = new ArrayList<String>();
        ArrayList<String> operatoreEsami = new ArrayList<String>();
        String operatoriEsame = "";
        ArrayList<Integer> strumenti = new ArrayList<Integer>();
        
        Gson gson1 = new Gson();
        Gson gson2 = new Gson();
        //ACCESSO AI 2 FILE JSON
        byte[] content = Files.readAllBytes(Paths.get("src\\main\\java\\com\\mycompany\\analisidelsangue\\esito.json"));
        String jsonEsito = new String(content);
        Esito esitoJson = gson1.fromJson(jsonEsito, Esito.class);
        byte[] content2 = Files.readAllBytes(Paths.get("src\\main\\java\\com\\mycompany\\analisidelsangue\\analisi.json"));
        String json1 = new String(content2);
        Analisi[] A = gson2.fromJson(json1, Analisi[].class);
  
        for (Analisi an : A) {
            for (int i=0; i<an.getStrumenti().size(); i++) {
                operatori.add(an.getStrumenti().get(i).getOperatoriAbilitati().get(i));
            }
        }
        System.out.println("------------------------------------------");
        System.out.println("Nome: " + esitoJson.getNome());
        System.out.println("Cognome: " + esitoJson.getCognome());
        System.out.println("Codice Fiscale: " + esitoJson.getCodice_fiscale());
        System.out.println("Sesso: " + esitoJson.getSesso());
        System.out.println("Età: " + esitoJson.getEta());
        System.out.println("Data del prelievo: " + esitoJson.getDataPrelievo());
        System.out.println("Ora del prelievo: " + esitoJson.getOraPrelievo());
        System.out.println("Luogo del prelievo: " + esitoJson.getLuogoPrelievo());
        System.out.println("------------------------------------------");
        
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("ESAMI EFFETTUATI:");
        System.out.println("--------------------------------------------------------------");
        //LISTA DEGLI ESAMI
        for (int i=0; i<esitoJson.getEsami().size(); i++) {
            System.out.println("Nome dell'esame: " + esitoJson.getEsami().get(i).getDenominazione().toUpperCase());
            System.out.println("Data: " + esitoJson.getEsami().get(i).getData());
            System.out.println("Ora: " + esitoJson.getEsami().get(i).getOra());
            //controllo data
            boolean Rdata = controlloData(esitoJson.getEsami().get(i).getData(), esitoJson.getDataPrelievo(), esitoJson.getEsami().get(i).getDenominazione(), A);
            if (Rdata == true) {
                System.out.println("Analisi svolta nei tempi previsti!");
            } else {
                System.out.println("Analisi non svolta nei tempi previsti!");
            }
            
            System.out.print("Codice dell'operatore: " + esitoJson.getEsami().get(i).getCodiceOperatore());
            //CONTROLLO OPERATORE
            boolean ROperatore = controlloOper(esitoJson.getEsami().get(i).getCodiceOperatore(), esitoJson.getEsami().get(i).getDenominazione(), A);
            if (ROperatore == true) {
                System.out.println(" -> Operatore abilitato!");
            } else {
                System.out.println(" -> Operatore non abilitato!");
            }
            
            operatoreEsami.add(esitoJson.getEsami().get(i).getCodiceOperatore());
            //LISTA CON CONTROLLO DEGLI STRUMENTI
            for (int j=0; j<esitoJson.getEsami().get(i).getStrumenti().size(); j++) { 
                strumenti.add(esitoJson.getEsami().get(i).getStrumenti().get(j));
            }
            controlloStrum(strumenti, esitoJson.getEsami().get(i).getDenominazione(), A);
            strumenti.clear();
            
            System.out.print("\nValore: " + esitoJson.getEsami().get(i).getValore());
            if (esitoJson.getEsami().get(i).getValore() < esitoJson.getEsami().get(i).getValoreMassimo() && esitoJson.getEsami().get(i).getValore() > esitoJson.getEsami().get(i).getValoreMinimo()) {
                System.out.println(" -> Il valore è nella norma.");
            } else if (esitoJson.getEsami().get(i).getValore() > esitoJson.getEsami().get(i).getValoreMassimo()) {
                System.out.println(" -> Il valore è superiore alla norma!");
            } else {
                System.out.println(" -> Il valore è inferiore alla norma!");
            }
            System.out.println("--------------------------------------------------------------");
        }
    }
}