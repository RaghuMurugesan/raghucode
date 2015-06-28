#include <stdio.h>
#include <string.h>

int main()
{
    char a[259];
    char b[256];
    a[1] = 'a';
    a[2] = 'b';
    a[3] = 'c';
    a[4] = 'd';
    a[5] = '\0';
    strncpy(b, a, sizeof(b));
    printf("%lu\n", sizeof(a));
    printf("%c\n", a[1]);
}
