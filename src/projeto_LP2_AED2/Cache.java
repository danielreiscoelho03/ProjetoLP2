package projeto_LP2_AED2;

import java.util.List;

public class Cache implements GestaoCache {

  public Integer idCache;
  private Integer dificuldade;
  public String tipoCache;
  public Aventureiro aventureiro;

  public List<Objeto> listObjetos;
  public List<LogsCache> histLogs;
  public List<Objeto> item;
  public Localizacao local;

  @Override
  public boolean adicionaCache(Integer dificuldade, String localizacao, String tipoCache) {
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