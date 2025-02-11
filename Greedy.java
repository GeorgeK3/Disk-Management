import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Greedy {
    public static void main(String[] args){
        
        double sumFolders = 0;
        int numFolders = 0;
        int sumDisks = 0;
        int space;
        
        BufferedReader reader = null;
        String line ;
        MaxPQ<Disk> disks = new MaxPQ<Disk>(new DiskComparator());
        String filename = args[0];

        //Reads the .txt file
        try{
            Path file = Paths.get(args[0]);
            long count = Files.lines(file).count();
            Folder[] folderArray = new Folder[(int)count];

            reader = new BufferedReader(new FileReader(new File(filename)));
            line = reader.readLine();

            while(line != null){

                space = Integer.parseInt(line) ;

                if (space<0 || space> 1000000){
                    throw new NoSuchElementException();
                }
                Folder f = new Folder(space);
                sumFolders += f.getSpace();
                folderArray[numFolders++] = f;

                line = reader.readLine();
            }
            
            for (int i = 0 ; i < count ; i++){
                if (disks.peek() == null){

                    Disk d = new Disk();
                    d.addFolder(folderArray[i]);
                    disks.add(d);
                    sumDisks ++;

                } else if (disks.peek().getFreeSpace() >= folderArray[i].getSpace()){

                    Disk d = disks.getMax();
                    d.addFolder(folderArray[i]);
                    disks.add(d);

                } else {

                    Disk d = new Disk();
                    d.addFolder(folderArray[i]);
                    disks.add(d);
                    sumDisks ++;

                }
            }
            
            System.out.println("Sum of all folders = " + sumFolders*0.000001d + " TB"); // sumFolders*0.000001d :: MB to TB
            System.out.println("Total number of disks used = " + sumDisks );

            if (numFolders < 100){
                while (disks.peek() != null){
                    System.out.println(disks.getMax());
                }
            }
            
        }//try
        catch (IOException e){  //For errors while reading the file
            System.err.println("Error reading File!!!");
        }
        catch (NoSuchElementException e){   //For false information on the .txt file
            System.err.println("False information detected on the .txt file!!!");
        }
        
    }
  
}
