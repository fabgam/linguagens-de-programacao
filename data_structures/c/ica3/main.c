#include <stdio.h>
#include <stdlib.h>
#include "fila.h"
#include <time.h>

void main_menu();
void initialize_config(int, int, int, int, int, int);
void land_menu(Queue*[], Queue*[], Queue*[], int, int, int, int, int, int, int, int);
void liftOff_menu(Queue*[], Queue*[], Queue*[], int, int, int, int, int, int, int, int);

void main()
{
    //Semente utilizada para a geração de strings e números aleatórios
    srand(time(NULL));

    main_menu();
}

//Menu principal do sistema
void main_menu()
{

    /*

    BREVE DESCRIÇÃO DAS VARIÁVEIS UTILIZADAS

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
            initialize_config(n_lanes, n_fingers, min_lo_airplanes, max_lo_airplanes,
                              min_la_airplanes, max_la_airplanes);
    }
}

//Função para inicializar os vetores de filas que serão manipulados
void initialize_config(int n_lanes, int n_fingers, int min_lo_airplanes, int max_lo_airplanes,
                       int min_la_airplanes, int max_la_airplanes)
{

    /*

    BREVE DESCRIÇÃO DAS VARIÁVEIS UTILIZADAS

    q_lo = Filas para pista de decolagem.
    q_la = Filas para pista de aterrissagem.
    q_fingers = Filas para fingers.

    */

    Queue *q_lo[n_lanes];
    q_lo[n_lanes] = initialize_vqueue(q_lo, n_lanes);

    Queue *q_la[n_lanes];
    q_la[n_lanes] = initialize_vqueue(q_la, n_lanes);

    Queue *q_fingers[n_fingers];
    q_fingers[n_fingers] = initialize_vqueue(q_fingers, n_fingers);

    int *LA_sequence = create_sequence();
    int *LO_sequence = create_sequence();

    land_menu(q_la, q_lo, q_fingers, n_lanes, n_fingers, min_lo_airplanes,
              max_lo_airplanes, min_la_airplanes, max_la_airplanes, LA_sequence, LO_sequence);

}

//Menu de aterrissagem
void land_menu(Queue *q_la[], Queue *q_lo[], Queue *q_fingers[], int n_lanes, int n_fingers, int min_lo_airplanes,
               int max_lo_airplanes, int min_la_airplanes, int max_la_airplanes, int LA_sequence, int LO_sequence)
{

    /*

    BREVE DESCRIÇÃO DAS VARIÁVEIS UTILIZADAS

    key = recebe o valor digitado e o transforma em um inteiro.
    n = recebe um valor aleatório.

    */

    int key = 0, n;

    n = random_n(min_la_airplanes, max_la_airplanes);

    printf("\nAPROXIMAÇÃO DE AERONAVES");
    printf("\nAproximaram %d novas aeronaves", n);

    if(n > 0)
    {
        printf("\n\nINSERÇÃO DAS AERONAVES NAS FILAS DE ATERRISSAGEM");
        insert_elements(q_la, n_lanes, n, LA_sequence);
    }

    printf("\nPressione ENTER para continuar...");
    while(key != 10)
    {
        key = getchar();

        if(key == 10)
            liftOff_menu(q_la, q_lo, q_fingers, n_lanes, n_fingers, min_lo_airplanes,
                         max_lo_airplanes, min_la_airplanes, max_la_airplanes, LA_sequence, LO_sequence);
    }
}

//Menu de decolagem
void liftOff_menu(Queue *q_la[], Queue *q_lo[], Queue *q_fingers[], int n_lanes, int n_fingers, int min_lo_airplanes,
                  int max_lo_airplanes, int min_la_airplanes, int max_la_airplanes, int LA_sequence, int LO_sequence)
{

    /*

    BREVE DESCRIÇÃO DAS VARIÁVEIS UTILIZADAS

    key = recebe o valor digitado e o transforma em um inteiro.
    n = recebe um valor aleatório.

    */

    int key = 0, n;

    n = random_n(min_lo_airplanes, max_lo_airplanes);

    printf("\nPREPARAÇÃO DE DECOLAGEM DE AERONAVES");
    printf("\nPreparam para decolar %d aeronaves", n);

    if(n > 0)
    {
        printf("\n\nTAXIAMENTO DE AERONAVES");
        insert_elements(q_lo, n_lanes, n, LO_sequence);
    }

    printf("\nPressione ENTER para continuar...");
    while(key != 10)
    {
        key = getchar();

        if(key == 10)
        {
            printf("\nLAND LANES\n");
            print_queue(q_la, n_lanes, 1);
            printf("\nLIFT OFF LANES\n");
            print_queue(q_lo, n_lanes, 1);
            end_execution(q_la, q_lo, q_fingers, n_lanes, n_fingers);
            free(LA_sequence);
            free(LO_sequence);
        }
    }
}
