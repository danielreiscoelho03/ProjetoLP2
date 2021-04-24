package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.util.Date;

public class GestaoAcessoAventureiro implements GestaoAventureiro {

    private BST_AED2_2021<Integer,Aventureiro> aventureiros = new BST_AED2_2021<>();
    private int numAventureiros = 1;
    private LogsDiario diario = new LogsDiario();
    private Date data = new Date();

    public BST_AED2_2021<Integer, Aventureiro> getAventureiros() {
        return aventureiros;
    }

    public int getNumAventureiros() {
        return numAventureiros;
    }

    @Override
    public boolean regista(Basic aventureiro) {
        aventureiros.put(numAventureiros, aventureiro);
        numAventureiros++;
        String toDiario = "Adicionou: " + aventureiro.toString();
        System.out.println(toDiario);
        diario.adicionaLog(toDiario, data, "data/LogsAventureiro");
        return true;
    }

    @Override
    public boolean regista(Admin aventureiro) {
        aventureiros.put(numAventureiros, aventureiro);
        numAventureiros++;
        String toDiario = "Adicionou: " + aventureiro.toString();
        System.out.println(toDiario);
        diario.adicionaLog(toDiario, data, "data/LogsAventureiro");
        return true;

    }

    @Override
    public boolean regista(Premium aventureiro) {
        aventureiros.put(numAventureiros, aventureiro);
        numAventureiros++;
        String toDiario = "Adicionou: " + aventureiro.toString();
        System.out.println(toDiario);
        diario.adicionaLog(toDiario, data, "data/LogsAventureiro");
        return true;
    }

    @Override
    public boolean remove(Integer idAventureiro) throws AventureiroNaoExisteException {
        if(aventureiros.contains(idAventureiro)){
            aventureiros.delete(idAventureiro);
            String toDiario = "Removeu o Aventureiro com id: " + idAventureiro;
            System.out.println(toDiario);
            diario.adicionaLog(toDiario, data, "data/LogsAventureiro");
            return true;
        }
        throw new AventureiroNaoExisteException("FODEU");
    }

    @Override
    public boolean existe(Integer idAventureiro) {
        return aventureiros.contains(idAventureiro);
    }

    @Override
    public boolean guardarAventureiros() throws AventureiroNaoExisteException {
        System.out.println(aventureiros.size());
        if(aventureiros.size() > 0) {
            Out outfile = new Out("data/Aventureiros.txt");
            int x = 1;
            while (x <= aventureiros.size()){
                String toSave = null;
                if(aventureiros.get(x) instanceof Basic)
                    toSave = "basic" + " " + aventureiros.get(x).getIdAventureiro() + " " + aventureiros.get(x).getNome() + " " + aventureiros.get(x).getLocal().getCoordenadaX() + " " + aventureiros.get(x).getLocal().getCoordenadaY();
                if(aventureiros.get(x) instanceof Admin)
                    toSave = "admin" + " " + aventureiros.get(x).getIdAventureiro() + " " + aventureiros.get(x).getNome() + " " + aventureiros.get(x).getLocal().getCoordenadaX() + " " + aventureiros.get(x).getLocal().getCoordenadaY();
                if(aventureiros.get(x) instanceof Premium)
                    toSave = "premium" + " " + aventureiros.get(x).getIdAventureiro() + " " + aventureiros.get(x).getNome() + " " + aventureiros.get(x).getLocal().getCoordenadaX() + " " + aventureiros.get(x).getLocal().getCoordenadaY();
                outfile.println(toSave);
                x++;
            }
            return true;
        }
        throw new AventureiroNaoExisteException("Nao ha aventureiros no jogo!");
    }

    @Override
    public void lerAventureiros() {
        In infile = new In("data/Aventureiros.txt");
        String line = null;
        while((line = infile.readLine()) != null){
            System.out.println(line);
            String[] parts = line.split(" ");
            String part0 = parts[0];
            String part1 = parts[1];
            int id = Integer.parseInt(part1);
            String part2 = parts[2];
            String part3 = parts[3];
            int cX = Integer.parseInt(part3);
            String part4 = parts[4];
            int cY = Integer.parseInt(part4);
            if(part0.equals("basic")){
                Basic u = new Basic(id, part2, cX, cY);
                aventureiros.put(numAventureiros, u);
                numAventureiros++;
            }else if(part0.equals("premium")){
                Premium u = new Premium(id, part2, cX, cY);
                aventureiros.put(numAventureiros, u);
                numAventureiros++;
            }else if(part0.equals("admin")){
                Admin u = new Admin(id, part2, cX, cY);
                aventureiros.put(numAventureiros, u);
                numAventureiros++;
            }
        }
        System.out.println("\n\n\n");
        aventureiros.printInOrder(aventureiros.getRoot());
        System.out.println("\n\n\n");
    }


    public int id(){
        int k = 0;
        In infile = new In("data/idCounter");
        int[] idCounter = infile.readAllInts();
        int rId = idCounter[0];
        idCounter[0]++;
        Out outfile = new Out("data/idCounter");
        while(k<3){
            outfile.println(idCounter[k]);
            k++;
        }
        return rId;
    }

}
