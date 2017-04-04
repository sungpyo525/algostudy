package com.test170404;

import java.util.Scanner;
import java.io.FileInputStream;

/* ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */

class Code_Halinkwon {
	public static void main(String args[]) throws Exception	{
		/* �Ʒ� �޼ҵ� ȣ���� ������ ǥ���Է�(Ű����) ��� sample_input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   ���� ������ PC ���� �׽�Ʈ �� ����, �Է°��� sample_input.txt�� ������ �� �� �ڵ带 ù �κп� ����ϸ�,
		   ǥ���Է� ��� sample_input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�.
		   ����, ���� PC���� �Ʒ� �޼ҵ带 ������� �ʰ� ǥ���Է��� ����Ͽ� �׽�Ʈ�ϼŵ� �����մϴ�.
		   ��, Codeground �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ�(//) ó�� �ϼž� �մϴ�. */
		//Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
        
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�. �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ� �˴ϴ�.
			
			int n=sc.nextInt();
			int m=sc.nextInt();
			int k= sc.nextInt();
			
			int[][] arrFee= new int[m][3];
			for(int i=0; i<m; i++){
				for(int j=0; j<3; j++){
					arrFee[i][j]=sc.nextInt();
				}
			}
			
			int l=sc.nextInt();
			int[][] arrPath=new int[l][2];
			for(int i=0; i<l; i++){
				for(int j=0; j<2; j++){
					arrPath[i][j]=sc.nextInt();
				}
			}
			
			
			int [][][] arrAvl= new int[n][n][2];
			
			for(int i=0; i<m; i++)
			{
				int x=arrFee[i][0]-1;
				int y=arrFee[i][1]-1;
				int z=arrFee[i][2];
				
				arrAvl[x][y][0]=1;
				arrAvl[x][y][1]=z;
			}
			
			int min;
			int cnt=0;
			
			for(int i=0; i<l; i++){
				int x=arrPath[i][0]-1;
				int y=arrPath[i][1]-1;
				
				if(arrAvl[x][y][0]==1){
					min=arrAvl[x][y][1];
					if(k<min){
						cnt++;
					}
				}else{
					int tmp;
					int tmpMin=99999999;
					
					for(int j=0; j<n; j++) {
						if( arrAvl[x][j][0] == 1) {
							tmp = arrAvl[x][j][1];
							if(arrAvl[j][y][0]==1) {
								tmp = tmp+arrAvl[j][y][1];
								if(tmpMin>tmp) {
									tmpMin=tmp;
								}
							}
						}
							
					}
					if(k < tmpMin) {
						cnt++;
					}
				}
			}

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(cnt);
		}
	}
}