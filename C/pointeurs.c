#include <stdio.h>

// pointeur: var qui contient l'adresse(0x12D37B08) d'une autre var
// &var: adresse de var(a afficher avec %p)
// point: adresse de la var *point: val de la var &point: adresse du point
// *point pour déclarer point

void inverser_nombre(int *pt_a, int *pt_b){
    int t = *pt_a;
    *pt_a = *pt_b;
    *pt_b = t;
    
}

int main(void){

    int numA = 100;
    int numB = 30;

    int *pt_sur_numA = &numA;
    int *pt_sur_numB = &numB;

    printf("A: %d %p, B:%d %p\n", numA, &numA, numB, &numB);

    inverser_nombre(pt_sur_numA, pt_sur_numB);

    printf("A: %d %p, B:%d %p\n", numA, &numA, numB, &numB);

    return 0;
}
