package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import edu.princeton.cs.algs4.BST;

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
        diario.adicionaLog(toDiario, data);
        return true;
    }

    @Override
    public boolean regista(Admin aventureiro) {
        aventureiros.put(numAventureiros, aventureiro);
        numAventureiros++;
        String toDiario = "Adicionou: " + aventureiro.toString();
        System.out.println(toDiario);
        diario.adicionaLog(toDiario, data);
        return true;

    }

    @Override
    public boolean regista(Premium aventureiro) {
        aventureiros.put(numAventureiros, aventureiro);
        numAventureiros++;
        String toDiario = "Adicionou: " + aventureiro.toString();
        System.out.println(toDiario);
        diario.adicionaLog(toDiario, data);
        return true;
    }

    @Override
    public boolean remove(Integer idAventureiro) throws AventureiroNaoExisteException {
        if(aventureiros.contains(idAventureiro)){
            aventureiros.delete(idAventureiro);
            String toDiario = "Removeu o Aventureiro com id: " + idAventureiro;
            System.out.println(toDiario);
            diario.adicionaLog(toDiario, data);
            return true;
        }
        throw new AventureiroNaoExisteException("FODEU");
    }

    @Override
    public boolean existe(Integer idAventureiro) {
        return aventureiros.contains(idAventureiro);
    }

}
