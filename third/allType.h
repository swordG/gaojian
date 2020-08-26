#ifndef ALLTYPE_H
#define ALLTYPE_H
enum computerBrand
{
	samsung = 1,
	xiaomi,
	huawei,
	DELL,
	HP,
	Acer,
	Apple,
	SONY,
	computerBrandEnd,
};

enum cpu
{
	Intel_i9_lowpower=1,
	intel_i9_norpower,
	Inter_CoreM,
	AMD,
	Inter_i7,
	cpuEnd,
};

enum computerType
{
	server=1,
	laptop,
	desktop,
	computerTypeEnd,
};

enum laptopType
{
	game_book=1,
	business_book,
	Ultra_thin_labtop,
	laptopTypeEnd,
};

enum price_range
{
	price0_1000=1,
	price1000_2000,
	price2000_3000,
	price3000_4000,
	price4000_5000,
	price5000_6000,
	price6000_7000,
	price7000_9000,
	price9000_,
	price_rangeEnd,
};

#endif