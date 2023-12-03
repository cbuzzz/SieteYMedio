import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SieteYMedio {
    private Pila<Carta> mazo;
    private List<Carta> manoJugador;
    private Random random;

    public SieteYMedio() {
        mazo = crearMazo();
        manoJugador = new ArrayList<>();
        random = new Random();
    }

    // Método para crear un mazo de cartas para el juego
    private Pila<Carta> crearMazo() {
        Pila<Carta> mazo = new Pila<>();
        // Agregar cartas al mazo (1 al 7, Sota, Caballo, Rey)
        for (int i = 1; i <= 7; i++) {
            mazo.put(new Carta(i, Palo.OROS));
            mazo.put(new Carta(i, Palo.COPAS));
            mazo.put(new Carta(i, Palo.ESPADAS));
            mazo.put(new Carta(i, Palo.BASTOS));
        }
        return mazo;
    }

    // Método para repartir una carta al jugador
    private void repartirCarta() {
        if (!mazo.isEmpty()) {
            Carta carta = mazo.pop();
            manoJugador.add(carta);
            System.out.println("Has recibido una carta: " + carta);
        } else {
            System.out.println("El mazo está vacío. Fin del juego.");
        }
    }

    // Método para calcular el total de puntos en la mano del jugador
    private double calcularTotal() {
        double total = 0;
        int ases = 0;

        for (Carta carta : manoJugador) {
            total += carta.getValor();
            if (carta.getNumero() == 1) {
                ases++;
            }
        }

        // Ajustar el valor de los ases
        while (total > 7.5 && ases > 0) {
            total -= 6.5; // Restar 1 punto (11 - 1)
            ases--;
        }

        return total;
    }

    // Método principal para ejecutar el juego
    public void jugar() {
        System.out.println("¡Bienvenido a Siete y Medio!");

        while (true) {
            System.out.println("¿Quieres otra carta? (s/n)");
            Scanner scanner = new Scanner(System.in);
            String respuesta = scanner.nextLine().toLowerCase();

            if (respuesta.equals("s")) {
                repartirCarta();
                double total = calcularTotal();
                System.out.println("Total de puntos: " + total);

                if (total == 7.5) {
                    System.out.println("¡Has obtenido 7.5! ¡Ganaste!");
                    break;
                } else if (total > 7.5) {
                    System.out.println("¡Te has pasado de 7.5! ¡Perdiste!");
                    break;
                }
            } else if (respuesta.equals("n")) {
                double total = calcularTotal();
                System.out.println("Total de puntos: " + total);

                if (total == 7.5) {
                    System.out.println("¡Has obtenido 7.5! ¡Ganaste!");
                } else {
                    System.out.println("¡Gracias por jugar! Tu total final es: " + total);
                }
                break;
            } else {
                System.out.println("Respuesta no válida. Por favor, responde con 's' o 'n'.");
            }
        }
    }

    public static void main(String[] args) {
        SieteYMedio juego = new SieteYMedio();
        juego.jugar();
    }
}

// Enumeración para los palos de las cartas
enum Palo {
    OROS,
    COPAS,
    ESPADAS,
    BASTOS
}


