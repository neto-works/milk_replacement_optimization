## Rrequirements

### Requisitos Funcionais
Cadastro de Produtos

RF001: O sistema deve permitir o cadastro de novos produtos (tipos de leite) com informações como nome, descrição, preço por litro, e unidade de medida.
RF002: O sistema deve permitir a edição e exclusão de produtos já cadastrados.
Cadastro de Vendedores

RF003: O sistema deve permitir o cadastro de vendedores com informações como nome, CPF, telefone, e endereço.
RF004: O sistema deve permitir a edição e exclusão de informações de vendedores.
Cadastro de Gerentes

RF005: O sistema deve permitir o cadastro de gerentes com informações como nome, CPF, telefone, e endereço.
RF006: O sistema deve permitir a edição e exclusão de informações de gerentes.
Registro de Recolhimento

RF007: O sistema deve permitir que os vendedores registrem o recolhimento de leite, incluindo informações como data, quantidade coletada e local de coleta.
RF008: O sistema deve permitir que o gerente aprove ou rejeite os registros de recolhimento.
Relatórios de Vendas e Recolhimentos

RF009: O sistema deve gerar relatórios de vendas e recolhimentos com filtros por data, vendedor e produto.
RF010: O sistema deve permitir a exportação desses relatórios para formatos como PDF e Excel.
Controle de Estoque

RF011: O sistema deve atualizar o estoque de leite disponível com base nos recolhimentos e nas vendas realizadas.
RF012: O sistema deve alertar quando o estoque de um produto estiver abaixo de um nível mínimo definido.
Acesso e Permissões

RF013: O sistema deve permitir o acesso de diferentes usuários com base em suas permissões (vendedores, gerentes).
RF014: O sistema deve permitir a definição de diferentes níveis de acesso para visualizar e modificar dados.

### Requisitos Não Funcionais
Desempenho

RNF001: O sistema deve ser capaz de processar e registrar até 500 transações de recolhimento e vendas por minuto.
RNF002: O tempo de resposta para gerar relatórios não deve exceder 5 segundos.
Segurança

RNF003: O sistema deve garantir que todas as informações pessoais e financeiras estejam criptografadas tanto em trânsito quanto em repouso.
RNF004: O sistema deve implementar autenticação de usuário e controle de acesso baseado em papéis para garantir que apenas usuários autorizados possam acessar e modificar dados.
Usabilidade

RNF005: O sistema deve ter uma interface amigável e intuitiva, com menus e botões claramente identificáveis.
RNF006: O sistema deve fornecer ajuda e documentação acessível para os usuários em caso de dúvidas.
Escalabilidade

RNF007: O sistema deve ser escalável para suportar um aumento no número de produtos, vendedores e transações sem comprometer o desempenho.
Compatibilidade

RNF008: O sistema deve ser compatível com os principais navegadores da web (Chrome, Firefox, Edge, Safari) e versões recentes de sistemas operacionais.
Manutenção

RNF009: O sistema deve permitir atualizações e manutenção sem interromper o serviço para os usuários.
RNF010: O sistema deve registrar logs de atividades e erros para facilitar a manutenção e resolução de problemas.
Backup e Recuperação

RNF011: O sistema deve realizar backups automáticos diários e permitir a recuperação de dados em caso de falha.
Documentação

RNF012: O sistema deve fornecer documentação técnica e manual do usuário, que deve estar atualizada com as versões do sistema.

## Scheme