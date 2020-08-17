public class Dependente {

    private byte idade;

    public Dependente(byte idade) {
        this.idade = idade;
    }

    public boolean getIdadeValida(int parametro) {

        if (idade <= parametro) {
            return true;
        } else {
            return false;
        }
    }

    public void setIdade(byte idade) {
        this.idade = idade;
    }

}