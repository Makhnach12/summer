#ifndef FUNCTIONS
#define FUNCTIONS
#include "Figure.h"
#include "Isosceles_triangle.h"
#include "straight_prism.h"
#include "List.h"
#include "Checkers.h"
#include <fstream>

int get_idx(Figure* hero) {
	if (typeid(*hero) == typeid(straight_prism))
		return 1;
	else if (typeid(*hero) == typeid(straight_isoscales_triangle))
		return 2;
	else
		return -1;
}

void func_1(list<Figure*>& arr) {
	int fig_num;
	std::string _side_1, _side_2, _side_3, _high;
	straight_prism* fig_1;
	straight_isoscales_triangle* fig_2;
	std::ifstream f_in("input.txt");
	while (!f_in.eof()) {
		f_in >> fig_num;
		switch (fig_num) {
		case 1:
			f_in >> _side_1 >> _side_2 >> _side_3 >> _high;
			try {
				if (check_triangle(str2doub(_side_1), str2doub(_side_2), str2doub(_side_3))) {
					fig_1 = new straight_prism(str2doub(_side_1), str2doub(_side_2), str2doub(_side_3), str2doub(_high));
					arr.push_back(fig_1);
				}
				else
					throw 1;
			}
			catch (int a) {
				std::cout << "Caught exception number:  " << a << "\n";
			}
			break;
		case 2:
			f_in >> _side_1 >> _side_2 >> _side_3;
			try {
				if (check_triangle(str2doub(_side_1), str2doub(_side_2), str2doub(_side_3))) {
					fig_2 = new straight_isoscales_triangle(str2doub(_side_1), str2doub(_side_2), str2doub(_side_3));
					arr.push_back(fig_2);
				}
				else
					throw 2;
			}
			catch (int a) {
				std::cout << "Caught exception number:  " << a << "\n";
			}
			break;
		}
	}
	f_in.close();
}

void func_2(list<Figure*>& arr) {
	for (int i = 0; i < arr.size(); i++) {
		if (get_idx(arr.find_value(i)) == 1)
			(dynamic_cast<straight_prism*>(arr.find_value(i)))->print();
		else 
			(dynamic_cast<straight_isoscales_triangle*>(arr.find_value(i)))->print();
	}
}

straight_isoscales_triangle func_3_1(list<Figure*>& arr) {
	straight_isoscales_triangle* min_trian = 0;
	int min_angle = 100000;
	for (int i = 0; i < arr.size(); i++)
		if (get_idx(arr.find_value(i)) == 2) {
			if (45 < min_angle) {
				min_angle = 45;
				min_trian = (dynamic_cast<straight_isoscales_triangle*>(arr.find_value(i)));
			}
		}
	return *(min_trian);
}

double func_3_2(list<Figure*>& arr) {
	double all_volume = 0;
	int num_of_prism = 0;
	for (int i = 0; i < arr.size(); i++)
		if (get_idx(arr.find_value(i)) == 1) {
			num_of_prism++;
			all_volume += (dynamic_cast<straight_prism*>(arr.find_value(i)))->volume();
		}
	return all_volume / num_of_prism;
}

#endif

