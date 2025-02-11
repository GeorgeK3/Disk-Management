import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Comparison {

    static int txtFiles;

    public static void main(String[] args) throws IOException {

        System.out.println("\n\n");

        Scanner scan = new Scanner(System.in);                                      //number of txt files to create
        System.out.println("How many files do you want to create? : \t ");
        txtFiles = scan.nextInt();


        try{
            Random rand = new Random();
            for(int i=0; i<txtFiles; i++){    //ftiaxnoyme 10 arxeia gia megethoi fakelwn 100,500,1000 grammwn
                FileWriter fWriter100 = new FileWriter("data/N100/foldersD"+(i+1)+".txt");
                FileWriter fWriter500 = new FileWriter("data/N500/foldersD"+(i+1)+".txt");
                FileWriter fWriter1000 = new FileWriter("data/N1000/foldersD"+(i+1)+".txt");
                for(int j=0; j<1000; j++){ //j=Grammes Fkelwn
                    if(j<100){
                        int rand_int100 = rand.nextInt(1000000);
                        fWriter100.write(rand_int100+"\n");
                    }
                    if(j<500){
                        int rand_int500 = rand.nextInt(1000000);
                        fWriter500.write(rand_int500+"\n");
                    }
                    int rand_int1000 = rand.nextInt(1000000);
                    fWriter1000.write(rand_int1000+"\n");
                }
                fWriter100.close();
                fWriter500.close();
                fWriter1000.close();
            }
             
        }
         

        catch (IOException e) {
            System.out.print("Error Writting File!!! ");
        }
    }
}
