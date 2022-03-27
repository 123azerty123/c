#include <stdio.h>

int main(void){
    int aireDuCarre = 0; // declaration et affectation d'une variable entiere
    float progression = 0.75;
    signed char a = 120;
    signed char b = "A";
    const float PI = 3.141592624; // constante
    // un peu useless, c géré auto, déconseillé, a ne pas utiliser
    register char bidule = 3; // variable assignée au processeur, ULTRA RAPIDE maiiiis le processeur a que quelques Mo de ram
    volatile int bidule2 = 3; // variable oubligée a rester dans la ram

    aireDuCarre = 12;
    printf("%d %f %c %c %.3f \n", aireDuCarre, progression, a, b, PI);

    return 0;
}
