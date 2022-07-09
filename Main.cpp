#include <iostream>
#include <cmath>
#include <string>
#include "Figure.h"
#include "Isosceles_triangle.h"
#include "straight_prism.h"
#include "List.h"
#include "Functions.h"

int main() {
	setlocale(LC_ALL, "Russian");
	std::ifstream f_in("input.txt");
	list<Figure*> arr;
	func_1(arr);
	func_2(arr);
	return 0;
}