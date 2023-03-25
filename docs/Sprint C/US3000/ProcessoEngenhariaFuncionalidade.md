# US3000
=======================================


# 1. Requisitos

**US1003:** Como Project Manager ...

- Quero que a equipa especifique uma gramática que permita expressar vários tipos de questionários.

###From the client clarifications
* Q1: We have read the specifications about the questionnaire structure provided in the System Specification document, however could you provide a template of a questionnaire, in order to better facilitate the implementation of the grammar from US3000?
	* A: No template will be provided. Teams are free to adopt the format foreseen as best suitable for the project purposes.

* Q2: In the requested grammar, is it needed to distinguish the different types of questions? For example, if the user says a certain question is multiple choice, shall we make the user input the possible options specifically or do we let the user write the content of the question as he prefers?
	* A: Well, the question type is need and useful for some reason. The way you/your team take (technical) advantage of it is up to you. 

# 2. Análise

###Requisitos Funcionais
- Verificar a estrutura de um questionário tendo em conta a Acceptance Criteria.

###Regras de Negócio
- Um questionário tem:
	- ID;
	- Title;
	- Welcome Message;
	- Sections;
	- Final Message;

- Uma Section tem:
	- ID;
	- Title;
	- Description;
	- Obligatoriness;
	- Repeatability;
	- Questions;

- Uma Question tem:
	- ID;
	- Question Text;
	- Instruction;
	- Type;
	- Obligatoriness;
	- Extra info;

# 3. Design

## 3.1. Realização da Funcionalidade




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



