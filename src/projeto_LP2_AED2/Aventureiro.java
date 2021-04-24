package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import edu.princeton.cs.algs4.BST;

import java.util.Date;

public abstract class Aventureiro {

    //private BST<Integer, LogsDiario> histLogs = new BST<>();
    //private LogsDiario histLogs;

    private Integer idAventureiro;
    private String nome;
    private LogsDiario diario = new LogsDiario();
    private Localizacao local;
    private int numCacheVis;
    private int numCacheEsc;
    private int numObj;
    private Date data = new Date();

    private BST_AED2_2021<Integer, Cache> listCacheVisit = new BST_AED2_2021<>();
    private BST_AED2_2021<Integer, Cache> listCacheEsc = new BST_AED2_2021<>();
    private BST_AED2_2021<Integer, Objeto> listObjetos = new BST_AED2_2021<>();

    public Aventureiro(Integer idAventureiro, String nome, int x, int y) {
        this.idAventureiro = idAventureiro;
        this.nome = nome;
        this.local = new Localizacao(x, y);
    }

    public int getNumCacheVis() {
        return numCacheVis;
    }

    public void setNumCacheVis(int numCacheVis) {
        this.numCacheVis = numCacheVis;
    }

    public int getNumCacheEsc() {
        return numCacheEsc;
    }

    public void setNumCacheEsc(int numCacheEsc) {
        this.numCacheEsc = numCacheEsc;
    }

    public Localizacao getLocal() {
        return local;
    }

    public void setLocal(Localizacao local) {
        this.local = local;
    }

    public Integer getIdAventureiro() {
        return idAventureiro;
    }

    public void setIdAventureiro(Integer idAventureiro) {
        this.idAventureiro = idAventureiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BST_AED2_2021<Integer, Cache> getListCacheVisit() {
        return listCacheVisit;
    }

    public BST_AED2_2021<Integer, Cache> getListCacheEsc() {
        return listCacheEsc;
    }

    public void addCacheVis(Cache c){
        listCacheVisit.put(numCacheVis,c);
        numCacheVis++;
        String toDiario ="O utilizador " + this.getNome() + " visitou esta cache: " + c.toString();
        diario.adicionaLog(toDiario, data,"data/LogsAventureiro");
        toDiario = "Dados do utilizador: " + this.toString();
        diario.adicionaLog(toDiario,data,"data/LogsAventureiro");

    }

    public void addCacheEsc(Cache c){
        listCacheEsc.put(numCacheEsc,c);
        numCacheEsc++;
        String toDiario = "O utilizador " + this.getNome() + " criou e escondeu esta cache: " + c.toString();
        diario.adicionaLog(toDiario, data, "data/LogsAventureiro");
        toDiario = "Dados do utilizador: " + this.toString();
        diario.adicionaLog(toDiario,data,"data/LogsAventureiro");
    }

    public void removeCacheEsc(Cache c) throws CacheNaoExisteException {
        if(this.getListCacheEsc().contains(c.idCache)){
            this.getListCacheEsc().delete(c.idCache);
        }
        throw new CacheNaoExisteException("Esta a remover uma cache que nao existe");
    }

    public void encontrouCache(Cache c, Objeto o){
        this.listObjetos.put(numObj, c.getObjeto());
        numObj++;
        this.addCacheVis(c);
        c.removeObjeto(c.getObjeto());
        c.setObjeto(o);
    }

    @Override
    public String toString() {
        return "Id: " + idAventureiro +
                ", nome: " + nome +
                ", local: " + local +
                ", numCacheVis: " + numCacheVis +
                ", numCacheEsc: " + numCacheEsc;
    }
}