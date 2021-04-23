package projeto_LP2_AED2;

import Search.BST_AED2_2021;

import java.util.Date;

public class GestaoAcessoCache implements GestaoCache{

    private BST_AED2_2021<Integer, Cache> caches = new BST_AED2_2021<>();
    GestaoAcessoObjeto gao = new GestaoAcessoObjeto();
    private int numCache = 1;
    private LogsDiario diario = new LogsDiario();
    private Date data = new Date();

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
        String toDiario = "Adicionada cache: " + cache.toString();
        System.out.println(toDiario);
        diario.adicionaLog(toDiario, data);
        return true;
    }

    @Override
    public boolean removeCache(Integer idCache) throws CacheNaoExisteException{
        if(caches.contains(idCache)){
            caches.delete(idCache);
            String toDiario = "Removeu a cache com id: " + idCache;
            System.out.println(toDiario);
            diario.adicionaLog(toDiario, data);
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
    public boolean depositaObjeto(Objeto objeto, Integer idCache) throws JaExisteObjetoNumaCacheException {

        if(caches.get(idCache).getObjeto() == null && caches.contains(objeto.getIdObjeto())){ //se objeto não existir nessa cache ou não estiver noutra
            caches.get(idCache).setObjeto(objeto);
            String toDiario = "Depositou o objeto: " + objeto.toString() + " na Cache " + idCache;
            System.out.println(toDiario);
            diario.adicionaLog(toDiario, data);
            return true;
        }
        throw new JaExisteObjetoNumaCacheException("Objeto já existe numa Cache!!");

    }

    @Override
    public boolean retiraObjeto(Objeto objeto, Integer idCache) throws JaExisteObjetoNumaCacheException {
        if(caches.get(idCache).getObjeto().equals(objeto)){
            caches.get(idCache).removeObjeto(objeto);
            String toDiario = "Retirou o objeto: " + objeto.toString() + " na Cache " + idCache;
            System.out.println(toDiario);
            diario.adicionaLog(toDiario, data);
            return true;
        }
        throw new JaExisteObjetoNumaCacheException("Objeto não existe na cache!!");
    }
}
