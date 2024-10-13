package org.example;

import java.net.URI;
import java.net.URISyntaxException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws URISyntaxException {
        final ProcessarBoletos processarBoletos = new ProcessarBoletos(new LeituraRetornoBradesco());

        String caminhoArquivo = Main.class.getResource("/bradesco-1.csv").toURI().getPath();
        System.out.println("Leitura Arquivo: " + caminhoArquivo + "\n");

        processarBoletos.processar(caminhoArquivo);
    }
}

