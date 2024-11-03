<h1>API MUTANTES</h1>

<h2>DE QUE TRATA?</h2>
Primeramente se nos planteo la situacion de que teniamos que crear un sistema backend que determinara si una secuencia de ADN es mutante o no.
Para eso se hizo uso de distintas herramientas para solucionar lo propuesto. A continuacion se dan mas detalles.

<h2>COMO FUNCIONA?</h2>
Se sabra si un humano es mutante o no dependiendo de su secuencia de ADN. Esta esta dada pos una secuencia de caracteres (A, C, T, G).
Los datos se reciben como una matriz de 6x6.
Ahora, un humano es mutante si en la matriz se encuentra mas de una secuencia de 4 letras iguales, ya sea horizontal, vertical o diagonal.
Cuando se envia la matriz, se le aplica una funcion que lo que hace es verificar si ese ADN contiene las secuencias mencionadas o no.

<h2>EJEMPLOS</h2>
<h3>MUTANTE</h3>

```json
{
    "dna": [
        "ACGTTT",
        "CAGAAT",
        "CGAATG",
        "CACAGC",
        "CCGTGG",
        "GTTATA"
    ]
}
```

Secuencias: 
- 4 A en diagonal
- 4 C en vertical

<h3>NO MUTANTE</h3>

```json
{
    "dna": [
        "ATTATC",
        "CGATGA",
        "GTACTA",
        "CGTACG",
        "GATCGG",
        "GCTTTA"
    ]
}
```

Secuencias: 
- Ninguna

<h2>DEPLOY</h2>
Este proyecto fue deployado en Render:


<h3>ENDPOINTS</h3>

- *POST*

```json
{
    "dna": [
        "ATGTAG",
        "GCTTTT",
        "AGTCTA",
        "CCACGA",
        "AACGCA",
        "ACTCCT"
    ]
}
```
- *GET*

```json
{
    "count_mutant_dna": 4,
    "count_human_dna": 51,
    "ratio": 0.0784313725
}
```

<h2>HERAMIENTAS</h2>
<ul>
    <li>JAVA</li>
    <li>H2</li>
    <li>JMETER</li>
    <li>GRADLE</li>
    <li>SPRING BOOT</li>
</ul>
