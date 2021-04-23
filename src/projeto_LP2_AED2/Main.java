package projeto_LP2_AED2;

public class Main {
    public static void main(String[] args) throws JaExisteObjetoNumaCacheException, AventureiroNaoExisteException, CacheNaoExisteException {
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
        Cache c = new Cache(1, 5, a1);
        gc.adicionaCache(c);
        Objeto o = new Objeto(1, "cao");
        Objeto o1 = new Objeto(2, "bola");
        c.setObjeto(o);
        System.out.println(a2 +", " + c);
        a2.encontrouCache(c, o1);
        System.out.println(a2 +", " + c);
        System.out.println(a1);
        System.out.println("SPORTING");
        System.out.println("asuydnajsd");
    }
}
