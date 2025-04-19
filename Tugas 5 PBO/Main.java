import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-DATA MAHASISWA-");
        System.out.println("Masukan nama mahasiswa:");
        String namaMhs = sc.nextLine();
        System.out.println("Masukan alamat mahasiwa:");
        String alamatMhs = sc.nextLine();
        Student mhs = new Student(namaMhs, alamatMhs);

        System.out.print("Berapa mata kuliah yang dimabil?: ");
        int jumlahMK = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < jumlahMK; i++) {
            System.out.println("Nama mata kuliah ke-" + (i + 1) + ": ");
            String mk = sc.nextLine();
            System.out.print("Nilai: ");
            int nilai = sc.nextInt();
            sc.nextLine();
            mhs.addCourseGrade(mk, nilai);
        }

        System.out.println("\n-DATA DOSEN-");
        System.out.println("\nMasukan nama dosen:");
        String namaDosen = sc.nextLine();
        System.out.println("Masukan alamat dosen:");
        String alamatDosen = sc.nextLine();
        Teacher dosen = new Teacher(namaDosen, alamatDosen);

        System.out.print("Berapa mata kuliah yang diajar?: ");
        int jumlahAmpu = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < jumlahAmpu; i++) {
            System.out.print("Mata kuliah ke-" + (i + 1) + ": ");
            String matkul = sc.nextLine();
            if (!dosen.addCourse(matkul)) {
                System.out.println("Mata Kuliah sudah ada, tidak ditambahkan.");
            }
        }

        System.out.println(dosen);
        System.out.print("\nMasukkan nama mata kuliah yang ingin dihapus dari dosen: ");
        String hapusMk = sc.nextLine();
        if (dosen.removeCourse(hapusMk)) {
            System.out.println("Mata kuliah berhasil dihapus.");
        } else {
            System.out.println("Mata kuliah tidak ditemukan.");
        }
        System.out.println("\n===============DATA MAHASISWA==================");
        mhs.printGrades();
        System.out.println("Rata-rata: " + mhs.getAverageGrade());
        System.out.println(mhs);
        
        System.out.println("\n===============DATA DOSEN==================");
        System.out.println(dosen);
        dosen.printCourses();
        sc.close();
    }
}