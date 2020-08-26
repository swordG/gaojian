#include "Inventory.h"

//������д�뵽����
void Inventory::addComputer(string computerId, double price, ComputerSpec comSpec)
{
	store comInfo;
	comInfo.computerId = computerId;
	comInfo.price = price;
	comInfo.comSpec = comSpec;      //---û�����������
	computerInformation.insert(pair<string, store>(computerId,comInfo));
}

Computer Inventory::get(string computerId)
{
	//�����洢
	map<string, store>::iterator it = computerInformation.find(computerId);
	if (it != computerInformation.end())
	{
		Computer com(it->second.computerId, it->second.price);
		return  com;
	}
	else
	{
		Computer com("-1", -1);
		return  com;
	}
}

//���������ComputerSpec����
vector<Computer> Inventory::search(ComputerSpec  comSpec)
{
	vector<Computer> returnComputer;
	map<string, store>::iterator it = computerInformation.begin();
	while (it != computerInformation.end())
	{
		if (it->second.comSpec.matches(comSpec))
		{
			returnComputer.push_back(Computer(it->first,it->second.price));
		}
	}
}


//-----
Computer::Computer(string comId, double pri)
{
	computerId = comId;
	price = pri;
}

string Computer::getComputerId()
{
	return computerId;
}

double Computer::getPrice()
{
	return price;
}

void Computer::setPrice(double inPrice)
{
	price = inPrice;
}

ComputerSpec Computer::getSpec()
{
	//-------������Σ�գ�������÷�������
	return *(static_cast<ComputerSpec*>( this));
}

//-----
Object ComputerSpec::getProperty(string str)
{
	map<string, Object>::iterator  it = properties.find(str);
	if (it != properties.end())
	{
		return it->second;
	}
	else
	{
		Object err("-1",-1);
		return err;
	}
}

void ComputerSpec::setProperties(string type, int information)
{
	Object a(type, information);
	properties.insert(pair<string, Object>(type,a));
}

map<string, Object> ComputerSpec::getProperties()
{
	return properties;
}

bool ComputerSpec::matches(ComputerSpec &comS)
{
	//----�Ա�map��ֻҪcomS��properties���Ӽ�����
	map<string, Object>::iterator it1 = comS.getProperties().begin();
	map<string, Object>::iterator it2 = properties.begin();
	if (it1 == comS.getProperties().end())
	{
		return false;
	}
	else
	{
		while (it1 != comS.getProperties().end())
		{
			it2 = properties.find(it1->first);
			if (it2 == properties.end())
				return false;
		}
	}
	return true;
}


