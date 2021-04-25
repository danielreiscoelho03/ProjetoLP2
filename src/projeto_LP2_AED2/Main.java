package projeto_LP2_AED2;

public class Main {
    public static void main(String[] args) throws JaExisteObjetoNumaCacheException, AventureiroNaoExisteException, CacheNaoExisteException {
        GestaoAcessoAventureiro ga = new GestaoAcessoAventureiro();
        GestaoAcessoCache gc = new GestaoAcessoCache();
        //GestaoAcessoObjeto go = new GestaoAcessoObjeto();

        ga.lerAventureiros();
        gc.lerCache();

        System.out.println("Leitura do ficheiro\n\n\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
        System.out.println("\n\n\nAcabou a leitura");

        Basic a1 = new Basic(ga.id(), "jonas", 1, 2);
        Basic a2 = new Basic(ga.id(), "carlos",3, 4);
        Basic a3 = new Basic(ga.id(), "miguel", 5, 6);
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

        Objeto pilha = new Objeto(5, "pilha");
        Objeto corno = new Objeto(6, "corno");
        Objeto gato = new Objeto(7, "gato");
        Cache c1 = new Cache(gc.id(), 5, a1, pilha, 1, 3);
        Cache c2 = new Cache(gc.id(), 5, a2, corno, 4, 5);
        Cache c3 = new Cache(gc.id(), 5, a2, gato, 5,6);

        gc.adicionaCache(c1);
        gc.adicionaCache(c2);
        gc.adicionaCache(c3);

        System.out.println("\n\tteste das funcoes do admin\n");
        System.out.println("\n\t\tVER LOCALIZACAO DE CACHE ESPECIFICA: ");
        a5.verLocalizacaoCache(c1);
        System.out.println("\n\t\tVER LOCALIZACAO DE AVENTUREIRO ESPECIFICO: ");
        a5.verLocalizacaoAventureiro(a1);
        System.out.println("\n\t\tVER TODAS AS CACHES: ");
        a5.verTodasCaches(gc);
        System.out.println("\n\t\tVER TODOS OS AVENTUREIROS: ");
        a5.verTodosAventureiros(ga);
        System.out.println("\n\tFIM\n");


        ga.guardarAventureiros();
        gc.guardarCache();


    }
}