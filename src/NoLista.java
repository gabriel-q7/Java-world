public class NoLista {

    private String nomeArquivo; //nome do arquivo
    private int frequencia; //quantidade de vezes que um termo aparece dentro do arquivo
    private NoLista proximoNo;

    public NoLista(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
        this.frequencia = 1;
        this.proximoNo = null;
    }

    public NoLista(){
        nomeArquivo = null;
        frequencia = 0;
        proximoNo = null;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public void setProximoNo(NoLista proximoNo) {
        this.proximoNo = proximoNo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public NoLista getProximoNo() {
        return proximoNo;
    }
}
