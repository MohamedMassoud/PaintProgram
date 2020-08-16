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
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Square extends Rectangle{

        
	public Square() {
		properties = new HashMap<String, Double>();
		properties.put("side", 0.0);
                
	}
        

	@Override
	public void draw(Graphics canvas) {
	  if(getFillColor() != null){
            canvas.setColor(this.getFillColor());
            canvas.fillRect((int)this.position.getX(), (int)this.position.getY(), (int)(this.properties.get("side").doubleValue()), (int)(this.properties.get("side").doubleValue()));		
	}else{
            canvas.setColor(Color.BLACK);
            canvas.setColor(this.getColor());
            canvas.drawRect((int)this.position.getX(), (int)this.position.getY(), (int)(this.properties.get("side").doubleValue()), (int)(this.properties.get("side").doubleValue()));
        }
        }
         
        @Override
	public Object clone() throws CloneNotSupportedException{
        Square obj = new Square();
		obj.properties = this.properties;
                obj.c = this.c;
                obj.fc = this.fc;
                obj.position = this.position;
                return obj;
    } 

        

}
