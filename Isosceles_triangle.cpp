#include "Isosceles_triangle.h"
#include <cmath>
#include <set>

int side_checker(int num_of_side_1, int num_of_side_2) {
	std::set<int> st;
	st.insert(0);
	st.insert(1);
	st.insert(2);
	st.erase(num_of_side_1);
	st.erase(num_of_side_2);
	std::set <int> ::iterator it = st.begin();
	return *it;
}

straight_isoscales_triangle::straight_isoscales_triangle(double side_1, double side_2, double side_3) {
	_sides[0] = side_1;
	_sides[1] = side_2;
	_sides[2] = side_3;
}

int straight_isoscales_triangle::find_angle_between_sides(int side_1, int side_2) {
	if (sqrt(_sides[side_1] * _sides[side_1] + _sides[side_2] * _sides[side_2]) == _sides[side_checker(side_1, side_2)])
		return 90;
	else
		return 45;
}

void straight_isoscales_triangle::print() {
	std::cout << "Равнобедренный прямоугольный треугольник" << "\n";
	std::cout << "Сторона 1" << "\n";
	std::cout << _sides[0] << "\n";
	std::cout << "Сторона 2" << "\n";
	std::cout << _sides[1] << "\n";
	std::cout << "Сторона 3" << "\n";
	std::cout << _sides[2] << "\n";
}

double str2doub(std::string str) {
	bool flag = 0;
	int num_of_digits = 0;
	double num = 0;
	if (str[0] == 's') {
		for (int i = 4; i < str.size(); i++) {
			if (str[i] == ',') {
				num_of_digits++;
				flag = 1;
			}
			else {
				num = num * 10 + str[i] - 48;
				if (flag)
					num_of_digits++;
			}
		}
		if (num_of_digits == 0)
			return sqrt(num);
		return sqrt(num / pow(10, (num_of_digits - 1)));
	}
	else
		for (int i = 0; i < str.size(); i++)
			num = num * 10 + str[i] - 48;
	return num;
}
