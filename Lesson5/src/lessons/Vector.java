package lessons;

import java.util.Random;

public class Vector {

    private int xOrigin;
    private int yOrigin;
    private int zOrigin;
    private int xEnd;
    private int yEnd;
    private int zEnd;

    Vector(int x, int y, int z, int x1, int y1, int z1) {

        this.xOrigin = x;
        this.yOrigin = y;
        this.zOrigin = z;
        this.xEnd = x1;
        this.yEnd = y1;
        this.zEnd = z1;
    }

    public int getxOrigin() {
        return xOrigin;
    }

    public int getyOrigin() {
        return yOrigin;
    }

    public int getzOrigin() {
        return zOrigin;
    }

    public int getxEnd() {
        return xEnd;
    }

    public int getyEnd() {
        return yEnd;
    }

    public int getzEnd() {
        return zEnd;
    }

    public static double getLength(Vector vector) {
        return Math.sqrt(Math.pow((vector.xEnd - vector.xOrigin), 2)
                + Math.pow((vector.yEnd - vector.yOrigin), 2)
                + Math.pow((vector.zEnd - vector.zOrigin), 2));
    }

    public static double scalar(Vector vector1, Vector vector2) {
        if ((vector1.xOrigin != vector2.xOrigin) && (vector1.xOrigin != vector2.xOrigin) && (vector1.zOrigin != vector2.zOrigin)) {
            return 0;
        }
        return vector1.xEnd * vector2.xEnd + vector1.yEnd * vector2.yEnd + vector1.zEnd * vector2.zEnd;
    }

    public static Vector vector(Vector vector1, Vector vector2) {
        if ((vector1.xOrigin != vector2.xOrigin) && (vector1.xOrigin != vector2.xOrigin) && (vector1.zOrigin != vector2.zOrigin)) {
            return null;
        }
        return new Vector(vector1.xOrigin,
                vector1.yOrigin,
                vector1.zOrigin,
                (vector1.yEnd * vector2.zEnd - vector1.zEnd * vector2.yEnd),
                (vector1.zEnd * vector2.xEnd - vector1.xEnd * vector2.zEnd),
                (vector1.xEnd * vector2.yEnd - vector1.yEnd * vector2.xEnd));
    }

    public static double angle(Vector vector1, Vector vector2) {
        if ((vector1.xOrigin != vector2.xOrigin) && (vector1.xOrigin != vector2.xOrigin) && (vector1.zOrigin != vector2.zOrigin)) {
            return -1;
        }

        return scalar(vector1, vector2) / (getLength(vector1) * getLength(vector2));
    }

    public static Vector summ(Vector vector1, Vector vector2) {
        if ((vector1.xOrigin != vector2.xOrigin) && (vector1.xOrigin != vector2.xOrigin) && (vector1.zOrigin != vector2.zOrigin)) {
            return null;
        }
        return new Vector(vector1.xOrigin,
                vector1.yOrigin,
                vector1.zOrigin,
                (vector1.xEnd + vector2.xEnd),
                (vector1.yEnd + vector2.yEnd),
                (vector1.zEnd + vector2.zEnd));
    }

    public static Vector diff(Vector vector1, Vector vector2) {
        if ((vector1.xOrigin != vector2.xOrigin) && (vector1.xOrigin != vector2.xOrigin) && (vector1.zOrigin != vector2.zOrigin)) {
            return null;
        }
        return new Vector(vector1.xOrigin,
                vector1.yOrigin,
                vector1.zOrigin,
                (vector1.xEnd - vector2.xEnd),
                (vector1.yEnd - vector2.yEnd),
                (vector1.zEnd - vector2.zEnd));
    }

    public static Vector[] vectors(int n) {
        Vector[] vectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int randomXorigin = random.nextInt(10);
            int randomYorigin = random.nextInt(10);
            int randomZorigin = random.nextInt(10);
            int randomXend = random.nextInt(10);
            int randomYend = random.nextInt(10);
            int randomZend = random.nextInt(10);
            Vector vector = new Vector(randomXorigin,randomYorigin,randomZorigin,randomXend,randomYend,randomZend);
        }
        return vectors;
    }
}
