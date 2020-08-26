#include "Inventory.h"
#include "test.h"

int main()
{
	Inventory inven;
	test test1;
	test1.InsertAllCom(inven);

	ComputerSpec input;
	test1.getInput(input);
	vector<Computer> output = inven.search(input);
	test1.print(output);
	system("pause");
	return 0;
}