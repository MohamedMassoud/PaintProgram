/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.cse.oop.draw;

/**
 *
 * @author crap
 */
import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import java.awt.Point;


public class Circle implements Shape {



        private Point position;
	private Map<String, Double> properties;
	private Color c;
	private Color fc;
        
        
        
        
        
	
	public Circle() {
		properties = new HashMap<String, Double>();
		properties.put("radius", 0.0);
	}
	
	public void setPosition(Point position) { this.position = position; }
	public Point getPosition() { return position; }

	public void setProperties(Map<String, Double> properties) {	this.properties = properties; }
	public Map<String, Double> getProperties() { return this.properties; }

	public void setColor(Color color) {	c = color;	}
	public Color getColor() { return c;	}

	public void setFillColor(Color color) { fc = color; }
	public Color getFillColor() { return fc; }

	@Override
	public void draw(Graphics canvas) {
	  if(getFillColor()!= null){
              
              canvas.setColor(this.getFillColor());
              canvas.fillOval((int)this.position.getX(), (int)this.position.getY(), (int)(this.properties.get("radius").doubleValue()), (int)(this.properties.get("radius").doubleValue()));		
          }else{	
            canvas.setColor(Color.BLACK);
            canvas.setColor(this.getColor());
            canvas.drawOval((int)this.position.getX(), (int)this.position.getY(), (int)(this.properties.get("radius").doubleValue()), (int)(this.properties.get("radius").doubleValue()));	
            
	}
        }
        

	
	@Override
	public Object clone() throws CloneNotSupportedException{
            Circle obj = new Circle();
		obj.properties = this.properties;
                obj.c = this.c;
                obj.fc = this.fc;
                obj.position = this.position;
                return obj;
	}
        
        
}
