package fw;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Folders {
    private List<String> storedFolders = null;

    public Folders(List<String> folders){
        this.storedFolders = new ArrayList<>(folders);
    }

    public Folders withAdded(String folder) {
        Folders newList = new Folders(storedFolders);
        newList.storedFolders.add(folder);
        return newList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Folders folders = (Folders) o;
        return Objects.equals(storedFolders, folders.storedFolders);
    }

    @Override
    public int hashCode() {

        return Objects.hash(storedFolders);
    }

    @Override
    public String toString() {
        return "Folders{" +
                "storedFolders=" + storedFolders +
                '}';
    }
}
