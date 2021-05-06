package projeto_LP2_AED2;

import Search.BST_AED2_2021;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GestaoAcessoObjeto implements GestaoObjetos{
    private int numObjeto = 1;
    private int numTb = 1;
    public BST_AED2_2021<Integer, Objeto> objetos = new BST_AED2_2021<>();
    public BST_AED2_2021<Integer, TravelBug> travelBug = new BST_AED2_2021<>();


    public int getNumTb() {
        return numTb;
    }

    public void setNumTb(int numTb) {
        this.numTb = numTb;
    }

    public BST_AED2_2021<Integer, TravelBug> getTravelBug() {
        return travelBug;
    }

    public void setTravelBug(BST_AED2_2021<Integer, TravelBug> travelBug) {
        this.travelBug = travelBug;
    }

    public int getNumObjeto() {
        return numObjeto;
    }

    public void setNumObjeto(int numObjeto) {
        this.numObjeto = numObjeto;
    }

    public BST_AED2_2021<Integer, Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(BST_AED2_2021<Integer, Objeto> objetos) {
        this.objetos = objetos;
    }

    public void menuGestaoObjeto(GestaoAcessoAventureiro ga, GestaoAcessoCache gc) throws AventureiroNaoExisteException, AventureiroNaoHabilitado, JaExisteObjetoNumaCacheException, ParseException, CacheNaoExisteException {
        boolean f = true;
        while (f){
            Scanner sc = new Scanner(System.in);
            System.out.println("[1]-Adicionar Objeto/TravelBug");
            System.out.println("[2]-Remover Objeto/TravelBug");
            System.out.println("[3]-Editar Objeto/TravelBug");
            System.out.println("[4]-Voltar");
            int aux2 = sc.nextInt();
            switch (aux2){
                case 1:
                    sc.nextLine();
                    System.out.println("Insira o tipo do objeto:");
                    String tipo = sc.nextLine();
                    boolean correto = false;
                    while(!correto) {
                        if (tipo.equals("TravelBug")) { //se for Premium
                            System.out.println("Insira o nome do TravelBug:");
                            String nome = sc.nextLine();
                            TravelBug tb = new TravelBug(nome);
                            regista(tb);
                            correto = true;
                        } else if (tipo.equals("Objeto")) { //se for Basic
                            System.out.println("Insira o nome do Objeto:");
                            String nome = sc.nextLine();
                            Objeto o = new Objeto(nome);
                            regista(o);
                            correto = true;
                        } else {
                            System.out.println("Volte a inserir o tipo de Objeto:");
                            tipo = sc.nextLine();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Quer remover um Objeto ou TravelBug:");
                    System.out.println("[1]-Objeto:");
                    System.out.println("[2]-TravelBug:");
                    int r = sc.nextInt();
                    if(r == 1){
                        System.out.println("Insira o id do objeto:");
                        removeO(sc.nextInt());
                    }
                    else if(r == 2){
                        System.out.println("Insira o id do travelBug:");
                        removeTb(sc.nextInt());
                    }
                    break;
                case 3:
                    System.out.println("Quer editar um Objeto ou TravelBug:");
                    System.out.println("[1]-Objeto:");
                    System.out.println("[2]-TravelBug:");
                    r = sc.nextInt();
                    if(r == 1){
                        System.out.println("Insira o id do objeto:");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Qual o novo nome do objeto:");
                        String nome = sc.nextLine();
                        editarO(id, nome);
                    }
                    else if(r == 2){
                        System.out.println("Insira o id do travelBug:");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Qual o novo nome do travelBug:");
                        String nome = sc.nextLine();
                        editarTb(id, nome);
                    }
                    break;
                case 4:
                    guardarObjeto(gc, ga);
                    gc.guardarCache(ga, this);
                    ga.guardarAventureiros(gc, this);
                    Main.clientTeste13(ga, gc, this, 0);
                    f = false;
                    break;
            }
        }
    }

    @Override
    public boolean editarO(int id, String nome){
        if(objetos.get(id) != null){
            objetos.get(id).setNome(nome);
            return true;
        }
        return false;
    }

    @Override
    public boolean editarTb(int id, String nome){
        if(travelBug.get(id) != null){
            travelBug.get(id).setNome(nome);
            return true;
        }
        return false;
    }

    @Override
    public boolean regista(Objeto objeto) {
        objeto.setIdObjeto(numObjeto);
        objetos.put(numObjeto,objeto);
        numObjeto ++;
        return true;
    }

    @Override
    public boolean regista(TravelBug tb) {
        tb.setIdObjeto(numTb);
        travelBug.put(numTb,tb);
        numTb ++;
        return true;
    }

    @Override
    public boolean removeO(Integer idObjeto) {
        if(objetos.contains(idObjeto)){
            objetos.delete(idObjeto);
            return true;
        }
        return false;
    }
    @Override
    public boolean removeTb(Integer idTb) {
        if(travelBug.contains(idTb)){
            travelBug.delete(idTb);
            return true;
        }
        return false;
    }

    @Override
    public boolean existeO(Integer idObjeto) {
        return objetos.contains(idObjeto);
    }

    public boolean existeTb(Integer idObjeto) {
        return travelBug.contains(idObjeto);
    }

    public int travelBugVisits(){
        int x = 1, id = 0, num = 0;
        while(x < travelBug.size()){
            if(travelBug.get(x).getNumCachesPres() > num){
                id = travelBug.get(x).getIdObjeto();
                num = travelBug.get(x).getNumCachesPres();
            }
            x++;
        }
        return id;
    }

    public void lerObjeto(){
        In infile = new In("data/Objeto.txt");
        String line = null;
        while((line = infile.readLine()) != null){
            String[] parts = line.split(" ");
            String part0 = parts[0]; // id
            int id = Integer.parseInt(part0);
            String part1 = parts[1]; // nome
            Objeto o = new Objeto(part1);
            o.setIdObjeto(numObjeto);
            getObjetos().put(numObjeto, o);
            numObjeto++;
        }
    }

    public void lerTb(){
        In infile = new In("data/TravelBug.txt");
        String line = null;
        while((line = infile.readLine()) != null){
            String[] parts = line.split(" ");
            String part0 = parts[0]; // id
            int id = Integer.parseInt(part0);
            String part1 = parts[1]; // nome
            String part2 = parts[2]; // numCachePres
            int numCachePres = Integer.parseInt(part2);
            String part3 = parts[2+numCachePres+1]; // numAvent
            int numAvent = Integer.parseInt(part3);
            String part4 = parts[2+numCachePres+1+numAvent+2]; // numMissao
            int numMissao = Integer.parseInt(part4);
            StringBuilder missao = new StringBuilder(numMissao + " " + parts[2+numCachePres+1+numAvent+2+1]); // Missao
            int i = 2+numCachePres+1+numAvent+2+1+1;
            while(!parts[i].equals(".")){
                missao.append(" ").append(parts[i]);
                i++;
            }
            TravelBug t = new TravelBug(part1, missao.toString());
            t.setIdObjeto(numTb);
            getTravelBug().put(numTb, t);
            numTb++;
        }
    }

    public void lerTbHist(GestaoAcessoCache gc, GestaoAcessoAventureiro ga){
        In infile = new In("data/TravelBug.txt");
        String line = null;
        ArrayList<Integer> idCaches = new ArrayList<>();
        ArrayList<Integer> idAventureiros = new ArrayList<>();
        while((line = infile.readLine()) != null){
            idAventureiros.removeAll(idAventureiros);
            idCaches.removeAll(idCaches);
            String[] parts = line.split(" ");
            int id = Integer.parseInt(parts[0]);
            int numCachePres = Integer.parseInt(parts[2]);
            for (int i = 3; i <= 3+numCachePres-1; i++) {
                idCaches.add(Integer.parseInt(parts[i]));
            }
            int numAvent = Integer.parseInt(parts[3+numCachePres]);
            for (int i = 3+numCachePres+1; i < 3+numCachePres+1+numAvent; i++) {
                idAventureiros.add(Integer.parseInt(parts[i]));
            }
            String viajar = parts[3+numCachePres+1+numAvent];
            int x = 0;
            if(viajar.equals("true")){
                while (idCaches.size()>x){
                    getTravelBug().get(id).getListaCachesPresente().put(getTravelBug().get(id).getNumCachesPres(), (PremiumCache)gc.getCaches().get(idCaches.get(x)));
                    getTravelBug().get(id).setNumCachesPres(getTravelBug().get(id).getNumCachesPres()+1);
                    x++;
                }
                getTravelBug().get(id).setViajar(true);
            }else if(viajar.equals("false")){
                while (idCaches.size()-1>x){
                    getTravelBug().get(id).getListaCachesPresente().put(getTravelBug().get(id).getNumCachesPres(), (PremiumCache)gc.getCaches().get(idCaches.get(x)));
                    getTravelBug().get(id).setNumCachesPres(getTravelBug().get(id).getNumCachesPres()+1);
                    x++;
                }
                getTravelBug().get(id).setViajar(false);
            }
            x = 0;
            while (idAventureiros.size()>x){
                getTravelBug().get(id).getListaAventureiros().put(getTravelBug().get(id).getNumAventureiros(), ga.getAventureiros().get(idAventureiros.get(x)));
                getTravelBug().get(id).setNumAventureiros(getTravelBug().get(id).getNumAventureiros()+1);
                x++;
            }
            int j = 1;
            if(viajar.equals("false")){
                while (getTravelBug().get(id).getNumCachesPres()-1 > j){
                        PremiumCache temp = getTravelBug().get(id).getListaCachesPresente().get(j);
                        getTravelBug().get(id).getListaCachesPresente().put(j, getTravelBug().get(id).getListaCachesPresente().get(j+1));
                        getTravelBug().get(id).getListaCachesPresente().put(j+1, temp);
                    j++;
                }
            }
        }
    }

    public void guardarObjeto(GestaoAcessoCache gc, GestaoAcessoAventureiro ga){
        if(objetos.size()>0){
            Out outfile = new Out("data/Objeto.txt");
            int x = 1, k = 1;
            while(k <= objetos.size()){
                if(objetos.get(x) != null) {
                    String toSave = objetos.get(x).getIdObjeto() + " " + objetos.get(x).getNome();
                    outfile.println(toSave);
                    k++;
                }
                x++;
            }
        }
        if(travelBug.size()>0){
            Out outfile = new Out("data/TravelBug.txt");
            int x = 1, k = 1;
            while(k <= travelBug.size()){
                if(travelBug.get(x) != null){
                    StringBuilder toSave = new StringBuilder(travelBug.get(x).getIdObjeto() + " " + travelBug.get(x).getNome());
                    StringBuilder temp = new StringBuilder();
                    int j = 1;
                    while(travelBug.get(x).getListaCachesPresente().size() >= j){
                        if(gc.getCaches().contains(travelBug.get(x).getListaCachesPresente().get(j).getIdCache()))
                            temp.append(travelBug.get(x).getListaCachesPresente().get(j).getIdCache()).append(" ");
                        else
                            travelBug.get(x).setNumCachesPres(travelBug.get(x).getNumCachesPres()-1);
                        j++;
                    }
                    if(travelBug.get(x).getListaCachesPresente().size() <=0 ){
                        toSave.append(" ").append(0);
                    }else{
                        toSave.append(" ").append(travelBug.get(x).getListaCachesPresente().size());
                        toSave.append(" ").append(temp);
                    }
                    j=0;
                    temp = new StringBuilder();
                    while (travelBug.get(x).getListaAventureiros().size() > j){
                        if(ga.getAventureiros().contains(travelBug.get(x).getListaAventureiros().get(j).getIdAventureiro()))
                            temp.append(" ").append(travelBug.get(x).getListaAventureiros().get(j).getIdAventureiro());
                        else
                            travelBug.get(x).setNumAventureiros(travelBug.get(x).getNumAventureiros()-1);
                        j++;
                    }
                    if(travelBug.get(x).getNumAventureiros() <=0 ){
                        toSave.append(0);
                    }else{
                        toSave.append(travelBug.get(x).getNumAventureiros());
                        toSave.append(temp);
                    }
                    toSave.append(" ").append(travelBug.get(x).isViajar());
                    toSave.append(" ").append(travelBug.get(x).getMissao()).append(" .");
                    outfile.println(toSave);
                    k++;
                }
                x++;
            }

        }
    }

    public void now(){
        int x = 1;
        while(travelBug.size() >= x) {
            System.out.println("==============================================================================");
            System.out.println("Nome do TravelBug: " + travelBug.get(x).getNome());
            System.out.println("A localizacao atual é: " + travelBug.get(x).getListaCachesPresente().get(travelBug.get(x).getNumCachesPres() - 1).getLocal().getLocalizacao());
            int p = travelBug.get(x).getNumCachesPres()-1;
            System.out.println("Numero de caches percorridas: " + p);
            if(travelBug.get(x).isViajar()) {
                System.out.println("O TravelBug esta a ser transportado neste momento pelo aventureiro: " + travelBug.get(x).getListaAventureiros().get(travelBug.get(x).getNumAventureiros() - 1).getNome());
            }
            else if(travelBug.get(x).getNumAventureiros() > 0){
                if (travelBug.get(x).getListaAventureiros().get(travelBug.get(x).getNumAventureiros() - 1).getNome() != null)
                    System.out.println("O ultimo Aventureiro que o transportou foi: " + travelBug.get(x).getListaAventureiros().get(travelBug.get(x).getNumAventureiros() - 1).getNome());
            }
            if(travelBug.get(x).getNumCachesPres() == 2){
                System.out.println("O TravelBug so esteve na sua cache atual: " + travelBug.get(x).getListaCachesPresente().get(travelBug.get(x).getNumCachesPres()-1).getIdCache());
            }else{
                if(travelBug.get(x).getListaCachesPresente().get(travelBug.get(x).getNumCachesPres()-1) != null && !travelBug.get(x).isViajar()){
                    System.out.println("A Cache atual: " + travelBug.get(x).getListaCachesPresente().get(travelBug.get(x).getNumCachesPres()-1).getIdCache());
                }
                if(travelBug.get(x).getListaCachesPresente().get(1) != null){
                    System.out.println("A primeira cache: " + travelBug.get(x).getListaCachesPresente().get(1).getIdCache());
                }
            }
            if(travelBug.get(x).getNumCachesPres() > 2){
                int k = 1;
                while(k < travelBug.get(x).getNumCachesPres()-1){
                    System.out.println("O " + k + " caminho percorrido foi de " + travelBug.get(x).getListaCachesPresente().get(k).getLocal().getLocalizacao() + " para " + travelBug.get(x).getListaCachesPresente().get(k+1).getLocal().getLocalizacao());
                    double dist = travelBug.get(x).getListaCachesPresente().get(k).getLocal().distancia(travelBug.get(x).getListaCachesPresente().get(k+1).getLocal());
                    //System.out.println("A distancia percorrida foi de: " + dist);
                    System.out.printf("A distancia percorrida foi de %.2f metros.\n", dist);
                    k++;
                }
            }
            System.out.println("==============================================================================");
            x++;
        }
    }

    public void topTravelBug(){
        ArrayList<TravelBug> temp = new ArrayList<>();
        ArrayList<Integer> numTb = new ArrayList<>();
        int x = 1, k = 1;
        while(getTravelBug().size()>x){
            int numC = getTravelBug().get(x).getNumCachesPres();
            if(getTravelBug().get(k).getNumCachesPres() > 1){
                if(numTb.isEmpty()) {
                    temp.add(getTravelBug().get(k));
                    numTb.add(numC);
                }else {
                    for (int o = 0; o < numTb.size(); o++){
                        if(numTb.get(o)<numC){
                            if(numTb.size() == o+1){
                                temp.add(temp.get(o));
                                numTb.add(numTb.get(o));
                            }else{
                                for (int j = numTb.size(); j>o; j--){
                                    if(j == numTb.size()){
                                        temp.add(j, temp.get(j-1));
                                        numTb.add(j, numTb.get(j-1));
                                    }else{
                                        temp.set(j, temp.get(j-1));
                                        numTb.set(j, numTb.get(j-1));
                                    }
                                }
                            }
                            temp.set(o, getTravelBug().get(k));
                            numTb.set(o, numC);
                            o = numTb.size();
                        }else if(o == numTb.size()-1){
                            numTb.add(numC);
                            temp.add(getTravelBug().get(k));
                            o = numTb.size();
                        }
                    }
                }
                x++;
            }
            k++;
        }
        for (TravelBug t : temp){
            int i =t.getNumCachesPres()-1;
            System.out.println("Id Tb: " + t.getIdObjeto() + ", numero localizacoes: " + i);
        }
    }

}
