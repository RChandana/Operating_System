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
		
		System.out.println("Main memory size : ");
		temp = sc.next();
		size = convert(temp);
		main_Memory_Size = size;
		String main_Memory_Unit = unit;
		main_Memory_Size = convert_To_Byte(main_Memory_Size, unit);
		System.out.println("LOGICAL ADDRESS SPACE : ");
		ip.generate_Logical_Address_Space(segment);
		System.out.println();
		int x = 0;
		while(true){
			System.out.print("Number of mapping in segment table : ");
			x = sc.nextInt();
			if(x > segment.length)
				System.out.println("Error... number mapping is greater than number of segment.");
			else{
				break;
			}
		}
		
	int flag1 = 0;
		int flag2 = 0;
		long total_Limit = 0;
		while(true){
			System.out.println(" Segment_number Base_address Limit ");
			System.out.println(" .............. ............ ..... ");
			for (int i = 0; i < x; i++) {
				int segment_Number = sc.nextInt();
				if(segment_Number >= segment.length){
					System.out.println("Segment Number is not in the logical memory.");
					clear_Segments(segment);
					flag1 = 1;
					break;
				}
