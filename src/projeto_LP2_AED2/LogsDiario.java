package projeto_LP2_AED2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.util.Date;

public class LogsDiario implements GestaoLogs {

  public String mensagem;
  public Date data;


  @Override
  public void adicionaLog(String mensagem, Date data) {
    In infile = new In("ProjetoLP2/data/diario.txt");
    Out outfile = new Out("ProjetoLP2/data/diario.txt");
    System.out.println(infile.toString());
    outfile.println(infile.toString());
    outfile.println(mensagem + data);
  }
}