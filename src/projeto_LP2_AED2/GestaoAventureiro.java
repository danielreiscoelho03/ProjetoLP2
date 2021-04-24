package projeto_LP2_AED2;

public interface GestaoAventureiro {
  public boolean regista(Basic aventureiro);
  public boolean regista(Admin aventureiro);
  public boolean regista(Premium aventureiro);
  public boolean remove(Integer idAventureiro) throws AventureiroNaoExisteException;
  public boolean existe(Integer idAventureiro);
  public boolean guardarAventureiros() throws  AventureiroNaoExisteException;
  public void lerAventureiros();
}