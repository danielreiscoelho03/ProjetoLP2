package projeto_LP2_AED2;

public class Main {
    public static void main(String[] args) throws JaExisteObjetoNumaCacheException, AventureiroNaoExisteException, CacheNaoExisteException {
        GestaoAcessoAventureiro ga = new GestaoAcessoAventureiro();
        GestaoAcessoCache gc = new GestaoAcessoCache();
        GestaoAcessoObjeto go = new GestaoAcessoObjeto();

        ga.lerAventureiros();
        gc.lerCache();
        System.out.println("\n\n\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n\n\n");

        Basic a1 = new Basic(ga.id(), "fernando", 1, 2);
        Basic a2 = new Basic(ga.id(), "micael",3, 4);
        Basic a3 = new Basic(ga.id(), "ZE", 5, 6);
        Premium a4 = new Premium(ga.id(), "Daniela", 5,6);
        Admin a5 = new Admin(ga.id(), "sara", 8,9);
        ga.regista(a1);
        ga.regista(a2);
        ga.regista(a3);
        ga.regista(a4);
        ga.regista(a5);

        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
        System.out.println("\n");
        //ga.remove(1);
        //ga.remove(9);
        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
        System.out.println(ga.existe(1));
        System.out.println(ga.existe(2));
        //ga.regista(a5);
        System.out.println(ga.getAventureiros().get(1).getLocal().distancia(ga.getAventureiros().get(2).getLocal()));
        Objeto o = new Objeto(1, "cao");
        Objeto o1 = new Objeto(2, "bola");
        Objeto o2 = new Objeto(3, "patins");
        Cache c = new Cache(gc.id(), 5, a1, o);
        Cache c2 = new Cache(gc.id(), 5, a2, o1);
        Cache c3 = new Cache(gc.id(), 5, a2, o2);
        gc.adicionaCache(c);
        gc.adicionaCache(c2);
        gc.adicionaCache(c3);

        gc.depositaObjeto(o, c);
        gc.depositaObjeto(o1, c2);
        gc.depositaObjeto(o2, c3);
        //c.setAventureiro(a1);
        gc.retiraObjeto(c);
        gc.depositaObjeto(o2, c);


        System.out.println("a2: " + a2);
        //System.out.println("c: " + c);
        a2.encontrouCache(c, o1);
        a1.encontrouCache(c, o2);
        System.out.println("a2: " + a2);
        System.out.println("c: " + c);
        System.out.println("a1: " + a1);
        System.out.println("\n\n\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n\n\n");
        ga.guardarAventureiros();
        gc.guardarCache();


    }
}