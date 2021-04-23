package projeto_LP2_AED2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LogsDiario implements GestaoLogs {

    public String mensagem;
    public Date data;

    @Override
    public void adicionaLog(String mensagem, Date data, String file) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        int k = 0, x = 0;
        In infile = new In(file);
        String[] allLines = infile.readAllLines();
        Out outfile = new Out(file);
        while (allLines.length > k) {
            outfile.println(allLines[k]);
            k++;
        }
        outfile.println(mensagem + ", na data de: " + sdf.format(data));
    }
}