package projeto_LP2_AED2;

import java.util.List;

public class Objeto {

  public Integer idObjeto;
  public String nome;

  public Cache cache;
  public Aventureiro aventureiro;
  public Localizacao local;

  public List<LogsObjeto> histLogs;

  public Objeto(Integer idObjeto, String nome) {
    this.idObjeto = idObjeto;
    this.nome = nome;
  }

  public Integer getIdObjeto() {
    return idObjeto;
  }

  public void setIdObjeto(Integer idObjeto) {
    this.idObjeto = idObjeto;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Cache getCache() {
    return cache;
  }

  public void setCache(Cache cache) {
    this.cache = cache;
  }

  public Aventureiro getAventureiro() {
    return aventureiro;
  }

  public void setAventureiro(Aventureiro aventureiro) {
    this.aventureiro = aventureiro;
  }

  @Override
  public String toString() {
    return "Objeto{" +
            "idObjeto=" + idObjeto +
            ", nome='" + nome + '\'' +
            '}';
  }
}