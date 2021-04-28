package projeto_LP2_AED2;

import Search.BST_AED2_2021;
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
        aventureiro.setIdAventureiro(numAventureiros);
        aventureiros.put(numAventureiros, aventureiro);
        numAventureiros++;
        String toDiario = "Adicionou: " + aventureiro.toString();
        System.out.println(toDiario);
        diario.adicionaLog(toDiario, data, "data/LogsAventureiro");
        return true;
    }

    @Override
    public boolean regista(Admin aventureiro) {
        aventureiro.setIdAventureiro(numAventureiros);
        aventureiros.put(numAventureiros, aventureiro);
        numAventureiros++;
        String toDiario = "Adicionou: " + aventureiro.toString();
        System.out.println(toDiario);
        diario.adicionaLog(toDiario, data, "data/LogsAventureiro");
        return true;

    }

    @Override
    public boolean regista(Premium aventureiro) {
        aventureiro.setIdAventureiro(numAventureiros);
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
            String nome = aventureiros.get(idAventureiro).getNome();
            aventureiros.delete(idAventureiro);
            String toDiario = "Removeu o Aventureiro com id: " + idAventureiro;
            System.out.println(toDiario);
            String toArquivo = "Foi removido o Aventureiro com id : " + idAventureiro + " e com o nome : " + nome;
            diario.adicionaLog(toDiario, data, "data/LogsAventureiro");
            diario.adicionaLog(toArquivo, data, "data/Arquivo.txt");
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
        if(aventureiros.size() > 0) {
            Out outfile = new Out("data/Aventureiros.txt");
            int x = 1;
            while (x <= aventureiros.size()){
                if(aventureiros.get(x) != null){
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
            //System.out.println(line);
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
                Basic u = new Basic(part2, cX, cY);
                aventureiros.put(numAventureiros, u);
                numAventureiros++;
            }else if(part0.equals("premium")){
                Premium u = new Premium(part2, cX, cY);
                aventureiros.put(numAventureiros, u);
                numAventureiros++;
            }else if(part0.equals("admin")){
                Admin u = new Admin(part2, cX, cY);
                aventureiros.put(numAventureiros, u);
                numAventureiros++;
            }
        }
        /*System.out.println("\n\n\n");
        aventureiros.printInOrder(aventureiros.getRoot());
        System.out.println("\n\n\n");*/
    }

    public void PrintTodasCachesVisitadas(int id){
        int x = 0;
        while(getAventureiros().get(id).getListCacheVisit().size() > x){
            System.out.println(getAventureiros().get(id).getListCacheVisit().get(x).getIdCache());
            x++;
        }
    }

}
