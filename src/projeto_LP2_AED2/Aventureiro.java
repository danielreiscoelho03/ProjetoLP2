package projeto_LP2_AED2;


import java.util.ArrayList;
import java.util.List;

public class Aventureiro implements GestaoAventureiro {

  private Integer idAventureiro;
  private String nome;
  private String tipoAventureiro;
  private ArrayList<Cache> listCacheVisit;

  public List<Cache> listCacheEsc;
  public List<LogsCache> logs;
  public List<Objeto> listObjetos;
  public Localizacao local;
  public List<LogsDiario> histLogs;

  @Override
  public boolean regista(String nome) {
    return false;
  }

  @Override
  public boolean remove(Integer idAventureiro) {
    return false;
  }

  @Override
  public boolean existe(Integer idAventureiro) {
    return false;
  }
}