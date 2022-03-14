package com.mycompany.reto_10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args){
        boolean opcion = true;
        
        
        List<Double> lista = new ArrayList();
        lista.add((double)19998);
        lista.add((double)198);
        lista.add((double)9991);
        lista.add((double)12345);
        
        List<Integer> listaEnteros = new ArrayList();
        listaEnteros.add(1);
        listaEnteros.add(12);
        listaEnteros.add(7);
        listaEnteros.add(3);
        listaEnteros.add(5);
        listaEnteros.add(4);
        
        Set<String> setString = new HashSet();
        setString.add("juan manuel");
        setString.add("paulina");
        setString.add("hola");
        setString.add("dos");
        setString.add("aeronave");
        setString.add("100");
        setString.add("sol");
        
        List<Estudiante> listaEstudiantes = new ArrayList();
        listaEstudiantes.add(new Estudiante("juan","restrepo",(double)4));
        listaEstudiantes.add(new Estudiante("juan2","restrepo2",(double)1));
        listaEstudiantes.add(new Estudiante("juan3","restrepo3",(double)2));
        listaEstudiantes.add(new Estudiante("juan4","restrepo4",(double)2));
        
        while(opcion){
            System.out.println("elija una opcion:1) punto uno.\n2) punto tres.\n3) punto 4");
            Scanner input = new Scanner(System.in);
            switch(input.nextInt()){
                case 1:{
                    System.out.println(Integer.toString(sumaHastaN(126)));
                    break;
                }
                case 2:{
                    Stream<Double> streamLista = lista.stream();
        
                    streamLista.map(numero -> Math.sqrt(numero))
                        .forEach(n -> System.out.println(n.toString()));
                    
                    Stream<Integer> streamListaEnteros = listaEnteros.stream();
        
                    streamListaEnteros.map(numero -> factorial(numero))
                        .forEach(n -> System.out.println(n.toString()));
                    
                    Stream<String> streamSetString = setString.stream();
        
                    List<String> nuevaListaString = streamSetString.filter(e -> e.length()>5 )
                            .toList();
                    streamSetString = nuevaListaString.stream();
                    streamSetString.forEach(n -> System.out.println(n));
                    break;
                }
                case 3:{
                    Stream<Estudiante> streamEstudiantes = listaEstudiantes.stream();
        
                    promedioEstudiantes(listaEstudiantes.stream());
                    //promedioMayor(listaEstudiantes.stream());
                    promedioMenor(listaEstudiantes.stream());
                    break;
                }
                default:{
                    opcion = false;
                }
            }
        }
       
    }
    
    static int factorial(int n){
        if(n<=1) return 1;
        else{
            int resultado = factorial(n-1)*n;
            return resultado;
        }
    }
    
    static void promedioEstudiantes(Stream<Estudiante> streamEstudiantes){
        
        double promedio = streamEstudiantes.map(e -> e.getPromedio())
                .mapToDouble(p -> p.doubleValue())
                .average()
                .getAsDouble();
        System.out.println("El promedio de los promedios de los estudiantes es: "+Double.toString(promedio));
    }
    static void promedioMayor(Stream<Estudiante> streamEstudiantes){
               /*OptionalDouble mayorPromedio = streamEstudiantes.map(e -> e.getPromedio())
                       .mapToDouble(p -> p.doubleValue())
                       .max()
                       .;
               */
    }
    static void promedioMenor(Stream<Estudiante> streamEstudiantes){
        double resultado = streamEstudiantes.map(e -> e.getPromedio())
                .mapToDouble(p -> p.doubleValue())
                .min().getAsDouble();
        System.out.println(Double.toString(resultado));
    }
    static int sumaHastaN(int n){
        if(n>0){
            int resultado = sumaHastaN(n/10)+n%10;
            return resultado;
        }
        else{
            return 0;
        }
    }
}
