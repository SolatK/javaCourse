package tasks.homework6;

import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.sqrt;

public class Geometry {

    public static void runTest() {
        Figure[] figures = new Figure[5];

        for (int i = 0; i < figures.length; i++) {
            switch ((int) (Math.random() * 3)) {
                case (0):
                    figures[i] = Circle.getRandom();
                    break;
                case (1):
                    figures[i] = Rectangle.getRandom();
                    break;
                case (2):
                    figures[i] = Triangle.getRandom();
                    break;
            }
        }

        System.out.printf("Сумма периметра фигур: %1$f\n", Arrays.stream(figures).mapToDouble(Figure::getPerimeter).sum());
    }

    public static abstract class Figure {
        public abstract float getPerimeter();

        public abstract float getArea();
    }

    public static class Triangle extends Figure {
        float sideA;
        float sideB;
        float sideC;

        public static Triangle getRandom() {
            float sideA;
            float sideB;
            float sideC;
            do {
                sideA = (float) Math.random() * 10;
                sideB = (float) Math.random() * 10;
                sideC = (float) Math.random() * 10;
            } while (!testSides(sideA, sideB, sideC));
            return new Triangle(sideA, sideB, sideC);

        }

        public Triangle(float sideA, float sideB, float sideC) {
            if (!testSides(sideA, sideB, sideC)) {
                System.out.println("Треугольник с такими ребрами не возможен");
                System.exit(0);
            }
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            System.out.printf(
                    "Создан новый треугольник со сторонами A = %.2f, B = %.2f, C = %.2f, периметром = %.2f, площадью = %.2f.\n",
                    sideA,
                    sideB,
                    sideC,
                    getPerimeter(),
                    getArea()
                    );
        }

        public static boolean testSides(float sideA, float sideB, float sideC) {
            float max = max(sideA, max(sideB, sideC));
            return ((max < (sideA + sideB + sideC) - max) & sideA > 0 & sideB > 0 & sideC > 0);
        }

        @Override
        public float getPerimeter() {
            return sideA + sideB + sideC;
        }

        @Override
        public float getArea() {
            float halfPerimeter = getPerimeter() / 2;
            return (float) sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
        }
    }

    public static class Rectangle extends Figure {

        float sideA;
        float sideB;

        public static Rectangle getRandom() {
            float sideA;
            float sideB;
            do {
                sideA = (float) Math.random() * 10;
                sideB = (float) Math.random() * 10;
            } while (!testSides(sideA, sideB));
            return new Rectangle(sideA, sideB);

        }

        public Rectangle(float sideA, float sideB) {
            this.sideA = sideA;
            this.sideB = sideB;
            System.out.printf(
                    "Создан новый прямоугольник со сторонами A = %.2f, B = %.2f, периметром = %.2f, площадью = %.2f.\n",
                    sideA,
                    sideB,
                    getPerimeter(),
                    getArea()
            );
        }

        public static boolean testSides(float sideA, float sideB) {
            return (sideA > 0 & sideB > 0);
        }

        @Override
        public float getPerimeter() {
            return sideA * 2 + sideB * 2;
        }

        @Override
        public float getArea() {
            return sideA * sideB;
        }
    }

    public static class Circle extends Figure {

        float radius;

        public static Circle getRandom() {
            float radius;
            do {
                radius = (float) Math.random() * 10;
            } while (!testSides(radius));
            return new Circle(radius);

        }

        public Circle(float radius) {
            this.radius = radius;
            System.out.printf(
                    "Создан новый круг с радиусом R = %.2f, окружностью = %.2f, площадью = %.2f.\n",
                    radius,
                    getPerimeter(),
                    getArea()
            );
        }

        public static boolean testSides(float radius) {
            return radius > 0;
        }


        @Override
        public float getPerimeter() {
            return (float) Math.PI * radius * 2;
        }

        @Override
        public float getArea() {
            return (float) Math.PI * radius * radius;
        }
    }
}
