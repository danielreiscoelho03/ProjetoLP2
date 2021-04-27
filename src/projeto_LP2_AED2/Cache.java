package projeto_LP2_AED2;

import edu.princeton.cs.algs4.BST;

public class Cache {

    public Integer idCache;
    private Integer dificuldade;
    public String tipoCache;
    private Aventureiro aventureiro;
    private Objeto objeto;
    private TravelBug travelbug;

    //public ArrayList<Objeto> listObjetos;
    //public ArrayList<LogsCache> histLogs;
    //public ArrayList<Objeto> item;
    public Localizacao local;

    //private BST<Integer, Objeto> listObjetos = new BST<>();
    // private BST<Integer, LogsCache> histLogs = new BST<>();
    private BST<Integer, Objeto> item = new BST<>();

    public Cache(Integer idCache, Integer dificuldade, Aventureiro aventureiro, Objeto objeto, int x, int y) throws AventureiroNaoHabilitado {
            this.idCache = idCache;
            this.dificuldade = dificuldade;
            this.objeto = objeto;
            this.aventureiro = aventureiro;
            this.local = new Localizacao(x, y);
            aventureiro.addCacheEsc(this);
    }

    public Cache(Integer idCache, Integer dificuldade, Aventureiro aventureiro, TravelBug tb, int x, int y) throws AventureiroNaoHabilitado {
        this.idCache = idCache;
        this.dificuldade = dificuldade;
        this.travelbug = tb;
        this.aventureiro = aventureiro;
        this.local = new Localizacao(x, y);
        aventureiro.addCacheEsc(this);
    }

    //Getters and Setters
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
        if(aventureiro != null){
            return "idCache: " + idCache +
                    ", dificuldade: " + dificuldade +
                    ", Dono da Cache: " + aventureiro.getNome() +
                    ", objeto: " + objeto.getNome();
        }
        return "idCache: " + idCache +
                ", dificuldade: " + dificuldade +
                ", objeto: " + objeto.getNome();

    }
}
