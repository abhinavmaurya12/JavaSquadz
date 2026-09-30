package PracticeHome.Pattern_home;

class Pattern_home01{
    public static void main(String args[]){
        int n=5;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=5; j++){
                if((i==2 || i==3 || i==4) & (j==2 || j==3 || j==4))
                    System.out.print("  ");
                else 
                    System.out.print("*"+" ");
            }
            System.out.println();
        }

    }
}


// * * * * * 
// *       * 
// *       * 
// *       * 
// * * * * * 