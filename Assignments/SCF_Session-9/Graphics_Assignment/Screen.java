package com;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * class for implementing virtual screen
 * created on July 31, 2018
 */
public class Screen {

    private Map <String, Shape> mapOfShapeOnScreen = new HashMap <String, Shape> (); //map for containing Shape objects
    private Map <Shape, Date> timeStampMap = new HashMap <Shape, Date> (); //map to maintain timestamp and shape objects
    private String uniqueId = "";

    /*
     * method adds the shape on the screen
     * @param Shape object
     * @return 1 if shape added successfully otherwise return 0
     */
    public int addShapeToScreen(Shape shape) {
        if (shape != null) {
            Date date = new Date();
            uniqueId = unigueIdGenerator();
            mapOfShapeOnScreen.put(uniqueId, shape);
            timeStampMap.put(shape, date);
            System.out.println("Shape added at origin location " + shape.getOrigin() + " with id: " + uniqueId + " having timestamp: " + date);
            System.out.println("\nShapes On screen:\n");
            showShapesOnScreen();
            return 1;
        }
        return 0;
    }

    /*
     * method remove the object from screen
     * @param shape object
     * @return 1 if removed successfully otherwise return 0
     */
    public int deleteShapeFromScreen(String uniqueShapeId) {
        if (uniqueShapeId != null) {
            timeStampMap.remove(mapOfShapeOnScreen.get(uniqueShapeId));
            mapOfShapeOnScreen.remove(uniqueShapeId);
            showShapesOnScreen();
            return 1;
        }
        return 0;
    }

    /*
     * method remove all the shapes of specific type on the screen
     * @return 1 if removed successfully otherwise return 0
     */
    public int deleteAllShapeOfSpecificType(String shapeType) {

        for (Shape value: mapOfShapeOnScreen.values()) {
            if ((value.getType().name()).equals(shapeType)) {
                mapOfShapeOnScreen.remove(value);
                timeStampMap.remove(value);
            }
            showShapesOnScreen();
        }
        return 1;
    }

    /*
     * method sorts the list of shapes in ascending order based on area
     * @return list of shapes
     */
    public List < Shape > getSortedListOfShapes() {
        List < Shape > listOfShapes = new ArrayList < Shape > ();
        for (Shape value: mapOfShapeOnScreen.values()) {
            listOfShapes.add(value);
        }

        for (int i = 0; i < listOfShapes.size(); i++) {
            for (int j = 0; j < listOfShapes.size() - 1 - i; j++) {
                double area1 = listOfShapes.get(j).getArea();
                double area2 = listOfShapes.get(j + 1).getArea();
                if (area1 > area2) {
                    Shape temp1 = listOfShapes.get(j);
                    Shape temp2 = listOfShapes.get(j + 1);
                    listOfShapes.remove(j);
                    listOfShapes.add(j, temp2);
                    listOfShapes.remove(j + 1);
                    listOfShapes.add(j + 1, temp1);
                }
            }
        }
        return listOfShapes;
    }

    /*
     * method to find the shapes enclosing a particular point
     * @param Point object as point which is enclosed
     * @return list of shapes enclosing point
     */
    public List < Shape > getListOfShapesEnclosingThePoint(Point point) {
        List < Shape > returningListOfShapes = new ArrayList < Shape > ();
        for (Shape value: mapOfShapeOnScreen.values()) {
            if (value.isPointEnclosed(point)) {
                returningListOfShapes.add(value);
            }
        }

        return returningListOfShapes;
    }

    /*
     * method shows the shapes pesent on the screen
     */
    private void showShapesOnScreen() {
        for (Shape shape: mapOfShapeOnScreen.values()) {
            System.out.println("Shape Type : " + shape.getType().name());
            System.out.println("Origin : " + shape.getOrigin());
            System.out.println("Area : " + shape.getArea());
            System.out.println("Perimeter : " + shape.getPerimeter());
            System.out.println("-----------------------------------------------------\n");
        }
    }

    /*
     * method generate a unique Id by random function
     * @return unique Id as string
     */
    private String unigueIdGenerator() {
        String uniqueId = "shape";
        for (int i = 1; i <= 3; i++) {
            uniqueId = uniqueId + String.valueOf((int)(Math.random() * 10));
        }
        return uniqueId;
    }

    public String getUniqueId() {
        return uniqueId;
    }


}