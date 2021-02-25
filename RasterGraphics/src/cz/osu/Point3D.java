package cz.osu;

public class Point3D {
    public double[] vector;
    public Point3D(){
        vector = new double[4];
    }

    public Point3D(double x, double y, double z){

        vector = new double[4];

        vector[0] = x;
        vector[1] = y;
        vector[2] = z;
        vector[4] = 1;
    }
    public Point3D applyMatrix(Matrix3D matrix){
        Point3D export = new Point3D();

        for (int i = 0; i < 4 ; i++) {
            export.vector[0] += matrix.matrix[0][i] * vector[i];
            export.vector[1] += matrix.matrix[1][i] * vector [i];
            export.vector[2] += matrix.matrix[2][i] * vector[i];
            export.vector[3] += matrix.matrix[3][i] * vector[i];
        }
        return export;
    }
}
