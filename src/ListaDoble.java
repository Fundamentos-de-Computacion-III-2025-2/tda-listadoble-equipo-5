public class ListaDoble {
    protected NodoDoble inicio, fin; //Apuntadores para saber donde esta el inicio y el fin de la lista doble

    //Constructor para crear la lista doble vacía
    public ListaDoble(){
        inicio = null;
        fin =null;
    }

    //Metodo para saber si la lista doble está vacía
    public boolean listaVacia(){
        if(inicio==null){
            return true;
        }else{
            return false;
        }
    }

    //Metodo para agregar un NodoDoble al Inicio de la Lista Doble
    public void insertarInicio(int dato){//Angel Andres Santillanes Hernandez
        NodoDoble nuevo = new NodoDoble(dato);//crear nuevo nodo
        if (inicio==null) {// cuando no hay elementos, inicio y fin apuntan al primer nodo
            inicio = fin = nuevo;
        }else{
            nuevo.siguiente = inicio;
            inicio.anterior = nuevo;
            inicio = nuevo;
        }

    }

    //Metodo para insertar al Final de la lista doble
    public void insertarFinal(int dato){
        //TODO @(ALAN HORACIO BEJARANO CASTRO)

    }


    /* Metodo para insertar un elemento suponiendo que la lista está en orden ascendente
    es decir, se debe comenzar a recorrer la lista e insertar el elemento antes del primer
    número mayor al elemento que se encuentre en la lista, si no se encuentar un dato mayor
    se inserta al final */

    public void insertarEnOrden(int dato){
        // POR ELIAS VALDEZ MIRANDA
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
                NodoDoble nuevo = new NodoDoble(dato,actual,actual.anterior);
                actual.anterior.siguiente = nuevo;
                actual.anterior = nuevo;
                return;
            }
            actual = actual.siguiente;
        }
        insertarFinal(dato);
    }


    //Eliminar al inicio
    public int eliminarInicio(){//Angel Andres Santillanes Hernandez
        if(listaVacia()){
            throw new RuntimeException("Error: La lista esta vacia.");
        }
        int d;
        if (inicio == fin){
            d = inicio.dato;
            inicio=fin=null;
            return d;
        }else{
            d = inicio.dato;
            inicio = inicio.siguiente;
            inicio.anterior=null;
        }
        return d;
    }

    //Eliminar al final
    public int eliminarFinal(){
        //TODO @(ALAN HORACIO BEJARANO CASTRO)

        return -1;
    }

    //Eliminar un elemento
    public int eliminarElemento(int elemento){
        //TODO @(JOSUE EMILIANO ROBLEDO VILLEGAS)

        return elemento;
    }

    //Metodo para buscar un elemento
    public boolean buscarElemento(int elemento){
        //TODO @(JOSUE EMILIANO ROBLEDO VILLEGAS)

        return false;

    }

    //Imprimir los datos de la lista doble de inicio a fin
    public void mostrarInicioFin(){
        NodoDoble actual=inicio;
        System.out.println();
        while(actual!=null){
            System.out.print(actual.dato+" --> ");
            actual = actual.siguiente;
        }
    }

    //Imprimir los datos de la lista doble de fin a inicio
    public void mostrarFinInicio(){
        //TODO @(JOSE EVERARDO HERNANDEZ MONTOYA)

    }
}