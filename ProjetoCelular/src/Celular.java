public class Celular {

    private String marca;
    private String modelo;
    private int bateria;
    private int volume;

    public Celular(String marca, String modelo, int bateria, int volume) {

        this.marca = marca;
        this.modelo = modelo;
        this.bateria = bateria;
        this.volume = volume;

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
