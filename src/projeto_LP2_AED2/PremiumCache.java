package projeto_LP2_AED2;

public class PremiumCache extends Cache{

    public PremiumCache(Integer idCache, Integer dificuldade, Aventureiro aventureiro, Objeto objeto, int x, int y) throws AventureiroNaoHabilitado {
        super(idCache, dificuldade, aventureiro, objeto, x, y);
    }

    public PremiumCache(Integer idCache, Integer dificuldade, Aventureiro aventureiro, TravelBug tb, int x, int y) throws AventureiroNaoHabilitado {
        super(idCache, dificuldade, aventureiro, tb, x, y);
    }
}
