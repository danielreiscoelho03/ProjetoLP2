package projeto_LP2_AED2;

public class Main {
    public static void main(String[] args) throws CacheNaoExisteException, JaExisteObjetoNumaCacheException, AventureiroNaoExisteException {

        GestaoAcessoCache gc = new GestaoAcessoCache();


        Premium p = new Premium(20,"espirrolonca");
        Objeto objeto = new Objeto(1,"cruz");
        Cache cache = new Cache(1,8,p);

        Premium p1 = new Premium(21,"caraii");
        Objeto objeto1 = new Objeto(2,"sopa");
        Cache cache1 = new Cache(2,8,p1);

        Premium p2 = new Premium(22,"zebisgas");
        Objeto objeto2 = new Objeto(3,"bola");
        Cache cache2 = new Cache(3,8,p2);

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

        gc.depositaObjeto(objeto2,cache.getIdCache());
        gc.depositaObjeto(objeto1,cache2.getIdCache());
        System.out.println("\nAPÓS ADICIONAR OBJETO\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");
        /*
        Cache cache3 = new Cache(4,8,p2);
        System.out.println("TESTE PARA VER SE POSSO ADICIONAR UM OBJETO QUE JÁ EXISTE NUMA CACHE NOUTRA CACHE");
        //gc.depositaObjeto(objeto2,cache3.getIdCache()); //adicionar um objeto que já está numa cache
        System.out.println("\nAPÓS ADICIONAR OBJETO\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");

         */

        gc.retiraObjeto(objeto2,cache.getIdCache());
        gc.retiraObjeto(objeto1,cache2.getIdCache());
        System.out.println("\nAPÓS REMOVER OBJETOS\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");

        gc.depositaObjeto(objeto2,cache.getIdCache());
        System.out.println("\nAPÓS ADICIONAR OBJETO\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");

        System.out.println("TESTE SE EXISTE CACHE\n");
        Cache cache4 = new Cache(5,8,p2);
        if(gc.existeCache(cache4.getIdCache())){
            System.out.println("Cache Existe");
        }else{
            System.out.println("Cache não Existe");
        }
    }
}
