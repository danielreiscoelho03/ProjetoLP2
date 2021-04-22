package projeto_LP2_AED2;

import edu.princeton.cs.algs4.BST;

public class Cache {

    public Integer idCache;
    private Integer dificuldade;
    public String tipoCache;
    public Aventureiro aventureiro;
    private Objeto objeto;

    //public ArrayList<Objeto> listObjetos;
    //public ArrayList<LogsCache> histLogs;
    //public ArrayList<Objeto> item;
    public Localizacao local;

    //private BST<Integer, Objeto> listObjetos = new BST<>();
    private BST<Integer, LogsCache> histLogs = new BST<>();
    private BST<Integer, Objeto> item = new BST<>();

    public Cache(Integer idCache, Integer dificuldade, Aventureiro aventureiro) {
        this.idCache = idCache;
        this.dificuldade = dificuldade;
        this.aventureiro = aventureiro;
    }

    public Cache(Integer idCache, Integer dificuldade, Aventureiro aventureiro, Objeto objeto) {
        this.idCache = idCache;
        this.dificuldade = dificuldade;
        this.aventureiro = aventureiro;
        this.objeto = objeto;
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

    public void setAventureiro(Aventureiro aventureiro) {
        this.aventureiro = aventureiro;
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

    public void removeObjeto(Objeto objeto){
        this.objeto = null;
    }

    @Override
    public String toString() {
        return "Cache{" +
                "idCache=" + idCache +
                ", dificuldade=" + dificuldade +
                ", aventureiro=" + aventureiro +
                ", objeto=" + objeto +
                '}' + "\n";
    }
}
