#include <stdio.h>

// si je mets static devant une fonction, elle ne peut etre utilisée que dans ce fichier

void bonjour(void){
    printf("cc\n");
}

int levelUp(void){
    // si j'ai bien compris, static est global(pas détruit a la fin de la fonction) et ne peut pas etre redéfini
    static int level = 0;
    level++;
    printf("niveau: %d\n", level);
    return level;
}