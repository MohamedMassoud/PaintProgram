/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.cse.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

/**
 *
 * @author crap
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class DEngine implements DrawingEngine{
    

    
    static ArrayList<Shape> shapes = new ArrayList<Shape>();
    static ArrayList<String> shapeName = new ArrayList<String>();
    static HashMap<Class<? extends Shape>, Integer> classes = new HashMap<Class<? extends Shape>, Integer>();
    static int check = 0;
    static int count = 0;
    static Stack Stock = new Stack();
    static List<Class<? extends Shape>> supportedShapes = new ArrayList<Class<? extends Shape>>();
    
    
    
    


    Square sqr;
    Circle crc;
    Rectangle rect;
    @Override
    
    public void addShape(Shape shape) {
        if(check==0){
            shapeName.add("Select");
            shapes.add(null);
            check++;
        }
        
        shapes.add(shape);

        if(classes.containsKey(shape.getClass())){
           count = classes.get(shape.getClass())+1;
        }else{
            count = 0;
        }
        classes.put(shape.getClass(), count);
        
        shapeName.add(String.format("%s%02d", shape.getClass().getSimpleName(),classes.get(shape.getClass())));

    }
    

    @Override
    public void removeShape(Shape shape) {
        Stock.push(shapes.get(shapes.size()-1));
        shapeName.remove(shapes.indexOf(shape));
        shapes.remove(shape);

    }

    @Override
    public Shape[] getShapes() {
        Shape [] shapeStock = new Shape[shapes.size()];
        shapeStock = shapes.toArray(shapeStock);
        return shapeStock;
    }
  
  
    

    @Override
    public void refresh(Graphics canvas) {
        
        for(int i=1; i< this.getShapes().length;i++){
            /*if(this.getShapes()[i].getFillColor()!=null){
                canvas.setColor(this.getShapes()[i].getFillColor());
                this.getShapes()[i].fill(canvas);
                
            }*/
                
                this.getShapes()[i].draw(canvas);

            
            
        }
    }

    @Override
    public List<Class<? extends Shape>> getSupportedShapes() {
       return supportedShapes;
        
    }

    @Override
    public void installPluginShape(Class<? extends Shape> shapeClass) {
        
        this.supportedShapes.add(shapeClass);
    }

    @Override
    public void undo() {
      
        
        if(shapes.size()>1){
             this.removeShape(shapes.get(shapes.size()-1)); 
        }

    }

    @Override
    public void redo() {
    if(!Stock.isEmpty()){
        shapes.add((Shape) Stock.pop());
        count = classes.get(shapes.get(shapes.size()-1).getClass())+1;
        shapeName.add(String.format("%s%02d", shapes.get(shapes.size()-1).getClass().getSimpleName(),classes.get(shapes.get(shapes.size()-1).getClass())));
    }
    
    
    }
}