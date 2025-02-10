<h1>ToolsChallenge</h1>
<p>Projeto desenvolvido como parte do processo de teste técnico da empresa Tools Software.</p>
<p>Este projeto foi construído seguindo os princípios arquitetônicos RESTful. </br>
Além disso, foi realizada a separação das camadas: Service, Controllers, Repository, Models e DTOs. O padrão DTO (Data Transfer Object) foi utilizado principalmente para evitar a exposição das entidades no retorno das respostas das requisições, bem como para padronizar as solicitações.</p>
<p>A camada Controller foi desacoplada tanto da camada Service quanto do Assembler, responsável por transferir dados entre entidades e DTOs, garantindo maior organização e facilitando a manutenção do código.</br>
Essa abordagem segue o princípio da Inversão de Dependência (DIP) do SOLID, no qual a camada Controller passou a depender apenas de abstrações.</p>
<p>Foram também implementados testes unitários a fim de assegurar a qualidade e segurança das regras de negócio do sistema.</p>
