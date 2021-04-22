package projeto_LP2_AED2;

import Search.BST_AED2_2021;

public class GestaoAcessoCache implements GestaoCache{

    private BST_AED2_2021<Integer, Cache> caches = new BST_AED2_2021<>();
    private int numCache = 1;

    public BST_AED2_2021<Integer, Cache> getCaches() {
        return caches;
    }

    public void setCaches(BST_AED2_2021<Integer, Cache> caches) {
        this.caches = caches;
    }

    @Override
    public boolean adicionaCache(Cache cache) {
        caches.put(numCache,cache);
        numCache++;
        return true;
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
    public boolean depositaObjeto(Objeto objeto, Integer idCache) throws JaExisteObjetoNaCacheException {
        if(caches.get(idCache).getObjeto() == null){
            caches.get(idCache).setObjeto(objeto);
            return true;
        }
        throw new JaExisteObjetoNaCacheException("Já Existe Objeto na Cache!!");
    }

    @Override
    public boolean retiraObjeto(Objeto objeto, Integer idCache) throws JaExisteObjetoNaCacheException {
        if(caches.get(idCache).getObjeto().equals(objeto)){
            caches.get(idCache).removeObjeto(objeto);
            return true;
        }
        throw new JaExisteObjetoNaCacheException("Objeto não existe na cache!!");
    }
}
