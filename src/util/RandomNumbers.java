package util;

import java.util.Random;

public class RandomNumbers
{
	private int num = 5;
	private int max = 10;
	private int [] arr = new int[num];


	public static void main(String[] args) {
		RandomNumbers r = new RandomNumbers();
		r.setNumOfItems(32);
		r.createSet();
		r.peek();
	}

	public void createSet()
	{
		Random rand = new Random();

		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(max) + 1;
		}
	}


	public void peek()
	{
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
	}
	public int roll()
	{
		return new Random().nextInt(max+1);
	}
	public int getNumOfItems() {
		return num;
	}

	public void setNumOfItems(int num) {
		this.num = num;
		arr = new int[num];
	}

	public int getMaxValue() {
		return max;
	}

	public void setMaxValue(int max) {
		this.max = max;
	}
}

