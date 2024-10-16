LA PROPOSTA
---------------
-SCHERMATA HOME
A-strategy propone un interfaccia web in grado di visualizzare le proprie carte Pokémon e creare con esse mazzi personalizzati in modo semplice ed intuitivo.
----------------
-SCHERMATA LOGIN
Tramite la piattaforma di registrazione sarà infatti possibile creare un account, dal quale si accederà alla propria area personale, comprensiva delle seguenti funzioni:

- LE MIE CARTE (schermata le mie carte): l'utente avrà visione di tutte le proprie carte, il loro quantitativo, e avrà la possibilità di aggiungerne di nuove dal semplice pulsante +nuova

- I MIEI MAZZI (schermata mazzi): l'utente potrà accedere ai propri mazzi e crearne di nuovi, modificarli o eliminarli.
-----------------------
- RICERCA E FILTRI - Sarà possibile inoltre, sia a login effettuato che non, ricercare in tutto il database di carte una carta specifica grazie ad appositi filtri ideati:
-- ricerca per nome (campo testuale)
-- ricerca per tipo (menù tendina)
-- ricerca per set	(menù tendina)
-- ricerca per generazione (menù tendina)
-- ricerca per rarità	(menù tendina)
I filtri potranno essere utilizzati anche in modo combinato.

- SCHERMATA CARTA - La specifica carta selezionata verrà mostrata comprensiva di foto (ove possibile) e relativi dettagli: se effettuato il login sarà inoltre possibile aggiungere la carta alla propria collezione personale.
------------------------------------------------
Per favorire l'inclusione e l'utilizzo, la proposta è comprensiva della versione del sito sia in lingua italiana che lingua inglese

### API Endpoint Table 


### API Endpoint Table

| Endpoint                   | Method      | Description                           | Parameters                                   |
|----------------------------|-------------|---------------------------------------|----------------------------------------------|
| `/pokemon/search`          | GET         | Fetch all Cards                       | `None`,`name`,`type`,'artist',`set`,`generation`,`rarity`,`supertype` |
| `/pokemon/add`             | POST        | Add new user                          | `username`,`email`,`password`                |
| `/pokemon/delete`          | GET         | remove user with id                   | `id`                                         |
| `/pokemon/collection/`     | GET         | Fetch all Cards of collection         | `id`                                         |
| `/pokemon/collection/add`  | POST        | Add new Card to collection            | `userid`, `cardid`                           |
| '/pokemon/collection/remove'| Post       | remove Card From collection           | `userid`,`cardid`                            |
| `/pokemon/decks/`          | GET         | Fetch Deck by User id                 | `userid`                                     |
| `/pokemon/{userid}/newdeck`| POST        | Add new Deck to user                  | `deckname`, `description`                    |
| `/pokemon/{userid}/{deckid}`| GET        | Fecth User with speci. Deck Id        |`None`                                        |

