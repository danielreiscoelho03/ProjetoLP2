package projeto_LP2_AED2;

public class Main {
    public static void main(String[] args) throws CacheNaoExisteException, JaExisteObjetoNumaCacheException, AventureiroNaoExisteException {
        GestaoAcessoAventureiro ga = new GestaoAcessoAventureiro();
        GestaoAcessoCache gc = new GestaoAcessoCache();
        Basic a1 = new Basic(ga.id(), "kini", 1, 2);
        Basic a2 = new Basic(ga.id(), "mosca",3, 4);
        Basic a3 = new Basic(ga.id(), "cao", 5, 6);
        Premium a4 = new Premium(ga.id(), "caozinho", 5,6);
        Admin a5 = new Admin(ga.id(), "joao", 8,9);
        ga.regista(a1);
        ga.regista(a2);
        ga.regista(a3);
        ga.regista(a4);
        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
        System.out.println("\n");
        //ga.remove(1);
        //ga.remove(9);
        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
        System.out.println("\n");
        System.out.println(ga.existe(1));
        System.out.println(ga.existe(2));
        //ga.regista(a5);
        System.out.println(ga.getAventureiros().get(1).getLocal().distancia(ga.getAventureiros().get(2).getLocal()));


    }
}
