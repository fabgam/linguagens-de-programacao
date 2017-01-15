#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"

Pilha *novaPilha()
{
    Pilha *p = (Pilha*)malloc(sizeof(Pilha));
    p->inicio = NULL;
    return p;
}

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

void liberaVetor(Pilha *p[], int qtd)
{
    int i;
    for(i = 0; i < qtd; i++)
        free(p[i]);
}

Pilha *push(Pilha *p, int elem)
{
    No *novoNo = (No*)malloc(sizeof(No));
    novoNo->dado = elem;
    novoNo->prox = p->inicio;
    p->inicio = novoNo;
    return p;
}

Pilha *pop(Pilha *p)
{
    No *aux = p->inicio->prox;
    free(p->inicio);
    p->inicio = aux;
    return p;
}

No *topo(Pilha *p)
{
    return (pilhaVazia(p)) ? NULL : p->inicio;
}

int pilhaVazia(Pilha *p)
{
    return (p->inicio == NULL) ? 1 : 0;
}

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

Pilha *desempilhaTudo(Pilha *p)
{
    No *aux = p->inicio;
    Pilha *pAux = novaPilha();

    while(aux != NULL)
    {
        push(pAux, aux->dado);
        pop(p);
        aux = aux->prox;
    }
    return pAux;
}

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

Pilha *coloqueEm(Pilha *p[], int n1, int n2, int pilhaOrigem, int pilhaDestino)
{
    if (topo(p[pilhaOrigem])->dado == n1 || topo(p[pilhaDestino])->dado == n2)
    {
        Pilha *pAux = NULL;
        if(topo(p[pilhaOrigem])->dado == n1 && !topo(p[pilhaDestino])->dado == n2)
        {
            pAux = desempilha(p[pilhaDestino], n2);
        }
        else
        {
            if(topo(p[pilhaDestino])->dado == n2)
            {
                pAux = desempilha(p[pilhaOrigem], n1);
            }
        }
        posicaoInicial(p, pAux);
        free(pAux);
    }
    else
    {
        Pilha *pAux1 = desempilha(p[pilhaOrigem], n1);
        Pilha *pAux2 = desempilha(p[pilhaDestino], n2);
        posicaoInicial(p, pAux1);
        free(pAux1);
        posicaoInicial(p, pAux2);
        free(pAux2);
    }
    push(p[pilhaDestino], n1);
    pop(p[pilhaOrigem]);
    return p;
}

Pilha *coloqueNo(Pilha *p[], int n1, int n2, int pilhaOrigem, int pilhaDestino)
{
    if(!topo(p[pilhaOrigem])->dado == n1)
    {
        Pilha *pAux = desempilha(p[pilhaOrigem], n1);
        posicaoInicial(p, pAux);
        free(pAux);
    }
    push(p[pilhaDestino], n1);
    pop(p[pilhaOrigem]);
    return p;
}

Pilha *empilhaEm(Pilha *p[], int n1, int n2, int pilhaOrigem, int pilhaDestino)
{
    if (topo(p[pilhaOrigem])->dado == n1 || topo(p[pilhaDestino])->dado == n2)
    {
        if(topo(p[pilhaOrigem])->dado == n1)
        {
            if(!topo(p[pilhaDestino])->dado == n2)
            {
                Pilha *pAux = desempilha(p[pilhaDestino], n2);
                posicaoInicial(p, pAux);
                free(pAux);
            }
            push(p[pilhaDestino], n1);
            pop(p[pilhaOrigem]);
        }
        else
        {
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

Pilha *empilhaNo(Pilha *p[], int n1, int n2, int pilhaOrigem, int pilhaDestino)
{
    if(topo(p[pilhaOrigem])->dado == n1)
    {
        push(p[pilhaDestino], n1);
        pop(p[pilhaOrigem]);
    }
    else
    {
        Pilha *pAux = desempilha(p[pilhaOrigem], n1);
        push(p[pilhaDestino], n1);
        pop(p[pilhaOrigem]);
        empilha(pAux, p[pilhaDestino]);
        free(pAux);
    }
    return p;
}
