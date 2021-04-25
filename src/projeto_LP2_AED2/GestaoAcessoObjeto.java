package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

public class GestaoAcessoObjeto implements GestaoObjetos{
    private int numObjeto = 1;
    public BST_AED2_2021<Integer, Objeto> objetos = new BST_AED2_2021<>();

    @Override
    public boolean regista(Objeto objeto) {
        objetos.put(numObjeto,objeto);
        numObjeto ++;
        return true;
    }

    @Override
    public boolean remove(Integer idObjeto) {
        if(objetos.contains(idObjeto)){
            objetos.delete(idObjeto);
            return true;
        }
        return false;
    }

    @Override
    public boolean existe(Integer idObjeto) {
        return objetos.contains(idObjeto);
    }

    public int id(){
        int k = 0;
        In infile = new In("data/idCounter");
        int[] idCounter = infile.readAllInts();
        int rId = idCounter[2];
        idCounter[2]++;
        Out outfile = new Out("data/idCounter");
        while(k<3){
            outfile.println(idCounter[k]);
            k++;
        }
        return rId;
    }
}
