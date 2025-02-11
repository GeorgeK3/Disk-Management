import java.util.*;

public class DiskComparator implements Comparator<Disk>{
    public int compare(Disk A ,Disk B) {
        return A.getFreeSpace() - B.getFreeSpace();
        
    }
}