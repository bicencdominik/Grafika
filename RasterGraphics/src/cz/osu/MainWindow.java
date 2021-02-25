package cz.osu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainWindow extends JPanel{

    private ImagePanel imagePanel;
    private JLabel infoLabel;

    private V_RAM vram;

    private Triangle2D t1;
    private Triangle2D t2;
    private Line2D line1;

    public MainWindow(){

        initialize();
        
        vram = new V_RAM(100, 100);

        GraphicsOperations.fillBrightness(vram, 255);

        Point2D p0 = new Point2D(20,50);
        Point2D p1 = new Point2D(20,50);
        Point2D p2 = new Point2D(35,25);
        Point2D p3 = new Point2D(60,75);
        Point2D p4 = new Point2D(85,50);
        Point2D pN = new Point2D(85,50);

        Scene scene = new Scene();
        scene.addPoint(p0);
        scene.addPoint(p1);
        scene.addPoint(p2);
        scene.addPoint(p3);
        scene.addPoint(p4);
        scene.addPoint(pN);

        scene.generatePointsWithManaging();


        scene.drawToV_Ram(vram);

        vram.setPoint(p1);
        vram.setPoint(p2);
        vram.setPoint(p3);
        vram.setPoint(p4);






        /*Point2D cp = new Point2D(50,50);
        Point2D p1 = new Point2D(25,25);
        Point2D p2 = new Point2D(25,50);
        Point2D p3 = new Point2D(50,25);
        Point2D p4 = new Point2D(75,25);
        Point2D p5 = new Point2D(75,50);
        Point2D p6 = new Point2D(75,75);
        Point2D p7 = new Point2D(50,75);
        Point2D p8 = new Point2D(25,75);
        Point2D p9 = new Point2D(25,40);
        Point2D p10 = new Point2D(40,25);
        Point2D p11 = new Point2D(60,25);
        Point2D p12 = new Point2D(75,40);
        Point2D p13 = new Point2D(75,60);
        Point2D p14 = new Point2D(25,60);
        Point2D p15 = new Point2D(40,75);
        Point2D p16 = new Point2D(60,75);

        Line2D line = new Line2D(cp,p1);
        Line2D line2 = new Line2D(cp,p2);
        Line2D line3 = new Line2D(cp,p3);
        Line2D line4 = new Line2D(cp,p4);
        Line2D line5 = new Line2D(cp,p5);
        Line2D line6 = new Line2D(cp,p6);
        Line2D line7 = new Line2D(cp,p7);
        Line2D line8 = new Line2D(cp,p8);
        Line2D line9 = new Line2D(cp,p9);
        Line2D line10 = new Line2D(cp,p10);
        Line2D line11 = new Line2D(cp,p11);
        Line2D line12 = new Line2D(cp,p12);
        Line2D line13 = new Line2D(cp,p13);
        Line2D line14 = new Line2D(cp,p14);
        Line2D line15 = new Line2D(cp,p15);
        Line2D line16 = new Line2D(cp,p16);


        GraphicsOperations.drawLine(vram,line,55);
        GraphicsOperations.drawLine(vram,line2,55);
        GraphicsOperations.drawLine(vram,line3,55);
        GraphicsOperations.drawLine(vram,line4,55);
        GraphicsOperations.drawLine(vram,line5,55);
        GraphicsOperations.drawLine(vram,line6,55);
        GraphicsOperations.drawLine(vram,line7,55);
        GraphicsOperations.drawLine(vram,line8,55);
        GraphicsOperations.drawLine(vram,line9,55);
        GraphicsOperations.drawLine(vram,line10,55);
        GraphicsOperations.drawLine(vram,line11,55);
        GraphicsOperations.drawLine(vram,line12,55);
        GraphicsOperations.drawLine(vram,line13,55);
        GraphicsOperations.drawLine(vram,line14,55);
        GraphicsOperations.drawLine(vram,line15,55);
        GraphicsOperations.drawLine(vram,line16,55);

        //GraphicsOperations gp = new GraphicsOperations();
        //GraphicsOperations.drawLine(vram,line,128);
        //t1 = new Triangle2D(new Point2D(20, 20), new Point2D(50, 20), new Point2D(20, 50));
        //t2 = t1.clone();

        //GraphicsOperations.drawTriangle(vram, t1, 128);
        //GraphicsOperations.drawTriangle(vram, t2, 50);*/

        /*Point2D p = new Point2D(25,25);
        Point2D p2 = new Point2D(10,20);
        Point2D p3 = new Point2D(40,30);
        Point2D p4 = new Point2D(30,15);

        Point2D[] points = new Point2D[4];
        points[0] = p;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;


        for (Point2D point2D : points){
            vram.setPixelSafe(point2D.vector[0],point2D.vector[1],128);
        }


        vram.setPixelSafe(p.vector[0],p.vector[1],128);

        Matrix2D translation = Matrix2D.createTranslationMatrix(-5,-20);
        Matrix2D scale = Matrix2D.createScalingMatrix(1.7);
        Matrix2D rotation = Matrix2D.createRotationMatrix(Math.PI / 3);

        Matrix2D result = Matrix2D.multiplyMatrix(rotation, scale);
        result = Matrix2D.multiplyMatrix(result,translation);

        for (Point2D point2D : points){
            Point2D oTemp = point2D.applyMatrix(result);
            vram.setPixelSafe(oTemp.vector[0],oTemp.vector[1],128);
        }*/

        /*Point3D[] points = new Point3D[8];
        points[0] = new Point3D(10,10,10);
        points[1] = new Point3D(80,10,10);
        points[2] = new Point3D(80,80,10);
        points[3] = new Point3D(10,80,10);

        points[4] = new Point3D(10,10,80);
        points[5] = new Point3D(80,10,80);
        points[6] = new Point3D(80,80,80);
        points[7] = new Point3D(10,80,80);

        for (Point3D point3D: points){
            vram.drawPoint(point3D);
        }
*/
        //prechod do normaliuzovaneho prostoru - do jednotkove krychle
        /*
        Matrix3D tDoN = Matrix3D.createTranslationMatrix(-45,-45,-45);
        Matrix3D sDoN = Matrix3D.createScalingMatrix(2.0/70);

        Matrix3D rN = Matrix3D.createRotationMatrix_xy(0.1);
        Matrix3D rN_xz = Matrix3D.createRotationMatrix_yz(0.5);

        Matrix3D sDoV = Matrix3D.createScalingMatrix(100);
        Matrix3D tDoV = Matrix3D.createTranslationMatrix(100,100,100);

        Matrix3D projection = Matrix3D.createOrthogonalMatrix();

        // Point2D = tDoV * sDoV * projection * rN * sDoN * tDoN * Point
        //Point2D = tDoV * sDoV * projection * rN * rN * sDoN * tDoN * Point
        //Point2D = tDoV * sDoV * projection * rN * rN * rN * sDoN * tDoN * Point

        //K * rN * Q
        //Point2D = K * Q * P

        Matrix3D Q = Matrix3D.multiplyMatrix(sDoN,tDoN);
        Matrix3D K = Matrix3D.multiplyMatrix(projection,Matrix3D.multiplyMatrix(tDoV,sDoV));

        Matrix3D Q1 = Matrix3D.multiplyMatrix(Q,rN_xz);
        Matrix3D Qr = Matrix3D.multiplyMatrix(rN,Q1);
        Matrix3D KQ = Matrix3D.multiplyMatrix(K,Qr);
        Matrix3D KQrN = Matrix3D.multiplyMatrix(KQ,rN);

        Point2D[] point2DS = new Point2D[8];
        /*for (int i = 0; i < points.length; i++) {
            points[i] = points[i].applyMatrix(KQ);
            vram.drawPoint(points[i]);

        }*/
        imagePanel.setImage(vram.getImage());

    }

    private void initialize(){

        setLayout(null);
        setFocusable(true);
        requestFocusInWindow();

        imagePanel = new ImagePanel();
        imagePanel.setBounds(10,60, 970, 600);
        this.add(imagePanel);

        /*
        //open image
        JButton button = new JButton();
        button.setBounds(150,10,120,30);
        button.setText("Load Image");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                openImage();
            }
        });

        this.add(button);
        */

        //save image as PNG
        JButton button4 = new JButton();
        button4.setBounds(10,10,120,30);
        button4.setText("Save as PNG");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveImageAsPNG();
            }
        });

        this.add(button4);

        infoLabel = new JLabel();
        infoLabel.setBounds(850,10,120,30);
        infoLabel.setText("Rotation");
        infoLabel.setFont(new Font(infoLabel.getName(), Font.BOLD, 20));

        this.add(infoLabel);

        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {

                if(e.getKeyChar() == 'r'){

                    infoLabel.setText("Rotation");
                }

                if(e.getKeyChar() == 't'){

                    infoLabel.setText("Translation");
                }

                if(e.getKeyChar() == 's'){

                    infoLabel.setText("Scale");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

                int key = e.getKeyCode();

                GraphicsOperations.fillBrightness(vram, 255);

               // GraphicsOperations.drawTriangle(vram, t1, 128);

                if(infoLabel.getText().equals("Translation")){

                    if (key == KeyEvent.VK_LEFT) t2.applyMatrix(Matrix2D.createTranslationMatrix(-1, 0));

                    if (key == KeyEvent.VK_UP) t2.applyMatrix(Matrix2D.createTranslationMatrix(0, -1));

                    if (key == KeyEvent.VK_RIGHT) t2.applyMatrix(Matrix2D.createTranslationMatrix(1, 0));

                    if (key == KeyEvent.VK_DOWN) t2.applyMatrix(Matrix2D.createTranslationMatrix(0, 1));
                }

                if(infoLabel.getText().equals("Rotation")){

                    if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_UP) t2.applyMatrix(Matrix2D.createRotationMatrix(-1));

                    if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_DOWN) t2.applyMatrix(Matrix2D.createRotationMatrix(1));
                }

                if(infoLabel.getText().equals("Scale")){

                    if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_UP) t2.applyMatrix(Matrix2D.createScalingMatrix(1.05));

                    if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_DOWN) t2.applyMatrix(Matrix2D.createScalingMatrix(1 / 1.05));
                }

               // GraphicsOperations.drawTriangle(vram, t2, 50);

                imagePanel.setImage(vram.getImage());
            }
        });

        JFrame frame = new JFrame("Raster Graphics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setSize(1004, 705);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void openImage(){

        String userDir = System.getProperty("user.home");
        JFileChooser fc = new JFileChooser(userDir +"/Desktop");
        fc.setDialogTitle("Load Image");

        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            File file = fc.getSelectedFile();

            try {

                BufferedImage temp = ImageIO.read(file);

                if(temp != null){

                    imagePanel.setImage(temp);

                }else {

                    JOptionPane.showMessageDialog(null, "Unable to load image", "Open image: ", JOptionPane.ERROR_MESSAGE);
                }

            }catch (IOException e){

                e.printStackTrace();
            }
        }
    }

    private void saveImageAsPNG(){

        String userDir = System.getProperty("user.home");
        JFileChooser fc = new JFileChooser(userDir +"/Desktop");
        fc.setDialogTitle("Save Image as PNG");

        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

            File file = fc.getSelectedFile();

            String fname = file.getAbsolutePath();

            if(!fname.endsWith(".png") ) file = new File(fname + ".png");

            try {

                ImageIO.write(imagePanel.getImage(), "png", file);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {

        new MainWindow();
    }
}
