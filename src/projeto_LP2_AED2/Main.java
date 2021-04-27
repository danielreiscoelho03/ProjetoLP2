package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import Search.RedBlack_AED2;
import edu.princeton.cs.algs4.RedBlackBST;

public class Main {
    public static void main(String[] args) throws JaExisteObjetoNumaCacheException, AventureiroNaoExisteException, CacheNaoExisteException, AventureiroNaoHabilitado {
        GestaoAcessoAventureiro ga = new GestaoAcessoAventureiro();
        GestaoAcessoCache gc = new GestaoAcessoCache();
        GestaoAcessoObjeto go = new GestaoAcessoObjeto();

        //clientTeste1(ga, gc, go);
        //clientTeste2(ga, gc, go);
        //clientTeste3(ga, gc, go);
        //clientTeste4(ga, gc, go);
        //clientTeste5(ga, gc, go);
        //clientTeste6(ga, gc, go);
        clientTeste7(ga, gc, go);

    }

    public static void clientTeste1(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) throws AventureiroNaoExisteException, CacheNaoExisteException, AventureiroNaoHabilitado {
        ga.lerAventureiros();
        gc.lerCache(ga);// receber ga

        System.out.println("Leitura do ficheiro\n\n\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
        System.out.println("\n\n\nAcabou a leitura");

        Premium a1 = new Premium(ga.id(), "jonas", 1, 2);
        Premium a2 = new Premium(ga.id(), "carlos",3, 4);
        Premium a3 = new Premium(ga.id(), "miguel", 5, 6);
        Premium a4 = new Premium(ga.id(), "antonio", 5,6);
        Admin a5 = new Admin(ga.id(), "roscas", 8,9);
        ga.regista(a1);
        ga.regista(a2);
        ga.regista(a3);
        ga.regista(a4);
        ga.regista(a5);

        System.out.println("ver caches antes de add\n");
        a5.verTodasCaches(gc);
        System.out.println("acabou\n");

        Objeto pilha = new Objeto(go.id(), "pilha");
        Objeto corno = new Objeto(go.id(), "corno");
        Objeto gato = new Objeto(go.id(), "gato");
        Cache c1 = new Cache(gc.id(), 5, a1, pilha, 1, 3, "porto");
        Cache c2 = new Cache(gc.id(), 5, a2, corno, 4, 5, "porto");
        Cache c3 = new Cache(gc.id(), 5, a2, gato, 5,6, "lisboa");

        gc.adicionaCache(c1);
        gc.adicionaCache(c2);
        gc.adicionaCache(c3);

        Objeto corda = new Objeto(go.id(), "corda");

        a2.encontrouCache(c1, corda);


        System.out.println("\n\tteste das funcoes do admin\n");
        System.out.println("\n\t\tVER LOCALIZACAO DE CACHE ESPECIFICA: ");
        a5.verLocalizacaoCache(c1);
        System.out.println("\n\t\tVER LOCALIZACAO DE AVENTUREIRO ESPECIFICO: ");
        a5.verLocalizacaoAventureiro(a1);
        System.out.println("\n\t\tVER TODAS AS CACHES: ");
        a5.verTodasCaches(gc);
        System.out.println("\n\t\tVER TODOS OS AVENTUREIROS: ");
        a5.verTodosAventureiros(ga);
        System.out.println("\n\t\tVER CACHE POR REGIAO: ");
        a5.verTodasCachesRegiao(gc, "lisboa");
        System.out.println("\n\tFIM\n");

        ga.guardarAventureiros();
        gc.guardarCache();
    }

    public static void clientTeste2(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go){
        RedBlack_AED2<Integer, Objeto> objetos = new RedBlack_AED2<>();
        Objeto pilha = new Objeto(go.id(), "pilha");
        Objeto corno = new Objeto(go.id(), "corno");
        Objeto gato = new Objeto(go.id(), "gato");

        objetos.put(1, pilha);
        objetos.put(2, corno);
        objetos.put(3, gato);

        objetos.printInOrder(objetos.getRoot());

    }

    public static void clientTeste3(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) throws AventureiroNaoHabilitado {
        Basic a1 = new Basic(ga.id(), "jonas", 1, 2);
        Admin a2 = new Admin(ga.id(), "coxis", 1,2);
        Premium a3 = new Premium(ga.id(), "jota", 3,4);
        ga.regista(a1);
        ga.regista(a2);
        ga.regista(a3);
        Objeto pilha = new Objeto(go.id(), "pilha");
        Cache c2 = new Cache(gc.id(), 4, a2, pilha, 1,5, "porto");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
    }

    public static void clientTeste4(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) throws AventureiroNaoHabilitado {
        TravelBug tb1 = new TravelBug(go.id(), "oculos");
        TravelBug tb2 = new TravelBug(go.id(), "corda");
        TravelBug tb3 = new TravelBug(go.id(), "piscina");
        TravelBug tb4 = new TravelBug(go.id(), "monitor");
        TravelBug tb5 = new TravelBug(go.id(), "estojo", "Dar uma cabecada ao kinito");

        Premium a1 = new Premium(ga.id(), "jota", 3,4);
        ga.regista(a1);

        PremiumCache pc = new PremiumCache(go.id(), 3, a1, tb1, 1,2, "porto");
        gc.adicionaCache(pc);

        System.out.println("\n\n\n\n");

        gc.getCaches().printInOrder(gc.getCaches().getRoot());


        System.out.println("\n\n\n");
        Objeto o = new Objeto(go.id(), "mosca");

        go.regista(tb1);
        go.regista(tb2);
        go.regista(tb3);
        go.regista(tb4);
        go.regista(tb5);
        go.regista(o);
        go.getObjetos().printInOrder(go.getObjetos().getRoot());
    }

    public static void clientTeste5(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) throws AventureiroNaoHabilitado {
        Premium a1 = new Premium(ga.id(), "jonas", 1, 2);
        Premium a2 = new Premium(ga.id(), "carlos",3, 4);
        Premium a3 = new Premium(ga.id(), "miguel", 5, 6);
        Premium a4 = new Premium(ga.id(), "antonio", 5,6);
        Admin a5 = new Admin(ga.id(), "roscas", 8,9);
        ga.regista(a1);
        ga.regista(a2);
        ga.regista(a3);
        ga.regista(a4);
        ga.regista(a5);
        Objeto pilha = new Objeto(go.id(), "pilha");
        Objeto corno = new Objeto(go.id(), "corno");
        Objeto gato = new Objeto(go.id(), "gato");
        Cache c1 = new Cache(gc.id(), 5, a1, pilha, 1, 3, "porto");
        Cache c2 = new Cache(gc.id(), 5, a2, corno, 4, 5, "porto");
        Cache c3 = new Cache(gc.id(), 5, a2, gato, 5,6, "lisboa");
        gc.adicionaCache(c1);
        gc.adicionaCache(c2);
        gc.adicionaCache(c3);

        a1.encontrouCache(c2, corno);
        a1.getListCacheVisit().printInOrder(a1.getListCacheVisit().getRoot());

        System.out.println("\n\tteste das funcoes do admin\n");
        System.out.println("\n\t\tVER LOCALIZACAO DE CACHE ESPECIFICA: ");
        a5.verLocalizacaoCache(c1);
        System.out.println("\n\t\tVER LOCALIZACAO DE AVENTUREIRO ESPECIFICO: ");
        a5.verLocalizacaoAventureiro(a1);
        System.out.println("\n\t\tVER TODAS AS CACHES: ");
        a5.verTodasCaches(gc);
        System.out.println("\n\t\tVER TODOS OS AVENTUREIROS: ");
        a5.verTodosAventureiros(ga);
        System.out.println("\n\t\tVER CACHE POR REGIAO: ");
        a5.verTodasCachesRegiao(gc, "lisboa");
        System.out.println("\n\t\tVER TODAS AS CACHES VISITADAS POR UM AVENTUREIRO: ");
        ga.PrintTodasCachesVisitadas(1);
        System.out.println("\n\tFIM\n");

    }

    public static void clientTeste6(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) throws AventureiroNaoHabilitado, CacheNaoExisteException {
        ga.lerAventureiros();
        gc.lerCache(ga);
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        gc.guardarCache();
    }

    public static void clientTeste7(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) throws AventureiroNaoHabilitado, CacheNaoExisteException, AventureiroNaoExisteException {
        Premium a1 = new Premium(ga.id(), "jonas", 1, 2);
        Premium a2 = new Premium(ga.id(), "carlos",3, 4);
        Premium a3 = new Premium(ga.id(), "miguel", 5, 6);
        Premium a4 = new Premium(ga.id(), "antonio", 5,6);
        Admin a5 = new Admin(ga.id(), "roscas", 8,9);
        ga.regista(a1);
        ga.regista(a2);
        ga.regista(a3);
        ga.regista(a4);
        ga.regista(a5);
        TravelBug pilha = new TravelBug(go.id(), "pilha");
        TravelBug corno = new TravelBug(go.id(), "corno", "kini gay");
        Objeto gato = new Objeto(go.id(), "gato");
        PremiumCache c1 = new PremiumCache(gc.id(), 5, a1, pilha, 1, 3, "porto");
        PremiumCache c2 = new PremiumCache(gc.id(), 5, a2, corno, 4, 5, "porto");
        BasicCache c3 = new BasicCache(gc.id(), 5, a2, gato, 5,6, "lisboa");
        gc.adicionaCache(c1);
        gc.adicionaCache(c2);
        gc.adicionaCache(c3);

        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        gc.guardarCache();
        ga.guardarAventureiros();
    }

}