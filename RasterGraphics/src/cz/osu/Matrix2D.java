package cz.osu;

public class Matrix2D {

    public double[][] matrix;

    public Matrix2D(int size){

        matrix = new double[size][size];

    }

    public static Matrix2D createIdentityMatrix(){

        //TODO

        return null;
    }

    public static Matrix2D createTranslationMatrix(double dX, double dY){
        Matrix2D export = new Matrix2D(3);
        export.matrix[0][0] = 1;
        export.matrix[1][1] = 1;
        export.matrix[2][2]= 1;
        export.matrix[0][2] = dX;
        export.matrix[1][2] = dY;

        return export;
    }

    public static Matrix2D createRotationMatrix(double angle){

        Matrix2D export = new Matrix2D(3);
        export.matrix[0][0] = Math.cos(angle);
        export.matrix[0][1] = -Math.sin(angle);
        export.matrix[1][0] = Math.sin(angle);
        export.matrix[1][1] = export.matrix[0][0];
        export.matrix[2][2] = 1;

        return export;
    }

    public static Matrix2D createScalingMatrix(double scale){
        Matrix2D export = new Matrix2D(3);
        export.matrix[0][0] = scale;
        export.matrix[1][1] = scale;
        export.matrix[2][2] = 1;

        return  export;
    }

    public static Matrix2D multiplyMatrix(Matrix2D m1, Matrix2D m2) {
        Matrix2D export = new Matrix2D(3);
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                for (int k = 0; k < 3; k++) {
                    export.matrix[i][j] += m1.matrix[i][k] * m2.matrix[k][j];
                }
            }
        }
        return export;
    }
}
