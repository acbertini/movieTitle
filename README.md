# movieTitle

Exercício 1 - MovieTitles (teste 1)
Solução proposta: construir a requisição HTTP GET para extrair os resultados em formato JSON. Foi construido um loop while para varrer todas as páginas do JSON, transformando a variável totalPageNumbers no número total de páginas obtidos através da chave "total_pages". Ao entrar em uma página, são extraídos os dados do nó "data" e dentro os valores de "Title", os quais foram armazenados num array. Com o array preenchido foi aplicado o Collections.sort(titles) para obtenção ordenada dos títulos.

Dificuldades: aprender a tratar uma requisição do tipo HTTP GET e manipular um JSON a partir da biblioteca org.json
