package projeto_LP2_AED2;

public class Main {
    public static void main(String[] args) throws JaExisteObjetoNumaCacheException, AventureiroNaoExisteException, CacheNaoExisteException {

        //GestaoAcessoAventureiro ga = new GestaoAcessoAventureiro();
        GestaoAcessoCache gc = new GestaoAcessoCache();
        /*
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
        ga.remove(1);
        ga.remove(9);
        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
        System.out.println("\n");
        System.out.println(ga.existe(1));
        System.out.println(ga.existe(2));
        ga.regista(a5);

         */

        Premium p = new Premium(20,"espirrolonca",1,2);
        Objeto objeto = new Objeto(1,"cruz");
        Cache cache = new Cache(gc.id(),8,p);

        Premium p1 = new Premium(21,"caraii",5,1);
        Objeto objeto1 = new Objeto(2,"sopa");
        Cache cache1 = new Cache(gc.id(),8,p1);

        Premium p2 = new Premium(22,"zebisgas",8,3);
        Objeto objeto2 = new Objeto(3,"bola");
        Cache cache2 = new Cache(gc.id(),8,p2);

        System.out.println("\nAPÓS ADICIONAR UMA CACHE DE CADA VEZ\n");
        //GestaoAcessoCache gc = new GestaoAcessoCache();
        gc.adicionaCache(cache);
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");
        gc.adicionaCache(cache1);
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");
        gc.adicionaCache(cache2);
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");

        gc.removeCache(cache1.getIdCache());
        System.out.println("\nAPÓS REMOÇÃO DE CACHE\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");

        gc.depositaObjeto(objeto,cache.getIdCache());
        gc.depositaObjeto(objeto1,cache2.getIdCache());
        System.out.println("\nAPÓS ADICIONAR OBJETO\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");

        /*
        Cache cache3 = new Cache(gc.id().i,8,p2);
        System.out.println("TESTE PARA VER SE POSSO ADICIONAR UM OBJETO QUE JÁ EXISTE NUMA CACHE NOUTRA CACHE");
        //gc.depositaObjeto(objeto2,cache3.getIdCache()); //adicionar um objeto que já está numa cache
        System.out.println("\nAPÓS ADICIONAR OBJETO\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");

         */

        gc.retiraObjeto(objeto,cache.getIdCache());
        gc.retiraObjeto(objeto1,cache2.getIdCache());
        System.out.println("\nAPÓS REMOVER OBJETOS\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");
        /*
        gc.depositaObjeto(objeto2,cache1.getIdCache());
        System.out.println("\nAPÓS ADICIONAR OBJETO\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");

         */


        System.out.println("TESTE SE EXISTE CACHE\n");
        Cache cache4 = new Cache(5,8,p2);
        if(gc.existeCache(cache4.getIdCache())){
            System.out.println("Cache Existe");
        }else{
            System.out.println("Cache não Existe");
        }
    }
}
