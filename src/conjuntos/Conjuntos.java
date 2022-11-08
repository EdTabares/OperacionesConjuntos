package conjuntos;

import javax.swing.JOptionPane;

public class Conjuntos {

    private static String setString = "";
    private static ConVector UniversalVector = new ConVector(0);
    //private static SetList UniversalList = new SetList();
    private static ConVector AVector = new ConVector(0);
    //private static SetList AList = new SetList();
    private static ConVector BVector = new ConVector(0);
    //private static SetList BList = new SetList();
    private static ConVector ResultVector = new ConVector(0);
    //private static SetList ResultList = new SetList();

    public static void main(String[] args) {
        menuppal();
    }

    private static void menuppal() {
        int opcion = -1;
        String menu = "***MENU PRINCIPAL OPERACIONES CON CONJUNTOS***\n"
                + "1- Definir el conjunto Universal\n"
                + "2- Conjuntos con Vectores\n"
                + "3- Conjuntos con Listas\n"
                + "0- Salir";
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcion) {
                    case 1:
                        conUniversal();
                        break;
                    case 2:
                        if (UniversalVector.size == 0) {
                            JOptionPane.showMessageDialog(null, "El conjunto Universal no puede estar vacio");
                        } else {
                        menuVectores();
                        }
                        break;
                    case 3:
                        menuListas();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 0);
    }

    private static void conUniversal() {
        setString = requestSet();
        UniversalVector.defineU(setString);
        JOptionPane.showMessageDialog(null, "Vector Universal: "
                + "\nVector:\n" + UniversalVector.show());
    }

    public static void menuVectores() {
        int opcion = 0;
        String menu = "***MENU CONJUNTOS EN VECTORES***\n"
                + "1- Definir conjunto A \n"
                + "2- Definir conjunto B \n"
                + "3- Pertenencia\n"
                + "4- Inclusión\n"
                + "5- Unión\n"
                + "6- Intersección\n"
                + "7- Igualdad\n"
                + "8- Complemento\n"
                + "9- Diferencia\n"
                + "10- Diferencia Simétrica\n"
                + "11- Mostrar A\n"
                + "12- Mostrar B\n"
                + "0- Salir";

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcion) {
                    case 1: //Definir A
                        setString = requestSet();
                        AVector.define(UniversalVector, setString);
                        break;
                        
                    case 2: //Definir B
                        setString = requestSet();
                        BVector.define(UniversalVector, setString);
                        break;
                        
                    case 3: //Pertenencia
                        setString = requestElement();
                        String answer = "";
                        if (AVector.exist(Integer.parseInt(setString))) 
                            answer = answer + "El elemento se encuentra en A\n";
                        if (BVector.exist(Integer.parseInt(setString))) 
                            answer = answer + "El elemento se encuentra en B\n";
                        
                        if (answer == "") {
                            JOptionPane.showMessageDialog(null, "El elemento no se encuentra ni en A ni en B");
                        } else{
                            JOptionPane.showMessageDialog(null, answer);
                        }                                           
                        break;
                        
                    case 4: //Inclusión
                        String result = "";
                        if(AVector.included(BVector)){
                            result = result + "El conjunto A está incluido en B\n";
                        }
                        if (BVector.included(AVector)) {
                            result = result + "El conjunto B está incluido en A\n";
                        }
                        if (result == "") {
                            JOptionPane.showMessageDialog(null, "Ni A ni B están incluidos en el otro");                            
                        } else {
                            JOptionPane.showMessageDialog(null, result);
                        }
                        break;
                        
                    case 5: //Unión
                        ResultVector = AVector.union(BVector);
                        JOptionPane.showMessageDialog(null, "La unión de A y B es:\n" + ResultVector.show());
                        break;
                        
                    case 11: //Mostrar A
                        JOptionPane.showMessageDialog(null, "El conjunto A es: "+AVector.show());
                        break;
                        
                    case 12: //Mostrar B
                        JOptionPane.showMessageDialog(null, "El conjunto A es: "+BVector.show());
                        break;
                        
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "opcion no válida");
                }
            } catch (Exception e) {
            }
        } while (opcion != 0);
    }

    public static void menuListas() {
        int opcion = 0;
        String menu = "***MENU CONJUNTOS EN LISTAS***\n"
                + "1- \n"
                + "2- \n"
                + "3- \n"
                + "4- \n"
                + "5- \n"
                + "6- \n"
                + "7- \n"
                + "0- Salir";

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "opcion no válida");
                }
            } catch (Exception e) {
            }
        } while (opcion != 0);

    }

    private static String requestSet() { //Pide String al usuario y limpia espacios en Blanco
        String set = JOptionPane.showInputDialog("Ingrese numeros enteros separados por coma");
        set = set.replaceAll("\\s", "");  // \\s --> Indica un solo cáracter de espacio en blanco
        return set;
    }

    private static String requestElement() {
        String set = JOptionPane.showInputDialog("Ingrese un elemento");
        set = set.replaceAll("\\s", "");
        return set;
    }

    public static boolean isNumeric(String str) {
        boolean isNumeric = str.matches("[+-]?\\d+");
        return isNumeric;
    }

}
