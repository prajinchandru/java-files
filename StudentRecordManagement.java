import java.io.*;
import java.util.*;
class Student {
    String rollNo;
    String name;
    String dept;
    Student(String rollNo, String name, String dept) {
        this.rollNo = rollNo;
        this.name = name;
        this.dept = dept;
    }
    @Override
    public String toString() {
        return rollNo + "," + name + "," + dept;
    }
}
public class StudentRecordManagement {
     static final String FILE_NAME = "students.txt";
     public static void createFile() {
        try {
            File file = new File(FILE_NAME);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error creating file.");
        }
    }
     public static void writeRecord(Student s) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bw.write(s.toString());
            bw.newLine();
            System.out.println("Record written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing record.");
        }
    }

    // Append student record
    public static void appendRecord(Student s) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(s.toString());
            bw.newLine();
            System.out.println("Record appended successfully.");
        } catch (IOException e) {
            System.out.println("Error appending record.");
        }
    }

    // Read all student records
    public static void readRecords() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Student Records ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading records.");
        }
    }

    // Update student record by roll number
    public static void updateRecord(String rollNo, Student newData) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean updated = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(rollNo)) {
                    bw.write(newData.toString());
                    updated = true;
                } else {
                    bw.write(line);
                }
                bw.newLine();
            }

            if (updated) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("Record not found.");
            }
        } catch (IOException e) {
            System.out.println("Error updating record.");
        }

        // Replace old file with updated file
        if (inputFile.delete()) {
            tempFile.renameTo(inputFile);
        }
    }

    public static void main(String[] args) {
        createFile();

        Student s1 = new Student("101", "Ashif", "CSE");
        Student s2 = new Student("102", "Priya", "ECE");
        Student s3 = new Student("103", "Rahul", "MECH");

        writeRecord(s1); // overwrite with first record
        appendRecord(s2); // add second record
        appendRecord(s3); // add third record

        readRecords(); // display records

        // Update student record
        Student updated = new Student("102", "Priya", "IT");
        updateRecord("102", updated);

        readRecords(); // display after update
    }
}
