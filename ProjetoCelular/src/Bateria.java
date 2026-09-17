public class Bateria {

    private int porcentagem;

    public Bateria(int porcentagem) {
        this.porcentagem = porcentagem;
    }

    public int getPorcentagem() {
        return porcentagem;
    }

    public void carregar(int quantidade) {
        if (quantidade > 0 && porcentagem + quantidade <= 100) {
            porcentagem = porcentagem + quantidade;
        }
    }
}