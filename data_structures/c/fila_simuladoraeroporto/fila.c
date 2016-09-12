/*  Ambiente de desenvolvimento:
    OS: Ubuntu 16.04 LTS
    IDE: CodeBlocks 16.01
    GCC: 5.3.1*/

#include <stdio.h>
#include <stdlib.h>
#include "fila.h"
#include <string.h>

//Função para criar uma fila
Queue *create_queue()
{
    Queue *q = (Queue*)malloc(sizeof(Queue));
    q->first = q->last = NULL;
    return q;
}

//Função para inicializar o vetor de filas
Queue *initialize_vqueue(Queue *q[], int n, int x)
{
    int i, count_n = 0;
    char id[8];

    for(i = 0; i < n; i++)
        q[i] = create_queue();

    if(x > 0)
    {
        i = 0;

        while(count_n != x)
        {
            strcpy(id, gen_id());

            push(q[i], id, 0);

            count_n++;
            i++;

            if(i == n)
                i = 0;
        }
    }
    return q;
}

//Função para liberar o vetor de filas
void *dequeue(Queue *q[], int n_lanes)
{
    int i;

    for(i = 0; i < n_lanes; i++)
        free(q[i]);
}

//Função para inserir um elemento na fila
Queue *push(Queue *q, char id[], int entry_sequence)
{
    Node *node = (Node*)malloc(sizeof(Node));

    strcpy(node->id, id);
    node->next = NULL;
    node->sequence_entry = entry_sequence;
    node->c_shift = 0;

    if(is_Empty(q))
        q->first = q->last = node;

    else
    {
        q->last->next = node;
        q->last = node;
    }
    return q;
}

//Função para remover um elemento da fila
Queue *pop(Queue *q)
{
    if(is_Empty(q))
        return NULL;

    else if(q->first == q->last)
    {
        free(q->first);
        q->first = q->last = NULL;
    }

    else
    {
        Node *aux = q->first->next;
        free(q->first);
        q->first = aux;
    }

    return q;
}

//Função para verificar se a fila está vazia
int is_Empty(Queue *q)
{
    return ((q->first == NULL) ? 1 : 0);
}

//Função para contar a quantidade de elementos de uma fila
int count_elements(Queue *q)
{
    int count = 0;

    if(!is_Empty(q))
    {
        Node *aux = q->first;

        while(aux != NULL)
        {
            count++;
            aux = aux->next;
        }
    }
    return count;
}

//Função para contar a quantidade de elementos em um vetor de fila
int count_qelements(Queue *q[], int n)
{
    int i, total = 0;

    for(i = 0; i < n; i++)
        total = total + count_elements(q[i]);

    return total;
}

//Função para retornar a quantidade de fingers livres
int count_free_finger(Queue *q[], int n)
{
    int i, count = 0;

    for(i = 0; i < n; i++)
    {
        if(is_Empty(q[i]))
            count++;
    }
    return count;
}

//Função para retornar o número de um finger livre
int free_finger(Queue *q[], int n)
{
    int i, f = -1;

    for(i = 0; i < n; i++)
    {
        if(is_Empty(q[i]))
        {
            f = i;
            break;
        }
    }
    return f;
}

//Função para gerar uma ID aleatória
char *gen_id()
{
    int n_random, aux, i;
    char *id = (char*)malloc(8 * sizeof(char));
    char *num = (char*)malloc(8 * sizeof(char));

    for(i = 0; i < 4; i++)
    {
        n_random = rand() % 10;
        num[i] = n_random + '0';
    }

    for(i = 0; i < 2; i++)
    {
        aux = (65 + rand() % (91-65));
        id[i] = (char)aux;
    }

    strcat(id, num);
    free(num);

    return id;
}

//Função para retornar um número aleatório entre o intervalo de min_n - max_n
int random_n(int min_n, int max_n)
{
    int n_random;

    return n_random = (min_n + rand() % (max_n - min_n));
}

//Função para retornar o maior turno registrado
int highest_shift(Queue *q[], int n_finger)
{
    int i, x = 0, p;

    for(i = 0; i < n_finger; i++)
    {
        if(!is_Empty(q[i]))
        {
            Node *aux = q[i]->first;

            if(aux->c_shift > x)
            {
                x = aux->c_shift;
                p = i;
            }
        }
    }
    return p;
}

//Função para procurar o maior número de entrada inserido
int highest_entry(Queue *q[], int n_lanes)
{
    int i, x = 0;

    for(i = 0; i < n_lanes; i++)
    {
        if(!is_Empty(q[i]))
        {
            Node *aux = q[i]->first;

            while(aux != NULL)
            {
                if(aux->sequence_entry > x)
                    x = aux->sequence_entry;

                aux = aux->next;
            }
        }
    }
    return x;
}

//Função para retornar a fila com a menor entrada
int smaller_entry(Queue *q[], int n_lanes)
{
    int i, x = 999999, p;

    for(i = 0; i < n_lanes; i++)
    {
        if(!is_Empty(q[i]))
        {
            if(q[i]->first->sequence_entry < x)
            {
                x = q[i]->first->sequence_entry;
                p = i;
            }
        }
    }
    return p;
}

//Função para procurar a fila com menos elementos inseridos
int search_entry(Queue *q[], int n_lanes)
{
    int i, p, y = 999999;

    for(i = 0; i < n_lanes; i++)
    {
        if(y > count_elements(q[i]))
        {
            y = count_elements(q[i]);
            p = i;
        }
    }
    return p;
}

//Função para inserir os elementos no vetor de fila
void insert_elements(Queue *q[], int n_lanes, int n)
{
    int i, count_n = 0;
    char id[8];

    while(count_n < n)
    {
        i = search_entry(q, n_lanes);

        strcpy(id, gen_id());

        printf("\nInserindo aeronave %s na fila da pista %d", id, i);
        push(q[i], id, (highest_entry(q, n_lanes) + 1));

        count_n++;
    }
}

//Função para atualizar as filas de aterrissagens e fingers
void land(Queue *q[], Queue *q_fingers[], int n_lanes, int n_fingers, int n)
{
    int i, count_n = 0, x;

    while(count_n < n)
    {
        i = smaller_entry(q, n_lanes);
        x = free_finger(q_fingers, n_fingers);
        Node *aux = q[i]->first;

        if(is_Empty(q_fingers[x]))
        {
            printf("\nAeronave %s aterrissou na Pista %d e estacionou no Finger %d", aux->id, i, x);
            push(q_fingers[x], aux->id, highest_entry(q_fingers, n_fingers));
            pop(q[i]);
            count_n++;
        }
    }
}

//Função de manipulação da lista de espera por um finger livre
void land_wq(Queue *q[], Queue *q_wfingers, int n_lanes, int n)
{
    int i, count_n = 0;

    while(count_n < n)
    {
        i = smaller_entry(q, n_lanes);

        if(!is_Empty(q[i]))
        {
            Node *aux = q[i]->first;

            printf("\nAeronave %s aterrissou na Pista %d e foi para a fila de espera", aux->id, i);
            push(q_wfingers, aux->id, 0);
            pop(q[i]);
            count_n++;
        }
    }
}

//Função para atualizar as decolagens de aeronaves
void lift_off(Queue *q[], int n_lanes, int n)
{
    int i, count_n = 0;

    while(count_n < n)
    {
        i = smaller_entry(q, n_lanes);

        if(!is_Empty(q[i]))
        {
            Node *aux = q[i]->first;

            printf("\nAeronave %s decolou da Pista %d", aux->id, i);
            pop(q[i]);
            count_n++;
        }
    }
}

//Função para movimentar as aeronaves dos fingers para a pista de decolagem
void f_qlo(Queue *q[], Queue *q_fingers[], int n_lanes, int n_fingers, int n)
{
    int i, x = 0, count_n = 0;
    char id[8];

    while(count_n < n)
    {
        i = search_entry(q, n_lanes);

        if(!is_Empty(q_fingers[x]))
        {
            Node *aux = q_fingers[x]->first;

            printf("\nInserindo aeronave %s na fila da pista %d", aux->id, i);
            push(q[i], aux->id, (highest_entry(q, n_lanes) + 1));
            pop(q_fingers[x]);
            count_n++;
        }
        x++;

        if(x == n_fingers)
            x = n_fingers;
    }
}

//Função para movimentar as aeronaves da lista de espera para os fingers livres
void w_fingers(Queue *q[], Queue *q_wfingers, int n_fingers, int n)
{
    int i = 0, count_n = 0;

    while(count_n < n)
    {
        i = free_finger(q, n_fingers);

        if(is_Empty(q[i]) && !is_Empty(q_wfingers))
        {
            Node *aux = q_wfingers->first;
            printf("\nAeronave %s deixou a fila de espera e estacionou no Finger %d", aux->id, i);
            push(q[i], aux->id, 0);
            pop(q_wfingers);
            count_n++;
        }
    }
}

//Função para imprimir um vetor de filas.
void print_queue(Queue *q[], int n, int display)
{
    int i;

    for(i = 0; i < n; i++)
    {
        Node *aux = q[i]->first;

        if(display == 1)
            printf("Pista %d: ", i);
        else
            printf("Finger %d: ", i);

        if(!is_Empty(q[i]))
        {
            while(aux != NULL)
            {
                printf("%s -> ", aux->id);
                aux = aux->next;
            }
        }
        printf("\n");
    }
}

//Função para atualizar os turnos das aeronaves que estiverem na fila de espera por um finger
void update_shift(Queue *q_fingers[], Queue *q_wfingers, int n_fingers)
{
    Node *aux = q_wfingers->first;

    if(!is_Empty(q_wfingers))
    {
        while(aux != NULL)
        {
            aux->c_shift++;
            aux = aux->next;
        }
    }

    int i;

    for(i = 0; i < n_fingers; i++)
    {
        if(!is_Empty(q_fingers[i]))
        {
            aux = q_fingers[i]->first;

            while(aux != NULL)
            {
                aux->c_shift++;
                aux = aux->next;
            }
        }
    }
}

//Função para liberar os vetores de filas utilizados
void end_execution(Queue *q_la[], Queue *q_lo[], Queue *q_fingers[], int n_lanes, int n_fingers)
{
    dequeue(q_la, n_lanes);
    dequeue(q_lo, n_lanes);
    dequeue(q_fingers, n_fingers);
}
