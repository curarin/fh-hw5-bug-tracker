# Simple Bug Tracker

Schreibe einen einfachen Bug Tracker. Verwende dabei alles, was wir bisher geübt haben.

---

## Aufgabenstellung

Ein **Bug** ist definiert durch seinen **Titel**, **Status** (`OPEN`, `IN_PROGRESS`, `FIXED`, `CLOSED`) und seine **Priorität** (`LOW`, `MEDIUM`, `HIGH`, `CRITICAL`).  
Initialisiert wird der Bug immer im Status **`OPEN`** und mit einer vom Benutzer angegebenen ID, Priorität und Titel. Es kann davon ausgegangen werden, dass die ID eindeutig ist.

Ein Bug bietet folgende Methoden an:

- **`startProgress()`**:  
  Setzt den Status auf `IN_PROGRESS`. Dies ist nur erlaubt, wenn der aktuelle Status `OPEN` ist.  
  Ist der Status `FIXED` oder `CLOSED`, soll eine **Exception** geworfen werden, die in der Main-Klasse behandelt wird.

- **`markFixed()`**:  
  Setzt den Status auf `FIXED`. Dies ist nur erlaubt, wenn der aktuelle Status `IN_PROGRESS` ist.  
  Bei anderen Zuständen wird eine **Exception** geworfen.

- **`closeBug()`**:  
  Setzt den Status auf `CLOSED`. Dies ist nur erlaubt, wenn der aktuelle Status `FIXED` ist.  
  Ansonsten wird eine **Exception** geworfen.

- **`printDetails()`**:  
  Gibt den Titel, den Status und die Priorität mit einer entsprechenden Meldung aus.

Der **`BugTracker`** hält alle Bugs in einer Liste vor. Über den BugTracker sollen folgende Operationen möglich sein:

- **Hinzufügen eines Bugs** mit Titel und Priorität.
- **Löschen eines Bugs** anhand seines Indexes.
- **Ausgabe aller Bugs** mit ihren Details.
- **Ausgabe aller Bugs mit einem bestimmten Status.**
- **Änderung des Status** eines Bugs anhand seines Indexes (nach den Regeln: `OPEN -> IN_PROGRESS -> FIXED -> CLOSED`).
- **Ausgabe aller Bugs einer bestimmten Priorität.** Zusätzlich gibt es ein **Array** von 10 Bugs mit der Priorität `CRITICAL`. Werden diese 10 Einträge überschritten, soll eine Warnung ausgegeben werden. 

---

## Menü der Main-Klasse

### 1 - Add a new bug
Eingabe von ID, Titel und Priorität. Der Bug wird dem BugTracker hinzugefügt.

### 2 - Start progress on a bug
Listet alle Bugs mit ihren Indexnummern, ID, Status und Priorität auf.  
Der Benutzer gibt die Indexnummer ein, und der Status wird auf `IN_PROGRESS` gesetzt.

### 3 - Mark a bug as fixed
Listet alle Bugs mit ihren Indexnummern,ID, Status und Priorität auf.  
Der Benutzer gibt die Indexnummer ein, und der Status wird auf `FIXED` gesetzt.

### 4 - Close a bug
Listet alle Bugs mit ihren Indexnummern, ID, Status und Priorität auf.  
Der Benutzer gibt die Indexnummer ein, und der Status wird auf `CLOSED` gesetzt.

### 5 - Display all bugs
Gibt alle Bugs mit ihren Details (ID, Titel, Status, Priorität) aus.

### 6 - Delete a bug
Listet alle Bugs mit ihren Indexnummern, ID, Status und Priorität auf.  
Der Benutzer gibt die Indexnummer ein, und der Bug wird aus dem Tracker entfernt.

### 7 - Display bugs by status
Der Benutzer gibt einen Status (`OPEN`, `IN_PROGRESS`, `FIXED`, `CLOSED`) ein, und alle Bugs mit diesem Status werden angezeigt.

### 0 - Exit
Beendet das Programm.

---

## Anmerkungen

- **Fehleingaben abfangen**:  
  Z. B. ungültige Menüauswahl oder Eingabe von negativen Werten.
- **Maximale Anzahl von CRITICAL-Bugs**:  
  Wird die maximale Anzahl von 10 Bugs überschritten, soll eine Meldung ausgegeben werden, der Bug aber trotzdem angelegt werden.

---

## Zusatzpunkte

- **Sortiere Bugs nach Priorität und zeige sie an.** Sortierreihenfolge s.o. (+7 Punkte)
- **Zeige die Anzahl der Bugs in jedem Status an.** (+3 Punkte)
- **Lösche CRITICAL-Bugs auch aus dem Array**, sollte es den Bug mit der zu löschenden ID auch dort geben. (+3 Punkte)