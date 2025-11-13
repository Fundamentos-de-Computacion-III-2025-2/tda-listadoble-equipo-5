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
                            "1. Insertar un elemento al inicio\n"+ //ANGEL ANDRES SANTILLANES HERNANDEZ
                                    "2. Insertar un elemento al final\n"+ //TODO @(ALAN HORACIO BEJARANO CASTRO)
                                    "3. Insertar un elemento en orden\n"+ // ELIAS VALDEZ MIRANDA
                                    "4. Eliminar un elemento al inicio\n"+ //ANGEL ANDRES SANTILLANES HERNANDEZ
                                    "5. Eliminar un elemento al final\n"+ //TODO @(ALAN HORACIO BEJARANO CASTRO)
                                    "6. Eliminar un elemento\n"+ //TODO @(JOSUE EMILIANO ROBLEDO VILLEGAS)
                                    "7. Buscar un elemento\n"+ //TODO @(JOSUE EMILIANO ROBLEDO VILLEGAS)
                                    "8. Mostrar los datos de inicio a fin\n"+
                                    "9. Mostrar los datos de fin a inicio\n"+ //TODO @(JOSE EVERARDO HERNANDEZ MONTOYA)
                                    "10. Salir\n",
                            "Menú de opciones", 3));
                    switch (opcion) {
                        case 1: //Angel Andres Santillanes Hernandez
                            try {
                                elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                        "Ingresa el elemento: ",
                                        "Insertar al inicio: ", 3));
                                lista.insertarInicio(elemento);
                            }catch (NumberFormatException n){
                                JOptionPane.showMessageDialog(null,"Error"+n.getMessage(),"No se inserto",0);
                            }
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
                        case 3: //Insertar en orden por ELIAS VALDEZ MIRANDA
                            try {
                                elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                        "Ingresa el elemento: ",
                                        "Insertar en orden: ", 3));
                                lista.insertarEnOrden(elemento);
                            } catch (NumberFormatException n) {
                                JOptionPane.showMessageDialog(null, "Error" + n.getMessage(), "Error de ingreso", 0);
                            }
                            break;
                        case 4: //Angel Andres Santillanes Hernandez
                            try {
                                elemento=lista.eliminarInicio();
                                JOptionPane.showMessageDialog(null, "Se eliminó al elemento " + elemento, "Eliminar elemento al inicio ", 1);
                            }catch (RuntimeException e) {
                                JOptionPane.showMessageDialog(null, "La lista esta vacia",
                                        "lista vacia",JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;
                        case 5: //Eliminar al final (ALAN HORACIO BEJARANO CASTRO)
                            try {
                                int elementoEliminado = lista.eliminarFinal();
                                JOptionPane.showMessageDialog(null, "Elemento " + elementoEliminado + " eliminado del final.");
                            } catch (RuntimeException e) {
                                JOptionPane.showMessageDialog(null, e.getMessage(), "Error al Eliminar", JOptionPane.ERROR_MESSAGE);
                            }
                            break;
                        case 6: // eliminarElemento
                            try {
                                elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el elemento a eliminar", "Eliminar elemento específico", JOptionPane.QUESTION_MESSAGE));
                                lista.eliminarElemento(elemento);
                                JOptionPane.showMessageDialog(null, "Se eliminó el elemento " + elemento, "Eliminar elemento específico", JOptionPane.INFORMATION_MESSAGE);

                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor ingrese un número entero.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                            }
                            catch (RuntimeException e) {JOptionPane.showMessageDialog(null, e.getMessage(), "Error al eliminar", JOptionPane.ERROR_MESSAGE);
                            }
                            break;
                        case 7:
                            try {
                                elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                        "Ingresa el elemento a buscar: ",
                                        "Buscar elemento: ", 3));
                                if (lista.buscarElemento(elemento)) {
                                    JOptionPane.showMessageDialog(null, elemento + " encontrado en la lista", "Elemento encontrado", 1);
                                } else {
                                    JOptionPane.showMessageDialog(null, elemento + " No encontrado en la lista", "Elemento No encontrado", 0);
                                }
                            } catch (NumberFormatException n) {
                                JOptionPane.showMessageDialog(null, "Error" + n.getMessage(), "Error de ingreso", 0);
                            }
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