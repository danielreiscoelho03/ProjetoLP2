package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import Search.RedBlack_AED2;
import edu.princeton.cs.algs4.RedBlackBST;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws JaExisteObjetoNumaCacheException, AventureiroNaoExisteException, CacheNaoExisteException, AventureiroNaoHabilitado, ParseException {
        GestaoAcessoAventureiro ga = new GestaoAcessoAventureiro();
        GestaoAcessoCache gc = new GestaoAcessoCache();
        GestaoAcessoObjeto go = new GestaoAcessoObjeto();
        //clientTeste1(ga, gc, go);
        //clientTeste2(ga, gc, go);
        //clientTeste3(ga, gc, go);
        //clientTeste4(ga, gc, go);
        //clientTeste5(ga, gc, go);
        //clientTeste6(ga, gc, go);
        //clientTeste7(ga, gc, go);
        //clientTeste8(ga, gc, go);
        //clientTeste9(ga, gc, go);
        clientTeste10(ga, gc, go);

    }

    public static void clientTeste1(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) throws AventureiroNaoExisteException, CacheNaoExisteException, AventureiroNaoHabilitado {
        ga.lerAventureiros();
        gc.lerCache(ga);// receber ga

        System.out.println("Leitura do ficheiro\n\n\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
        System.out.println("\n\n\nAcabou a leitura");

        Premium a1 = new Premium("jonas", 1, 2);
        Premium a2 = new Premium("carlos", 3, 4);
        Premium a3 = new Premium("miguel", 5, 6);
        Premium a4 = new Premium("antonio", 5, 6);
        Admin a5 = new Admin("roscas", 8, 9);
        ga.regista(a1);
        ga.regista(a2);
        ga.regista(a3);
        ga.regista(a4);
        ga.regista(a5);

        System.out.println("ver caches antes de add\n");
        a5.verTodasCaches(gc);
        System.out.println("acabou\n");

        Objeto pilha = new Objeto("pilha");
        Objeto corno = new Objeto("corno");
        Objeto gato = new Objeto("gato");
        Cache c1 = new Cache(5, a1, pilha, 1, 3, "porto");
        Cache c2 = new Cache(5, a2, corno, 4, 5, "porto");
        Cache c3 = new Cache(5, a2, gato, 5, 6, "lisboa");

        gc.adicionaCache(c1);
        gc.adicionaCache(c2);
        gc.adicionaCache(c3);

        Objeto corda = new Objeto("corda");

        a2.encontrouCache(c1, corda, new Date("20/05/2021"));


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

    public static void clientTeste2(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) {
        RedBlack_AED2<Integer, Objeto> objetos = new RedBlack_AED2<>();
        Objeto pilha = new Objeto("pilha");
        Objeto corno = new Objeto("corno");
        Objeto gato = new Objeto("gato");

        objetos.put(1, pilha);
        objetos.put(2, corno);
        objetos.put(3, gato);

        objetos.printInOrder(objetos.getRoot());

    }

    public static void clientTeste3(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) throws AventureiroNaoHabilitado {
        Basic a1 = new Basic("jonas", 1, 2);
        Admin a2 = new Admin("coxis", 1, 2);
        Premium a3 = new Premium("jota", 3, 4);
        ga.regista(a1);
        ga.regista(a2);
        ga.regista(a3);
        Objeto pilha = new Objeto("pilha");
        Cache c2 = new Cache(4, a2, pilha, 1, 5, "porto");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
    }

    public static void clientTeste4(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) throws AventureiroNaoHabilitado {
        TravelBug tb1 = new TravelBug("oculos");
        TravelBug tb2 = new TravelBug("corda");
        TravelBug tb3 = new TravelBug("piscina");
        TravelBug tb4 = new TravelBug("monitor");
        TravelBug tb5 = new TravelBug("estojo", "Dar uma cabecada ao kinito");

        Premium a1 = new Premium("jota", 3, 4);
        ga.regista(a1);

        PremiumCache pc = new PremiumCache(3, a1, tb1, 1, 2, "porto");
        gc.adicionaCache(pc);

        System.out.println("\n\n\n\n");

        gc.getCaches().printInOrder(gc.getCaches().getRoot());


        System.out.println("\n\n\n");
        Objeto o = new Objeto("mosca");

        go.regista(tb1);
        go.regista(tb2);
        go.regista(tb3);
        go.regista(tb4);
        go.regista(tb5);
        go.regista(o);
        go.getObjetos().printInOrder(go.getObjetos().getRoot());
    }

    public static void clientTeste5(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) throws AventureiroNaoHabilitado {
        Premium a1 = new Premium("jonas", 1, 2);
        Premium a2 = new Premium("carlos", 3, 4);
        Premium a3 = new Premium("miguel", 5, 6);
        Premium a4 = new Premium("antonio", 5, 6);
        Admin a5 = new Admin("roscas", 8, 9);
        ga.regista(a1);
        ga.regista(a2);
        ga.regista(a3);
        ga.regista(a4);
        ga.regista(a5);
        Objeto pilha = new Objeto("pilha");
        Objeto corno = new Objeto("corno");
        Objeto gato = new Objeto("gato");
        Cache c1 = new Cache(5, a1, pilha, 1, 3, "porto");
        Cache c2 = new Cache(5, a2, corno, 4, 5, "porto");
        Cache c3 = new Cache(5, a2, gato, 5, 6, "lisboa");
        gc.adicionaCache(c1);
        gc.adicionaCache(c2);
        gc.adicionaCache(c3);

        a1.encontrouCache(c2, corno, new Date("20/05/2021"));
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

    public static void clientTeste6(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) throws AventureiroNaoHabilitado, CacheNaoExisteException, AventureiroNaoExisteException {
        ga.lerAventureiros();
        gc.lerCache(ga);
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        Premium fabio = new Premium("fabio", 2, 4);
        Premium goncalo = new Premium("Goncalo", 2, 5);
        TravelBug rato3 = new TravelBug( "rato");

        TravelBug rato = new TravelBug("rato");
        TravelBug rato2 = new TravelBug( "rato2");
        PremiumCache cache = new PremiumCache(5, fabio, rato, 4, 6, "porto");
        BasicCache c1 = new BasicCache(4, fabio, rato, 1, 2, "porto");

        ga.regista(fabio);
        ga.regista(goncalo);
        gc.adicionaCache(cache);
        gc.adicionaCache(c1);

        //gc.getCaches().get(1).getTravelbug().interpetarMissao(gc);
        //gc.getCaches().get(2).getTravelbug().interpetarMissao(gc);

        goncalo.encontrouCache(cache, rato3, new Date("20/05/2021"));
        goncalo.getListTravelBug().get(0).interpetarMissao(gc);
        System.out.println();
        rato.getListaCachesPresente().printInOrder(rato.getListaCachesPresente().getRoot());
        System.out.println();
        //goncalo.getListTravelBug().get(0).depositar(gc);

        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        ga.getAventureiros().get(1).encontrouCache(cache, rato2, new Date("20/05/2021"));
        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
        //ga.guardarAventureiros();
        //gc.guardarCache();
    }

    public static void clientTeste7(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) throws AventureiroNaoHabilitado, CacheNaoExisteException, AventureiroNaoExisteException {
        Premium a1 = new Premium("jonas", 1, 2);
        Premium a2 = new Premium("carlos", 3, 4);
        Premium a3 = new Premium("miguel", 5, 6);
        Premium a4 = new Premium("antonio", 5, 6);
        Admin a5 = new Admin("roscas", 8, 9);
        ga.regista(a1);
        ga.regista(a2);
        ga.regista(a3);
        ga.regista(a4);
        ga.regista(a5);
        TravelBug pilha = new TravelBug("pilha", "mosca is not programmer");
        TravelBug corno = new TravelBug("corno", "kini gay");
        Objeto gato = new Objeto("gato");
        PremiumCache c1 = new PremiumCache(5, a1, pilha, 1, 3, "porto");
        PremiumCache c2 = new PremiumCache(5, a2, corno, 4, 5, "porto");
        BasicCache c3 = new BasicCache(5, a2, gato, 5, 6, "lisboa");
        gc.adicionaCache(c1);
        gc.adicionaCache(c2);
        gc.removeCache(c2.getIdCache());
        gc.adicionaCache(c3);

        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        gc.guardarCache();
        ga.guardarAventureiros();
    }

    public static void clientTeste8(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) throws AventureiroNaoHabilitado, CacheNaoExisteException, AventureiroNaoExisteException {
        Premium a1 = new Premium("jonas", 1, 2);
        Premium a2 = new Premium("carlos", 3, 4);
        Premium a3 = new Premium("miguel", 5, 6);
        Premium a4 = new Premium("antonio", 5, 6);
        Admin a5 = new Admin("roscas", 8, 9);

        ga.regista(a1);
        ga.regista(a2);
        ga.regista(a3);
        ga.regista(a4);
        ga.regista(a5);

        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
        ga.remove(4);
        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
        ga.guardarAventureiros();
    }

    public static void clientTeste9(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) throws AventureiroNaoHabilitado, CacheNaoExisteException, AventureiroNaoExisteException, JaExisteObjetoNumaCacheException {
        Premium a1 = new Premium("jonas", 1, 2);
        Premium a2 = new Premium("carlos", 3, 4);
        Premium a3 = new Premium("miguel", 5, 6);
        Premium a4 = new Premium("antonio", 5, 6);
        Admin a5 = new Admin("roscas", 8, 9);

        ga.regista(a1);
        ga.regista(a2);
        ga.regista(a3);
        ga.regista(a4);
        ga.regista(a5);

        TravelBug pilha = new TravelBug("pilha", "mosca is not programmer");
        TravelBug corno = new TravelBug("corno", "kini gay");
        Objeto gato = new Objeto("gato");
        Objeto pau = new Objeto("pau");
        Objeto tele = new Objeto("tele");

        PremiumCache c1 = new PremiumCache(5, a1, pilha, 1, 3, "porto");
        PremiumCache c2 = new PremiumCache(5, a2, corno, 4, 5, "porto");
        BasicCache c3 = new BasicCache(5, a2, gato, 5, 6, "lisboa");
        BasicCache c4 = new BasicCache(5, a2, pau, 5, 6, "porto");

        gc.adicionaCache(c1);
        gc.adicionaCache(c2);
        gc.removeCache(c2.getIdCache());
        gc.adicionaCache(c3);
        gc.adicionaCache(c4);

        ga.getAventureiros().get(1).encontrouCache(c4, tele, new Date("20/05/2021"));

        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        gc.guardarCache();

    }

    public static void clientTeste10(GestaoAcessoAventureiro ga, GestaoAcessoCache gc, GestaoAcessoObjeto go) throws AventureiroNaoHabilitado, CacheNaoExisteException, AventureiroNaoExisteException, JaExisteObjetoNumaCacheException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Premium a1 = new Premium("jonas", 1, 2);
        Premium a2 = new Premium("carlos", 3, 4);
        ga.regista(a1);
        ga.regista(a2);
        TravelBug pilha = new TravelBug("pilha");
        TravelBug cao = new TravelBug("cao");
        TravelBug gato = new TravelBug("gato");
        TravelBug rato = new TravelBug("gato");
        TravelBug corno = new TravelBug("corno");
        TravelBug corno2 = new TravelBug("corno2");
        TravelBug corno3 = new TravelBug("corno3");
        TravelBug corno4 = new TravelBug("corno3");
        go.regista(pilha);
        go.regista(cao);
        go.regista(gato);
        go.regista(rato);
        go.regista(corno);
        go.regista(corno2);
        go.regista(corno3);
        go.regista(corno4);
        PremiumCache c1 = new PremiumCache(5, a1, pilha, 1, 3, "porto");
        PremiumCache c2 = new PremiumCache(5, a1, cao, 1, 3, "lisboa");
        PremiumCache c3 = new PremiumCache(5, a1, gato, 1, 3, "porto");
        PremiumCache c4 = new PremiumCache(5, a1, rato, 1, 3, "porto");
        gc.adicionaCache(c1);
        gc.adicionaCache(c2);
        gc.adicionaCache(c3);
        gc.adicionaCache(c4);
        a2.getListTravelBug().put(0, corno);
        a2.encontrouCache(c1, corno, sdf.parse("20/04/2021 18:24:23"));
        System.out.println("confirmacao");
        a2.getListTravelBug().printInOrder(a2.getListTravelBug().getRoot());
        System.out.println("fim");
        a2.encontrouCache(c2, corno2, sdf.parse("21/04/2021 19:24:23"));
        a2.encontrouCache(c3, corno3, sdf.parse("22/04/2021 20:24:23"));
        a2.encontrouCache(c2, pilha, sdf.parse("23/02/2021 20:23:23"));
        a2.encontrouCache(c1, gato, sdf.parse("24/02/2021 20:23:23"));

        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
        System.out.println();
        ga.getAventureiros().get(2).getDatas().printInOrder(ga.getAventureiros().get(2).getDatas().getRoot());
        System.out.println();
        ga.getAventureiros().get(2).getListCacheVisit().printInOrder(ga.getAventureiros().get(2).getListCacheVisit().getRoot());
        System.out.println();
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println();
        go.getTravelBug().printInOrder(go.getTravelBug().getRoot());
        System.out.println();
        System.out.println(go.travelBugVisits());
        System.out.println();
        System.out.println(go.getTravelBug().get(go.travelBugVisits()).getNumCachesPres());
        System.out.println();
        go.getTravelBug().get(1).getListaCachesPresente().printInOrder(go.getTravelBug().get(1).getListaCachesPresente().getRoot());

    }
}