#ввод целого числа
num_1 = int(input())
sum = int(0)
sum_2 = int(1)
#цикл
for i in range(3):
    sum += num_1 % 10
    sum_2 *= num_1 % 10
    num_1 //= 10
print('Сумма цифр', sum, sep = ' = ' )
print('Произведение цифр', sum_2, sep = ' = ')
#sep and end позволяют помщеать внутрь вывода разные символы(sep - между аргументами, end в конце)
name = input()
print('Привет', name, sep = ', ', end = '!')
#list - пока для меня это массив в питоне, норм массив почему то не работает(
nums = list()
num_1 = int(input())
for i in range(3):
    #// - в питоне это деление нацело а / - протсо деление)
    nums.append(num_1 // (10 ** (2 - i)))
    num_1 %= (10 ** (2 - i))
for i in range(3):
    if (i == 1):
        print(nums[i], nums[(i + 2) % 3], nums[(i + 1) % 3], sep='')
        print(nums[i], nums[(i + 1) % 3], nums[(i + 2) % 3], sep='')
    else:
        print(nums[i], nums[(i + 1) % 3], nums[(i + 2) % 3], sep = '')
        print(nums[i], nums[(i + 2) % 3], nums[(i + 1) % 3], sep = '')