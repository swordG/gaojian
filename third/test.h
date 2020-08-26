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

	//��ȡ����,ƴ�ӳ�ComputerSpec
	void getInput(ComputerSpec &input)
	{
		int computerBrand = 0;
		int cpu = 0;
		int computerType = 0;
		int laptopType = 0;
		int price_range = 0;
		cout << "���������Ʒ��:��0��ʾ��ѡ��" << endl;
		cout << "1��samsung" << endl;
		cout << "2��xiaomi" << endl << ".....";
		cin >> computerBrand;

		cout << "������cpu�ͺ�:��0��ʾ��ѡ��" << endl;
		cout << "1��Intel_i9_lowpower" << endl;
		cout << "2��intel_i9_norpower" << endl << ".....";
		cin >> cpu;

		cout << "�������������:��0��ʾ��ѡ��" << endl;
		cout << "1����������server��" << endl;
		cout << "2���ʼǱ���laptop��" << endl << ".....";
		cin >> computerType;

		cout << "�۸�����:��0��ʾ��ѡ��" << endl;
		cout << "6��5000~6000" << endl;
		cout << "7��6000~7000" << endl << ".....";
		cin >> price_range;

		//����ComputerSpec�ļ�
		if (computerBrand == 0)
		{
		}
		else if (computerBrand >= 1 && computerBrand <computerBrandEnd)
		{
			input.setProperties("computerBrand", computerBrand);
		}
		else
		{
			cout << "�������Ʒ���������" << endl;
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
			cout << "cpu�ͺ��������" << endl;
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
			cout << "������������������" << endl;
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
			cout << "�۸������������" << endl;
		}
	}

	void print(vector<Computer> &output)
	{
		for (int i = 0; i < output.size(); i++)
		{
			cout << "����ID��" << output[i].getComputerId() << endl;
			cout << "�۸�:" << output[i].getPrice() << endl << endl;
		}
	}
};

#endif