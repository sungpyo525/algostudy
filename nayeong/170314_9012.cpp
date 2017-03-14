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

			//case ) : stack이 비어있으면  ||  stack에서 (가 pop 되지 않으면 :  NO 
			if (command[j] == ')') {

				if (STACK.empty() == true) { cout << "NO"; break; }

				popped = STACK.top();
				if (popped != '(') { cout << "NO"; break; }
				else { STACK.pop(); }

			}

			if (j == command.length() - 1) {
			
			//case : 문자열을 다 검사한 후, 스택이 비어있으면 YES
			if (STACK.empty() == true) { cout << "YES"; }
			else { cout << "NO"; }
			}

		}
		cout << endl;
	}
	return 0;
}

*/