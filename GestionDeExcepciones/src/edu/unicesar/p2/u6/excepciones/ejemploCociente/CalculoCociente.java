/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicesar.p2.u6.excepciones.ejemploCociente;

import java.util.Scanner;

/**
 *
 * @author jairo
 */
public class CalculoCociente {
    public static void main(String arg[]){
        Scanner entrada = new Scanner(System.in);
        boolean error = true;
        do{
            try{
                System.out.print("Registre numerador (numerico): ");
                int num = entrada.nextInt();

                System.out.print("Registre denominador (numerico): ");
                int den = entrada.nextInt();

                System.out.println("Cociente=" + cociente(num, den));
                error=false;
            }
            catch(java.util.InputMismatchException IME){
                System.out.println("Se requiere un valor numerico");
                System.out.println("Excepcion del tipo: " + IME);
                entrada.nextLine();
            }
            catch(MyExcepcion AE){
                System.out.println("No se puede dividir por cero");
                System.out.println("Excepcion del tipo: " + AE);
            }
            
            finally{
                if(error){
                    System.out.println("!Se presentaron excepciones¡");
                    System.out.println("\nRegistre los datos nuevamente\n");
                }
                else{
                    System.out.println("!No Se presentaron excepciones¡");
                    System.out.println("\nCierra controladamente\n");
                }
            }
        }while(error);    
    }
    
    public static int cociente(int n, int d) throws MyExcepcion {
        if(d==0)
            throw new MyExcepcion("El numerador no puede ser cero");
        
        return n/d;
    }
}
