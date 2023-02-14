package com.mycompany.analisidelsangue;

/**
 *
 * @author FRANCESCADELLAMANO
 */

import com.google.gson.Gson;
import java.io.*;
import java.nio.file.*;

public class AnalisiDelSangue {

    private static String readStringFromFile(String file) throws IOException {
        byte[] content = Files.readAllBytes(Paths.get(file));
        return new String(content);
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Gson gson = new Gson();
        String json = readStringFromFile("esito.json");
        Esito esito = gson.fromJson(json, Esito.class);
        
        System.out.println("Nome: " + esito.getNome());
        System.out.println("Cognome: " + esito.getCognome());
        System.out.println("Codice Fiscale: " + esito.getCodiceFiscale());
        System.out.println("Sesso: " + esito.getSesso());
        System.out.println("Età: " + esito.getEta());
        System.out.println("Data prelievo: " + esito.getDataPrelievo());
        System.out.println("Ora prelievo: " + esito.getOraPrelievo());
        System.out.println("Luogo prelievo: " + esito.getLuogoPrelievo());
        System.out.println("\nESAMI:\n");
        
        for(int i=0; i<esito.getEsami().size(); i++) {
            System.out.println("Nome esame: " + esito.getEsami().get(i).getNomeEsame());
            System.out.println("Data esame: " + esito.getEsami().get(i).getDataEsame());
            System.out.println("Ora esame: " + esito.getEsami().get(i).getOraEsame());
            System.out.println("Codice operatore: " + esito.getEsami().get(i).getCodiceOperatore());
            
            for(int j=0; j<esito.getEsami().get(i).getStrumentiUtilizzati().size(); j++) { //lista strumenti
                System.out.println("Strumento utilizzato: " + esito.getEsami().get(i).getStrumentiUtilizzati().get(j));
            }
            
            System.out.println("Valore misurato: " + esito.getEsami().get(i).getValoreMisurato());
            System.out.println("Unità di misura: " + esito.getEsami().get(i).getUnitaMisura());
            System.out.println("Valore minimo: " + esito.getEsami().get(i).getValoreMinimo());
            System.out.println("Valore massimo: " + esito.getEsami().get(i).getValoreMassimo());
        }
    }
}