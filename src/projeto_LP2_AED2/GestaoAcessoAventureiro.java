package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import edu.princeton.cs.algs4.BST;

public class GestaoAcessoAventureiro implements GestaoAventureiro {

    private BST_AED2_2021<Integer,Aventureiro> aventureiros = new BST_AED2_2021<>();
    private int numAventureiros;

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
        return true;
    }

    @Override
    public boolean regista(Admin aventureiro) {
        aventureiros.put(numAventureiros, aventureiro);
        numAventureiros++;
        return true;

    }

    @Override
    public boolean regista(Premium aventureiro) {
        aventureiros.put(numAventureiros, aventureiro);
        numAventureiros++;
        return true;
    }

    @Override
    public boolean remove(Integer idAventureiro) {
        return false;
    }

    @Override
    public boolean existe(Integer idAventureiro) {
        return false;
    }

    public void printAventureiros(BST_AED2_2021<Integer, Aventureiro>.Node bst){
        if (bst == null)
        return;

        printAventureiros(bst.getLeft());
        System.out.print(bst.getKey() + " ");
        printAventureiros(bst.getRight());
    }

}
