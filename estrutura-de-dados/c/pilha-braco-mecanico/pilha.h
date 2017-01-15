#ifndef PILHA_H_INCLUDED
#define PILHA_H_INCLUDED

typedef struct no
{
    int dado;
    struct No *prox;
} No;

typedef struct pilha
{
    No *inicio;
} Pilha;

Pilha *novaPilha();
Pilha *inicializaVetor(Pilha*[], int);
void liberaVetor(Pilha*[], int);
Pilha *push(Pilha*, int);
Pilha *pop(Pilha*);
No *topo(Pilha*);
int pilhaVazia(Pilha*);
int buscaElemento(Pilha*[], int, int);
void imprimePilha(Pilha*[], int);
Pilha *empilha(Pilha*, Pilha*);
Pilha *desempilha(Pilha*, int);
Pilha *desempilhaTudo(Pilha*);
Pilha *posicaoInicial(Pilha*[], Pilha*);
Pilha *inverterPilha(Pilha*[], int);
Pilha *coloqueEm(Pilha*[], int, int, int, int);
Pilha *coloqueNo(Pilha*[], int, int, int, int);
Pilha *empilhaEm(Pilha*[], int, int, int, int);
Pilha *empilhaNo(Pilha*[], int, int, int, int);

#endif // PILHA_H_INCLUDED
