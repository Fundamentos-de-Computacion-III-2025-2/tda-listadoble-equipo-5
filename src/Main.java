import javax.swing.*;

public class Main {

        /*
        En este metodo va toda la interfaz del usuario
        Las clases NodoDoble y ListaDoble deben tener solo implementación (nada de interfaz o visualización),
        excepto los métodos de mostrarInicioFin y mostrarFinInicio (son los únicos que pueden imprimir en consola
        o devolver un String para después imprimirlo desde aquí o mostrarlo en un JOptionPane aquí en Main.java).
         */

        /*
        Pueden usar JOptionPane o hacer la interfaz por consola.
        Deben definir un menú con las siguientes opciones:
                "1. Insertar un elemento al inicio\n"+
                "2. Insertar un elemento al final\n"+
                "3. Insertar un elemento en orden\n"+
                "4. Eliminar un elemento al inicio\n"+
                "5. Eliminar un elemento al final\n"+
                "6. Eliminar un elemento\n"+
                "7. Buscar un elemento\n"+
                "8. Mostrar los datos de inicio a fin\n"+
                "9. Mostrar los datos de fin a inicio\n"+
                "10. Salir\n","Menú de opciones",3));
        */
        public static void main(String[] args) {

            int opcion = 0;
            int elemento;
            ListaDoble lista = new ListaDoble();

            do {
                try {
                    opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "1. Insertar un elemento al inicio\n"+ //TODO @(ANGEL ANDRES SANTILLANES HERNANDEZ)
                                    "2. Insertar un elemento al final\n"+ //TODO @(ALAN HORACIO BEJARANO CASTRO)
                                    "3. Insertar un elemento en orden\n"+ //TODO @(ELIAS VALDEZ MIRANDA)
                                    "4. Eliminar un elemento al inicio\n"+ //TODO @(ANGEL ANDRES SANTILLANES HERNANDEZ)
                                    "5. Eliminar un elemento al final\n"+ //TODO @(ALAN HORACIO BEJARANO CASTRO)
                                    "6. Eliminar un elemento\n"+ //TODO @(JOSUE EMILIANO ROBLEDO VILLEGAS)
                                    "7. Buscar un elemento\n"+ //TODO @(JOSUE EMILIANO ROBLEDO VILLEGAS)
                                    "8. Mostrar los datos de inicio a fin\n"+
                                    "9. Mostrar los datos de fin a inicio\n"+ //TODO @(JOSE EVERARDO HERNANDEZ MONTOYA)
                                    "10. Salir\n",
                            "Menú de opciones", 3));
                    switch (opcion) {
                        case 1://Insertar un elemento al inicio TODO @(ANGEL ANDRES SANTILLANES HERNANDEZ)
                            break;
                        case 2://Insertar un elemento al final (ALAN HORACIO BEJARANO CASTRO)
                            try{
                                elemento = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el elemento a insertar al final:", "Insertar al final", 3));
                                lista.insertarFinal(elemento);
                                JOptionPane.showMessageDialog(null, "Elemento" + elemento + "Insertando al final.");
                            } catch(NumberFormatException n){
                                JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                            }
                            break;
                        case 3: //Insertar en orden TODO @(ELIAS VALDEZ MIRANDA)
                            break;
                        case 4: //Eliminar al inicio TODO @(ANGEL ANDRES SANTILLANES HERNANDEZ)
                            break;
                        case 5: //Eliminar al final (ALAN HORACIO BEJARANO CASTRO)
                            try {
                                int elementoEliminado = lista.eliminarFinal();
                                JOptionPane.showMessageDialog(null, "Elemento " + elementoEliminado + " eliminado del final.");
                            } catch (RuntimeException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Eliminar", JOptionPane.ERROR_MESSAGE);
                            }
                            break;
                        case 6: //Eliminar elemento TODO @(JOSUE EMILIANO ROBLEDO VILLEGAS)
                            break;
                        case 7: //Buscar elemento TODO @(JOSUE EMILIANO ROBLEDO VILLEGAS)
                            break;
                        case 8: //MostrarLista (InicioFin)
                            lista.mostrarInicioFin();
                            break;
                        case 9: //MostrarLista (FinInicio) TODO @(JOSE EVERARDO HERNANDEZ MONTOYA)
                            lista.mostrarFinInicio();
                            break;
                        case 10: //Salir
                            JOptionPane.showMessageDialog(null, "Programa Finalizado");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción Incorrecta");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "error" + e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (opcion != 10);
    }
}