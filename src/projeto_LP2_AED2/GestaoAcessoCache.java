package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import Search.RedBlack_AED2;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;

import java.util.Date;

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
        System.out.println(toDiario);
        diario.adicionaLog(toDiario, data, "data/LogsCache");
        return true;
    }

    @Override
    public boolean removeCache(Integer idCache) throws CacheNaoExisteException{
        if(caches.contains(idCache)){
            caches.delete(idCache); //remove cache
            String toDiario = "Removeu a cache com o ID " + idCache;
            System.out.println(toDiario);
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

    public boolean guardarCache() throws CacheNaoExisteException{
        if(caches.size() > 0 ){
            Out outfile = new Out("data/Caches.txt");
            //System.out.println(caches.size());
            int x = 1, k = 1;
            while (k <= caches.size()){
                if(caches.get(x) != null){
                    if(caches.get(x).getObjeto() != null){
                        caches.get(x).getObjeto().guardarObjeto();
                    }
                    if (caches.get(x).getTravelbug() != null){
                        caches.get(x).getTravelbug().guardarTravelBug();
                    }
                    if(caches.get(x).getAventureiro() != null){
                        if(caches.get(x) instanceof BasicCache){
                            String toSave = "Basic " + caches.get(x).getIdCache() + " " + caches.get(x).getDificuldade() + " " + caches.get(x).getObjeto().getIdObjeto() + " " + caches.get(x).getAventureiro().getIdAventureiro() + " " + caches.get(x).getLocal().getCoordenadaX() + " " + caches.get(x).getLocal().getCoordenadaY() + " " + caches.get(x).getLocal().getLocalizacao(); ;
                            outfile.println(toSave);
                            k++;
                        }else if(caches.get(x) instanceof PremiumCache){
                            String toSave = "Premium " + caches.get(x).getIdCache() + " " + caches.get(x).getDificuldade() + " " + caches.get(x).getTravelbug().getIdObjeto() + " " + caches.get(x).getAventureiro().getIdAventureiro() + " " + caches.get(x).getLocal().getCoordenadaX() + " " + caches.get(x).getLocal().getCoordenadaY() + " " + caches.get(x).getLocal().getLocalizacao(); ;
                            outfile.println(toSave);
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
        In infile2 = new In("data/Objeto.txt");
        int k = 1, j = 1;
        String line = null;
        String line2 = null;
        String[] lerObjetos = infile2.readAllLines();
        Out outfile = new Out("data/Objeto.txt");
        outfile.println("OBJETOS");
        while((line = infile.readLine()) != null){
            //System.out.println(line);
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
            while(lerObjetos.length > k){
                //System.out.println("BROUAS ENTREI");
                String[] parts2 = lerObjetos[k].split(" ");
                String tipo = parts2[0];
                String idObj = parts2[1];
                int idObje = Integer.parseInt(idObj);
                String nomeObj = parts2[2];
                if(idO == idObje){
                    j=1;
                    while(ga.getAventureiros().size() >= j){
                        if(ga.getAventureiros().get(j).getIdAventureiro() == idA){
                            if(tipo.equals("Travelbug")){
                                int i = 4;
                                StringBuilder missao = new StringBuilder(parts2[3]);
                                while(!parts2[i].equals(".")){
                                    missao.append(" ").append(parts2[i]);
                                    i++;
                                }
                                TravelBug tb = new TravelBug(nomeObj, missao.toString());
                                tb.setIdObjeto(go.getNumTb()+1);
                                go.setNumTb(go.getNumTb()+1);
                                PremiumCache pc = new PremiumCache(dific, ga.getAventureiros().get(j), tb, cX,cY,local);
                                pc.idCache = numCache;
                                caches.put(numCache,pc);
                                numCache++;
                                //System.out.println("ADICIONEI UMA CACHE");
                                k = lerObjetos.length;
                                j = ga.getAventureiros().size();
                            }
                            else{
                                Objeto o = new Objeto(nomeObj);
                                BasicCache bc = new BasicCache(dific, ga.getAventureiros().get(j), o, cX,cY,local);
                                o.setIdObjeto(go.getNumObjeto()+1);
                                go.setNumObjeto(go.getNumObjeto()+1);
                                bc.idCache = numCache;
                                caches.put(numCache,bc);
                                numCache++;
                                System.out.println("ADICIONEI UMA CACHE");
                                k = lerObjetos.length;
                                j = ga.getAventureiros().size();
                            }
                        }
                        j++;
                    }
                }
                k++;
            }
            k = 1;
        }
    }
}
