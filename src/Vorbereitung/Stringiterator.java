package Vorbereitung;

import java.util.Scanner;

public class Stringiterator {
    private final String lesennur;
    private int position;

    public Stringiterator(String Stringiterator){
        this.lesennur = Stringiterator;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter text!");
        var input = sc.nextLine();
        Stringiterator si = new Stringiterator(input);
        char arr[] = si.lesennur.toCharArray();



        while(si.hasNext()){
            System.out.println(arr[si.position]);
            si.position++;
        }
    }

    public boolean hasNext(){
        return position < (lesennur.length());
    }

    public char next()
    {
        position++;
        return lesennur.charAt(position);
    }
}
