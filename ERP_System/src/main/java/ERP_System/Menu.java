package ERP_System;

import java.util.Scanner;

import CargaDatos.Datos;
import Clases.Producto;
import Controlador.control;


public class Menu {
		static Datos D = new Datos(); 
		static control C = new control();
		
	public static void main(String[] args)  {
		
		D.cargardatos();
		 C = new control(D.getP());
		
		 M();
	}
	
	static void M() {
		Scanner input = new Scanner(System.in);
		int op;
		
		do {
			System.out.println("\n---------------MENU------------------ ");
			System.out.println("1-Buscar por Id    | 2-Buscar por nombre");
			System.out.println("3-Retirar por Id   | 4-Busqueda en arbol");
			System.out.println("5-Ver stock por Id | 0- Cerrar");
			op=input.nextInt();
			input.nextLine();
			
		switch (op){
		case 1:
				System.out.println("Informe el ID");
			int ID = input.nextInt();
			input.nextLine();
			Producto p = C.BuscarId(ID);
			if(p==null) {System.out.println(" Producto no encontrado ");}
			else {
			System.out.println(p.toString());
			}
			
			break;
		case 2:
			System.out.println("Ingrese el Nombre");
			String Nombre = input.nextLine();
			C.BuscarNom(Nombre);
			break;
		case 3:
			System.out.println("Informe el ID : ");
			int id= input.nextInt();
			input.nextLine();
			System.out.println("Cantidad a ser retirada :");
			int cant = input.nextInt();
			input.nextLine();
			C.Retirar(id, cant);
			break;
		case 4:
			System.out.println("Informe el Id");
			 id = input.nextInt();
			 input.nextLine();
			C.verArbol(id);
			break;
		case 5:
			System.out.println("Ingresar ID :");
			id= input.nextInt();
			C.verStock(id);
			
			break;
		case 6:
			
			break;
		default:
			break;
		}
		}while(op!=0);
		input.close();
	}
}
