package projeto_LP2_AED2;

import edu.princeton.cs.algs4.BST;

public class Admin extends Aventureiro {
    public Admin(String nome, int x, int y) {
        super(nome, x, y);
    }

    public void verTodasCaches(GestaoAcessoCache gc){
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
    }

    public void verTodosAventureiros(GestaoAcessoAventureiro ga){
        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
    }

    public void verLocalizacaoCache(Cache c){
        System.out.println("coordenadas x: " + c.getLocal().getCoordenadaX() + ", coordenados y: " + c.getLocal().getCoordenadaY());
    }

    public void verLocalizacaoAventureiro(Aventureiro a){
        System.out.println("coordenadas x: " + a.getLocal().getCoordenadaX() + ", coordenados y: " + a.getLocal().getCoordenadaY());
    }

    public void verTodasCachesRegiao(GestaoAcessoCache gc, String local){
        int x = 1;
        while(gc.getCaches().size() >= x){
            if(gc.getCaches().get(x).getLocal().getLocalizacao().equals(local)){
                System.out.println(gc.getCaches().get(x));
            }
            x++;
        }
    }
}