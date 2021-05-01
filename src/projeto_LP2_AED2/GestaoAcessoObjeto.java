package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.util.ArrayList;
import java.util.Random;

public class GestaoAcessoObjeto implements GestaoObjetos{
    private int numObjeto = 1;
    private int numTb = 1;
    public BST_AED2_2021<Integer, Objeto> objetos = new BST_AED2_2021<>();
    public BST_AED2_2021<Integer, TravelBug> travelBug = new BST_AED2_2021<>();


    public int getNumTb() {
        return numTb;
    }

    public void setNumTb(int numTb) {
        this.numTb = numTb;
    }

    public BST_AED2_2021<Integer, TravelBug> getTravelBug() {
        return travelBug;
    }

    public void setTravelBug(BST_AED2_2021<Integer, TravelBug> travelBug) {
        this.travelBug = travelBug;
    }

    public int getNumObjeto() {
        return numObjeto;
    }

    public void setNumObjeto(int numObjeto) {
        this.numObjeto = numObjeto;
    }

    public BST_AED2_2021<Integer, Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(BST_AED2_2021<Integer, Objeto> objetos) {
        this.objetos = objetos;
    }

    @Override
    public boolean regista(Objeto objeto) {
        objeto.setIdObjeto(numObjeto);
        objetos.put(numObjeto,objeto);
        numObjeto ++;
        return true;
    }

    @Override
    public boolean regista(TravelBug tb) {
        tb.setIdObjeto(numTb);
        travelBug.put(numTb,tb);
        numTb ++;
        return true;
    }

    @Override
    public boolean removeO(Integer idObjeto) {
        if(objetos.contains(idObjeto)){
            objetos.delete(idObjeto);
            return true;
        }
        return false;
    }
    @Override
    public boolean removeTb(Integer idTb) {
        if(travelBug.contains(idTb)){
            travelBug.delete(idTb);
            return true;
        }
        return false;
    }

    @Override
    public boolean existeO(Integer idObjeto) {
        return objetos.contains(idObjeto);
    }

    public boolean existeTb(Integer idObjeto) {
        return travelBug.contains(idObjeto);
    }

    public int travelBugVisits(){
        int x = 1, id = 0, num = 0;
        while(x < travelBug.size()){
            if(travelBug.get(x).getNumCachesPres() > num){
                id = travelBug.get(x).getIdObjeto();
                num = travelBug.get(x).getNumCachesPres();
            }
            x++;
        }
        return id;
    }

    public void guardarObjeto(){
        if(objetos.size()>0){
            Out outfile = new Out("data/Objeto.txt");
            int x = 1, k = 1;
            while(k <= objetos.size()){
                if(objetos.get(x) != null) {
                    String toSave = objetos.get(x).getIdObjeto() + objetos.get(x).getNome();
                    if (objetos.get(x).isViajar())
                        toSave = toSave + objetos.get(x).isViajar() + objetos.get(x).getAventureiro().getIdAventureiro();
                    else
                        toSave = toSave + objetos.get(x).isViajar() + objetos.get(x).getCache().getIdCache();
                    outfile.println(toSave);
                    k++;
                }
                x++;
            }
        }
        if(travelBug.size()>0){
            Out outfile = new Out("data/TravelBug.txt");
            int x = 1, k = 1;
            while(k <= travelBug.size()){
                if(travelBug.get(x) != null){
                    StringBuilder toSave = new StringBuilder(travelBug.get(x).getIdObjeto() + " " + travelBug.get(x).getNome() + " " + travelBug.get(x).getNumCachesPres() + " ");
                    int j = 1;
                    while(travelBug.get(x).getListaCachesPresente().size() >= j){
                        toSave.append(travelBug.get(x).getListaCachesPresente().get(j).getIdCache()).append(" ");
                        j++;
                    }
                    j=0;
                    toSave.append(travelBug.get(x).getNumAventureiros());
                    while (travelBug.get(x).getListaAventureiros().size() > j){
                        toSave.append(" ").append(travelBug.get(x).getListaAventureiros().get(j).getIdAventureiro());
                        j++;
                    }
                    toSave.append(" ").append(travelBug.get(x).getMissao());
                    outfile.println(toSave);
                    k++;
                }
                x++;
            }

        }
    }

    public void now(){
        int x = 1;
        while(travelBug.size() >= x) {
            System.out.println("==============================================================================");
            System.out.println("Nome do TravelBug: " + travelBug.get(x).getNome());
            System.out.println("A localizacao atual é: " + travelBug.get(x).getListaCachesPresente().get(travelBug.get(x).getNumCachesPres() - 1).getLocal().getLocalizacao());
            int p = travelBug.get(x).getNumCachesPres()-1;
            System.out.println("Numero de caches percorridas: " + p);
            if(travelBug.get(x).isViajar()) {
                System.out.println("O TravelBug esta a ser transportado neste momento pelo aventureiro: " + travelBug.get(x).getListaAventureiros().get(travelBug.get(x).getNumAventureiros() - 1).getNome());
            }
            else if(travelBug.get(x).getNumAventureiros() > 0){
                if (travelBug.get(x).getListaAventureiros().get(travelBug.get(x).getNumAventureiros() - 1).getNome() != null)
                    System.out.println("O ultimo Aventureiro que o transportou foi: " + travelBug.get(x).getListaAventureiros().get(travelBug.get(x).getNumAventureiros() - 1).getNome());
            }
            if(travelBug.get(x).getNumCachesPres() == 2){
                System.out.println("O TravelBug so esteve na sua cache atual: " + travelBug.get(x).getListaCachesPresente().get(travelBug.get(x).getNumCachesPres()-1).getIdCache());
            }else{
                if(travelBug.get(x).getListaCachesPresente().get(travelBug.get(x).getNumCachesPres()-1) != null && !travelBug.get(x).isViajar()){
                    System.out.println("A Cache atual: " + travelBug.get(x).getListaCachesPresente().get(travelBug.get(x).getNumCachesPres()-1).getIdCache());
                }
                if(travelBug.get(x).getListaCachesPresente().get(1) != null){
                    System.out.println("A primeira cache: " + travelBug.get(x).getListaCachesPresente().get(1).getIdCache());
                }
            }
            if(travelBug.get(x).getNumCachesPres() > 2){
                int k = 1;
                while(k < travelBug.get(x).getNumCachesPres()-1){
                    System.out.println("O " + k + " caminho percorrido foi de " + travelBug.get(x).getListaCachesPresente().get(k).getLocal().getLocalizacao() + " para " + travelBug.get(x).getListaCachesPresente().get(k+1).getLocal().getLocalizacao());
                    double dist = travelBug.get(x).getListaCachesPresente().get(k).getLocal().distancia(travelBug.get(x).getListaCachesPresente().get(k+1).getLocal());
                    //System.out.println("A distancia percorrida foi de: " + dist);
                    System.out.printf("A distancia percorrida foi de %.2f metros.\n", dist);
                    k++;
                }
            }
            System.out.println("==============================================================================");
            x++;
        }
    }

    public void topTravelBug(){
        ArrayList<TravelBug> temp = new ArrayList<>();
        ArrayList<Integer> numTb = new ArrayList<>();
        int x = 1, k = 1;
        while(getTravelBug().size()>x){
            int numC = getTravelBug().get(x).getNumCachesPres();
            if(getTravelBug().get(k).getNumCachesPres() > 1){
                if(numTb.isEmpty()) {
                    temp.add(getTravelBug().get(k));
                    numTb.add(numC);
                }else {
                    for (int o = 0; o < numTb.size(); o++){
                        if(numTb.get(o)<numC){
                            if(numTb.size() == o+1){
                                temp.add(temp.get(o));
                                numTb.add(numTb.get(o));
                            }else{
                                for (int j = numTb.size(); j>o; j--){
                                    if(j == numTb.size()){
                                        temp.add(j, temp.get(j-1));
                                        numTb.add(j, numTb.get(j-1));
                                    }else{
                                        temp.set(j, temp.get(j-1));
                                        numTb.set(j, numTb.get(j-1));
                                    }
                                }
                            }
                            temp.set(o, getTravelBug().get(k));
                            numTb.set(o, numC);
                            o = numTb.size();
                        }else if(o == numTb.size()-1){
                            numTb.add(numC);
                            temp.add(getTravelBug().get(k));
                            o = numTb.size();
                        }
                    }
                }
                x++;
            }
            k++;
        }
        for (TravelBug t : temp){
            int i =t.getNumCachesPres()-1;
            System.out.println("Id Tb: " + t.getIdObjeto() + ", numero localizacoes: " + i);
        }
    }

}
