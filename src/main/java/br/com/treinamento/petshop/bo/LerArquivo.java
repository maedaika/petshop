package br.com.treinamento.petshop.bo;

public class LerArquivo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String texto = "cachorro1,xxx,22-12-2021,1";
		String[] array = texto.split(",");
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);

	}

}
