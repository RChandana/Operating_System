public class IPC_Banker {
	int p = 7; 
	int r = 4; 
	int need[][] = new int[p][r];
	int [][]max;
	int [][]allocation;
	int []available; 
	int safe_Sequence[] = new int[p];
	void provide_Values(){
		allocation = new int[][] { { 1, 2, 1, 2 },
			{ 1, 0, 0, 3 },
			{ 1, 3, 5, 4 },
			{ 0, 4, 3, 3 },
			{ 0, 0, 1, 4 },
			{ 0, 2, 1, 4 }, 
			{ 3, 2, 1, 0 }
		};
		max = new int[][] { { 2, 2, 1, 2 },
			{ 1, 7, 5, 5 },
			{ 2, 3, 5, 6 },
			{ 0, 6, 5, 4 },
			{ 0, 6, 3, 6 },
			{ 0, 4, 1, 5 },
			{ 3, 3, 3, 3 }
		};

		available = new int[] { 1, 5, 2, 0, 6, 3};
	}

	void check_Safety(){
		int count = 0;
		boolean flag[] = new boolean[p];
		for (int i = 0; i < p; i++){
			flag[i] = false;
		}
		int work[] = new int[r];
		for (int i = 0; i < r; i++){
			work[i] = available[i];
		}

		while (count < p){
			boolean flag1 = false;
			for (int i = 0; i < p; i++){
				if (flag[i] == false){
					int j;
					for (j = 0; j < r; j++){
						if (need[i][j] > work[j])
							break;
					}
					if (j == r){
						safe_Sequence[count++] = i;
						flag[i] = true;
						flag1 = true;

						for (j = 0; j < r; j++){
							work[j] = work[j] + allocation[i][j];
						}
					}
				}
			}
			if (flag1 == false){
				break;
			}
		}
		if (count < p){
			System.out.println("The System is UnSafe!");
		}
		else{
			System.out.println(" The SAFE Sequence is: ");
			for (int i = 0; i < p; i++){
				System.out.print("P" + safe_Sequence[i]);
				if (i != p - 1)
					System.out.print(" -> ");
			}
		}
	}

	void get_Need(){
		for (int i = 0; i < p; i++){
			for (int j = 0; j < r; j++){
				need[i][j] = max[i][j] - allocation[i][j];
			}
		}
	}

	public static void main(String[] args){

		IPC_Banker ba = new IPC_Banker();

		ba.provide_Values();

		ba.get_Need();

		ba.check_Safety();
	}
}
