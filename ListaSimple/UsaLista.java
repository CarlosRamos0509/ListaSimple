public class UsaLista {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        lista.insertaPrimerNodo("H");
        lista.insertaAntesPrimerNodo("O");
        lista.insertaAlFinal("Y");
        lista.insertaEntreNodos("R", "A");

        // Buscar nodo por posición (ejemplo: posición 2)
        Node nodoEnPosicion2 = lista.buscarPorPosicion(2);
        System.out.println("Nodo en posición 2: " + nodoEnPosicion2.name);

        // Insertar nuevo nodo antes del último
        lista.insertarAntesUltimo("NUEVO");
        lista.imprimir();

        // Intercambiar nodos (ejemplo: intercambiar "O" por "Y")
        lista.intercambiarNodos("O", "Y");
        lista.imprimir();
    }
}