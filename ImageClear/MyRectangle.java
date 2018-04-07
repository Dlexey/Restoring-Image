package ImageClear;

import java.awt.geom.Rectangle2D;

//Alexey Dubrovinskiy
//alexey.dubrovinskiy@rambler.ru
//April 08, 2018

public class MyRectangle extends Rectangle2D {
	
	private double width, height;
	private MyPoint point=new MyPoint();
	private MyPoint bottom_right=new MyPoint();
	
	public MyRectangle() {
		this.point.setLocation(0, 0);
		this.width=0;
		this.height=0;	
		bottom_right.setLocation(width+point.getX(), height+point.getY());
	}

	public MyRectangle(MyPoint point, double width, double height ) {
		this.point=point;
		this.width=width;
		this.height=height;
		bottom_right.setLocation(width+point.getX(), height+point.getY());
	}
	
	public MyRectangle(double x, double y, double width, double height ) {
		this.point.setLocation(x, y);
		this.width=width;
		this.height=height;	
		bottom_right.setLocation(width+point.getX(), height+point.getY());
	}

	@Override
	public Rectangle2D createIntersection(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D createUnion(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outcode(double arg0, double arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRect(double x, double y, double width, double height) {
		this.point.setLocation(x, y);
		this.width=width;
		this.height=height;	
		bottom_right.setLocation(width+point.getX(), height+point.getY());

	}
	
	public void setRect(MyPoint point, double width, double height ) {
		this.point=point;
		this.width=width;
		this.height=height;	
		bottom_right.setLocation(width+point.getX(), height+point.getY());
	}

	@Override
	public double getHeight() {		
		return height;
	}

	@Override
	public double getWidth() {		
		return width;
	}

	@Override
	public double getX() {		
		return point.getX();
	}

	@Override
	public double getY() {		
		return point.getY();
	}
	
	public MyPoint getPoint() {		
		return point;
	}
	
	public boolean contains(double x, double y) {
		
		if (point.getX()<=x&point.getX()+width>=x&point.getY()<=y&point.getY()+height>=y){
			return true;
		}else {return false;}
	}
	
public boolean contains(MyPoint p) {
		
		if (point.getX()<=p.getX()&point.getX()+width>=p.getX()&point.getY()<=p.getY()&point.getY()+height>=p.getY()){
			return true;
		}else {return false;}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
