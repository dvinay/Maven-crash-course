package com.fuppino;

import java.util.Scanner;
/**
 * Sum of two numbers!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println( "Enter two numbers" );
    	Scanner input= new Scanner(System.in);
    	int a=input.nextInt();
    	int b=input.nextInt();
        int result = sum(a,b);
        System.out.println( "Sum of "+ a +" and "+ b +" is = "+result );
        input.close();
    }
    public static int sum(int a, int b) {
    	return a+b;
    }
}
