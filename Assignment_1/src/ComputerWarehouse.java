
class Computer {

	protected int length, width, height;

	public Computer() {
		this.length = 0;
		this.height = 0;
		this.width = 0;
	}

	public static float sumThreeVolumes(Object o1, Object o2, Object o3) {

		Computer c1 = (Computer) o1;

		Computer c2 = (Computer) o2;

		Computer c3 = (Computer) o3;

		double c1Volume = c1.getClass().getName().equals("WorkStation") ? (c1.length * c1.height * c1.width)
				: 2 * (c1.length * c1.height * c1.width);
		double c2Volume = c2.getClass().getName().equals("WorkStation") ? (c2.length * c2.height * c1.width)
				: 2 * (c2.length * c2.height * c2.width);
		double c3Volume = c3.getClass().getName().equals("WorkStation") ? (c3.length * c3.height * c3.width)
				: 2 * (c3.length * c3.height * c3.width);
		return (float) (c1Volume + c2Volume + c3Volume);

	}

	public String toString() {
		return "Computer with the following length, width, height : [ " + this.length + "," + this.width + ","
				+ this.height + "]";
	}

}

class Laptop extends Computer {

	protected String screenType;

	public Laptop() {
		this.length = 30;
		this.width = 20;
		this.height = 5;
		this.screenType = "seperate";
	}

	public String toString() {
		return "Laptop with the following length, width, height,screen_type" + " : [ " + this.length + "," + this.width
				+ "," + this.height + "," + this.screenType + "]";
	}
}

class Desktop extends Computer {

	protected String screenType;

	public Desktop() {
		this.length = 50;
		this.width = 30;
		this.height = 45;
		this.screenType = "attached";
	}

	public String toString() {
		return "Desktop with the following length, width, height,screen_type" + " : [ " + this.length + "," + this.width
				+ "," + this.height + "," + this.screenType + "]";
	}
}

class WorkStation extends Desktop {

	protected int volumeMultiplier;

	public WorkStation() {
		this.length = 50;
		this.width = 30;
		this.height = 45;
		this.volumeMultiplier = 2;
	}

	public String toString() {
		return "WorkStation with the following length, width, height,screen_type" + ",volume_multiplier : [ "
				+ this.length + "," + this.width + "," + this.height + "," + this.screenType + ","
				+ this.volumeMultiplier + "]";
	}
}

class DellLaptop extends Laptop {

	private String brand;

	public DellLaptop() {
		this.length = 35;
		this.width = 25;
		this.height = 10;
		this.brand = "dell";
	}

	public String toString() {
		return "Dell Laptop with the following length, width, height,brand, screen_type" + "[ " + this.length + ","
				+ this.width + "," + this.height + "," + this.brand + "," + this.screenType + "]";
	}

}

class AlienDesktop extends WorkStation {

	private String brand;

	public AlienDesktop() {
		this.length = 60;
		this.width = 40;
		this.height = 50;
		this.brand = "Alien";
	}

	public String toString() {
		return "Alien Desktop with the following length, width, height,screen_type" + ",volume_multiplier, brand : [ "
				+ this.length + "," + this.width + "," + this.height + "," + this.screenType + ","
				+ this.volumeMultiplier + "," + this.brand + "]";
	}

}

public class ComputerWarehouse {

	public static void FindBiggestRow(Computer c[][]) {
		
		float maxSum = Float.MIN_VALUE;
		int maxSumRow = 0;
		for(int i=0;i<c.length;i++)
		{
			float currentRowVolume = Computer.sumThreeVolumes(c[i][0], c[i][1], c[i][2]);
			System.out.println("Row "+i+" has the total volume of "+currentRowVolume);
			if(currentRowVolume > maxSum)
			{
				maxSum = currentRowVolume;
				maxSumRow = i; 
			}
		}
		
		System.out.println("Row "+maxSumRow+" has the largest volume!");

	}

	public static void main(String[] args) {
		Computer computers[][] = new Computer[10][3];
		System.out.println("Created a "+computers.length+" x 3 matrix\nGenerating "+computers.length*computers[0].length+" Computer Obecs and placing them in an array\n\n");
		for (int i = 0; i < computers.length; i++) {
			for (int j = 0; j < computers[i].length; j++) {
				int random_value = (int) (Math.random() * 6);
				switch (random_value) {
				case 0:
					computers[i][j] = new Laptop();
					break;
				case 1:
					computers[i][j] = new Desktop();
					break;
				case 2:
					computers[i][j] = new WorkStation();
					break;
				case 3:
					computers[i][j] = new DellLaptop();
					break;
				case 4:
					computers[i][j] = new AlienDesktop();
					break;
				case 5:
					computers[i][j] = new Computer();
					break;

				}
			}
		}

		for(int i=0;i<computers.length;i++)
		{
			System.out.println("Printing Row "+i+" values\n***************************************");
			for(int j=0;j<computers[i].length;j++)
			{
				System.out.println(computers[i][j].toString()+" ");
			}
			System.out.println();
		}
		

		FindBiggestRow(computers);
	}

}