#include <stdio.h>

int main(void){

    char a = 1;
    char block;
    int x;
    int y;
    char map[8][8];
    for (int x=0;x<8;x++){
        for(int y=0;y<8;y++){
            map[x][y] = 35;
        }
    }

    while (a)
    {
        for (int x=0;x<8;x++){
            for(int y=0;y<8;y++){
                printf("[%c] ", map[x][y]);
            }
            printf("\n");
        }
        scanf("%d %d %d %c", &a, &x, &y, &block);
        map[x][y] = block;
    }
    

    return 0;
}