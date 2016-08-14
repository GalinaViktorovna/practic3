package com.practice3.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AreaOfRectangles {

        private class Rectangle implements Comparable {
            int x;
            int h;
            int w;
            int endX;
            int square;


            public int getX() {
                return x;
            }

            public int getH() {
                return h;
            }

            public int getEndX() {
                return endX;
            }

            public Rectangle(int x, int h, int w) {
                this.x = x;
                this.h = h;
                this.w = w;
                this.endX = x + w;
                this.square = w * h;
            }

            @Override
            public boolean equals(Object obj) {
                Rectangle tmp = (Rectangle) obj;

                return ((this.x == tmp.x) && (this.h == tmp.h) && (this.w == tmp.w));
            }

            @Override
            public String toString() {
                return "x[" + x + "]" + "h[" + h + "]" + "w[" + w + "]";
            }

            public int compareTo(Object o) {
                return this.x - ((Rectangle) o).getX();
            }
        }

        public int measure(int[] x, int[] h, int[] w) {

            ArrayList<Rectangle> rectangles = new ArrayList<>();
            ArrayList<Integer> points = new ArrayList<>();

            for (int i = 0; i < x.length; i++) {
                points.add(x[i]);
                points.add(x[i] + w[i]);
                rectangles.add(new Rectangle(x[i], h[i], w[i]));
            }

            Set<Integer> pointsWithoutDuplicates = new HashSet<>();
            pointsWithoutDuplicates.addAll(points);
            points.clear();
            points.addAll(pointsWithoutDuplicates);

            Collections.sort(points);

            ArrayList<Rectangle> columns = new ArrayList<>();
            int heightIntervalBetweenPointers;
            for (int i = 0; i < points.size() - 1; i++) {
                heightIntervalBetweenPointers = 0;
                int beginPoint = points.get(i);
                int endPoint = points.get(i + 1);

                for (Rectangle r :
                        rectangles) {
                    if ((r.getX() <= beginPoint) &&
                            (r.getEndX() >= endPoint) &&
                            (r.getH() > heightIntervalBetweenPointers)) {
                        heightIntervalBetweenPointers = r.getH();
                    }
                }

                if (heightIntervalBetweenPointers > 0) {
                    columns.add(new Rectangle(beginPoint, heightIntervalBetweenPointers, endPoint - beginPoint));
                }
            }

            int square = 0;
            for (Rectangle r :
                    columns) {
                square += r.square;
            }
            return square;
        }

        public static void main(String[] args) {
            AreaOfRectangles areaOfRectangles = new AreaOfRectangles();
            int x[] = {0, 0, 20, 10, 5};
            int h[] = {20, 10, 30, 20, 5};
            int w[] = {10, 20, 10, 30, 40};
            int measure = areaOfRectangles.measure(x, h, w);
            System.out.println(measure);
        }

    }
