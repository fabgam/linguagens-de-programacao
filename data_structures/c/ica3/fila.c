#include <stdio.h>
#include <stdlib.h>
#include "fila.h"
#include <string.h>

Queue *create_queue()
{
    Queue *q = (Queue*)malloc(sizeof(Queue));
    q->first = q->last = NULL;
    return q;
}

Queue *push(Queue *q, char id[])
{
    Node *n = (Node*)malloc(sizeof(Node));
    strcpy(n->id, id);
    n->next = NULL;

    if(is_Empty(q))
        q->first = q->last = n;
    else
    {
        q->last->next = n;
        q->last = n;
    }
    return q;
}

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

int is_Empty(Queue *q)
{
    return ((q->first == NULL) ? 1 : 0);
}

Node *first_node(Queue *q)
{
    return ((is_Empty(q)) ? NULL : q->first);
}

Node *last_node(Queue *q)
{
    return ((is_Empty(q)) ? NULL : q->last);
}

int count_elements(Queue *q)
{
    Node *aux = q->first;
    int count = 0;
    while(aux != NULL)
    {
        count++;
        aux = aux->next;
    }
    return count;
}

char *gen_id()
{
    int n_random, aux, i;
    char *id = (char*)malloc(6 * sizeof(char));
    char *num = (char*)malloc(6 * sizeof(char));

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
Queue *initialize_lanes(int n_lanes)
{
    int i;
    Queue *q_lanes[n_lanes];

    for(i = 0; i < n_lanes; i++)
        q_lanes[i] = create_queue();

    return q_lanes;
}

Queue *initialize_fingers(int n_fingers)
{
    int i;
    Queue *q_fingers[n_fingers];

    for(i = 0; i < n_fingers; i++)
        q_fingers[i] = create_queue();

    return q_fingers;
}

void print_queue(Queue *q)
{
    Node *aux = q->first;
    while(aux != NULL)
    {
        printf("%s -> ", aux->id);
        aux = aux->next;
    }
    printf("\n");
}


