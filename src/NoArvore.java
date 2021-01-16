public class NoArvore {

    private String palavraChave;
    private ListaArquivos lista = new ListaArquivos();

    public NoArvore(String palavraChave, String nomeArquivo){
        this.palavraChave = palavraChave;
        this.lista.inserir(nomeArquivo);
    }

    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }

    public void setLista(ListaArquivos lista) {
        this.lista = lista;
    }

    public String getPalavraChave() {
        return palavraChave;
    }

    public ListaArquivos getLista() {
        return lista;
    }

    public int valorOrdem(String palavraNova,int indice){
        //valor positivo deve inserir a esquerda
        //valor negativo deve inserir a direita
        int valor, tamanho;

        String objetoLetra = this.getPalavraChave().substring(0,indice).toUpperCase();
        String novaLetra   =            palavraNova.substring(0,indice).toUpperCase();

        valor = objetoLetra.compareTo(novaLetra);
        tamanho = Math.min(this.getPalavraChave().length(),palavraNova.length());

        if(valor == 0 && indice < tamanho ){
            //primeira letra igual, vai para a proxima
            return valorOrdem(palavraNova, indice + 1);
        }
        else if(indice == tamanho){
            // chegou na ultima letra para comparação
            // nova palavra menor mas igual o começo, inseri na esquerda
            return 1;
        }
        else{
            return valor;
        }
    }

}
