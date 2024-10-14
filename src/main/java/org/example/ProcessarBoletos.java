package org.example;

import java.util.List;

public class ProcessarBoletos {
    private LeituraRetorno leituraRetorno;

    public ProcessarBoletos(LeituraRetorno leitura) {
        this.leituraRetorno = leitura;
    }

    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public void processar(String nomeArquivo){
        System.out.println("Boletos\n" +
                "-----------------------------------------------------");
        final var boletos = leituraRetorno.lerArquivo(nomeArquivo);
        boletos.forEach(System.out::println);
    }
}
