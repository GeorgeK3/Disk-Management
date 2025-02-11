
public class Disk implements Comparable<Disk>{
    protected static int id = 0;
    protected int myID;
    protected int space;
    DiskComparator comparator = new DiskComparator();
    MaxPQ<Folder> folders = new MaxPQ<>(new FolderComparator());

    Disk(){

        myID = id;
        id ++;

        space = 1000000 ; // 1.000.000 MB = 1 TB
    }

    public void addFolder(Folder f){
        folders.add(f);
        space -= f.getSpace();
    }

    public int getID(){
        return myID;
    }

    public int getFreeSpace() {
        return space;
    }
  
    public int compareTo(Disk B){
        int bigger = this.getFreeSpace() - B.getFreeSpace();
        if (bigger>0){
            return 1;
        }else if(bigger<0){
            return -1;
        }else{
            return 0;
        }
    }

    public String toString(){
        String s = "id: " + this.getID() + " free space: " + this.getFreeSpace() + " : " ;
        while (folders.peek() != null ){
            s += folders.getMax().getSpace() + " ";
        }
        return s;
    }
}