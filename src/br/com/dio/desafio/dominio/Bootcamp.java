package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {

    private String nome;
    private String descricao;

    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);

    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    // Construtor para inicializar nome, descrição e conteúdos do bootcamp
    public Bootcamp(String nome, String descricao, Conteudo... conteudos) {
        setNome(nome);
        setDescricao(descricao);
        this.conteudos.addAll(Set.of(conteudos));
    }

    public void inscreverDev(Dev dev) {
        this.devsInscritos.add(dev);
    }

    public String getNome() {
        return nome;
    }

    // Validação para nome não ser nulo ou vazio
    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do bootcamp não pode ser vazio");
        }
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return Collections.unmodifiableSet(devsInscritos);

    }

    public Set<Conteudo> getConteudos() {
        return Collections.unmodifiableSet(conteudos);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Bootcamp bootcamp))
            return false;
        return Objects.equals(nome, bootcamp.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
