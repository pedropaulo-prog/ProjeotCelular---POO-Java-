public class Celular {

    private String marca;
    private String modelo;
    private int bateria;
    private int volume;

    public Celular(String marca, String modelo) {
        this.setMarca(marca);
        this.setModelo(modelo);
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void aumentarVolume(int quantidade) {

        if (quantidade > 0 && volume + quantidade <= 100) {
            volume = volume + quantidade;
        }

    }

    public void carregarBateria(int quantidade) {

        if (quantidade > 0 && bateria + quantidade <= 100) {
            bateria = bateria + quantidade;
        }

    }

    public int getVolume() {

        return volume;

    }

    public int getBateria() {

        return bateria;

    }
}