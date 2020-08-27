#include "order.h"

map<string, double> coffe_all_price;
map<string, double> mix_all_price;

order::order(string ct, int cs, int tem, int mt)
{
	coffe_type = ct;
	map<string, double>::iterator it = coffe_all_price.find(coffe_type);
	if (it != coffe_all_price.end())
	{
		coffe_price = it->second;
	}
	else
		coffe_price = -1;
	cup_size = cs;
	temparature=tem;
	ifAddMilk = mt;
}

void order::setCoffePrice(string coname,double price)
{
	//map的insert相同键值的不会覆盖
	coffe_all_price.insert(pair<string,double>(coname,price));
}
double order::getCoffePrice()
{
	return coffe_price;
}

double order::getAllPrice()
{
	double allPrice=getCoffePrice();
	//根据规格，0,10%，20%加
	allPrice = allPrice*(1 + (double)(cup_size)*0.1);
	map<string, mix*>::iterator it = add_mix.begin();
	while (it != add_mix.end())
	{
		allPrice += it->second->get_MixPrice();
		it++;
	}
	return allPrice;
}

void order::addMix(mix *it)
{
	add_mix.insert(pair<string, mix *>(it->getType(), it));
}

//

string mix::getType()
{
	return mix_type;
}

//可能有雷
mix * mix::getThis()
{
	return (mix *)(this);
}

double mix_yuanweitangjiang::get_MixPrice()
{
	//先搜索价格
	double price;
	map<string, double>::iterator it = mix_all_price.find(mix_type);
	if (it != mix_all_price.end())
	{
		price = it->second;
		return price * specification;
	}
	else
		return -1;  //表示无价格
}

double mix_xiangcaotangjiang::get_MixPrice()
{
	double price;
	map<string, double>::iterator it = mix_all_price.find(mix_type);
	if (it != mix_all_price.end())
	{
		price = it->second;
		return price * specification;
	}
	else
		return -1;  
}

double mix_jiaotangtangjiang::get_MixPrice()
{
	double price;
	map<string, double>::iterator it = mix_all_price.find(mix_type);
	if (it != mix_all_price.end())
	{
		price = it->second;
		return price * specification;
	}
	else
		return -1;
}

double mix_mokalinjiang::get_MixPrice()
{
	double price;
	map<string, double>::iterator it = mix_all_price.find(mix_type);
	if (it != mix_all_price.end())
	{
		price = it->second;
		return price * specification;
	}
	else
		return -1;
}