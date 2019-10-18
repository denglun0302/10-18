import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.List;
import java.util.Vector;

class authorComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.author.compareTo(o2.author);
    }
}
class nameComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.name.compareTo(o2.name);
    }
}
class pComparator implements Comparator<Book> {
    boolean asc;

    public pComparator(boolean asc) {
        this.asc = asc;
    }


    @Override
    public int compare(Book o1, Book o2) {
         {
            if (asc) {
                return o1.p - o2.p;
            } else {
                return o2.p - o1.p;
            }
        }
    }
}
class saleComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.sale-o2.sale;
    }
}
class commentComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.comment-o2.comment;
    }
}

public class Book implements Comparable<Book> {
    public String isbn;
    public String author;
    public String name;
    public int p;
    public int sale;
    public int comment;

    public Book(String isbn, String author, String name, int p, int sale, int comment) {
        this.isbn = isbn;
        this.author = author;
        this.name = name;
        this.p = p;
        this.sale = sale;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", p=" + p +
                ", sale=" + sale +
                ", comment=" + comment +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return isbn.compareTo(o.isbn);
    }
}


 class bookSort {

    public static void main(String[] args) {
        List<Book> a = new ArrayList<>();
        a.add(new Book("123456","小军","我和我的祖国",1,20,456));
        a.add(new Book("124456","小明","你",1,30,45));
        a.add(new Book("125456","小红","我们",1,80,457));
        a.add(new Book("126456","小峰","应物兄",1,50,452));
        a.add(new Book("127456","小蓝","我们三",1,60,458));
        a.add(new Book("128456","小紫","更狂日记",1,90,457));

        List<Book> copy;

        // 按自然顺序（ISBN）排序
        System.out.println("按 ISBN 排序：");
        copy = new ArrayList<>(a);
        sort(copy);
        System.out.println(copy);

        // 按书名排序
        System.out.println("按 书名 排序：");
        copy = new ArrayList<>(a);
        sort(copy, new nameComparator());
        System.out.println(copy);

        // 按价格排序-从小到大
        System.out.println("按 价格-从小到大 排序：");
        copy = new ArrayList<>(a);
        sort(copy, new pComparator(true));
        System.out.println(copy);

        // 按价格排序-从大到小
        System.out.println("按 价格-从大到小 排序：");
        copy = new ArrayList<>(a);
        sort(copy, new pComparator(false));
        System.out.println(copy);

        System.out.println("按 销量 排序：");
        copy = new ArrayList<>(a);
        sort(copy,new saleComparator());
        System.out.println(copy);

        System.out.println("按 评价 排序：");
        copy = new ArrayList<>(a);
        sort(copy,new commentComparator());
        System.out.println(copy);


    }

    public static void sort(List<Book> books) {
        for (int i = 1; i < books.size(); i++) {
            Book k = books.get(i);
            int j = i - 1;
            for (; j >= 0 && (books.get(j).compareTo(k)) > 0; j--) {
                books.set(j + 1, books.get(j));
            }
            books.set(j + 1, k);

        }

    }

    public static void sort(List<Book> books, Comparator<Book> cmp) {
        for (int i = 1; i < books.size(); i++) {
            Book k = books.get(i);
            int j = i - 1;
            for (; j >= 0 && cmp.compare(books.get(j), k) > 0; j--) {
                books.set(j + 1, books.get(j));
            }
            books.set(j + 1, k);

        }
    }
}



