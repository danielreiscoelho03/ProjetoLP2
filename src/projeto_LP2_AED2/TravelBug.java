package projeto_LP2_AED2;

<<<<<<< HEAD
public class TravelBug extends Objeto {
=======
import edu.princeton.cs.algs4.In;

import java.util.Random;

public class TravelBug extends  Objeto {
>>>>>>> a1b2dc7a0e2ffae74e14a960b5b80a226b8327d9

  public String missao;

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

  @Override
  public String toString() {
    return super.toString() +", missao: " + missao;
  }
}