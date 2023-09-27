package ra.bussiness;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Book {
    private static int count = 0;
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
        this.bookId = count++;
    }

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner,Book[] arrBook){
        /** bookName **/
        boolean isExit = false;
        while(!isExit){
            System.out.println("Hãy nhập vào tên sách (Không được để trống)");
            String bookNameTest = scanner.nextLine();
            if(bookNameTest.isEmpty()){
                System.out.println("tên sách (Không được để trống)");
            }else {
                this.bookName = bookNameTest;
                isExit = true;
            }
        }
        /** author **/
        System.out.println("Mời nhập tác giả(String) : ");
        do {
            this.author = scanner.nextLine();
            if (!this.author.isEmpty()){
                boolean checkAuthor = true;
                for (int i = 0; i < arrBook.length; i++) {
                    if(arrBook[i] != null && arrBook[i].getAuthor().equals(this.author)){
                        checkAuthor = false;
                        break;
                    }
                }
                if (checkAuthor){
                    isExit = false;
                }else
                    System.err.println("Tác giả đã tồn tại, vui lòng nhập lại");

            }else {
                System.err.println("Tác giả không đc để trống, vui lòng nhập lại");
                isExit = true;
            }
        }while (isExit);
        /** descriptions **/
        System.out.println("Mời nhập mô tả sách(String) : ");
        do {
            this.descriptions = scanner.nextLine();
            if (this.descriptions.length() >= 10 ){
                isExit = false;
                break;
            }else
                System.err.println("Mô tả không được để trống và phải có ít nhất 10 ky tự, Vui lòng nhập lại");
                isExit =true;
        }while (isExit);
        /** importPrice **/
        System.out.println("Mời nhập giá nhập(double) : ");

       do {
           this.importPrice = Double.parseDouble(scanner.nextLine());
           if (this.importPrice > 0 ){
               break;
           }else {
               System.err.println("Giá nhập phải lớn hơn không,Vui lòng nhập lại:");
               isExit = true;
           }
       }while (isExit);
       /** exportPrice **/
        System.out.println("Mời nhập giá xuất(double) : ");
        do {
            this.exportPrice = Double.parseDouble(scanner.nextLine());
            if( this.exportPrice * 1.2>= this.importPrice){
                break;
            }else {
                System.err.println("Giá xuất phải lớn hơn 1.2 lần giá nhập, Vui lòng nhập lại");
                isExit =true;
            }
        }while (isExit);
        /** bookStatus **/
        System.out.println("Mời nhập trang thái sách(boolean) : ");
        String statusString = scanner.nextLine();
       do {
           if (statusString.equals("true") || statusString.equals("false")){
               this.bookStatus = Boolean.parseBoolean(statusString);
               break;
           }else {
               System.err.println("Vui lòng nhập true or false,Vui lòng nhập lại");
           }
       }while (isExit);
    }
    public double callInterest(){
        double interest = exportPrice - importPrice;
        return interest;
    }
    public void displayData(){
        System.out.println("Mã sách " + bookId);
        System.out.println(" Tên sách " + bookName);
        System.out.println("Tác giả sách " + author);
        System.out.println("Mô tả sách " + author);
        System.out.println("Giá nhập sách " + importPrice);
        System.out.println("Giá xuất sách " + exportPrice);
        System.out.println("Lợi nhuận sách " + interest);
        System.out.println("Trạng thái sách " + (bookStatus?"Có sách" : "không sách"));
    }
}
