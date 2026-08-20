public class Main {

    public static void main(String[] args) {

        Celular celular = new Celular(
                "Apple",
                "iPhone 17 Pro Max",
                50,
                40
        );

        // Teste do volume
        System.out.println("Volume inicial: " + celular.getVolume());

        celular.aumentarVolume(20);

        System.out.println("Volume após aumentar: " + celular.getVolume());

        celular.aumentarVolume(50);

        System.out.println("Volume após tentativa inválida: " + celular.getVolume());


        // Teste da bateria
        System.out.println("Bateria inicial: " + celular.getBateria());

        celular.carregarBateria(30);

        System.out.println("Bateria após carregar: " + celular.getBateria());

        celular.carregarBateria(50);

        System.out.println("Bateria após tentativa inválida: " + celular.getBateria());

    }

}
