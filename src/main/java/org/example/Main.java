package org.example;

import java.net.URI;
import java.net.URISyntaxException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws URISyntaxException {
        final var processarBoletos = new ProcessarBoletos(new LeituraRetornoBancoBrasil());

        String caminhoArquivo = Main.class.getResource("/banco-brasil-1.csv").toURI().getPath();
        processarBoletos.processar(caminhoArquivo);

        processarBoletos.setLeituraRetorno(new LeituraRetornoBradesco());
        processarBoletos.processar(Main.class.getResource("/bradesco-1.csv").toURI().getPath());
    }
}

