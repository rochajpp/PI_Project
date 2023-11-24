# Projeto Integrador 4

<h1> Análise de Requisitos </h1>

<h2> Introdução </h2>

Este projeto visa o desenvolvimento de um sistema de reserva de carros implementado em Java, compreendendo funcionalidades distintas para áreas pública e administrativa. Na área pública, será criada uma página de login, uma funcionalidade de recuperação de senha através do login e data de nascimento, uma página de visualização dos carros disponíveis e uma funcionalidade para demonstração de interesse em um carro, onde o interessado fornecerá nome e telefone, removendo o carro da lista pública.

Na área administrativa, acessível após login, será implementado um CRUD para gerenciamento de usuários e carros, contendo variáveis específicas como id, login, senha, nome, entre outras. Haverá também uma funcionalidade para geração de relatório em PDF dos carros com interesse demonstrado, além de uma funcionalidade para liberar carros reservados, retornando-os à lista pública sem apagar o histórico de interesses. A documentação incluirá um relatório detalhando as tecnologias utilizadas, o diagrama de classes e a contribuição de cada membro da equipe no projeto.

<h2>Atribuição de tarefas</h2>
<table>
  
  <tr>
    <td align="center"> Nome </td>
    <td align="center"> Atividade </td>
  </tr>

  <tr>
    <td>Lucas</td>
    <td>
      <p>- Criação das Entidades "Car", "User" e "Report". </p>
      <p>- Adicionar arquivos SQL para o Database.</p>
      <p>- Criação de repositórios.</p>
      <p>- Configuração de repositórios.</p>
    </td>
  </tr>

  <tr>
    <td>Guilherme</td>
    <td>
      <p>- Configuração de pastas estáticas de CSS e estilização da página. </p>
      <p>- Criação da página Admin e estilização.</p>
      <p>- Estilização das páginas alterUser e addUser.</p>
    </td>
  </tr>

  <tr>
    <td>João Paulo</td>
    <td>
      <p>- Adicionar HomeController.</p>
      <p>- Criação e configuração do método getCookie.</p>
      <p>- Adicionar e configurar sistema de Interceptor.</p>
      <p>- Tratação de dados para a API.</p>
    </td>
  </tr>

  <tr>
    <td>André</td>
    <td>
      <p>- Criação da API de lista de "Cars" e "Users".</p>
      <p>- Criação do LoginController e método de login.</p>
      <p>- Criação de controller Admin.</p>
      <p>- Documento de Requisitos.</p>
    </td>
  </tr>
</table>

<h2>Tecnologias utilizadas</h2>
<table>
  <tr>
    <td align="center"> Tecnologia </td>
    <td align="center"> Descrição </td>
  </tr>

  <tr>
    <td align="center"> Java </td>
    <td> Linguagem utilizada para estruturação do back-end. </td>
  </tr>

  <tr>
    <td align="center"> SpringBoot </td>
    <td> Framework que utiliza Java como base, para ter uma comunicação mais eficiente do Java com o TomCat. </td>
  </tr>

  <tr>
    <td align="center"> TomCat </td>
    <td> Usado para construir e executar aplicativos de forma a não comprometer a estabilidade do servidor. </td>
  </tr>

  <tr>
    <td align="center"> HTML </td>
    <td> Linguagem de Marcação de HiperTexto. </td>
  </tr>

  <tr>
    <td align="center"> CSS </td>
    <td> Estilização de páginas, usando como base o HTML. </td>
  </tr>

  <tr>
    <td align="center"> JavaScript </td>
    <td> Adição da lógica do front-end, que se comunicará com o HTML e o CSS. </td>
  </tr>

  <tr>
    <td align="center"> EclipseIDE </td>
    <td>IDE utilizada para o desenvolvimento do software.</td>
  </tr>
</table>

<h2> Sobre o documento </h2>
Abaixo seguem os tipos de importância dos requisitos:

- OBRIGATÓRIO: Deve ser obrigatoriamente implementado.
- DESEJÁVEL: Um requisito que deve ser parte do escopo, mas não bloqueia o sistema a entrar em produção. Pode ser postergado para pós-implantação, ou ser atendido temporariamente por soluções de contorno ou paliativos.
- OPCIONAL: Quando não desenvolvido, o sistema deve funcionar de maneira satisfatória, atendendo completamente seu objetivo. Por ser algo que não precisa ser feito para que o sistema esteja completo, é a menor das prioridades, e deve ser postergado para, se for possível, ser viabilizado no futuro.

<h2> Requisitos funcionais </h2>
<table>
  <tr>
    <td align="center">
      <p>ID</p>
    </td>
    <td align="center">
    Nome
    </td>
    <td align="center">
      <p>Descrição</p>
    </td>
    <td align="center">
    Importância
    </td>
  </tr>
  
   <tr>
    <td align="center">
      <p>RF001</p>
    </td>
    <td>
      <p>
        Página de login
      </p>
    </td>
     <td align="center">
       Criar uma página de login que dará acesso à área administrativa do sistema. O usuário deve fornecer login e senha, que será verificado no banco de dados
     </td>
     <td align="center">
       Obrigatório
     </td>
  </tr>
  <tr>

  <tr>
    <td align="center">
      <p>RF002</p>
    </td>
    <td>
      <p>
        Recuperar senha
      </p>
    </td>
     <td align="center">
       Criar uma funcionalidade que permita ao usuário recuperar sua senha, caso ele saiba o login e a data de nascimento
     </td>
     <td align="center">
       Obrigatório
     </td>
  </tr>
  <tr>

  <tr>
    <td align="center">
      <p>RF003</p>
    </td>
    <td>
      <p>
        Exibição de carros disponíveis
      </p>
    </td>
     <td align="center">
       Criar uma página que exiba todos os carros disponíveis e permita ver os detalhes de cada carro individualmente.
     </td>
     <td align="center">
       Obrigatório
     </td>
  </tr>
  <tr>

  <tr>
    <td align="center">
      <p>RF004</p>
    </td>
    <td>
      <p>
        Exibição de interesse em determinado carro
      </p>
    </td>
     <td align="center">
       Criar uma funcionalidade que permita que uma pessoa demonstre interesse em um determinado carro. Ao demonstrar interesse no carro, deve-se informar o nome e telefone de quem tem interesse e esse carro não pode mais ser exibido na lista pública
     </td>
     <td align="center">
       Obrigatório
     </td>
  </tr>
  <tr>

  <tr>
    <td align="center">
      <p>RF005</p>
    </td>
    <td>
      <p>
        CRUD de usuário
      </p>
    </td>
     <td align="center">
       Criar um CRUD de usuário com pelo menos as seguintes variáveis: id, login, senha, nome, ativo, dataNascimento e dataCadastro.
     </td>
     <td align="center">
       Obrigatório
     </td>
  </tr>
  <tr>

  <tr>
    <td align="center">
      <p>RF006</p>
    </td>
    <td>
      <p>
        CRUD de carros
      </p>
    </td>
     <td align="center">
       Criar uma CRUD de carros com pelo menos as seguintes variáveis: id, marca, modelo, anoFabricacao, anoModelo, valor e descrição.
     </td>
     <td align="center">
       Obrigatório
     </td>
  </tr>
  <tr>

  <tr>
    <td align="center">
      <p>RF007</p>
    </td>
    <td>
      <p>
        Relatório em PDF
      </p>
    </td>
     <td align="center">
       Criar uma funcionalidade que exiba um relatório em pdf com os carros que alguém demonstrou interesse, informando seu nome, telefone e data de cadastro do interesse. Essas informações serão geradas a partir da funcionalidade descrita no RF004.
     </td>
     <td align="center">
       Obrigatório
     </td>
  </tr>
  <tr>

  <tr>
    <td align="center">
      <p>RF008</p>
    </td>
    <td>
      <p>
        Liberar carro que esteja reservado
      </p>
    </td>
     <td align="center">
       Criar uma funcionalidade para liberar um carro que esteja reservado caso alguém tenha mostrado interesse. Ao liberar o carro, ele deve voltar a ser exibido na página pública. Esse registro não pode ser apagado do histórico de interesses
     </td>
     <td align="center">
       Obrigatório
     </td>
  </tr>
  <tr>

  <tr>
    <td align="center">
      <p>RF009</p>
    </td>
    <td>
      <p>
        Documentação de Requisitos funcionais e não funcionais
      </p>
    </td>
     <td align="center">
       Criar um relatório informando as tecnologias utilizadas para desenvolver o software. No relatório também deve ser disponibilizado o diagrama de classes. Por fim deve ser informado o que cada membro da equipe fez no trabalho.
     </td>
     <td align="center">
       Obrigatório
     </td>
  </tr>
  <tr>
</table>

<h2>Requisitos não funcionais</h2>
<table>
  <tr>
    <td align="center">Nome</td>
    <td>Descrição</td>
  </tr>

  <tr>
    <td align="center">InterceptorAppConfig</td>
    <td> Adicionar interceptores para cada rota. </td>
  </tr>

  <tr>
    <td align="center">LoginInterceptor</td>
    <td> Componente que implementa HandlerInterceptor, que tem como pre-handle verificar se há um cookie para acessar a rota. </td>
  </tr>

  <tr>
    <td align="center">ResetPassInterceptor</td>
    <td> Componente que implementa HandlerInterceptor, que tem como pre-handle verificar se há um cookie para acessar a rota. </td>
  </tr>

  <tr>
    <td align="center">CookieService</td>
    <td> Possui métodos de obter e alterar cookies. </td>
  </tr>
  
</table>

<h2>Diagrama de Classe</h2>
<a href="https://ibb.co/gmYH6d4"><img src="https://i.ibb.co/BckdwGn/diagrama-de-classe.jpg" alt="diagrama-de-classe" border="0"></a>
