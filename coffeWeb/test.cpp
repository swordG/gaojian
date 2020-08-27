#include "test.h"
#include "enumType.h"

void test::addCoffe(string conam,double price)
{
	coffe_all_price.insert(pair<string, double>(conam, price));
}

void test::addMix(string minam, double price)
{
	mix_all_price.insert(pair<string, double>(minam, price));
}

void test::addCoffe_and_addMix_demo()
{
	addCoffe("拿铁",10);
	addCoffe("美式", 12);
	addCoffe("摩卡", 13);
	addCoffe("卡布奇诺", 15);

	addMix("原味糖浆",2);
	addMix("香草糖浆", 2);
	addMix("焦糖糖浆", 3);
	addMix("摩卡淋酱", 4);
}

string test::coffeTostring(int type)
{
	string a;
	switch (type)
	{
	case 1:{
		a = "美式";
	}break;
	case 2:{
		a = "拿铁";
	}break;
	case 3:{
		a = "摩卡";
	}break;
	case 4:{
		a = "卡布奇诺";
	}break;
	default:
	{
		a = "-1";
	}
		break;
	}
	return a;
}

string test::mixTostring(int type)
{
	string a;
	switch (type)
	{
	case 1:{
		a = "原味糖浆";
	}break;
	case 2:{
		a = "香草糖浆";
	}break;
	case 3:{
		a = "焦糖糖浆";
	}break;
	case 4:{
		a = "摩卡淋酱";
	}break;
	default:
	{
		a = "-1";
	}
	break;
	}
	return a;
}

//返回mix实例
mix* test::creatMix(int type, int num)
{
	mix* mm;
	string a;
	switch (type)
	{
	case 1:{
		a = "原味糖浆";
		mm = (mix*)(new mix_yuanweitangjiang(a, num));
	}break;
	case 2:{
		a = "香草糖浆";
		mm = (mix*)(new mix_xiangcaotangjiang(a, num));
	}break;
	case 3:{
		a = "焦糖糖浆";
		mm = (mix*)(new mix_jiaotangtangjiang(a, num));
	}break;
	case 4:{
		a = "摩卡淋酱";
		mm = (mix*)(new mix_mokalinjiang(a, num));
	}break;
	default:
	{
		a = "-1";
		mm = (mix*)(new mix_mokalinjiang(a, num));
	}
	break;
	}
	return mm;
}

void test::printOrder(order &od)
{
	cout << "您已选：" << "咖啡规格:" << od.coffe_type << endl;
	cout << "附加项：" << endl;
	map<string, mix*>::iterator it = od.add_mix.begin();
	while (it != od.add_mix.end())
	{
		cout << it->first << ":" << it->second->specification << endl;
		it++;
	}
	cout << "总价：" << od.getAllPrice()<<endl;
	cout << "---------------------谢谢惠顾-------------------------" << endl<<endl;
}

void test::orderAddMix(order &od)
{
	map<int, int> input; map<int, int>::iterator it;
	int ip;
	cout << "有如下附加项可选：1.原味糖浆（2元/泵）  2.香草糖浆（2元/泵）  3.焦糖糖浆（3元/泵）  4.摩卡淋酱（4元/泵）  输入其余数字为结束" << endl;
	while (1)
	{
		cin >> ip;
		if (ip < 1 || ip>4)
			break;
		else
		{
			it = input.find(ip);
			if (it == input.end())
			{
				input.insert(pair<int, int>(ip, 0));
			}
			else
				cout << "该项已选" << endl;
		}
	}
	if (input.size() == 0)
	{
		cout << "您未选附加项" << endl;
	}
	else
	{
		cout << "分别输入规格（泵）" << endl;
		it = input.begin();
		while (it != input.end())
		{
			int num;
			cout << "输入" << mixTostring(it->first) << "的数量(1~10)" << endl;
			cin >> num;
			if (num <= 0 || num > 10)
			{
				cout << "数量不对，请重输入" << endl;
			}
			else
			{
				mix *mm;
				mm = creatMix(it->first, num);
				od.addMix(mm);  //订单增加
				it++;
			}
		}
	}
}

void test::creatOrder()
{
	int coffeType = 0; string coffeTy;
	map<string, int> userchooseMix;
	int size = 0;
	int mikeType = 0;
	int temp=0;
	while (1)
	{
		cout << "选择咖啡类型：1. 拿铁（基价10元）  2.美式（基价12元）  3.摩卡（基价13元） 4.卡布奇诺（基价15元）  其它数字无效" << endl;
		cin >> coffeType;
		if (coffeType < natie || coffeType > 4)
		{
			cout << "欢迎下次再来" << endl;
			continue;
		}
		coffeTy = coffeTostring(coffeType);
		cout << "选择杯型：1.中杯（355ml）  2.大杯（473ml，基价+10%） 3.超大杯（592ml，基价+20%）其它数字无效" << endl;
		bool ifsellect = false;
		while (!ifsellect)
		{
			cin >> size;
			if (size < 1 || size>3)
			{
				cout << "亲，请选择规格哦，不然无法下单" << endl;
			}
			else
				ifsellect = true;
		}
		ifsellect = false;
		cout << "选择温度：1.特别热  2.热  3.微热  4.去冰  5.少冰  6.冰  其它数字无效" << endl;
		while (!ifsellect)
		{
			cin >> temp;
			if (temp < 1 || temp>6)
			{
				cout << "亲，请选择温度哦，不然无法下单" << endl;
			}
			else
				ifsellect = true;
		}

		ifsellect = false;
		cout << "添加或更换牛奶：1.全脂牛奶  2.燕麦奶  3.脱脂牛奶  4.豆奶  其它数字无效" << endl;
		while (!ifsellect)
		{
			cin >> mikeType;
			if (mikeType < 1 || mikeType>6)
			{
				cout << "亲，请选择牛奶哦，不然无法下单" << endl;
			}
			else
				ifsellect = true;
		}

		//添加糖浆等参数
		order od(coffeTy, size, temp, mikeType );
		orderAddMix(od);

		//计价并打印订单
		printOrder(od);
	}

}