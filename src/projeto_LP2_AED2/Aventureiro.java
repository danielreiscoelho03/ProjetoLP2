package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import edu.princeton.cs.algs4.BST;

import java.util.Date;

public abstract class Aventureiro {

    //private BST<Integer, LogsDiario> histLogs = new BST<>();
    //private LogsDiario histLogs;

    private Integer idAventureiro;
    private String nome;
    private LogsDiario diario = new LogsDiario();
    private Localizacao local;
    private int numCacheVis;
    private int numCacheEsc;
    private int numObj;
    private int numTb;
    private Date data = new Date();

    private BST_AED2_2021<Integer, Cache> listCacheVisit = new BST_AED2_2021<>();
    private BST_AED2_2021<Integer, Date> datas = new BST_AED2_2021<>();
    private BST_AED2_2021<Integer, Cache> listCacheEsc = new BST_AED2_2021<>();
    private BST_AED2_2021<Integer, Objeto> listObjetos = new BST_AED2_2021<>();
    private BST_AED2_2021<Integer, TravelBug> listTravelBug = new BST_AED2_2021<>();

    public Aventureiro(String nome, int x, int y) {
        this.nome = nome;
        this.local = new Localizacao(x, y);
    }



    public BST_AED2_2021<Integer, Date> getDatas() {
        return datas;
    }

    public void setDatas(BST_AED2_2021<Integer, Date> datas) {
        this.datas = datas;
    }

    public BST_AED2_2021<Integer, TravelBug> getListTravelBug() { return listTravelBug; }

    public void setListTravelBug(BST_AED2_2021<Integer, TravelBug> listTravelBug) { this.listTravelBug = listTravelBug; }

    public BST_AED2_2021<Integer, Objeto> getListObjetos() {
        return listObjetos;
    }

    public void setListObjetos(BST_AED2_2021<Integer, Objeto> listObjetos) {
        this.listObjetos = listObjetos;
    }

    public int getNumCacheVis() {
        return numCacheVis;
    }

    public void setNumCacheVis(int numCacheVis) {
        this.numCacheVis = numCacheVis;
    }

    public int getNumCacheEsc() {
        return numCacheEsc;
    }

    public void setNumCacheEsc(int numCacheEsc) {
        this.numCacheEsc = numCacheEsc;
    }

    public Localizacao getLocal() {
        return local;
    }

    public void setLocal(Localizacao local) {
        this.local = local;
    }

    public Integer getIdAventureiro() {
        return idAventureiro;
    }

    public void setIdAventureiro(Integer idAventureiro) {
        this.idAventureiro = idAventureiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BST_AED2_2021<Integer, Cache> getListCacheVisit() {
        return listCacheVisit;
    }

    public BST_AED2_2021<Integer, Cache> getListCacheEsc() {
        return listCacheEsc;
    }

    public void addCacheVis(Cache c, Date d){
        listCacheVisit.put(numCacheVis,c);
        datas.put(numCacheVis, d);
        numCacheVis++;
        String toDiario ="O utilizador " + this.getNome() + " visitou esta cache: " + c.toString();
        diario.adicionaLog(toDiario, data,"data/LogsAventureiro");
        toDiario = "Dados do utilizador: " + this.toString();
        diario.adicionaLog(toDiario,data,"data/LogsAventureiro");

    }

    public boolean addCacheEsc(Cache c) throws AventureiroNaoHabilitado {
        if(this instanceof Premium || this instanceof Admin){
            listCacheEsc.put(numCacheEsc,c);
            numCacheEsc++;
            String toDiario = "O utilizador " + this.getNome() + " criou e escondeu esta cache: " + c.toString();
            diario.adicionaLog(toDiario, data, "data/LogsAventureiro");
            toDiario = "Dados do utilizador: " + this.toString();
            diario.adicionaLog(toDiario,data,"data/LogsAventureiro");
            return true;
        }
        throw new AventureiroNaoHabilitado("Nao esta habilitado a criar cache");
    }

    public void removeCacheEsc(Cache c) throws CacheNaoExisteException {
        if(this.getListCacheEsc().contains(c.idCache)){
            this.getListCacheEsc().delete(c.idCache);
        }
        throw new CacheNaoExisteException("Esta a remover uma cache que nao existe");
    }

    public void encontrouCache(Cache c, Objeto o, Date d){
        if(c.getObjeto()!=null){
            this.listObjetos.put(numObj, c.getObjeto());
            numObj++;
        }
        else if(c.getTravelbug()!=null){
            c.getTravelbug().getListaAventureiros().put(c.getTravelbug().getNumAventureiros(), this);
            c.getTravelbug().setNumAventureiros(c.getTravelbug().getNumAventureiros()+1);
            this.listTravelBug.put(numObj, c.getTravelbug());
            numTb++;
        }
        c.getHistAventureiros().put(c.getNumAvent(), this);
        c.setNumAvent(c.getNumAvent()+1);
        c.removeObjeto(c.getObjeto());
        this.addCacheVis(c, d);
        c.removeObjeto(c.getObjeto());
        c.setObjeto(o);
    }

    public void encontrouCache(PremiumCache c, TravelBug bg, Date d){
        if(this.getListTravelBug().get(0).getIdObjeto().equals(bg.getIdObjeto())){
            if(c.getObjeto()!=null){
                this.listObjetos.put(numObj, c.getObjeto());
                numObj++;
            }
            else if(c.getTravelbug()!=null){
                c.getTravelbug().getListaAventureiros().put(c.getTravelbug().getNumAventureiros(), this);
                c.getTravelbug().setNumAventureiros(c.getTravelbug().getNumAventureiros()+1);
                this.listTravelBug.put(numObj, c.getTravelbug());
                numTb++;
                c.getTravelbug().setViajar(true);
                bg.setViajar(false);
            }
            this.addCacheVis(c, d);
            c.getHistAventureiros().put(c.getNumAvent(), this);
            c.setNumAvent(c.getNumAvent()+1);
            c.removeObjeto(c.getObjeto());
            c.setTravelbug(bg);
            bg.getListaCachesPresente().put(bg.getNumCachesPres(),c);
            bg.setNumCachesPres(bg.getNumCachesPres()+1);
        }
    }

    @Override
    public String toString() {
        return "Id: " + idAventureiro +
                ", nome: " + nome +
                ", local: " + local +
                ", numCacheVis: " + numCacheVis +
                ", numCacheEsc: " + numCacheEsc;
    }
}