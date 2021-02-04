package CargaDatos;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import com.opencsv.bean.CsvToBeanBuilder;

import Clases.Arbol;
import Clases.Producto;
import Clases.Stock;


public class Datos {
	
	List<Producto> P = new ArrayList<Producto>();
	Arbol A = new Arbol();
	
	
	public Datos() {
		
	}
	
	public void cargardatos() {
		System.out.println("Cargando datos...");
		try {
			 P = new CsvToBeanBuilder<Producto>(new FileReader("C:\\Users\\anato\\OneDrive\\Escritorio\\ERP_System\\Products.csv"))
			       .withType(Producto.class).build().parse();
		} catch (Exception e) {	
		}
		
		
		for (Producto producto : P) {
			producto.setStock(stock(producto.getId()));
			
		}
	}
	
	
	public Queue<Stock> stock(int id){
		Queue<Stock> filaS= new LinkedList<Stock>();
			 int control=0,numE=(int)(Math.random()*20) + 1;
			do {
			Stock S = new Stock();
			S.setIdP(id);
			S.setCantidad((int)(Math.random()* 100) + 1); 
			S.setFecha(fecha());
			
			filaS.add(S);
			control++;
			}while(control < numE);
		
		
		return filaS;
		
	}
	
	public  Date fecha() {
	Calendar Fecha;
      Random aleatorio;
      aleatorio = new Random();
      Fecha = Calendar.getInstance();
      Fecha.set(aleatorio.nextInt(5)+2020,aleatorio.nextInt(12)+1, aleatorio.nextInt(30)+1, aleatorio.nextInt(24)+1, aleatorio.nextInt(59)+1);
      return Fecha.getTime();
		
	}
	
	public List<Producto> getP() {
		return P;
	}

	public void setP(List<Producto> p) {
		P = p;
	}

	
}
