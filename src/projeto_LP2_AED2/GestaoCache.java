package projeto_LP2_AED2;

public interface GestaoCache {

  public boolean adicionaCache(Integer dificuldade, String localizacao, String tipoCache);
  public boolean removeCache(Integer idCache);
  public boolean existeCache(Integer idCache);
  public boolean depositaObjeto(Objeto objeto);
  public boolean retiraObjeto(Objeto objeto);

}