package OopCourse.ModuleFour;

import java.util.Comparator;
import java.util.Scanner;
import static java.util.Arrays.sort;


public class TaskFourStepFour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        В классе Main создайте массив комментариев, данные вводятся с консоли.
//        В первой строке вводится количество элементов массива.
//        В последующих строках  - сами комментарии. Каждый комментарий на отдельной строке.
//        Элементы отделяются точкой с запятой.
        scan.useDelimiter(";|\n");
        int arraySize = scan.nextInt();
        Comment[] gruppa = new Comment[arraySize];
        for(int i = 0; i < arraySize; i++){
            gruppa[i] = new Comment(scan.next(), scan.next(), scan.nextInt());
        }
        sort(gruppa);
        for (Comment comment : gruppa) {
            System.out.println(comment);
        }
        System.out.println();
        CommentComparator comp = new CommentComparator();
        sort(gruppa, comp);
        for (Comment comment : gruppa) {
            System.out.println(comment);
        }
    }
}

class Comment implements Comparable<Comment> {
    String author;
    String commentText;
    int likes;

    Comment(String author, String commentText, int likes) {
        this.author = author;
        this.commentText = commentText;
        this.likes = likes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return author + "#" + commentText + "#" + likes;
    }

    @Override
    public int compareTo(Comment o) {
        if(likes - o.getLikes() < 0) return 1;
        if(likes - o.getLikes() > 0) return -1;
        return 0;
    }
}

class CommentComparator implements Comparator<Comment> {
    @Override
    public int compare(Comment o1, Comment o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}
