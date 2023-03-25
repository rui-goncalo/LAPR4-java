# US2002
=======================================

# 1. Requirements

**Title -** As Warehouse Employee, I want to configure the AGVs available on the warehouse.

**Requirements Clarifications:**
* Q1: What position should be defined when configuring an AGV? The same position as his AGV Dock?
	* A: By default, the AGV is on its base location, i.e., on the AGV dock.
* Q2: Should it be possible to still create an AGV without assigning it to an AGV Dock (in case of none being available)?
	* A: No! The AGV Dock is mandatory.
* Q3: Should it be possible to edit an AGV configuration, or is that outside the scope of US2002?
	* A: It outside of scope. But, if you want, you can do it.
* Q4: What should the default autonomy when creating an AGV be?
	* A: There is no default value. The user must type the AGV autonomy in minutes according to the manufacture specifications.
* Q5: Should a list of warehouses be shown for the AGV to be assigned or should the AGV be automatically assigned to the warehouse where the warehouse employee works?
	* A: As I said before, for now, there is only one warehouse. Do not turn things more complex than they already are.
* Q6: Could you specify the business rules associated with the identifier, short description, and model of the AGVS?
	* A: You should apply general validation rules such as:
		* Identifier: not empty alphanumeric code with at 8 chars maximum;
		* Short description: not empty having 30 chars maximum;
		* Model: not empty having 50 chars maximum;
		* For other necessary attributes, you should follow common-sense.
* Q7: Are the current tasks provided (free, charging, occupied serving a given order) fixed, or more could be added?
	* A: I would not called it task but, instead, AGV status. Besides those status I can foresee another status: in maintenance. If you find out more AGV status useful, you might adopt them and further explain/argue about their pertinence.

# 2. Analysis

###Requisitos Funcionais - FAZER AINDA
- Escolher a Order a ser enviada para o AGV;
- Escolher o AGV que irá realizar a tarefa;
- Esta função pode ser desempenhada por um utilizador "administrador" (admin/poweruser) ou pelo "Warehouse Employee".

###Regras de Negócio - FAZER AINDA
- A Order tem de estar com o STATUS igual a "TO\_BE_PREPARED";
- A ORDER é enviada para um AGV que esteja livre e que possa realizar a tarefa;
- O STATUS da Order é alterado;

# 3. Design - DEIXAR SÓ O SD

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