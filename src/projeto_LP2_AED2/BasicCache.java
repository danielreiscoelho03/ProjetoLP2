package projeto_LP2_AED2;

public class BasicCache extends Cache{

    public BasicCache(Integer idCache, Integer dificuldade, Aventureiro aventureiro, Objeto objeto, int x, int y, String local) throws AventureiroNaoHabilitado {
        super(idCache, dificuldade, aventureiro, objeto, x, y, local);
    }

    public BasicCache(Integer idCache, Integer dificuldade, Aventureiro aventureiro, TravelBug tb, int x, int y, String local) throws AventureiroNaoHabilitado {
        super(idCache, dificuldade, aventureiro, tb, x, y, local);
    }
}
