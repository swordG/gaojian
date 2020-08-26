#ifndef TEST_H
#define TEST_H
#include "Inventory.h"

class test
{
public:
	void InsertComSpc1(ComputerSpec &in)
	{
		in.setProperties("computerBrand", samsung);
		in.setProperties("cpu", Intel_i9_lowpower);
		in.setProperties("computerType", server);
		in.setProperties("price_range", price5000_6000);
	}

	void InsertComSpc2(ComputerSpec &in)
	{
		in.setProperties("computerBrand", xiaomi);
		in.setProperties("cpu", intel_i9_norpower);
		in.setProperties("computerType", server);
		in.setProperties("price_range", price5000_6000);
	}

	void InsertComSpc3(ComputerSpec &in)
	{
		in.setProperties("computerBrand", huawei);
		in.setProperties("cpu", intel_i9_norpower);
		in.setProperties("computerType", laptop);
		in.setProperties("price_range", price6000_7000);
	}

	void InsertAllCom(Inventory &inven)
	{
		ComputerSpec insertComSpc1, insertComSpc2, insertComSpc3;
		InsertComSpc1(insertComSpc1);
		InsertComSpc1(insertComSpc2);
		InsertComSpc1(insertComSpc3);
		inven.addComputer("0000", 5111, insertComSpc1);
		inven.addComputer("0001", 5222, insertComSpc2);
		inven.addComputer("0002", 6222, insertComSpc3);
	}

	//获取输入,拼接成ComputerSpec
	void getInput(ComputerSpec &input)
	{
		int computerBrand = 0;
		int cpu = 0;
		int computerType = 0;
		int laptopType = 0;
		int price_range = 0;
		cout << "请输入电脑品牌:（0表示不选）" << endl;
		cout << "1：samsung" << endl;
		cout << "2：xiaomi" << endl << ".....";
		cin >> computerBrand;

		cout << "请输入cpu型号:（0表示不选）" << endl;
		cout << "1：Intel_i9_lowpower" << endl;
		cout << "2：intel_i9_norpower" << endl << ".....";
		cin >> cpu;

		cout << "请输入电脑类型:（0表示不选）" << endl;
		cout << "1：服务器（server）" << endl;
		cout << "2：笔记本（laptop）" << endl << ".....";
		cin >> computerType;

		cout << "价格区间:（0表示不选）" << endl;
		cout << "6：5000~6000" << endl;
		cout << "7：6000~7000" << endl << ".....";
		cin >> price_range;

		//构建ComputerSpec文件
		if (computerBrand == 0)
		{
		}
		else if (computerBrand >= 1 && computerBrand <computerBrandEnd)
		{
			input.setProperties("computerBrand", computerBrand);
		}
		else
		{
			cout << "输入电脑品牌输入错误！" << endl;
		}

		if (cpu == 0)
		{
		}
		else if (cpu >= 1 && cpu <cpuEnd)
		{
			input.setProperties("cpu", cpu);
		}
		else
		{
			cout << "cpu型号输入错误！" << endl;
		}

		if (computerType == 0)
		{
		}
		else if (computerType >= 1 && computerType <computerTypeEnd)
		{
			input.setProperties("computerType", computerType);
		}
		else
		{
			cout << "输入电脑类型输入错误！" << endl;
		}

		if (price_range == 0)
		{
		}
		else if (price_range >= 6 && price_range <8)
		{
			input.setProperties("price_range", price_range);
		}
		else
		{
			cout << "价格区间输入错误！" << endl;
		}
	}

	void print(vector<Computer> &output)
	{
		for (int i = 0; i < output.size(); i++)
		{
			cout << "电脑ID：" << output[i].getComputerId() << endl;
			cout << "价格:" << output[i].getPrice() << endl << endl;
		}
	}
};

#endif