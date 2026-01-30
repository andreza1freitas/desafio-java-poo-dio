package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

    private final int cargaHoraria;

    // Construtor para inicializar os atributos do curso com validação
    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao);
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("Carga horária deve ser maior que zero");
        }
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    // Método toString personalizado para exibir informações do curso e carga horária
    @Override
    public String toString() {
        return "Curso{" + super.toString() +
                ", cargaHoraria=" + cargaHoraria + "}";
    }
}
