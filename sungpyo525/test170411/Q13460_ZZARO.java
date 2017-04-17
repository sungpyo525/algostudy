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
	 
	// 변하지 않는 값이기 때문에 따로 구조체 필요 없음
	static int holeX, holeY;
	
	//상하좌우순
	static int offX[]={-1, 1, 0, 0};
	static int offY[]={0, 0, -1, 1};
	
	static Queue<Ball> q= new LinkedList<Ball>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1. 입력받기
		N=sc.nextInt();
		M=sc.nextInt();
		map=new char[N][M];
		
		int rx=0, ry=0, bx=0, by=0; //초기화 안하면 왜 오류나는지 몰겠음 ㅡ ㅡ;;
		
		for(int i=0; i<N; i++){
			String input=sc.next();
			for(int j=0; j<M; j++){
				map[i][j]=input.charAt(j);
				
				//입력된 값의 R, B, O의 위치는 따로 기억
				// R과 B는 항상 동시에 값이 기록되어야 함
				if(map[i][j]=='R'){
					rx=i;   ry=j;
				} else if(map[i][j]=='B'){
					bx=i;   by=j;
				} else if(map[i][j]=='O'){
					holeX=i;   holeY=j;
				}
			}
		}
		
		
		
		
		// cnt와 R, B 좌표 추가!
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
			
			// 전체 종료 조건
			if(cnt==10){
				System.out.println(-1);
				break oneskip; 
			}
			
			for(int i=0; i<4; i++){
				// 1. 빨간 공이 굴러가는 경우
				int rex=0;
				int blue=0;
				int offRx, offRy;
				int redMove=0;
				offRx=redX+offX[i]; // 이동 오프셋
				offRy=redY+offY[i];
				if(offRx<0 || offRx >=N || offRy<0 || offRy>=M) continue;
				// 장애물이 나오기 전까지 최대한 갈 수 있도록 반복
				while(map[offRx][offRy]!='#'){
					redMove++;
					
					//가는 길에 B가 있는 경우
					if(offRx==blueX && offRy==blueY)
						blue=redMove;
					//가는 길에 O가 있는 경우
					if(map[offRx][offRy]=='O')
						rex=redMove;
					
					//그 후 또 이동
					offRx+=offX[i];
					offRy+=offY[i];
				}
				
				
				//2. 파란 공이 굴러가는 경우
				boolean bex=false;
				boolean red=false;
				int offBx, offBy;
				int blueMove=0;
				offBx=blueX+offX[i];
				offBy=blueY+offY[i];
				if(offBx<0 || offBx >=N || offBy<0 || offBy>=M) continue;
				// 장애물이 나오기 전까지 최대한 갈 수 있도록 반복
				while(map[offBx][offBy]!='#'){
					blueMove++;
					
					//가는 길에 R이 있는 경우
					if(offBx==redX && offBy==redY)
						red=true;
					//가는 길에 O이 있는 경우
					if(map[offBx][offBy]=='O'){
						bex=true;
					}
					
					//그 후 또 이동
					offBx+=offX[i];
					offBy+=offY[i];
				}
				
				
				
				// 서로 같은 직선상에 없는 경우
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

				// R이 가는 길에 B가 있는 경우
				else if(blue!=0){
					// 구멍이 B보다 앞쪽에 있는 경우 하나 빼야됨
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
				
				// B가 가는 길에 R이 있는 경우
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
