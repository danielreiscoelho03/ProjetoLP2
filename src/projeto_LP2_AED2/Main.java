package projeto_LP2_AED2;

public class Main {
<<<<<<< HEAD
    public static void main(String[] args) {
      

=======
    public static void main(String[] args) throws AventureiroNaoExisteException {
        GestaoAcessoAventureiro ga = new GestaoAcessoAventureiro();
        Basic a1 = new Basic(1, "kini");
        Basic a2 = new Basic(2, "mosca");
        Basic a3 = new Basic(3, "cao");
        Premium a4 = new Premium(4, "caozinho");
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
>>>>>>> b1b39e90383b0c71484de3b4eb33f7782bb4ab01
    }
}
