package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBradesco implements LeituraRetorno{

    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        List<Boleto> boletos = new ArrayList<>();
        try{
            var lines = Files.readAllLines(Path.of(nomeArquivo));
            for (var line : lines) {
                Boleto boleto = new Boleto();
                String[] array = line.split(";");
                boleto.setId(Integer.parseInt(array[0]));
                boleto.setCodBanco(array[1]);
                boleto.setAgencia(array[2]);
                boleto.setContaBancaria(array[3]);
                boleto.setDataVencimento(LocalDate.parse(array[4], FORMATO_DATA));
                boleto.setDataPagamento(LocalDateTime.parse(array[5], FORMATO_DATA_HORA));
                boleto.setCpfCliente(array[6]);
                boleto.setValor(Double.parseDouble(array[7]));
                boleto.setMulta(Double.parseDouble(array[8]));
                boleto.setJuros(Double.parseDouble(array[9]));
                boletos.add(boleto);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return boletos;
    }
}
