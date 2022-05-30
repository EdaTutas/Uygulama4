import java.util.Scanner;

public class Main {

    private static Kart[][] kartlar =new Kart[4][4];


    public static void main(String[] args) {



        kartlar [0][0] =new Kart ('E');
        kartlar [0][1] =new Kart ('D');
        kartlar [0][2] =new Kart ('A');
        kartlar [0][3] =new Kart ('+');
        kartlar [1][0] =new Kart ('-');
        kartlar [1][1] =new Kart ('!');
        kartlar [1][2] =new Kart ('?');
        kartlar [1][3] =new Kart ('/');
        kartlar [2][0] =new Kart ('A');
        kartlar [2][1] =new Kart ('/');
        kartlar [2][2] =new Kart ('!');
        kartlar [2][3] =new Kart ('E');
        kartlar [3][0] =new Kart ('-');
        kartlar [3][1] =new Kart ('?');
        kartlar [3][2] =new Kart ('D');
        kartlar [3][3] =new Kart ('+');

        //oyun();
        while(oyunBittiMi()==false){
            oyun();
            tahminEt();
        }
    }


    public static void tahminEt(){

        Scanner scanner =new Scanner(System.in);

        System.out.print("Birinci Tahmin (i ve j degerlerini birer bosluk birakarak girin..) : ");
        int i1= scanner.nextInt();
        int j1=scanner.nextInt();

        kartlar[i1][j1].setTahmin(true);
        oyun();

        System.out.print("İkinci Tahmin (i ve j degerlerini birer bosluk birakarak girin..) : ");
        int i2= scanner.nextInt();
        int j2=scanner.nextInt();

        if(kartlar[i1][j1].getDeger()==kartlar[i2][j2].getDeger()){
            kartlar[i2][j2].setTahmin(true);
            System.out.println("Dogru Tahmin Ettiniz!");

        }

        else {
            System.out.println("Yanlis Tahmin Ettiniz!");
            kartlar[i1][j1].setTahmin(false);
        }


    }
    public static boolean oyunBittiMi(){

        for(int i=0; i<4 ; i++){
            for(int j=0 ; j<4; j++){
                if(kartlar[i][j].isTahmin()==false){
                    return false;

                }

            }
        }
        return true;
    }

    public static void oyun(){

        for (int i=0; i<4 ; i++){
            System.out.println("___________________");

            for (int j = 0; j<4 ; j++ ){

                if (kartlar[i][j].isTahmin()){
                    System.out.print(" [" + kartlar[i][j].getDeger() + "] ");
                }
                else{

                    System.out.print(" [ ] ");

                }
            }

            System.out.println("");

        }
        System.out.println("___________________");

    }
}