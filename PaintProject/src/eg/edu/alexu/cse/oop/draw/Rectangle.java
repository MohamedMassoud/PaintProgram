/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.cse.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author crap
 */
public class Rectangle implements Shape{
    
        protected Point position;
	protected Map<String, Double> properties;
	protected Color c;
	protected Color fc;

    
    Rectangle(){
        properties = new HashMap<String,Double>();
        properties.put("length", 0.0);
        properties.put("width", 0.0);
    }
        
    public void setPosition(java.awt.Point position){
        this.position = position;
    }
    public java.awt.Point getPosition(){
        return position;
    }
    /* update shape specific properties (e.g., radius) */
    public void setProperties(java.util.Map<String, Double> properties){
        this.properties = properties;
    }
    public java.util.Map<String, Double> getProperties(){
        return properties;
    }
    /* colorize */
    public void setColor(java.awt.Color color){
        c = color;
    } 
    public java.awt.Color getColor(){
        return c;
    } 
    public void setFillColor(java.awt.Color color){
        fc = color;
    }
    public java.awt.Color getFillColor(){
        return fc;
    } 
    /* redraw the shape on the canvas */
    public void draw(java.awt.Graphics canvas){
        if(getFillColor() != null){
            canvas.setColor(this.getFillColor());
            canvas.fillRect((int)position.getX(), (int)position.getY(), (int)properties.get("length").doubleValue(), (int)properties.get("width").doubleValue());
        }else{
            canvas.setColor(Color.BLACK);
            canvas.setColor(this.getColor());
            canvas.drawRect((int)position.getX(), (int)position.getY(), (int)properties.get("length").doubleValue(), (int)properties.get("width").doubleValue());      
     }
     } 
    
    /* create a deep clone of the shape */
    
    public Object clone() throws CloneNotSupportedException{
        Rectangle obj = new Rectangle();
		obj.properties = this.properties;
                obj.c = this.c;
                obj.fc = this.fc;
                obj.position = this.position;
                return obj;
    }  

    
}
