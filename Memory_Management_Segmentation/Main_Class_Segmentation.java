package segmentation;
import java.util.Scanner;

public class MainClass_Segmentation{
	static String unit = " ";
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("SEGMENTATION");
		System.out.println("------------");
		System.out.println("Byte = b, Kilobyte = kb, Megabyte = mb, Gigabyte = gb, Terabyte = tb");
		System.out.print("Number of Segments : ");
		Implementation ip = new Implementation();
		int num_Of_Segment = sc.nextInt();
		Segment[] segment = new Segment[num_Of_Segment];
		
		String temp = null;
		long size = 0;
		long main_Memory_Size = 0;
		for(int i = 0; i < num_Of_Segment; i++){
			segment[i] = new Segment();
			System.out.print("Size of segment " + i + " : ");
			temp = sc.next();
			size = convert(temp);
			segment[i].set_Size(size);
			segment[i].set_Unit(unit);
		}
