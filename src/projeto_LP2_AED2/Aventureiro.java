package projeto_LP2_AED2;

import edu.princeton.cs.algs4.BST;

public abstract class Aventureiro {

    private Integer idAventureiro;
    private String nome;
    private LogsDiario diario;

    private BST<Integer, Cache> listCacheVisit = new BST<>();
    private BST<Integer, Cache> listCacheEsc = new BST<>();
    //private BST<Integer, LogsDiario> histLogs = new BST<>();
    private LogsDiario histLogs;
    private BST<Integer, Objeto> listObjetos = new BST<>();

    public Aventureiro(Integer idAventureiro, String nome) {
        this.idAventureiro = idAventureiro;
        this.nome = nome;
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

    public BST<Integer, Cache> getListCacheVisit() {
        return listCacheVisit;
    }

    public BST<Integer, Cache> getListCacheEsc() {
        return listCacheEsc;
    }

    public LogsDiario getHistLogs() {
        return histLogs;
    }

    public BST<Integer, Objeto> getListObjetos() {
        return listObjetos;
    }

    @Override
    public String toString() {
        return "Id do Aventureiro = " + idAventureiro +
                ", nome= " + nome;
    }
}