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

    public void verLocalizacaoTravelBug(GestaoAcessoObjeto go, int id){
        if(go.getTravelBug().get(id)!=null){
            if(go.getTravelBug().get(id).isViajar()){
                System.out.println("Esta a viajar com o aventureiro: " + go.getTravelBug().get(id).getListaAventureiros().get(go.getTravelBug().get(id).getNumAventureiros()-1));
            }else{
                System.out.println("Esta na cache " + go.getTravelBug().get(id).getListaCachesPresente().get(go.getTravelBug().get(id).getNumCachesPres()-1) + " e esta localizado em " + go.getTravelBug().get(id).getListaCachesPresente().get(go.getTravelBug().get(id).getNumCachesPres()-1).getLocal().getLocalizacao());
            }
        }
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

    public void verTodosOsObjetos(GestaoAcessoObjeto go){
        int x = 1;
        System.out.println("Objetos: ");
        while(go.getObjetos().size() >= x) {
            System.out.println(go.getObjetos().get(x).getNome());
            x++;
        }
    }

    public void verTodosOsTravelBug(GestaoAcessoObjeto go){
        int x = 1;
        System.out.println("TravelBugs: ");
        while(go.getTravelBug().size() >= x) {
            System.out.println(go.getTravelBug().get(x).getNome());
            x++;
        }
    }

}