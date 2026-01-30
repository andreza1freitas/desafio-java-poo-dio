import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {

    public static void main(String[] args) {

        Bootcamp bootcampJava = criarBootcampJava();

        // Cria Devs, inscreve no Bootcamp e simula progresso
        Dev camila = criarDev("Camila", bootcampJava);
        executarFluxo(camila, 2);

        System.out.println("-------");

        Dev joao = criarDev("Joao", bootcampJava);
        executarFluxo(joao, 3);
    }

    // Cria um Bootcamp com cursos e mentorias
    private static Bootcamp criarBootcampJava() {
        return new Bootcamp(
                "Bootcamp Java Developer",
                "Descrição Bootcamp Java Developer",
                criarCurso("Curso Java", "Descrição curso Java", 8),
                criarCurso("Curso JS", "Descrição curso JS", 4),
                criarMentoria("Mentoria Java", "Descrição mentoria Java"));
    }

    // Cria um Curso com título, descrição e carga horária
    private static Curso criarCurso(String titulo, String descricao, int cargaHoraria) {
        return new Curso(titulo, descricao, cargaHoraria);
    }

    // Cria uma Mentoria com título e descrição
    private static Mentoria criarMentoria(String titulo, String descricao) {
        return new Mentoria(titulo, descricao);
    }

    // Cria um Dev, define seu nome e o inscreve no Bootcamp
    private static Dev criarDev(String nome, Bootcamp bootcamp) {
        Dev dev = new Dev(nome);
        dev.inscreverBootcamp(bootcamp);
        return dev;
    }

    // Executa o fluxo de progresso do Dev no Bootcamp
    private static void executarFluxo(Dev dev, int progresso) {
        System.out.println("Conteúdos inscritos de " + dev.getNome() + ":");
        System.out.println(dev.getConteudosInscritos());

        int limite = Math.min(progresso, dev.getConteudosInscritos().size());

        for (int i = 0; i < limite; i++) {
            dev.progredir();
        }

        System.out.println("Conteúdos concluídos de " + dev.getNome() + ":");
        System.out.println(dev.getConteudosConcluidos());
        System.out.println("XP Total: " + dev.calcularTotalXp());
    }
}
