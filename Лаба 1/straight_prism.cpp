#include"straight_prism.h"
#include <iostream>

straight_prism::straight_prism(double side_1, double side_2, double side_3, double high) {
	_sides[0] = side_1;
	_sides[1] = side_2;
	_sides[2] = side_3;
	_high = high;
}

void straight_prism::print() {
	std::cout << "������ ����������� ������" << "\n";
	std::cout << "������� 1" << "\n";
	std::cout << _sides[0] << "\n";
	std::cout << "������� 2" << "\n";
	std::cout << _sides[1] << "\n";
	std::cout << "������� 3" << "\n";
	std::cout << _sides[2] << "\n";
	std::cout << "������" << "\n";
	std::cout << _high << "\n";
}




