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

  @Override
  public String toString() {
    return "Objeto{" +
            "idObjeto=" + idObjeto +
            ", nome='" + nome + '\'' +
            '}';
  }
}