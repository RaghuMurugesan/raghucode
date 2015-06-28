#include <stdio.h>

int main()
{
    int a = -100;
    unsigned int b = 0;

    b = a;
if(b < 0)
    printf("%d [] %u\n", b, b);
    return (0);
}
