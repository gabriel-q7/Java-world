
public class FuncionarioTemporario extends Funcionario {

    private double salarioMensal;

    public FuncionarioTemporario(int codigo, double salarioBase, int tempo) {
        super(codigo, salarioBase, tempo);
    }

    public double calcularSalario() {
        salarioMensal = salarioBase + tempo * 15 + getDependentesValidos(18) * 50; // tempo=meses
        return salarioMensal;
    }

    public String getTipo() {
        return "Temporario";
    }

    public int getTempo() {
        return tempo;
    }

    protected void imprimirInfoSubClasse() {
        Imprimir.l("Tipo: " + getTipo());
        Imprimir.l("Meses de trabalho: " + getTempo());
        Imprimir.l("Dependentes inclusos: " + getDependentesValidos(18));
        Imprimir.l("Salário mensal: " + calcularSalario());
    }
}