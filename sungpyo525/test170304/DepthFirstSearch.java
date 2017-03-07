package com.test170304;

import java.util.Scanner;

public class DepthFirstSearch {
	static int vertex;  //������ ����
	static int startVertex; //��������
	static int[][] vertextMap; //���� ��� ��
	static int[] vertexVisit; // ������ �湮 ���θ� ����Ű�� �迭;
	static int vt1, vt2;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vertex = sc.nextInt(); // ������ ���� �Է�
		startVertex=Integer.parseInt(sc.nextLine().trim()); // ������ ���� �Է�
		vertextMap = new int[vertex+1][vertex+1]; // 1�� �÷����ϸ� ������ ������ 0�� �ƴ� 1�� �� ���ִ�.
		vertexVisit= new int[vertex+1]; // ��
		
		while(true){
			vt1=sc.nextInt();
			vt2=sc.nextInt();
			
			
			if(vt1<0 && vt2<0) // �ΰ��� ���� 0���� ���� ���� break
				break; // -1 -1 �Է����ָ� �� �� �������� ����
			
			vertextMap[vt1][vt2]=vertextMap[vt2][vt1]=1; //���� vt2�� vt1�� ����Ǿ����� ǥ��
			//���� ����� �����ϸ� �� ������
		}
		
		dfs(startVertex);
	}


	private static void dfs(int start) {
		vertexVisit[start]=1;
		for(int i=1; i<=vertex; i++){
			// =1 : ���� ������ �Ǿ��ְ�, ==0 : �ȵ�ȴ� ���̸�! 
			if(vertextMap[start][i]==1 && vertexVisit[i]==0){
				// �̵��Ͽ���
				System.out.println(start + "->" + i + "�� �̵��մϴ�.");
				dfs(i);
			}
		}	
	}
}
