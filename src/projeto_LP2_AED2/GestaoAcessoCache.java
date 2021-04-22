package projeto_LP2_AED2;

import edu.princeton.cs.algs4.BST;

public class GestaoAcessoCache implements GestaoCache{

    private BST<Integer, Cache> caches = new BST<>();

    @Override
    public boolean adicionaCache(Integer dificuldade, String tipoCache, Aventureiro aventureiro) {

        return false;
    }

    @Override
    public boolean removeCache(Integer idCache) throws CacheNaoExisteException{

        if(caches.contains(idCache)){
            caches.delete(idCache);
            return true;
        }
        throw new CacheNaoExisteException("Cache a remover não existe!!");
    }

    @Override
    public boolean existeCache(Integer idCache) {
        if(caches.contains(idCache)){
            return true;
        }
        return false;
    }

    @Override
    public boolean depositaObjeto(Objeto objeto, Integer idCache) {
        caches.get(idCache).setObjeto(objeto);
        return true;
    }

    @Override
    public boolean retiraObjeto(Objeto objeto, Integer idCache) throws ObjetoNaoExisteNaCacheException{
        if(caches.get(idCache).getObjeto().equals(objeto)){
            caches.get(idCache).removeObjeto(objeto);
            return true;
        }
        throw new ObjetoNaoExisteNaCacheException("Objeto não existe na cache!!");
    }
}
