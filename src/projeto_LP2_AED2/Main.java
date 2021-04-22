package projeto_LP2_AED2;

public class Main {
<<<<<<< HEAD
    public static void main(String[] args) throws CacheNaoExisteException {
=======
    public static void main(String[] args) throws AventureiroNaoExisteException {
        GestaoAcessoAventureiro ga = new GestaoAcessoAventureiro();
        GestaoAcessoCache gc = new GestaoAcessoCache();
        Basic a1 = new Basic(ga.id(), "kini");
        Basic a2 = new Basic(ga.id(), "mosca");
        Basic a3 = new Basic(ga.id(), "cao");
        Premium a4 = new Premium(ga.id(), "caozinho");
        Admin a5 = new Admin(ga.id(), "joao");
        ga.regista(a1);
        ga.regista(a2);
        ga.regista(a3);
        ga.regista(a4);
        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
        System.out.println("\n");
        ga.remove(1);
        ga.getAventureiros().printInOrder(ga.getAventureiros().getRoot());
        System.out.println("\n");
        System.out.println(ga.existe(1));
        System.out.println(ga.existe(2));
        ga.regista(a5);
>>>>>>> dbc05eed02ebe51f7e936e6002840d88996d283d
    }
}
