
public class ListaDoble {
    protected NodoDoble inicio, fin; //Apuntadores para saber donde está el inicio y el fin de la lista doble

    // Constructor para crear la lista doble vacía
    public ListaDoble() {
        inicio = null;
        fin = null;
    }

    // Metodo para saber si la lista doble está vacía
    public boolean listaVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    // Metodo para agregar un NodoDoble al Inicio de la Lista Doble
    // ANGEL ANDRES SANTILLANES HERNANDEZ
    public void insertarInicio(int dato) {
        NodoDoble nuevo = new NodoDoble(dato); //crear nuevo nodo
        if (inicio == null) { // cuando no hay elementos, inicio y fin apuntan al primer nodo
            inicio = fin = nuevo;
        } else {
            nuevo.siguiente = inicio;
            inicio.anterior = nuevo;
            inicio = nuevo;
        }

    }

    //Metodo para insertar al final de la lista doble
    // ALAN HORACIO BEJARANO CASTRO
    public void insertarFinal(int dato) {

        NodoDoble nuevo = new NodoDoble(dato);
        if (listaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            nuevo.anterior = fin;
            fin = nuevo;
        }
    }

    /* Metodo para insertar un elemento suponiendo que la lista está en orden ascendente
    es decir, se debe comenzar a recorrer la lista e insertar el elemento antes del primer
    número mayor al elemento que se encuentre en la lista, si no se encuentra un dato mayor
    se inserta al final */
    // ELIAS VALDEZ MIRANDA
    public void insertarEnOrden(int dato) {
        // Si la lista está vacía o el primer elemento es mayor al dato otorgado,
        // se actualiza la lista insertando un nuevo nodo al inicio.
        if (listaVacia() || inicio.dato >= dato) {
            insertarInicio(dato);
            return;
        }
        // Si la cabeza de la lista es igual a la cola, se trabaja con un solo
        // elemento y, como no se introduce al inicio, se introduce al final.
        else if (inicio == fin) {
            insertarFinal(dato);
            return;
        }
        // Se busca un dato que sea mayor al dato otorgado, y, de encontrarlo,
        // se introduce en medio de la lista. De lo contrario, si se llega al
        // final, se introduce el nodo al final.
        NodoDoble actual = inicio;
        while (actual != null) {
            if (actual.dato > dato) {
                NodoDoble nuevo = new NodoDoble(dato, actual, actual.anterior);
                actual.anterior.siguiente = nuevo;
                actual.anterior = nuevo;
                return;
            }
            actual = actual.siguiente;
        }
        insertarFinal(dato);
    }


    //Eliminar al inicio
    // ANGEL ANDRES SANTILLANES HERNANDEZ
    public int eliminarInicio() {
        if (listaVacia()) {
            throw new RuntimeException("Error: La lista esta vacía.");
        }
        int d;
        if (inicio == fin) {
            d = inicio.dato;
            inicio = fin = null;
            return d;
        } else {
            d = inicio.dato;
            inicio = inicio.siguiente;
            inicio.anterior = null;
        }
        return d;
    }

    //Eliminar al final
    // ALAN HORACIO BEJARANO CASTRO
    public int eliminarFinal() {
        if (listaVacia()) {
            throw new RuntimeException("La lista doble está vacía. No se puede eliminar el elemento final.");
        }

        int elemento = fin.dato;

        if (inicio == fin) {
            inicio = null;
            fin = null;
        } else {
            fin = fin.anterior;
            fin.siguiente = null;
        }
        return elemento;
    }

    // Eliminar un elemento
    // JOSUE EMILIANO ROBLEDO VILLEGAS
    public int eliminarElemento(int elemento) {
        if (listaVacia()) {
            throw new RuntimeException("Lista vacía: No hay elemento por eliminar");
        }
        if (inicio == fin && inicio.dato == elemento) {
            inicio = null;
            fin = null;
            return elemento;
        }
        if (inicio.dato == elemento) {
            inicio = inicio.siguiente;
            if (inicio != null) {
                inicio.anterior = null;
            }
            return elemento;
        }
        NodoDoble anterior = inicio;
        NodoDoble actual = inicio.siguiente;

        while (actual != null && actual.dato != elemento) {
            anterior = actual;
            actual = actual.siguiente;
        }
        if (actual != null) {
            anterior.siguiente = actual.siguiente;
            if (actual.siguiente != null) {
                actual.siguiente.anterior = anterior;
            }
            if (actual == fin) {
                fin = anterior;
            }
            return elemento;
        }
        throw new RuntimeException("No se encontró el elemento por eliminar");
    }

    // Metodo para buscar un elemento
    // JOSUE EMILIANO ROBLEDO VILLEGAS
    public boolean buscarElemento(int elemento) {
        NodoDoble actual = inicio;
        while (actual != null) {
            if (actual.dato == elemento) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    //Imprimir los datos de la lista doble de inicio a fin
    public void mostrarInicioFin() {
        NodoDoble actual = inicio;
        System.out.println();
        while (actual != null) {
            System.out.print(actual.dato + " --> ");
            actual = actual.siguiente;
        }
    }

    // Imprimir los datos de la lista doble de fin a inicio
    // JOSE EVERARDO HERNANDEZ MONTOYA
    public void mostrarFinInicio() {

        NodoDoble actual = fin; // Empezamos desde el final
        System.out.println(); // Salto de línea por estética

        while (actual != null) {
            System.out.print(actual.dato + " --> ");
            actual = actual.anterior; // Nos movemos hacia atrás
        }
    }

}