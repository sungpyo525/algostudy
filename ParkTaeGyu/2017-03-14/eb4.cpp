#include<iostream>
#include<string>
using namespace std;

int way = 0; // 0 = ºÏ , 1 = µ¿ , 2 = ³² , 3 = ¼­;
int x = 0;
int y = 0;

void move()
{
	switch (way)
	{
	case 0: y++;
		break;
	case 1: x++;
		break;
	case 2: y--;
		break;
	case 3: x--;
		break;
	}
}
void changeWay(char direction)
{
	if (direction == 'R')
	{
		switch (way)
		{
		case 0: way++;	break;
		case 1: way++; break;
		case 2: way++; break;
		case 3: way = 0; break;
		}
	}
	if (direction == 'L')
	{
		switch (way)
		{
		case 0: way = 3;	break;
		case 1: way--; break;
		case 2: way--; break;
		case 3: way--; break;
		}
	}
}

int main()
{
	string s;
	cin >> s;
	for (int i = 0; i < s.size(); i++)
	{
		if (s.at(i) == 'G') move();
		else if (s.at(i) == 'R' || s.at(i) == 'L') changeWay(s.at(i));
	}

	cout << "x: " << x << " y: " << y << endl;
	cout << "way: " << way << endl;
	if (x>1 || x<-1 || y>1 || y < -1) cout << "NO";
	else cout << "YES" << endl;

	return 0;
}