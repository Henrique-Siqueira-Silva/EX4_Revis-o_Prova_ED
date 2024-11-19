package controller;

public class Lista<T> {

	No<T> primeiro;

	public Lista() {
		primeiro = null;
	}

	public boolean isEmpty() {
		if (primeiro == null) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		int cont = 0;
		if (!isEmpty()) {
			No<T> auxiliar = primeiro;
			while (auxiliar != null) {
				cont++;
				auxiliar = auxiliar.proximo;
			}
		}
		return cont;
	}

	private No<T> getNo(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Invalida");
		}
		int cont = 0;
		No<T> auxiliar = primeiro;
		while (cont < pos) {
			cont++;
			auxiliar = auxiliar.proximo;
		}
		return auxiliar;
	}

	public void addFirst(Integer valor) {
		No<T> elemento = new No<>();
		elemento.dado = (T) valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}

	public void addLast(T valor) throws Exception {
		if (isEmpty()) {
//			throw new Exception("Lista Vazia");
			addFirst((Integer) valor);
		}
		int tamanho = size();
		No<T> elemento = new No<>();
		elemento.dado = valor;
		elemento.proximo = null;
		No<T> ultimo = getNo(tamanho - 1);
		ultimo.proximo = elemento;
	}

	public void add(T valor, int pos) throws Exception {
		int tamanho = size();
		if (pos < 0 || pos > tamanho) {
			throw new Exception("Posição Invalida");
		}
		if (pos == 0) {
			addFirst((Integer) valor);
		} else if (pos == tamanho) {
			addLast(valor);
		} else {
			No<T> anterior = getNo(pos - 1);
			No<T> elemento = new No<>();
			elemento.dado = valor;
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
	}

	public void removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		primeiro = primeiro.proximo;
	}

	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if (tamanho == 1) {
			removeFirst();
		} else {
			No<T> penultimo = getNo(tamanho - 2);
			penultimo.proximo = null;
		}
	}

	public void remove(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Invalida");
		}
		if (pos == 0) {
			removeFirst();
		} else if (pos == tamanho - 1) {
			removeLast();
		} else {
			No<T> anterior = getNo(pos - 1);
			No<T> atual = getNo(pos);
			anterior.proximo = atual.proximo;
		}
	}

	public T get(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Invalida");
		}
		No<T> auxiliar = getNo(pos);
		return auxiliar.dado;
	}
	

	public void MoveMenor () throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		No<T> aux = primeiro;
		Integer menor =  (Integer) aux.dado;
		int cta = -1;
		while (aux.proximo != null) {
			if ( (Integer) aux.dado < menor ) {
				menor =  (Integer) aux.dado;
			}
			aux = aux.proximo;
			cta++;
		}
		remove(cta);
		addFirst( menor);
}
}
