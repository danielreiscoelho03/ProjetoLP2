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
                        toSave.append(" ").append(aventureiros.get(x).getDatas().get(j).toString());
                        j++;
                    }
                    toSave.append(" ").append(aventureiros.get(x).getNumCacheEsc());
                    j=0;
                    while(aventureiros.get(x).getListCacheEsc().size() > j){
                        toSave.append(" ").append(aventureiros.get(x).getListCacheEsc().get(j).getIdCache());
                        j++;
                    }
                    int aux = 0;
                    if(aventureiros.get(x).getListTravelBug().size() > 0) {
                        toSave.append(" ").append("tb").append(" ").append(aventureiros.get(x).getListTravelBug().get(0).getIdObjeto());
                        aux++;
                    }
                    if(aventureiros.get(x).getListObjetos().size() > 0) {
                        toSave.append(" ").append("o").append(" ").append(aventureiros.get(x).getListObjetos().get(0).getIdObjeto());
                        aux++;
                    }
                    if(aux==0){
                        toSave.append(" ").append("none");
                    }
                    outfile.println(toSave.toString());
                    k++;
                }
                x++;
            }
            return true;
        }
        throw new AventureiroNaoExisteException("Nao ha aventureiros no jogo!");
    }

    public void lerAventureirosHist(GestaoAcessoCache gc, GestaoAcessoObjeto go){
        In infile = new In("data/Aventureiros.txt");
        String line = null;
        ArrayList<Integer> cVis = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();
        ArrayList<Integer> cEsc = new ArrayList<>();
        while((line = infile.readLine()) != null){
            String[] parts = line.split(" ");
            int id = Integer.parseInt(parts[1]);
            int numCacheVisit = Integer.parseInt(parts[5]);
            for (int i = 6; i < 6+numCacheVisit+numCacheVisit; i+=2) {
                cVis.add(Integer.parseInt(parts[i]));
                data.add(parts[i+1]);
            }
            int numCacheEsc = Integer.parseInt(parts[6+numCacheVisit+numCacheVisit]);
            for (int i = 6+numCacheVisit+numCacheVisit+1; i < 6+numCacheVisit+numCacheVisit+1+numCacheEsc; i++) {
                cEsc.add(Integer.parseInt(parts[i]));
            }
            String tipoObjeto = parts[6+numCacheVisit+numCacheVisit+1+numCacheEsc];
            int idO=0;
            if(!tipoObjeto.equals("none"))
                idO = Integer.parseInt(parts[6+numCacheVisit+numCacheVisit+1+numCacheEsc+1]);
            int x = 0;
            while (cVis.size()>x){
                String[] datas = data.get(x).split("/");
                int d = Integer.parseInt(datas[0]);
                int m = Integer.parseInt(datas[1]);
                int a = Integer.parseInt(datas[2]);
                aventureiros.get(id).getListCacheVisit().put(aventureiros.get(id).getNumCacheVis(), gc.getCaches().get(cVis.get(x)));
                aventureiros.get(id).getDatas().put(aventureiros.get(id).getNumCacheVis(), new Date(d, m, a));
                aventureiros.get(id).setNumCacheVis(aventureiros.get(id).getNumCacheVis()+1);
                x++;
            }
            if(tipoObjeto.equals("tb"))
                aventureiros.get(id).getListTravelBug().put(0, go.getTravelBug().get(idO));
            if(tipoObjeto.equals("o"))
                aventureiros.get(id).getListObjetos().put(0, go.getObjetos().get(idO));
            cEsc.removeAll(cEsc);
            cVis.removeAll(cVis);
            data.removeAll(data);
        }
    }

    @Override
    public void lerAventureiros() {
        In infile = new In("data/Aventureiros.txt");
        String line = null;
        while((line = infile.readLine()) != null){
            //System.out.println(line);
            String[] parts = line.split(" ");
            String part0 = parts[0]; // Tipo de Aventureiro
            String part1 = parts[1]; // id
            int id = Integer.parseInt(part1);
            String part2 = parts[2]; // nome
            String part3 = parts[3]; // coordenadas x
            int cX = Integer.parseInt(part3);
            String part4 = parts[4]; // coordenadas y
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

    public void verTodasCachesVisGlobal(int id){
        if(aventureiros.get(id) != null)
            aventureiros.get(id).getListCacheVisit().printInOrder(aventureiros.get(id).getListCacheVisit().getRoot());
    }

    public void verTodasCachesVisReg(int id, String reg){
        int k = 0;
        if(aventureiros.get(id) != null)
            while(aventureiros.get(id).getListCacheVisit().size() > k){
                if(aventureiros.get(id).getListCacheVisit().get(k).getLocal().getLocalizacao().equals(reg))
                    System.out.println(aventureiros.get(id).getListCacheVisit().get(k).toString());
            k++;
            }
    }

    public void verTodasCachesNaoVisGlobal(GestaoAcessoCache gc, int id){
        int j = 1, x, count = 0;
        while (gc.getCaches().size() >= j){
            x = 0;
            while(aventureiros.get(id).getListCacheVisit().size() > x){
                if(gc.getCaches().get(j).getIdCache().equals(aventureiros.get(id).getListCacheVisit().get(x).getIdCache()))
                    count++;
                x++;
            }
            if(count == 0)
                System.out.println(gc.getCaches().get(j).toString());
            count = 0;
            j++;
        }
    }

    public void verTodasCachesNaoVisReg(GestaoAcessoCache gc, int id, String reg){
        int j = 1, x, count = 0;
        while (gc.getCaches().size() >= j){
            if(gc.getCaches().get(j).getLocal().getLocalizacao().equals(reg)){
                x = 0;
                while(aventureiros.get(id).getListCacheVisit().size() > x){
                    if(gc.getCaches().get(j).getIdCache().equals(aventureiros.get(id).getListCacheVisit().get(x).getIdCache()))
                        count++;
                    x++;
                }
                if(count == 0)
                    System.out.println(gc.getCaches().get(j).toString());
                count = 0;
            }
            j++;
        }
    }

}
