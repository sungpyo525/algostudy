#include <string>
#include <algorithm>  // copy
#include <vector>
#include <iostream>
#include <iterator>    // ostream_iterator
#include <fstream>
using namespace std;

int main()
{
	char ch;
	char cha;
	string str;
	int i = 0;
	vector<string> Vector;
	vector<string> tokens;
	ifstream inf("input2.txt");
	while (inf.get(ch))
	{
		if (ch == ' ') continue;
		if (ch == ',')
		{
		//	cout << str << endl;
			Vector.push_back(str);
			str.clear();
			continue;
		}
		else
		{
			str.append(1, ch);
		}
	}

	for (int i = 0; i < Vector.size(); i++)
	{
		for (int j = i+1; j < Vector.size(); j++)
		{
			if (Vector[i] == Vector[j])
			{
				cout << Vector[i] << endl;
				return 0;
			}
		}
	}
	return 0;
}
