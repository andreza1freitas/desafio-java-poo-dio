package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {

    private final String nome;
    
    private final  Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private final Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome) {
        this.nome = nome;
    }

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.inscreverDev(this);
    }

    // Método progredir que avança no próximo conteúdo inscrito
    public boolean progredir() {
        if (conteudosInscritos.isEmpty()) {
            return false;
        }

        Conteudo conteudo = conteudosInscritos.iterator().next();
        conteudosInscritos.remove(conteudo);
        conteudosConcluidos.add(conteudo);
        return true;
    }

    // Método calcularTotalXp que calcula o total de XP dos conteúdos concluídos
    public double calcularTotalXp() {
         return this.conteudosConcluidos
         .stream()
         .mapToDouble(Conteudo::calcularXp)
         .sum();
    }

    public String getNome() {
        return nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    // Métodos equals e hashCode baseados no nome do Dev
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dev dev)) return false;
        return nome.equals(dev.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
