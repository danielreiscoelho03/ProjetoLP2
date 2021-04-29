package projeto_LP2_AED2;

public interface GestaoCache {

  public boolean adicionaCache(Cache cache);
  public boolean removeCache(Integer idCache) throws CacheNaoExisteException;
  public boolean existeCache(Integer idCache);
  public boolean depositaObjeto(Objeto objeto, Cache Cache) throws JaExisteObjetoNumaCacheException;
  public boolean retiraObjeto(Cache Cache) throws JaExisteObjetoNumaCacheException;
  public boolean guardarCache() throws CacheNaoExisteException;
  public void lerCache(GestaoAcessoAventureiro ga, GestaoAcessoObjeto go) throws AventureiroNaoHabilitado;

}