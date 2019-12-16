package com.yc13;

public class Calc extends Compf {
    private StackInt s;
    private static int char2int(char c)
    {
        return (int)c - (int)'0';
    }
    protected int symOther(char c) {
        if (c < '0' || c > '9') {
            System.out.println("Íåäîïóñòèìûé ñèìâîë: " + c);
            System.exit(0);
        }
        return SYM_OTHER;
    }
    protected void nextOper(char c) {
        int second = s.pop();
        int first = s.pop();
        switch (c) {
            case '+':
                s.push(first + second); break;
            case '-':
                s.push(first - second); break;
            case '*':
                s.push(first * second); break;
            case '/':
                s.push(first / second); break;
        }
    }
    /* protected void nextOther(char c) {
  s.push(char2int(c));
     }*/
    protected void nextOther(char c) {
        if (num) {
            int number = ((s.pop()) * 10) + char2int(c);
            s.push(number);
            num= true;
        } else {
            s.push(char2int(c));
            num = true;
        }
    }
    public Calc() {
        s = new StackInt();
    }
    /* public final void compile(char[] str) {
         super.compile(str);
         System.out.println("" + s.top());
     }*/
    public final void compile(char[] str)
    {
        super.compile(str);
        System.out.println("" + s.top());
        num = false;
    }
}