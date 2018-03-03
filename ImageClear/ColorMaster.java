package ImageClear;

import java.awt.Color;
import java.awt.image.BufferedImage;

//Alexey Dubrovinskiy
//alexey.dubrovinskiy@rambler.ru
//October 17, 2017

public final class ColorMaster {
	
	static public Color getColor(double x_in, double y_in, BufferedImage image) {
		
		Color pixel_left_up=new Color(image.getRGB((int)Math.floor(x_in), (int)Math.floor(y_in)));
		Color pixel_left_bottom=new Color(image.getRGB((int)Math.floor(x_in), (int)Math.ceil(y_in)));
		Color pixel_right_up=new Color(image.getRGB((int)Math.ceil(x_in), (int)Math.floor(y_in)));
		Color pixel_right_bottom=new Color(image.getRGB((int)Math.ceil(x_in), (int)Math.ceil(y_in)));
		
		double left_up=Math.sqrt(Math.pow(x_in-Math.floor(x_in),2)+Math.pow(y_in-Math.floor(y_in),2));
		double left_bottom=Math.sqrt(Math.pow(x_in-Math.floor(x_in),2)+Math.pow(y_in-Math.ceil(y_in),2));
		double right_up=Math.sqrt(Math.pow(x_in-Math.ceil(x_in),2)+Math.pow(y_in-Math.floor(y_in),2));
		double right_bottom=Math.sqrt(Math.pow(x_in-Math.ceil(x_in),2)+Math.pow(y_in-Math.ceil(y_in),2));
		
		int r=0;
		int g=0;
		int b=0;		
		
		if ((left_up<left_bottom)&(left_up<right_up)&(left_up<right_bottom)){
			r=pixel_left_up.getRed();
			g=pixel_left_up.getGreen();
			b=pixel_left_up.getBlue();
		}
		
		if ((left_bottom<left_up)&(left_bottom<right_up)&(left_bottom<right_bottom)){
			r=pixel_left_bottom.getRed();
			g=pixel_left_bottom.getGreen();
			b=pixel_left_bottom.getBlue();
		}
		
		if ((right_up<left_up)&(right_up<left_bottom)&(right_up<right_bottom)){
			r=pixel_right_up.getRed();
			g=pixel_right_up.getGreen();
			b=pixel_right_up.getBlue();
		}
		
		if ((right_bottom<left_up)&(right_bottom<left_bottom)&(right_bottom<right_up)){
			r=pixel_right_bottom.getRed();
			g=pixel_right_bottom.getGreen();
			b=pixel_right_bottom.getBlue();
		}
		
		if ((left_up==left_bottom)&(right_bottom<left_bottom)){
			r=pixel_right_bottom.getRed();
			g=pixel_right_bottom.getGreen();
			b=pixel_right_bottom.getBlue();
		}
		
		if ((left_up==left_bottom)&(left_bottom<right_bottom)){
			r=pixel_left_bottom.getRed();
			g=pixel_left_bottom.getGreen();
			b=pixel_left_bottom.getBlue();
		}
		
		if ((left_up==right_up)&(right_bottom<right_up)){
			r=pixel_right_bottom.getRed();
			g=pixel_right_bottom.getGreen();
			b=pixel_right_bottom.getBlue();
		}
		
		if ((right_up==left_up)&(right_up<right_bottom)){
			r=pixel_right_up.getRed();
			g=pixel_right_up.getGreen();
			b=pixel_right_up.getBlue();
		}		
		
		Color c=new Color(r, g, b);
		
		return c;		
	}
	
	static public Color getColorInterpolationXY(double x_in, double y_in, BufferedImage image) {
		
		Color pixel_left_up=new Color(image.getRGB((int)Math.floor(x_in), (int)Math.floor(y_in)));
		Color pixel_left_bottom=new Color(image.getRGB((int)Math.floor(x_in), (int)Math.ceil(y_in)));
		Color pixel_right_up=new Color(image.getRGB((int)Math.ceil(x_in), (int)Math.floor(y_in)));
		Color pixel_right_bottom=new Color(image.getRGB((int)Math.ceil(x_in), (int)Math.ceil(y_in)));
		
		double k_x=(x_in-(int)Math.floor(x_in))/(int)(Math.ceil(x_in)-Math.floor(x_in));
		if ((Math.ceil(x_in)-Math.floor(x_in))==0) {
			k_x=0;
		}
		double k_y=(y_in-(int)Math.floor(y_in))/(int)(Math.ceil(y_in)-Math.floor(y_in));
		if ((Math.ceil(y_in)-Math.floor(y_in))==0) {
			k_y=0;
		}
		
		int r_up=(int)Math.rint((pixel_left_up.getRed()*(1-k_x)+pixel_right_up.getRed()*k_x));
		int r_bottom=(int)Math.rint((pixel_left_bottom.getRed()*(1-k_x)+pixel_right_bottom.getRed()*k_x));
		int r=(int)Math.rint(r_up*(1-k_y)+r_bottom*k_y);
		
		int g_up=(int)Math.rint((pixel_left_up.getGreen()*(1-k_x)+pixel_right_up.getGreen()*k_x));
		int g_bottom=(int)Math.rint((pixel_left_bottom.getGreen()*(1-k_x)+pixel_right_bottom.getGreen()*k_x));
		int g=(int)Math.rint(g_up*(1-k_y)+g_bottom*k_y);
		
		int b_up=(int)Math.rint((pixel_left_up.getBlue()*(1-k_x)+pixel_right_up.getBlue()*k_x));
		int b_bottom=(int)Math.rint((pixel_left_bottom.getBlue()*(1-k_x)+pixel_right_bottom.getBlue()*k_x));
		int b=(int)Math.rint(b_up*(1-k_y)+b_bottom*k_y);
		
		Color c=new Color(r, g, b);
				
		return c;		
	}
	
	static public Color getColorInterpolationX(double x_in, double y_in, BufferedImage image) {
		
		Color pixel_left=new Color(image.getRGB((int)Math.floor(x_in), (int)Math.rint(y_in)));
		Color pixel_right=new Color(image.getRGB((int)Math.ceil(x_in), (int)Math.rint(y_in)));		
		
		double k_x=(x_in-(int)Math.floor(x_in))/(int)(Math.ceil(x_in)-Math.floor(x_in));
		if ((Math.ceil(x_in)-Math.floor(x_in))==0) {
			k_x=0;
		}		
		
		int r=(int)Math.rint((pixel_left.getRed()*(1-k_x)+pixel_right.getRed()*k_x));		
		
		int g=(int)Math.rint((pixel_left.getGreen()*(1-k_x)+pixel_right.getGreen()*k_x));		
		
		int b=(int)Math.rint((pixel_left.getBlue()*(1-k_x)+pixel_right.getBlue()*k_x));
				
		Color c=new Color(r, g, b);
				
		return c;		
	}

	static public Color getColorInterpolationY(double x_in, double y_in, BufferedImage image) {
	
		Color pixel_up=new Color(image.getRGB((int)Math.rint(x_in), (int)Math.floor(y_in)));
		Color pixel_bottom=new Color(image.getRGB((int)Math.rint(x_in), (int)Math.ceil(y_in)));	
		
		double k_y=(y_in-(int)Math.floor(y_in))/(int)(Math.ceil(y_in)-Math.floor(y_in));
		if ((Math.ceil(y_in)-Math.floor(y_in))==0) {
			k_y=0;
		}
		
		int r=(int)Math.rint((pixel_up.getRed()*(1-k_y)+pixel_bottom.getRed()*k_y));	
		
		int g=(int)Math.rint((pixel_up.getGreen()*(1-k_y)+pixel_bottom.getGreen()*k_y));	
		
		int b=(int)Math.rint((pixel_up.getBlue()*(1-k_y)+pixel_bottom.getBlue()*k_y));	
		
		Color c=new Color(r, g, b);
				
		return c;		
	}
	
	static public int getCase(double x_in, double y_in, double pixelWidth, double pixelHeight) {
		
		MyPoint pixel=new MyPoint(x_in,y_in);
		MyPoint up_left=new MyPoint(Math.floor(x_in),Math.floor(y_in));
		MyPoint up_right=new MyPoint(Math.ceil(x_in),Math.floor(y_in));
		MyPoint bottom_left=new MyPoint(Math.floor(x_in),Math.ceil(y_in));
		MyPoint bottom_right=new MyPoint(Math.ceil(x_in),Math.ceil(y_in));
		
		MyRectangle rect_up_left=new MyRectangle(up_left, pixelWidth/2,pixelHeight/2);
		MyRectangle rect_up_right=new MyRectangle(up_right.getX()-pixelWidth/2,up_right.getY(), pixelWidth/2,pixelHeight/2);
		MyRectangle rect_bottom_left=new MyRectangle(bottom_left.getX(),bottom_left.getY()-pixelHeight/2, pixelWidth/2,pixelHeight/2);
		MyRectangle rect_bottom_right=new MyRectangle(bottom_right.getX()-pixelWidth/2,bottom_right.getY()-pixelHeight/2, pixelWidth/2,pixelHeight/2);
		
		MyRectangle rect_up=new MyRectangle(up_left.getX()+pixelWidth/2,up_left.getY(), 1-pixelWidth,pixelHeight/2);
		MyRectangle rect_bottom=new MyRectangle(bottom_left.getX()+pixelWidth/2,bottom_left.getY()-pixelHeight/2, 1-pixelWidth,pixelHeight/2);
		
		MyRectangle rect_left=new MyRectangle(up_left.getX(),up_left.getY()+pixelHeight/2, pixelWidth/2,1-pixelHeight);
		MyRectangle rect_right=new MyRectangle(up_right.getX()-pixelWidth/2,up_right.getY()+pixelHeight/2, pixelWidth/2,1-pixelHeight);
		
		MyRectangle rect_center=new MyRectangle(up_left.getX()+pixelWidth/2,up_left.getY()+pixelHeight/2, 1-pixelWidth,1-pixelHeight);
		
		if (rect_up_left.contains(pixel)|rect_up_right.contains(pixel)|rect_bottom_left.contains(pixel)|rect_bottom_right.contains(pixel)) {
			return 1;
		}
		
		if (rect_up.contains(pixel)|rect_bottom.contains(pixel)) {
			return 2;
		}
		
		if (rect_left.contains(pixel)|rect_right.contains(pixel)) {
			return 3;
		}
		
		if (rect_center.contains(pixel)) {
			return 4;
		}
		
		return 0;
		
	}


}
