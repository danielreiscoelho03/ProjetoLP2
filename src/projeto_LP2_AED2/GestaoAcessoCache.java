package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

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
        //cache.getAventureiro().getListCacheEsc().put(cache.getIdCache(),cache);
        //caches.get(cache.getIdCache()).getAventureiro().addCacheVis(cache); //remove cache das caches escondidas do utilizador que a tem
        //cache.getAventureiro().getListCacheEsc().printInOrder( cache.getAventureiro().getListCacheEsc().getRoot());
        String toDiario = "Adicionada cache com o ID " + cache.getIdCache();
        System.out.println(toDiario);
        diario.adicionaLog(toDiario, data, "data/LogsCache");
        return true;
    }

    @Override
    public boolean removeCache(Integer idCache) throws CacheNaoExisteException{
        if(caches.contains(idCache)){
            caches.delete(idCache); //remove cache
            //caches.get(idCache).getAventureiro().removeCacheEsc(caches.get(idCache)); //remove cache das caches escondidas do utilizador que a tem
            //caches.get(idCache).getAventureiro().setNumCacheEsc(caches.get(idCache).getAventureiro().getNumCacheEsc() + 1);
            String toDiario = "Removeu a cache com o ID " + idCache;
            System.out.println(toDiario);
            diario.adicionaLog(toDiario, data, "data/LogsCache");
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
    public boolean depositaObjeto(Objeto objeto, Cache Cache) throws JaExisteObjetoNumaCacheException {
    // || !caches.contains(objeto.getIdObjeto())
        //System.out.println(caches.size());
        int x = 1;
        while(x <= caches.size()) {
            System.out.println(caches.get(x).getIdCache());
            if (caches.get(x).getIdCache().equals(Cache.idCache)) { //se objeto não existir nessa cache ou não estiver noutra
                caches.get(x).setObjeto(objeto);
                String toDiario = "Depositou o " + objeto.toString() + " na Cache com o ID " + Cache.idCache;
                System.out.println(toDiario);
                diario.adicionaLog(toDiario, data, "data/LogsCache");
                return true;
            }
            x++;
        }
        throw new JaExisteObjetoNumaCacheException("Objeto já existe numa Cache!!");

    }

    @Override
    public boolean retiraObjeto(Cache Cache) throws JaExisteObjetoNumaCacheException {
        int x = 1;
        while(x <= caches.size()) {
            //System.out.println(caches.get(x).getObjeto().toString());

            if(caches.get(x).getIdCache().equals(Cache.idCache)){
                String toDiario = "Retirou o " + caches.get(x).getObjeto().toString() + " na Cache com o id: " + Cache.idCache;
                caches.get(x).setObjeto(null);
                System.out.println(toDiario);
                diario.adicionaLog(toDiario, data, "data/LogsCache");
                return true;
            }
            x++;
        }
        throw new JaExisteObjetoNumaCacheException("Objeto não existe na cache!!");
    }


    public int id(){
        int k = 0;
        In infile = new In("data/idCounter");
        int[] idCounter = infile.readAllInts();
        int rId = idCounter[1];
        idCounter[1]++;
        Out outfile = new Out("data/idCounter");
        while(k<3){
            outfile.println(idCounter[k]);
            k++;
        }
        return rId;
    }
}
