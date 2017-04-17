package com.test170411;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Ball{
	int cnt;
	int redX;
	int redY;
	int blueX;
	int blueY;
	
	public Ball(int cnt, int redX, int redY, int blueX, int blueY){
		this.cnt=cnt;
		this.redX=redX;
		this.redY=redY;
		this.blueX=blueX;
		this.blueY=blueY;
	}
}


public class Q13460_ZZARO {
	static int N, M;
	static char map[][];
	
	static Ball red, blue;
	 
	// ������ �ʴ� ���̱� ������ ���� ����ü �ʿ� ����
	static int holeX, holeY;
	
	//�����¿��
	static int offX[]={-1, 1, 0, 0};
	static int offY[]={0, 0, -1, 1};
	
	static Queue<Ball> q= new LinkedList<Ball>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1. �Է¹ޱ�
		N=sc.nextInt();
		M=sc.nextInt();
		map=new char[N][M];
		
		int rx=0, ry=0, bx=0, by=0; //�ʱ�ȭ ���ϸ� �� ���������� ������ �� ��;;
		
		for(int i=0; i<N; i++){
			String input=sc.next();
			for(int j=0; j<M; j++){
				map[i][j]=input.charAt(j);
				
				//�Էµ� ���� R, B, O�� ��ġ�� ���� ���
				// R�� B�� �׻� ���ÿ� ���� ��ϵǾ�� ��
				if(map[i][j]=='R'){
					rx=i;   ry=j;
				} else if(map[i][j]=='B'){
					bx=i;   by=j;
				} else if(map[i][j]=='O'){
					holeX=i;   holeY=j;
				}
			}
		}
		
		
		
		
		// cnt�� R, B ��ǥ �߰�!
		q.offer(new Ball(0, rx, ry, bx, by));
	
		
		
		int answer=-1;
		
		oneskip:
		while(!q.isEmpty()){
			int cnt=q.peek().cnt;
			int redX=q.peek().redX;
			int redY=q.peek().redY;
			int blueX=q.peek().blueX;
			int blueY=q.peek().blueY;
			q.poll();
			
			// ��ü ���� ����
			if(cnt==10){
				System.out.println(-1);
				break oneskip; 
			}
			
			for(int i=0; i<4; i++){
				// 1. ���� ���� �������� ���
				int rex=0;
				int blue=0;
				int offRx, offRy;
				int redMove=0;
				offRx=redX+offX[i]; // �̵� ������
				offRy=redY+offY[i];
				if(offRx<0 || offRx >=N || offRy<0 || offRy>=M) continue;
				// ��ֹ��� ������ ������ �ִ��� �� �� �ֵ��� �ݺ�
				while(map[offRx][offRy]!='#'){
					redMove++;
					
					//���� �濡 B�� �ִ� ���
					if(offRx==blueX && offRy==blueY)
						blue=redMove;
					//���� �濡 O�� �ִ� ���
					if(map[offRx][offRy]=='O')
						rex=redMove;
					
					//�� �� �� �̵�
					offRx+=offX[i];
					offRy+=offY[i];
				}
				
				
				//2. �Ķ� ���� �������� ���
				boolean bex=false;
				boolean red=false;
				int offBx, offBy;
				int blueMove=0;
				offBx=blueX+offX[i];
				offBy=blueY+offY[i];
				if(offBx<0 || offBx >=N || offBy<0 || offBy>=M) continue;
				// ��ֹ��� ������ ������ �ִ��� �� �� �ֵ��� �ݺ�
				while(map[offBx][offBy]!='#'){
					blueMove++;
					
					//���� �濡 R�� �ִ� ���
					if(offBx==redX && offBy==redY)
						red=true;
					//���� �濡 O�� �ִ� ���
					if(map[offBx][offBy]=='O'){
						bex=true;
					}
					
					//�� �� �� �̵�
					offBx+=offX[i];
					offBy+=offY[i];
				}
				
				
				
				// ���� ���� ������ ���� ���
				if(blue==0 && red==false){
					if(rex!=0){
						answer=cnt+1;
						System.out.println(answer);
						break oneskip;
					}
					else if(bex==true)
						continue;
					else
						q.offer(new Ball(cnt+1, redX+offX[i]*redMove, redY+offY[i]*redMove, blueX+offX[i]*blueMove,  blueY+offY[i]*blueMove));
				}

				// R�� ���� �濡 B�� �ִ� ���
				else if(blue!=0){
					// ������ B���� ���ʿ� �ִ� ��� �ϳ� ���ߵ�
					if(rex!=0){
						if(rex<blue){
							answer=cnt+1;
							System.out.println(answer);
							break oneskip;
						}
						continue;
					}
					else{
						redMove--;
						q.offer(new Ball(cnt+1, redX+offX[i]*redMove, redY+offY[i]*redMove, blueX+offX[i]*blueMove,  blueY+offY[i]*blueMove));
					}
				}
				
				// B�� ���� �濡 R�� �ִ� ���
				else{
					if(rex!=0){
						continue;
					}
					else{
						blueMove--;
						q.offer(new Ball(cnt+1, redX+offX[i]*redMove, redY+offY[i]*redMove, blueX+offX[i]*blueMove,  blueY+offY[i]*blueMove));
					}
				}
			}
		}
			
	}
}
