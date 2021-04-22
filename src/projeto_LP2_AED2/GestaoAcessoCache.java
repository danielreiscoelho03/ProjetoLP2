package projeto_LP2_AED2;

public class GestaoAcessoCache implements GestaoCache{
    @Override
    public boolean adicionaCache(Integer dificuldade, String tipoCache, Aventureiro aventureiro) {
        return false;
    }

    @Override
    public boolean removeCache(Integer idCache) {
        return false;
    }

    @Override
    public boolean existeCache(Integer idCache) {
        return false;
    }

    @Override
    public boolean depositaObjeto(Objeto objeto) {
        return false;
    }

    @Override
    public boolean retiraObjeto(Objeto objeto) {
        return false;
    }
}
