package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.util.Random;

public class TravelBug extends  Objeto {

  public String missao;
  private Cache cAtual;
  private Cache cProx;
  private BST_AED2_2021<Integer, PremiumCache> listaCachesPresente = new BST_AED2_2021<>();
  private int numCachesPres = 1;

  public String getMissao() {
    return missao;
  }

  public int getNumCachesPres() {
    return numCachesPres;
  }

  public void setNumCachesPres(int numCachesPres) {
    this.numCachesPres = numCachesPres;
  }

  public BST_AED2_2021<Integer, PremiumCache> getListaCachesPresente() {
    return listaCachesPresente;
  }

  public void setListaCachesPresente(BST_AED2_2021<Integer, PremiumCache> listaCachesPresente) {
    this.listaCachesPresente = listaCachesPresente;
  }

  public void setMissao(String missao) {
    this.missao = missao;
  }

  public TravelBug(Integer idObjeto, String nome) {
    super(idObjeto, nome);
    Random num = new Random();
    int posicao = num.nextInt(9);
    lerMissao(1);
  }

  public TravelBug(Integer idObjeto, String nome, String m) {
    super(idObjeto, nome);
    missao = m;
  }

  public void lerMissao(int posicao){
    In infile = new In("data/Missoes.txt");
    String [] missoes = infile.readAllLines();
    int x = 0;
    while(missoes.length > x){
      String[] parts = missoes[x].split("-");
      int pos = Integer.parseInt(parts[0]);
      StringBuilder m = new StringBuilder();
      if(pos == posicao){
        m.append(parts[0]).append(" ").append(parts[1]);
        missao = m.toString();
      }
      x++;

    }
  }

  public void interpetarMissao(GestaoAcessoCache gc){
    String [] parts = missao.split(" ");
    //System.out.println(parts[2]+ parts[3]);
    Integer idMissao = Integer.parseInt(parts[0]);
    switch (idMissao){
      case 1:
        int x = 1, k = 1;
        double dist = 0;
        while (k <= gc.getCaches().size()){
          if(gc.getCaches().get(x) != null){
            String toSave = null;
            if(this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal()) > dist){
              dist = this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal());
              PremiumCache pc = (PremiumCache) gc.getCaches().get(1);
              listaCachesPresente.put(numCachesPres, pc);
              numCachesPres++;
            }
            k++;
          }
          x++;
        }
        System.out.println("Tem de levar o TravelBug para a cache: " + listaCachesPresente.get(numCachesPres-1));
        break;
      case 2:
        x = 1;
        k = 1;
        dist = 1000000;
        while (k <= gc.getCaches().size()){
          if(gc.getCaches().get(x) != null){
            String toSave = null;
            if(this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal()) < dist && this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal()) > 0){
              dist = this.getCache().getLocal().distancia(gc.getCaches().get(x).getLocal());
              PremiumCache pc = (PremiumCache) gc.getCaches().get(0);
              listaCachesPresente.put(numCachesPres, pc);
            }
            k++;
          }
          x++;
        }
        System.out.println("Tem de levar o TravelBug para a cache: " + listaCachesPresente.get(numCachesPres-1));
        break;
      case 3: break;
      case 4: break;
      case 5: break;
      case 6: break;
      case 7: break;
      case 8: break;
      case 9: break;
      case 10: break;
      default:
        System.out.println("erro");
    }
  }

  public void guardarTravelBug(){
    int k = 0;
    In infile = new In("data/Objeto.txt");
    String [] lines = infile.readAllLines();
    Out outfile = new Out("data/Objeto.txt");
    String toFile = "Travelbug " + getIdObjeto() + " " + getNome() + " " + getMissao() + " .";
    while (lines.length > k) {
      outfile.println(lines[k]);
      k++;
    }
    outfile.println(toFile);
  }

  @Override
  public String toString() {
    return super.toString() +", missao: " + missao;
  }
}