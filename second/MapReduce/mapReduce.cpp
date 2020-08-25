#include "mapReduce.h"

mapReduce::mapReduce(string file_in, string file_out)
{
	myfile = ifstream(file_in);
	outfile = ofstream(file_out);
	if (!myfile.is_open())
	{
		cout << "can not open this file" << endl;
	}
	print_enable = false;
	text_line_reading = 0;
	split_end = false;
}

//分行
void mapReduce::splitting()
{
	string line;
	while (getline(myfile, line))//逐行读
	{
		//消除符号，大写变小写
		for (int i = 0; i<line.size(); i++)
		{
			if (line[i] >= 'a'&&line[i] <= 'z')
			{
			}
			else if (line[i] >= 'A'&&line[i] <= 'Z')
			{
				line[i] = line[i] + 32;
			}
			else
			{
				line[i] = ' ';
			}
		}
		text_mu.lock();
		text.push_back(line);
		text_mu.unlock();
	}
	split_end = true;
}

//分单词
void mapReduce::mapping()
{
	string line, str;
	map<string, int>::iterator it;
	while (!split_end)
	{
		if (text_line_reading < text.size())
		{
			line = text[text_line_reading];
			istringstream istr(line);
			while (!istr.eof())
			{
				istr >> str;      //get a word
				it = allword.find(str);
				allword_mu.lock();
				if (it == allword.end())
				{
					allword.insert(pair<string, int>(str, 1));
				}
				else
				{
					it->second++;
				}
				allword_mu.unlock();
			}
			text_line_reading++;
		}
	}
	print_enable = true;
}

//合并
void mapReduce::shuffling()
{
};

//计数
void mapReduce::reducing()
{
};

//执行读写过程
void mapReduce::close()
{
	myfile.close();
	outfile.close();
}

void mapReduce::out_file()
{
	map<string, int>::iterator it;
	//写入文件操作
	it = allword.begin();
	while (it != allword.end())
	{
		outfile << it->first << ',' << it->second << endl;
		it++;
	}
}

void mapReduce::print()
{
	cout << "读行数:" << text.size() << endl;
	cout << "读取单词数目：" << allword.size() << endl;
}