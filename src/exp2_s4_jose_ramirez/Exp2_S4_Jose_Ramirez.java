
package exp2_s4_jose_ramirez;


import java.util.Scanner;
/**
 *
 * @author jlrj0
 */
public class Exp2_S4_Jose_Ramirez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int  opcion , edad , i , j , ubiSector , ubiNroAsiento  ;        // declaracion de variables
        int posFila = -1;
        int posColumna = -1;
        int precioBase = 20000;
        int precioFinal , descuento;
        String selSector = new String ("");
        String selAsiento = new String ("") ;
        String rangoUsuario = new String ();
        
        Boolean validar = true;          // Variable usada para validar entradas
       
        String[] filas ={"A","B","C","D","E"};        // array usados para graficar asientos
        String[] columnas = {"1" , "2" , "3" , "4" , "5" };
        int [][] ubicacion;          // arrays usados para guardar los datos ingresados
        ubicacion = new int[5][5];
        int [][] ubicacionTemporal;
        ubicacionTemporal = new int[5][5];
        int[] sector;
        sector = new int[5];
        int[] nroAsiento;
        nroAsiento = new int[5];
        
        do{ // Inicio 
            System.out.println("\n Bienvenido al Tetro Moro");
            System.out.println("\n     Menu Principal");
            System.out.println("\n 1.- Comprar entrada");
            System.out.println(" 2.- Salir");
            System.out.println("\n Valor Entrada General $" + precioBase);
            System.out.println("\n Ingrese opcion 1 para comprar o 2 para salir");
            for (i = 0 ; i < ubicacionTemporal.length ; i++) {          //Inicializacion de array usado para 
                for (j = 0 ; j < ubicacionTemporal.length ; j++) {      //contabilizar las diferentes  
                    ubicacionTemporal[i][j] = 0;                        // compras hechas por un usuario y poder conssultar para el resumen
                    
                }
            }
            do{
            opcion = input.nextInt();       // ingreso opción de compra
            if ((opcion>=1) && (opcion <=2)){        // opción válida// validación ingreso menu principal
                validar = false;
                break;
            }else           // condición no valida
                System.out.println("Ingreso no valido, debe ser 1 o 2 ");
                validar = true;
            }
            while (validar);
            precioFinal = 0 ;
            descuento = 0 ;
            int precioFinalPagar = 0;
            int descuentoTotal = 0 ;
            if (opcion ==1){       // ingreso al sistema de compra válida
                System.out.println("\n Para comenzar su compra, ingrese su edad (Descuentos estudiantes(10%) y tercera edad(15%)): ");
                edad = input.nextInt();     // Ingreso edad cliente
                do {
                System.out.println("\n Elija un sector ( A,B,C,D,E ) y un numero de asiento (1 al 5) que se encuentre sin reserva");
                System.out.println("        R = Asiento reservado  /  SR = Asiento sin reserva ");
                System.out.println("");
                System.out.println("\n     (1)   (2)   (3)   (4)   (5)");     // Logica realizada para
                for (i = 0 ; i < filas.length ; i++){            // mostrar ubicaciones vacias 
                    System.out.print("("+ filas[i]+ ") ");
                    for (j = 0 ; j < nroAsiento.length ; j++){     // y ocupadas
                        if (ubicacion[i][j] == 0){
                            System.out.print("  SR  ");
                        } else {//
                            System.out.print("  R  ");
                        }
                    }System.out.println("\n");
                }
                do {
                System.out.println("Ingrese Sector ( A , B , C , D , E ) ");       //Ingreso de selección columna de asientos
                do {
                selSector = input.next().toUpperCase();
                for (i = 0 ; i < filas.length ; i++){
                    if (filas[i].equals(selSector)) {
                        posFila = i;
                        validar = true;
                        break;
                    }
                }
                if (i > 4) {          //Validacion de ingreso
                        System.out.println("Ingreso incorrecto, debe ser (A , B , C , C , D , E)");
                        validar = false;
                    }
                }while (!validar);
                System.out.println("Ingrese Numero de asiento (1 al 5)");     //Ingreso de selección de fila de asiento
                do {
                selAsiento = input.next();
                for (i =0 ; i < columnas.length ; i++) {
                    if (columnas[i].equals(selAsiento)) {
                        posColumna = i;
                        validar = true;
                        break;
                    }
                }
                if (i >4) {       //Validación de ingreso
                    System.out.println("Ingreso incorrecto, deber estar entre 1 y 5");
                    validar = false;
                }
                }while (!validar);
                if (ubicacion[posFila][posColumna] > 0){        // Aviso de selección asiento ya reservado
                    System.out.println("Asiento se encuentra reservado, elija otra ubicacion");
                }
                }while (ubicacion[posFila][posColumna] != 0);
                if (edad  <= 18) {                                               // Selección y cálculo estudante
                     precioFinal = (precioBase - ((10 * precioBase) / 100)) ;
                     descuento = precioBase - precioFinal;
                     rangoUsuario = "Estudiante";
                }
                else if (edad >= 60) {                                           // Selecion y cálculo tercera edad
                         precioFinal = (precioBase - ((15 * precioBase) / 100)) ;
                         descuento = precioBase - precioFinal;
                         rangoUsuario = "Tercera edad";
                        }
                else {
                      precioFinal = precioBase;                                  // Slección y cálculo público general
                      descuento = precioBase - precioFinal;
                      rangoUsuario = "Publico general";
                }
                ubicacion[posFila][posColumna] = precioFinal;  // Ingreso en array para almacenar asientos ocupados
                ubicacionTemporal[posFila][posColumna] = precioFinal;  // Ingreso temporal en array para compras por usuario 
               // precioFinalPagar = precioFinalPagar + precioFinal ;
                descuentoTotal = descuentoTotal + descuento;
                    System.out.println("");
                    System.out.println("\n Usted seleciono la ubicacion " +  filas[posFila] + columnas[posColumna] +" con un valor a pagar de $" + precioFinal + " por estar en el rango de " + rangoUsuario); //   Resumen de compra unitaria
                    System.out.println("");
                    System.out.println("\n Desea seguir comprando? (Seguir = opcion 1 / Salir = opcion 2");
                    int seguirCompra = input.nextInt();
                    switch (seguirCompra){
                        case 1: validar = true;
                        break;
                        case 2: validar = false;
                        break;
                        default: validar = false;
                        break;
                    }
            }while (validar) ;
                System.out.println("\n        Resumen del total de su compra :");   // Resumen de compra total de usuario
                System.out.println("\n Usted compro las siguientes ubicaciones :");
                for (i = 0 ; i < ubicacionTemporal.length ; i++){
                    for (j = 0 ; j < ubicacionTemporal.length ; j++){
                        if (ubicacionTemporal[i][j] > 0) {
                            System.out.println("Sector " + filas[i] + columnas[j]);
                            precioFinalPagar = precioFinalPagar + ubicacionTemporal[i][j];
                            
                        }
                    }
                }
                
                
                System.out.println("Con un valor total a pagar de $" + precioFinalPagar);
                System.out.println("Obteniendo un descuento total por $" + descuentoTotal + " por ser " + rangoUsuario);
                System.out.println("\n Muchas gracias por preferir nuestro Teatro");
                System.out.println("       Que disfrute la funcion!!!");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                
                
            }
        }while (opcion !=2);
        System.out.println("Hasta la proxima !!!");
        
        
        // TODO code application logic here
    }
    
}
