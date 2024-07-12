package tarea7;

import java.util.Arrays;

public class ararys {
	 static void desplazaDerecha(int[] lista){
	        int i,ultimo;
	        
	        //Cojo el último elemento del array y lo guardo en "ultimo"
	        ultimo=lista[lista.length-1];
	        //desplazo todos los elementos de derecha a izquierda
	        //dejando sin hueco en la primera posición
	        for(i=lista.length-1; i>0; i--){
	            lista[i]=lista[i-1];
	        }
	        //pongo en la primera posición "ultimo" que rescaté al principio
	        lista[0]=ultimo;
	    }
	    
	    public static void main(String[] args) {
	        int[] numeros=new int[10];
	        int i;
	        
	        //Inicializo el array con valores aleatorios del 1 al 100
	        for (i=0;i < numeros.length;i++)
	            numeros[i]=(int)(Math.random()*100+1);
	        
	        System.out.println("Array inicial: "+Arrays.toString(numeros));
	        //desplazo a la derecha el array
	        desplazaDerecha(numeros);
	        System.out.println("Array desplazado: "+Arrays.toString(numeros)); 
	    }
}

