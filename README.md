
### API TEST  Table 

| Endpoint                                         | Method   | Description                                | Parameters                                   | request body |
|--------------------------------------------------|----------|--------------------------------------------|----------------------------------------------|---------|
| `localhost:8080/cards/`                           | GET      | Fetch all Cards                            | `name`,`type`,`artist`,`set`,`rarity`,<br>`supertype`,`series`,`generation`,`id`,`page` | - |
| `localhost:8080/cards/page`                    | GET        | Fetch  First 100 Cards                           | `page`,                | yes |
| `localhost:8080/users/signin`                    | POST        | Add new user                          | `username`,`email`,`password`                | yes |
| `localhost:8080/users/deleteaccount`              | GET         | remove user with id                   | `id`                                         | yes |
| `localhost:8080/collection/` | GET         | Fetch all Cards of collection         | `userid`                                         | yes
| `localhost:8080/collection/{userid}/add`  | POST        | Add new Card to user collection            |  `cardid`                           | yes
| `localhost:8080/collection/{userid}/remove`| POST       | remove Card From collection           | `cardid`                            | yes
| `localhost:8080/decks/{userid}` | GET         | Fetch Deck by User id                 | `None`                                     | - |
| `localhost:8080/decks/{userid}/newdeck`| POST        | Add new Deck to user                  | `deckname`, `description`                    | yes
| `localhost:8080/decks/{userid}/{deckid}`| GET        | Fecth User with speci. Deck Id        |`None`                                        | - |
| `localhost:8080/decks/{userid}/{deckid}/validate`| GET | validation of decks                 | `None`                                       | - |
| `localhost:8080/decks/{userid}/{deckid}/add`| POST | Add new Card to Deck                 | `cardid`                                        | yes |
| `localhost:8080/decks/{userid}/{deckid}/remove`| POST | remove Card from Deck                 | `cardid`                                        | yes |
| `localhost:8080/decks/{userid}/{deckid}/deletedeck`| GET | remove Deck for user                  | `deckid`                                        | yes |
