public class ListaSimple {
    Node top;

    // Métodos para los casos de inserción de nodos
    public boolean insertaPrimerNodo(String dato) {
        if (top == null) { // La lista está vacía
            top = new Node();
            top.name = dato;
            top.next = null;

            return true;
        } else {
            return false;
        }
    }

    public void insertaAntesPrimerNodo(String nombre) {
        Node temp;
        temp = new Node();
        temp.name = nombre;
        temp.next = this.top;
        this.top = temp;
        temp = null;
    }

    public void insertaAlFinal(String nombre) {
        Node temp = new Node();
        temp.name = nombre;
        temp.next = null;
        Node temp2 = this.top;

        while (temp2.next != null)
            temp2 = temp2.next;

        temp2.next = temp;
        temp = null;
        temp2 = null;
    }

    public boolean insertaEntreNodos(String nombre, String buscado) {
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = this.top;

        while ((temp2 != null) && temp2.name.equals(buscado) == false) {
            temp2 = temp2.next;
        }

        if (temp2 != null) { // Nodo buscado se encontró
            temp.next = temp2.next;
            temp2.next = temp;
            temp = null;
            temp2 = null;
            return true;
        } else return false;
    }

    // Métodos de borrado
    public void borrarPrimerNodo() {
        this.top = this.top.next;
    }

    // Borrar cualquier nodo que no sea el primero
    public boolean borrarCualquierNodo(String buscado) {
        Node temp = this.top;

        while ((temp != null) && temp.name.equals(buscado) == false) {
            temp = temp.next;
        }

        if (temp != null) { // Nodo buscado se encontró
            temp.next = temp.next.next;
            temp = null;

            return true;
        } else return false;
    }

    // Nuevos métodos adicionales
    public Node buscarPorPosicion(int posicion) {
        int contador = 0;
        Node temp = this.top;

        while (temp != null && contador < posicion) {
            temp = temp.next;
            contador++;
        }

        return temp;
    }

    public void insertarAntesUltimo(String nombre) {
        Node nuevoNodo = new Node();
        nuevoNodo.name = nombre;
        nuevoNodo.next = null;

        if (this.top == null) {
            // La lista está vacía, insertar como primer nodo
            this.top = nuevoNodo;
        } else {
            // Buscar el último nodo
            Node temp = this.top;
            while (temp.next != null) {
                temp = temp.next;
            }

            // Insertar antes del último nodo
            temp.next = nuevoNodo;
        }
    }

    public boolean intercambiarNodos(String nodo1, String nodo2) {
        Node temp = this.top;
        Node nodoAnterior1 = null;
        Node nodoAnterior2 = null;
        Node nodoActual1 = null;
        Node nodoActual2 = null;

        // Buscar los nodos y sus nodos anteriores
        while (temp != null) {
            if (temp.name.equals(nodo1)) {
                nodoActual1 = temp;
                break;
            }
            nodoAnterior1 = temp;
            temp = temp.next;
        }

        temp = this.top; // Reiniciar la búsqueda desde el principio

        while (temp != null) {
            if (temp.name.equals(nodo2)) {
                nodoActual2 = temp;
                break;
            }
            nodoAnterior2 = temp;
            temp = temp.next;
        }

        // Verificar que ambos nodos fueron encontrados
        if (nodoActual1 != null && nodoActual2 != null) {
            // Intercambiar los nodos
            if (nodoAnterior1 != null) {
                nodoAnterior1.next = nodoActual2;
            } else {
                this.top = nodoActual2;
            }

            if (nodoAnterior2 != null) {
                nodoAnterior2.next = nodoActual1;
            } else {
                this.top = nodoActual1;
            }

            Node tempNext = nodoActual1.next;
            nodoActual1.next = nodoActual2.next;
            nodoActual2.next = tempNext;

            return true;
        }

        return false; // Al menos uno de los nodos no fue encontrado
    }

    public void imprimir() {
        for (Node temp = this.top; temp != null; temp = temp.next) {
            System.out.print("[ " + temp.name + " ] -> ");
        }

        System.out.print("[X]\n");
    }

    public String toString() {
        String cadAux = "";
        for (Node temp = this.top; temp != null; temp = temp.next) {
            cadAux += "[ " + temp.name + " ] -> ";
        }

        cadAux += "[X]\n";

        return cadAux;
    }
}











