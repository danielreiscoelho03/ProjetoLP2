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
    private Cache cAtual;
    private Cache cProx;
    private BST_AED2_2021<Integer, PremiumCache> listaCachesPresente = new BST_AED2_2021<>();
    private BST_AED2_2021<Integer, Date> datas = new BST_AED2_2021<>();
    private BST_AED2_2021<Integer, Aventureiro> listaAventureiros = new BST_AED2_2021<>();
    private int numCachesPres = 1;
    private int numAventureiros;

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

    public void interpetarMissao(GestaoAcessoCache gc, GestaoAcessoAventureiro ga) {
        String[] parts = missao.split(" ");
        Integer idMissao = Integer.parseInt(parts[0]);
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
                System.out.println("Tem de levar o TravelBug para a cache: " + id);
                break;
            case 2:
                x = 1;
                k = 1;
                dist = 1000000;
                id = -1;
                while (k <= gc.getCaches().size()) {
                    if (gc.getCaches().get(x) != null) {
                        String toSave = null;
                        if (this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal()) < dist && this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal()) > 0) {
                            dist = this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal());
                            id = x;
                        }
                        k++;
                    }
                    x++;
                }
                System.out.println("Tem de levar o TravelBug para a cache: " + id);
                break;
            case 3:
                ArrayList<String> regioes = new ArrayList<>();
                x = 1;
                k = 1;
                String local;
                while (k <= gc.getCaches().size()) {
                    if (gc.getCaches().get(x) != null) {
                        local = gc.getCaches().get(x).getLocal().getLocalizacao();
                        //local = this.getCache().getLocal().getLocalizacao();
                        //System.out.println(local);
                        regioes.add(local);
                    }
                    x++;
                    k++;
                }
                Random rand = new Random();
        /*
        System.out.println("SIZE: " + regioes.size());
        for (String r: regioes){
          System.out.println(r);
        }
         */
                int posicao = rand.nextInt(regioes.size());
                System.out.println("Tem de levar o TravelBug para a região: " + regioes.get(posicao));
                break;
            case 4:
                ArrayList<String> regiao = new ArrayList<>();
                x = 1;
                k = 1;
                String loc;
                while (k <= gc.getCaches().size()) {
                    if (gc.getCaches().get(x) != null) {
                        loc = gc.getCaches().get(x).getLocal().getLocalizacao();
                        //local = this.getCache().getLocal().getLocalizacao();
                        //System.out.println(local);
                        regiao.add(loc);
                    }
                    x++;
                    k++;
                }
                Random r = new Random();
                int pos = r.nextInt(regiao.size());
                System.out.println("Tem de levar o TravelBug sem ser na região: " + regiao.get(pos));
                break;
            case 5:
                Random g = new Random();
                int h = g.nextInt(gc.getNumCache()-1);
                h++;
                System.out.println("Tem de levar o TravelBug em 24h para a cache: " + h);
                break;
            case 6:
                x = 1;
                k = 1;
                dist = 1000000;
                id = -1;
                while (k <= gc.getCaches().size()) {
                    if (gc.getCaches().get(x) != null) {
                        String toSave = null;
                        if (this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal()) < dist && this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal()) > 0) {
                            dist = this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal());
                            id = x;
                        }
                        k++;
                    }
                    x++;
                }
                System.out.println("Tem de levar o TravelBug para a cache em menos de 24h: " + id);
                break;
            case 7:
                x = 1;
                k = 1;
                dist = 0;
                id = 0;
                while (k <= gc.getCaches().size()) {
                    if (gc.getCaches().get(x) != null) {
                        String toSave = null;
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
                System.out.println("Tem de levar o TravelBug numa semana para a cache: " + id);
                break;
            case 8:
                break;
            case 9:
                //System.out.println(ga.getAventureiros().get(1).getListCacheVisit().get(1));
                if (this.listaAventureiros.get(0).getListCacheVisit().get(0) != null) {
                    System.out.println("Tem de levar o TravelBug para a cache com o ID: " + this.listaAventureiros.get(0).getListCacheVisit().get(0).getIdCache());
                }
                break;
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
                System.out.println("Tem de levar o TravelBug para a seguinte cache que ainda não visitaste com o seguinte ID: " + cacheNpresentes.get(posi));
                break;
            default:
                System.out.println("erro");
        }
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