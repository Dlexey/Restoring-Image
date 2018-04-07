package ImageClear;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.Scanner;

import javax.imageio.*;

import static ImageClear.ColorMaster.*;


//Alexey Dubrovinskiy
//alexey.dubrovinskiy@rambler.ru
//April 08, 2018


public class ImageStart {

	public static void main(String[] args) throws IOException {
		
		File folder = new File(".");
		String[] files = folder.list();
		
		//------------------------------------- начинаем искать входной файл -------------------------------------------------------------
		int count=0;
		for (int i=0;i<files.length;i++) {
			if (files[i].startsWith("in.")){
				count++;
			}
		}
		
		if (count==0) {
			System.err.println("Ошибка: В папке должен присутствовать входной файл типа in.jpg или любого другого формата");
			System.exit(0);
		}
		
		if (count>1) {
			System.err.println("Ошибка: Входной файл типа in.jpg должен быть в единственном экземпляре");
			System.exit(0);
		}
		
		File file_in=null;
		if (count==1) {			
			for (int i=0;i<files.length;i++) {
				if (files[i].startsWith("in.")){
					file_in = new File(files[i]);
				}
			}			
		}
		//------------------------------------------ начинаем искать color_mask --------------------------------------------------------
		
		count=0;
		for (int i=0;i<files.length;i++) {
			if (files[i].startsWith("color_mask.")){
				count++;
			}
		}
		
		if (count==0) {
			System.err.println("Ошибка: В папке должен присутствовать  файл типа color_mask.jpg или любого другого формата");
			System.exit(0);
		}
		
		if (count>1) {
			System.err.println("Ошибка: Входной файл типа color_mask.jpg должен быть в единственном экземпляре");
			System.exit(0);
		}
		
		File file_color_mask=null;
		if (count==1) {			
                    for (String file : files) {
                        if (file.startsWith("color_mask.")) {
                            file_color_mask = new File(file);
                        }
                    }			
		}	
		//------------------------------------------------------------------------------------------------------------------------------
		
		BufferedImage image_in = ImageIO.read(file_in);	
		
		File file_out = new File("./out.png");
		BufferedImage image_color_mask = ImageIO.read(file_color_mask);		
		
		//----------------------------------------------------- читаем файл bounds.txt ---------------------------------------------------------------
		MyBounds bounds=new MyBounds();
		
		File file = new File("./bounds.txt");
		try (Scanner in = new Scanner(file)) {
                        int i=0;
			while(in.hasNextLine()) {	
                            i++;
				String str= in.nextLine();
				if (!str.trim().isEmpty()) {
					String[] stuff=str.split(":");
					String[] stuff_left_up=stuff[0].split(",");
					String[] stuff_right_bottom=stuff[1].split(",");
					MyPoint left_up=new MyPoint();
					MyPoint right_bottom=new MyPoint();	
					try {
						left_up.setLocation(Double.parseDouble(stuff_left_up[0]), Double.parseDouble(stuff_left_up[1]));
						right_bottom.setLocation(Double.parseDouble(stuff_right_bottom[0]), Double.parseDouble(stuff_right_bottom[1]));
					}catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                                            System.err.println("Ошибка: Неверный формат числа в файле bounds.txt");
                                            System.err.println("Номер строки: "+i);
                                            System.err.println("Значение строки: "+str);
                                            System.exit(0);
                                        }
					bounds.addLeft_up(left_up);
					bounds.addRight_bottom(right_bottom);					
				}				
			}						
		} catch (FileNotFoundException e) {			
			System.err.println("Ошибка: Файл bounds.txt не найден");
			System.exit(0);
		}	
		//---------------------------------------------------- прочитали файл bounds.txt ------------------------------------------------------------
            //---------------------------------------------------- прочитали файл bounds.txt ------------------------------------------------------------
		
		
		double pixelWidth=(double)image_color_mask.getWidth()/(double)image_in.getWidth();
		double pixelHeight=(double)image_color_mask.getHeight()/(double)image_in.getHeight();	
		
		for (int b=0;b<bounds.size();b++) {
			for(double x=bounds.getLeft_up(b).getX();x<bounds.getRight_bottom(b).getX()+1;x++) {
				for(double y=bounds.getLeft_up(b).getY();y<bounds.getRight_bottom(b).getY()+1;y++) {					
									
					double x_in=x*pixelWidth;
					double y_in=y*pixelHeight;
                                        
                                        
					
					Color c=null;					
					
					switch(getCase(x_in, y_in, pixelWidth, pixelHeight)) {
					case 1:
						c=getColor(x_in,y_in,image_color_mask);
						break;
					case 2:
						c=getColorInterpolationY_Up(x_in, y_in, image_color_mask);
						break;
					case 3:
						c=getColorInterpolationY_Bottom(x_in, y_in, image_color_mask);
						break;
					case 4:
						c=getColorInterpolationX_Left(x_in, y_in, image_color_mask);
						break;	
                                        case 5:
						c=getColorInterpolationX_Right(x_in, y_in, image_color_mask);
						break;
                                        case 6:
						c=getColorInterpolationXY_Up_Left(x_in, y_in, image_color_mask);
						break;	
                                        case 7:
						c=getColorInterpolationXY_Up_Right(x_in, y_in, image_color_mask);
						break;	
                                        case 8:
						c=getColorInterpolationXY_Bottom_Left(x_in, y_in, image_color_mask);
						break;	
                                        case 9:
						c=getColorInterpolationXY_Bottom_Right(x_in, y_in, image_color_mask);
						break;	
					}					
					image_in.setRGB((int)x, (int)y, c.getRGB());	
					//image_in.setRGB((int)x, (int)y, 0);	
				}			
			}	
		}				
		ImageIO.write(image_in, "png", file_out);		
	}
}
	
	
