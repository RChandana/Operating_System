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
				
				else{
					long base_Address = sc.nextLong();
					String y = sc.next();
					long limit = convert(y);
					System.out.println(segment_Number);
					segment[segment_Number].set_Base(base_Address);
					segment[segment_Number].set_Limit(limit);
					segment[segment_Number].set_Limit_Unit(unit);
					if(unit.equals("kb")){
						segment[segment_Number].limit = segment[segment_Number].limit * 1024;
					}
					else if(unit.equals("mb")){
						segment[segment_Number].limit = segment[segment_Number].limit * 1024 * 1024;
					}
					else if(unit.equals("gb")){
						segment[segment_Number].limit = segment[segment_Number].limit * 1024 * 1024 * 1024;
					}
					else if(unit.equals("tb")){
						segment[segment_Number].limit = segment[segment_Number].limit * 1024 * 1024 * 1024 * 1024;
					}
					
					long temp_Limit = segment[segment_Number].limit;
					long temp_Base = segment[segment_Number].get_Base();
					long max = temp_Limit + temp_Base;
					if(temp_Limit < segment[segment_Number].get_Size()){
						System.out.println("Error at segment " + segment_Number + "... Limit of a segment can not be less than it's size.");
						flag1 = 1;
						clear_Segments(segment);
						break;
					}
					total_Limit += temp_Limit;
					for(int j = 0; j < segment.length; j++){
						if(j != segment_Number){
							long checkLimit = segment[j].get_Limit();
							long checkBase = segment[j].get_Base();
							long checkMax = checkLimit + checkBase;
							if(temp_Base > checkMax || max < checkBase){	
							}
							else{
								System.out.println("Error... Address overlapped between " + j + " and " + segment_Number + " segment.");
								flag1 = 1;
								flag2 = 1;
								clear_Segments(segment);
								break;
							}
						}
					}
				}
				if(flag2 == 1){
					flag2 = 0;
					break;
				}
			}
			if(total_Limit > main_Memory_Size){
				total_Limit = 0;
				flag1 = 1;
				clear_Segments(segment);
			}
			if(flag1 == 0)
				break;
			flag1 = 0;
		}
					
		System.out.println("PHYSICAL ADDRESS SPACE:");
		ip.generate_Physical_AddressSpace(segment);
		System.out.println();
		int segment_Number;
		int offset;
		flag1 = 0;
		while (true) {
			System.out.print("Segment No: ");
			segment_Number = sc.nextInt();
			System.out.print("Offset: ");
			offset = sc.nextInt();
			System.out.println();
			if(segment[segment_Number].get_Size() == -1){
				System.out.println("Segment not found in the segment table.");
				flag1 = 1;
			}
			if(segment[segment_Number].get_Size() <= offset ){
				System.out.println("Error... Offset is not valid.");
				flag1 = 1;
			}	
			if(flag1 == 0)
				break;
			flag1 = 0;
		}	
		ip.calculate_Physical_Address(segment, segment_Number, offset);
		sc.close();
	}
