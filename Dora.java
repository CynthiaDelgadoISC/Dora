import java.util.Scanner;

public class Dora {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n = 0;
        int m = 0;
        do{
            System.out.println("Ingresa los renglones y columnas (con espacio): "); 
            String aux=entrada.nextLine();
            String[] parts = aux.split(" ");
            n=Integer.parseInt(parts[0]);
            m=Integer.parseInt(parts[1]);
            if (!(n>=3 && n<=51 && m>=3 && m<=51)){
                System.out.println("Ingresa numeros entre (3<= renglones <= 51) y (3<= columnas <= 51)");
            }
        }while(!(n>=3 && n<=51 && m>=3 && m<=51));
            String[] matriz= new String[n];
            System.out.println("Ingresa la matriz: ");
            for(int i=0; i<n; i++){
                do{
                    System.out.println("Ingresa la fila "+i+":");
                    matriz[i]=entrada.nextLine();
                    if (matriz[i].length()!=m)
                    System.out.println("La fila debe ser de la misma longitud M");
                }while(matriz[i].length()!=m);
            }
            
            int x=0;
            int y=0;
            for (int i=0; i<n;i++){
                for (int j=0; j<m;j++){
                    if(matriz[i].charAt(j)=='#'){
                        x=i;
                        y=j;
                        break;
                    }
                }
            }
            
            camino(matriz,n,m,x,y);
            
            for (int i=0; i<n ; i++){
                System.out.println(matriz[i]);
            }
        
    }
    static void camino(String[] matriz,int n, int m, int x,int y){
        char[] tempCharArray = matriz[x].toCharArray();
        tempCharArray[y] = '#';
        matriz[x]=String.valueOf(tempCharArray);
        if (y-1>=0)
            if (matriz[x].charAt(y-1)=='.')
                camino(matriz,n,m,x,y-1);
        if (x+1<n)
            if (matriz[x+1].charAt(y)=='.')
                camino(matriz,n,m,x+1,y);
        if (y+1<m)
            if (matriz[x].charAt(y+1)=='.')
                camino(matriz,n,m,x,y+1);
        if (x-1>=0)
            if (matriz[x-1].charAt(y)=='.')
                camino(matriz,n,m,x-1,y);
        return;
    }
}