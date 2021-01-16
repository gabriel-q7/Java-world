public class ArvoreBinariaBusca {

    private NoArvore raiz;
    private ArvoreBinariaBusca esquerda;
    private ArvoreBinariaBusca direita;
    private int fb;

    public ArvoreBinariaBusca(){
        this.raiz = raiz;
        this.esquerda = null;
        this.direita = null;
        this.fb = 0;
    }

    public ArvoreBinariaBusca(NoArvore novoNo){
        this.raiz = novoNo;
        this.esquerda = null;
        this.direita = null;
        this.fb = 0;
    }

    public void setRaiz(NoArvore raiz) {
        this.raiz = raiz;
    }

    public void setEsquerda(ArvoreBinariaBusca esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(ArvoreBinariaBusca direita) {
        this.direita = direita;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }

    public NoArvore getRaiz() {
        return raiz;
    }

    public ArvoreBinariaBusca getEsquerda() {
        return esquerda;
    }

    public ArvoreBinariaBusca getDireita() {
        return direita;
    }

    public int getFb() {
        return fb;
    }

    // funções

    public  boolean estaVazio(){
        return this.raiz == null;
    }

    public void insere(String palavraChave,String nomeArquivo){

        NoArvore novoNo = new NoArvore(palavraChave,nomeArquivo);

        //novo nó arvore
        if(this.buscaAntiga(palavraChave) == null) {
            //System.out.println("entrou no novo nó");

            if (this.estaVazio()) {
                raiz = novoNo;
            }
            else{
                ArvoreBinariaBusca novaArvore = new ArvoreBinariaBusca(novoNo);

                //inserirAntigo na esquerda C B = 1
                if (raiz.valorOrdem(novoNo.getPalavraChave(),1) > 0) {
                    if (this.esquerda == null) {
                        this.esquerda = novaArvore;
                    } else {
                       this.esquerda.insere(palavraChave, nomeArquivo);
                    }
                }

                //inserirAntigo na direita B C = -1
                else if (raiz.valorOrdem(novoNo.getPalavraChave(),1) < 0) {
                    if (this.direita == null) {
                        this.direita = novaArvore;
                    } else {
                        this.direita.insere(palavraChave, nomeArquivo);
                    }
                }
            }
        }
        else{
            //nó arvore já existe
            this.buscaAntiga(palavraChave).getRaiz().getLista().inserir(nomeArquivo);
        }
    }

    public ArvoreBinariaBusca buscaAntiga(String palavraChave){

        if(this.estaVazio()){
            return null;
        }

        if(this.raiz.getPalavraChave() == palavraChave ){
            return this;
        }
        else{

            if(this.raiz.valorOrdem(palavraChave,1) > 0){
                if(this.esquerda == null){
                    return null;
                }
                else{
                    return this.esquerda.buscaAntiga(palavraChave);
                }
            }
            else if(this.raiz.valorOrdem(palavraChave,1) < 0){
                if(this.direita == null){
                    return null;
                }
                else{
                    return this.direita.buscaAntiga(palavraChave);
                }
            }
            return null;
        }
    }


    public String imprimirArvore(int nivel){
        String texto = this.toString();

        for(int i=0;i < nivel; i ++){
            texto += "\t";
        }
        if(this.esquerda != null){
            texto += "<-Esq" + this.esquerda.imprimirArvore(nivel + 1);
        }
        else{
            texto += "<-Esq: nulo";
        }

        texto += "\n";

        for(int i=0;i < nivel; i ++){
            texto += "\t";
        }

        if(this.direita != null){
            texto += "->Dir" + this.direita.imprimirArvore(nivel + 1);
        }
        else{
            texto += "->Dir: nulo";
        }
        texto += "\n";

        return texto;
    }

    public String toString(){
        return "["+this.raiz.getPalavraChave()+"] fb("+this.getFb()+")"+this.raiz.getLista().listar()+"\n";
    }

    public int calcularAltura(){

        if(this.esquerda == null && this.direita == null){
            return 1;
        }
        else if(this.esquerda != null && this.direita == null){
            return 1 + this.esquerda.calcularAltura();
        }
        else if(this.esquerda == null && this.direita != null){
            return 1 + this.direita.calcularAltura();
        }
        else{
            //caso tenha 2 filhos
            return 1 + Math.max(this.esquerda.calcularAltura(),this.direita.calcularAltura());
        }
    }

    public void calcularBalanceamento(){

        if(this.esquerda == null && this.direita == null){
            this.fb = 0;
        }
        else if(this.esquerda == null && this.direita != null){
            this.fb = this.direita.calcularAltura();
        }
        else if(this.esquerda != null && this.direita == null){
            this.fb = - this.esquerda.calcularAltura();
        }
        else{
            this.fb = this.direita.calcularAltura() - this.esquerda.calcularAltura();
        }

        if(this.direita != null) this.direita.calcularBalanceamento();
        if(this.esquerda != null) this.esquerda.calcularBalanceamento();
    }

    public ArvoreBinariaBusca verificarBalanceamento(){

            if(this.fb >= 2){
                //sinais iguais
                if(this.fb * this.direita.getFb() > 0){
                    return rotacaoSimplesDireita();
                }
                //sinais diferentes
                else{
                    return rotacaoDuplaDireita();
                }
            }
            else if(this.fb <= -2){
                if(this.fb * this.esquerda.getFb() > 0){
                    return rotacaoSimplesEsquerda();
                }
                else{
                    return rotacaoDuplaEsquerda();
                }
            }

        this.calcularBalanceamento();

        if(this.direita != null) this.direita = this.direita.verificarBalanceamento();
        if(this.esquerda != null) this.esquerda = this.esquerda.verificarBalanceamento();

        return this;
    }

    public ArvoreBinariaBusca rotacaoSimplesDireita(){

        System.out.println("rotacaoSimplesDireita");
        ArvoreBinariaBusca filhoDireita;
        ArvoreBinariaBusca neto = null;

        filhoDireita = this.getDireita();
        if(this.direita != null){
            if(this.direita.getEsquerda() != null){
                neto = filhoDireita.getEsquerda();
            }
        }
        filhoDireita.setEsquerda(this);
        this.setDireita(neto);
        return filhoDireita;
    }

    public ArvoreBinariaBusca rotacaoSimplesEsquerda(){

        System.out.println("rotacaoSimplesEsquerda");
        ArvoreBinariaBusca filhoEsquerda;
        ArvoreBinariaBusca neto = null;

        filhoEsquerda = this.getEsquerda();
        if(this.esquerda != null){
            if(this.esquerda.getEsquerda() != null){
                neto = filhoEsquerda.getDireita();
            }
        }
        filhoEsquerda.setDireita(this);
        this.setEsquerda(neto);
        return filhoEsquerda;
    }

    public ArvoreBinariaBusca rotacaoDuplaDireita(){

        System.out.println("rotacaoDuplaDireita");
        ArvoreBinariaBusca arvore = this;
        ArvoreBinariaBusca filhoDireita = this.getDireita();
        ArvoreBinariaBusca neto = filhoDireita.getEsquerda();
        ArvoreBinariaBusca noInserido = neto.getDireita();

        filhoDireita.setEsquerda(noInserido);
        neto.setDireita(filhoDireita);
        this.setDireita(neto);

        ArvoreBinariaBusca novoFilhoDireita = this.getDireita();
        arvore.setDireita(null);
        novoFilhoDireita.setEsquerda(arvore);

        return novoFilhoDireita;
    }

    public ArvoreBinariaBusca rotacaoDuplaEsquerda(){

        System.out.println("rotacaoDuplaEsquerda");
        ArvoreBinariaBusca arvore = this;
        ArvoreBinariaBusca filhoEsquerda = this.getEsquerda();
        ArvoreBinariaBusca neto = filhoEsquerda.getDireita();
        ArvoreBinariaBusca noInserido = neto.getEsquerda();

        filhoEsquerda.setDireita(noInserido);
        neto.setEsquerda(filhoEsquerda);
        this.setEsquerda(neto);

        ArvoreBinariaBusca novoFilhoEsquerda = this.getEsquerda();
        arvore.setEsquerda(null);
        novoFilhoEsquerda.setDireita(arvore);

        return novoFilhoEsquerda;
    }

}






