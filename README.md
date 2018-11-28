# Dados importantes

Recomendacao: https://6h3yzrpuwj.execute-api.sa-east-1.amazonaws.com/v1/recommend?city=
Maps API Key `AIzaSyDdXLUyZosLC8fQftguJ-F953J_ANTQQ5A`


## Contratos da API

`/spotify/coordinates/:lat/:lon`
Realiza a indicação de musicas pelo clima da codernada

Parametros:
- :lat - latitude
- :lon - longitude

Retorna:
- Array com as tracks


`/spotify/city/:city`
Realiza a indicação de musicas pelo clima da cidade

Parametros:
- :city - nome da cidade

Retorna:
- Array com as tracks
