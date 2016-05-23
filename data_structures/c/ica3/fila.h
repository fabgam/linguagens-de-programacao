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
Queue *initialize_queue(Queue*[], int);
void *dequeue(Queue*[], int);
Queue *push(Queue*, char[]);
Queue *pop(Queue*);
int is_Empty(Queue*);
Node *first(Queue*);
Node *last(Queue*);
int count_elements(Queue*);
char *gen_id();
int random_n(int, int);
Queue *insert_elements(Queue*[], int, int);
void print_queue(Queue*[], int, int);
void end_execution(Queue*[], Queue*[], Queue*[], int, int);

#endif // FILA_H_INCLUDED
