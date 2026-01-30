package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mentoria extends Conteudo {

    private final LocalDate data;

    // Construtor com validação e data atual
    public Mentoria(String titulo, String descricao) {
        super(titulo, descricao);
        this.data = LocalDate.now();
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public LocalDate getData() {
        return data;
    }

    // Método toString personalizado para exibir informações da mentoria e data formatada
    @Override
    public String toString() {
        return "Mentoria{" + super.toString() +
                ", data=" + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "}";
    }
}
