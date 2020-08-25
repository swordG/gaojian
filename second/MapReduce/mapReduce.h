#ifndef MAPREDUCE
#define MAPREDUCE
#include<iostream>
#include<string>
#include<sstream>
#include<fstream>
#include<vector>
#include<map>
#include<iterator>
#include<thread>
#include <mutex>  //Ëø
#include <ctime>

using namespace std;
class mapReduce
{
	ifstream myfile;
	ofstream outfile;
	mutex text_mu;
	mutex allword_mu;
	bool print_enable;
	vector<string>::iterator text_it;
	int text_line_reading ;
	bool split_end;

	//´æÎÄ±¾
	vector<string> text;
	//´æword
	map<string, int> allword;

public:
	mapReduce(string file_in,string file_out);
	void splitting();
	void mapping();
	void shuffling();
	void reducing();

	void out_file();
	void print();
	void close();
};

#endif