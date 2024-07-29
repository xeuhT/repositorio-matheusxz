Problema 1: Qual classe deve ser responsável por calcular o valor total do pedido, incluindo impostos e frete?

Padrão GRASP Utilizado: Information Expert

A classe Pedido é a mais adequada para calcular o valor total, pois ela conhece os itens do pedido e seus preços.



Problema 2: Qual classe deve ser responsável por criar objetos da classe Produto?

Padrão GRASP Utilizado: Creator

A criação de objetos da classe Produto é responsabilidade do ControladorCheckout, que orquestra o processo de checkout.



Problema 3: Qual classe deve ser responsável por orquestrar o processo de checkout, desde a validação do pedido até a geração da nota fiscal?

Padrão GRASP Utilizado: Controller

A classe ControladorCheckout é responsável por orquestrar o processo de checkout.



Problema 4: Como evitar que a classe Pedido dependa diretamente de classes específicas de pagamento, como CartaoCredito ou BoletoBancario?

Padrão GRASP Utilizado: Low Coupling

O uso da interface Pagamento permite que Pedido utilize diferentes métodos de pagamento sem depender diretamente de classes específicas.



Problema 5: A classe Produto deve armazenar informações de histórico de preços?

Padrão GRASP Utilizado: Information Expert

A classe Produto armazena o histórico de preços utilizando a classe HistoricoPreco.



Problema 6: Como permitir que diferentes tipos de produtos (livros, eletrodomésticos etc.) sejam tratados de forma uniforme no processo de checkout?

Padrão GRASP Utilizado: Polymorphism

A classe Produto pode ser especializada em subclasses para diferentes tipos de produtos, todos tratados uniformemente pelo Pedido.



Problema 7: Como gerar um identificador único para cada pedido?

Padrão GRASP Utilizado: Creator

A classe GeradorID é responsável por criar identificadores únicos.



Problema 8: Como evitar que a classe Pedido dependa diretamente do sistema de notificação por e-mail para enviar avisos ao cliente?

Padrão GRASP Utilizado: Indirection

A classe ServicoNotificacao gerencia o envio de notificações, desacoplando Pedido do sistema de notificação.



Problema 9: Como proteger o sistema contra as mudanças frequentes nos cálculos de impostos que podem variar de acordo com a região, produto e outras características?

Padrão GRASP Utilizado: Protected Variations

O uso da interface EstrategiaImposto permite a troca fácil da estratégia de cálculo de impostos.
