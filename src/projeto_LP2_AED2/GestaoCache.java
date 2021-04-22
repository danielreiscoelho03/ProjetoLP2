package projeto_LP2_AED2;

public interface GestaoCache {

  public boolean adicionaCache(Integer dificuldade, String tipoCache, Aventureiro aventureiro);
  public boolean removeCache(Integer idCache) throws CacheNaoExisteException;
  public boolean existeCache(Integer idCache);
  public boolean depositaObjeto(Objeto objeto, Integer idCache);
  public boolean retiraObjeto(Objeto objeto, Integer idCache) throws ObjetoNaoExisteNaCacheException;

}