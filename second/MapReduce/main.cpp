#include "mapReduce.h"

void thread_splitting(mapReduce *t1)
{
	t1->splitting();
}

void thread_mapping(mapReduce *t1)
{
	t1->mapping();
}

void print_time(double time)
{
	cout << "ºÄ·ÑÊ±¼ä:" << time / (CLOCKS_PER_SEC) << "s" << endl;
}

int main()
{
	clock_t startTime, endTime;
	startTime = clock();

	mapReduce test("hamlet.txt","out.txt");
	thread Thread_splitting(thread_splitting, &test);
	thread Thread_mapping(thread_mapping, &test);
	Thread_splitting.join();
	Thread_mapping.join();

	test.out_file();
	test.print();
	endTime = clock();

	print_time((double)(endTime - startTime));
	system("pause");
	return 0;
}