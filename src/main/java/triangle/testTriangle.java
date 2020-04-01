package triangle;

public class testTriangle {
    public static void main(String[] args) {
        Judge judge = new Judge();
        System.out.println(judge.judge(1, 1, 1));
        System.out.println(judge.judge(2, 1, 2));
        System.out.println(judge.judge(2, 2, 1));
        System.out.println(judge.judge(2, 1, 2));
        System.out.println(judge.judge(3, 4, 5));
        System.out.println(judge.judge(5, 4, 3));
        System.out.println(judge.judge(3, 5, 4));
        System.out.println(judge.judge(3, 2, 1));
        System.out.println(judge.judge(-3, 4, 5));
    }
}
