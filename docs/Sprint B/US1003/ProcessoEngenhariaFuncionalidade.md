# US1003
=======================================


# 1. Requisitos



**US1003:** Como Sales Clerk pretendo ...

- Registar um novo customer

Deve ser possível registar um novo Customer indicando os atributos (ver 2. Análise) desde de que o utilizador a fazê-lo seja um Sales Clerk.

# 2. Análise

###Requisitos Funcionais
- Inserir os dados necessários para ser possível a criação de um Customer no sistema, tais como:
	- Nome curto (shortName)
	- Nome (name)
	- Género (gender)
	- Contacto de telefone (phone)
	- NIF (VAT)
	- Endereço (postalAddress)
	- Email (email)
	- Data de Nascimento (birthDate)
- Esta função pode ser desempenhada por um utilizador "administrador" (admin/poweruser) ou pelo Sales Clerk.

###Regras de Negócio
- Nome pode ser representado por, pelo menos, o primeiro e o último. O recomendado é o nome completo.
- O VAT ID é único e varia de país para país. Pode conter letras e números.
- Contacto de telefone: segue os standards internacionais (e.g.: +351 987654321)
- Endereço:


# 3. Design

## 3.1. Realização da Funcionalidade

![SD](SD.svg)

## 3.2. Diagrama de Classes

![CD](CD.svg)

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



