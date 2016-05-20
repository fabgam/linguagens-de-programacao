/*
    ** AMBIENTE DE DESENVOLVIMENTO **
        OS: LINUX
        DISTRIBUIÇÃO: FEDORA 23
        IDE: CODEBLOCKS 13.12
        GCC: 5.3.1
*/

// BIBLIOTECAS UTILIZADAS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

// DEFINIÇÃO DE CONSTANTES PARA UTILIZAÇÃO NO CÓDIGO
#define vAlunos_TAM 30 // CONSTANTE UTILIZADA PARA DEFINIR O TAMANHO MÁXIMO PARA CADASTRO DE ALUNOS
#define sizeOfMatricula 8 // CONSTANTE UTILIZADA PARA DEFINIR O TAMANHO MÁXIMO DA MATRÍCULA DO ALUNO
#define nome_TAM 15 // CONSTANTE UTILIZADA PARA O TAMANHO DE NOME E SOBRENOME
#define ica_TAM 4 // CONSTANTE UTILIZADA PARA O VETOR QUE IRÁ GUARDAR AS NOTAS DOS ICAS
#define testProva_TAM 2 // CONSTANTE UTILIZADA PARA DEFINIR O TAMANHO DO VETOR QUE IRÁ GUARDAR AS NOTAS DE TESTES E PROVAS
#define media_TAM 3 // CONSTANTE UTILIZADA PARA DEFINIR O TAMANHO DO VETOR DAS MÉDIAS
#define situacao_TAM 33 // CONSTANTE UTILIZADA PARA DEFINIR O TAMANHO DA STRING SITUAÇÃO

// STRUCT PARA O CADASTRO DE ALUNOS
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

// INICIALIZAÇÃO DO VETOR DE ALUNOS
struct Aluno aluno[vAlunos_TAM];

// PROTOTIPAÇÃO DAS FUNÇÕES UTILIZADAS
void menuPrincipal();
void menuCadastro();
void menuFrequencia();
void menuNotas();
void menuRelatorio();
void insereAluno(int);
void alteraAluno();
void excluiAluno();
void insereFrequencia(int);
void insereNotas(int);
void calculaMedias(int);
void atualizaSituacao(int);
void zeraNotas(int);
void exibeAlunos();
void exibeSituacaoAlunos(int);
void iniResetaVetorAluno(int);
int proximoVazio();
int listaVazia();
int verificaMatricula(int);
int verificaMatriculaInt(char[]);
int validaDados(char[]);
int validaNotas(int, int);
int validaNome(char[]);

// FUNÇÃO PRINCIPAL, SERÁ EXECUTADA ATÉ QUE O USUÁRIO DIGITE O NÚMERO 5 DO MENU PRINCIPÁL
void main()
{
    for (;;)
        menuPrincipal();
}

// MENU PRINCIPAL
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

    if (validaDados(op) == 0)
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

// MENU CADASTRO
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

    if (validaDados(op) == 0)
    {
        switch (atoi(op))
        {
        case 1:
            insereAluno(proximoVazio(aluno));
            break;
        case 2:
            alteraAluno();
            break;
        case 3:
            excluiAluno();
            break;
        case 4:
            exibeAlunos();
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

// MENU FREQUÊNCIA
void menuFrequencia()
{
    char op[2];

    printf ("\nMENU FREQUÊNCIA");
    printf ("\n1. Inserir a frequência por aluno");
    printf ("\n2. Inserir a frequência para todos os alunos");
    printf ("\n3. Voltar ao menu principal");
    printf ("\nDigite a sua opção: ");
    scanf ("%s", op);

    if (validaDados(op) == 0)
    {
        switch (atoi(op))
        {
        case 1:
            insereFrequencia(atoi(op));
            break;
        case 2:
            insereFrequencia(atoi(op));
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

// MENU NOTAS
void menuNotas()
{
    char op[2];

    printf ("\nMENU NOTAS DAS AVALIAÇÕES");
    printf ("\n1. Inserir notas por aluno");
    printf ("\n2. Inserir notas para todos os alunos");
    printf ("\n3. Voltar ao menu principal");
    printf ("\nDigite a sua opção: ");
    scanf ("%s", op);

    if (validaDados(op) == 0)
    {
        switch (atoi(op))
        {
        case 1:
            insereNotas(atoi(op));
            break;
        case 2:
            insereNotas(atoi(op));
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

// MENU RELATÓRIO
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

    if (validaDados(op) == 0)
    {
        switch (atoi(op))
        {
        case 1:
            exibeSituacaoAlunos(atoi(op));
            break;
        case 2:
            exibeSituacaoAlunos(atoi(op));
            break;
        case 3:
            exibeSituacaoAlunos(atoi(op));
            break;
        case 4:
            exibeSituacaoAlunos(atoi(op));
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

// FUNÇÃO PARA CADASTRO DE ALUNOS NO SISTEMA
void insereAluno(int x)
{
    char matricula[sizeOfMatricula], nome[nome_TAM], sobrenome[nome_TAM];

    if (x != -1) // CASO HAJA ALGUM ESPAÇO VAZIO NA LISTA, O ALUNO É CADASTRADO.
    {
        printf ("\nMatrícula: ");
        scanf ("%s", matricula);

        if (verificaMatriculaInt(matricula) == 0 && atoi(matricula) > 0) // VERIFICA SE A MATRÍCULA É UM NÚMERO INTEIRO E POSITIVO
        {
            if (verificaMatricula(atoi(matricula)) == 0) // VERIFICA SE A MATRÍCULA DIGITADA JÁ EXISTE NO SISTEMA
            {
                printf ("\nMatrícula já cadastrada no sistema.\n"); // SE A MATRÍCULA EXISTIR É EXIBIDA UMA MSG
                menuCadastro();
            }
            else // CASO A MATRÍCULA NÃO EXISTA O CADASTRO É EFETUADO
            {
                printf ("Nome e sobrenome: ");
                scanf ("%s %s", nome, sobrenome);

                if (validaNome(nome) == 0 && validaNome(sobrenome) == 0)
                {
                    aluno[x].matricula = atoi(matricula);
                    strcpy (aluno[x].nome, nome);
                    strcpy (aluno[x].sobrenome, sobrenome);
                    strcpy (aluno[x].situacao, "Notas e frequência não inseridas.");
                    zeraNotas(x);

                    printf ("\nCadastro efetuado com sucesso.\n");
                    menuCadastro();
                }
                else
                {
                    printf ("\nDados inválidos.\n");
                    menuCadastro();
                }
            }
        }
        else  // CASO A MATRÍCULA NÃO SEJA UM NÚMERO VÁLIDO É EXIBIDO UMA MSG
        {
            printf ("\nMatrícula inválida.\n");
            menuCadastro();
        }
    }
    else  // CASO A LISTA ESTEJA CHEIA É EXIBIDA UMA MSG NA TELA.
    {
        printf ("\nLista cheia.\n");
        menuCadastro();
    }
}

// FUNÇÃO PARA ALTERAR DADOS DE UM ALUNO NO SISTEMA
void alteraAluno()
{
    if (listaVazia(aluno) == 0)
    {
        char matricula[sizeOfMatricula];

        printf ("\nMatrícula: ");
        scanf ("%s", matricula);

        if (verificaMatriculaInt(matricula) == 0 && atoi(matricula) > 0) // VERIFICA SE A MATRÍCULA É UM NÚMERO INTEIRO E POSITIVO
        {
            if (verificaMatricula(atoi(matricula)) == 0) // CASO A MATRICULA EXISTA OS DADOS PODERÃO SER ALTERADOS
            {
                int i;

                for (i = 0; i < vAlunos_TAM; i++)
                {
                    if (aluno[i].matricula == atoi(matricula))
                    {
                        char nome[nome_TAM], sobrenome[nome_TAM];

                        printf ("Nome: ");
                        scanf ("%s %s", nome, sobrenome);

                        if (validaNome(nome) == 0 && validaNome(sobrenome) == 0)
                        {
                            strcpy (aluno[i].nome, nome);
                            strcpy (aluno[i].sobrenome, sobrenome);
                            printf ("\nCadastro alterado com sucesso.\n");
                        }
                        else
                        {
                            printf ("\nDados inválidos.\n");
                            menuCadastro();
                        }
                    }
                }
                menuCadastro();
            }
            else
            {
                printf ("\nMatrícula inexistente.\n"); // CASO A MATRÍCULA NÃO EXISTA É EXIBIDO UMA MSG
                menuCadastro();
            }
        }
        else
        {
            printf ("\nMatrícula inválida.\n");
            menuCadastro();
        }
    }
    else
    {
        printf ("\nNenhum aluno cadastrado no sistema.\n");
        menuCadastro();
    }
}

// FUNÇÃO PARA EXCLUIR UM ALUNO DO SISTEMA
void excluiAluno()
{
    if (listaVazia(aluno) == 0)
    {
        char matricula[sizeOfMatricula];

        printf ("\nMatrícula: ");
        scanf ("%s", matricula);

        if (verificaMatriculaInt(matricula) == 0 && atoi(matricula) > 0) // VERIFICA SE A MATRÍCULA É UM NÚMERO INTEIRO E POSITIVO
        {
            if (verificaMatricula(atoi(matricula)) == 0) // CASO A MATRICULA EXISTA O ALUNO SERÁ EXCLUÍDO DO SISTEMA
            {
                int i;

                for (i = 0; i < vAlunos_TAM; i++)
                {
                    if (aluno[i].matricula == atoi(matricula))
                    {
                        iniResetaVetorAluno(i);
                    }
                }
                printf ("\nCadastro excluído com sucesso.\n");
                menuCadastro();
            }
            else
            {
                printf ("\nMatrícula não cadastrada no sistema.\n"); // CASO A MATRÍCULA NÃO EXISTA É EXIBIDO UMA MSG
                menuCadastro();
            }
        }
        else
        {
            printf ("\nMatrícula inválida.\n");
            menuCadastro();
        }
    }
    else
    {
        printf ("\nNenhum aluno cadastrado no sistema.\n");
        menuCadastro();
    }
}

// FUNÇÃO PARA INSERIR A FREQÙÊNCIA DE ALUNOS
void insereFrequencia(int op)
{
    int i;
    char frequencia[3];

    if (listaVazia(aluno) == 0)
    {
        if (op == 1) // A FREQUÊNCIA É INSERIDA POR ALUNO QUANDO OP É IGUAL A 1
        {
            char matricula[sizeOfMatricula];

            printf ("\nMatrícula: ");
            scanf ("%s", matricula);

            if (verificaMatriculaInt(matricula) == 0 && atoi(matricula) > 0) // VERIFICA SE A MATRÍCULA É UM NÚMERO INTEIRO E POSITIVO
            {
                if (verificaMatricula(atoi(matricula)) == 0) // SE A MATRÍCULA EXISTIR NO SISTEMA A FREQUÊNCIA SERÁ ALTERADA
                {
                    for (i = 0; i < vAlunos_TAM; i++)
                    {
                        if (aluno[i].matricula == atoi(matricula))
                        {
                            printf ("Nome: %s %s", aluno[i].nome, aluno[i].sobrenome);
                            printf ("\nDigite a quantidade total de faltas do aluno: ");
                            scanf ("%s", frequencia);

                            if (validaDados(frequencia) == 0)
                            {
                                aluno[i].frequencia = atoi(frequencia);
                                atualizaSituacao(i);
                                printf ("\nFrequência salva com sucesso.\n");
                                menuFrequencia();
                            }
                            else
                            {
                                printf("\nEntrada inválida.\n");
                                menuFrequencia();
                            }
                        }
                    }
                }
                else
                {
                    printf ("\nMatrícula inexistente.\n"); // CASO A MATRÍCULA NÃO EXISTA É EXIBIDA UMA MSG NA TELA
                    menuFrequencia();
                }
            }
            else
            {
                printf ("\nMatrícula inválida.\n");
                menuFrequencia();
            }
        }
        else // A FREQUÊNCIA É INSERIDA PARA TODOS OS ALUNOS CADASTRADOS NO SISTEMA
        {
            for (i = 0; i < vAlunos_TAM; i++)
            {
                if (aluno[i].matricula != 0)
                {
                    printf ("\nMatrícula: %d", aluno[i].matricula);
                    printf ("\nNome: %s %s", aluno[i].nome, aluno[i].sobrenome);
                    printf ("\nDigite a quantidade total de faltas do aluno: ");
                    scanf ("%s", frequencia);

                    if (validaDados(frequencia) == 0)
                    {
                        aluno[i].frequencia = atoi(frequencia);
                        atualizaSituacao(i);
                    }
                    else
                    {
                        printf("\nEntrada inválida.\n");
                        menuFrequencia();
                    }
                }
            }
            printf ("\nFrequência salva com sucesso.\n");
            menuFrequencia();
        }
    }
    else
    {
        printf ("\nNenhum aluno cadastrado no sistema.\n");
        menuFrequencia();
    }
}

// FUNÇÃO PARA INSERIR AS NOTAS DE ALUNOS
void insereNotas(int op)
{
    int i, x, teste[testProva_TAM], prova[testProva_TAM], ica[ica_TAM];

    if (listaVazia(aluno) == 0)
    {
        if (op == 1) // SE A OP FOR IGUAL A 1 AS NOTAS SERÃO INSERIDAS INDIVIDUALMENTE
        {
            char matricula[sizeOfMatricula];

            printf ("\nMatrícula: ");
            scanf ("%s", matricula);

            if (verificaMatriculaInt(matricula) == 0 && atoi(matricula) > 0) // VERIFICA SE A MATRÍCULA É UM NÚMERO INTEIRO E POSITIVO
            {
                if (verificaMatricula(atoi(matricula)) == 0) // SE A MATRÍCULA EXISTIR NO SISTEMA A FREQUÊNCIA SERÁ ALTERADA
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

                                if (validaNotas(teste[i], 1) == 0 && validaNotas(prova[i], 2) == 0)
                                {
                                    aluno[x].teste[i] = teste[i];
                                    aluno[x].prova[i] = prova[i];
                                }
                                else
                                {
                                    printf ("\nDados inválidos.\n");
                                    zeraNotas(i);
                                    menuNotas();
                                }
                            }
                            printf("\n");
                            for (i = 0; i < ica_TAM; i++)
                            {
                                printf ("ICA %d: ", i + 1);
                                scanf ("%d", &ica[i]);

                                if (validaNotas(ica[i], 3) == 0)
                                    aluno[x].ica[i] = ica[i];
                                else
                                {
                                    printf ("\nDados inválidos.\n");
                                    zeraNotas(i);
                                    menuNotas();
                                }
                            }
                            calculaMedias(x);
                            atualizaSituacao(x);
                        }
                    }
                    printf ("\nNotas salvas com sucesso.\n");
                    menuNotas();
                }
                else
                {
                    printf ("\nMatrícula inexistente.\n"); // CASO A MATRÍCULA NÃO EXISTA É EXIBIDA UMA MSG NA TELA
                    menuNotas();
                }
            }
            else
            {
                printf ("\nMatrícula inválida.\n");
                menuNotas();
            }
        }
        else // SE A OP FOR IGUAL A 2 AS NOTAS SÃO INSERIDAS PARA TODOS OS ALUNOS CADASTRADOS
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

                        if (validaNotas(teste[i], 1) == 0 && validaNotas(prova[i], 2) == 0)
                        {
                            aluno[x].teste[i] = teste[i];
                            aluno[x].prova[i] = prova[i];
                        }
                        else
                        {
                            printf ("\nDados inválidos.\n");
                            zeraNotas(i);
                            menuNotas();
                        }
                    }
                    printf("\n");
                    for (i = 0; i < ica_TAM; i++)
                    {
                        printf ("ICA %d: ", i + 1);
                        scanf ("%d", &ica[i]);

                        if (validaNotas(ica[i], 3) == 0)
                            aluno[x].ica[i] = ica[i];
                        else
                        {
                            printf ("\nDados inválidos.\n");
                            zeraNotas(i);
                            menuNotas();
                        }
                    }
                    calculaMedias(x);
                    atualizaSituacao(x);
                }
            }
            printf ("\nNotas salvas com sucesso.\n");
            menuNotas();
        }
    }
    else
    {
        printf ("\nNenhum aluno cadastrado no sistema.\n");
        menuNotas();
    }
}

// FUNÇÃO PARA CALCULAR AS MÉDIAS
void calculaMedias(int x)
{
    aluno[x].medias[0] = ((aluno[x].ica[0] + aluno[x].ica[1]) + (2 * (aluno[x].teste[0] + aluno[x].prova[0]))) / 3;
    aluno[x].medias[1] = ((aluno[x].ica[2] + aluno[x].ica[3]) + (2 * (aluno[x].teste[1] + aluno[x].prova[1]))) / 3;
    aluno[x].medias[2] = (aluno[x].medias[0] + aluno[x].medias[1]) / 2;
}

// FUNÇÃO PARA ATUALIZAR A SITUAÇÃO DE UM ALUNO, SENDO APROVADO OU REPROVADO
void atualizaSituacao(int x)
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

// FUNÇÃO PARA ZERAR AS NOTAS DE UM ALUNO
void zeraNotas(int x)
{
    // ESTA FUNÇÃO IRÁ ATRIBUIR ZERO A TODAS AS NOTAS DE TESTES, PROVAS E ICAS DE CADA ALUNO
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

// FUNÇÃO PARA EXIBIÇÃO DA LISTA DE ALUNOS CADASTRADOS NO SISTEMA
void exibeAlunos()
{
    if (listaVazia(aluno) == 0)
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
        menuCadastro();
    }
    else
    { // CASO NÃO HAJA ALUNO CADASTRADO NO SISTEMA É EXIBIDO UMA MSG
        printf ("\nNenhum aluno cadastrado no sistema.\n");
        menuCadastro();
    }
}

// FUNÇÃO PARA EXIBIR A SITUAÇÃO DE CADA ALUNO
void exibeSituacaoAlunos(int x)
{
    // SERÁ EXIBIDO ALUNOS REPROVADOS, APROVADOS, LISTAGEM DE TODOS OS ALUNOS E IRÁ EXIBIR A SITUAÇÃO POR ALUNO
    int i, y, cont = 0;

    if (listaVazia(aluno) == 0)
    {
        if (x == 1) // OPÇÃO 1 DO MENU RELATÓRIO, EXIBIÇÃO DE TODOS OS ALUNOS
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
            menuRelatorio();
        }
        else if (x == 2) // OPÇÃO 2 DO MENU RELATÓRIO, EXIBIÇÃO DE TODOS OS ALUNOS APROVADOS
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
            {
                printf ("\nNenhum aluno aprovado.\n");
                menuRelatorio();
            }
            else
                menuRelatorio();
        }
        else if (x == 3) // OPÇÃO 3 DO MENU RELATÓRIO, EXIBIÇÃO DE TODOS OS ALUNOS REPROVADOS
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
            {
                printf ("\nNenhum aluno reprovado.\n");
                menuRelatorio();
            }
            else
                menuRelatorio();
        }
        else
        {
            // OPÇÃO 4, É EXIBIDA A SITUAÇÃO DO ALUNO PELO NOME E SOBRENOME
            char name[nome_TAM], lastname[nome_TAM];
            int cont = 0;

            printf ("\nNome: ");
            scanf ("%s %s", name, lastname);

            if (validaNome(name) == 0 && validaNome(lastname) == 0)
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
                if (cont == 0) // CONT É UTILIZADO PARA VERIFICAR SE HÁ REGISTRO NO SISTEMA DO ALUNO
                {
                    // CASO O ALUNO NÃO ESTEJA CADASTRADO NO SISTEMA É EXIBIDA UMA MENSAGEM
                    printf ("\nAluno não cadastrado.\n");
                    menuRelatorio();
                }
                else
                    menuRelatorio();
            }
            else
            {
                printf ("\nDados inválidos.\n");
                menuRelatorio();
            }
        }
    }
    else
    {
        // CASO NÃO HAJA NENHUM ALUNO CADASTRADO NO SISTEMA É EXIBIDO UMA MENSAGEM
        printf ("\nNenhum aluno cadastrado no sistema.\n");
        menuRelatorio();
    }
}

// FUNÇÃO PARA RESETAR OU INICIALIZAR OS VALORES DO VETOR DE ALUNOS
void iniResetaVetorAluno(int x)
{
    aluno[x].matricula = 0; // INICIALIZA / RESETA A MATRÍCULA COM ZERO
    aluno[x].nome[0] = '\0'; // INICIALIZA / RESETA O VETOR DE NOME E SOBRENOME VÁZIOS
    aluno[x].sobrenome[0] = '\0';
    zeraNotas(x);
}

// FUNÇÃO PARA BUSCAR A PRÓXIMA POSIÇÃO VAZIA DO VETOR DE ALUNOS
int proximoVazio()
{
    int i;

    for (i = 0; i < vAlunos_TAM; i++)
    {
        if (aluno[i].matricula == 0) // CASO A MATRICULA SEJA IGUAL A ZERO
            return i; // A FUNÇÃO RETORNA i, OU SEJA, A ṔOSIÇÃO LIVRE
    }
    return -1;
}

// FUNÇÃO PARA VERIFICAR SE A LISTA ESTÁ VAZIA
int listaVazia()
{
    int i, cont = 0;

    for (i = 0; i < vAlunos_TAM; i++)
    {
        if (aluno[i].matricula != 0)
            cont++; // CONT IRÁ CONTAR A QUANTIDADE DE VEZES QUE UMA MATRÍCULA É DIFERENTE DE ZERO
    }
    if (cont > 0)
        return 0; // CASO CONT SEJA MAIOR QUE ZERO, SIGNIFICA QUE EXISTE AO MENOS UM CADASTRO NO SISTEMA
    else
        return 1; // CASO NÃO, RETORNA 1
}

// FUNÇÃO PARA VERIFICAR SE UMA MATRÍCULA EXISTE OU NÃO NO SISTEMA
int verificaMatricula(int matricula)
{
    int i, x = 1;

    for (i = 0; i < vAlunos_TAM; i++)
    {
        if (aluno[i].matricula == matricula)
            x = 0; // CASO A MATRÍCULA EXISTA, RETORNA ZERO
    }
    return x; // CASO CONTRÁRIO RETORNA SEU VALOR ORIGINAL, 1
}

// FUNÇÃO PARA VERIFICAR SE A MATRÍCULA DIGITADA É UM NÚMERO INTEIRO E POSITIVO
int verificaMatriculaInt(char matricula[])
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
    if (cont == strlen(matricula))
        return 0;
    else
        return 1;
}

/*
    FUNÇÃO PARA VERIFICAR A INTEGRIDADE DOS DADOS INSERIDOS PELO USUÁRIO, TAL COMO A OPERAÇÃO SOLICITADA NOS MENUS,
    FREQUÊNCIA, ETC.
*/
int validaDados(char dado[])
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
    if (cont == strlen(dado))
        return 0;
    else
        return 1;
}

// FUNÇÃO PARA VALIDAR AS NOTAS DE TESTES, PROVAS E ICAS
int validaNotas(int x, int y)
{
    if (y == 1)  // PARA Y = 1 A FUNÇÃO IRÁ VERIFICAR AS NOTAS DE TESTES
    {
        if (x >= 0 && x <= 30)
            return 0;
        else
            return 1;
    }
    if (y == 2)  // PARA Y = 2 A FUNÇÃO IRÁ VERIFICAR AS NOTAS DE PROVAS
    {
        if (x >= 0 && x <= 70)
            return 0;
        else
            return 1;
    }
    if (y == 3)  // PARA Y = 3 A FUNÇÃO IRÁ VERIFICAR AS NOTAS DE ICAS
    {
        if (x >= 0 && x <= 50)
            return 0;
        else
            return 1;
    }
}

// FUNÇÃO PARA VALIDAR NOME E SOBRENOME
int validaNome(char nome[])
{
    int i, cont = 0;

    for (i = 0; i < strlen(nome); i ++)
    {
        if (isalpha(nome[i]) == 0)
            cont++;
    }
    return cont;
}
