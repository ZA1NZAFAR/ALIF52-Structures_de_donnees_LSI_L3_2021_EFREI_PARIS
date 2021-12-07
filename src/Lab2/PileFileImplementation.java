package Lab2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PileFileImplementation {
    private static final String FILE_NAME = "stack";
    private int last;

    public PileFileImplementation() {
        try {
            new BufferedWriter(new FileWriter(FILE_NAME));
        } catch (IOException ignore) {
        }
        this.last = -1;
    }

    public void push(int n) {
        last++;
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
            writer.write(n + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int top() {
        try {
            return Integer.parseInt(Files.readAllLines(Paths.get(FILE_NAME)).get(last));
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void pop() {
        byte b;
        try {
            RandomAccessFile f = new RandomAccessFile(FILE_NAME, "rw");
            long length = f.length() - 1;
            do {
                length -= 1;
                f.seek(length);
                b = f.readByte();
            } while (b != 10);
            f.setLength(length + 1);
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        last--;
    }

    @Override
    public String toString() {
        String res = "";
        try {
            String line;
            BufferedReader in = new BufferedReader(new FileReader(FILE_NAME));
            while ((line = in.readLine()) != null) {
                res += line + "\n";
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
