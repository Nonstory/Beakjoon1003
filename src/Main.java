import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static double getDistance(int x1, int y1, int x2, int y2) {
        int s1 = x2 - x1;
        int s2 = y2 - y1;
        return Math.sqrt(s1 * s1 + s2 * s2);
    }

    static double getLongest(double a, double b, double c) {

        if (a >= b && a >= c)
            return a;
        else if (b >= c)
            return b;
        return c;


    }

    public static void main(String[] args) {

        class Circle {
            int x;
            int y;
            int r;
        }

        class Triangle {
            double a;
            double b;
            double c;
        }
        //결국 원의 중심점과 반지름이 주어졌을때
        //두 원의 접점의 개수를 구하라가 되네

        //두 중심점사이의 거리가 두 반지름의 합보다 크다면 0, 같다면 1, 작다면 2가 된다
        int count = 0;
        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            //원 생성후 입력받기
            Circle c1 = new Circle();
            Circle c2 = new Circle();
            c1.x = sc.nextInt();
            c1.y = sc.nextInt();
            c1.r = sc.nextInt();
            c2.x = sc.nextInt();
            c2.y = sc.nextInt();
            c2.r = sc.nextInt();

            //삼각형을 만들고 result 판별
            Triangle t = new Triangle();
            t.a = c1.r;
            t.b = c2.r;
            t.c = Main.getDistance(c1.x, c1.y, c2.x, c2.y);

            double l = Main.getLongest(t.a, t.b, t.c);
            double s = t.a + t.b + t.c;
            if (t.c == 0 && c1.r == c2.r)
                result.add(-1);
            else if (s > l * 2)
                result.add(2);
            else if (s == l * 2)
                result.add(1);
            else if (s < l * 2)
                result.add(0);


        }
        for (int element : result) {
            System.out.println(element);
        }

    }

}

