package projeto_LP2_AED2;

public class ObjetoNaoExisteNaCacheException extends Exception {
    public ObjetoNaoExisteNaCacheException( String message){
        super(message);
    }
}