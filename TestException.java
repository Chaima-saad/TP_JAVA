class Tableau{
    static int [] T= new int[10];
    static void loadT(int n){
        System.out.println("Charg. de "+n+" entiers dans T") ;
        try {
            if (n>10) throw new IndexOutOfBoundsException();
            for (int i=0;i<n;i++)
                T[i] = i*10 ;
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("INDEXOUT");
        }

    }
    public static void showT(int n){
        System.out.println("Affich. de "+n+" entiers de T") ;
        try {
            for (int i=0;i<n;i++)
                System.out.println(T[i]);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("PB");
        }

    }
}
public class TestException{
    public static void main(String[]args){
        Tableau.loadT(15);
        Tableau.showT(15);
        System.out.println("FIN PROG") ;

    }
}