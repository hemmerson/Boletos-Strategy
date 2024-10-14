package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBancoBrasil implements LeituraRetorno {

    @Override
    public List<Boleto> lerArquivo(final String nomeArquivo) {
        try {
            List<Boleto> boletos = new ArrayList<>();
            var lines = Files.readAllLines(Path.of(nomeArquivo));
            for (String line : lines) {
                Boleto b = new Boleto();
                String[] array = line.split(";");
                b.setId(Integer.parseInt(array[0]));
                b.setCodBanco(array[1]);
                b.setDataVencimento(LocalDate.parse(array[2], FORMATO_DATA));
                b.setDataPagamento(LocalDate.parse(array[3], FORMATO_DATA).atTime(0, 0, 0));
                b.setCpfCliente(array[4]);
                b.setValor(Double.parseDouble(array[5]));
                b.setMulta(Double.parseDouble(array[6]));
                b.setJuros(Double.parseDouble(array[7]));
                boletos.add(b);
            }
            return boletos;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
