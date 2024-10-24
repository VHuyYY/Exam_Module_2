package SaveData;

import Model.Directory;

import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class ReadAndWriteDirectory {
    private File file = new File("C:\\Users\\Admin\\Documents\\Exam_Module2\\APJ-EXAM_C0624l1_VoNguyenVanHuy\\src\\DataBase\\directory.csv");

    public void WriteDirectory(List<Directory> directorys) {
        try {
            String data = "";
            for (Directory directory : directorys) {
                data += directory.getName() + "," + directory.getName() + "," + directory.getSex() + "," + directory.getPhone() + "," + directory.getEmail() + "," + directory.getAddress() + "," + directory.getGroup() + "," + directory.getGroup() + "," + directory.getDate() + "\n";
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public List<Directory> ReadDirectory() {
        List<Directory> directorys = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String sex = data[2];
                String phone = data[3];
                String email = data[4];
                String address = data[5];
                String group = data[6];
                String date = data[7];
                Directory directory = new Directory(id, name, sex, phone, email, address, group, date);
                directorys.add(directory);
            }
        } catch (IOException e) {
            System.out.println("e");
        }
        return directorys;
    }
}
