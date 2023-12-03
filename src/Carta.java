public class Carta {
    private int numero;
    private Palo palo;

    public Carta(int numero, Palo palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

    // Método para obtener el valor de la carta
    public double getValor() {
        if (numero >= 10) {
            return 0.5; // Figuras valen medio punto
        }
        return numero;
    }

    @Override
    public String toString() {
        return numero + " de " + palo;
    }
}
