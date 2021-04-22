package projeto_LP2_AED2;

import java.util.List;

public class Objeto implements GestaoObjetos {

  public Integer idObjeto;
  public String nome;

  public Cache cache;
  public Aventureiro aventureiro;
  public Localizacao local;

  public List<LogsObjeto> histLogs;

  @Override
  public boolean regista(String nome) {
    return false;
  }

  @Override
  public boolean remove(Integer idObjeto) {
    return false;
  }

  @Override
  public boolean existe(Integer idObjeto) {
    return false;
  }
}