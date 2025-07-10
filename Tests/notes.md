# Test 1/2 - class design

- Pieges blocs static
- Connaissance de Object (methodes final + leur signatures)
- Règles de visibilité
- Inner/outer classes
  - visibilités champs des inner classes
  - this/ pas this ?
- Interfaces et conflits ?
- Pas de new sur un enum
- Pieges appels constructeurs !!!
- Constructeur caché ?

# Test 3 - generics / collections

- Connaissance des méthodes TreeMap, TreeSet, etc.. et leur comportements (exceptions, etc...)
- Pièges masquage de type (Truc)
- <? extends Truc> ne peut rien setter (mais peut être lu)
- Subtilités des méthodes TreeMap, TreeSet, etc.
- Comparator / Comparable
- Arrays.asList !!!
- ASC/DESC !!!   this - other = ASC    other - this = DESC

# Test 4/5

- Connaissance des méthodes de Stream (et différentes impls)
- Connaissance des functional interfaces built-in
- Function Interface = 1 méthode abstract !!!! (+ optionel des default)
- Pièges conversion type
- Attention aux Predicate.negate
- S'entrainer sur les groupingBy
- Connaissance de Optional
- Subtilités de anyMatch, noneMatch, etc.

# Test  6

- pieges multicatch (meres et filles)
- pieges héritage classe mere leve exception, pas la fille, c'est le type de la variable qui compte
- Pas AutoCloseable == pas de try-with statement
- Baisser seulement le niveau d'exception lors d'héritage
- Visibilité variables
- Connaissance des signatures, comportements des close, hiérarchies des exceptions du core de java
- Suppression des exceptions !

# Test 7

- pièges Duration.between !!! t2 converti en t1, t1 et t2 doivent avoir Time
- connaissance des formats, des API
- maitrise passage heure d'été
- Immutable !!!

# Test 8

- connaissance des méthodes et API : exceptions ou non ???
- serializable ??? ObjectOutputStream.writeObject
- static -> pas écrit avec serializable
- passage du monde texte au monde numérique (char to int)




