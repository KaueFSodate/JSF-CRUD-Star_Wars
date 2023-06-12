Questão 1

Título do Projeto: JSF-CRUD-Star_Wars

Descrição do projeto:
API criada utilizando o JSF, Maven e o Mysql, na qual ela tem o tema do Star Wars, conseguindo salvar, excluir, listar todos planetas, listar por id e nome.

Requisitos do sistema: 

Java Development Kit (JDK) - 19
Apache Maven
Servidor de banco de dados MySQL
Navegador da web (para acessar a API)
Configuração do banco de dados: na persistence.xml

    <persistence-unit name="planeta" transaction-type="RESOURCE_LOCAL">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

        <!-- Configurações de conexão com o banco de dados -->
        <properties>
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/DATABASE"/>
            <property name="javax.persistence.jdbc.user" value="USUARIO"/>
            <property name="javax.persistence.jdbc.password" value="SUA SENHA"/>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>

            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>

            <!-- Configuração para criação automática das tabelas -->
            <property name="hibernate.hbm2ddl.auto" value="update"/>
        </properties>
    </persistence-unit>

Configuração do ambiente de desenvolvimento: 

Utilizei a IDEA intellij para carregar as dependências em conjunto um plugin da IDEA na qual contem o tomcat server

Instruções de instalação: 

Envie o comando git clone https://github.com/KaueFSodate/JSF-CRUD-Star_Wars/ na pasta que deseja arnmazenar o código,
Acesse a sua IDEA, carregue as dependências do arquivo pom.xml, utilize o servidor TomCat para hospedar a aplicação e acesse a URL: http://localhost:8080/backendkaue/views/index.xhtml

Executando a aplicação: 

Após executar a aplicação ira conter a função de cadastrar planetas, tendo os atributos nome, clima, terreno e se algum planeta tiver aparecido nos filmes do Star Wars ira automaticamente setar a quantidade das aparições.
A informação das aparições foi retirada por essa URL: https://swapi.dev/api/planets/?search=NOME_DO_PLANETA

Questão 2

Em uma estrutura git onde temos as branches master e develop, após receber duas solicitações, uma para correção de um erro e outra para criação de uma nova funcionalidade, 
as branches devem ser criadas da seguinte forma, de acordo com o Gitflow:

1. Branch "hotfix/erro": Essa branch deve ser criada a partir da branch "master". 
É usada para corrigir erros críticos em produção. Podemos criar a branch "hotfix/erro" a partir da branch "master" para corrigir o erro solicitado.

Exemplo:

1: Criar a branch de correção de erro

$ git checkout -b hotfix/nome-do-erro master

2: Realizar as correções necessárias no código

$ git add .

$ git commit -m "Corrigir erro: descrição do erro"

3: Mesclar a branch de correção na branch master

$ git checkout master

$ git merge --no-ff hotfix/nome-do-erro

4: Mesclar a branch de correção na branch develop

$ git checkout develop

$ git merge --no-ff hotfix/nome-do-erro

5: Excluir a branch de correção após a mesclagem concluída

$ git branch -d hotfix/nome-do-erro

2. Branch "feature/nova-funcionalidade": Essa branch deve ser criada a partir da branch "develop". É usada para adicionar uma nova funcionalidade. 
Podemos criar a branch "feature/nova-funcionalidade" a partir da branch "develop" para desenvolver a nova funcionalidade solicitada.

1: Criar a branch para a nova funcionalidade

git checkout -b feature/nome-da-funcionalidade develop

2: Implementar a nova funcionalidade

$ git add .

$ git commit -m "Adicionar nova funcionalidade: descrição da funcionalidade"

3: Mesclar a branch da nova funcionalidade na branch develop

$ git checkout develop

$ git merge --no-ff feature/nome-da-funcionalidade

4: Excluir a branch da nova funcionalidade após a mesclagem concluída

$ git branch -d feature/nome-da-funcionalidade

Com isso, resultando na criação das seguintes branches:

- Branch "hotfix/erro" a partir da branch "master".

- Branch "feature/nova-funcionalidade" a partir da branch "develop".
