package View;

import Input.Input;
import Manager.ManagerDirectory;
import Model.Directory;
import Validate.RegexPhone;

import java.util.List;
import java.util.Scanner;

public class DirectoryMenu {
    private ManagerDirectory managerDirectory = new ManagerDirectory();
    Scanner sc = new Scanner(System.in);

    public void showMenu() {
        int choice;
        do {
            System.out.println("===== Menu Danh Bạ =====");
            System.out.println("1.Xem Danh Sách");
            System.out.println("2.Thêm Mới");
            System.out.println("3.Cập Nhập");
            System.out.println("4.Xoá");
            System.out.println("5.Tìm Kiếm");
            System.out.println("6.Đọc Từ File");
            System.out.println("7.Ghi Vào File");
            System.out.println("0.Thoát");
            System.out.println("Vui Lòng Nhập Lựa Chọn Của Bạn");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    showAll();
                    break;
                case 2:
                    showAdd();
                    break;
                case 3:
                    showEdit();
                    break;
                case 4:
                    showDelete();
                    break;
                case 5:
                    showSreachMenu();
                    break;
                case 6:
                    writeFile();
                    break;
                case 7:
                    readFile();
                    break;
                case 0:
                    System.out.println("Thoát Thành Công!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }

    public void showAll() {
        System.out.println("===== Hiển Thị Danh Sách =====");
        List<Directory> directories = managerDirectory.getAll();
        for (Directory directory : directories) {
            System.out.println(directory);
        }
    }

    public void showAdd() {
        System.out.println("===== Thêm Mới Danh Bạ =====");
        System.out.println("Nhập Id");
        int id = Input.inputNumber();
        String name;
        do {
            System.out.println("Nhập Tên");
            name = sc.nextLine();
            if (name.isEmpty()) {
                System.out.println("Tên Không Được Để Trống.Vui Lòng Nhập Lại!");
            }
        } while (name.isEmpty());
        String sex;
        do {
            System.out.println("Nhập Giới Tính");
            sex = sc.nextLine();
            if (sex.isEmpty()) {
                System.out.println("Giới Tính Không Được Để Trống.Vui Lòng Nhập Lại!");
            }
        } while (sex.isEmpty());

        System.out.println("Nhập Số Điện Thoại");
        String phone = RegexPhone.validatePhone();
        String email;
        do {
            System.out.println("Nhập Email");
            email = sc.nextLine();
            if (email.isEmpty()) {
                System.out.println("Email Không Được Để Trống.Vui Lòng Nhập Lại!");
            }
        } while (email.isEmpty());
        String address;
        do {
            System.out.println("Nhập Địa Chỉ");
            address = sc.nextLine();
            if (address.isEmpty()) {
                System.out.println("Địa Chỉ Không Được Để Trống.Vui Lòng Nhập Lại!");
            }
        } while (address.isEmpty());
        String group;
        do {
            System.out.println("Nhập Nhóm Danh Bạ");
            group = sc.nextLine();
            if (group.isEmpty()) {
                System.out.println("Nhóm Danh Bạ Không Được Để Trống.Vui Lòng Nhập Lại!");
            }
        } while (group.isEmpty());

        System.out.println("Nhập Ngày Sinh");
        String date = sc.nextLine();
        Directory directory = new Directory(id, name, sex, phone, email, address, group, date);
        managerDirectory.add(directory);
        System.out.println("Thêm Thành Công!");
    }

    public void showDelete() {
        System.out.println("===== Menu Xoá =====");
        System.out.println("Nhập Id Danh Bạ");
        int idDelete = Input.inputNumber();
        int index = managerDirectory.findByIndexId(idDelete);
        if (index != -1) {
            System.out.println("Bạn có chắc chắn muốn xoá bài hát này không? (Y/N): ");
            String confirm = Input.inputString().toLowerCase();
            if (confirm.equals("y")) {
                managerDirectory.remove(idDelete);
                System.out.println("Xoá Thành Công!");
            } else {
                System.out.println("Đã Huỷ Xoá Bài Hát!");
            }
        } else {
            System.out.println("Không Tìm Thấy Bài Hát Để Xoá!");
        }
    }

    public void showEdit() {
        System.out.println("===== Menu Sửa Danh Bạ =====");
        System.out.println("Nhập Id Cần Sửa");
        int idEdit = Input.inputNumber();
        int index = managerDirectory.findByIndexId(idEdit);
        if (index == -1) {
            System.out.println("Id Không Tồn Tại");
            return;
        }
        String name;
        do {
            System.out.println("Nhập Tên");
            name = sc.nextLine();
            if (name.isEmpty()) {
                System.out.println("Tên Không Được Để Trống.Vui Lòng Nhập Lại!");
            }
        } while (name.isEmpty());
        String sex;
        do {
            System.out.println("Nhập Giới Tính");
            sex = sc.nextLine();
            if (sex.isEmpty()) {
                System.out.println("Giới Tính Không Được Để Trống.Vui Lòng Nhập Lại!");
            }
        } while (sex.isEmpty());

        System.out.println("Nhập Số Điện Thoại");
        String phone = RegexPhone.validatePhone();
        String email;
        do {
            System.out.println("Nhập Email");
            email = sc.nextLine();
            if (email.isEmpty()) {
                System.out.println("Email Không Được Để Trống.Vui Lòng Nhập Lại!");
            }
        } while (email.isEmpty());
        String address;
        do {
            System.out.println("Nhập Địa Chỉ");
            address = sc.nextLine();
            if (address.isEmpty()) {
                System.out.println("Địa Chỉ Không Được Để Trống.Vui Lòng Nhập Lại!");
            }
        } while (address.isEmpty());
        String group;
        do {
            System.out.println("Nhập Nhóm Danh Bạ");
            group = sc.nextLine();
            if (group.isEmpty()) {
                System.out.println("Nhóm Danh Bạ Không Được Để Trống.Vui Lòng Nhập Lại!");
            }
        } while (group.isEmpty());

        System.out.println("Nhập Ngày Sinh");
        String date = sc.nextLine();
        Directory directory = new Directory(idEdit, name, sex, phone, email, address, group, date);
        managerDirectory.update(idEdit, directory);
        System.out.println("Sửa Danh Bạ Thành Công");
    }

    public void showSreachMenu() {
        int choice;
        do {
            System.out.println("===== Tìm Kiếm Danh Bạ =====");
            System.out.println("1.Tìm Kiếm Theo Tên");
            System.out.println("2.Tìm Kiếm Theo Số Điện Thoại");
            System.out.println("0.Thoát");
            System.out.println("Nhập Sự Lựa Chọn Của Bạn");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    showSreachName();
                    break;
                case 2:
                    showSreachPhone();
                    break;
                case 0:
                    System.out.println("Thoát Thành Công!");
                    break;
                default:
                    System.out.println("Không Có Lựa Chọn Nào!");
            }
        } while (choice != 0);
    }

    public void showSreachName() {
        System.out.println("===== Tìm Kiếm Tên Theo Danh Bạ =====");
        System.out.println("Nhập Tên Cần Tìm Kiếm");
        String name = sc.nextLine();
        List<Directory> directoryList = managerDirectory.findByName(name);
        for (int i = 0; i < directoryList.size(); i++) {
            System.out.println(directoryList.get(i).toString());
        }
    }

    public void showSreachPhone() {
        System.out.println("===== Tìm Kiếm Số Điện Thoại Theo Danh Bạ =====");
        System.out.println("Nhập Số Điện Thoại Cần Tìm Kiếm");
        String phone = sc.nextLine();
        List<Directory> directoryList = managerDirectory.findByPhone(phone);
        for (int i = 0; i < directoryList.size(); i++) {
            System.out.println(directoryList.get(i).toString());
        }
    }

    private void writeFile() {
        System.out.println("====LƯU VÀO FILE====");
        if (true) {
            String config;
            do {
                System.out.println("Lựa chọn Lưu vào File sẽ thực hiện cảnh báo người dùng trước khi cập nhật file danh\n" +
                        "bạ.  Nếu người dùng chấp nhận sẽ thực hiện cập nhật lại toàn bộ nội dung file");
                config = sc.nextLine();
                if (config.isEmpty()) {
                    System.out.println("Dữ liệu bắt buộc phải nhập");
                }
            } while (config.isEmpty());

            managerDirectory.saveDirectoryToFile();
            System.out.println("Lưu danh bạ vào file thành công.");
        } else {
            System.out.println("Lưu vào file đã bị hủy.");
        }
    }

    private void readFile() {
        System.out.println("====ĐỌC TỪ FILE====");
        if (true) {
            String config;
            do {
                System.out.println("Lựa chọn Đọc từ File sẽ thực hiện cảnh báo người dùng trước khi cập nhật bộ nhớ (xóa\n" +
                        "toàn bộ danh bạ đang có trong bộ nhớ). Nếu người dùng chấp nhận sẽ thực hiện cập nhật\n" +
                        "lại  toàn bộ bộ nhớ danh bạ từ file.");
                config = sc.nextLine();
                if (config.isEmpty()) {
                    System.out.println("Dữ liệu bắt buộc phải nhập");
                }
            } while (config.isEmpty());

            managerDirectory.reloadDirectory();

            List<Directory> directories = managerDirectory.getAll();
            if (!directories.isEmpty()) {
                System.out.println("Danh sách hiện tại:");
                for (Directory directory : directories) {
                    System.out.println(directory);
                }
            } else {
                System.out.println("Danh bạ rỗng hoặc không có dữ liệu từ file.");
            }
        } else {
            System.out.println("Đọc từ file đã bị hủy.");
        }

    }
}
