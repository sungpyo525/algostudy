#include<iostream>
#include<string>
#include<stack>
using namespace std;

int test_case;
stack<char> st;
string s;

void check()
{
	for (int i = 0; i < s.size(); i++)
	{
		if (s.at(i) == '(') { st.push(s.at(i)); continue; }
		
		if (s.at(i) == ')')
		{
			if (st.empty()) { cout << "NO" << endl; return; }
			
			if (st.top() == '(') st.pop();
			else
			{
				cout << "NO" << endl;
				return;
			}
		}
	}
	if (st.empty()) cout << "YES" << endl;
	else cout << "NO" << endl;
}

int main()
{
	
	cin >> test_case;
	for (int j = 0; j < test_case; j++)
	{
		cin >> s;
		check();
		while (!st.empty())
		{
			st.pop();
		}
		
	}

}