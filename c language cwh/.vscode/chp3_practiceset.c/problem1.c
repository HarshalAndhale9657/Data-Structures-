#include <stdio.h>

int main()
{
    int marks1, marks2, marks3, avg;
    avg = (marks1 + marks2 + marks3) / 3;

    printf("Enter marks of subject 1 : ");
    scanf("%d", &marks1);
    printf(" \n");
    printf("Enter marks of subject 2 : ");
    scanf("%d", &marks2);
    printf(" \n");
    printf("Enter marks of subject 3 : ");
    scanf("%d", &marks3);
    printf(" \n");

    if (avg > 40 && marks1 > 33 && marks2 > 33 && marks3 > 33)
        printf("Student is passed in exam");
    else
        printf("student is failed in exam");

    return 0;
}