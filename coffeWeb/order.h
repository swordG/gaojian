#ifndef ORDER
#define ORDER

#include <iostream>
#include <string>
#include <map>
using namespace std;

extern map<string, double> coffe_all_price;
extern map<string, double> mix_all_price;

class mix;

class order
{
public:
	string coffe_type;
	double coffe_price;    //价格为-1表示没有这个
	int cup_size;
	int temparature;
	int ifAddMilk;
	map<string, mix*> add_mix;
	order(){};
	order(string ct, int cs, int tem, int mt);
	void setCoffePrice(string coname, double price);  //test类
	double getCoffePrice();
	void addMix(mix *it);				//由外界调用拼凑
	double getAllPrice();
	void printOrder();
};

class mix
{
public:
	string mix_type;
	int specification;
	mix(){};
	mix(string mt, int sp){ mix_type = mt; specification = sp; };
	virtual double get_MixPrice()=0;
	string getType();
	mix * getThis();
};

//接下来是实例化的所有配料的类
class mix_yuanweitangjiang: public mix
{
public:
	mix_yuanweitangjiang(string mt, int sp) :mix(mt, sp){};
	double get_MixPrice();
};

class mix_xiangcaotangjiang : public mix
{
public:
	mix_xiangcaotangjiang(string mt, int sp) :mix(mt, sp){};
	double get_MixPrice();
};

class mix_jiaotangtangjiang : public mix
{
public:
	mix_jiaotangtangjiang(string mt, int sp) :mix(mt, sp){};
	double get_MixPrice();
};
class mix_mokalinjiang : public mix
{
public:
	mix_mokalinjiang(string mt, int sp) :mix(mt, sp){};
	double get_MixPrice();
};


#endif