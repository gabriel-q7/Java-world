public class ListaArquivos {

    private int tamanho;
    private NoLista inicio;

    public ListaArquivos(){
        this.tamanho = 0;
        this.inicio = null;
    }

    public void setInicio(NoLista inicio) {
        this.inicio = inicio;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public NoLista getInicio() {
        return inicio;
    }

    public int getTamanho(){
        return tamanho;
    }


    public void inserir(String nomeArquivo){
        NoLista novoNo = new NoLista(nomeArquivo);
        boolean parar = false;

        if(this.estaVazia()){
            inicio = novoNo;
            tamanho++;
        }
        else{
            //inserir novo nó no fim
            if(this.pesquisa(nomeArquivo) == null){
                this.retornarUltimoNo().setProximoNo(novoNo);
            }
            else{
                NoLista existente = this.pesquisa(nomeArquivo);
                novoNo = this.retirar(nomeArquivo);
                novoNo.setFrequencia(1 + existente.getFrequencia());

                if(inicio == null){
                    inicio = novoNo;
                    parar = true;
                }

                NoLista atual = inicio;

                while(atual != null && parar == false){

                    //insere no inicio
                    if(novoNo.getFrequencia()>=inicio.getFrequencia()){
                        novoNo.setProximoNo(inicio);
                        inicio = novoNo;
                        break;
                    }

                    //insere no meio
                    if(atual.getFrequencia() > novoNo.getFrequencia()){
                        if(novoNo.getFrequencia() >= atual.getProximoNo().getFrequencia()){
                            novoNo.setProximoNo(atual.getProximoNo());
                            atual.setProximoNo(novoNo);
                            break;
                        }
                    }

                    //insere no fim
                    if(atual.getProximoNo() == null){
                        this.retornarUltimoNo().setProximoNo(novoNo);
                        break;
                    }
                    atual = atual.getProximoNo();
                }
            }
            tamanho++;
        }
    }

    public NoLista retornarUltimoNo(){
        NoLista auxiliar = inicio;

        while(auxiliar.getProximoNo() != null){
            auxiliar = auxiliar.getProximoNo();
        }
        return auxiliar;
    }

    public NoLista retirar(String nome){

        if(!this.estaVazia()){
            //System.out.println("entrou em retirar");
            NoLista atual = inicio;
            NoLista posterior = inicio.getProximoNo();

            if(tamanho == 1){
                //System.out.println("retornou inicio");
                tamanho--;
                inicio = null;
                return atual;
            }

            while (posterior != null){
                if(atual.getNomeArquivo() == nome){
                    inicio = posterior;
                    tamanho--;
                    return atual;
                }
                if(posterior.getNomeArquivo() == nome){
                    atual.setProximoNo(posterior.getProximoNo());
                    tamanho--;
                    return posterior;
                }
                atual = atual.getProximoNo();
                posterior = posterior.getProximoNo();
            }
        }
        else{
            throw new RuntimeException("Lista esta vazia.");
        }
        return null;
    }

    public String listar(){
        String lista = " >>>";

        if(this.estaVazia()){
            return "Lista está vazia.";
        }
        else{
            NoLista auxiliar = inicio;

            while (auxiliar != null){
                lista +=  auxiliar.getNomeArquivo();
                lista += " (" + auxiliar.getFrequencia()+")->";
                auxiliar = auxiliar.getProximoNo();
            }
            return lista;
        }
    }

    public NoLista pesquisa(String nome){
        if(this.estaVazia()){
            System.out.println("Lista está vazia.");
        }
        else{
            NoLista auxiliar = inicio;
            while (auxiliar != null){
                if(auxiliar.getNomeArquivo() == nome){
                    return auxiliar;
                }
                auxiliar = auxiliar.getProximoNo();
            }
        }
        return null;
    }

    public int pesquisaFrequencia(String nome){
        if(this.pesquisa(nome) != null)
            return this.pesquisa(nome).getFrequencia();
        else
            return 0;
    }


    public boolean estaVazia(){
        return this.inicio == null;
    }

}
