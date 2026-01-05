#include <stdio.h>

int main()
{
    for (int i = 0; i < 15; i++)
    {
        if (i == 5)
        {
            //  break;// Exit this loop now!!(this will break the loop)
            continue; // Exit this iteration now!(this will skip the line i=5)
        }
        printf("i is %d\n", i);
    }
    printf("For loop is done");

    return 0;
}