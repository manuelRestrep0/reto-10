package com.mycompany.reto_10;

public class recursividad {
    int sumaHastaN(int n){
        if(n<=0) return 0;
        else{
            int resultado = sumaHastaN(n-1)+n;
            return resultado;
        }
    }

    
    public recursividad() {
    }
    
}
