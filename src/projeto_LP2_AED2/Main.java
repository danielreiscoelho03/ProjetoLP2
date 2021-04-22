package projeto_LP2_AED2;

public class Main {
    public static void main(String[] args) throws CacheNaoExisteException, JaExisteObjetoNaCacheException {
        Premium p = new Premium(20,"espirrolonca");
        Objeto o = new Objeto(1,"cruz");
        Cache c = new Cache(1,8,p);

        Premium p1 = new Premium(21,"caraii");
        Objeto o1 = new Objeto(2,"sopa");
        Cache c1 = new Cache(2,8,p1);

        Premium p2 = new Premium(22,"zebisgas");
        Objeto o2 = new Objeto(3,"bola");
        Cache c2 = new Cache(3,8,p2);
        GestaoAcessoCache gc = new GestaoAcessoCache();
        gc.adicionaCache(c);
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");
        gc.adicionaCache(c1);
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");
        gc.adicionaCache(c2);
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");

        gc.removeCache(c1.getIdCache());
        System.out.println("\nAPÓS REMOÇÃO\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");

        gc.depositaObjeto(o2,c.getIdCache());
        gc.depositaObjeto(o1,c2.getIdCache());
        System.out.println("\nAPÓS ADICIONAR OBJETO\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");

        gc.retiraObjeto(o2,c.getIdCache());
        gc.retiraObjeto(o1,c2.getIdCache());
        System.out.println("\nAPÓS REMOVER OBJETOS\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");

        gc.depositaObjeto(o2,c.getIdCache());
        System.out.println("\nAPÓS ADICIONAR OBJETO\n");
        gc.getCaches().printInOrder(gc.getCaches().getRoot());
        System.out.println("\n");
    }
}
