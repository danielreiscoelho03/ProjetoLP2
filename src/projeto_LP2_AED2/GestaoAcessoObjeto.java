package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

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

    public void now(){
        System.out.println("se vai foder!");
        int x = 1;
        while(travelBug.size() >= x) {
            System.out.println("A localizacao atual e: " + travelBug.get(x).getListaCachesPresente().get(travelBug.get(x).getNumCachesPres() - 1).getLocal().getLocalizacao());
            if(travelBug.get(x).getNumAventureiros() > 0){
                if (travelBug.get(x).getListaAventureiros().get(travelBug.get(x).getNumAventureiros() - 1).getNome() != null)
                    System.out.println("O ultimo Aventureiro que o transportou foi: " + travelBug.get(x).getListaAventureiros().get(travelBug.get(x).getNumAventureiros() - 1).getNome());
            }
            x++;
        }
    }

}
