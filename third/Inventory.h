#ifndef INVENTORY_H
#define INVENTORY_H

#include <iostream>
#include<string>
#include <map>
#include <vector>
#include <stdint.h>
#include "allType.h"

using namespace std;

class Computer;
class ComputerSpec;
class store;
class Object;


//存储数据
extern map<string, store> computerInformation;


class Inventory
{
public:
	Inventory(){};
	void addComputer(string computerId,double price,ComputerSpec &comSpec);
	Computer get(string computerId);
	vector<Computer> search(ComputerSpec  &comSpec);    //返回一个vector表示数组
};


class Computer: public Inventory
{
	string computerId;
	double price;
public:
	Computer(){ computerId = "-1"; price = -1; };
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
	ComputerSpec(){};
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
	bool operator==(const Object& b) const //重载==运行
	{
		return type == b.type && information == b.information;
	}
};

class store
{
public:
	string computerId;
	double price;
	ComputerSpec comSpec;
};


#endif