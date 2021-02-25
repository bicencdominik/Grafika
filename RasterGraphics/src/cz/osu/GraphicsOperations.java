package cz.osu;

import java.awt.*;

public class GraphicsOperations {

    public static void fillBrightness(V_RAM vram, int brightness){

        brightness = Math.min(255, Math.max(0, brightness));

        for(int y = 0; y < vram.getHeight(); y++)
            for(int x = 0; x < vram.getWidth(); x++)
                vram.getRawData()[y][x] = brightness;
    }

   /* public static void drawLine(V_RAM vram, Line2D line, int brightness){

        bresenhamLineDrawing(vram, line, brightness);
    }*/

    /*public static void drawTriangle(V_RAM vram, Triangle2D triangle, int brightness){

        bresenhamLineDrawing(vram, new Line2D(triangle.pointA, triangle.pointB), brightness);
        bresenhamLineDrawing(vram, new Line2D(triangle.pointB, triangle.pointC), brightness);
        bresenhamLineDrawing(vram, new Line2D(triangle.pointC, triangle.pointA), brightness);
    }*/

    public static void bresenhamDrawing(V_RAM vram, Point point0, Point point1, int brightness) {

        int x, y, dx, dy, dx1, dy1, px, py, xe, ye;

        dx = point1.x - point0.x;
        dy = point1.y - point0.y;

        dx1 = Math.abs(dx);
        dy1 = Math.abs(dy);

        px = 2 * dy1 - dx1;
        py = 2 * dx1 - dy1;

        if (dy1 <= dx1) {
            if (dx >= 0) {
                x = point0.x; y = point0.y; xe = point1.x;
            } else {
                x = point1.x; y = point1.y; xe = point0.x;
            }
            vram.setPixelSafe(x,y,brightness);
            for (int i = 0; x < xe; i++) {
                x = x + 1;
                if (px < 0) {
                    px = px + 2 * dy1;
                } else {
                    if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0)) {
                        y = y + 1;
                    } else {
                        y = y - 1;
                    }
                    px = px + 2 * (dy1 - dx1);
                }
                vram.setPixelSafe(x, y,brightness);
            }
        } else {
            if (dy >= 0) {
                x = point0.x; y = point0.y; ye = point1.y;
            } else {
                x = point1.x; y = point1.y; ye = point0.y;
            }
            vram.setPixelSafe(x,y,brightness);
            for (int i = 0; y < ye; i++) {
                y = y + 1;
                if (py <= 0) {
                    py = py + 2 * dx1;
                } else {
                    if ((dx < 0 && dy<0) || (dx > 0 && dy > 0)) {
                        x = x + 1;
                    } else {
                        x = x - 1;
                    }
                    py = py + 2 * (dx1 - dy1);
                }
                vram.setPixelSafe(x, y,brightness);
            }
        }

        /*int dx =  Math.abs(point1.x - point0.x);
        int sx = point0.x < point1.x ? 1 : -1;

        int dy = -Math.abs(point1.y - point0.y);
        int sy = point0.y < point1.y ? 1 : -1;

        int err = dx + dy;
        int e2;

        while (true){

            vram.setPixel(point0.x, point0.y, brightness);

            if (point0.x == point1.x && point0.y == point1.y) break;

            e2 = 2 * err;

            if (e2 >= dy) { err += dy; point0.x += sx; } /* e_xy+e_x > 0
            if (e2 <= dx) { err += dx; point0.y += sy; } /* e_xy+e_y < 0
        }
        */
    }
    public static void drawPoint(V_RAM vram, Point startPoint, int brightness, int i) {
        vram.setPixelSafe(startPoint.getX(), startPoint.getY(), brightness);
    }
    public static void drawBezier(V_RAM vram, CubicBezier cubicBezier, int steps, int brightness, boolean showPoints) {

        cubicBezier.recomputeValues();

        Point startPoint = cubicBezier.p1.getRoundedPoint();

        if (showPoints) GraphicsOperations.drawPoint(vram,startPoint,brightness,2);

        for (int i = 1; i <= steps; i++) {

            Point endPoint = cubicBezier.getPoint(1.0 * i / steps).getRoundedPoint();

            GraphicsOperations.bresenhamDrawing(vram,startPoint,endPoint,brightness);

            if (showPoints){
                GraphicsOperations.drawPoint(vram,endPoint,brightness,2);
            }

            startPoint = endPoint;

        }

    }
}
