#ifndef FILA_H_INCLUDED
#define FILA_H_INCLUDED

#define TAM 6

typedef struct node
{
    char id[TAM];
    struct node *next;
} Node;

typedef struct q
{
    Node *first;
    Node *last;
} Queue;

Queue *create_queue();
Queue *push(Queue*, char[]);
Queue *pop(Queue*);
int is_Empty(Queue*);
Queue *first(Queue*);
Queue *last(Queue*);
int count_elements(Queue*);
char *gen_id();
Queue *initialize_lanes(int);
Queue *initialize_fingers(int);
void print_elements(Queue*);

#endif // FILA_H_INCLUDED
