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
	//map��insert��ͬ��ֵ�Ĳ��Ḳ��
	coffe_all_price.insert(pair<string,double>(coname,price));
}
double order::getCoffePrice()
{
	return coffe_price;
}

double order::getAllPrice()
{
	double allPrice=getCoffePrice();
	//���ݹ��0,10%��20%��
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

//��������
mix * mix::getThis()
{
	return (mix *)(this);
}

double mix_yuanweitangjiang::get_MixPrice()
{
	//�������۸�
	double price;
	map<string, double>::iterator it = mix_all_price.find(mix_type);
	if (it != mix_all_price.end())
	{
		price = it->second;
		return price * specification;
	}
	else
		return -1;  //��ʾ�޼۸�
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