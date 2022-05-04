package staff;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        StaffManagement staffManagement = new StaffManagement();

        while(true) {
            showMenu();
            int choice = -1;
            while (choice == -1) {
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Chi duoc nhap vao so");
                } finally {
                    scanner.nextLine();
                }
            }
            switch (choice) {
                case 0:
                    staffManagement.showStaffList();
                    break;
                case 1:
                    staffManagement.add();
                    break;
                case 2:
                    System.out.println("Nhap vao ten nhan vien can tim: ");
                    String name = scanner.nextLine();
                    int pos = staffManagement.findByName(name);
                    if (pos == -1) {
                        System.out.println("Khong co nhan vien nay!");
                    } else {
                        StaffManagement.outputStaffList(staffManagement.getStaffList().get(pos));
                    }
                    break;
                case 3:
                    staffManagement.filterFulltimeStaff();
                    break;
                case 4:
                    staffManagement.filterParttimeStaff();
                    break;
                case 5:
                    System.out.println("Nhap vao ten can sua: ");
                    String nameEdit = scanner.nextLine();
                    int isNotExisted = staffManagement.findByName(nameEdit);
                    if (isNotExisted == -1) {
                        System.out.println("Khong co nhan vien nay!");
                    } else {
                        System.out.println("Nhap vao loai: ");
                        String type = scanner.nextLine();
                        System.out.println("Nhap vao trang thai: ");
                        String status = scanner.nextLine();
                        System.out.println("Nhap vao luong: ");
                        int salary = scanner1.nextInt();
                        staffManagement.editByName(nameEdit, new Staff(nameEdit, type, status, salary));
                    }
                    break;
                case 6:
                    System.out.println("Nhap vao ten can sua trang thai: ");
                    String nameEdit2 = scanner.nextLine();
                    int isNotExisted2 = staffManagement.findByName(nameEdit2);
                    if (isNotExisted2 == -1) {
                        System.out.println("Khong co nhan vien nay");
                    } else {
                        staffManagement.updateStaffStatus(nameEdit2);
                    }
                    break;
                case 7:
                    staffManagement.calSalaryFulltime();
                    break;
                case 8:
                    staffManagement.calSalaryParttime();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Chi duoc nhap tu 1-9");
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("-----Menu-----");
        System.out.println("0. Hien thi tat ca nhan vien");
        System.out.println("1. Them");
        System.out.println("2. Tim kiem");
        System.out.println("3. In ra danh sach nhan vien Fulltime");
        System.out.println("4. In ra danh sach nhan vien Parttime");
        System.out.println("5. Sua");
        System.out.println("6. Doi trang thai");
        System.out.println("7. Tinh tong luong nhan vien Fulltime");
        System.out.println("8. Tinh tong luong nhan vien Parttime");
        System.out.println("9. Thoat");
        System.out.println("====Chon di====");
    }
}
