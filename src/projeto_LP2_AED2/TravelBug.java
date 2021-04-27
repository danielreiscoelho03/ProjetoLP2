package projeto_LP2_AED2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.util.Random;

public class TravelBug extends  Objeto {

  public String missao;

  public String getMissao() {
    return missao;
  }

  public void setMissao(String missao) {
    this.missao = missao;
  }

  public TravelBug(Integer idObjeto, String nome) {
    super(idObjeto, nome);
    Random num = new Random();
    int posicao = num.nextInt(3);
    lerMissao(posicao);
  }

  public TravelBug(Integer idObjeto, String nome, String m) {
    super(idObjeto, nome);
    Random num = new Random();
    int posicao = num.nextInt(3);
    missao = m;
  }

  public void lerMissao(int posicao){
    In infile = new In("data/Missoes.txt");
    String [] missoes = infile.readAllLines();
    int x = 0;
    while(missoes.length > x){
      String[] parts = missoes[x].split("-");
      //System.out.println(parts[0] + parts[1]);
      int pos = Integer.parseInt(parts[0]);
      if(pos == posicao)
        missao = parts[1];
      x++;
    }
  }

  public void guardarTravelBug(){
    int k = 0;
    In infile = new In("data/Objeto.txt");
    String [] lines = infile.readAllLines();
    Out outfile = new Out("data/Objeto.txt");
    String toFile = "Travelbug " + getIdObjeto() + " " + getNome() + " " + getMissao();
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