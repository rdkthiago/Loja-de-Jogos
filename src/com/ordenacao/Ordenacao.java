package com.ordenacao;
import com.classes.JogoDigital;

public class Ordenacao {
	public JogoDigital [] quicksort(JogoDigital [] vetor , int inicio , int fim) {
		int part;
		if(inicio<fim) {
			part = particao(vetor , inicio , fim);
			quicksort(vetor , inicio , part-1);
			quicksort(vetor , part+1 , fim);
		}
		
		return vetor;
	}

	private int particao(JogoDigital[] vetor, int inicio, int fim) {
		JogoDigital pivo = vetor[fim];
		int part = inicio-1;
		for(int i = inicio; i<fim; ++i) {
			if(vetor[i].getAnoLancamento() < pivo.getAnoLancamento()) {
				part++;
				trocar(vetor , i, part);
			}
			else if(vetor[i].getAnoLancamento() == pivo.getAnoLancamento()) {
				if(vetor[i].getNomeJogo().compareTo(pivo.getNomeJogo()) < 0) {
					part = part+1;
					trocar(vetor, i , part);
				}
			}
			
			
		}
		part ++;
		trocar(vetor , part , fim);
		return (part);
	}
	private void trocar(JogoDigital vetor[] , int i , int part) {
		JogoDigital aux  = vetor[i];
		vetor[i]  = vetor[part];
		vetor[part] = aux;
	}

}
