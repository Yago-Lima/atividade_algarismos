package com.yagofranca;

import static java.lang.String.join;

import static java.util.Collections.nCopies;

public class ConversorAlgoritimico {
    public static void main(String[] args) {
       
    }

    private static final int[] DECIMAIS = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    private static final String[] ROMANOS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    public static int subtrair(int valorAtual, int valorProximo){

        
        return valorProximo - valorAtual; // Subtrai o valor atual do valor próximo e adiciona ao resultado
    }

    public static boolean validaNumero(int num){

        if (num >= 1 && num <= 3999) {
            return true;
        }

        return false;
    }
  
    public static boolean validaAlgarismo(char atual, String entrada){
        
        int cont = 0;
        for (char e : entrada.toCharArray()) {
            if (e ==  atual) {
                cont++;
            }else{
                cont = 0;
            }
        }// verifica a quantidade de repetições em sequencia de um algarismo
        
        return (cont <= 3)?true:false;
    }

    public static String converterEmDecimal(String entrada) {
        entrada = entrada.toUpperCase(); // Garante que a entrada esteja em maiúsculas para facilitar a comparação
        int resultado = 0;
        int i = 0; 
    
        while (i < entrada.length()) { // Entra em um loop enquanto houver caracteres na entrada
            char atual = entrada.charAt(i); // Pega o caractere atual na posição 'i'
            if (validaAlgarismo(atual, entrada)) {
                    int valorAtual = valorRomano(atual); // Obtém o valor decimal correspondente ao caractere atual

    
            if (i + 1 < entrada.length()) { // Verifica se há um próximo caractere na entrada
                char proximo = entrada.charAt(i + 1); // Pega o próximo caractere
                int valorProximo = valorRomano(proximo); 
    
                if (valorAtual < valorProximo) { // Compara os valores atuais e próximos
                    resultado += subtrair(valorAtual, valorProximo);
                    i += 2; // Pula dois caracteres (atual e próximo)
                } else {
                    resultado += valorAtual; // Adiciona o valor atual ao resultado
                    i++; // Avança para o próximo caractere
                }
            } else {
                resultado += valorAtual; // Adiciona o valor atual ao resultado (último caractere)
                i++; // Avança para a próxima posição (fora dos limites, sairá do loop)
            }
        }
        }

        return Integer.toString(resultado) ; 
    }
    
   

     public static int valorRomano(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0; // Se o caractere não for reconhecido, retorna 0
        }
    }
    
    

  
    public static String converterEmRomanos(int entrada) {

        
        
        if (validaNumero(entrada)) {
            
            
        StringBuilder resultado = new StringBuilder(); // Inicializa um StringBuilder para construir a representação romana do número
        
        for (int i = 0; i < DECIMAIS.length; i++) { // Percorre a lista de valores decimais em ordem decrescente
            int parteInteira = entrada / DECIMAIS[i]; // Calcula quantas vezes o valor decimal atual cabe no número de entrada
    
            if (parteInteira == 0) {
                continue; // Se parteInteira for 0, não há correspondência, então passa para o próximo valor decimal
            }
    
            entrada -= DECIMAIS[i] * parteInteira; // Remove a parte convertida do número de entrada
    
            resultado.append(join("", nCopies(parteInteira, ROMANOS[i]))); // Adiciona a representação romana ao resultado
        }
                        return resultado.toString(); // Retorna a representação romana completa como uma string
        }
      
        return "use apenas numeros entre 1 e 3999";
    }
    
}
