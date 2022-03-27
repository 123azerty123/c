#include <stdio.h>

#define TAILLE_TAB 12

void test(int tab[], int taille_tableau);

int main(void){

    // déclaration d'un tableau
    int tableau[TAILLE_TAB] = {0, 1}; // [0, 1, 0, 0, 0, ...]
    tableau[0] = 11;

    test(tableau, TAILLE_TAB);

    return 0;
}

void test(int tab[], int taille_tableau){

    for (int i = 0; i < taille_tableau; i++)
    {
        printf("%d ", tab[i]);
    }
}
