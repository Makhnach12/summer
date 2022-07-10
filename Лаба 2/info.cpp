#include <iostream>

int** create_mat(int n, int m)
{
	int** mat = new int* [n];

	for (int i = 0; i < n; i++)
		mat[i] = new int[m];

	return mat;
}

void clean_mat(int** mat, int n, int m)
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
			mat[i][j] = 0;

		delete[] mat[i];
	}

	delete[] mat;
	mat = 0;
}

int main()
{
	int n, m;
	std::cin >> n >> m;

	//массив для веса слитков
	int* weight = new int[n];

	int** mat = create_mat(n + 1, m + 1);

	for (int i = 0; i < n; i++)
		std::cin >> weight[i];

	for (int j = 0; j <= m; j++)
		mat[0][j] = 0;

	for (int i = 1; i <= n; i++)
		for (int j = 0; j <= m; j++)
		{
			mat[i][j] = mat[i - 1][j];
			if ((mat[i][j] < weight[i - 1]+ mat[i - 1][j - weight[i - 1]]) and j >= weight[i - 1])
				mat[i][j] = weight[i - 1] + mat[i - 1][j - weight[i - 1]];
		}

	std::cout << mat[n][m];

	clean_mat(mat, n + 1, m + 1);
	delete[] weight;
	weight = 0;
	return 0;
}