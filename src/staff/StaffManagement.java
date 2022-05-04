package staff;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StaffManagement {
    public static Scanner scanner = new Scanner(System.in);
    public static Scanner scanner2 = new Scanner(System.in);

    private List<Staff> staffList;
    private FileStaff fileStaff;
    private static final String FULLTIME = "fulltime";
    private static final String PARTTIME = "parttime";

    public StaffManagement() throws IOException {
        fileStaff = new FileStaff();
        staffList = fileStaff.read();
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public FileStaff getFileStaff() {
        return fileStaff;
    }

    public void setFileStaff(FileStaff fileStaff) {
        this.fileStaff = fileStaff;
    }

    public Staff add() throws IOException {
        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.println("Nhap loai: ");
        String type = scanner.nextLine();
        System.out.println("Nhap trang thai: ");
        String status = scanner.nextLine();
        System.out.println("Nhap luong");
        int salary = scanner2.nextInt();
        Staff staff = new Staff(name, type, status, salary);
        staffList.add(staff);
        fileStaff.write(staffList);
        return staff;
    }

    public static void outputStaffList(Staff staff) {
        System.out.println("Ten nhan vien: " + staff.getName() +
                           ", loai: " + staff.getType() +
                           ", trang thai: " + staff.getStatus() +
                           ", luong: " + staff.getSalary());
    }

    public void showStaffList() {
        for (Staff staff : staffList) {
            System.out.println(staff.toString());
        }
    }

    public int findByName(String name) {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getName().contains(name)){
                return i;
            }
        }
        return -1;
    }

    public void editByName(String name, Staff staff) {
        staffList.set(findByName(name), staff);
        fileStaff.write(staffList);
    }

    public void removeByName(String name) {
        staffList.remove(findByName(name));
        fileStaff.write(staffList);
    }

    public void updateStaffStatus(String name) {
        System.out.println("Nhap vao loai: ");
        String type = scanner.nextLine();
        System.out.println("Nhap vao trang thai: ");
        String status = scanner.nextLine();
        System.out.println("Nhap vao luong: ");
        int salary = scanner2.nextInt();
        staffList.set(findByName(name), new Staff(name, type, status, salary));
        fileStaff.write(staffList);
    }

    public void filterFulltimeStaff() {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getType().equals(FULLTIME)) {
                StaffManagement.outputStaffList(staffList.get(i));
            }
        }
    }

    public void filterParttimeStaff() {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getType().equals(PARTTIME)) {
                StaffManagement.outputStaffList(staffList.get(i));
            }
        }
    }

    public void calSalaryFulltime() {
        int sum1 = 0;
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getType().equals(FULLTIME)) {
                sum1 += staffList.get(i).getSalary();
            }
        }
        System.out.println("Tong luong nhan vien fulltime: " + sum1);
    }

    public void calSalaryParttime() {
        int sum = 0;
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getType().equals(PARTTIME)) {
                sum += staffList.get(i).getSalary();
            }
        }
        System.out.println("Tong luong nhan vien parttime: " + sum);
    }

}
