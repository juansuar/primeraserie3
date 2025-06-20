
class Nodo {
    int valor;
    Nodo izquierda, derecha;

    Nodo(int valor) {
        this.valor = valor;
        izquierda = derecha = null;
    }
}

public class ProfundidadArbol {

    // Profundidad mínima (hasta la hoja más cercana)
    public static int profundidadMinima(Nodo nodo) {
        if (nodo == null)
            return 0;
        if (nodo.izquierda == null && nodo.derecha == null)
            return 1;
        if (nodo.izquierda == null)
            return profundidadMinima(nodo.derecha) + 1;
        if (nodo.derecha == null)
            return profundidadMinima(nodo.izquierda) + 1;
        return Math.min(profundidadMinima(nodo.izquierda), profundidadMinima(nodo.derecha)) + 1;
    }

    // Profundidad máxima (hasta la hoja más lejana)
    public static int profundidadMaxima(Nodo nodo) {
        if (nodo == null)
            return 0;
        return Math.max(profundidadMaxima(nodo.izquierda), profundidadMaxima(nodo.derecha)) + 1;
    }

    public static void main(String[] args) {
        // Armamos el árbol igualito al del ejercicio:
        /*
               3
              / \
             9  20
                / \
              15   7
        */
        Nodo raiz = new Nodo(3);
        raiz.izquierda = new Nodo(9);
        raiz.derecha = new Nodo(20);
        raiz.derecha.izquierda = new Nodo(15);
        raiz.derecha.derecha = new Nodo(7);

        System.out.println("Profundidad mínima: " + profundidadMinima(raiz));
        System.out.println("Profundidad máxima: " + profundidadMaxima(raiz));
    }
}
