#ifndef FILA_H_INCLUDED
#define FILA_H_INCLUDED

typedef struct node
{
    char id[8];
    int sequence_entry;
    int c_shift;
    struct node *next;
} Node;

typedef struct q
{
    Node *first;
    Node *last;
} Queue;

Queue *create_queue();
Queue *initialize_vqueue(Queue*[], int);
void *dequeue(Queue*[], int);
Queue *push(Queue*, char[], int);
Queue *pop(Queue*);
int is_Empty(Queue*);
int q_empty(Queue*[], int);
Node *first_node(Queue*);
Node *last_node(Queue*);
int count_elements(Queue*, int);
int count_free_finger(Queue*[], int);
int free_finger(Queue*[], int);
char *gen_id();
int random_n(int, int);
void insert_elements(Queue*[], int, int);
int highest_entry(Queue*[], int);
int smaller_entry(Queue*[], int);
int search_entry(Queue*[], int);
void land(Queue*[], Queue*[], Queue*, int, int, int);
void land_wq(Queue*[], Queue*, int, int, int);
void lift_off(Queue*[], int, int);
void print_queue(Queue*[], int, int);
void update_shift(Queue*[], Queue *, int);
void end_execution(Queue*[], Queue*[], Queue*[], int, int);

#endif // FILA_H_INCLUDED
