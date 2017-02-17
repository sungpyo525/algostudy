#include<iostream>
#include<stack>
#include<vector>
#include<string>
using namespace std;



int main()
{
	stack<char> st;
	int mul = 1;
	int temp = 1;
	int level = 0;
	int ans = 0;
	string str;
	cin >> str;
	int j = 1;

	for (int i = 0; i < str.size();i++)
	if (str[i] == '('){
		mul *= 2, st.push(str[i]);
		if (str[i + 1] == ')') ans += mul;
	}
	else if (str[i] == '['){
		mul *= 3, st.push(str[i]);
		if (str[i + 1] == ']') ans += mul;
	}
	else if (!st.empty() && str[i] == ')')
		mul /= 2, st.pop();
	else if (!st.empty() && str[i] == ']')
		mul /= 3, st.pop();

	cout << ans;
	return 0;
}