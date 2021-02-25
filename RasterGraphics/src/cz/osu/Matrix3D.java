package cz.osu;

public class Matrix3D {
    public double[][] matrix;

    public Matrix3D(int size) {
        matrix = new double[size][size];
    }
    public static Matrix3D createTranslationMatrix(double dX, double dY,double dZ){
        Matrix3D export = new Matrix3D(4);
        export.matrix[0][0] = 1;
        export.matrix[1][1] = 1;
        export.matrix[2][2]= 1;
        export.matrix[3][3] = 1;
        export.matrix[0][3] = dX;
        export.matrix[1][3] = dY;
        export.matrix[2][3] = dZ;

        return export;
    }
    public static Matrix3D createScalingMatrix(double scale){
        Matrix3D export = new Matrix3D(4);
        export.matrix[0][0] = scale;
        export.matrix[1][1] = scale;
        export.matrix[2][2] = scale;
        export.matrix[3][3] = 1;

        return  export;
    }
    public static Matrix3D createRotationMatrix_xy(double angle){

        Matrix3D export = new Matrix3D(4);
        export.matrix[0][0] = Math.cos(angle);
        export.matrix[0][1] = -Math.sin(angle);
        export.matrix[1][0] = Math.sin(angle);
        export.matrix[1][1] = export.matrix[0][0];
        export.matrix[2][2] = 1;
        export.matrix[3][3] = 1;

        return export;
    }
    public static Matrix3D createRotationMatrix_yz(double angle){

        Matrix3D export = new Matrix3D(4);
        export.matrix[0][0] = 1;
        export.matrix[1][1] = Math.cos(angle);
        export.matrix[2][1] = Math.sin(angle);
        export.matrix[1][2] = -export.matrix[2][1];
        export.matrix[2][2] = export.matrix[1][1];
        export.matrix[3][3] = 1;

        return export;
    }
    public static Matrix3D createRotationMatrix_zx(double angle){

        Matrix3D export = new Matrix3D(4);
        export.matrix[0][0] = Math.cos(angle);
        export.matrix[1][1] = 1;
        export.matrix[2][0] = -Math.sin(angle);
        export.matrix[0][2] = Math.sin(angle);
        export.matrix[2][2] = export.matrix[0][0];
        export.matrix[3][3] = 1;

        return export;
    }
    public static Matrix3D multiplyMatrix(Matrix3D m1, Matrix3D m2) {
        Matrix3D export = new Matrix3D(3);
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <4 ; j++) {
                for (int k = 0; k < 4; k++) {
                    export.matrix[i][j] += m1.matrix[i][k] * m2.matrix[k][j];
                }
            }
        }
        return export;
    }
    public static Matrix3D createOrthogonalMatrix(){
        Matrix3D export = new Matrix3D(4);

        export.matrix[0][0] = 1;
        export.matrix[1][1] = 1;
        export.matrix[3][3] = 1;

        return export;
    }
}
