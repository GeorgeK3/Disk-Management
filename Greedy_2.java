import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Greedy_2 {
    public static void main(String[] args) throws IOException{
        
        String[] args1 = {};        //Creates new Random files
        Comparison.main(args1);
        double txtFiles = Comparison.txtFiles;

        System.out.println("\n\n-----------------------------------------------------------\n\n");

        int N=100;

        for (int n=0;n<3;n++){

            if (n==1){N=500;}
            if (n==2){N=1000;}
            int sumDisks1 = 0;
            int sumDisks2 = 0;

            for (int j=0;j<txtFiles;j++){

                int numFolders = 0;
                int space;
                
                BufferedReader reader = null;
                String line ;
                MaxPQ<Disk> disks1 = new MaxPQ<Disk>(new DiskComparator());     //The Disks array for the 1st Algorithm   
                MaxPQ<Disk> disks2 = new MaxPQ<Disk>(new DiskComparator());     //The Disks array for the 2nd Algorithm   
                String filename = "data/N"+N+"/foldersD"+(j+1)+".txt";

                //Reads the .txt file
                try{
                    Path file = Paths.get(filename);                    //Counts the number of files 
                    long count = Files.lines(file).count();

                    Folder[] folderArray = new Folder[(int)count];      //The Folders array

                    reader = new BufferedReader(new FileReader(new File(filename)));
                    line = reader.readLine();

                    while(line != null){                                    //Reads the space of each file and creates the array

                        space = Integer.parseInt(line) ;

                        if (space<0 || space> 1000000){
                            throw new NoSuchElementException();
                        }
                        Folder f = new Folder(space);
                        folderArray[numFolders++] = f;

                        line = reader.readLine();
                    }

                    
                    for (int i = 0 ; i < count ; i++){              //The 1st Algorithm
                        if (disks1.peek() == null){

                            Disk d = new Disk();
                            d.addFolder(folderArray[i]);
                            disks1.add(d);
                            sumDisks1 ++;

                        } else if (disks1.peek().getFreeSpace() >= folderArray[i].getSpace()){

                            Disk d = disks1.getMax();
                            d.addFolder(folderArray[i]);
                            disks1.add(d);

                        } else {

                            Disk d = new Disk();
                            d.addFolder(folderArray[i]);
                            disks1.add(d);
                            sumDisks1 ++;

                        }
                        
                    }

                    Sort<Folder> s = new Sort<Folder>(new FolderComparator());  //Sorting the folderArray
                    s.quickSort(folderArray, 0, numFolders-1);


                    for (int i = 0 ; i < count ; i++){              //The 2nd Algorithm
                        if (disks2.peek() == null){

                            Disk d = new Disk();
                            d.addFolder(folderArray[i]);
                            disks2.add(d);
                            sumDisks2 ++;

                        } else if (disks2.peek().getFreeSpace() >= folderArray[i].getSpace()){

                            Disk d = disks2.getMax();
                            d.addFolder(folderArray[i]);
                            disks2.add(d);

                        } else {

                            Disk d = new Disk();
                            d.addFolder(folderArray[i]);
                            disks2.add(d);
                            sumDisks2 ++;

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

            System.out.println("For " + N + " folders :");
            System.out.println("Average number of disks Algorithm 1 used = " + (sumDisks1/txtFiles));
            System.out.println("Average number of disks Algorithm 2 used = " + (sumDisks2/txtFiles));
            System.out.println("\n\n-----------------------------------------------------------\n\n");

        }
        
    }
  
}