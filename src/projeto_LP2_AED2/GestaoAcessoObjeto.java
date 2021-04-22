package projeto_LP2_AED2;

import Search.BST_AED2_2021;

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
}
