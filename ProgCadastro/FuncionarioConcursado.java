
public class FuncionarioConcursado extends Funcionario {

    private double salarioMensal;

    public FuncionarioConcursado(int codigo, double salarioBase, int tempo) {
        super(codigo, salarioBase, tempo);
    }

    public double calcularSalario() {
        salarioMensal = salarioBase + tempo * 200 + getDependentesValidos(21) * 100; // tempo = anos
        return salarioMensal;
    }

    public String getTipo() {
        return "Concursado";
    }

    public int getTempo() {
        return tempo;
    }

    protected void imprimirInfoSubClasse() {
        Imprimir.l("Tipo: " + getTipo());
        Imprimir.l("Anos de trabalho: " + getTempo());
        Imprimir.l("Dependentes inclusos: " + getDependentesValidos(21));
        Imprimir.l("Salário mensal: " + calcularSalario());
    }
}