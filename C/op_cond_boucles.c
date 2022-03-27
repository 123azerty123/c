#include <stdio.h>

int main(void){

    printf("%.2f\n", 3/2.0);

    int x = 0;
    x++;
    printf("%d\n", x);
    x+=2;
    printf("%d\n",x);

    // conditions, switch comme en JS
    0 ? printf("jojo bad\n") : printf("jojo good\n");

    // while et for comme en JS

    return 0;
}
