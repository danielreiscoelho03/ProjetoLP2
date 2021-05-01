package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class TravelBug extends Objeto {
    private boolean viajar;
    public String missao;
    private BST_AED2_2021<Integer, PremiumCache> listaCachesPresente = new BST_AED2_2021<>();
    private BST_AED2_2021<Integer, Date> datas = new BST_AED2_2021<>();
    private BST_AED2_2021<Integer, Aventureiro> listaAventureiros = new BST_AED2_2021<>();
    private int numCachesPres = 1;
    private int numAventureiros;

    public BST_AED2_2021<Integer, Date> getDatas() {
        return datas;
    }

    public void setDatas(BST_AED2_2021<Integer, Date> datas) {
        this.datas = datas;
    }

    public boolean isViajar() {
        return viajar;
    }

    public void setViajar(boolean viajar) {
        this.viajar = viajar;
    }

    public String getMissao() {
        return missao;
    }

    public int getNumCachesPres() {
        return numCachesPres;
    }

    public void setNumCachesPres(int numCachesPres) {
        this.numCachesPres = numCachesPres;
    }

    public BST_AED2_2021<Integer, PremiumCache> getListaCachesPresente() {
        return listaCachesPresente;
    }

    public void setListaCachesPresente(BST_AED2_2021<Integer, PremiumCache> listaCachesPresente) {
        this.listaCachesPresente = listaCachesPresente;
    }

    public void setMissao(String missao) {
        this.missao = missao;
    }

    public BST_AED2_2021<Integer, Aventureiro> getListaAventureiros() {
        return listaAventureiros;
    }

    public void setListaAventureiros(BST_AED2_2021<Integer, Aventureiro> listaAventureiros) {
        this.listaAventureiros = listaAventureiros;
    }

    public int getNumAventureiros() {
        return numAventureiros;
    }

    public void setNumAventureiros(int numAventureiros) {
        this.numAventureiros = numAventureiros;
    }

    public TravelBug(String nome) {
        super(nome);
        Random num = new Random();
        int posicao = num.nextInt(10);
        lerMissao(1);
    }

    public TravelBug(String nome, String m) {
        super(nome);
        missao = m;
    }

    public void lerMissao(int posicao) {
        In infile = new In("data/Missoes.txt");
        String[] missoes = infile.readAllLines();
        int x = 0;
        while (missoes.length > x) {
            String[] parts = missoes[x].split("-");
            int pos = Integer.parseInt(parts[0]);
            StringBuilder m = new StringBuilder();
            if (pos == posicao) {
                m.append(parts[0]).append(" ").append(parts[1]);
                missao = m.toString();
            }
            x++;
        }
    }

    public ArrayList<Cache> interpetarMissao(GestaoAcessoCache gc, GestaoAcessoAventureiro ga) {
        String[] parts = missao.split(" ");
        Integer idMissao = Integer.parseInt(parts[0]);
        ArrayList<Cache> tempCache = new ArrayList<>();
        switch (idMissao) {
            case 1:
                int x = 1, k = 1, id = 0;
                double dist = 0;
                while (k <= gc.getCaches().size()) {
                    if (gc.getCaches().get(x) != null) {
                        if (this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal()) > dist) {
                            if (gc.getCaches().get(x) instanceof PremiumCache) {
                                dist = this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal());
                                id = x;
                            }
                        }
                        k++;
                    }
                    x++;
                }
                tempCache.add(gc.getCaches().get(id));
                return tempCache;
            case 2:
                x = 1;
                k = 1;
                dist = 1000000;
                id = -1;
                while (k <= gc.getCaches().size()) {
                    if (gc.getCaches().get(x) != null) {
                        if (this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal()) < dist && this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal()) > 0) {
                            dist = this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal());
                            id = x;
                        }
                        k++;
                    }
                    x++;
                }
                tempCache.add(gc.getCaches().get(id));
                return tempCache;
            case 3:
                ArrayList<String> regioes = new ArrayList<>();
                x = 1;
                k = 1;
                String local;
                while (k <= gc.getCaches().size()) {
                    if (gc.getCaches().get(x) != null) {
                        local = gc.getCaches().get(x).getLocal().getLocalizacao();
                        regioes.add(local);
                        k++;
                    }
                    x++;
                }
                Random rand = new Random();
                int posicao = rand.nextInt(regioes.size());
                k = 1;
                x = 1;
                while (k <= gc.getCaches().size()) {
                    if (gc.getCaches().get(x) != null) {
                        if(gc.getCaches().get(x).getLocal().getLocalizacao().equals(regioes.get(posicao))){
                            tempCache.add(gc.getCaches().get(x));
                        }
                        k++;
                    }
                    x++;
                }
                return tempCache;
            case 4:
                ArrayList<String> regiao = new ArrayList<>();
                x = 1;
                k = 1;
                String loc;
                while (k <= gc.getCaches().size()) {
                    if (gc.getCaches().get(x) != null) {
                        loc = gc.getCaches().get(x).getLocal().getLocalizacao();
                        regiao.add(loc);
                        k++;
                    }
                    x++;
                }
                Random r = new Random();
                int pos = r.nextInt(regiao.size());
                k = 1;
                x = 1;
                while (k <= gc.getCaches().size()) {
                    if (gc.getCaches().get(x) != null) {
                        if(!gc.getCaches().get(x).getLocal().getLocalizacao().equals(regiao.get(pos))){
                            tempCache.add(gc.getCaches().get(x));
                        }
                        k++;
                    }
                    x++;
                }
                //System.out.println("Levar o TravelBug para uma região sem ser: " + regiao.get(pos));
                return tempCache;
            case 5:
                Random g = new Random();
                int h = g.nextInt(gc.getNumCache()-1);
                h++;
                //System.out.println("Levar o TravelBug em 24h para a cache: " + h);
                tempCache.add(gc.getCaches().get(h));
                return tempCache;
            case 6:
                x = 1;
                k = 1;
                dist = 1000000;
                id = -1;
                while (k <= gc.getCaches().size()) {
                    if (gc.getCaches().get(x) != null) {
                        if (this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal()) < dist && this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal()) > 0) {
                            dist = this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal());
                            id = x;
                        }k++;
                    }x++;
                }
                tempCache.add(gc.getCaches().get(id));
                return tempCache;
            case 7:
                x = 1;
                k = 1;
                dist = 0;
                id = 0;
                while (k <= gc.getCaches().size()) {
                    if (gc.getCaches().get(x) != null) {
                        if (this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal()) > dist) {
                            if (gc.getCaches().get(x) instanceof PremiumCache) {
                                dist = this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal());
                                id = x;
                            }
                        }
                        k++;
                    }
                    x++;
                }
                tempCache.add(gc.getCaches().get(id));
                return tempCache;
            case 8:
                //System.out.println("Ver se aventureiro tem caches visitadas: " + this.listaAventureiros.get(numAventureiros-1).getListCacheVisit().get(numCachesPres-1));
                //System.out.println("CACHES PRESENTES: " + numCachesPres);
                if (this.listaAventureiros.get(numAventureiros-1).getListCacheVisit().get(numCachesPres-1) == null) {
                    System.out.println("Visto que não tens ainda nenhuma cache visitada, leva o TravelBug para uma cache qualquer.");
                }
                else if(this.listaAventureiros.get(numAventureiros-1).getListCacheVisit().get(numCachesPres-1) != null) {
                    //System.out.println("Tem de levar o TravelBug para a cache com o ID: " + this.listaAventureiros.get(numAventureiros-1).getListCacheVisit().get(numCachesPres-1).getIdCache());
                    tempCache.add(gc.getCaches().get(this.listaAventureiros.get(numAventureiros-1).getListCacheVisit().get(numCachesPres-1).getIdCache()));
                }
                return tempCache;
            case 9:
                /*
                System.out.println("1print " + ga.getAventureiros().get(1).getListCacheVisit().get(1));
                System.out.println("Caches deste Utilizador: ");
                System.out.println("1 -> " + this.listaAventureiros.get(numAventureiros-1).getListCacheVisit().get(numCachesPres-2));
                System.out.println("2 -> " + this.listaAventureiros.get(numAventureiros-1).getListCacheVisit().get(numCachesPres-1));
                System.out.println("NUMERO DE CACHES PRESENTES : " + numCachesPres);
                 */
                if (this.listaAventureiros.get(numAventureiros-1).getListCacheVisit().get(numCachesPres-1) == null) {
                    System.out.println("Visto que esta é a tua primeira cache visitada, leva o TravelBug para uma cache qualquer.");
                }
                else if(this.listaAventureiros.get(numAventureiros-1).getListCacheVisit().get(numCachesPres-1) == null){
                    //System.out.println("Tem de levar o TravelBug para a cache com o ID: " + this.listaAventureiros.get(numAventureiros-1).getListCacheVisit().get(0).getIdCache());
                    tempCache.add(gc.getCaches().get(this.listaAventureiros.get(numAventureiros-1).getListCacheVisit().get(0).getIdCache()));
                }
                return tempCache;
            case 10:
                x = 0;
                k = 1;
                int cache;
                ArrayList<Integer> cacheNpresentes = new ArrayList<>();
                while (k <= gc.getCaches().size()) {
                    if (gc.getCaches().get(k) != null) {
                        //System.out.println(this.getListaAventureiros().get(numAventureiros).getListCacheVisit().get(x).getIdCache());
                        while (this.getListaAventureiros().get(numAventureiros - 1).getListCacheVisit().size() > x) {
                            if (!this.getListaAventureiros().get(numAventureiros - 1).getListCacheVisit().get(x).getIdCache().equals(gc.getCaches().get(k).getIdCache())) {
                                cache = gc.getCaches().get(k).getIdCache();
                                cacheNpresentes.add(cache);
                            }
                            x++;
                        }
                        x = 0;
                    }
                    k++;
                }
                Random a = new Random();
                int posi = a.nextInt(cacheNpresentes.size());
                //System.out.println("Levar o TravelBug para a seguinte cache que ainda não visitaste com o seguinte ID: " + cacheNpresentes.get(posi));
                tempCache.add(gc.getCaches().get(cacheNpresentes.get(posi)));
                return tempCache;
            default:
                System.out.println("erro");
        }
        return null;
    }

    public void guardarTravelBug() {
        int k = 0;
        In infile = new In("data/Objeto.txt");
        String[] lines = infile.readAllLines();
        Out outfile = new Out("data/Objeto.txt");
        String toFile = "Travelbug " + getIdObjeto() + " " + getNome() + " " + getMissao() + " .";
        while (lines.length > k) {
            outfile.println(lines[k]);
            k++;
        }
        outfile.println(toFile);
    }

    @Override
    public String toString() {
        return super.toString() + ", missao: " + missao;
    }
}