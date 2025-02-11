import java.util.*;

public class FolderComparator implements Comparator<Folder>{
    public int compare(Folder A ,Folder B) {
        return A.getSpace() - B.getSpace();
    }
}