package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import Search.RedBlack_AED2;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;


public class GestaoAcessoCache implements GestaoCache{

    //private BST_AED2_2021<Integer, Cache> caches = new BST_AED2_2021<>();
    private RedBlack_AED2<Integer, Cache> caches = new RedBlack_AED2<>();
    GestaoAcessoObjeto gao = new GestaoAcessoObjeto();
    private int numCache = 1;
    private LogsDiario diario = new LogsDiario();
    private Date data = new Date();

    /*
    public BST_AED2_2021<Integer, Cache> getCaches() {
        return caches;
    }

    public void setCaches(BST_AED2_2021<Integer, Cache> caches) {
        this.caches = caches;
    }

     */

    public int getNumCache() {
        return numCache;
    }

    public void setNumCache(int numCache) {
        this.numCache = numCache;
    }

    public RedBlack_AED2<Integer, Cache> getCaches() {
        return caches;
    }

    public void setCaches(RedBlack_AED2<Integer, Cache> caches) {
        this.caches = caches;
    }

    @Override
    public boolean adicionaCache(Cache cache) {
        cache.setIdCache(numCache);
        caches.put(numCache,cache);
        numCache++;
        String toDiario = "Adicionada cache com o ID " + cache.getIdCache();
        //System.out.println(toDiario);
        diario.adicionaLog(toDiario, data, "data/LogsCache");
        return true;
    }

    @Override
    public boolean removeCache(Integer idCache) throws CacheNaoExisteException{
        if(caches.contains(idCache)){
            caches.delete(idCache); //remove cache
            String toDiario = "Removeu a cache com o ID " + idCache;
            //System.out.println(toDiario);
            diario.adicionaLog(toDiario, data, "data/Arquivo.txt");
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
        int x = 1;
        while(x <= caches.size()) {
            //System.out.println(caches.get(x).getIdCache());
            if (caches.get(x).getIdCache().equals(Cache.idCache)) { //se objeto não existir nessa cache ou não estiver noutra
                caches.get(x).setObjeto(objeto);
                String toDiario = "Depositou o " + objeto.toString() + " numa Cache com o ID " + Cache.idCache;
                //System.out.println(toDiario);
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
                //System.out.println(toDiario);
                diario.adicionaLog(toDiario, data, "data/LogsCache");
                return true;
            }
            x++;
        }
        throw new JaExisteObjetoNumaCacheException("Objeto não existe na cache!!");
    }

    public boolean guardarCache() throws CacheNaoExisteException{
        if(caches.size() > 0 ){
            Out outfile = new Out("data/Caches.txt");
            //System.out.println(caches.size());
            int x = 1, k = 1;
            while (k <= caches.size()){
                if(caches.get(x) != null){
                    if(caches.get(x).getAventureiro() != null){
                        if(caches.get(x) instanceof BasicCache){
                            StringBuilder toSave = new StringBuilder("Basic " + caches.get(x).getIdCache() + " " + caches.get(x).getDificuldade() + " " + caches.get(x).getObjeto().getIdObjeto() + " " + caches.get(x).getAventureiro().getIdAventureiro() + " " + caches.get(x).getLocal().getCoordenadaX() + " " + caches.get(x).getLocal().getCoordenadaY() + " " + caches.get(x).getLocal().getLocalizacao());
                            int numAvent = caches.get(x).getNumAvent();
                            toSave.append(" ").append(caches.get(x).getNumAvent());
                            int j = 0;
                            while(j < caches.get(x).getHistAventureiros().size()) {
                                toSave.append(" ").append(caches.get(x).getHistAventureiros().get(j).getIdAventureiro());
                                j++;
                            }
                            outfile.println(toSave.toString());
                            k++;
                        }else if(caches.get(x) instanceof PremiumCache){
                            StringBuilder toSave = new StringBuilder("Premium " + caches.get(x).getIdCache() + " " + caches.get(x).getDificuldade() + " " + caches.get(x).getTravelbug().getIdObjeto() + " " + caches.get(x).getAventureiro().getIdAventureiro() + " " + caches.get(x).getLocal().getCoordenadaX() + " " + caches.get(x).getLocal().getCoordenadaY() + " " + caches.get(x).getLocal().getLocalizacao()); ;
                            int numAvent = caches.get(x).getNumAvent();
                            toSave.append(" ").append(caches.get(x).getNumAvent());
                            int j = 0;
                            while(j < caches.get(x).getHistAventureiros().size()) {
                                toSave.append(" ").append(caches.get(x).getHistAventureiros().get(j).getIdAventureiro());
                                j++;
                            }
                            outfile.println(toSave.toString());
                            k++;
                        }
                    }
                }
                x++;
            }
            return true;
        }
        throw new CacheNaoExisteException("Cache nao Existe!");
    }

    @Override
    public void lerCache(GestaoAcessoAventureiro ga, GestaoAcessoObjeto go) throws AventureiroNaoHabilitado {
        In infile = new In("data/Caches.txt");
        ArrayList<Integer> idAventureiro = new ArrayList<>();
        int k = 1, j = 1;
        String line = null;
        while((line = infile.readLine()) != null){
            idAventureiro.removeAll(idAventureiro);
            String[] parts = line.split(" ");
            String idCache = parts[1];
            int idC = Integer.parseInt(idCache);
            String dif = parts[2];
            int dific = Integer.parseInt(dif);
            String idObjeto = parts[3];
            int idO = Integer.parseInt(idObjeto);
            String idAvent = parts[4];
            int idA = Integer.parseInt(idAvent);
            String coordX = parts[5];
            int cX = Integer.parseInt(coordX);
            String coordY = parts[6];
            int cY = Integer.parseInt(coordY);
            String local = parts[7];
            String numA = parts[8];
            int numAvent = Integer.parseInt(numA);
            int p = numAvent, i = 9;
            while(p>0){
                idAventureiro.add(Integer.parseInt(parts[i]));
                i++;
                p--;
            }
            if(parts[0].equals("Premium")){
                PremiumCache c = new PremiumCache(dific, ga.getAventureiros().get(idA), go.getTravelBug().get(idO), cX, cY, local);
                int x = 0;
                //c.setNumAvent(0);
                while (idAventureiro.size() > x) {
                    c.getHistAventureiros().put(c.getNumAvent(), ga.getAventureiros().get(idAventureiro.get(x)));
                    c.setNumAvent(c.getNumAvent()+1);
                    x++;
                }
                c.setIdCache(numCache);
                getCaches().put(numCache, c);
                setNumCache(getNumCache()+1);
            }else if(parts[0].equals("Basic")){
                System.out.println("ola");
            }
        }
    }
}
