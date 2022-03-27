#include <stdio.h>

int mymain(int e);

int main(void){
    int e = 0;
    printf("E: ");
    scanf("%d", &e);
    return mymain(e);
}

// void pour pas i/o
int mymain(int e){
    printf("e: %d ", e);
    if (e>1){
        return mymain(e-1);
    }
    else{
        return 0;
    }
}
