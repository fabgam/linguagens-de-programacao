#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define vAlunos_TAM 30
#define sizeOfMatricula 8
#define nome_TAM 15
#define ica_TAM 4
#define testProva_TAM 2
#define media_TAM 3
#define situacao_TAM 33

struct Aluno
{
    int matricula;
    char nome[nome_TAM];
    char sobrenome[nome_TAM];
    int ica[ica_TAM];
    int teste[testProva_TAM];
    int prova[testProva_TAM];
    int frequencia;
    int medias[media_TAM];
    char situacao[situacao_TAM];
};

struct Aluno aluno[vAlunos_TAM];

void menuPrincipal();
void menuCadastro();
void menuFrequencia();
void menuNotas();
void menuRelatorio();
void inserirAluno(int);
void alterarAluno();
void excluirAluno();
void inserirFrequencia(int);
void inserirNotas(int);
void calcularMedias(int);
void atualizarSituacao(int);
void zerarNotas(int);
void exibirAlunos();
void exibirSituacaoAlunos(int);
void iniResetaVetorAluno(int);
int proximoVazio();
int isListaVazia();
int isMatriculaExistente(int);
int isMatriculaInt(char[]);
int isDadosValidos(char[]);
int isNotasValidas(int, int);
int isNomeValido(char[]);

int main(int argc, char **argv)
{
    for (;;)
        menuPrincipal();

    return 0;
}

void menuPrincipal()
{
    char op[2];

    printf ("\nMENU PRINCIPAL");
    printf ("\n1. Cadastro");
    printf ("\n2. Frequência");
    printf ("\n3. Notas das avaliações");
    printf ("\n4. Relatórios");
    printf ("\n5. Sair");
    printf ("\nDigite a sua opção: ");
    scanf ("%s", op);

    if (isDadosValidos(op) == 0)
    {
        switch (atoi(op))
        {
        case 1:
            menuCadastro();
            break;
        case 2:
            menuFrequencia();
            break;
        case 3:
            menuNotas();
            break;
        case 4:
            menuRelatorio();
            break;
        case 5:
            exit(0);
        default:
            printf ("\nOpção inválida.\n");
            menuPrincipal();
            break;
        }
    }
    else
    {
        printf ("\nEntrada inválida.\n");
        menuPrincipal();
    }
}

void menuCadastro()
{
    char op[2];

    printf ("\nMENU CADASTRO");
    printf ("\n1. Inserir aluno");
    printf ("\n2. Alterar aluno");
    printf ("\n3. Excluir aluno");
    printf ("\n4. Exibir alunos");
    printf ("\n5. Voltar ao menu principal");
    printf ("\nDigite a sua opção: ");
    scanf ("%s", op);

    if (isDadosValidos(op) == 0)
    {
        switch (atoi(op))
        {
        case 1:
            inserirAluno(proximoVazio(aluno));
            break;
        case 2:
            alterarAluno();
            break;
        case 3:
            excluirAluno();
            break;
        case 4:
            exibirAlunos();
            break;
        case 5:
            menuPrincipal();
            break;
        default:
            printf ("\nOpção inválida.\n");
            menuCadastro();
            break;
        }
    }
    else
    {
        printf ("\nEntrada inválida.\n");
        menuCadastro();
    }
}

void menuFrequencia()
{
    char op[2];

    printf ("\nMENU FREQUÊNCIA");
    printf ("\n1. Inserir a frequência por aluno");
    printf ("\n2. Inserir a frequência para todos os alunos");
    printf ("\n3. Voltar ao menu principal");
    printf ("\nDigite a sua opção: ");
    scanf ("%s", op);

    if (isDadosValidos(op) == 0)
    {
        switch (atoi(op))
        {
        case 1:
            inserirFrequencia(atoi(op));
            break;
        case 2:
            inserirFrequencia(atoi(op));
            break;
        case 3:
            menuPrincipal();
            break;
        default:
            printf ("\nOpção inválida.\n");
            menuFrequencia();
            break;
        }
    }
    else
    {
        printf ("\nEntrada inválida.\n");
        menuFrequencia();
    }
}

void menuNotas()
{
    char op[2];

    printf ("\nMENU NOTAS DAS AVALIAÇÕES");
    printf ("\n1. Inserir notas por aluno");
    printf ("\n2. Inserir notas para todos os alunos");
    printf ("\n3. Voltar ao menu principal");
    printf ("\nDigite a sua opção: ");
    scanf ("%s", op);

    if (isDadosValidos(op) == 0)
    {
        switch (atoi(op))
        {
        case 1:
            inserirNotas(atoi(op));
            break;
        case 2:
            inserirNotas(atoi(op));
            break;
        case 3:
            menuPrincipal();
            break;
        default:
            printf ("\nOpção inválida.\n");
            menuNotas();
            break;
        }
    }
    else
    {
        printf ("\nEntrada inválida.\n");
        menuNotas();
    }
}

void menuRelatorio()
{
    char op[2];

    printf ("\nMENU RELATÓRIO");
    printf ("\n1. Todos os alunos");
    printf ("\n2. Alunos aprovados");
    printf ("\n3. Alunos reprovados");
    printf ("\n4. Por nome do aluno");
    printf ("\n5. Voltar ao menu principal");
    printf ("\nDigite a sua opção: ");
    scanf ("%s", op);

    if (isDadosValidos(op) == 0)
    {
        switch (atoi(op))
        {
        case 1:
            exibirSituacaoAlunos(atoi(op));
            break;
        case 2:
            exibirSituacaoAlunos(atoi(op));
            break;
        case 3:
            exibirSituacaoAlunos(atoi(op));
            break;
        case 4:
            exibirSituacaoAlunos(atoi(op));
            break;
        case 5:
            menuPrincipal();
            break;
        default:
            printf ("\nOpção inválida.\n");
            menuRelatorio();
            break;
        }
    }
    else
    {
        printf ("\nEntrada inválida.\n");
        menuRelatorio();
    }
}

void inserirAluno(int x)
{
    char matricula[sizeOfMatricula], nome[nome_TAM], sobrenome[nome_TAM];

    if (x != -1)
    {
        printf ("\nMatrícula: ");
        scanf ("%s", matricula);

        if (isMatriculaInt(matricula) == 0 && atoi(matricula) > 0)
        {
            if (isMatriculaExistente(atoi(matricula)) == 0)
                printf ("\nMatrícula já cadastrada no sistema.\n");
            else
            {
                printf ("Nome e sobrenome: ");
                scanf ("%s %s", nome, sobrenome);

                if (isNomeValido(nome) == 0 && isNomeValido(sobrenome) == 0)
                {
                    aluno[x].matricula = atoi(matricula);
                    strcpy (aluno[x].nome, nome);
                    strcpy (aluno[x].sobrenome, sobrenome);
                    strcpy (aluno[x].situacao, "Notas e frequência não inseridas.");
                    zerarNotas(x);

                    printf ("\nCadastro efetuado com sucesso.\n");
                }
                else
                    printf ("\nDados inválidos.\n");
            }
        }
        else
            printf ("\nMatrícula inválida.\n");
    }
    else
        printf ("\nLista cheia.\n");

    menuCadastro();
}

void alterarAluno()
{
    if (isListaVazia(aluno) == 0)
    {
        char matricula[sizeOfMatricula];

        printf ("\nMatrícula: ");
        scanf ("%s", matricula);

        if (isMatriculaInt(matricula) == 0 && atoi(matricula) > 0)
        {
            if (isMatriculaExistente(atoi(matricula)) == 0)
            {
                int i;

                for (i = 0; i < vAlunos_TAM; i++)
                {
                    if (aluno[i].matricula == atoi(matricula))
                    {
                        char nome[nome_TAM], sobrenome[nome_TAM];

                        printf ("Nome: ");
                        scanf ("%s %s", nome, sobrenome);

                        if (isNomeValido(nome) == 0 && isNomeValido(sobrenome) == 0)
                        {
                            strcpy (aluno[i].nome, nome);
                            strcpy (aluno[i].sobrenome, sobrenome);
                            printf ("\nCadastro alterado com sucesso.\n");
                        }
                        else
                            printf ("\nDados inválidos.\n");
                    }
                }
            }
            else
                printf ("\nMatrícula inexistente.\n");
        }
        else
            printf ("\nMatrícula inválida.\n");
    }
    else
        printf ("\nNenhum aluno cadastrado no sistema.\n");

    menuCadastro();
}

void excluirAluno()
{
    if (isListaVazia(aluno) == 0)
    {
        char matricula[sizeOfMatricula];

        printf ("\nMatrícula: ");
        scanf ("%s", matricula);

        if (isMatriculaInt(matricula) == 0 && atoi(matricula) > 0)
        {
            if (isMatriculaExistente(atoi(matricula)) == 0)
            {
                printf("\nMatrícula: %d", aluno[atoi(matricula)-1].matricula);
                printf("\nNome: %s %s\n", aluno[atoi(matricula)-1].nome, aluno[atoi(matricula)-1].sobrenome);

                int resposta;
                printf("\nDeseja excluir a matrícula do sistema?");
                printf("\n1 - Sim, 2 - Não\n");
                scanf("%d", &resposta);

                if(resposta == 1)
                {
                    int i;
                    for (i = 0; i < vAlunos_TAM; i++)
                    {
                        if (aluno[i].matricula == atoi(matricula))
                            iniResetaVetorAluno(i);
                    }
                    printf ("\nCadastro excluído com sucesso.\n");
                }
                else if(resposta == 2)
                    menuCadastro();
                else
                    printf("\nOpção inválida.\n");
            }
            else
                printf ("\nMatrícula não cadastrada no sistema.\n");
        }
        else
            printf ("\nMatrícula inválida.\n");
    }
    else
        printf ("\nNenhum aluno cadastrado no sistema.\n");

    menuCadastro();
}

void inserirFrequencia(int op)
{
    int i;
    char frequencia[3];

    if (isListaVazia(aluno) == 0)
    {
        if (op == 1)
        {
            char matricula[sizeOfMatricula];

            printf ("\nMatrícula: ");
            scanf ("%s", matricula);

            if (isMatriculaInt(matricula) == 0 && atoi(matricula) > 0)
            {
                if (isMatriculaExistente(atoi(matricula)) == 0)
                {
                    for (i = 0; i < vAlunos_TAM; i++)
                    {
                        if (aluno[i].matricula == atoi(matricula))
                        {
                            printf ("Nome: %s %s", aluno[i].nome, aluno[i].sobrenome);
                            printf ("\nDigite a quantidade total de faltas do aluno: ");
                            scanf ("%s", frequencia);

                            if (isDadosValidos(frequencia) == 0)
                            {
                                aluno[i].frequencia = atoi(frequencia);
                                atualizarSituacao(i);
                                printf ("\nFrequência salva com sucesso.\n");
                            }
                            else
                                printf("\nEntrada inválida.\n");
                        }
                    }
                }
                else
                    printf ("\nMatrícula inexistente.\n");
            }
            else
                printf ("\nMatrícula inválida.\n");
        }
        else
        {
            for (i = 0; i < vAlunos_TAM; i++)
            {
                if (aluno[i].matricula != 0)
                {
                    printf ("\nMatrícula: %d", aluno[i].matricula);
                    printf ("\nNome: %s %s", aluno[i].nome, aluno[i].sobrenome);
                    printf ("\nDigite a quantidade total de faltas do aluno: ");
                    scanf ("%s", frequencia);

                    if (isDadosValidos(frequencia) == 0)
                    {
                        aluno[i].frequencia = atoi(frequencia);
                        atualizarSituacao(i);
                        printf ("\nFrequência salva com sucesso.\n");
                    }
                    else
                        printf("\nEntrada inválida.\n");
                }
            }
        }
    }
    else
        printf ("\nNenhum aluno cadastrado no sistema.\n");

    menuPrincipal();
}

void inserirNotas(int op)
{
    int i, x, teste[testProva_TAM], prova[testProva_TAM], ica[ica_TAM];

    if (isListaVazia(aluno) == 0)
    {
        if (op == 1)
        {
            char matricula[sizeOfMatricula];

            printf ("\nMatrícula: ");
            scanf ("%s", matricula);

            if (isMatriculaInt(matricula) == 0 && atoi(matricula) > 0)
            {
                if (isMatriculaExistente(atoi(matricula)) == 0)
                {
                    for (x = 0; x < vAlunos_TAM; x++)
                    {
                        if (aluno[x].matricula == atoi(matricula))
                        {
                            printf ("\nNome: %s %s", aluno[x].nome, aluno[x].sobrenome);
                            printf ("\n");
                            for (i = 0; i < testProva_TAM; i++)
                            {
                                printf ("Teste %d: ", i + 1);
                                scanf ("%d", &teste[i]);

                                printf ("Prova %d: ", i + 1);
                                scanf ("%d", &prova[i]);

                                if (isNotasValidas(teste[i], 1) == 0 && isNotasValidas(prova[i], 2) == 0)
                                {
                                    aluno[x].teste[i] = teste[i];
                                    aluno[x].prova[i] = prova[i];
                                }
                                else
                                {
                                    printf ("\nDados inválidos.\n");
                                    zerarNotas(i);
                                }
                            }
                            printf("\n");
                            for (i = 0; i < ica_TAM; i++)
                            {
                                printf ("ICA %d: ", i + 1);
                                scanf ("%d", &ica[i]);

                                if (isNotasValidas(ica[i], 3) == 0)
                                    aluno[x].ica[i] = ica[i];
                                else
                                {
                                    printf ("\nDados inválidos.\n");
                                    zerarNotas(i);
                                }
                            }
                            calcularMedias(x);
                            atualizarSituacao(x);
                        }
                    }
                    printf ("\nNotas salvas com sucesso.\n");
                }
                else
                    printf ("\nMatrícula inexistente.\n");
            }
            else
                printf ("\nMatrícula inválida.\n");
        }
        else
        {
            for (x = 0; x < vAlunos_TAM; x++)
            {
                if (aluno[x].matricula != 0)
                {
                    printf ("\nMatrícula: %d", aluno[x].matricula);
                    printf ("\nNome: %s %s", aluno[x].nome, aluno[x].sobrenome);
                    printf("\n");
                    for (i = 0; i < testProva_TAM; i++)
                    {
                        printf ("Teste %d: ", i + 1);
                        scanf ("%d", &teste[i]);

                        printf ("Prova %d: ", i + 1);
                        scanf ("%d", &prova[i]);

                        if (isNotasValidas(teste[i], 1) == 0 && isNotasValidas(prova[i], 2) == 0)
                        {
                            aluno[x].teste[i] = teste[i];
                            aluno[x].prova[i] = prova[i];
                        }
                        else
                        {
                            printf ("\nDados inválidos.\n");
                            zerarNotas(i);
                        }
                    }
                    printf("\n");
                    for (i = 0; i < ica_TAM; i++)
                    {
                        printf ("ICA %d: ", i + 1);
                        scanf ("%d", &ica[i]);

                        if (isNotasValidas(ica[i], 3) == 0)
                            aluno[x].ica[i] = ica[i];
                        else
                        {
                            printf ("\nDados inválidos.\n");
                            zerarNotas(i);
                        }
                    }
                    calcularMedias(x);
                    atualizarSituacao(x);
                }
            }
            printf ("\nNotas salvas com sucesso.\n");
        }
    }
    else
        printf ("\nNenhum aluno cadastrado no sistema.\n");

    menuPrincipal();
}

void calcularMedias(int x)
{
    aluno[x].medias[0] = ((aluno[x].ica[0] + aluno[x].ica[1]) + (2 * (aluno[x].teste[0] + aluno[x].prova[0]))) / 3;
    aluno[x].medias[1] = ((aluno[x].ica[2] + aluno[x].ica[3]) + (2 * (aluno[x].teste[1] + aluno[x].prova[1]))) / 3;
    aluno[x].medias[2] = (aluno[x].medias[0] + aluno[x].medias[1]) / 2;
}

void atualizarSituacao(int x)
{
    if (aluno[x].frequencia > 20 || aluno[x].medias[2] < 60)
    {
        if (aluno[x].frequencia > 20 && aluno[x].medias[2] < 60)
            strcpy (aluno[x].situacao, "Reprovado por falta e por nota.");
        else if (aluno[x].frequencia > 20)
            strcpy (aluno[x].situacao, "Reprovado por falta.");
        else
            strcpy (aluno[x].situacao, "Reprovado por nota.");
    }
    else
        strcpy (aluno[x].situacao, "Aprovado.");
}

void zerarNotas(int x)
{
    int i;

    for (i = 0; i < testProva_TAM; i++)
    {
        aluno[x].teste[i] = 0;
        aluno[x].prova[i] = 0;
    }
    for (i = 0; i < ica_TAM; i++)
        aluno[x].ica[i] = 0;

    for (i = 0; i < media_TAM; i++)
        aluno[x].medias[i] = 0;
}

void exibirAlunos()
{
    if (isListaVazia(aluno) == 0)
    {
        int i;

        for (i = 0; i < vAlunos_TAM; i++)
        {
            if (aluno[i].matricula != 0)
            {
                printf ("\nMatrícula: %d", aluno[i].matricula);
                printf ("\nNome: %s %s", aluno[i].nome, aluno[i].sobrenome);
                printf ("\n");
            }
        }
    }
    else
        printf ("\nNenhum aluno cadastrado no sistema.\n");

    menuCadastro();
}

void exibirSituacaoAlunos(int x)
{
    int i, y, cont = 0;

    if (isListaVazia(aluno) == 0)
    {
        if (x == 1)
        {
            for (i = 0; i < vAlunos_TAM; i++)
            {
                if (aluno[i].matricula != 0)
                {
                    printf ("\nMatrícula: %d", aluno[i].matricula);
                    printf ("\nNome: %s %s", aluno[i].nome, aluno[i].sobrenome);
                    printf ("\n");
                    for (y = 0; y < media_TAM - 1; y++)
                    {
                        printf ("MB%d: %d | ", y + 1, aluno[i].medias[y]);
                    }
                    printf ("MF: %d", aluno[i].medias[y]);
                    printf ("\nFaltas: %d", aluno[i].frequencia);
                    printf ("\nSituação: %s", aluno[i].situacao);
                    printf ("\n");

                    cont++;
                }
            }
        }
        else if (x == 2)
        {
            for (i = 0; i < vAlunos_TAM; i++)
            {
                if (aluno[i].matricula != 0 && strncmp(aluno[i].situacao, "Aprovado", 1) == 0)
                {
                    printf ("\nMatrícula: %d", aluno[i].matricula);
                    printf ("\nNome: %s %s", aluno[i].nome, aluno[i].sobrenome);
                    printf ("\n");
                    for (y = 0; y < media_TAM - 1; y++)
                    {
                        printf ("MB%d: %d | ", y + 1, aluno[i].medias[y]);
                    }
                    printf ("MF: %d", aluno[i].medias[y]);
                    printf ("\nFaltas: %d", aluno[i].frequencia);
                    printf ("\nSituação: %s", aluno[i].situacao);
                    printf ("\n");
                    cont++;
                }
            }
            if (cont == 0)
                printf ("\nNenhum aluno aprovado.\n");
        }
        else if (x == 3)
        {
            for (i = 0; i < vAlunos_TAM; i++)
            {
                if (aluno[i].matricula != 0 && strncmp(aluno[i].situacao, "Reprovado", 1) == 0)
                {
                    printf ("\nMatrícula: %d", aluno[i].matricula);
                    printf ("\nNome: %s %s", aluno[i].nome, aluno[i].sobrenome);
                    printf ("\n");
                    for (y = 0; y < media_TAM - 1; y++)
                    {
                        printf ("MB%d: %d | ", y + 1, aluno[i].medias[y]);
                    }
                    printf ("MF: %d", aluno[i].medias[y]);
                    printf ("\nFaltas: %d", aluno[i].frequencia);
                    printf ("\nSituação: %s", aluno[i].situacao);
                    printf ("\n");
                    cont++;
                }
            }
            if (cont == 0)
                printf ("\nNenhum aluno reprovado.\n");
        }
        else
        {
            char name[nome_TAM], lastname[nome_TAM];
            int cont = 0;

            printf ("\nNome: ");
            scanf ("%s %s", name, lastname);

            if (isNomeValido(name) == 0 && isNomeValido(lastname) == 0)
            {
                for (i = 0; i < vAlunos_TAM; i++)
                {
                    if (strcmp(aluno[i].nome, name) == 0 && strcmp(aluno[i].sobrenome, lastname) == 0)
                    {
                        printf ("\nMatrícula: %d", aluno[i].matricula);
                        printf ("\nNome: %s %s", aluno[i].nome, aluno[i].sobrenome);
                        printf ("\n");
                        for (y = 0; y < media_TAM - 1; y++)
                        {
                            printf ("MB%d: %d | ", y + 1, aluno[i].medias[y]);
                        }
                        printf ("MF: %d", aluno[i].medias[y]);
                        printf ("\nFaltas: %d", aluno[i].frequencia);
                        printf ("\nSituação: %s", aluno[i].situacao);
                        printf ("\n");
                        cont++;
                    }
                }
                if (cont == 0)
                    printf ("\nAluno não cadastrado.\n");
            }
            else
                printf ("\nDados inválidos.\n");
        }
    }
    else
        printf ("\nNenhum aluno cadastrado no sistema.\n");

    menuRelatorio();
}

void iniResetaVetorAluno(int x)
{
    aluno[x].matricula = 0;
    aluno[x].nome[0] = '\0';
    aluno[x].sobrenome[0] = '\0';
    zerarNotas(x);
}

int proximoVazio()
{
    int i;

    for (i = 0; i < vAlunos_TAM; i++)
    {
        if (aluno[i].matricula == 0)
            return i;
    }
    return -1;
}

int isListaVazia()
{
    int i, cont = 0;

    for (i = 0; i < vAlunos_TAM; i++)
    {
        if (aluno[i].matricula != 0)
            cont++;
    }
    return (cont > 0) ? 0 : 1;
}

int isMatriculaExistente(int matricula)
{
    int i, x = 1;

    for (i = 0; i < vAlunos_TAM; i++)
    {
        if (aluno[i].matricula == matricula)
            x = 0;
    }
    return x;
}

int isMatriculaInt(char matricula[])
{
    char numerais[] = {'0','1','2','3','4','5','6','7','8','9'};
    int i, x, cont = 0;

    for (i = 0; i < strlen(numerais); i++)
    {
        for (x = 0; x < strlen(matricula); x++)
        {
            if (numerais[i] == matricula[x])
                cont++;
        }
    }
    return (cont == strlen(matricula)) ? 0 : 1;
}

int isDadosValidos(char dado[])
{
    char numerais[] = {'0','1','2','3','4','5','6','7','8','9'};
    int i, x, cont = 0;

    for (i = 0; i < strlen(numerais); i++)
    {
        for (x = 0; x < strlen(dado); x++)
        {
            if (numerais[i] == dado[x])
                cont++;
        }
    }
    return (cont == strlen(dado)) ? 0 : 1;
}

int isNotasValidas(int x, int y)
{
    if (y == 1)
        return (x >= 0 && x <= 30) ? 0 : 1;

    if (y == 2)
        return (x >= 0 && x <= 70) ? 0 : 1;

    if (y == 3)
        return (x >= 0 && x <= 50) ? 0 : 1;

    return -1;
}

int isNomeValido(char nome[])
{
    int i, cont = 0;

    for (i = 0; i < strlen(nome); i ++)
    {
        if (isalpha(nome[i]) == 0)
            cont++;
    }
    return cont;
}
