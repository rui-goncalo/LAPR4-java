# US1004
=======================================


# 1. Requisitos



**US1003:** Como Sales Clerk pretendo ...

- Criar uma nova order de produtos por um Customer;

Deve ser possível registar uma nova Order desde de que o utilizador a fazê-lo seja um Sales Clerk.

# 2. Análise

###Requisitos Funcionais
- Inserir o email do Sales Clerk;
- Inserir o ID do Customer para quem a Order está a ser feita;
- Inserir os dados necessários para ser possível a criação de uma nova Order no sistema, tais como:
	- Order ID (Gerado automáticamente)
	- Status
	- Sales Clerk
	- Customer
	- Payment Method
	- Shipment Type
	- Email (email)

- Esta função pode ser desempenhada por um utilizador "administrador" (admin/poweruser) ou pelo Sales Clerk.

# 3. Design

## 3.1. Realização da Funcionalidade

![SD](SD.svg)

## 3.3. Padrões Aplicados

*Nesta secção deve apresentar e explicar quais e como foram os padrões de design aplicados e as melhores práticas.*

## 3.4. Testes 
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*

**Teste 1:** Verificar que não é possível criar uma instância da classe Exemplo com valores nulos.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Exemplo instance = new Exemplo(null, null);
	}

# 4. Implementação

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integração/Demonstração

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 6. Observações

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*



