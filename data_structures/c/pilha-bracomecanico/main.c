/*
    AMBIENTE DE DESENVOLVIMENTO
    OS: LINUX
    DISTRIBUIÇÃO: FEDORA 23
    GCC: 5.3.1
    IDE: CODEBLOCKS 13.12
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "pilha.h"

//CHAMADA DE FUNÇÃO
void op(Pilha*[], int);

void main()
{
    //VARIÁVEL RESPONSÁVEL PELA QUANTIDADE DE PILHAS
    int qtd;

    //LEITURA DA QUANTIDADE DE PILHAS QUE SERÃO TRABALHADAS
    while(qtd < 1 || qtd > 24)
        scanf("%d", &qtd);

    //CRIAÇÃO DO VETOR DE PILHAS
    Pilha *p[qtd];
    //INICIALIZAÇÃO DO VETOR DE PILHAS
    p[qtd] = inicializaVetor(p, qtd);

    //CHAMADA DA FUNÇÃO QUE EXECUTARÁ OS COMANDOS DIGITADOS
    op(p, qtd);
}

//FUNÇÃO QUE FARA A LEITURA DA ENTRADA DO TECLADO E CHAMADA DAS FUNÇÕES DE MANIPULAÇÃO DAS PILHAS
void op(Pilha *p[], int qtd)
{
    char str1[7], str2[2];
    int n1, n2, x, y;

    for(;;)
    {
        scanf("%s", str1);

        /* QUANDO O USUÁRIO DIGITAR "FIM" ESSE BLOCO SERÁ EXECUTADO,
        PRIMEIRO IRÁ INVERTER A PILHA, EM SEGUIDA É CHAMADA A FUNÇÃO PÁRA EXIBIR A PILHA,
        AO FINAL O VETOR DE PILHAS É LIBERADO E O PROGRAMA TEM SUA EXECUÇÃO ENCERRADA. */
        if(strcmp(str1, "fim") == 0)
        {
            inverterPilha(p, qtd);
            imprimePilha(p, qtd);
            liberaVetor(p, qtd);
            exit(0);
        }
        scanf("%d %s %d", &n1, str2, &n2);

        x = buscaElemento(p, qtd, n1); // REPRESENTA A PILHA EM QUE N1 ESTÁ INSERIDO
        y = buscaElemento(p, qtd, n2); // REPRESENTA A PILHA EM QUE N2 ESTÁ INSERIDO

        if(n1 != n2 && n1 >= 0 && n1 < qtd && n2 >= 0 && n2 < qtd)
        {
            /* SE N1 E N2 FOREM NÚMEROS DIFERENTES E NÃO ESTIVEREM NA MESMA LISTA
                E ESTIVEREM DENTRO DO INTERVALO PREVIAMENTE DETERMINADO, ESSE BLOCO É EXECUTADO */
            if(x != y)
            {
                if(strcmp(str1, "coloque") == 0)
                {
                    if(strcmp(str2, "em") == 0)
                        coloqueEm(p, n1, n2, x, y); // EXECUÇÃO DO COMANDO COLOQUE EM
                    else if(strcmp(str2, "no") == 0)
                        coloqueNo(p, n1, n2, x, y); // EXECUÇÃO DO COMANDO COLQQUE NO
                }
                else if(strcmp(str1, "empilhe") == 0)
                {
                    if(strcmp(str2, "em") == 0)
                        empilhaEm(p, n1, n2, x, y); // EXECUÇÃO DO COMANDO EMPILHE EM
                    else if(strcmp(str2, "no") == 0)
                        empilhaNo(p, n1, n2, x, y); // EXECUÇÃO DO COMANDO EMPILHE NO
                }
            }
            //PARA EXIBIR A PILHA A CADA COMANDO DIGITADO DESCOMENTE A LINHA ABAIXO
            //imprimePilha(p, qtd);
        }
    }
}
