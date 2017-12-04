//FILA ESTATICA EM C

#include <stdio.h>
#include <stdlib.h>

#define MAXTAM 6
#define bool short
#define true  1
#define false 0

int array[MAXTAM+1];
int primeiro;
int ultimo;

void start()
{
	primeiro = ultimo = 0;
}

void inserir(int x)
{	
	if((ultimo+1) % MAXTAM) == primeiro)
	{
		printf("Erro ao inserir!");
	}

	array[ultimo] = x;
	ultimo = (ultimo+1) % MAXTAM;
}

int remover()
{
	if(primeiro == ultimo)
	{
		printf("ERRO ao remover");
		exit(1);
	}

	int resp = array[primeiro];
	primeiro = (primeiro+1) % MAXTAM;
	return resp;
}

/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/

//PILHA ESTATICA EM C

int array[MAXTAM];
int topo;

void start()
{
	topo = 0;
}

void inserir(int x)
{
	if(topo >= MAXTAM)
	{
		printf("ERRO ao inserir");
	}

	array[topo] = x;
	topo++;
}

int remover()
{
	if(topo == 0)
	{
		printf("ERRO ao remover");
	}
	return array[--topo];
}

/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/

//FILA DINAMICA EM C

#include <stdio.h>
#include <stdlib.h>
#include <err.h>

typedef struct Celula
{
	int elemento;
	struct Celula* prox;
}Celula;

Celula* novaCelula(int x)
{
	Celula* nova = (Celula*) malloc(sizeof(Celula));
	nova->elemento = x;
	nova->prox = NULL;
}

Celula* primeiro;
Celula* ultimo;

void start()
{
	primeiro = novaCelula(-1);
	ultimo = primeiro;
}

void inserir(int x)
{
	ultimo->prox = novaCelula(x);
	ultimo = ultimo->prox;
}

int remover()
{
	if(primeiro == ultimo)
	{	
		errx(1, "erro ao remover");
	}

	Celula* tmp = primeiro;
	primeiro = primeiro->prox;
	int resp = primeiro->elemento;
	tmp->prox = NULL;
	free(tmp);
	tmp = NULL;
	return resp;
}

void mostrar()
{
	for(Celula* i = primeiro->prox; i != NULL; i = i->prox)
	{
		printf(i->elemento);
	}
}

/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/

//PILHA DINAMICA EM C

typedef struct Celula
{
	int elemento;
	struct Celula* prox;
}Celula;

Celula* novaCelula(int elemento)
{
	Celula* nova = (Celula*) malloc(sizeof(Celula));
	nova->elemento = elemento;
	nova->prox = NULL;
	return nova;
}

Celula* topo;

void start()
{
	topo = NULL;
}

void inserir(int x)
{
	if(topo == NULL)
	{
		errx(1, "erro ao inserir!");
	}

	Celula* tmp = novaCelula(x);
	tmp->prox = topo;
	topo = tmp->prox;
	tmp->prox = NULL;
	free(tmp);
	tmp = NULL;

	return resp;
}

void remover()
{
	if(topo == NULL)
	{
		errx(1, "erro ao remover")
	}

	int resp = topo->elemento;
	Celula* tmp = topo;
	topo = topo->prox;

	tmp->prox = NULL;
	free(tmp);
	tmp = NULL;
	return resp;
}

/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/

//LISTA DINAMICA EM C

typedef struct Celula
{
	int elemento;
	struct Celula* prox;
}Celula;

Celula* novaCelula(int x)
{
	Celula* nova = (Celula*) malloc(sizeof(Celula));
	nova->elemento = x;
	nova->prox = NULL;
	return nova;
}

Celula* primeiro;
Celula* ultimo;

void start()
{
	primeiro = novaCelula(-1);
	ultimo = primeiro;
}

void inserirInicio(int elemento)
{
	Celula* tmp = novaCelula(x);
	tmp->prox = primeiro->prox;
	primeiro->prox = tmp;
	if(primeiro == ultimo)
	{
		ultimo = tmp;
	}
	free(tmp);
	tmp = NULL;
}

void inserirFim(int x)
{
	ultimo->prox = novaCelula(x);
	ultimo = ultimo->prox;
}

int removerInicio()
{
	if(primeiro == ultimo)
	{
		errx(1, "erro ao inserir");
	}

	Celula* tmp = primeiro;
	primeiro = primeiro->prox;
	int resp = primeiro->elemento;
	tmp->prox = NULL;
	free(tmp);
	return resp;
}

int removerFim()
{
	if(primeiro == ultimo)
	{
		errx(1, "erro ao remover!");
	}

	Celula* i;
	for(i = primeiro; i->prox != ultimo; i = i.prox);

	int resp = ultimo->elemento;
	ultimo = i;
	free(i);
	free(ultimo->prox);
	i = ultimo->prox = NULL;

	return resp;
}

/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/

//Metriz DINAMICA EM C


typedef struct Celula
{
	int elemento;
	struct Celula* sup;
	struct Celula* inf;
	struct Celula* esq;
	struct Celula* dir;
}Celula;

Celula* novaCelula(int elemento)
{
	Celula* nova = (Celula*) malloc(sizeof(Celula));
	nova->elemento = elemento;
	nova->sup = NULL;
	nova->inf = NULL;
	nova->dir = NULL;
	nova->esq = NULL;
}
Celula* matriz;

int linha;
int coluna;

void start()
{
	matriz = novaCelula();
	gerarMatriz();	
}



void gerarMatriz()
{
	if(linha < 0 || coluna < 0)
	{
		errx(1, "erro: numero de linhas ou colunas invalido");
	}

	Celula* i, j;
	i = j = matriz;
	int lin, col;
	lin = col = 0;

	while(lin < linha)
	{
		while(col < coluna-1)
		{
			j->dir = novaCelula(0);
			j->dir->esq = j;
			j = j->dir;

			if(j->esq != NULL && j->esq->sup != NULL)
			{
				j->sup = j->esq->sup->dir;
				j->esq->sup->dir->inf = j;
			}
			col++;
		}
		i->inf = novaCelula(0);
		i->inf->sup = i;
		i = j = i->inf;
		col =0;
		lin++;
	}

	free(i);
	free(j);
	i = j = NULL;
}

/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/

//METODO DE PESQUISA BINARIA

public String[] array;

public boolean pesquisa(String nome, int inicio, int fim)
{
	int meio;
	boolean resp = false;
	while(inicio <= fim)
	{
		meio = (inicio+fim)/2;

		if(this.array[meio].equals(nome) == true)
		{
			resp = true;
		}else if(nome.compareTo(this.array[meio]) > 0){
			inicio = meio+1;
		}else if(nome.compareTo(this.array[meio]) < 0){
			fim = meio-1;
		}else{
			if(this.array[meio].equals(nome) == true)
			{
				resp = true;
			}
		}
		return resp;
	}
}

/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/

//Metodos de Ordenacao em JAVA

//Selecao

public void selecao()
{
	for(int i = 0; i < (n-1); i++)
	{
		int menor = i;

		for(int j = i+1; j < n; j++)
		{
			if(array[menor] > array[j])
			{
				menor = j;
			}
		}

		if(menor != i)
		{
			int aux = array[i];
			array[i] = array[menor];
			array[menor] = aux;
		}
	}
}

//Insercao

public void insercao()
{
	for(int i =1; i < n; i++)
	{
		int tmp = array[i];
		int j = i-1;
		while((j >= 0) && array[j] > tmp)
		{
			array[j+1]  array[j];
			j--;
		}

		array[j+1] = tmp;
	}
}

/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/

//ARVORE BINARIA

class No
{
	int elemento;
	No dir, esq;

	public No(int elemento){this(elemento, null, null);}
	private No(int elemento, No dir, No esq)
	{
		this.elemento = elemento;
		this.dir = dir;
		this.esq = esq;
	}
}

class Arvore
{
	private No raiz;

	public Arvore()
	{
		this.raiz = null;
	}

	public void inserir(int x) throws Exception
	{
		this.raiz = inserir(x, this.raiz);
	}

	private No inserir(int x, No i) throws Exception
	{
		if(i == null)
		{
			i = new No(x);
		}else if(x < i.elemento){
			i.esq = inserir(x, i.esq);
		}else if(x > i.elemento){
			i.dir = inserir(x, i.dir);
		}else{
			throw new Exception("Erro ao inserir na arvore");
		}
		return i;
	}

	public void remover(int x) throws Exception
	{
		this.raiz = remover(x, this.raiz);
	}

	private No remover(int x, No i) throws Exception
	{
		if(i == null)
		{
			throw new Exception("Error ao remover");
		}else if(x < i.elemento){
			i.esq = remover(x, i.esq);
		}else if(x > i.elemento){
			i.dir = remover(x, i.dir);
		}else if(i.dir == null){
			i = i.esq;
		}else if(i.esq == null){
			i = i.dir;
		}else{
			i.esq = anterior(i, i.esq);
		}
		return i;
	}

	private No anterior(No i, No j)
	{
		if(j.dir != null)
		{
			j.dir = anterior(i, j.dir);
		}else{
			i.elemento = j.elemento;
			j = j.esq;
		}
		return j;
	}	

	public boolean pesquisar(int x)
	{
		return pesquisar(x, this.raiz);
	}

	private boolean pesquisar(int x, No i)
	{
		boolean resp;
		if(i == null)
		{
			resp = false;
		}else if(x == i.elemento){
			resp = true;
		}else if(x < i.elemento){
			resp = pesquisar(x, i.esq);
		}else{
			resp = pesquisar(x, i.dir);
		}
		return i;
	}
}

/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/

//ARVORE DE LISTA

class Contato
{
	public String nome;
	public String telefone;
	public String email;
	public int cpf;

	public Contato(String nome, String telefone, String email, int cpf)
	{
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
	}
}

class No
{
	public Celula primeiro, ultimo;
	public No esq, dir;
	public char letra;
}

class Celula
{
	public Contato contato;
	public Celula prox;

	public Celula(Contato contato)
	{
		this.contato = contato;
		this.prox = null;
	}
}

class ArvoreLista
{
	private No raiz;

	public Agenda()
	{
		this.raiz = new No('M');
		this.raiz.esq = new No('F');
		this.raiz.dir = new No('S');
		this.raiz.dir.dir = new No('V');
	}

	/*
	 * Metodo para pesquisar dentro da lista
	 */
	public boolean pesquisar(String nome)
	{
		return pesquisar(nome, this.raiz);
	}

	/*
	 * Metodo recursivo para procurar na arvore 
	 * em que lista o nome pertence
	 */
	public boolean pesquisar(String nome, No i)
	{
		boolean resp;
		if(i == null)
		{
			resp = false;
		}else if(Character.toUpper(nome.charAt(0)) == i.letra){
			resp = pesquisar2(nome, i.primeiro);
		}else if(Character.toUpper(nome.charAt(0)) < i.letra){
			resp = pesquisar(nome, i.esq);
		}else{
			resp = pesquisar(nome, i.dir);
		}
		return resp;
	}

	/*
	 * Metodo para pesquisar se o nome esta dentro da lista
	 */
	private boolean pesquisar2(String nome, Celula i)
	{
		boolean resp = false;
		for(/**/; i != ultimo && resp == false; i = i.prox)
		{
			if(nome.equals(i.contato.nome))
			{
				resp = true;
			}
		}
		return resp;
	}

	public void inserir(Contato contato)
	{
		this.raiz = inserir(contato, this.raiz);
	}

	public void inserir(Contato c, No i)
	{
		if(i == null)
		{
			throw new Exception("Erro: Nao existe o No para que o elemento seja inserido");
		}else if(Char.toUpper(c.nome.charAt(0)) == i.letra){
			inserir2(c, i.primeiro);
		}else if(Char.toUpper(c.nome.charAt(0)) < i.letra){
			inserir(c, i.esq);
		}else{
			inserir(c, i.dir);
		}	
	}

	public void inserir2(Contato c, Celula i)
	{
		 i.ultimo.prox = new Celula(c);
		 i.ultimo = i.ultimo.prox;
	}
}

/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/

//Arvore Arvore

class No
{
	private char letra;
	private No dir, esq;
	private No2 arvore;

	public No(char letra){this(letra, null, null, null);}
	public No(char letra, No dir, No esq, No2 arvore)
	{
		this.letra = letra;
		this.dir = dir;
		this.esq; esq;
		this.arvore = arvore;
	}
}

class No2
{
	public String nome;
	public No2 dir, esq;

	public No2(String nome){this(nome, null, null);}
	public No2(String nome, No2 dir, No2 esq)
	{	
		this.nome = nome;
		this.dir = dir;
		this.esq = esq;
	}
}

class ArvoreArvore
{
	private raiz;

	public ArvoreArvore()
	{
		this.raiz = null;
	}

	public void inserir(char letra)
	{
		this.raiz = inserir(letra, this.raiz);
	}

	public No inserir(char letra, No i)
	{
		if(i == null)
		{
			i = new No(letra);
		}else if(letra < i.letra){
			i.esq = inserir(letra, i.esq);
		}else{
			i.dir = inserir(letra, i.dir);
		}

		return i;
	}

	public void inserirArvore(String nome) throws Exception
	{
		inserirArvore(nome, this.raiz);
	}

	public void inserirArvore(String x, No i) throws Exception
	{
		if(i == null)
		{
			throw new Exception("Erro: Nó nao existe na arvore!");
		}else if(Char.toUpper(x.charAt(0)) == i.letra){
			i. arvore = inserir2(x, i.arvore);
		}else if(Char.toUpper(x.charAt(0)) < i.letra){
			i.esq = inserirArvore(x, i.esq);
		}else{
			i.dir = inserirArvore(x, i.dir);
		}
	}

	public No2 inserir2(String nome, No2 i)
	{
		if(i == null)
		{
			i = new No2(nome);
		}else if(nome.compareTo(i.nome) < 0){
			i.esq = inserir2(nome, i.esq);
		}else if(nome.compareTo(i.nome) > 0){
			i.dir = inserir2(nome, i.dir);
		}else{
			throw new Exception("ERRO: Elemento a ser inserido na arvore invalido!");
		}
		return i;
	}
}

/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/

//ARVORE TRIE

class No
{
	public char elemento;
	public int tamanho = 255;
	public No[] prox;
	public boolean folha;

	public No()
	{
		this(' ');
	}

	public No(char elemento)
	{
		this.elemento = elemento;
		this.prox = new No[this.tamanho];
		for(int i = 0; i < this.prox.length; i++)
		{
			this.tabela[i] = null;
		}
		this.folha = false;
	}

	public int hash(char x)
	{
		return (int)x;
	}
}

class Trie
{
	private No raiz;

	public Trie()
	{
		this.raiz = new No();
	}

	public void inserir(String s) throws Exception
	{
		inserir(s, this.raiz, 0);
	}

	public void inserir(String s, No no, int i)
	{
		if(no.prox[s.charAt(i)] == null)
		{
			no.prox[s.charAt(i)] = new No(s.charAt(i));

			if(i == s.length()-1)
			{
				no.prox[s.charAt(i)].folha = true;
			}else{
				inserir(s, no.prox[s.charAt(i)], i+1);
			}
		}else if(no.folha == false){
			inserir(s, no.prox[s.charAt(i)], i+1);
		}else{
			throw new Exception("ERRO: Erro ao inserir!");
		}
	}

	public boolean pesquisar(String s) throws Exception
	{
		return pesquisar(s, this.raiz, 0);
	}

	public boolean pesquisar(String s, No no, int i)
	{
		boolean resp;
		if(no.prox[s.charAt(i)] == null)
		{
			resp = false;
		}else if(i == s.length()-1){
			resp = (no.folha == true);
		}else if(i < s.length()-1){
			pesquisar(s, no.prox[s.charAt(i)], i+1);
		}else{
			throw new Exception("Erro ao pesquisar!");
		}
	}

	public void mostar()
	{
		mostrar("", this.raiz);
	}

	public void mostrar(String s, No no)
	{
		if(no.folha == true)
		{
			System.out.println(s+no.elemento);
		}else{
			for(int i =0; i < no.prox.length; i++)
			{
				if(no.prox[i] != null)
				{
					mostrar(s+no.elemento, no.prox[i]);
				}
			}
		}
	}
}

/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/

//HASH COM RESERVA

class Hash
{
	int tabela[];
	int m1, m2, m, reserva;
	int NULO = -1;

	public Hash()
	{
		this(10, 3);
	}

	public Hash(int m1, int m2)
	{
		this.m1 = m1;
		this.m2 = m2;
		this.m = this.m1 + this.m2;
		this.tabela = new int[this.m];
		for(int i =0; i < this.tabela.length; i++)
		{
			this.tabela[i] = NULO;
		}
		this.reserva = 0;
	}

	public int hash(int x)
	{
		return x % this.m1;
	}

	public boolean inserir(int elemento)
	{
		resp = false;
		if(elemento != NULO)
		{
			int pos = hash(elemento);

			if(this.tabela[pos] == NULO)
			{
				this.tabela[pos] = elemento; 
				resp = true;
			}else if(this.reserva < this.m2){
				this.tabela[this.m1+reserva] = elemento;
				this.reserva++;
				resp = true;
			}
		}
		return resp;
	}

	public void pesquisar(int elemento)
	{
		boolean resp = false;

		int pos = hash(elemento);
		if(this.tabela[pos] == elemento)
		{
			resp = true;
		}else{
			for(int i =0; i < reserva; i++)
			{
				if(this.tabela[this.m1+i] == elemento)
				{
					resp = true;
					i = this.reserva;
				}
			}
		}
		return resp;
	}
}

/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------*/

//HASH INDIRETA com LISTA

class HashIndireta
{
	Lista tabela[];
	int tam; 
	final int NULO = -1;

	public HashIndireta(){this(10);}

	public HashIndireta(int tam)
	{
		this.tam = tam;
		this.tabela = new Lista[tam];
	}

	public int hash(int elemento)
	{
		return elemento % tam;
	}

	public boolean pesquisar(int elemento)
	{
		int pos = hash(int elemento);
		return this.tabela[pos].pesquisar(elemento);
	}

	public void inserir(int elemento)
	{
		int pos = hash(elemento);
		this.tabela[pos].inserirFim(elemento);
	}
}