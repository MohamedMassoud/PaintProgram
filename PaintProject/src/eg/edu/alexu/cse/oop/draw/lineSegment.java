/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.cse.oop.draw;

import java.awt.Graphics;
import java.util.HashMap;
import java.awt.Point;
import java.awt.Color;
import java.util.Map;

/**
 *
 * @author Ibrahim Moursy
 */
public class lineSegment extends Rectangle{

    
    public lineSegment(){
        
        properties = new HashMap<String , Double>();
        properties.put("length", 0.0);

    }
        
        @Override
        
        public void draw(Graphics canvas) {
            canvas.setColor(this.getColor());
            canvas.setColor(this.getFillColor());
            canvas.drawLine((int)this.position.getX(), (int)this.position.getY(), (int)this.position.getX()+ (int)this.properties.get("length").doubleValue(), (int)this.position.getY()+ (int)this.properties.get("length").doubleValue());
    }
        
        public Object clone() throws CloneNotSupportedException{
        lineSegment obj = new lineSegment();
		obj.properties = this.properties;
                obj.c = this.c;
                obj.fc = this.fc;
                obj.position = this.position;
                return obj;
    } 
        
        
    
    
}
