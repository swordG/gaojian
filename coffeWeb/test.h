#ifndef TEST_H
#define TEST_H


#include "order.h"
#include <vector>
class test
{
public:
	void addCoffe(string conam, double price);
	void addMix(string minam, double price);
	void addCoffe_and_addMix_demo();

	string coffeTostring(int type);
	string mixTostring(int type);
	mix* creatMix(int type, int num);
	void orderAddMix(order &od);
	void creatOrder();
	void printOrder(order &od);
};

#endif