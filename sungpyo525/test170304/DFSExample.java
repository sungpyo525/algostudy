package com.test170304;

import java.util.Scanner;

public class DFSExample {
	static int [][] map; // map�� ��Ÿ���� �迭
	//static int [][] visited; // 0�� 1�� �̵� ������ ó���Ұ��̱� ������ �ʿ� ����
	static int map_size; // map�� ������
	static int min; // �ִ� �Ÿ�
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map_size= sc.nextInt();// map�� ����� �Է¹޴´�.
		map=new int[map_size][map_size];
		
		// �ϴ� map�� �迭�� ũ�⸦ �Է¹��� map_sizeũ��� �����.
		//		(��� ��θ� ���ƴٳ൵ n*n�̱� ������, �ּҰ��� �ִ�ġ�� �ȴ�.)
		min = map_size * map_size; 
		
		// �̵��� �� �ִ� path�� �Է¹ޱ����� for�� ���
		for(int i=0; i<map_size; i++){
			for(int j=0; j<map_size; j++){
				map[i][j]=sc.nextInt();
			}
		}
		depthfirstSearch(0,0,1);
		
		System.out.println("�ִ� �Ÿ� : " + min);
	}


	
	
	//dfs �˰��� ����
	private static void depthfirstSearch(int x, int y, int length) {
		if(x==map_size-1 && y==map_size-1){
			if(min>length) min=length;
			return;
		}
		
		map[x][y]=0;
		
		//�������� �̵��� ���
		if(x>0 && map[x-1][y]==1)
			depthfirstSearch(x-1, y, length+1);
		
		//���������� �̵��� ���
		if(x<map_size-1&& map[x+1][y]==1)
			depthfirstSearch(x+1, y, length+1);
		
		//�Ʒ��� �̵��� ���
		if(y<map_size-1 && map[x][y+1]==1)
			depthfirstSearch(x, y+1, length+1);
		
		//���� �̵��� ���
		if(y>0 && map[x][y-1]==1)
			depthfirstSearch(x, y-1, length+1);
		
		map[x][y]=1;
		
	}
}
