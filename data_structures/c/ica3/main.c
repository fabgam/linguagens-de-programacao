#include <stdio.h>
#include <stdlib.h>
#include "fila.h"
#include <string.h>
#include <time.h>

void main_menu();
void initialize_queues(int, int, int, int, int, int);
void land_menu(Queue*[], Queue*[], Queue*[], int, int, int, int, int, int);
void liftOff_menu(Queue*[], Queue*[], Queue*[], int, int, int, int, int, int);

void main()
{
    srand(time(NULL));

    main_menu();
}

//Menu principal do sistema
void main_menu()
{
    /*
    n_lanes = Quantidade de pistas para aterrissagens e decolagens.
    n_fingers = Quantidade de fingers.
    parked_airplanes = Quantidade de aeronaves estacionadas.
    min_lo_airplanes = Quantidade minima de aeronaves para decolagem.
    max_lo_airplanes = Quantidade máxima de aeronaves para decolagem.
    min_la_airplanes = Quantidade minima de aeronaves para aterrissagem.
    max_la_airplanes = Quantidade máxima de aeronaves para aterrissagem.
    */

    int key = 0;
    int n_lanes, n_fingers, parked_airplanes;
    int min_lo_airplanes, max_lo_airplanes, min_la_airplanes, max_la_airplanes;

    printf("CONFIGURAÇÕES DO SISTEMA");
    printf("\nInforme o número de pistas: ");
    scanf("%d", &n_lanes);
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

    while(key != 10)
    {
        key = getchar();

        if(key == 10)
            initialize_queues(n_lanes, n_fingers, min_lo_airplanes, max_lo_airplanes,
                              min_la_airplanes, max_la_airplanes);
    }
}

//Função para inicializar os vetores de filas que serão manipulados
void initialize_queues(int n_lanes, int n_fingers, int min_lo_airplanes, int max_lo_airplanes,
                       int min_la_airplanes, int max_la_airplanes)
{
    /*
    q_lo = Filas para pista de decolagem.
    q_la = Filas para pista de aterrissagem.
    q_fingers = Filas para fingers.
    */

    Queue *q_lo[n_lanes];
    q_lo[n_lanes] = initialize_queue(q_lo, n_lanes);

    Queue *q_la[n_lanes];
    q_la[n_lanes] = initialize_queue(q_la, n_lanes);

    Queue *q_fingers[n_fingers];
    q_fingers[n_fingers] = initialize_queue(q_fingers, n_fingers);

    land_menu(q_la, q_lo, q_fingers, n_lanes, n_fingers, min_lo_airplanes,
              max_lo_airplanes, min_la_airplanes, max_la_airplanes);
}

//Menu de aterrissagem
void land_menu(Queue *q_la[], Queue *q_lo[], Queue *q_fingers[], int n_lanes, int n_fingers,
               int min_lo_airplanes, int max_lo_airplanes, int min_la_airplanes, int max_la_airplanes)
{
    int key = 0, n;

    n = random_n(min_la_airplanes, max_la_airplanes);

    printf("\nAPROXIMAÇÃO DE AERONAVES");
    printf("\nAproximaram %d novas aeronaves", n);

    if(n > 0)
    {
        printf("\n\nINSERÇÃO DAS AERONAVES NAS FILAS DE ATERRISSAGEM");
        insert_elements(q_la, n_lanes, n);
    }

    printf("\nPressione ENTER para continuar...");
    while(key != 10)
    {
        key = getchar();

        if(key == 10)
            liftOff_menu(q_la, q_lo, q_fingers, n_lanes, n_fingers, min_lo_airplanes,
                         max_lo_airplanes, min_la_airplanes, max_la_airplanes);
    }
}

//Menu de decolagem
void liftOff_menu(Queue *q_la[], Queue *q_lo[], Queue *q_fingers[], int n_lanes, int n_fingers,
                  int min_lo_airplanes, int max_lo_airplanes, int min_la_airplanes, int max_la_airplanes)
{
    int key = 0, n;

    n = random_n(min_lo_airplanes, max_lo_airplanes);

    printf("\nPREPARAÇÃO DE DECOLAGEM DE AERONAVES");
    printf("\nPreparam para decolar %d aeronaves", n);
    printf("\n\nTAXIAMENTO DE AERONAVES");

    printf("\nPressione ENTER para continuar...");
    while(key != 10)
    {
        key = getchar();

        if(key == 10)
            end_execution(q_la, q_lo, q_fingers, n_lanes, n_fingers);
    }
}
