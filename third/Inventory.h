#ifndef INVENTORY
#define INVENTORY

#include <iostream>
#include<string>
#include <map>
#include <vector>

#include "allType.h"

using namespace std;

//测试类
class test
{

};

struct store
{
	string computerId;
	double price;
	ComputerSpec comSpec;
};

class Inventory
{
public:
	Inventory();
	void addComputer(string computerId,double price,ComputerSpec comSpec);
	Computer get(string computerId);
	vector<Computer> search(ComputerSpec  comSpec);    //返回一个vector表示数组
	~Inventory();
};


class Computer: public Inventory
{
	string computerId;
	double price;
public:
	Computer(string comId, double pri);
	string getComputerId();
	double getPrice();
	void setPrice(double inPrice);
	ComputerSpec getSpec();
};

class ComputerSpec: public Computer
{
	map<string, Object> properties;
public:
	bool operator==(const ComputerSpec& b) //重载==运行
	{
		return properties == b.properties;
	}
	Object getProperty(string str);
	void setProperties(string type, int information);
	map<string, Object> getProperties();
	bool matches(ComputerSpec &comS);
};

class Object
{
	string type;
	int information;
public:
	Object(string str,int in)
	{
		type = str;
		information = in;
	}
	string toString()
	{
		return to_string(information);
	}
	bool operator==(const Object& b) //重载==运行
	{
		return type == b.type && information == b.information;
	}
};

#endif