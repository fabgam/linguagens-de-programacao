#include <stdio.h>
#include <stdlib.h>
#include "fila.h"
#include <string.h>
#include <time.h>

void menu();

void main()
{
    int i;
    char id[6];
    Queue *q = create_queue();

    srand(time(NULL));

    for(i = 0; i < 6; i++)
    {
        strcpy(id, gen_id());
        push(q, id);
    }
    print_queue(q);
    free(q);

    int key;
    printf("\nPressione ENTER para continuar...");
    key = getchar();

    if(key == 10)
        menu();
}

void menu()
{
    int n_lane, n_fingers, parked_airplanes;
    int min_lo_airplanes, max_lo_airplanes, min_la_airplanes, max_la_airplanes;

    printf("\nCONFIGURAÇÕES DO SISTEMA");
    printf("\nInforme o número de pistas: ");
    scanf("%d", &n_lane);
    printf("Informe o número de fingers: ");
    scanf("%d", &n_fingers);
    printf("Informe a quantidade de aeronaves estacionadas: ");
    scanf("%d", &parked_airplanes);
    printf("Informe a quantidade mínima de aeronaves que decolam: ");
    scanf("%d", &min_lo_airplanes);
    printf("Informe a quantidade máxima de aeronaves que decolam: ");
    scanf("%d", &max_lo_airplanes);
    printf("Informe a quantidade mínima de aeronaves que aterrissam: ");
    scanf("%d", &min_la_airplanes);
    printf("Informe a quantidade máxima de aeronaves que aterrissam: ");
    scanf("%d", &max_la_airplanes);
}
