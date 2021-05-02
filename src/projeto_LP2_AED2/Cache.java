package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import edu.princeton.cs.algs4.BST;

public class Cache {

    public Integer idCache; //ta
    private Integer dificuldade; //ta
    public String tipoCache;
    private Aventureiro aventureiro; //id
    private Objeto objeto; //id
    private TravelBug travelbug; //id
    public Localizacao local; //x e y e localizacao
    //private BST<Integer, Objeto> item = new BST<>();
    private BST_AED2_2021<Integer, Aventureiro> histAventureiros = new BST_AED2_2021<>();
    private int numAvent;

    public Cache(Integer dificuldade, Aventureiro aventureiro, Objeto objeto, int x, int y, String local) throws AventureiroNaoHabilitado {
            this.dificuldade = dificuldade;
            this.objeto = objeto;
            objeto.setCache(this);
            this.aventureiro = aventureiro;
            this.local = new Localizacao(x, y, local);
            aventureiro.addCacheEsc(this);
    }

    public BST_AED2_2021<Integer, Aventureiro> getHistAventureiros() {
        return histAventureiros;
    }

    public void setHistAventureiros(BST_AED2_2021<Integer, Aventureiro> histAventureiros) {
        this.histAventureiros = histAventureiros;
    }

    public int getNumAvent() {
        return numAvent;
    }

    public void setNumAvent(int numAvent) {
        this.numAvent = numAvent;
    }

    public Cache(Integer dificuldade, Aventureiro aventureiro, TravelBug tb, int x, int y, String local) throws AventureiroNaoHabilitado {
        this.dificuldade = dificuldade;
        this.travelbug = tb;
        tb.setCache(this);
        tb.getDatas().put(tb.getNumCachesPres(), new Date());
        tb.getListaCachesPresente().put(tb.getNumCachesPres(), (PremiumCache) this);
        tb.setNumCachesPres(tb.getNumCachesPres()+1);
        this.aventureiro = aventureiro;
        this.local = new Localizacao(x, y, local);
        aventureiro.addCacheEsc(this);
    }

    //Getters and Setters


    public TravelBug getTravelbug() {
        return travelbug;
    }

    public void setTravelbug(TravelBug travelbug) {
        this.travelbug = travelbug;
    }

    public Integer getIdCache() {
        return idCache;
    }

    public void setIdCache(Integer idCache) {
        this.idCache = idCache;
    }

    public Integer getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Integer dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getTipoCache() {
        return tipoCache;
    }

    public void setTipoCache(String tipoCache) {
        this.tipoCache = tipoCache;
    }

    public Aventureiro getAventureiro() {
        return aventureiro;
    }

    public void setAventureiro(Aventureiro aventureiro) throws AventureiroNaoHabilitado {
        this.aventureiro = aventureiro;
        this.getAventureiro().addCacheEsc(this);
    }

    public Localizacao getLocal() {
        return local;
    }

    public void setLocal(Localizacao local) {
        this.local = local;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public Objeto removeObjeto(Objeto objeto){
        Objeto obj = this.objeto;
        this.objeto = null;
        return obj;
    }

    @Override
    public String toString() {
        if(objeto != null){
            return "idCache: " + idCache +
                    ", dificuldade: " + dificuldade +
                    ", Dono da Cache: " + aventureiro.getNome() +
                    ", objeto: " + objeto.getNome() +
                    ", Localização: " + local.getCoordenadaX() + ","
                    + local.getCoordenadaY() + " -> " + local.getLocalizacao();

        }
        else if(travelbug != null){
            return "idCache: " + idCache +
                    ", dificuldade: " + dificuldade +
                    ", Dono da Cache: " + aventureiro.getNome() +
                    ", TravelBug: " + travelbug.getNome() + ", Localização: " + local.getCoordenadaX() + ","
                    + local.getCoordenadaY() + "->" + local.getLocalizacao();


        }
        return null;
    }

    public void verTodosAventVis(){
        if(histAventureiros.size()>0)
            histAventureiros.printInOrder(histAventureiros.getRoot());
    }

}
