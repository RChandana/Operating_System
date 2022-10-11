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
