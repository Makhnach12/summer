#ifndef STRAIGHT_PRISM
#define STRAIGHT_PRISM
#include <iostream>
#include "Isosceles_triangle.h"

class straight_prism : public straight_isoscales_triangle {
private:
	int _high;
public:
	straight_prism(double side_1, double side_2, double side_3, double high);
	double full_square() { return 2 * square() + 2 * catet() * _high + hypo() * _high; }
	double volume() { return square() * _high; }

	friend std::istream& operator>>(std::istream& input, straight_prism& stud);
	friend std::ostream& operator<<(std::ostream& output, const straight_prism& stud);

	void print();
};

inline std::istream& operator>>(std::istream& input, straight_prism& stud) {
	std::string num;
	std::cout << "Сторона 1" << "\n";
	input >> num;
	stud._sides[0] = str2doub(num);
	std::cout << "Сторона 2" << "\n";
	input >> num;
	stud._sides[1] = str2doub(num);
	std::cout << "Сторона 3" << "\n";
	input >> num;
	stud._sides[2] = str2doub(num);
	std::cout << "Высота" << "\n";
	input >> num;
	stud._high = str2doub(num);
	return input;
}

inline std::ostream& operator<<(std::ostream& output, const straight_prism& stud) {
	std::cout << "Прямая призма" << "\n";
	std::cout << "Сторона 1" << "\n";
	output << stud._sides[0] << "\n";
	std::cout << "Сторона 2" << "\n";
	output << stud._sides[1] << "\n";
	std::cout << "Сторона 3" << "\n";
	output << stud._sides[2] << "\n";
	std::cout << "Высота" << "\n";
	output << stud._high << "\n";
	return output;
}

#endif
