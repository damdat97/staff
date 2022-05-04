package staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStaff {
    private static final String FILE_SANPHAM = "D:\\Staff\\src\\staff\\staff.dat";

    public void write(List<Staff> staffList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(FILE_SANPHAM);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(staffList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    public List<Staff> read() {
        List<Staff> staffList =new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(FILE_SANPHAM);
            ois = new ObjectInputStream(fis);
            staffList =(List<Staff>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return staffList;
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
