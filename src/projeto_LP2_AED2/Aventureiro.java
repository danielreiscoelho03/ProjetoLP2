package projeto_LP2_AED2;

import edu.princeton.cs.algs4.BST;

import java.util.ArrayList;
import java.util.List;

public class Aventureiro {

  /*
    private ArrayList<Cache> listCacheVisit;
    private ArrayList<Cache> listCacheEsc;
    private ArrayList<LogsDiario> histLogs;
    private ArrayList<Objeto> listObjetos;
  */

    private Integer idAventureiro;
    private String nome;

    private BST<Integer, Cache> listCacheVisit = new BST<>();
    private BST<Integer, Cache> listCacheEsc = new BST<>();
    private BST<Integer, LogsDiario> histLogs = new BST<>();
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

}