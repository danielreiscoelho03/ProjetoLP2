package projeto_LP2_AED2;

public class Localizacao {

    private Integer coordenadaX;
    private Integer coordenadaY;
    private String localizacao;

    public Localizacao(Integer coordenadaX, Integer coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public Localizacao(Integer coordenadaX, Integer coordenadaY, String localizacao) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.localizacao = localizacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(Integer coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public Integer getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(Integer coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public double distancia(Localizacao local) {
        return Math.sqrt(Math.pow(distanceX(local), 2.0) + Math.pow(distanceY(local), 2.0));
    }

    public double distanceX(Localizacao local) {
        return Math.abs(this.getCoordenadaX() - local.getCoordenadaX());
    }

    public double distanceY(Localizacao local) {
        return Math.abs(this.getCoordenadaY() - local.getCoordenadaY());
    }

    @Override
    public String toString() {
        return "X = " + coordenadaX +
                ", Y = " + coordenadaY;
    }
}