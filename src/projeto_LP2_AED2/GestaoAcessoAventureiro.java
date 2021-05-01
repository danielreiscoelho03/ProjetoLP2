package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import Search.RedBlack_AED2;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.util.ArrayList;

public class GestaoAcessoAventureiro implements GestaoAventureiro {

    //private BST_AED2_2021<Integer,Aventureiro> aventureiros = new BST_AED2_2021<>();
    private RedBlack_AED2<Integer,Aventureiro> aventureiros = new RedBlack_AED2<>();
    private int numAventureiros = 1;
    private LogsDiario diario = new LogsDiario();
    private Date data = new Date();

    /*
    public BST_AED2_2021<Integer, Aventureiro> getAventureiros() {
        return aventureiros;
    }

    public int getNumAventureiros() {
        return numAventureiros;
    }
     */

    public RedBlack_AED2<Integer, Aventureiro> getAventureiros() {
        return aventureiros;
    }

    public void setAventureiros(RedBlack_AED2<Integer, Aventureiro> aventureiros) {
        this.aventureiros = aventureiros;
    }

    @Override
    public boolean regista(Basic aventureiro) {
        aventureiro.setIdAventureiro(numAventureiros);
        aventureiros.put(numAventureiros, aventureiro);
        numAventureiros++;
        String toDiario = "Adicionou: " + aventureiro.toString();
        //System.out.println(toDiario);
        diario.adicionaLog(toDiario, data, "data/LogsAventureiro");
        return true;
    }

    @Override
    public boolean regista(Admin aventureiro) {
        aventureiro.setIdAventureiro(numAventureiros);
        aventureiros.put(numAventureiros, aventureiro);
        numAventureiros++;
        String toDiario = "Adicionou: " + aventureiro.toString();
        //System.out.println(toDiario);
        diario.adicionaLog(toDiario, data, "data/LogsAventureiro");
        return true;

    }

    @Override
    public boolean regista(Premium aventureiro) {
        aventureiro.setIdAventureiro(numAventureiros);
        aventureiros.put(numAventureiros, aventureiro);
        numAventureiros++;
        String toDiario = "Adicionou: " + aventureiro.toString();
        //System.out.println(toDiario);
        diario.adicionaLog(toDiario, data, "data/LogsAventureiro");
        return true;
    }

    @Override
    public boolean remove(Integer idAventureiro) throws AventureiroNaoExisteException {
        if(aventureiros.contains(idAventureiro)){
            String nome = aventureiros.get(idAventureiro).getNome();
            aventureiros.delete(idAventureiro);
            String toDiario = "Removeu o Aventureiro com id: " + idAventureiro;
            //System.out.println(toDiario);
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
            int x = 1, k = 1;
            while (k <= aventureiros.size()){
                if(aventureiros.get(x) != null){
                    StringBuilder toSave = null;
                    if(aventureiros.get(x) instanceof Basic)
                        toSave = new StringBuilder("basic" + " " + aventureiros.get(x).getIdAventureiro() + " " + aventureiros.get(x).getNome() + " " + aventureiros.get(x).getLocal().getCoordenadaX() + " " + aventureiros.get(x).getLocal().getCoordenadaY());
                    if(aventureiros.get(x) instanceof Admin)
                        toSave = new StringBuilder("admin" + " " + aventureiros.get(x).getIdAventureiro() + " " + aventureiros.get(x).getNome() + " " + aventureiros.get(x).getLocal().getCoordenadaX() + " " + aventureiros.get(x).getLocal().getCoordenadaY());
                    if(aventureiros.get(x) instanceof Premium)
                        toSave = new StringBuilder("premium" + " " + aventureiros.get(x).getIdAventureiro() + " " + aventureiros.get(x).getNome() + " " + aventureiros.get(x).getLocal().getCoordenadaX() + " " + aventureiros.get(x).getLocal().getCoordenadaY());
                    toSave.append(" ").append(aventureiros.get(x).getNumCacheVis());
                    int j = 0;
                    while(aventureiros.get(x).getListCacheVisit().size() > j){
                        toSave.append(" ").append(aventureiros.get(x).getListCacheVisit().get(j).getIdCache());
                        j++;
                    }
                    toSave.append(" ").append(aventureiros.get(x).getNumCacheEsc());
                    j=0;
                    while(aventureiros.get(x).getListCacheEsc().size() > j){
                        toSave.append(" ").append(aventureiros.get(x).getListCacheEsc().get(j).getIdCache());
                        j++;
                    }
                    if(aventureiros.get(x).getListTravelBug().size() > 0)
                        toSave.append(" ").append("tb").append(" ").append(aventureiros.get(x).getListTravelBug().get(0).getIdObjeto());
                    if(aventureiros.get(x).getListObjetos().size() > 0)
                        toSave.append(" ").append("o").append(" ").append(aventureiros.get(x).getListObjetos().get(0).getIdObjeto());
                    outfile.println(toSave.toString());
                    k++;
                }
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
                u.setIdAventureiro(numAventureiros);
                aventureiros.put(numAventureiros, u);
                numAventureiros++;
            }else if(part0.equals("premium")){
                Premium u = new Premium(part2, cX, cY);
                u.setIdAventureiro(numAventureiros);
                aventureiros.put(numAventureiros, u);
                numAventureiros++;
            }else if(part0.equals("admin")){
                Admin u = new Admin(part2, cX, cY);
                u.setIdAventureiro(numAventureiros);
                aventureiros.put(numAventureiros, u);
                numAventureiros++;
            }
        }
    }

    public void PrintTodasCachesVisitadas(int id){
        int x = 0;
        while(getAventureiros().get(id).getListCacheVisit().size() > x){
            System.out.println(getAventureiros().get(id).getListCacheVisit().get(x).getIdCache());
            x++;
        }
    }

    public ArrayList<Aventureiro> aventureirosVisitCache(Cache c){
        int x = 1;
        ArrayList<Aventureiro> temp = new ArrayList<>();
        while (aventureiros.size() >= x){
            int k = 0;
            while(aventureiros.get(x).getListCacheVisit().size() > k){
                if(aventureiros.get(x).getListCacheVisit().get(k).getIdCache().equals(c.idCache))
                    temp.add(aventureiros.get(x));
                k++;
            }
            x++;
        }
        return temp;
    }

    public void topAventureiros(Date i, Date f){
        ArrayList<Aventureiro> temp = new ArrayList<>();
        ArrayList<Integer> cv = new ArrayList<>();
        int x = 1, k = 1;
        while(getAventureiros().size() >= x){
            if(getAventureiros().get(k)!=null){
                int numVis = NumCacheVisData(getAventureiros().get(k).getListCacheVisit(), i, f, getAventureiros().get(k).getDatas());
                if(cv.isEmpty()) {
                    cv.add(numVis);
                    temp.add(getAventureiros().get(k));
                }else{
                    for (int o = 0; o < cv.size(); o++){
                        if(cv.get(o) < numVis){
                            if(cv.size() == o+1){
                                cv.add(cv.get(o));
                                temp.add(temp.get(o));
                            }else{
                                for(int j = cv.size(); j > o; j--) {
                                    if(j == cv.size()){
                                        cv.add(cv.get(j-1));
                                        temp.add(temp.get(j-1));
                                    }else{
                                        cv.set(j, cv.get(j-1));
                                        temp.set(j, temp.get(j-1));
                                    }
                                }
                            }
                            temp.set(o, getAventureiros().get(k));
                            cv.set(o, numVis);
                            o = cv.size();
                        }
                        else if(o == cv.size()-1){
                            cv.add(numVis);
                            temp.add(getAventureiros().get(k));
                            o = cv.size();
                        }
                    }
                }
                x++;
            }
            k++;
        }
        System.out.println("O top 5 de utilizadores com mais caches visitadas entre as datas: " + i + " e " + f + " sao: ");
        for (int j = 0; j < 5; j++) {
            System.out.println(temp.get(j).getNome() + " visitou no total : " + temp.get(j).getNumCacheVis() + " caches e visitou: " + cv.get(j) + " caches entres estas datas.");
        }
    }

    public int NumCacheVisData(BST_AED2_2021<Integer, Cache> node, Date i, Date f, BST_AED2_2021<Integer, Date> data){
        int k = 0, count = 0;
        while(node.size() > k){
            if(f.afterDate(data.get(k)) && i.beforeDate(data.get(k))){
                count++;
            }
            k++;
        }
        return count;
    }

}
