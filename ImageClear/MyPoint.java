package ImageClear;

import java.awt.geom.Point2D;

//Alexey Dubrovinskiy
//alexey.dubrovinskiy@rambler.ru
//April 08, 2018

public class MyPoint extends Point2D{
	
	private double x;
	private double y;
	
	public MyPoint() {
		x=0;
		y=0;
	}

	public MyPoint(double x, double y) {
		this.x=x;
		this.y=y;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setLocation(double x, double y) {
		this.x=x;
		this.y=y;		
	}
        
        public double getDistance(MyPoint p){
            return Math.sqrt(Math.pow(p.getX()-x,2)+Math.pow(p.getY()-y,2));
        }
        
        public void move (double dx, double dy){
            this.x+=dx;
            this.y+=dy;
        }

}
