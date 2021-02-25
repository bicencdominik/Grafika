package cz.osu;

import java.util.ArrayList;

public class Scene {
    private ArrayList<Point2D> points;
    private ArrayList<CubicBezier> cubicBeziers;
    private ArrayList<Point2D> pointsWithManaging = new ArrayList<>();

    public Scene(){
        points = new ArrayList<>();
    }
    public void addPoint(Point2D point){
        points.add(point);
    }


    public void generatePointsWithManaging(){

        for (int i = 1; i < points.size() - 1; i++) {
            if (i ==1){
                pointsWithManaging.add(points.get(i));
                pointsWithManaging.add(generateRPointP(i));
            }
            else if (i == points.size() - 2){
                pointsWithManaging.add(generateLPointP(i));
                pointsWithManaging.add(points.get(i));
            }
            else {
                pointsWithManaging.add(generateLPointP(i));
                pointsWithManaging.add(points.get(i));
                pointsWithManaging.add(generateRPointP(i));
            }
        }



        int beziersCount = (pointsWithManaging.size() - 1) / 3;

        cubicBeziers = new ArrayList<>();

        for (int i = 0; i < beziersCount; i++) {
            cubicBeziers.add(new CubicBezier(pointsWithManaging,3*i));
        }


    }

    public Point2D generateLPointP(int index){
        double Lx;
        double Ly;

        Lx = points.get(index).vector[0] - ((points.get(index + 1).vector[0] - points.get(index - 1).vector[0]) / 6);
        Ly = points.get(index).vector[1] - ((points.get(index + 1).vector[1] - points.get(index - 1).vector[1]) / 6);

        return new Point2D(Lx,Ly);
    }

    public Point2D generateRPointP(int index){
        double Rx;
        double Ry;

        Rx = points.get(index).vector[0] + ((points.get(index + 1).vector[0] - points.get(index - 1).vector[0]) / 6);
        Ry = points.get(index).vector[1] + ((points.get(index + 1).vector[1] - points.get(index - 1).vector[1]) / 6);

        return new Point2D(Rx,Ry);
    }
    public void drawToV_Ram(V_RAM vram){
        GraphicsOperations.fillBrightness(vram,255);

        for (int i = 1; i < points.size(); i++) {
            GraphicsOperations.bresenhamDrawing(vram,points.get(i-1).getRoundedPoint(),points.get(i).getRoundedPoint(),200);
        }
        for (Point2D point2D: points){
            GraphicsOperations.drawPoint(vram, point2D.getRoundedPoint(),150,4);
        }
        for (CubicBezier cubicBezier: cubicBeziers){
            GraphicsOperations.drawBezier(vram, cubicBezier, 20,10,true);
        }
    }
}
