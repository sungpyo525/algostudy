/*

#include<iostream>
#include<stack>
#include<string>

using namespace std;

int main()
{
	freopen("input.txt", "r", stdin);
	//freopen("output.txt", "w", stdout);

	int N;
	string command;
	char popped;


	cin >> N;
	

	for (int i = 0; i < N; i++) {
		stack <char>STACK;
		cin >> command;

		for (int j = 0; j < (int)command.length(); j++) {
		
			//case ( : push
			if (command[j] == '(') { STACK.push(command[j]); }

			//case ) : stack�� ���������  ||  stack���� (�� pop ���� ������ :  NO 
			if (command[j] == ')') {

				if (STACK.empty() == true) { cout << "NO"; break; }

				popped = STACK.top();
				if (popped != '(') { cout << "NO"; break; }
				else { STACK.pop(); }

			}

			if (j == command.length() - 1) {
			
			//case : ���ڿ��� �� �˻��� ��, ������ ��������� YES
			if (STACK.empty() == true) { cout << "YES"; }
			else { cout << "NO"; }
			}

		}
		cout << endl;
	}
	return 0;
}

*/