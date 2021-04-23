package projeto_LP2_AED2;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogsCache implements GestaoLogs {

  public String mensagem;
  public Date data;
  public Cache cache;
  public Aventureiro utilizador;

  @Override
  public void adicionaLog(String mensagem, Date data) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    int k = 0, x = 0;
    In infile = new In("data/LogsSistema");
    String[] allLines = infile.readAllLines();
    Out outfile = new Out("data/LogsSistema");
    while (allLines.length > k) {
      outfile.println(allLines[k]);
      k++;
    }
    outfile.println(mensagem + ", na data de: " + sdf.format(data));
  }
}