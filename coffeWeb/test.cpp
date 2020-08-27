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
	addCoffe("����",10);
	addCoffe("��ʽ", 12);
	addCoffe("Ħ��", 13);
	addCoffe("������ŵ", 15);

	addMix("ԭζ�ǽ�",2);
	addMix("����ǽ�", 2);
	addMix("�����ǽ�", 3);
	addMix("Ħ���ܽ�", 4);
}

string test::coffeTostring(int type)
{
	string a;
	switch (type)
	{
	case 1:{
		a = "��ʽ";
	}break;
	case 2:{
		a = "����";
	}break;
	case 3:{
		a = "Ħ��";
	}break;
	case 4:{
		a = "������ŵ";
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
		a = "ԭζ�ǽ�";
	}break;
	case 2:{
		a = "����ǽ�";
	}break;
	case 3:{
		a = "�����ǽ�";
	}break;
	case 4:{
		a = "Ħ���ܽ�";
	}break;
	default:
	{
		a = "-1";
	}
	break;
	}
	return a;
}

//����mixʵ��
mix* test::creatMix(int type, int num)
{
	mix* mm;
	string a;
	switch (type)
	{
	case 1:{
		a = "ԭζ�ǽ�";
		mm = (mix*)(new mix_yuanweitangjiang(a, num));
	}break;
	case 2:{
		a = "����ǽ�";
		mm = (mix*)(new mix_xiangcaotangjiang(a, num));
	}break;
	case 3:{
		a = "�����ǽ�";
		mm = (mix*)(new mix_jiaotangtangjiang(a, num));
	}break;
	case 4:{
		a = "Ħ���ܽ�";
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
	cout << "����ѡ��" << "���ȹ��:" << od.coffe_type << endl;
	cout << "�����" << endl;
	map<string, mix*>::iterator it = od.add_mix.begin();
	while (it != od.add_mix.end())
	{
		cout << it->first << ":" << it->second->specification << endl;
		it++;
	}
	cout << "�ܼۣ�" << od.getAllPrice()<<endl;
	cout << "---------------------лл�ݹ�-------------------------" << endl<<endl;
}

void test::orderAddMix(order &od)
{
	map<int, int> input; map<int, int>::iterator it;
	int ip;
	cout << "�����¸������ѡ��1.ԭζ�ǽ���2Ԫ/�ã�  2.����ǽ���2Ԫ/�ã�  3.�����ǽ���3Ԫ/�ã�  4.Ħ���ܽ���4Ԫ/�ã�  ������������Ϊ����" << endl;
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
				cout << "������ѡ" << endl;
		}
	}
	if (input.size() == 0)
	{
		cout << "��δѡ������" << endl;
	}
	else
	{
		cout << "�ֱ������񣨱ã�" << endl;
		it = input.begin();
		while (it != input.end())
		{
			int num;
			cout << "����" << mixTostring(it->first) << "������(1~10)" << endl;
			cin >> num;
			if (num <= 0 || num > 10)
			{
				cout << "�������ԣ���������" << endl;
			}
			else
			{
				mix *mm;
				mm = creatMix(it->first, num);
				od.addMix(mm);  //��������
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
		cout << "ѡ�񿧷����ͣ�1. ����������10Ԫ��  2.��ʽ������12Ԫ��  3.Ħ��������13Ԫ�� 4.������ŵ������15Ԫ��  ����������Ч" << endl;
		cin >> coffeType;
		if (coffeType < natie || coffeType > 4)
		{
			cout << "��ӭ�´�����" << endl;
			continue;
		}
		coffeTy = coffeTostring(coffeType);
		cout << "ѡ���ͣ�1.�б���355ml��  2.�󱭣�473ml������+10%�� 3.���󱭣�592ml������+20%������������Ч" << endl;
		bool ifsellect = false;
		while (!ifsellect)
		{
			cin >> size;
			if (size < 1 || size>3)
			{
				cout << "�ף���ѡ����Ŷ����Ȼ�޷��µ�" << endl;
			}
			else
				ifsellect = true;
		}
		ifsellect = false;
		cout << "ѡ���¶ȣ�1.�ر���  2.��  3.΢��  4.ȥ��  5.�ٱ�  6.��  ����������Ч" << endl;
		while (!ifsellect)
		{
			cin >> temp;
			if (temp < 1 || temp>6)
			{
				cout << "�ף���ѡ���¶�Ŷ����Ȼ�޷��µ�" << endl;
			}
			else
				ifsellect = true;
		}

		ifsellect = false;
		cout << "��ӻ����ţ�̣�1.ȫ֬ţ��  2.������  3.��֬ţ��  4.����  ����������Ч" << endl;
		while (!ifsellect)
		{
			cin >> mikeType;
			if (mikeType < 1 || mikeType>6)
			{
				cout << "�ף���ѡ��ţ��Ŷ����Ȼ�޷��µ�" << endl;
			}
			else
				ifsellect = true;
		}

		//����ǽ��Ȳ���
		order od(coffeTy, size, temp, mikeType );
		orderAddMix(od);

		//�Ƽ۲���ӡ����
		printOrder(od);
	}

}