package ra.run;

import ra.bussiness.Book;

import java.util.Scanner;

public class BookManagement {

    public static  Book[] arrBook = new Book[100];
    public  static int indexBook = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManagement bookManagement = new BookManagement();
        boolean isExit = true;
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("6. Thay đổi thông tin sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.println("Mời chọn các chức năng từ 1-7 ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                   bookManagement.addBook(scanner,arrBook);
                    break;
                case 2:
                    bookManagement.displayInformation(arrBook);
                    break;
                case 3:
                    bookManagement.sortBook(scanner,arrBook);
                    break;
                case 4:
                    bookManagement.deleteBook(scanner);
                    break;
                case 5:
                    bookManagement.searchBook(scanner);
                    break;
                case 6:
                    bookManagement.thayDoi(scanner);
                    break;
                case 7:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập không đúng chức năng, vui lòng nhập từ 1-7");

            }
        } while (isExit);
    }

    public void addBook(Scanner scanner, Book[] arrBook) {
        System.out.println("Mời nhập số lượng(n) sách : ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sách thứ " + (i + 1) + "là : ");
            Book book = new Book();
            book.inputData(scanner, arrBook);
            arrBook[i] = book;
            indexBook++;
        }
    }

    public void displayInformation(Book[] arrBook) {
        System.out.println("Hiển thị thông tin sách : ");
        for (int i = 0; i < indexBook; i++) {
            arrBook[i].displayData();
        }
    }

    public void sortBook(Scanner scanner, Book[] arrBook) {
        for (int i = 0; i < indexBook - 1; i++) {
            for (int j = 0; j < indexBook; j++) {
                if (arrBook[i].getInterest() > arrBook[j].getInterest()) {
                    Book temp = arrBook[i];
                    arrBook[i] = arrBook[j];
                    arrBook[j] = temp;
                }
            }
        }
        System.out.println("Đã Sắp xếp sách theo lợi nhuận tăng dần");
        for (int i = 0; i < indexBook; i++) {
            arrBook[i].displayData();

        }

    }
    public void deleteBook (Scanner scanner){
        System.out.println("Mời nhập mã sách muốn xóa: ");
        int wantDelete = Integer.parseInt(scanner.nextLine());
        int checkDelete = -1;
        for (int i = 0; i < indexBook; i++) {
            if (arrBook[i].getBookId() == wantDelete) {
                checkDelete = i;
                break;
            }
        }
        if (checkDelete != -1) {
            for (int i = checkDelete; i < indexBook - 1; i++) {
                arrBook[i] = arrBook[i + 1];
            }
            arrBook[indexBook - 1] = null;
            indexBook--;
        } else {
            System.out.println("Không tìm thấy sách để xóa");
        }

    }
    public void searchBook (Scanner scanner){
        System.out.println("Nhập tên sách muốn tìm kiếm : ");
        String searchName = scanner.nextLine();
        int indexSearch = -1;
        for (int i = 0; i < indexBook; i++) {
            if (arrBook[i].getBookName().contains(searchName) || arrBook[i].getDescriptions().contains(searchName)){
                arrBook[i].displayData();
               indexSearch  = i;
               break;
            }
        }
        if (indexSearch == -1){
            System.err.println("Không tìm thấy tên để xóa  ");
        }
    }
    public void thayDoi(Scanner scanner){
        System.out.println("Mời nhập vào mã sản phẩm bạn muốn thay đổi ");
        int wantChangeId  =  Integer.parseInt(scanner.nextLine());
        int findIdCheck = -1;
        for(int i=0; i<indexBook;i++){
            if(arrBook[i].getBookId()==wantChangeId){
                arrBook[i].inputData(scanner,arrBook);
                System.out.println("Trang thái sách");
                boolean wantStatus = Boolean.getBoolean(scanner.nextLine());
                arrBook[i].setBookStatus(wantStatus);
                findIdCheck = 1;
                break;
            }
        }
        if(findIdCheck == -1){
            System.out.println("Ko tìm thấy sách nào phù hôp với id bạn vừa nhập");
        }
    }
}
