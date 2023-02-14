package com.mycompany.mini.robotica;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author JENNIFERPAGANIN
 */

public class MiniRobotica {
    public static void main(String[] args) throws IOException {
        //Accesso al file json
        Gson fileGson = new Gson();
        byte[] content = Files.readAllBytes(Paths.get("src\\main\\java\\com\\mycompany\\mini\\robotica\\gare.json"));
        String fileJson = new String(content);
        Gara[] gara = fileGson.fromJson(fileJson, Gara[].class);
        //Inizializzazione Arralist per le squadre
        ArrayList <Squadra> squadre = new ArrayList<>();
        boolean presente = false;
        //For per stampare a video le squadre
        for (Gara G : gara) {
            presente = false;
            System.out.println(G);
            
            for(Squadra S : squadre){
                if(S.nome.equals(G.getSquadra())) {
                    S.core = S.core + G.getCoreDifficolta() + G.getCorePercorso();
                    S.tempo = S.tempo + G.getTempo();
                    presente = true;
                }
            }

            if(!presente)
                squadre.add(new Squadra(G.getSquadra(), G.getCoreDifficolta()+ G.getCorePercorso(), G.getTempo()));
        }
        //stampa a video dei dati delle squadre (solo nome, punteggio e tempo)
        System.out.println("\nSQUADRE");
        System.out.println("-------------------");
        for(Squadra sq : squadre){
            System.out.println("Nome: " + sq.nome);
            System.out.println("Punteggio: " + sq.core);
            System.out.println("Tempo: " + sq.tempo);
            System.out.println("-------------------");
        }
    }
}