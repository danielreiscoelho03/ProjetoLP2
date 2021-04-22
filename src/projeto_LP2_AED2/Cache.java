package projeto_LP2_AED2;

import edu.princeton.cs.algs4.BST;

import java.util.List;

public class Cache implements GestaoCache {

    public Integer idCache;
    private Integer dificuldade;
    public String tipoCache;
    public Aventureiro aventureiro;

    //public ArrayList<Objeto> listObjetos;
    //public ArrayList<LogsCache> histLogs;
    //public ArrayList<Objeto> item;
    public Localizacao local;

    private BST<Integer, Objeto> listObjetos = new BST<>();
    private BST<Integer, LogsCache> histLogs = new BST<>();
    private BST<Integer, Objeto> item = new BST<>();

  public Cache(Integer idCache, Integer dificuldade, String tipoCache, Aventureiro aventureiro) {
        this.idCache = idCache;
        this.dificuldade = dificuldade;
        this.tipoCache = tipoCache;
        this.aventureiro = aventureiro;
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

    @Override
    public boolean adicionaCache(Integer dificuldade, String tipoCache, Aventureiro aventureiro) {
      this.dificuldade = dificuldade;
      this.tipoCache = tipoCache;
      this.aventureiro = aventureiro;
      return false;
    }

    @Override
    public boolean removeCache(Integer idCache) {
        return false;
    }

    @Override
    public boolean existeCache(Integer idCache) {
        return false;
    }

    @Override
    public boolean depositaObjeto(Objeto objeto) {
        return false;
    }

    @Override
    public boolean retiraObjeto(Objeto objeto) {
        return false;
    }
}
