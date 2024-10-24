package Manager;

import Model.Directory;
import SaveData.ReadAndWriteDirectory;


import java.util.ArrayList;
import java.util.List;

public class ManagerDirectory implements Imanager<Directory> {
    List<Directory> DirectoryList;
    ReadAndWriteDirectory readAndWriteDirectory = new ReadAndWriteDirectory();

    public ManagerDirectory() {
        DirectoryList = readAndWriteDirectory.ReadDirectory();
    }

    @Override
    public void add(Directory directory) {
        DirectoryList.add(directory);
        readAndWriteDirectory.WriteDirectory(DirectoryList);
    }

    @Override
    public void remove(int id) {
        int index = findByIndexId(id);
        DirectoryList.remove(index);
        readAndWriteDirectory.WriteDirectory(DirectoryList);

    }

    @Override
    public void update(int id, Directory directory) {
        int index =findByIndexId(id);
        DirectoryList.set(index, directory);
        readAndWriteDirectory.WriteDirectory(DirectoryList);
    }

    @Override
    public List<Directory> getAll() {
        return this.DirectoryList;
    }

    @Override
    public int findByIndexId(int id) {
        for (int i = 0; i < this.DirectoryList.size(); i++) {
            if (this.DirectoryList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public List<Directory> findByName(String name) {
        List<Directory> result = new ArrayList<>();
        for (Directory directory : DirectoryList) {
            if (directory.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(directory);
            }
        }
        return result;
    }

    public List<Directory> findByPhone(String phone) {
        List<Directory> result1 = new ArrayList<>();
        for (Directory directory : DirectoryList) {
            if (directory.getPhone().toLowerCase().contains(phone.toLowerCase())) {
                result1.add(directory);
            }
        }
        return result1;
    }

    public void saveDirectoryToFile() {
        readAndWriteDirectory.WriteDirectory(DirectoryList);
    }

    public void reloadDirectory() {
        this.DirectoryList = readAndWriteDirectory.ReadDirectory();
    }
}
