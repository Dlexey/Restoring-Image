package ImageClear;

import java.awt.Color;
import java.awt.image.BufferedImage;

//Alexey Dubrovinskiy
//alexey.dubrovinskiy@rambler.ru
//April 08, 2018

public final class ColorMaster {
	
	static public Color getColor(double x_in, double y_in, BufferedImage image) {		
		
		return new Color(image.getRGB((int)Math.floor(x_in), (int)Math.floor(y_in)));		
	}
	
	static public Color getColorInterpolationXY_Up_Left(double x_in, double y_in, BufferedImage image) {
		
                int x=(int)Math.floor(x_in)-1;
                if(x<0)x=(int)Math.floor(x_in);
                
                int y=(int)Math.floor(y_in)-1;
                if(y<0)y=(int)Math.floor(y_in);
                               
                MyPoint p=new MyPoint((int)Math.floor(x_in), (int)Math.floor(y_in));
                p.move(0.5, 0.5);
                                
                Color pixel_left=new Color(image.getRGB(x, (int)Math.floor(y_in)));
		Color pixel=new Color(image.getRGB((int)Math.floor(x_in), (int)Math.floor(y_in)));	
                
                Color pixel_up=new Color(image.getRGB((int)Math.floor(x_in), y));
		Color pixel_up_left=new Color(image.getRGB(x,y));
                
                double k_x=p.getX()-x_in;
                double k_y=p.getY()-y_in;                         
		
                int r_up=(int)Math.rint(pixel_up.getRed()*(1-k_x)+pixel_up_left.getRed()*k_x);
                int r_bottom=(int)Math.rint(pixel.getRed()*(1-k_x)+pixel_left.getRed()*k_x);
                int r=(int)Math.rint(r_up*k_y+r_bottom*(1-k_y));	
                
                int g_up=(int)Math.rint(pixel_up.getGreen()*(1-k_x)+pixel_up_left.getGreen()*k_x);
                int g_bottom=(int)Math.rint(pixel.getGreen()*(1-k_x)+pixel_left.getGreen()*k_x);
                int g=(int)Math.rint(g_up*k_y+g_bottom*(1-k_y));	
                
                int b_up=(int)Math.rint(pixel_up.getBlue()*(1-k_x)+pixel_up_left.getBlue()*k_x);
                int b_bottom=(int)Math.rint(pixel.getBlue()*(1-k_x)+pixel_left.getBlue()*k_x);
                int b=(int)Math.rint(b_up*k_y+b_bottom*(1-k_y));	                
                
		Color c=new Color(r,g,b);		
				
		return c;		
	}
        
        static public Color getColorInterpolationXY_Up_Right(double x_in, double y_in, BufferedImage image) {
		
                int x=(int)Math.floor(x_in)+1;
                if(x==image.getWidth())x=(int)Math.floor(x_in);
                
                int y=(int)Math.floor(y_in)-1;
                if(y<0)y=(int)Math.floor(y_in);
                
               
                MyPoint p=new MyPoint((int)Math.floor(x_in), (int)Math.floor(y_in));
                                
                Color pixel_right=new Color(image.getRGB(x, (int)Math.floor(y_in)));
		Color pixel=new Color(image.getRGB((int)Math.floor(x_in), (int)Math.floor(y_in)));	
                
                Color pixel_up=new Color(image.getRGB((int)Math.floor(x_in), y));
		Color pixel_up_right=new Color(image.getRGB(x,y));
                
                p.move(0.5, 0.5);
                
                double k_x=x_in-p.getX();
                double k_y=p.getY()-y_in;                         
		
                int r_up=(int)Math.rint(pixel_up.getRed()*(1-k_x)+pixel_up_right.getRed()*k_x);
                int r_bottom=(int)Math.rint(pixel.getRed()*(1-k_x)+pixel_right.getRed()*k_x);
                int r=(int)Math.rint(r_up*k_y+r_bottom*(1-k_y));	
                
                int g_up=(int)Math.rint(pixel_up.getGreen()*(1-k_x)+pixel_up_right.getGreen()*k_x);
                int g_bottom=(int)Math.rint(pixel.getGreen()*(1-k_x)+pixel_right.getGreen()*k_x);
                int g=(int)Math.rint(g_up*k_y+g_bottom*(1-k_y));	
                
                int b_up=(int)Math.rint(pixel_up.getBlue()*(1-k_x)+pixel_up_right.getBlue()*k_x);
                int b_bottom=(int)Math.rint(pixel.getBlue()*(1-k_x)+pixel_right.getBlue()*k_x);
                int b=(int)Math.rint(b_up*k_y+b_bottom*(1-k_y));	 
                
		Color c=new Color(r,g,b);		
				
		return c;		
	}
        
        static public Color getColorInterpolationXY_Bottom_Left(double x_in, double y_in, BufferedImage image) {
		
                int x=(int)Math.floor(x_in)-1;
                if(x<0)x=(int)Math.floor(x_in);
                
                int y=(int)Math.floor(y_in)+1;
                if(y==image.getHeight())y=(int)Math.floor(y_in);
                
                
                MyPoint p=new MyPoint((int)Math.floor(x_in), (int)Math.floor(y_in));
                
                
                Color pixel_left=new Color(image.getRGB(x, (int)Math.floor(y_in)));
		Color pixel=new Color(image.getRGB((int)Math.floor(x_in), (int)Math.floor(y_in)));	
                
                Color pixel_bottom=new Color(image.getRGB((int)Math.floor(x_in), y));
		Color pixel_bottom_left=new Color(image.getRGB(x,y));
                
                p.move(0.5, 0.5);
                
                double k_x=p.getX()-x_in;
                double k_y=y_in-p.getY();                         
		
                int r_bottom=(int)Math.rint(pixel_bottom.getRed()*(1-k_x)+pixel_bottom_left.getRed()*k_x);
                int r_up=(int)Math.rint(pixel.getRed()*(1-k_x)+pixel_left.getRed()*k_x);
                int r=(int)Math.rint(r_up*(1-k_y)+r_bottom*k_y);	
                
                int g_bottom=(int)Math.rint(pixel_bottom.getGreen()*(1-k_x)+pixel_bottom_left.getGreen()*k_x);
                int g_up=(int)Math.rint(pixel.getGreen()*(1-k_x)+pixel_left.getGreen()*k_x);
                int g=(int)Math.rint(g_up*(1-k_y)+g_bottom*k_y);	
                
                int b_bottom=(int)Math.rint(pixel_bottom.getBlue()*(1-k_x)+pixel_bottom_left.getBlue()*k_x);
                int b_up=(int)Math.rint(pixel.getBlue()*(1-k_x)+pixel_left.getBlue()*k_x);
                int b=(int)Math.rint(b_up*(1-k_y)+b_bottom*k_y);	                
                
		Color c=new Color(r,g,b);		
				
		return c;		
	}
        
        static public Color getColorInterpolationXY_Bottom_Right(double x_in, double y_in, BufferedImage image) {
		
                int x=(int)Math.floor(x_in)+1;
                if(x==image.getWidth())x=(int)Math.floor(x_in);
                
                int y=(int)Math.floor(y_in)+1;
                if(y==image.getHeight())y=(int)Math.floor(y_in);
                                
                MyPoint p=new MyPoint((int)Math.floor(x_in), (int)Math.floor(y_in));                
                
                Color pixel_right=new Color(image.getRGB(x, (int)Math.floor(y_in)));
		Color pixel=new Color(image.getRGB((int)Math.floor(x_in), (int)Math.floor(y_in)));	
                
                Color pixel_bottom=new Color(image.getRGB((int)Math.floor(x_in), y));
		Color pixel_bottom_right=new Color(image.getRGB(x,y));
                
                p.move(0.5, 0.5);
                
                double k_x=x_in-p.getX();
                double k_y=y_in-p.getY();                         
		
                int r_bottom=(int)Math.rint(pixel_bottom.getRed()*(1-k_x)+pixel_bottom_right.getRed()*k_x);
                int r_up=(int)Math.rint(pixel.getRed()*(1-k_x)+pixel_right.getRed()*k_x);
                int r=(int)Math.rint(r_up*(1-k_y)+r_bottom*k_y);	
                
                int g_bottom=(int)Math.rint(pixel_bottom.getGreen()*(1-k_x)+pixel_bottom_right.getGreen()*k_x);
                int g_up=(int)Math.rint(pixel.getGreen()*(1-k_x)+pixel_right.getGreen()*k_x);
                int g=(int)Math.rint(g_up*(1-k_y)+g_bottom*k_y);	
                
                int b_bottom=(int)Math.rint(pixel_bottom.getBlue()*(1-k_x)+pixel_bottom_right.getBlue()*k_x);
                int b_up=(int)Math.rint(pixel.getBlue()*(1-k_x)+pixel_right.getBlue()*k_x);
                int b=(int)Math.rint(b_up*(1-k_y)+b_bottom*k_y);	   
                
		Color c=new Color(r,g,b);		
				
		return c;		
	}
	
	static public Color getColorInterpolationX_Left(double x_in, double y_in, BufferedImage image) {
            
                int x=(int)Math.floor(x_in)-1;
                if(x<0)x=(int)Math.floor(x_in);
                		
		Color pixel_left=new Color(image.getRGB(x, (int)Math.floor(y_in)));
		Color pixel_right=new Color(image.getRGB((int)Math.floor(x_in), (int)Math.floor(y_in)));		
		
		double k_x=((int)Math.floor(x_in)+0.5-x_in);				
		
		int r=(int)Math.rint((pixel_left.getRed()*k_x+pixel_right.getRed()*(1-k_x)));		
		
		int g=(int)Math.rint((pixel_left.getGreen()*k_x+pixel_right.getGreen()*(1-k_x)));		
		
		int b=(int)Math.rint((pixel_left.getBlue()*k_x+pixel_right.getBlue()*(1-k_x)));
				
		Color c=new Color(r,g,b);
				
		return c;		
	}
        
        static public Color getColorInterpolationX_Right(double x_in, double y_in, BufferedImage image) {
            
                int x=(int)Math.floor(x_in)+1;
                if(x==image.getWidth())x=(int)Math.floor(x_in);
                		
		Color pixel_right=new Color(image.getRGB(x, (int)Math.floor(y_in)));
		Color pixel_left=new Color(image.getRGB((int)Math.floor(x_in), (int)Math.floor(y_in)));		
		
		double k_x=(x_in-(int)Math.floor(x_in)-0.5);				
		
		int r=(int)Math.rint((pixel_left.getRed()*(1-k_x)+pixel_right.getRed()*k_x));		
		
		int g=(int)Math.rint((pixel_left.getGreen()*(1-k_x)+pixel_right.getGreen()*k_x));		
		
		int b=(int)Math.rint((pixel_left.getBlue()*(1-k_x)+pixel_right.getBlue()*k_x));
				
		Color c=new Color(r,g,b);
				
		return c;		
	}        

        static public Color getColorInterpolationY_Up(double x_in, double y_in, BufferedImage image) {
            
                int y=(int)Math.floor(y_in)-1;
                if(y<0)y=(int)Math.floor(y_in);
                		
		Color pixel_up=new Color(image.getRGB((int)Math.floor(x_in), y));
		Color pixel_bottom=new Color(image.getRGB((int)Math.floor(x_in), (int)Math.floor(y_in)));		
		
		double k_y=((int)Math.floor(y_in)+0.5-y_in);				
		
		int r=(int)Math.rint((pixel_up.getRed()*k_y+pixel_bottom.getRed()*(1-k_y)));		
		
		int g=(int)Math.rint((pixel_up.getGreen()*k_y+pixel_bottom.getGreen()*(1-k_y)));		
		
		int b=(int)Math.rint((pixel_up.getBlue()*k_y+pixel_bottom.getBlue()*(1-k_y)));
				
		Color c=new Color(r,g,b);
				
		return c;		
	}
        
        static public Color getColorInterpolationY_Bottom(double x_in, double y_in, BufferedImage image) {
            
                int y=(int)Math.floor(y_in)+1;
                if(y==image.getHeight())y=(int)Math.floor(y_in);
                		
		Color pixel_bottom=new Color(image.getRGB((int)Math.floor(x_in), y));
		Color pixel_up=new Color(image.getRGB((int)Math.floor(x_in), (int)Math.floor(y_in)));		
		
		double k_y=(y_in-(int)Math.floor(y_in)-0.5);				
		
		int r=(int)Math.rint((pixel_up.getRed()*(1-k_y)+pixel_bottom.getRed()*k_y));		
		
		int g=(int)Math.rint((pixel_up.getGreen()*(1-k_y)+pixel_bottom.getGreen()*k_y));		
		
		int b=(int)Math.rint((pixel_up.getBlue()*(1-k_y)+pixel_bottom.getBlue()*k_y));
				
		Color c=new Color(r,g,b);
				
		return c;		
	}
	
	static public int getCase(double x_in, double y_in, double pixelWidth, double pixelHeight) {
		
		MyPoint pixel=new MyPoint(x_in,y_in);
		MyPoint up_left=new MyPoint(Math.floor(x_in),Math.floor(y_in));
		MyPoint up_right=new MyPoint(Math.ceil(x_in),Math.floor(y_in));
		MyPoint bottom_left=new MyPoint(Math.floor(x_in),Math.ceil(y_in));
		MyPoint bottom_right=new MyPoint(Math.ceil(x_in),Math.ceil(y_in));
		
		MyRectangle rect_up_left=new MyRectangle(up_left, 0.5-pixelWidth/2,0.5-pixelHeight/2);
		MyRectangle rect_up_right=new MyRectangle(up_right.getX()-0.5+pixelWidth/2,up_right.getY(), 0.5-pixelWidth/2,0.5-pixelHeight/2);
		MyRectangle rect_bottom_left=new MyRectangle(bottom_left.getX(),bottom_left.getY()-0.5+pixelHeight/2, 0.5-pixelWidth/2,0.5-pixelHeight/2);
		MyRectangle rect_bottom_right=new MyRectangle(bottom_right.getX()-0.5+pixelWidth/2,bottom_right.getY()-0.5+pixelHeight/2, 0.5-pixelWidth/2,0.5-pixelHeight/2);
		
		MyRectangle rect_up=new MyRectangle(up_left.getX()+0.5-pixelWidth/2,up_left.getY(), pixelWidth,0.5-pixelHeight/2);
		MyRectangle rect_bottom=new MyRectangle(bottom_left.getX()+0.5-pixelWidth/2,bottom_left.getY()-0.5+pixelHeight/2, pixelWidth,0.5-pixelHeight/2);
		
		MyRectangle rect_left=new MyRectangle(up_left.getX(),up_left.getY()+0.5-pixelHeight/2, 0.5-pixelWidth/2,pixelHeight);
		MyRectangle rect_right=new MyRectangle(up_right.getX()-0.5+pixelWidth/2,up_right.getY()+0.5-pixelHeight/2, 0.5-pixelWidth/2,pixelHeight);
		
		MyRectangle rect_center=new MyRectangle(up_left.getX()+0.5-pixelWidth/2,up_left.getY()+0.5-pixelHeight/2, pixelWidth,pixelHeight);
		
                if (rect_center.contains(pixel)) {
			return 1;
		}	
		
		if (rect_up.contains(pixel)) {
			return 2;
		}
                
                if (rect_bottom.contains(pixel)) {
			return 3;
		}
		
		if (rect_left.contains(pixel)) {
			return 4;
		}
                
                if (rect_right.contains(pixel)) {
			return 5;
		}
                
                if (rect_up_left.contains(pixel)) {
			return 6;
		}
                
                if (rect_up_right.contains(pixel)) {
			return 7;
		}
                
                if (rect_bottom_left.contains(pixel)) {
			return 8;
		}
                
                if (rect_bottom_right.contains(pixel)) {
			return 9;
		}           
		
		return 0;
		
	}


}
