#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "pilha.h"

void op(Pilha*[], int);

int main(int argc, char **argv)
{
    int qtdPilhas;

    while(qtdPilhas < 1 || qtdPilhas > 24)
        scanf("%d", &qtdPilhas);

    Pilha *p[qtdPilhas];
    p[qtdPilhas] = inicializaVetor(p, qtdPilhas);

    op(p, qtdPilhas);
    return 0;
}

void op(Pilha *p[], int qtdPilhas)
{
    char comando1[7], comando2[2];
    int num1, num2, pilhaOrigemNum1, pilhaOrigemNum2;

    for(;;)
    {
        scanf("%s", comando1);

        if(strcmp(comando1, "fim") == 0)
        {
            inverterPilha(p, qtdPilhas);
            imprimePilha(p, qtdPilhas);
            liberaVetor(p, qtdPilhas);
            exit(0);
        }
        scanf("%d %s %d", &num1, comando2, &num2);

        pilhaOrigemNum1 = buscaElemento(p, qtdPilhas, num1);
        pilhaOrigemNum2 = buscaElemento(p, qtdPilhas, num2);

        if(num1 != num2 && num1 >= 0 && num1 < qtdPilhas && num2 >= 0 && num2 < qtdPilhas)
        {
            if(pilhaOrigemNum1 != pilhaOrigemNum2)
            {
                if(strcmp(comando1, "coloque") == 0)
                {
                    if(strcmp(comando2, "em") == 0)
                        coloqueEm(p, num1, num2, pilhaOrigemNum1, pilhaOrigemNum2);
                    else if(strcmp(comando2, "no") == 0)
                        coloqueNo(p, num1, num2, pilhaOrigemNum1, pilhaOrigemNum2);
                }
                else if(strcmp(comando1, "empilhe") == 0)
                {
                    if(strcmp(comando2, "em") == 0)
                        empilhaEm(p, num1, num2, pilhaOrigemNum1, pilhaOrigemNum2);
                    else if(strcmp(comando2, "no") == 0)
                        empilhaNo(p, num1, num2, pilhaOrigemNum1, pilhaOrigemNum2);
                }
            }
            /* PARA EXIBIR A PILHA A CADA COMANDO DIGITADO DESCOMENTE A LINHA ABAIXO
            imprimePilha(p, qtd); */
        }
    }
}
