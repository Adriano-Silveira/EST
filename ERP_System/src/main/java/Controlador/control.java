package Controlador;
import java.util.ArrayList;
import java.util.List;
import Clases.Arbol;
import Clases.Producto;
import Clases.Stock;
import java.util.Scanner;

public class control {
	
	Arbol A =  new Arbol();

	List<Producto> P = new ArrayList<Producto>();
	Scanner input = new Scanner(System.in);
	
	public control(List<Producto> pro) {
		this.P=pro;
	
		for (Producto producto : pro) {
		int i = (int)(Math.random()* 15000) + 1;
		 A.add(i, producto);
		}
	}
	
	public control() {
		
	}
	
	public Producto BuscarId(int Id) {
		
		for (Producto producto : P) {
			if(Id == producto.getId()) {
			return producto;
		}
		}
		return null;
	}
	
	public void BuscarNom(String Nombre) {
		
		for (Producto producto : P) {
			if(producto.getName().contains(Nombre)) {
				System.out.println(producto.getId()+ " | "+ producto.getName()+ " | " + producto.getPrices_amountMax());
				
			}
		}
	}	
	
	public void Retirar(int Id,int cant) {
		
		Producto pro = BuscarId(Id);
		int stock=0;
		
		if(pro!=null) {
		if(pro.getStock().isEmpty()) {
			System.out.println("No encontrado el Stock");
		}else{
			for(Stock S : pro.getStock()) {
				stock += S.getCantidad();
			}
			while(cant !=0) {
				if(cant >= stock) {
					System.out.println("Cantidad a ser retirada mayor al stock Disponible");
					System.out.println("Desea retirar: " + stock + "\n 1-SI 2-NO");
							int op = input.nextInt();
							
							if(op==1) {
								Object P;
								while ((P = pro.getStock().poll()) != null) {
							         System.out.println("Elemento eliminado: " + P);
								}
								break;
							}
							if(op==2) {
								break;
							}	
				}
				if(cant < stock) {
					if(cant >= pro.getStock().element().getCantidad()) {
						cant -= pro.getStock().element().getCantidad();
						System.out.println("Removiendo = " +pro.getStock().poll()+ "  de la fila");
					}else if(cant < pro.getStock().element().getCantidad()) {
						pro.getStock().element().setCantidad(pro.getStock().element().getCantidad() - cant);
					System.out.println("Removiendo " + cant + " del Stock");
					cant =0;
					}
				}
			}
		}
		}else {
			System.out.println("No existe este producto en el stock");
		}
		}
	
	public void verStock(int id) {	
		int stock=0;
		for (Producto pro : P) {
			if(id==pro.getId()) {
			for(Stock S : pro.getStock()) {
				System.out.println(S.toString());
				stock += S.getCantidad();
			}
			System.out.println(" Stock total "+ stock);
			break;
			}
		}
	}
	
	public void BuscarArbol(int idp) {
		
		A.buscarProducto(idp,A.raiz);
	}
	
	public void BusquedaBinaria(int id) {
		int max = P.size()-1, min = 0, med;
		boolean verifi= false;
		while(min <= max) {
			 med = (max + min)/2;
			 
			if(P.get(med).getId()== id) {
				System.out.println(P.get(med));
				cantStock(id);
				verifi=true;
				break;
			}else if(id <P.get(med).getId()) {
				max = med -1;
				
			}else {
				min = med+1;
			}	
		}
		if(verifi!=true) {
			System.out.println("No encontrado");
		}	
	}
	
	public void cantStock(int id) {	
		int stock=0;
		for (Producto pro : P) {
			if(id==pro.getId()) {
			for(Stock S : pro.getStock()) {
				stock += S.getCantidad();
			}
			System.out.println("Stock total "+ stock);
			break;
			}
		}
	
	}
	
	public void listarp() {
		for (Producto producto : P) {
			System.out.println(producto.toString());
		}
	}
		
}
