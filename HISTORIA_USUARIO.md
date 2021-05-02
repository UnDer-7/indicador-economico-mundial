# Historia 9999 - Listar porcentagem de pessoas em situação de extrema pobreza.


## Descricao
Necessito que seja disponivel as informacoes sobre a quantidade de pessoas em situação de extrema pobreza
pelo mundo.

## Critério de Aceitação

1. Utilizar os dados fornecidos pelo [World Bank](https://www.worldbank.org)
2. Deve ser possivel filtrar por países.
3. A lista deve ser ordenada por ano (decrescente)
4. O front-end não deve se comunicar diretamente com a API do World Bank.
5. Dados a serem exibidos: Data, País e Porcentagem.

## Cenário de teste
### 1
- Dado que o usuario entre na tela de pesquisa de países
- Ao informar o nome do pais ou abreviacao
- entao a busca deve funcionar corretamente.

### 2
- Quando o usuario entrar no sistema.
- Entao a primeira coisa que deve ac  ontercer
- O usuario deve escolher um país para fazer a primeira busca

### 3
- Quando um usuario acionar o botao "Selecionar novo país"
- Entao o sistema depois da selecao deve remover todos
dados antigos e mostrar os dados releciondos.
  
### 4
- Quando o sistema verificar que o World Bank esta
indisponivel, devera mostrar algum tipo de alerta pra
  o usuario.

## Obs
Enderecos da API do World Bank

- Listar os indicies por país: http://api.worldbank.org/v2/country/{CODIGO_DO_PAIS}/indicator/SI.POV.DDAY?format=json

- Obter uma lista de paises: http://api.worldbank.org/v2/country
