/*
    AMBIENTE DE DESENVOLVIMENTO
    OS: LINUX
    DISTRIBUIÇÃO: FEDORA 23
    GCC: 5.3.1
    IDE: CODEBLOCKS 13.12
*/

#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"

//FUNÇÃO PARA CRIAR UMA NOVA PILHA
Pilha *novaPilha()
{
    Pilha *p = (Pilha*)malloc(sizeof(Pilha));
    p->inicio = NULL;
    return p;
}

//FUNÇÃO PARA INICIALIZAR O VETOR DE PILHAS
Pilha *inicializaVetor(Pilha *p[], int qtd)
{
    int i;
    for(i = 0; i < qtd; i++)
    {
        p[i] = novaPilha();
        push(p[i], i);
    }
    return p;
}

//FUNÇÃO PARA LIBERAR O VETOR DE PILHAS
Pilha *liberaVetor(Pilha *p[], int qtd)
{
    int i;
    for(i = 0; i < qtd; i++)
        free(p[i]);

    return p;
}
//FUNÇÃO QUE INSERE UM NO EM UMA PILHA
Pilha *push(Pilha *p, int elem)
{
    No *novoNo = (No*)malloc(sizeof(No));
    novoNo->dado = elem;
    novoNo->prox = p->inicio;
    p->inicio = novoNo;
    return p;
}

//FUNÇÃO QUE ELIMINA UM NO DE UMA PILHA
Pilha *pop(Pilha *p)
{
    No *aux = p->inicio->prox;
    free(p->inicio);
    p->inicio = aux;
    return p;
}

//FUNÇÃO QUE RETORNA O TOPO DA PILHA
No *topo(Pilha *p)
{
    if(pilhaVazia(p))
        return NULL;
    else
        return p->inicio;
}

//FUNÇÃO PARA VERIFICAR SE A PILHA ESTÁ VAZIA
int pilhaVazia(Pilha *p)
{
    if(p->inicio == NULL)
        return 1;
    else
        return 0;
}

//FUNÇÃO PARA PROCURAR A PILHA EM QUE O ELEMENTO ESTÁ INSERIDO
int buscaElemento(Pilha *p[], int qtd, int elem)
{
    int i;
    for(i = 0; i < qtd; i++)
    {
        if(!pilhaVazia(p[i]))
        {
            No *aux = p[i]->inicio;
            while(aux != NULL)
            {
                if(aux->dado == elem)
                    return i;
                else
                    aux = aux->prox;
            }
        }
    }
    return -1;
}

//FUNÇÃO PARA IMPRIMIR O VETOR DE PILHAS
void imprimePilha(Pilha *p[], int qtd)
{
    int i;

    for(i = 0; i < qtd; i++)
    {
        No *aux = p[i]->inicio;
        printf("\n%d: ", i);
        while(aux != NULL)
        {
            printf("%d ", aux->dado);
            aux = aux->prox;
        }
    }
    printf("\n");
}

//FUNÇÃO PARA EMPILHAR UMA PILHA NO TOPO DE OUTRA PILHA
Pilha *empilha(Pilha *pilhaOrigem, Pilha *pilhaDestino)
{
    No *aux = pilhaOrigem->inicio;
    while(aux != NULL)
    {
        push(pilhaDestino, aux->dado);
        pop(pilhaOrigem);
        aux = aux->prox;
    }
    return pilhaDestino;
}

//FUNÇÃO PARA DESEMPILHAR OS ELEMENTOS DE UMA PILHA, ATÉ QUE ELA ENCONTRE O ELEMENTO PASSADO COMO PARÂMETRO
Pilha *desempilha(Pilha *p, int elem)
{
    No *aux = p->inicio;
    Pilha *pAux = novaPilha();

    while(aux->dado != elem)
    {
        push(pAux, aux->dado);
        pop(p);
        aux = aux->prox;
    }
    return pAux;
}

//FUNÇÃO PARA DESEMPILHAR TODOS OS ELEMENTOS DE UMA PILHA
Pilha *desempilhaTudo(Pilha *p)
{
    No *aux = p->inicio;
    Pilha *pAux = novaPilha();

    while(aux->dado != NULL)
    {
        push(pAux, aux->dado);
        pop(p);
        aux = aux->prox;
    }
    return pAux;
}

//FUNÇÃO PARA RETORNAR OS ELEMENTOS A SUA POSIÇÃO ORIGINAL
Pilha *posicaoInicial(Pilha *p[], Pilha *pilhaOrigem)
{
    No *aux = pilhaOrigem->inicio;
    while(aux != NULL)
    {
        if(pilhaVazia(p[aux->dado]))
        {
            push(p[aux->dado], aux->dado);
            pop(pilhaOrigem);
        }
        else
        {
            Pilha *pAux = desempilhaTudo(p[aux->dado]);
            push(p[aux->dado], aux->dado);
            pop(pAux);
            empilha(pAux, p[aux->dado]);
            free(pAux);
        }
        aux = aux->prox;
    }
    return p;
}

//FUNÇÃO PARA INVERTER O VETOR DE PILHAS
Pilha *inverterPilha(Pilha *p[], int qtd)
{
    int i;
    for(i = 0; i < qtd; i++)
    {
        Pilha *pAux = novaPilha();
        pAux = empilha(p[i], pAux);
        p[i]->inicio = pAux->inicio;
        free(pAux);
    }
    return p;
}

// FUNÇÃO QUE EXECUTARÁ O COMANDO COLOQUE EM
Pilha *coloqueEm(Pilha *p[], int n1, int n2, int pilhaOrigem, int pilhaDestino)
{
    //SE N1 OU N2 ESTIVEREM NO TOPO DE SUAS PÍLHAS, ESSE BLOCO SERÁ EXECUTADO
    if (topo(p[pilhaOrigem])->dado == n1 || topo(p[pilhaDestino])->dado == n2)
    {
        //SE N1 ESTIVER NO TOPO
        if(topo(p[pilhaOrigem])->dado == n1)
        {
            //SE N1 E N2 ESTIVEREM NO TOPO
            if(topo(p[pilhaDestino])->dado == n2)
            {
                push(p[pilhaDestino], n1);
                pop(p[pilhaOrigem]);
            }
            //SE N1 ESTÁ NO TOPO, E N2 NÃO, ESSE BLOCO SERÁ EXECUTADO
            else
            {
                Pilha *pAux = desempilha(p[pilhaDestino], n2);
                posicaoInicial(p, pAux);
                free(pAux);
                push(p[pilhaDestino], n1);
                pop(p[pilhaOrigem]);
            }
        }
        else
        {
            //SE N1 NÃO ESTIVER NO TOPO E N2 ESTIVER, ESSE BLOCO SERÁ EXECUTADO
            if(topo(p[pilhaDestino])->dado == n2)
            {
                Pilha *pAux = desempilha(p[pilhaOrigem], n1);
                posicaoInicial(p, pAux);
                free(pAux);
                push(p[pilhaDestino], n1);
                pop(p[pilhaOrigem]);
            }
        }
    }
    //SE N1 E N2 NÃO ESTIVEREM NO TOPO DE SUAS PILHAS, ESSE BLOCO SERÁ EXECUTADO
    else
    {
        Pilha *pAux1 = desempilha(p[pilhaOrigem], n1);
        Pilha *pAux2 = desempilha(p[pilhaDestino], n2);
        posicaoInicial(p, pAux1);
        free(pAux1);
        posicaoInicial(p, pAux2);
        free(pAux2);
        push(p[pilhaDestino], n1);
        pop(p[pilhaOrigem]);
    }
    return p;
}

// FUNÇÃO QUE EXECUTARÁ O COMANDO COLOQUE NO
Pilha *coloqueNo(Pilha *p[], int n1, int n2, int pilhaOrigem, int pilhaDestino)
{
    if(topo(p[pilhaOrigem])->dado == n1)
    { // SE N1 ESTIVER NO TOPO DA SUA PILHA ORIGEM ESTE BLOCO É EXECUTADO
        push(p[pilhaDestino], n1);
        pop(p[pilhaOrigem]);
    }
    else
    { // CASO CONTRÁRIO ESSE BLOCO SERÁ EXECUTADO
        Pilha *pAux = desempilha(p[pilhaOrigem], n1);
        posicaoInicial(p, pAux);
        free(pAux);
        push(p[pilhaDestino], n1);
        pop(p[pilhaOrigem]);
    }
    return p;
}

// FUNÇÃO QUE EXECUTARÁ O EMPILHE EM
Pilha *empilhaEm(Pilha *p[], int n1, int n2, int pilhaOrigem, int pilhaDestino)
{
//SE N1 OU N2 ESTIVEREM NO TOPO DE SUAS PÍLHAS, ESSE BLOCO SERÁ EXECUTADO
    if (topo(p[pilhaOrigem])->dado == n1 || topo(p[pilhaDestino])->dado == n2)
    {
        //SE N1 ESTIVER NO TOPO
        if(topo(p[pilhaOrigem])->dado == n1)
        {
            //SE N1 E N2 ESTIVEREM NO TOPO
            if(topo(p[pilhaDestino])->dado == n2)
            {
                push(p[pilhaDestino], n1);
                pop(p[pilhaOrigem]);
            }
            //SE N1 ESTÁ NO TOPO E N2 NÃO, ESSE BLOCO SERÁ EXECUTADO
            else
            {
                Pilha *pAux = desempilha(p[pilhaDestino], n2);
                posicaoInicial(p, pAux);
                free(pAux);
                push(p[pilhaDestino], n1);
                pop(p[pilhaOrigem]);
            }
        }
        else
        {
            //SE N1 NÃO ESTIVER NO TOPO E N2 ESTIVER ESSE BLOCO SERÁ EXECUTADO
            if(topo(p[pilhaDestino])->dado == n2)
            {
                Pilha *pAux = desempilha(p[pilhaOrigem], n1);
                push(p[pilhaDestino], n1);
                pop(p[pilhaOrigem]);
                empilha(pAux, p[pilhaDestino]);
                free(pAux);
            }
        }
    }
    //SE N1 E N2 NÃO ESTIVEREM NO TOPO DE SUAS PILHAS, ESSE BLOCO SERÁ EXECUTADO
    else
    {
        Pilha *pAux1 = desempilha(p[pilhaOrigem], n1);
        Pilha *pAux2 = desempilha(p[pilhaDestino], n2);
        posicaoInicial(p, pAux2);
        free(pAux2);
        push(p[pilhaDestino], n1);
        pop(p[pilhaOrigem]);
        empilha(pAux1, p[pilhaDestino]);
        free(pAux1);
    }
    return p;
}

// FUNÇÃO QUE EXECUTARÁ O EMPILHE NO
Pilha *empilhaNo(Pilha *p[], int n1, int n2, int pilhaOrigem, int pilhaDestino)
{
    if(topo(p[pilhaOrigem])->dado == n1)
    { // SE N1 ESTIVER NO TOPO ESSE BLOCO SERÁ EXECUTADO
        push(p[pilhaDestino], n1);
        pop(p[pilhaOrigem]);
    }
    else
    { // CASO CONTRÁRIO ESSE BLOCO É EXECUTADO
        Pilha *pAux = desempilha(p[pilhaOrigem], n1);
        push(p[pilhaDestino], n1);
        pop(p[pilhaOrigem]);
        empilha(pAux, p[pilhaDestino]);
        free(pAux);
    }
    return p;
}
