package exampleclass;

import java.util.Arrays;

public class Calculators {
    @Override
    public String toString(){ // 重写Object class中的默认的toString()方法
        return "This is a calculator class made by KE";
    }

    public int add(int num1 , int num2) {
        return num1 + num2;
    }
    // method overloading 
    public int add(int...numbers){
        return Arrays.stream(numbers).sum();
    }

    public int sub(int num1,int num2){
        return (num1 - num2);
    }

    public int multi(int num1,int num2){
        return (num1 * num2);
    }

    public double div(double num1,double num2){
        if (num2 == 0){
            throw new ArithmeticException("Division by zero");
        }
        return (num1 / num2);
    }
}
