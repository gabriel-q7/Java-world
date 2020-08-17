import java.util.ArrayList;

public abstract class Funcionario {

    protected int codigo, tempo;
    protected double salarioBase;
    protected ArrayList<Dependente> listaDependentes = new ArrayList<Dependente>();

    Funcionario(int codigo, double salarioBase, int tempo) {
        this.codigo = codigo;
        this.salarioBase = salarioBase;
        this.tempo = tempo;
    }

    // associação do dependente atraves de um atributo e metodo
    void addDependente(byte idade) {
        Dependente novoDependente = new Dependente(idade);
        listaDependentes.add(novoDependente);
    }

    protected byte getDependentesValidos(int idadeMax) {
        byte dependentesInclusos = 0;

        for (int i = 0; i < listaDependentes.size(); i++) {
            if (listaDependentes.get(i).getIdadeValida(idadeMax) == true) {
                dependentesInclusos++;
            }
        }
        return dependentesInclusos;
    }

    protected double calcularSalario() {
        return 0;
    }

    protected String getTipo() {
        return null;
    }

    protected int getCodigo() {
        return codigo;
    }

    protected double getSalarioBase() {
        return salarioBase;
    }

    protected void imprimirInfoBasica() {
        Imprimir.l("Número do funcionario: " + getCodigo());
        Imprimir.l("Salário base: " + getSalarioBase());

    }

    protected void imprimirInfoSubClasse() {

    }

}