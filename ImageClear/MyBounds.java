package ImageClear;

import java.util.ArrayList;

//Alexey Dubrovinskiy
//alexey.dubrovinskiy@rambler.ru
//April 08, 2018

public class MyBounds {
	
	private ArrayList<MyPoint> left_up;
	private ArrayList<MyPoint> right_bottom;		
	
	public MyBounds() {
		left_up= new ArrayList<MyPoint>();
		right_bottom= new ArrayList<MyPoint>();
	}	

	public MyPoint getLeft_up(int index) {
		return left_up.get(index);
	}

	public void addLeft_up(MyPoint left_up) {
		this.left_up.add(left_up);
	}
	
	public void addLeft_up(int index,MyPoint left_up) {
		this.left_up.add(index, left_up);
	}

	public MyPoint getRight_bottom(int index) {
		return right_bottom.get(index);
	}

	public void addRight_bottom(MyPoint right_bottom) {
		this.right_bottom.add(right_bottom);
	}
	
	public void addRight_bottom(int index,MyPoint right_bottom) {
		this.right_bottom.add(index, right_bottom);
	}
	
	public int size() {
		
		if (left_up.size()==right_bottom.size()) {
			return left_up.size();
		}else {
			System.err.println("в файле bounds.txt должно быть одинаковое количество координат для верхнего левого угла и нижнего правого угла");
			System.exit(0);
		}
		
		return 0;
	}
	
	
	
}
