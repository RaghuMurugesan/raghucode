#include "stdio.h"
#include "stdlib.h"

int main()
{
//    static unsigned int i = 2;
//    static int n = 0;
    u_int64_t i = 0xffffffffffffffff;
    double d;
//    i+=/2;
    d = (double)i;
/*    while(1){    
        scanf("%x", &i);
        i = i - 1;
        printf("num = %d\n", i);
*/
//        printf("\nsize of double = %d", sizeof(double));
        printf("\ndouble %lf , uint64 %lx",d,i);  
        printf("\ndouble %lx , uint64 %lu",d,i);  
//    }
}
