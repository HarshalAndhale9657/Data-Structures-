#include <stdio.h>

// function prototype
int sum(int, int);
// function defination
int sum(int x, int y)
{
    printf("The sum of %d and %d is : %d\n", x, y, x + y);
    return x + y;
}

int main()
{

    int a = 5;
    int b = 86;
    int c = sum(a, b);

    sum(5, 69);

    return 0;
}