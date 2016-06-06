/*  Ambiente de desenvolvimento:
    OS: Ubuntu 16.04 LTS
    IDE: CodeBlocks 16.01
    GCC: 5.3.1*/

#include <stdio.h>
#include <stdlib.h>
#include "fila.h"
#include <time.h>

//Protótipos das funções utilizadas
void config_menu(int);
void initialize_config(int, int, int, int, int, int, int, int);
void land_menu(Queue*[], Queue*[], Queue*[], Queue*, int, int, int, int, int, int, int);
void liftOff_menu(Queue*[], Queue*[], Queue*[], Queue*, int, int, int, int, int, int, int);
void before_menu(Queue*[], Queue*[], Queue*[], Queue*, int, int, int, int, int, int, int);
void waiting_menu(Queue*[], Queue*[], Queue*[], Queue*, int, int, int, int, int, int, int);
void lo_la_menu(Queue*[], Queue*[], Queue*[], Queue*, int, int, int, int, int, int, int);
void after_menu(Queue*[], Queue*[], Queue*[], Queue*, int, int, int, int, int, int, int);
void end_menu(Queue*[], Queue*[], Queue*[], Queue*, int, int, int, int, int, int, int);

void main()
{
    //Semente utilizada para a geração de strings e números aleatórios
    srand(time(NULL));

    //Contador para turno
    int shift = 0;

    //Chamada para o menu de configuração do sistema
    config_menu(shift);
}

//Menu de configuração do sistema
void config_menu(int shift)
{

    /* BREVE DESCRIÇÃO DAS VARIÁVEIS UTILIZADAS

    key = Será utilizada para capturar a tecla enter do teclado.
    n_lanes = Quantidade de pistas para aterrissagens e decolagens.
    n_fingers = Quantidade de fingers.
    parked_airplanes = Quantidade de aeronaves estacionadas.
    min_lo_airplanes = Quantidade minima de aeronaves para decolagem.
    max_lo_airplanes = Quantidade máxima de aeronaves para decolagem.
    min_la_airplanes = Quantidade minima de aeronaves para aterrissagem.
    max_la_airplanes = Quantidade máxima de aeronaves para aterrissagem. */

    int key = 0;
    int n_lanes = 0, n_fingers = 0, parked_airplanes = -1;
    int min_lo_airplanes = -1, max_lo_airplanes = -1, min_la_airplanes = -1, max_la_airplanes = -1;

    printf("CONFIGURAÇÕES DO SISTEMA");
    printf("\nInforme o número de pistas: ");
    while(n_lanes < 1 || n_lanes > 5)
        scanf("%d", &n_lanes);

    printf("Informe o número de fingers: ");
    while(n_fingers < 1 || n_fingers > 10)
        scanf("%d", &n_fingers);

    printf("Informe a quantidade de aeronaves estacionadas: ");
    while(parked_airplanes < 0 || parked_airplanes > n_fingers)
        scanf("%d", &parked_airplanes);

    printf("Informe a quantidade mínima de aeronaves que decolam: ");
    while(min_lo_airplanes < 0 || min_lo_airplanes > n_fingers)
        scanf("%d", &min_lo_airplanes);

    printf("Informe a quantidade máxima de aeronaves que decolam: ");
    while(max_lo_airplanes < min_lo_airplanes || max_lo_airplanes > n_fingers)
        scanf("%d", &max_lo_airplanes);

    printf("Informe a quantidade mínima de aeronaves que aterrissam: ");
    while(min_la_airplanes < 0)
        scanf("%d", &min_la_airplanes);

    printf("Informe a quantidade máxima de aeronaves que aterrissam: ");
    while(max_la_airplanes < min_la_airplanes)
        scanf("%d", &max_la_airplanes);

    while(key != 10)
    {
        key = getchar();

        if(key == 10)
            initialize_config(n_lanes, n_fingers, min_lo_airplanes, max_lo_airplanes,
                              min_la_airplanes, max_la_airplanes, parked_airplanes, shift);
    }
}

//Função para inicializar os vetores de filas que serão manipulados
void initialize_config(int n_lanes, int n_fingers, int min_lo_airplanes, int max_lo_airplanes,
                       int min_la_airplanes, int max_la_airplanes, int parked_airplanes, int shift)
{

    /* BREVE DESCRIÇÃO DAS VARIÁVEIS UTILIZADAS

    q_lo = Filas para pista de decolagem.
    q_la = Filas para pista de aterrissagem.
    q_fingers = Filas para fingers. */

    Queue *q_lo[n_lanes];
    q_lo[n_lanes] = initialize_vqueue(q_lo, n_lanes, 0);

    Queue *q_la[n_lanes];
    q_la[n_lanes] = initialize_vqueue(q_la, n_lanes, 0);

    Queue *q_fingers[n_fingers];
    q_fingers[n_fingers] = initialize_vqueue(q_fingers, n_fingers, parked_airplanes);

    Queue *q_wfingers = create_queue();

    land_menu(q_la, q_lo, q_fingers, q_wfingers, n_lanes, n_fingers, min_lo_airplanes,
              max_lo_airplanes, min_la_airplanes, max_la_airplanes, shift);

}

//Menu de aterrissagem
void land_menu(Queue *q_la[], Queue *q_lo[], Queue *q_fingers[], Queue *q_wfingers, int n_lanes, int n_fingers,
               int min_lo_airplanes, int max_lo_airplanes, int min_la_airplanes, int max_la_airplanes, int shift)
{
    /* BREVE DESCRIÇÃO DAS VARIÁVEIS UTILIZADAS

    key = Será utilizada para capturar a tecla enter do teclado.
    n = Receberá um valor aleatório. */

    int key = 0, n;

    n = random_n(min_la_airplanes, max_la_airplanes);

    printf("\nAPROXIMAÇÃO DE AERONAVES");
    printf("\nAproximaram %d novas aeronaves", n);

    //Se o valor aleatório for maior que Zero, as aeronaves serão inseridas nas filas de aterrissagem.
    if(n > 0)
    {
        printf("\n\nINSERÇÃO DAS AERONAVES NAS FILAS DE ATERRISSAGEM");
        insert_elements(q_la, n_lanes, n);
    }

    //Caso contrário o sistema será direcionado a próxima tela.
    printf("\nPressione ENTER para continuar...");
    while(key != 10)
    {
        key = getchar();

        if(key == 10)
            liftOff_menu(q_la, q_lo, q_fingers, q_wfingers, n_lanes, n_fingers, min_lo_airplanes,
                         max_lo_airplanes, min_la_airplanes, max_la_airplanes, shift);
    }
}

//Menu de decolagem
void liftOff_menu(Queue *q_la[], Queue *q_lo[], Queue *q_fingers[], Queue *q_wfingers, int n_lanes, int n_fingers,
                  int min_lo_airplanes, int max_lo_airplanes, int min_la_airplanes, int max_la_airplanes, int shift)
{

    /* BREVE DESCRIÇÃO DAS VARIÁVEIS UTILIZADAS

    key = Será utilizada para capturar a tecla enter do teclado.
    n = Receberá um valor aleatório. */

    int key = 0, n;

    n = random_n(min_lo_airplanes, max_lo_airplanes);

    printf("\n");
    printf("\nPREPARAÇÃO DE DECOLAGEM DE AERONAVES");
    printf("\nPreparam para decolar %d aeronaves", n);

    //Se o valor aleatório for maior que Zero, as aeronaves serão inseridas nas filas de decolagem.
    if(n > 0)
    {
        printf("\n\nTAXIAMENTO DE AERONAVES");
        insert_elements(q_lo, n_lanes, n);
    }

    //Caso contrário o sistema será direcionado a próxima tela.
    printf("\nPressione ENTER para continuar...");
    while(key != 10)
    {
        key = getchar();

        if(key == 10)
            before_menu(q_la, q_lo, q_fingers, q_wfingers, n_lanes, n_fingers, min_lo_airplanes,
                        max_lo_airplanes, min_la_airplanes, max_la_airplanes, shift);
    }
}

//Menu de pré decolagem e aterrissagem
void before_menu(Queue *q_la[], Queue *q_lo[], Queue *q_fingers[], Queue *q_wfingers, int n_lanes, int n_fingers,
                 int min_lo_airplanes, int max_lo_airplanes, int min_la_airplanes, int max_la_airplanes, int shift)
{
    int key = 0;

    printf("\nESTADO PRÉ DECOLAGEM/ATERRISSAGEM\n");

    printf("ATERRISSAGEM:\n");
    print_queue(q_la, n_lanes, 1);

    printf("DECOLAGEM:\n");
    print_queue(q_lo, n_lanes, 1);

    printf("FINGERS:\n");
    print_queue(q_fingers, n_fingers, 2);

    printf("\nPressione ENTER para continuar...");
    while(key != 10)
    {
        key = getchar();

        if(key == 10)
            waiting_menu(q_la, q_lo, q_fingers, q_wfingers, n_lanes, n_fingers, min_lo_airplanes,
                         max_lo_airplanes, min_la_airplanes, max_la_airplanes, shift);
    }
}

//Menu de espera
void waiting_menu(Queue *q_la[], Queue *q_lo[], Queue *q_fingers[], Queue *q_wfingers, int n_lanes, int n_fingers,
                  int min_lo_airplanes, int max_lo_airplanes, int min_la_airplanes, int max_la_airplanes, int shift)
{
    int key = 0, n;

    n = random_n(min_lo_airplanes, max_lo_airplanes);

    if(is_Empty(q_wfingers))
        n = 0;

    else if(n > count_elements(q_wfingers))
    {
        n = count_elements(q_wfingers);

        if(n > count_free_finger(q_fingers, n_fingers))
            n = count_free_finger(q_fingers, n_fingers);
    }

    printf("\nSAÍDA DA FILA DE ESPERA\n");
    printf("Saíram da fila de espera %d aeronaves", n);

    w_fingers(q_fingers, q_wfingers, n_fingers, n);

    printf("\nPressione ENTER para continuar...");
    while(key != 10)
    {
        key = getchar();

        if(key == 10)
            lo_la_menu(q_la, q_lo, q_fingers, q_wfingers, n_lanes, n_fingers, min_lo_airplanes,
                       max_lo_airplanes, min_la_airplanes, max_la_airplanes, shift);
    }
}

//Menu de aterrissagens e decolagens
void lo_la_menu(Queue *q_la[], Queue *q_lo[], Queue *q_fingers[], Queue *q_wfingers, int n_lanes, int n_fingers,
                int min_lo_airplanes, int max_lo_airplanes, int min_la_airplanes, int max_la_airplanes, int shift)
{
    int key = 0, x, y;

    x = random_n(min_la_airplanes, n_lanes);
    y = random_n(min_lo_airplanes, n_lanes);

    printf("\nATERRISSAGENS:\n");

    if(x > count_qelements(q_la, n_lanes))
        x = count_qelements(q_la, n_lanes);

    printf("Aterrissaram %d aeronaves\n", x);

    if(x > 0)
    {
        if(count_free_finger(q_fingers, n_fingers) == 0)
            land_wq(q_la, q_wfingers, n_lanes, x);

        else if(x <= count_free_finger(q_fingers, n_fingers))
            land(q_la, q_fingers, n_lanes, n_fingers, x);

        else if(x > count_free_finger(q_fingers, n_fingers))
        {
            land(q_la, q_fingers, n_lanes, n_fingers, count_free_finger(q_fingers, n_fingers));
            land_wq(q_la, q_wfingers, n_lanes, (x - count_free_finger(q_fingers, n_fingers)));
        }
    }

    printf("\n\nDECOLAGENS:\n");

    if(y > count_qelements(q_lo, n_lanes))
        y = count_qelements(q_lo, n_lanes);

    printf("Decolaram %d aeronaves", y);

    if(y > 0)
        lift_off(q_lo, n_lanes, y);

    printf("\nPressione ENTER para continuar...");
    while(key != 10)
    {
        key = getchar();

        if(key == 10)
            after_menu(q_la, q_lo, q_fingers, q_wfingers, n_lanes, n_fingers, min_lo_airplanes,
                       max_lo_airplanes, min_la_airplanes, max_la_airplanes, shift);
    }
}

//Menu PÓS decolagem e aterrissagem
void after_menu(Queue *q_la[], Queue *q_lo[], Queue *q_fingers[], Queue *q_wfingers, int n_lanes, int n_fingers,
                int min_lo_airplanes, int max_lo_airplanes, int min_la_airplanes, int max_la_airplanes, int shift)
{
    printf("\nESTADO PÓS DECOLAGEM/ATERRISSAGEM\n");

    printf("ATERRISSAGEM:\n");
    print_queue(q_la, n_lanes, 1);

    printf("DECOLAGEM:\n");
    print_queue(q_lo, n_lanes, 1);

    printf("FINGERS:\n");
    print_queue(q_fingers, n_fingers, 2);

    printf("\nDeseja continuar a simulação? (0 - Não  1 - Sim): ");
    end_menu(q_la, q_lo, q_fingers, q_wfingers, n_lanes, n_fingers, min_lo_airplanes,
             max_lo_airplanes, min_la_airplanes, max_la_airplanes, shift);
}

//Menu final, onde ser decidido se o usuário prossegue a simulação ou se a encerra.
void end_menu(Queue *q_la[], Queue *q_lo[], Queue *q_fingers[], Queue *q_wfingers, int n_lanes, int n_fingers,
              int min_lo_airplanes, int max_lo_airplanes, int min_la_airplanes, int max_la_airplanes, int shift)
{
    int op;

    scanf("%d", &op);

    switch(op)
    {
    case 0:
        end_execution(q_la, q_lo, q_fingers, n_lanes, n_fingers);
        free(q_wfingers);
        exit(0);
        break;
    case 1:
        update_shift(q_fingers, q_wfingers, n_fingers);
        shift++;
        land_menu(q_la, q_lo, q_fingers, q_wfingers, n_lanes, n_fingers, min_lo_airplanes,
                  max_lo_airplanes, min_la_airplanes, max_la_airplanes, shift);
        break;
    default:
        printf("\nOpção inválida.\n");
        end_menu(q_la, q_lo, q_fingers, q_wfingers, n_lanes, n_fingers, min_lo_airplanes,
                 max_lo_airplanes, min_la_airplanes, max_la_airplanes, shift);
        break;
    }
}
