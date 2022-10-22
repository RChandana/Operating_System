package segmentation;
public class Implementation{
	public void generate_Logical_Address_Space(Segment[] segment){
		for(int i = segment.length - 1; i >= 0; i--){
			segment[i].set_Size(convert_To_Byte(segment[i].get_Size(), segment[i].get_Unit()));
			if(i < 10){
				System.out.println("|  " + i + "   | 0B - " + (segment[i].get_Size() - 1) + "B");
			}
			else
				System.out.println("|  " + i + "  | 0B - " + (segment[i].get_Size() - 1) + "B");
		}
	}
	public void generate_Physical_AddressSpace(Segment[] segment){
		Segment[] temp_Segment = new Segment[segment.length];
		temp_Segment = segment;
		sort(temp_Segment);
		for(int i = temp_Segment.length - 1; i >= 0; i--){
			if(temp_Segment[i].get_Base() != -1){
				temp_Segment[i].set_Limit(convert_To_Byte(temp_Segment[i].get_Limit(), temp_Segment[i].get_Limit_Unit()));
				if(i < 10){
					System.out.println("|  " + temp_Segment[i].get_Base() + "   |");
				}
				else
					System.out.println("|  " + temp_Segment[i].get_Base() + "  |");
			}
		}
	}
	public void calculate_Physical_Address(Segment[] segment, int segmentNo, int offset){
		long base = segment[segmentNo].get_Base();
		long address = base + offset;
		System.out.println("Base address : " + base);
		System.out.println("Physical address : " + address);
	}
	public long convert_To_Byte(long size, String u){
		if(u.equals("kb")){
			size = size * 1024;
		}
		else if(u.equals("mb")){
			size = size * 1024 * 1024;
		}
		else if(u.equals("gb")){
			size = size * 1024 * 1024 * 1024;
		}
		else if(u.equals("tb")){
			size = size * 1024 * 1024 * 1024 * 1024;
		}
		return size;
	}
	public void sort(Segment[] s){
		for(int i = 1; i < s.length; i++){
	        int j = i - 1;
	        Segment key = s[i];
	        while(j >= 0 && s[j].get_Base() > key.get_Base()){
	            s[j + 1] = s[j];
	            j--;
	        }
	        s[j + 1] = key;
	    }
	}
}

