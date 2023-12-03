import java.util.ArrayList;
import java.util.List;

public class Pila<T> {
    private List<T> elementos = new ArrayList<>();

    // Método para agregar un elemento en la parte superior de la pila (push)
    public void put(T elemento) {
        elementos.add(elemento);
    }

    // Método para eliminar y devolver el elemento en la parte superior de la pila (pop)
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return elementos.remove(elementos.size() - 1);
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    // Método para obtener el tamaño de la pila
    public int size() {
        return elementos.size();
    }

    // Método para obtener el elemento en la parte superior de la pila sin quitarlo
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return elementos.get(elementos.size() - 1);
    }

    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();
        pila.put(1);
        pila.put(2);
        pila.put(3);

        System.out.println("Elemento en la parte superior de la pila: " + pila.peek());
        System.out.println("Tamaño de la pila: " + pila.size());

        while (!pila.isEmpty()) {
            System.out.println("Pop: " + pila.pop());
        }
    }
}
