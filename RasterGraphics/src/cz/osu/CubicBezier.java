package cz.osu;

import java.util.ArrayList;

public class CubicBezier {
    public Point2D p1;
    public Point2D p2;
    public Point2D p3;
    public Point2D p4;

    private double qx0;
    private double qx1;
    private double qx2;
    private double qx3;

    private double qy0;
    private double qy1;
    private double qy2;
    private double qy3;

    public CubicBezier(ArrayList<Point2D> points , int startIndex){
        p1 = points.get(startIndex);
        p2 = points.get(startIndex + 1);
        p3 = points.get(startIndex + 2);
        p4 = points.get(startIndex + 3);
    }
    public void recomputeValues(){
        qx0 = p1.vector[0];
        qx1 = 3 * (p2.vector[0] - p1.vector[0]);
        qx2 = 3 * (p3.vector[0]- 2 * p2.vector[0] + p1.vector[0]);
        qx3 = p4.vector[0] -3* p3.vector[0] + 3* p2.vector[0] - p1.vector[0];

        qy0 = p1.vector[1];
        qy1 = 3 * (p2.vector[1] - p1.vector[1]);
        qy2 = 3 * (p3.vector[1]- 2 * p2.vector[1] + p1.vector[1]);
        qy3 = p4.vector[1] -3* p3.vector[1] + 3* p2.vector[1] - p1.vector[1];
    }
    public Point2D getPoint(double t){
            double tt=t*t;
            double ttt=tt*t;

            double x=qx0 + qx1*t + qx2*tt + qx3*ttt;
            double y=qy0 + qy1*t + qy2*tt + qy3*ttt;

            return new Point2D(x,y);

    }
}
