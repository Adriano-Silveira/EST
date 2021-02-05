package Clases;

public class Arbol {

	public Nodo raiz;
	
	public Arbol() {
		raiz = null;
	}
	
	public void add(int i, Producto P) {
		Nodo n = new Nodo(i);
		n.produto = P;
		if(raiz ==null) {
			raiz =n;
		}else {
			Nodo aux = raiz;
			while(aux !=null) {
				n.raiz=aux;
				if(n.index>= aux.index) {
					aux = aux.right;
				}else {
					aux= aux.left;
				}
			}
			if(n.index<n.raiz.index) {
				n.raiz.left=n;
			}else {
				n.raiz.right=n;
			}
		}	
	}
	
	public void buscarProducto(int id, Nodo N) {
			while(N !=null) {
		if(N.produto.getId() == id) {
			System.out.println(N.produto.toString());
			break;
		}else{
				buscarProducto(id,N.right);
				break;
		}
	}
			if(N != null) {
			buscarProducto(id,N.left);
			}
	}
	
	public void recorrerArbol(Nodo n) {
		if(n !=null) {
			recorrerArbol(n.right);
			System.out.println("Objeto :"+ n.index + " "+ n.produto.toString());	
			recorrerArbol(n.left);
		}
	}
	
	
	private class Nodo{
		public Producto produto;
		public Nodo raiz;
		public Nodo left;
		public Nodo right;
		public int index;
		
		public Nodo (int index) {
			
			this.index=index;
			this.raiz=null;
			this.right=null;
			this.left=null;
			
		}
	}
}
