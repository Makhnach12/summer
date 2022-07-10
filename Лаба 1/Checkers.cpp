#include <iostream>
#include <cmath>
#include "Checkers.h"

bool check_triangle(double side_1, double side_2, double side_3) {
	if (sqrt(2 * pow(std::min(side_1, side_2), 2)) == std::max(std::max(side_1, side_2), side_3))
		return true;
	return false;
}
