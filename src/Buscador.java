import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Buscador {

    ArvoreBinariaBusca arvoreArquivos;

    public void setArvoreArquivos(ArvoreBinariaBusca arvoreArquivos) {
        this.arvoreArquivos = arvoreArquivos;
    }

    public ArvoreBinariaBusca getArvoreArquivos() {
        return arvoreArquivos;
    }

    public Buscador(ArvoreBinariaBusca arvoreArquivos){
        this.arvoreArquivos = arvoreArquivos;
    }

    ListaArquivos busca(String palavraChave){
        return this.arvoreArquivos.buscaAntiga(palavraChave).getRaiz().getLista();
    }

    public String buscaTermos(String[] termos){
        //receba palavras , retorna nome do arquivo com a freq somada dessas palavras
        ListaArquivos listaPalavras = new ListaArquivos();
        NoLista noAuxiliar = new NoLista();
        String texto = "";
       // String[] termos = termosJuntos.split(" ",0);

        //String delimitador = " ";
        //StringTokenizer termos = new StringTokenizer(termosJuntos,delimitador);

        //for(int j = 0; j < termos.length; j++){
        //    String palavraChave = termos[j];

        //while (termos.hasMoreTokens()){
        //    String palavraChave = termos.nextToken();

        for(String palavraChave:termos){
            System.out.println(palavraChave);

            noAuxiliar = this.busca(palavraChave).getInicio();
            NoLista novo = listaPalavras.getInicio();


            for(int i = 0; i < noAuxiliar.getFrequencia();i++){
                listaPalavras.inserir(palavraChave);
            }

            texto +=  listaPalavras.retornarUltimoNo().getNomeArquivo();
            texto += " " + noAuxiliar.getNomeArquivo();
            texto += " (" + listaPalavras.retornarUltimoNo().getFrequencia()+")-> ";


        }
        return texto;
    }


}
