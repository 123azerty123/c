#include <stdio.h>

int main(void){

    int ageUser = 0;
    signed char charA = "A";

    printf("Caractere choisi: ");
    scanf("%c", &charA);

    printf("char: %c\n", charA);
    
    printf("Quel age avez-vous? ");
    scanf("%d", &ageUser);

    printf("Vous avez %d ans!\n", ageUser);


    return 0;
}