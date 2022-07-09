#ifndef ISOSCELES_TRIANGLE
#define ISOSCELES_TRIANGLE
#include <iostream>
#include <cmath>
#include <string>
#include "Figure.h"

double str2doub(std::string str);

class straight_isoscales_triangle: public Figure {
protected:
	double _sides[3];
public:
	straight_isoscales_triangle() { ; }
	straight_isoscales_triangle(double side_1, double side_2, double side_3);
	~straight_isoscales_triangle() { ; }

	double hypo() { return std::max(std::max(_sides[0], _sides[1]), _sides[2]); }
	double catet() { return std::min(_sides[0], _sides[1]);  }

	int find_angle_between_sides(int side_1, int side_2);
	double perimeter() { return _sides[0] + _sides[1] + _sides[2]; }
	double square() { return pow(catet(), 2) / 2;  }

	friend std::istream& operator>>(std::istream& input, straight_isoscales_triangle& stud);
	friend std::ostream& operator<<(std::ostream& output, const straight_isoscales_triangle& stud);

	void print();
};

inline std::istream& operator>>(std::istream& input, straight_isoscales_triangle& stud) {
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
	return input;
}

inline std::ostream& operator<<(std::ostream& output, const straight_isoscales_triangle& stud) {
	std::cout << "Сторона 1" << "\n";
	output << stud._sides[0] << "\n";
	std::cout << "Сторона 2" << "\n";
	output << stud._sides[1] << "\n";
	std::cout << "Сторона 3" << "\n";
	output << stud._sides[2] << "\n";
	return output;
}

#endif 