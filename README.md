# Calculadora Distribuida
======= MANUAL DE USO ============

Para realizar as operações, basta digitar os seguintes comandos:

------------------------
## 1. Operações matemático
~~~~~~~~~~~~~~~~~~~~~~~

ADIÇÃO(SOMAR): SOMA N1 + N2 + N3 + ... + Nn
MULTIPLICAÇÂO: MULT N1 * N2 + N3 * ... * Nn
SUBTRAÇÃO: SUB N1 - N2 - N3 - ... - Nn
DIVISÃO: DIV N1 / N2 / N3 / ... / Nn
POTÊNCIA: POT N1 ^ N2
PORCENTAGEM: PORC N1 % N2
RAIZ QUADRADA: RAIZQ N
~~~~~~~~~~~~~~~~~~~~~~~

------------------------
## 2. Operações Extras
~~~~~~~~~~~~~~~~~~~~~~~~

"DATA" - Mostrar data e hora do servidor
"BYE" - Encerra a conexão com o servidor
"HELP" - Lista esse documento no proprio servidor. (Pode haver problema se esse arquivo README não estiver presente, deve está pasta raiz do projeto e também depende do sistema operacional.)
~~~~~~~~~~~~~~~~~~~~~~~~

## 3. Como Executar
Para executar o projeto, você deve executar primeiramente o SERVIDOR A (ServerA.java) e SERVIDOR B (ServerB.java) e depois executar o cliente (Client.java).
Caso esteja rodando no Intellij, você deve habilitar multipla execuções para permitir que rode múltiplos usuários acessar o servidor.

## 4. Explicação do projeto

### 4.1. Sobre o Projeto
O projeto foi criado usando o conceito aprendido na disciplina de sistemas distribuídos. De forma resumida, foi criado
dois servidores especialistas: O servidor A fica responsável por realizar a operação as quatro operações matematicos (+, -, /, *) e o 
servidor B fica responsável por realizar a operação de potência, raiz quadrada e porcentagem. Também foi criado um protocolo
que fica responsável por processar as requisições tanto do cliente, como também do servidor.

#### 4.1.1 Protocolo
O protocolo foi criado usando a linguagem de programação JAVA e totalmente orientada a objeto, com objetivo de 
reaproveitamento de código. Conforme os dados recebido de uma solicitação, o protocolo realizar um parser para 
verificar qual operação deve ser realizada, onde foi construído uma gramática regular com objetivo de reconhecer os dados.

Copyright (c) - Danilo Santana; 2022;
--------------------------------
