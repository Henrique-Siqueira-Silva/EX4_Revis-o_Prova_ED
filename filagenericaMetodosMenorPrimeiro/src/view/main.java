package view;

import controller.Lista;

public class main<T> {
	public static void main(String[] args) throws Exception {
		
	Lista<Integer> f = new Lista<>();	
	
	Integer[] vet = {13,4,21,10};
	
	for ( int i = 0; i < 4; i++) {
		Integer valor =  vet[i];
		f.addFirst(valor);
	}
	
	
	for (int i = 0; i < 4; i++) {
		System.out.println(f.get(i));
		
	}
		
	f.MoveMenor();
	
	for (int i = 0; i < 4; i++) {
		System.out.println(f.get(i));
		
	}
	
	}
}
